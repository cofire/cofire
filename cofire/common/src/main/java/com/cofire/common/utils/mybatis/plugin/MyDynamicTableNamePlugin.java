/**
 * File : MyDynamicTableNamePlugin.java <br/>
 * Author : alexgaoyh <br/>
 * Version : 1.1 <br/>
 * Date : 2017年1月12日 <br/>
 * Modify : <br/>
 * Package Name : com.zhongpin.zp.common.mybatis.plugin <br/>
 * Project Name : zp-common <br/>
 * Description : <br/>
 * 
 */

package com.cofire.common.utils.mybatis.plugin;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

/**
 * ClassName : MyDynamicTableNamePlugin <br/>
 * Function : 动态表名的问题，生成可操作表名的方法. <br/>
 * Reason : 动态表名的问题，生成可操作表名的方法. <br/>
 * Date : 2017年1月12日 上午9:32:03 <br/>
 * 
 * @author : alexgaoyh <br/>
 * @version : 1.1 <br/>
 * @since : JDK 1.6 <br/>
 * @see
 */

public class MyDynamicTableNamePlugin extends PluginAdapter {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean clientInsertMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        // 多个主键的话，忽略此生成器
        if (introspectedTable.getPrimaryKeyColumns() != null && introspectedTable.getPrimaryKeyColumns().size() == 1) {
            // 执行具体业务
            interfaze.addMethod(generateSelectByPrimaryKeyAndTableName(method, introspectedTable));
            interfaze.addMethod(generateDeleteByPrimaryKeyAndTableName(method, introspectedTable));
            interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param;"));
        }

        return true;
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        // 多个主键的话，忽略此生成器
        if (introspectedTable.getPrimaryKeyColumns() != null && introspectedTable.getPrimaryKeyColumns().size() == 1) {
            // 执行具体业务
            XmlElement parentElement = document.getRootElement();

            // 形如 表名+别名 ： sys_sysman_resource sys_sysman_resource
            String tableWithAliasName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();// 数据库表名

            // 形如 表名 ： sys_sysman_resource
            String tableName = introspectedTable.getFullyQualifiedTableNameAtRuntime();

            // 设定的表 别名 问题
            String aliasName = tableWithAliasName.replaceFirst(tableName, "");

            // 产生 selectByPrimaryKeyAndTableName 方法
            XmlElement selectByPrimaryKeyAndTableNameElement = new XmlElement("select");
            selectByPrimaryKeyAndTableNameElement.addAttribute(new Attribute("id", "selectByPrimaryKeyAndTableName"));
            selectByPrimaryKeyAndTableNameElement.addAttribute(new Attribute("parameterType", "String"));
            selectByPrimaryKeyAndTableNameElement.addAttribute(new Attribute("resultMap", "BaseResultMap"));

            selectByPrimaryKeyAndTableNameElement.addElement(new TextElement("select <include refid=\"Base_Column_List\" /> from ${dynamicTableName} "
                    + aliasName + " where " + MyBatis3FormattingUtilities.getAliasedEscapedColumnName(introspectedTable.getPrimaryKeyColumns().get(0))
                    + " = #{id, jdbcType=VARCHAR}"));

            // 产生 deleteByPrimaryKeyAndTableName 方法
            XmlElement deleteByPrimaryKeyAndTableNameElement = new XmlElement("delete");
            deleteByPrimaryKeyAndTableNameElement.addAttribute(new Attribute("id", "deleteByPrimaryKeyAndTableName"));
            deleteByPrimaryKeyAndTableNameElement.addAttribute(new Attribute("parameterType", "String"));

            deleteByPrimaryKeyAndTableNameElement.addElement(new TextElement("delete from ${dynamicTableName} where "
                    + introspectedTable.getPrimaryKeyColumns().get(0).getActualColumnName().toString() + " = #{id, jdbcType=VARCHAR}"));

            parentElement.addElement(selectByPrimaryKeyAndTableNameElement);
            parentElement.addElement(deleteByPrimaryKeyAndTableNameElement);
        }

        return true;
    }

    private Method generateSelectByPrimaryKeyAndTableName(Method method, IntrospectedTable introspectedTable) {

        Method m = new Method("selectByPrimaryKeyAndTableName");

        m.setVisibility(method.getVisibility());

        m.setReturnType(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));

        m.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "id", "@Param(\"id\")"));
        m.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "dynamicTableName", "@Param(\"dynamicTableName\")"));

        context.getCommentGenerator().addGeneralMethodComment(m, introspectedTable);
        return m;
    }

    private Method generateDeleteByPrimaryKeyAndTableName(Method method, IntrospectedTable introspectedTable) {

        Method m = new Method("deleteByPrimaryKeyAndTableName");

        m.setVisibility(method.getVisibility());

        m.setReturnType(FullyQualifiedJavaType.getIntInstance());

        m.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "id", "@Param(\"id\")"));
        m.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "dynamicTableName", "@Param(\"dynamicTableName\")"));

        context.getCommentGenerator().addGeneralMethodComment(m, introspectedTable);
        return m;
    }

}
