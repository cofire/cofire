package com.cofire.common.utils.mybatis.plugin;

import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

/**
 * mybatis generator sqlMapBaseColumnListElementGenerated Base_Column_List 列权限控制部分
 * 
 * 会忽略掉默认的 sqlMapBaseColumnListElementGenerated 方法的执行，则会忽略掉默认的 Base_Column_List SQL语句的生成，改为自定义的SQL 语句的生成
 * 为了考虑数据权限的列权限部分的功能，则需要在查询出来的所有列的部分添加权限过滤功能，如下所示，生成的 <sql id="Base_Column_List"> 部分，即增加了 myColumn_ 开头的权限控制部分的功能；
 * 
 * <sql id="Base_Column_List"> student.ID as student_ID, <if test="myColumn_name == null or myColumn_name == ''">
 * student.NAME as student_NAME, </if> student.CREATE_TIME as student_CREATE_TIME, student.MODIFY_TIME as
 * student_MODIFY_TIME </sql>
 * 
 * @author alexgaoyh
 *
 */
public class AddColumnCheckToBaseColumnListPlugin extends PluginAdapter {
    public boolean validate(List<String> arg0) {
        return true;
    }

    @Override
    public boolean sqlMapBaseColumnListElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {

        XmlElement parentElement = document.getRootElement();

        // 产生 Base_Column_List sql 语句
        XmlElement baseQueryMapConditionElement = new XmlElement("sql");
        baseQueryMapConditionElement.addAttribute(new Attribute("id", "Base_Column_List"));

        XmlElement trimElement = new XmlElement("trim");
        trimElement.addAttribute(new Attribute("suffixOverrides", ","));
        for (IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()) {
            StringBuffer strIf = new StringBuffer();
            XmlElement valuesNotNullElement = new XmlElement("if"); //$NON-NLS-1$
            strIf.setLength(0);
            strIf.append("myColumn_" + introspectedColumn.getJavaProperty());
            strIf.append(" == null"); //$NON-NLS-1$
            strIf.append(" or "); //$NON-NLS-1$
            strIf.append("myColumn_" + introspectedColumn.getJavaProperty());
            strIf.append(" == ''"); //$NON-NLS-1$

            valuesNotNullElement.addAttribute(new Attribute("test", strIf.toString())); //$NON-NLS-1$

            strIf.setLength(0);
            strIf.append(MyBatis3FormattingUtilities.getAliasedEscapedColumnName(introspectedColumn));
            strIf.append(" as "); //$NON-NLS-1$
            strIf.append(introspectedColumn.getTableAlias() + "_" + introspectedColumn.getActualColumnName() + " ,");
            valuesNotNullElement.addElement(new TextElement(strIf.toString()));

            trimElement.addElement(valuesNotNullElement);

        }
        baseQueryMapConditionElement.addElement(trimElement);

        parentElement.addElement(baseQueryMapConditionElement);

        return true;
    }
}