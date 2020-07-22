package io.github.gcdd1993.mybatis.plugins.auditing.samples.mappers;

import io.github.gcdd1993.mybatis.plugins.auditing.samples.po.SampleUserPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SampleUserPo record);

    SampleUserPo selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(SampleUserPo record);
}