package com.cofire.dao.mapper.system;

import com.cofire.dao.model.system.RoleResource;
import com.cofire.dao.model.system.RoleResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleResourceMapper {
    long countByExample(RoleResourceExample example);

    int deleteByExample(RoleResourceExample example);

    int deleteByPrimaryKey(@Param("roleId") String roleId, @Param("resourceId") String resourceId);

    int insert(RoleResource record);

    int insertSelective(RoleResource record);

    List<RoleResource> selectByExample(RoleResourceExample example);

    RoleResource selectByPrimaryKey(@Param("roleId") String roleId, @Param("resourceId") String resourceId);

    int updateByExampleSelective(@Param("record") RoleResource record, @Param("example") RoleResourceExample example);

    int updateByExample(@Param("record") RoleResource record, @Param("example") RoleResourceExample example);

    int updateByPrimaryKeySelective(RoleResource record);

    int updateByPrimaryKey(RoleResource record);

    List<RoleResource> selectPageByExample(RoleResourceExample example);
}