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

import java.util.Iterator;

import com.mysql.jdbc.StringUtils;
import org.mybatis.generator.GeneratorCondition;
import org.mybatis.generator.GeneratorMethod;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.OutputUtilities;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

/**
 * 
 * @author Jeff Butler
 * 
 */
public class UpdateElementGenerator extends
        AbstractXmlElementGenerator {

    private boolean isSimple;

    private String name;
    
    public UpdateElementGenerator(boolean isSimple,String name) {
        super();
        this.isSimple = isSimple;
        this.name = name;
    }
    public UpdateElementGenerator(boolean isSimple) {
        super();
        this.isSimple = isSimple;
    }
    @Override
    public void addElements(XmlElement parentElement) {
        XmlElement answer = new XmlElement("update"); //$NON-NLS-1$

        if(StringUtils.isNullOrEmpty(name)){
            name = GeneratorMethod.updateByPrimaryKey.getValue();
        }
        answer.addAttribute(new Attribute(
                "id",name )); //$NON-NLS-1$
        answer.addAttribute(new Attribute("parameterType", //$NON-NLS-1$
                introspectedTable.getBaseRecordType()));

        context.getCommentGenerator().addComment(answer);

        StringBuilder sb = new StringBuilder();
        sb.append("update "); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        answer.addElement(new TextElement(sb.toString()));

        // set up for first column
        sb.setLength(0);
        XmlElement includeElement = new XmlElement("include");
        includeElement.addAttribute(new Attribute("refid", GeneratorCondition.equalSet.getValue()));
        answer.addElement(includeElement);


        boolean and = false;
        for (IntrospectedColumn introspectedColumn : introspectedTable.getPrimaryKeyColumns()) {
            sb.setLength(0);
            if (and) {
                sb.append("  and "); //$NON-NLS-1$
            } else {
                sb.append("where "); //$NON-NLS-1$
                and = true;
            }

            sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
            sb.append(" = "); //$NON-NLS-1$
            sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
            answer.addElement(new TextElement(sb.toString()));
        }

        if (context.getPlugins()
                .sqlMapUpdateByPrimaryKeyWithBLOBsElementGenerated(answer,
                        introspectedTable)) {
            parentElement.addElement(answer);
        }
    }
}
