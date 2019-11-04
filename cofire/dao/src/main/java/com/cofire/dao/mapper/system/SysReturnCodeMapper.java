package com.cofire.dao.mapper.system;

import com.cofire.dao.model.system.SysReturnCode;
import com.cofire.dao.model.system.SysReturnCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysReturnCodeMapper {
    long countByExample(SysReturnCodeExample example);

    int deleteByExample(SysReturnCodeExample example);

    int deleteByPrimaryKey(String code);

    int insert(SysReturnCode record);

    int insertSelective(SysReturnCode record);

    List<SysReturnCode> selectByExample(SysReturnCodeExample example);

    SysReturnCode selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") SysReturnCode record, @Param("example") SysReturnCodeExample example);

    int updateByExample(@Param("record") SysReturnCode record, @Param("example") SysReturnCodeExample example);

    int updateByPrimaryKeySelective(SysReturnCode record);

    int updateByPrimaryKey(SysReturnCode record);

    List<SysReturnCode> selectPageByExample(SysReturnCodeExample example);
}