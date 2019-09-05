package com.cofire.dao.mapper.system;

import com.cofire.dao.model.system.LoginAudits;
import com.cofire.dao.model.system.LoginAuditsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginAuditsMapper {
    long countByExample(LoginAuditsExample example);

    int deleteByExample(LoginAuditsExample example);

    int deleteByPrimaryKey(Long sid);

    int insert(LoginAudits record);

    int insertSelective(LoginAudits record);

    List<LoginAudits> selectByExampleWithBLOBs(LoginAuditsExample example);

    List<LoginAudits> selectByExample(LoginAuditsExample example);

    LoginAudits selectByPrimaryKey(Long sid);

    int updateByExampleSelective(@Param("record") LoginAudits record, @Param("example") LoginAuditsExample example);

    int updateByExampleWithBLOBs(@Param("record") LoginAudits record, @Param("example") LoginAuditsExample example);

    int updateByExample(@Param("record") LoginAudits record, @Param("example") LoginAuditsExample example);

    int updateByPrimaryKeySelective(LoginAudits record);

    int updateByPrimaryKeyWithBLOBs(LoginAudits record);

    int updateByPrimaryKey(LoginAudits record);

    List<LoginAudits> selectPageByExample(LoginAuditsExample example);
}