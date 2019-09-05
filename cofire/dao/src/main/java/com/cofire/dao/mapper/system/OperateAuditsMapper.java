package com.cofire.dao.mapper.system;

import com.cofire.dao.model.system.OperateAudits;
import com.cofire.dao.model.system.OperateAuditsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperateAuditsMapper {
    long countByExample(OperateAuditsExample example);

    int deleteByExample(OperateAuditsExample example);

    int deleteByPrimaryKey(Long sid);

    int insert(OperateAudits record);

    int insertSelective(OperateAudits record);

    List<OperateAudits> selectByExample(OperateAuditsExample example);

    OperateAudits selectByPrimaryKey(Long sid);

    int updateByExampleSelective(@Param("record") OperateAudits record, @Param("example") OperateAuditsExample example);

    int updateByExample(@Param("record") OperateAudits record, @Param("example") OperateAuditsExample example);

    int updateByPrimaryKeySelective(OperateAudits record);

    int updateByPrimaryKey(OperateAudits record);

    List<OperateAudits> selectPageByExample(OperateAuditsExample example);
}