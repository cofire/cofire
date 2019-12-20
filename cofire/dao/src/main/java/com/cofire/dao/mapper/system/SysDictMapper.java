package com.cofire.dao.mapper.system;

import com.cofire.dao.model.system.SysDict;
import com.cofire.dao.model.system.SysDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysDictMapper {
    long countByExample(SysDictExample example);

    int deleteByExample(SysDictExample example);

    int deleteByPrimaryKey(@Param("groupId") String groupId, @Param("dictValue") String dictValue);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    List<SysDict> selectByExample(SysDictExample example);

    SysDict selectByPrimaryKey(@Param("groupId") String groupId, @Param("dictValue") String dictValue);

    int updateByExampleSelective(@Param("record") SysDict record, @Param("example") SysDictExample example);

    int updateByExample(@Param("record") SysDict record, @Param("example") SysDictExample example);

    int updateByPrimaryKeySelective(SysDict record);

    int updateByPrimaryKey(SysDict record);
}