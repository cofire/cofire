package com.cofire.dao.mapper.system;

import com.cofire.dao.model.system.SysOperateAudit;
import com.cofire.dao.model.system.SysOperateAuditExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysOperateAuditMapper {
    long countByExample(SysOperateAuditExample example);

    int deleteByExample(SysOperateAuditExample example);

    int deleteByPrimaryKey(Long sid);

    int insert(SysOperateAudit record);

    int insertSelective(SysOperateAudit record);

    List<SysOperateAudit> selectByExample(SysOperateAuditExample example);

    SysOperateAudit selectByPrimaryKey(Long sid);

    int updateByExampleSelective(@Param("record") SysOperateAudit record, @Param("example") SysOperateAuditExample example);

    int updateByExample(@Param("record") SysOperateAudit record, @Param("example") SysOperateAuditExample example);

    int updateByPrimaryKeySelective(SysOperateAudit record);

    int updateByPrimaryKey(SysOperateAudit record);
}
