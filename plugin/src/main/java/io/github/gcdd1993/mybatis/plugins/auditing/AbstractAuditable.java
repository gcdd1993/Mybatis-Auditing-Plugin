package io.github.gcdd1993.mybatis.plugins.auditing;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Gcdd1993
 */
@Getter
@Setter
public abstract class AbstractAuditable<U, PK extends Serializable> implements Auditable<U, PK> {
    private static final long serialVersionUID = -6258983661755896330L;

    protected U createdBy;

    protected Timestamp createdDate;

    protected U lastModifiedBy;

    protected Timestamp lastModifiedDate;
}
