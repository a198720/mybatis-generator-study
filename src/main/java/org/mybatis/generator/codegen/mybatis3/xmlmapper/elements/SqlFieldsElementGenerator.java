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

import com.mysql.jdbc.StringUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.GeneratedKey;

import java.util.List;


/**
 * 
 * @author l1
 * 
 */
public class SqlFieldsElementGenerator extends AbstractXmlElementGenerator {

    public SqlFieldsElementGenerator() {
        super();
    }

    @Override
    public void addElements(XmlElement parentElement) {
        XmlElement answer = new XmlElement("sql");
        answer.addAttribute(new Attribute("id","fields"));

        List<IntrospectedColumn> columns = introspectedTable.getAllColumns();
        StringBuffer sb = new StringBuffer();
        for (IntrospectedColumn column: columns) {
            String actualColumnName = column.getActualColumnName();
            sb.append(actualColumnName).append(",");
        }
        String substring = sb.substring(0, sb.length() - 1);
        answer.addElement(new TextElement(substring));

        if (context.getPlugins().sqlMapBlobColumnListElementGenerated(
                answer, introspectedTable)) {
            parentElement.addElement(answer);
        }
    }
}
