package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;



import org.mybatis.generator.GeneratorCondition;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.GeneratorMethod;

/**
 * 
 * @author Jeff Butler
 * 
 */
public class SelectOneElementGenerator extends
        AbstractXmlElementGenerator {

    public SelectOneElementGenerator() {
        super();
    }

    @Override
    public void addElements(XmlElement parentElement) {
        XmlElement answer = new XmlElement("select"); //$NON-NLS-1$

        answer.addAttribute(new Attribute(
                "id", GeneratorMethod.selectOne.getValue())); //$NON-NLS-1$
        answer.addAttribute(new Attribute("resultMap", //$NON-NLS-1$
                introspectedTable.getBaseResultMapId()));

        String parameterType;

        context.getCommentGenerator().addComment(answer);

        StringBuilder sb = new StringBuilder();
        sb.append("select * from "); //$NON-NLS-1$
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
