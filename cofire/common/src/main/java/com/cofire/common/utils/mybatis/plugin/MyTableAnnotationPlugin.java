package com.cofire.common.utils.mybatis.plugin;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.util.StringUtility;

/**
 * 生成实体类时，对整个类增加 Table 的注解部分
 *
 * @author alexgaoyh
 */
public class MyTableAnnotationPlugin extends PluginAdapter {

    /**
     * 生成基础实体类
     *
     * @param topLevelClass
     * @param introspectedTable
     * @return
     */
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        processEntityClass(topLevelClass, introspectedTable);
        return true;
    }

    /**
     * 处理实体类的包和@Table注解
     *
     * @param topLevelClass
     * @param introspectedTable
     */
    private void processEntityClass(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        // 引入JPA注解
        topLevelClass.addImportedType("com.MutiModule.common.mybatis.annotation.*");
        String tableName = introspectedTable.getFullyQualifiedTableNameAtRuntime();
        String tableAliasName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();
        String namespaceStr = introspectedTable.getMyBatis3SqlMapNamespace();
        // 如果包含空格，或者需要分隔符，需要完善
        if (StringUtility.stringContainsSpace(tableName)) {
            tableName = context.getBeginningDelimiter() + tableName + context.getEndingDelimiter();
        }
        topLevelClass.addAnnotation("@MyBatisTableAnnotation(name = \"" + tableName + "\", " + "namespace = \"" + namespaceStr + "\", " + "remarks = \""
                + " 修改点 " + "\", " + "aliasName = \"" + tableAliasName + "\" )");
    }

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }
}
