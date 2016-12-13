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

import org.mybatis.generator.GeneratorCondition;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;


/**
 * 
 * @author Jeff Butler
 * 
 */
public class EqualSetGenerator extends AbstractXmlElementGenerator {

    public EqualSetGenerator() {
        super();
    }

    @Override
    public void addElements(XmlElement parentElement) {
        XmlElement answer = new XmlElement("sql"); //$NON-NLS-1$

        answer.addAttribute(new Attribute("id","set"));

        context.getCommentGenerator().addComment(answer);

        //where 标签
        XmlElement whereElement = new XmlElement("set"); //$NON-NLS-1$

        StringBuilder sb = new StringBuilder();
        for (IntrospectedColumn introspectedColumn : introspectedTable
                .getAllColumns()) {

            //如果是主键,需要continue,
            if(introspectedTable.getPrimaryKeyColumns().contains(introspectedColumn))
            {
                continue;
            }
            XmlElement isNotNullElement = new XmlElement("if");
            isNotNullElement.addAttribute(
                    new Attribute("test", introspectedColumn.getJavaProperty(null)+" != null"));
            String currentColumnName= introspectedColumn.getActualColumnName();

            sb.setLength(0);
            sb.append(MyBatis3FormattingUtilities
                    .getEscapedColumnName(introspectedColumn));
            sb.append('=');
            sb.append(MyBatis3FormattingUtilities
                    .getParameterClause(introspectedColumn));
            sb.append(",");
            isNotNullElement.addElement(new TextElement(sb.toString()));
            whereElement.addElement(isNotNullElement);
        }

        answer.addElement(whereElement);

        if (context.getPlugins().sqlMapBlobColumnListElementGenerated(
                answer, introspectedTable)) {
            parentElement.addElement(answer);
        }
//        if (context.getPlugins().sqlMapBaseColumnListElementGenerated(
//                answer, introspectedTable)) {
//            parentElement.addElement(answer);
//        }
    }
}
