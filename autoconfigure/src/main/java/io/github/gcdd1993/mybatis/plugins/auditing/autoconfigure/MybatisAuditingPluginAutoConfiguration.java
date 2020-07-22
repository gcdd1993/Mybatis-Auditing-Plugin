package io.github.gcdd1993.mybatis.plugins.auditing.autoconfigure;

import io.github.gcdd1993.mybatis.plugins.auditing.Auditable;
import io.github.gcdd1993.mybatis.plugins.auditing.AuditingPlugin;
import io.github.gcdd1993.mybatis.plugins.auditing.AuditorAware;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * @author Gcdd1993
 */
@Slf4j
@RequiredArgsConstructor
@ConditionalOnClass({
        Auditable.class,
        Executor.class
})
@ConditionalOnBean({
        AuditorAware.class
})
@ConditionalOnProperty(prefix = "mybatis.plugin.auditing", name = "enabled", havingValue = "true")
public class MybatisAuditingPluginAutoConfiguration {

    private final AuditorAware<?> auditorAware;

    @ConditionalOnMissingBean
    @Bean
    public MybatisAuditingConfigurationCustomizer auditingPlugin() {
        AuditingPlugin auditingPlugin = new AuditingPlugin(auditorAware);
        log.info("register mybatis auditing plugin success");
        return new MybatisAuditingConfigurationCustomizer(auditingPlugin);
    }

}
