package com.cofire.dao.mapper.system;

import com.cofire.dao.model.system.QtzJob;
import com.cofire.dao.model.system.QtzJobExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QtzJobMapper {
    long countByExample(QtzJobExample example);

    int deleteByExample(QtzJobExample example);

    int deleteByPrimaryKey(String jobId);

    int insert(QtzJob record);

    int insertSelective(QtzJob record);

    List<QtzJob> selectByExample(QtzJobExample example);

    QtzJob selectByPrimaryKey(String jobId);

    int updateByExampleSelective(@Param("record") QtzJob record, @Param("example") QtzJobExample example);

    int updateByExample(@Param("record") QtzJob record, @Param("example") QtzJobExample example);

    int updateByPrimaryKeySelective(QtzJob record);

    int updateByPrimaryKey(QtzJob record);
}