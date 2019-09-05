package com.cofire.dao.mapper.system;

import com.cofire.dao.model.system.JobLog;
import com.cofire.dao.model.system.JobLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JobLogMapper {
    long countByExample(JobLogExample example);

    int deleteByExample(JobLogExample example);

    int deleteByPrimaryKey(Long sid);

    int insert(JobLog record);

    int insertSelective(JobLog record);

    List<JobLog> selectByExample(JobLogExample example);

    JobLog selectByPrimaryKey(Long sid);

    int updateByExampleSelective(@Param("record") JobLog record, @Param("example") JobLogExample example);

    int updateByExample(@Param("record") JobLog record, @Param("example") JobLogExample example);

    int updateByPrimaryKeySelective(JobLog record);

    int updateByPrimaryKey(JobLog record);

    List<JobLog> selectPageByExample(JobLogExample example);
}