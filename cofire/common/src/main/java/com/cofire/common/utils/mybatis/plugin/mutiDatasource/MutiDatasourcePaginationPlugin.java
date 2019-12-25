package com.cofire.common.utils.mybatis.plugin.mutiDatasource;

import java.util.List;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * @author ly
 * @version V1.0
 * @ClassName: MutiDatasourcePaginationPlugin
 * @Description:多数据源分页插件
 * @date 2019年12月4日
 */
public class MutiDatasourcePaginationPlugin extends PluginAdapter {

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        addPage(topLevelClass, introspectedTable, "page");
        addDatabaseId(topLevelClass, introspectedTable, "databaseId");
        return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }

    /**
     * 在接口中添加方法
     */
    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String objectName = introspectedTable.getTableConfiguration().getDomainObjectName();

        interfaze.addImportedType(new FullyQualifiedJavaType("java.util.List"));
        interfaze.addImportedType(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));

        Method method = new Method();
        method = new Method();
        method.setName("selectPageByExample");
        method.addParameter(new Parameter(new FullyQualifiedJavaType(introspectedTable.getExampleType()), "example"));
        method.setReturnType(new FullyQualifiedJavaType("java.util.List<" + objectName + ">"));
        interfaze.addMethod(method);

        return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        XmlElement parentElement = document.getRootElement();

        /** oracle 分页，生成相关 sql 部分语句 begin */
        /** 产生分页语句前半部分 */
        XmlElement oraclePaginationPrefixElement = new XmlElement("sql");
        oraclePaginationPrefixElement.addAttribute(new Attribute("id", "OracleDialectPrefix"));
        XmlElement pageStart = new XmlElement("if");
        pageStart.addAttribute(new Attribute("test", "page != null and databaseId == 'oracle'"));
        pageStart.addElement(new TextElement("select * from ( select row_.*, rownum rownum_ from ( "));
        oraclePaginationPrefixElement.addElement(pageStart);
        parentElement.addElement(oraclePaginationPrefixElement);

        /** 产生分页语句后半部分 */
        XmlElement oraclePaginationSuffixElement = new XmlElement("sql");
        oraclePaginationSuffixElement.addAttribute(new Attribute("id", "OracleDialectSuffix"));
        XmlElement pageEnd = new XmlElement("if");
        pageEnd.addAttribute(new Attribute("test", "page != null and databaseId == 'oracle'"));
        pageEnd.addElement(new TextElement("<![CDATA[ ) row_ ) where rownum_ > #{page.begin} and rownum_ <=#{page.end} ]]>"));
        oraclePaginationSuffixElement.addElement(pageEnd);
        parentElement.addElement(oraclePaginationSuffixElement);
        /** oracle 分页，生成相关 sql 部分语句 end */

        /** mssql 分页，生成相关 sql 部分语句 begin */
        /** 产生分页语句前半部分 */
        XmlElement mssqlPaginationPrefixElement = new XmlElement("sql");
        mssqlPaginationPrefixElement.addAttribute(new Attribute("id", "MssqlDialectPrefix"));
        XmlElement msPageStart = new XmlElement("if");
        msPageStart.addAttribute(new Attribute("test", "page != null and databaseId == 'mssql'"));
        msPageStart.addElement(new TextElement("select * from ( select row_number() over (order by ${orderByClause}) as R, p.* from ( "));
        mssqlPaginationPrefixElement.addElement(msPageStart);
        parentElement.addElement(mssqlPaginationPrefixElement);

        /** 产生分页语句后半部分 */
        XmlElement mssqlPaginationSuffixElement = new XmlElement("sql");
        mssqlPaginationSuffixElement.addAttribute(new Attribute("id", "MssqlDialectSuffix"));
        XmlElement msPageEnd = new XmlElement("if");
        msPageEnd.addAttribute(new Attribute("test", "page != null and databaseId == 'mssql'"));
        msPageEnd.addElement(new TextElement("<![CDATA[ ) p ) p2 where R > #{page.begin} and R <= #{page.end} ]]>"));
        mssqlPaginationSuffixElement.addElement(msPageEnd);
        parentElement.addElement(mssqlPaginationSuffixElement);
        /** mssql 分页，生成相关 sql 部分语句 end */

        XmlElement mysqlPaginationSuffixElement = new XmlElement("sql");
        mysqlPaginationSuffixElement.addAttribute(new Attribute("id", "MysqlDialect"));
        XmlElement oraclePage = new XmlElement("if");
        oraclePage.addAttribute(new Attribute("test", "page != null and databaseId == 'mysql'"));
        oraclePage.addElement(new TextElement("limit #{page.begin} , #{page.length}"));
        mysqlPaginationSuffixElement.addElement(oraclePage);
        parentElement.addElement(mysqlPaginationSuffixElement);

        /** 重写分页方法 */
        XmlElement pageQueryElement = new XmlElement("select");
        pageQueryElement.addAttribute(new Attribute("id", "selectPageByExample"));
        pageQueryElement.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        pageQueryElement.addAttribute(new Attribute("parameterType", introspectedTable.getExampleType()));
        XmlElement oraclePageStart = new XmlElement("include");
        oraclePageStart.addAttribute(new Attribute("refid", "OracleDialectPrefix"));
        pageQueryElement.addElement(oraclePageStart);
        /** mssql头部 */
        XmlElement mssqlPageStart = new XmlElement("include");
        mssqlPageStart.addAttribute(new Attribute("refid", "MssqlDialectPrefix"));
        pageQueryElement.getElements().add(mssqlPageStart);

        pageQueryElement.addElement(new TextElement("select "));

        XmlElement distinctElemen = new XmlElement("if");
        distinctElemen.addAttribute(new Attribute("test", "distinct"));
        distinctElemen.addElement(new TextElement("distinct"));
        pageQueryElement.addElement(distinctElemen);

        pageQueryElement.addElement(new TextElement("'true' as QUERYID, "));

        XmlElement query = new XmlElement("include");
        query.addAttribute(new Attribute("refid", "Base_Column_List"));
        pageQueryElement.addElement(query);
        pageQueryElement.addElement(new TextElement("from " + introspectedTable.getFullyQualifiedTable()));

        XmlElement whereSuffixElemen = new XmlElement("if");
        whereSuffixElemen.addAttribute(new Attribute("test", "_parameter != null"));
        XmlElement example = new XmlElement("include");
        example.addAttribute(new Attribute("refid", "Example_Where_Clause"));
        whereSuffixElemen.addElement(example);
        pageQueryElement.addElement(whereSuffixElemen);

        XmlElement orderSuffixElemen = new XmlElement("if");
        orderSuffixElemen.addAttribute(new Attribute("test", "orderByClause != null and (databaseId == 'mysql' or databaseId == 'oracle') "));
        orderSuffixElemen.addElement(new TextElement("order by ${orderByClause}"));
        pageQueryElement.addElement(orderSuffixElemen);

        XmlElement oraclePageEnd = new XmlElement("include");
        oraclePageEnd.addAttribute(new Attribute("refid", "OracleDialectSuffix"));
        pageQueryElement.addElement(oraclePageEnd);
        /** mssql头部 */
        XmlElement mssqlPageEnd = new XmlElement("include");
        mssqlPageEnd.addAttribute(new Attribute("refid", "MssqlDialectSuffix"));
        pageQueryElement.getElements().add(mssqlPageEnd);
        /** mysql头部 */
        XmlElement mysqlPageEnd = new XmlElement("include");
        mysqlPageEnd.addAttribute(new Attribute("refid", "MysqlDialect"));
        pageQueryElement.getElements().add(mysqlPageEnd);
        parentElement.addElement(pageQueryElement);

        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {

        // ----------------------------------------------------------------------------oracle 分页，生成相关 sql 部分语句 begin
        // XmlElement oraclePageStart = new XmlElement("include"); // Oracle头部
        // oraclePageStart.addAttribute(new Attribute("refid", "OracleDialectPrefix"));
        // element.getElements().add(0, oraclePageStart);
        //
        // XmlElement mssqlPageStart = new XmlElement("include"); // mssql头部
        // mssqlPageStart.addAttribute(new Attribute("refid", "MssqlDialectPrefix"));
        // element.getElements().add(0, mssqlPageStart);
        //
        // XmlElement mssqlPageEnd = new XmlElement("include"); // mssql尾部
        // mssqlPageEnd.addAttribute(new Attribute("refid", "MssqlDialectSuffix"));
        // element.getElements().add(mssqlPageEnd);
        //
        // XmlElement oraclePageEnd = new XmlElement("include"); // Oracle尾部
        // oraclePageEnd.addAttribute(new Attribute("refid", "OracleDialectSuffix"));
        // element.getElements().add(oraclePageEnd);
        // // ----------------------------------------------------------------------------oracle 分页，生成相关 sql 部分语句 end
        //
        // // ----------------------------------------------------------------------------mysql 分页，生成相关 sql 部分语句 begin
        // XmlElement mysqlPage = new XmlElement("include"); //$NON-NLS-1$
        // mysqlPage.addAttribute(new Attribute("refid", "MysqlDialect"));
        // element.getElements().add(mysqlPage);
        // // ----------------------------------------------------------------------------mysql 分页，生成相关 sql 部分语句 end

        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    /**
     * @param topLevelClass
     * @param introspectedTable
     * @param name
     */
    private void addPage(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String name) {
        topLevelClass.addImportedType(new FullyQualifiedJavaType("com.cofire.common.utils.mybatis.page.Page"));
        CommentGenerator commentGenerator = context.getCommentGenerator();
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(new FullyQualifiedJavaType("com.cofire.common.utils.mybatis.page.Page"));
        field.setName(name);
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
        char c = name.charAt(0);
        String camel = Character.toUpperCase(c) + name.substring(1);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("set" + camel);
        method.addParameter(new Parameter(new FullyQualifiedJavaType("com.cofire.common.utils.mybatis.page.Page"), name));
        method.addBodyLine("this." + name + "=" + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("com.cofire.common.utils.mybatis.page.Page"));
        method.setName("get" + camel);
        method.addBodyLine("return " + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
    }

    private void addDatabaseId(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String name) {
        topLevelClass.addImportedType(new FullyQualifiedJavaType("String"));
        CommentGenerator commentGenerator = context.getCommentGenerator();
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(new FullyQualifiedJavaType("String"));
        field.setName(name);
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
        char c = name.charAt(0);
        String camel = Character.toUpperCase(c) + name.substring(1);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("set" + camel);
        method.addParameter(new Parameter(new FullyQualifiedJavaType("String"), name));
        method.addBodyLine("this." + name + "=" + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("String"));
        method.setName("get" + camel);
        method.addBodyLine("return " + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
    }

    /**
     * This plugin is always valid - no properties are required
     */
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }
}
