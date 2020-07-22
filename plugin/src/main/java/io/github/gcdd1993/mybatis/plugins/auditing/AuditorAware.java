package io.github.gcdd1993.mybatis.plugins.auditing;

/**
 * @author Gcdd1993
 */
public interface AuditorAware<T> {

    /**
     * Returns the current auditor of the application.
     *
     * @return the current auditor
     */
    T getCurrentAuditor();
}
