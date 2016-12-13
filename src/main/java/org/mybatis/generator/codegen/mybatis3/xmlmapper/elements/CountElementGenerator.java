package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;

import com.mysql.jdbc.StringUtils;
import org.mybatis.generator.GeneratorCondition;
import org.mybatis.generator.GeneratorMethod;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * 
 * @author Jeff Butler
 * 
 */
public class CountElementGenerator extends
        AbstractXmlElementGenerator {
    private String name ;
    public CountElementGenerator() {
        super();
    }
    public CountElementGenerator(String name ) {
        super();
        this.name = name;
    }
    @Override
    public void addElements(XmlElement parentElement) {
        XmlElement answer = new XmlElement("select"); //$NON-NLS-1$

        if(StringUtils.isNullOrEmpty(name)){
            name = GeneratorMethod.selectList.getValue();
        }
        answer.addAttribute(new Attribute(
                "id",name)); //$NON-NLS-1$
        answer.addAttribute(new Attribute("resultType", //$NON-NLS-1$
                "integer"));

        String parameterType;

        context.getCommentGenerator().addComment(answer);

        StringBuilder sb = new StringBuilder();
        sb.append("select count(1) as nums  from "); //$NON-NLS-1$
        sb.append(introspectedTable
                .getAliasedFullyQualifiedTableNameAtRuntime());
//        sb.append(" <include refid=\"")
//          .append(Generator.equalWhere.getValue())
//          .append("\" />");
        answer.addElement(new TextElement(sb.toString()));

        XmlElement includeElement = new XmlElement("include");
        includeElement.addAttribute(new Attribute("refid", GeneratorCondition.equalWhere.getValue()));
        answer.addElement(includeElement);


        if (context.getPlugins().sqlMapBlobColumnListElementGenerated(
                answer, introspectedTable)) {
            parentElement.addElement(answer);
        }
    }
}
