package com.cofire.dao.mapper.system;

import com.cofire.dao.model.system.Params;
import com.cofire.dao.model.system.ParamsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParamsMapper {
    long countByExample(ParamsExample example);

    int deleteByExample(ParamsExample example);

    int deleteByPrimaryKey(@Param("groupId") String groupId, @Param("paramId") String paramId);

    int insert(Params record);

    int insertSelective(Params record);

    List<Params> selectByExample(ParamsExample example);

    Params selectByPrimaryKey(@Param("groupId") String groupId, @Param("paramId") String paramId);

    int updateByExampleSelective(@Param("record") Params record, @Param("example") ParamsExample example);

    int updateByExample(@Param("record") Params record, @Param("example") ParamsExample example);

    int updateByPrimaryKeySelective(Params record);

    int updateByPrimaryKey(Params record);

    List<Params> selectPageByExample(ParamsExample example);
}