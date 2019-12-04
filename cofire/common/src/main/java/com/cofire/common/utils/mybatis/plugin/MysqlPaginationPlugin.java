package com.cofire.common.utils.mybatis.plugin;

import java.util.List;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.PrimitiveTypeWrapper;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.AbstractJavaGenerator;

/**
 * 
 * @ClassName: MysqlPaginationPlugin
 * @Description:mysql分页插件
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
public class MysqlPaginationPlugin extends PluginAdapter {

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        addLimit(topLevelClass, introspectedTable, "limitStart");
        addLimit(topLevelClass, introspectedTable, "limitSize");
        return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }

    /**
     * 为selectByExample添加limitStart和limitSize
     */
    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        XmlElement isNotNullElement = new XmlElement("if");
        isNotNullElement.addAttribute(new Attribute("test", "limitStart != null and limitSize >= 0"));
        isNotNullElement.addElement(new TextElement("limit #{limitStart} , #{limitSize}"));
        element.addElement(isNotNullElement);
        return super.sqlMapSelectByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    /**
     * 为selectByExampleWithBLOBs添加limitStart和limitSize
     */
    @Override
    public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        XmlElement isNotNullElement = new XmlElement("if");
        isNotNullElement.addAttribute(new Attribute("test", "limitStart != null and limitSize >= 0"));
        isNotNullElement.addElement(new TextElement("limit #{limitStart} , #{limitSize}"));
        element.addElement(isNotNullElement);
        return super.sqlMapSelectByExampleWithBLOBsElementGenerated(element, introspectedTable);
    }

    private void addLimit(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String name) {

        CommentGenerator commentGenerator = context.getCommentGenerator();

        /**
         * 创建类成员变量 如protected Integer limitStart;
         */
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(PrimitiveTypeWrapper.getIntegerInstance());
        field.setName(name);
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
        /**
         * 首字母大写
         */
        char c = name.charAt(0);
        String camel = Character.toUpperCase(c) + name.substring(1);

        /**
         * 添加Setter方法
         */
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("set" + camel);
        method.addParameter(new Parameter(PrimitiveTypeWrapper.getIntegerInstance(), name));

        StringBuilder sb = new StringBuilder();
        sb.append("this.");
        sb.append(name);
        sb.append(" = ");
        sb.append(name);
        sb.append(";");
        /**
         * 如 this.limitStart = limitStart;
         */
        method.addBodyLine(sb.toString());

        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        /**
         * 添加Getter Method 直接调用AbstractJavaGenerator的getGetter方法
         */
        Method getterMethod = AbstractJavaGenerator.getGetter(field);
        commentGenerator.addGeneralMethodComment(getterMethod, introspectedTable);
        topLevelClass.addMethod(getterMethod);
    }

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

}