package io.github.gcdd1993.mybatis.plugins.auditing.autoconfigure;

import io.github.gcdd1993.mybatis.plugins.auditing.AuditingPlugin;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;

/**
 * @author Gcdd1993
 */
@RequiredArgsConstructor
public class MybatisAuditingConfigurationCustomizer implements ConfigurationCustomizer {

    private final AuditingPlugin auditingPlugin;

    @Override
    public void customize(Configuration configuration) {
        configuration.addInterceptor(auditingPlugin);
    }
}
