package com.cofire.dao.mapper.system;

import com.cofire.dao.model.system.SysRoleResource;
import com.cofire.dao.model.system.SysRoleResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleResourceMapper {
    long countByExample(SysRoleResourceExample example);

    int deleteByExample(SysRoleResourceExample example);

    int deleteByPrimaryKey(@Param("roleId") String roleId, @Param("resourceId") String resourceId);

    int insert(SysRoleResource record);

    int insertSelective(SysRoleResource record);

    List<SysRoleResource> selectByExample(SysRoleResourceExample example);

    SysRoleResource selectByPrimaryKey(@Param("roleId") String roleId, @Param("resourceId") String resourceId);

    int updateByExampleSelective(@Param("record") SysRoleResource record, @Param("example") SysRoleResourceExample example);

    int updateByExample(@Param("record") SysRoleResource record, @Param("example") SysRoleResourceExample example);

    int updateByPrimaryKeySelective(SysRoleResource record);

    int updateByPrimaryKey(SysRoleResource record);
}