package io.github.gcdd1993.mybatis.plugins.auditing;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Gcdd1993
 */
public interface Auditable<U, ID extends Serializable> {

    String FIELD_CREATE_BY = "createdBy";
    String FIELD_CREATE_DATE = "createdDate";
    String FIELD_LAST_MODIFIED_BY = "lastModifiedBy";
    String FIELD_LAST_MODIFIED_DATE = "lastModifiedDate";

    /**
     * Returns the user who created this entity.
     *
     * @return the createdBy
     */
    U getCreatedBy();

    /**
     * Sets the user who created this entity.
     *
     * @param createdBy the creating entity to set
     */
    void setCreatedBy(final U createdBy);

    /**
     * Returns the creation date of the entity.
     *
     * @return the createdDate
     */
    Timestamp getCreatedDate();

    /**
     * Sets the creation date of the entity.
     *
     * @param creationDate the creation date to set
     */
    void setCreatedDate(final Timestamp creationDate);

    /**
     * Returns the user who modified the entity lastly.
     *
     * @return the lastModifiedBy
     */
    U getLastModifiedBy();

    /**
     * Sets the user who modified the entity lastly.
     *
     * @param lastModifiedBy the last modifying entity to set
     */
    void setLastModifiedBy(final U lastModifiedBy);

    /**
     * Returns the date of the last modification.
     *
     * @return the lastModifiedDate
     */
    Timestamp getLastModifiedDate();

    /**
     * Sets the date of the last modification.
     *
     * @param lastModifiedDate the date of the last modification to set
     */
    void setLastModifiedDate(final Timestamp lastModifiedDate);
}
