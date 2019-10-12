package com.cofire.dao.mapper.system;

import com.cofire.dao.model.system.SysLoginAudit;
import com.cofire.dao.model.system.SysLoginAuditExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLoginAuditMapper {
    long countByExample(SysLoginAuditExample example);

    int deleteByExample(SysLoginAuditExample example);

    int deleteByPrimaryKey(Long sid);

    int insert(SysLoginAudit record);

    int insertSelective(SysLoginAudit record);

    List<SysLoginAudit> selectByExampleWithBLOBs(SysLoginAuditExample example);

    List<SysLoginAudit> selectByExample(SysLoginAuditExample example);

    SysLoginAudit selectByPrimaryKey(Long sid);

    int updateByExampleSelective(@Param("record") SysLoginAudit record, @Param("example") SysLoginAuditExample example);

    int updateByExampleWithBLOBs(@Param("record") SysLoginAudit record, @Param("example") SysLoginAuditExample example);

    int updateByExample(@Param("record") SysLoginAudit record, @Param("example") SysLoginAuditExample example);

    int updateByPrimaryKeySelective(SysLoginAudit record);

    int updateByPrimaryKeyWithBLOBs(SysLoginAudit record);

    int updateByPrimaryKey(SysLoginAudit record);

    List<SysLoginAudit> selectPageByExample(SysLoginAuditExample example);
}