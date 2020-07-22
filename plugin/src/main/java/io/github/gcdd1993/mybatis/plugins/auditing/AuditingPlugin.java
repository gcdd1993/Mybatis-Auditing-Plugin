package io.github.gcdd1993.mybatis.plugins.auditing;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Gcdd1993
 */
@Slf4j
@RequiredArgsConstructor
@Intercepts({
        @Signature(
                type = Executor.class,
                method = "update",
                args = {MappedStatement.class, Object.class}
        )
})
public class AuditingPlugin implements Interceptor {

    private final AuditorAware<?> auditorAware;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        try {
            MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
            SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
            boolean isInsertOperation = sqlCommandType.equals(SqlCommandType.INSERT);
            Object[] args = invocation.getArgs();
            // PreparedStatement
            Object parameter = args[1];
            Class<?> paramClass = parameter.getClass();
            if (Auditable.class.isAssignableFrom(paramClass)) {
                Field[] fields = getAllFields(paramClass);
                // set auditing column
                Timestamp nowTime = Timestamp.from(Instant.now());
                for (Field field : fields) {
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    if (isInsertOperation) {
                        if (Auditable.FIELD_CREATE_BY.equalsIgnoreCase(fieldName)) {
                            field.set(parameter, auditorAware.getCurrentAuditor());
                        }
                        if (Auditable.FIELD_CREATE_DATE.equalsIgnoreCase(fieldName)) {
                            field.set(parameter, nowTime);
                        }
                    } else {
                        if (Auditable.FIELD_LAST_MODIFIED_BY.equalsIgnoreCase(fieldName)) {
                            field.set(parameter, auditorAware.getCurrentAuditor());
                        }
                        if (Auditable.FIELD_LAST_MODIFIED_DATE.equalsIgnoreCase(fieldName)) {
                            field.set(parameter, nowTime);
                        }
                    }
                }
            } else {
                log.debug("class {} is not implements Auditable, ignore mybatis auditing", paramClass.getName());
            }
        } catch (SecurityException ex) {
            log.warn("mybatis auditing plugin execute error", ex);
        }
        return invocation.proceed();
    }

    private Field[] getAllFields(Class<?> clazz) {
        List<Field> fieldList = new ArrayList<Field>();
        Class<?> currentClass = clazz;
        while (currentClass != null) {
            fieldList.addAll(Arrays.asList(currentClass.getDeclaredFields()));
            currentClass = currentClass.getSuperclass();
        }
        return fieldList.toArray(new Field[0]);
    }
}
