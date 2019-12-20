package com.cofire.dao.mapper.system;

import com.cofire.dao.model.system.QtzJobLog;
import com.cofire.dao.model.system.QtzJobLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QtzJobLogMapper {
    long countByExample(QtzJobLogExample example);

    int deleteByExample(QtzJobLogExample example);

    int deleteByPrimaryKey(Long sid);

    int insert(QtzJobLog record);

    int insertSelective(QtzJobLog record);

    List<QtzJobLog> selectByExample(QtzJobLogExample example);

    QtzJobLog selectByPrimaryKey(Long sid);

    int updateByExampleSelective(@Param("record") QtzJobLog record, @Param("example") QtzJobLogExample example);

    int updateByExample(@Param("record") QtzJobLog record, @Param("example") QtzJobLogExample example);

    int updateByPrimaryKeySelective(QtzJobLog record);

    int updateByPrimaryKey(QtzJobLog record);
}