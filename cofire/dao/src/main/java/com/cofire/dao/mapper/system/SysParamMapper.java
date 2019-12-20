package com.cofire.dao.mapper.system;

import com.cofire.dao.model.system.SysParam;
import com.cofire.dao.model.system.SysParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysParamMapper {
    long countByExample(SysParamExample example);

    int deleteByExample(SysParamExample example);

    int deleteByPrimaryKey(@Param("groupId") String groupId, @Param("paramId") String paramId);

    int insert(SysParam record);

    int insertSelective(SysParam record);

    List<SysParam> selectByExample(SysParamExample example);

    SysParam selectByPrimaryKey(@Param("groupId") String groupId, @Param("paramId") String paramId);

    int updateByExampleSelective(@Param("record") SysParam record, @Param("example") SysParamExample example);

    int updateByExample(@Param("record") SysParam record, @Param("example") SysParamExample example);

    int updateByPrimaryKeySelective(SysParam record);

    int updateByPrimaryKey(SysParam record);
}