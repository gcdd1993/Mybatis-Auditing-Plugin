package io.github.gcdd1993.mybatis.plugins.auditing.samples.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author Gcdd1993
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleUserBo {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private Integer createdBy;
    private Timestamp createdDate;
    private Integer lastModifiedBy;
    private Timestamp lastModifiedDate;
}
