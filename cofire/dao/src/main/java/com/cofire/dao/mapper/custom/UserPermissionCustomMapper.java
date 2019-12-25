package com.cofire.dao.mapper.custom;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPermissionCustomMapper {

    /**
     * @param example
     * @return List<UserPermissionCustom> 返回类型
     * @Title: selectByExample
     * @Description: 查询用户的权限
     */
    Set<String> getUserPermission(@Param("user_id") String p_userId);

    List<Map<String, String>> getUserResource(@Param("user_id") String userId);

}
