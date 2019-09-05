package com.cofire.dao.mapper.system;

import com.cofire.dao.model.system.Dict;
import com.cofire.dao.model.system.DictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictMapper {
    long countByExample(DictExample example);

    int deleteByExample(DictExample example);

    int deleteByPrimaryKey(@Param("groupId") String groupId, @Param("dictValue") String dictValue);

    int insert(Dict record);

    int insertSelective(Dict record);

    List<Dict> selectByExample(DictExample example);

    Dict selectByPrimaryKey(@Param("groupId") String groupId, @Param("dictValue") String dictValue);

    int updateByExampleSelective(@Param("record") Dict record, @Param("example") DictExample example);

    int updateByExample(@Param("record") Dict record, @Param("example") DictExample example);

    int updateByPrimaryKeySelective(Dict record);

    int updateByPrimaryKey(Dict record);

    List<Dict> selectPageByExample(DictExample example);
}