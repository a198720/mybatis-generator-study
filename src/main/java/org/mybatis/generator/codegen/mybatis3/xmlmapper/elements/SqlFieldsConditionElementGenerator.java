/**
 *    Copyright 2006-2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;


/**
 * 
 * @author l1
 * 
 */
public class SqlFieldsConditionElementGenerator extends AbstractXmlElementGenerator {

    public SqlFieldsConditionElementGenerator() {
        super();
    }

    @Override
    public void addElements(XmlElement parentElement) {
        XmlElement answer = new XmlElement("sql");
        answer.addAttribute(new Attribute("id","fieldsCondition"));

        List<IntrospectedColumn> columns = introspectedTable.getAllColumns();
        XmlElement trimElement = new XmlElement("trim");
        trimElement.addAttribute(new Attribute("prefix",""));
        trimElement.addAttribute(new Attribute("prefixOverrides",","));

        for (IntrospectedColumn column: columns) {
            String actualColumnName = column.getActualColumnName();

            XmlElement isNotNullElement = new XmlElement("if");
            isNotNullElement.addAttribute(
                    new Attribute("test", column.getJavaProperty(null)+" != null"));
            isNotNullElement.addElement(new TextElement(actualColumnName+","));

            trimElement.addElement(isNotNullElement);

        }
        answer.addElement(trimElement);

        if (context.getPlugins().sqlMapBlobColumnListElementGenerated(
                answer, introspectedTable)) {
            parentElement.addElement(answer);
        }
    }
}
