package io.github.gcdd1993.mybatis.plugins.auditing.samples.mappers;

import io.github.gcdd1993.mybatis.plugins.auditing.samples.po.SampleUserPo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Gcdd1993
 */
@SpringBootTest
class SampleUserMapperTest {

    @Autowired
    private SampleUserMapper sampleUserMapper;

    @Test
    void insert() {
        int userId = 2;
        SampleUserPo userPo = SampleUserPo.builder()
                .id(userId)
                .username("user01")
                .password("111111")
                .age(1)
                .build();
        sampleUserMapper.insert(userPo);
        SampleUserPo sampleUserPo = sampleUserMapper.selectByPrimaryKey(userId);
        Assertions.assertNotNull(sampleUserPo.getCreatedBy());
        Assertions.assertNotNull(sampleUserPo.getCreatedDate());
        Assertions.assertNull(sampleUserPo.getLastModifiedBy());
        Assertions.assertNull(sampleUserPo.getLastModifiedDate());
    }

    @Test
    void updateByPrimaryKey() {
        int userId = 1;
        SampleUserPo userPo = SampleUserPo.builder()
                .id(userId)
                .username("user_update_test")
                .password("111111")
                .age(1)
                .build();
        sampleUserMapper.updateByPrimaryKey(userPo);
        SampleUserPo sampleUserPo = sampleUserMapper.selectByPrimaryKey(userId);
        Assertions.assertNotNull(sampleUserPo.getLastModifiedBy());
        Assertions.assertNotNull(sampleUserPo.getLastModifiedDate());
    }
}