package com.cofire.dao.mapper.system.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.cofire.dao.mapper.system.SysRoleMapper;
import com.cofire.dao.model.system.SysRoleResource;

@Repository
public interface SysRoleMapperImpl extends SysRoleMapper {

    List<SysRoleResource> getRoleLeafResource(@Param("roleId") String roleId);
}
