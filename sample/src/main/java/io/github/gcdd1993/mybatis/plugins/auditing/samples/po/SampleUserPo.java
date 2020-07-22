package io.github.gcdd1993.mybatis.plugins.auditing.samples.po;

import io.github.gcdd1993.mybatis.plugins.auditing.AbstractAuditable;
import lombok.*;

/**
 * @author Gcdd1993
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleUserPo extends AbstractAuditable<Integer, Integer> {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
}
