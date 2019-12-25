/**
 * File : MyInsertUpdateDynamicTableNamePlugin.java <br/>
 * Author : alexgaoyh <br/>
 * Version : 1.1 <br/>
 * Date : 2017年1月13日 <br/>
 * Modify : <br/>
 * Package Name : com.zhongpin.zp.common.mybatis.plugin <br/>
 * Project Name : zp-common <br/>
 * Description : <br/>
 */

package com.cofire.common.utils.mybatis.plugin;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * ClassName : MyInsertUpdateDynamicTableNamePlugin <br/>
 * Function : insert 与 update 方法的sql方法的动态表结构处理. <br/>
 * Reason : insert 与 update 方法的sql方法的动态表结构处理. <br/>
 * Date : 2017年1月13日 下午1:21:40 <br/>
 *
 * @author : alexgaoyh <br/>
 * @version : 1.1 <br/>
 * @since : JDK 1.6 <br/>
 * @see
 */

public class MyInsertUpdateDynamicTableNamePlugin extends PluginAdapter {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        resetInsertXmlElementTableName(element);
        return super.sqlMapInsertElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        resetInsertXmlElementTableName(element);
        return super.sqlMapInsertSelectiveElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapUpdateByPrimaryKeySelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        resetUpdateXmlElementTableNameNotMapType(element);
        return super.sqlMapUpdateByPrimaryKeySelectiveElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapUpdateByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        resetUpdateXmlElementTableName(element);
        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        resetUpdateXmlElementTableNameNotMapType(element);
        return super.sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    private void resetInsertXmlElementTableName(XmlElement element) {
        List<Element> elements = element.getElements();
        String content = elements.get(0).getFormattedContent(0);
        String[] data = content.split(" ");
        data[2] = "${dynamicTableName}";
        TextElement subSentence = new TextElement(MyInsertUpdateDynamicTableNamePlugin.join(" ", data));
        elements.set(0, subSentence);
    }

    private void resetUpdateXmlElementTableName(XmlElement element) {
        List<Element> elements = element.getElements();
        TextElement subSentence = new TextElement("update ${dynamicTableName}");
        elements.set(0, subSentence);
    }

    private void resetUpdateXmlElementTableNameNotMapType(XmlElement element) {
        List<Element> elements = element.getElements();
        TextElement subSentence = new TextElement("update ${dynamicTableName}");
        elements.set(0, subSentence);
    }

    public static String join(String join, String[] strAry) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strAry.length; i++) {
            if (i == (strAry.length - 1)) {
                sb.append(strAry[i]);
            } else {
                sb.append(strAry[i]).append(join);
            }
        }
        return new String(sb);
    }
}
