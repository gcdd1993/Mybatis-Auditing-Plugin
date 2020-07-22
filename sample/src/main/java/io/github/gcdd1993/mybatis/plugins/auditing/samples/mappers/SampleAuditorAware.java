package io.github.gcdd1993.mybatis.plugins.auditing.samples.mappers;

import io.github.gcdd1993.mybatis.plugins.auditing.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * @author Gcdd1993
 */
@Component
public class SampleAuditorAware implements AuditorAware<Integer> {

    @Override
    public Integer getCurrentAuditor() {
        return 111;
    }
}
