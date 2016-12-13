/**
 * Copyright 2006-2016 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mybatis.generator.codegen.mybatis3.xmlmapper;

import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.AbstractXmlGenerator;
import org.mybatis.generator.codegen.XmlConstants;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.*;

import static org.mybatis.generator.internal.util.messages.Messages.getString;

/**
 *
 * @author Jeff Butler
 *
 */
public class SimpleXMLMapperGenerator extends AbstractXmlGenerator {

    public SimpleXMLMapperGenerator() {
        super();
    }

    protected XmlElement getSqlMapElement() {
        FullyQualifiedTable table = introspectedTable.getFullyQualifiedTable();
        progressCallback.startTask(getString("Progress.12", table.toString())); //$NON-NLS-1$
        XmlElement answer = new XmlElement("mapper"); //$NON-NLS-1$
        String namespace = introspectedTable.getMyBatis3SqlMapNamespace();
        answer.addAttribute(new Attribute("namespace", //$NON-NLS-1$
                namespace));

        context.getCommentGenerator().addRootComment(answer);

        addResultMapElement(answer);
        addSqlPkElement(answer);
        addSqlFieldsElement(answer);
        addSqlFieldsPrefixAliaElement(answer);
        addSqlTableElement(answer);
        addSqlTableAliasElement(answer);
        addSqlOrderByElement(answer);
        addConditionPkElement(answer);
        addSqlFieldsConditionElement(answer);
        addSqlValuesConditionElement(answer);
        addEqualWhereElement(answer);
        addEqualSetElement(answer);
        addFindByPKElement(answer);
        addFindOneElement(answer);
        addFindListElement(answer);
        addFindByPageElement(answer);
        addInsertElement(answer);
        addUpdateElement(answer);
        addDeleteByPkElement(answer);
        addDeleteElement(answer);
//        // base insert
//        addInsertElement(answer,"insert");
//        // base delete
//        addDeleteElement(answer,"delete");
//        // base update
//        addUpdateElement(answer,"update");
//        // base deleteBatch
//        addDeleteBatchElement(answer);
//        // base find
//        addSelectList(answer,"find");
//        // base findByPage
//
//        // base count
//        addCountElement(answer,"count");


        //1. 单条记录查询
//        addSelectOne(answer);
        //2. 查询多条记录
//        addSelectList(answer,null);
        //3.更新
//        addUpdateElement(answer,null);
        //删除
//        addDeleteByPrimaryKeyElement(answer);
        //插入
//        addInsertSelectiveElement(answer);

//        addSelectByPrimaryKeyElement(answer);
//        addSelectAllElement(answer);

        return answer;
    }


    private void addResultMapElement(XmlElement parentElement) {
        if (introspectedTable.getRules().generateBaseResultMap()) {
            AbstractXmlElementGenerator elementGenerator = new ResultMapWithoutBLOBsElementGenerator(
                    true);
            initializeAndExecuteGenerator(elementGenerator, parentElement);
        }
    }

    private void addSqlPkElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new SqlPkElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    private void addSqlFieldsElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new SqlFieldsElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    private void addSqlFieldsPrefixAliaElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new SqlFieldsPrefixAliasElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    private void addSqlTableElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new SqlTableElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    private void addSqlTableAliasElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new SqlTableAliasElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }
    private void addSqlOrderByElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new SqlOrderByElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }
    private void addConditionPkElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new ConditionPkElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    private void addSqlFieldsConditionElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new SqlFieldsConditionElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    private void addSqlValuesConditionElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new SqlValuesConditionElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    /**
     * create by l1
     */
    private void addEqualWhereElement(XmlElement parentElement) {
        if (introspectedTable.getRules().generateBaseColumnList()) {
            AbstractXmlElementGenerator elementGenerator = new EqualWhereGenerator();
            initializeAndExecuteGenerator(elementGenerator, parentElement);
        }
    }

    /**
     * create by l1
     */
    private void addEqualSetElement(XmlElement parentElement) {
        if (introspectedTable.getRules().generateBaseColumnList()) {
            AbstractXmlElementGenerator elementGenerator = new EqualSetGenerator();
            initializeAndExecuteGenerator(elementGenerator, parentElement);
        }
    }

    /**
     * create by l1
     */
    private void addFindByPKElement(XmlElement parentElement) {
        if (introspectedTable.getRules().generateSelectByPrimaryKey()) {
            AbstractXmlElementGenerator elementGenerator = new FindByPKElementGenerator();
            initializeAndExecuteGenerator(elementGenerator, parentElement);
        }
    }
    /**
     * create by l1
     */
    private void addFindOneElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new FindOneElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    /**
     * create by l1
     */
    private void addFindListElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new FindListElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }
    /**
     * create by l1
     */
    private void addFindByPageElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new FindByPageElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }
    /**
     * create by l1
     */
    private void addInsertElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new InsertGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }
    /**
     * create by l1
     */
    private void addUpdateElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new UpdateGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

   /**
     * create by l1
     */
    private void addDeleteByPkElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new DeleteByPkGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }
    /**
     * create by l1
     */
    private void addDeleteElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new DeleteGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }




    protected void addSelectByPrimaryKeyElement(XmlElement parentElement) {
        if (introspectedTable.getRules().generateSelectByPrimaryKey()) {
            AbstractXmlElementGenerator elementGenerator = new SimpleSelectByPrimaryKeyElementGenerator();
            initializeAndExecuteGenerator(elementGenerator, parentElement);
        }
    }

    protected void addSelectAllElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new SimpleSelectAllElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    protected void addDeleteByPrimaryKeyElement(XmlElement parentElement) {
        if (introspectedTable.getRules().generateDeleteByPrimaryKey()) {
            AbstractXmlElementGenerator elementGenerator = new DeleteByPrimaryKeyElementGenerator(true);
            initializeAndExecuteGenerator(elementGenerator, parentElement);
        }
    }

    protected void addDeleteElement(XmlElement parentElement, String name) {
        if (introspectedTable.getRules().generateDeleteByPrimaryKey()) {
            AbstractXmlElementGenerator elementGenerator = new DeleteElementGenerator(true, name);
            initializeAndExecuteGenerator(elementGenerator, parentElement);
        }
    }

    protected void addDeleteBatchElement(XmlElement parentElement) {
        if (introspectedTable.getRules().generateDeleteByPrimaryKey()) {
            AbstractXmlElementGenerator elementGenerator = new DeleteBatchElementGenerator(true);
            initializeAndExecuteGenerator(elementGenerator, parentElement);
        }
    }

    protected void addInsertElement(XmlElement parentElement, String name) {
        if (introspectedTable.getRules().generateInsert()) {
            AbstractXmlElementGenerator elementGenerator = new InsertElementGenerator(true, name);
            initializeAndExecuteGenerator(elementGenerator, parentElement);
        }
    }

    protected void addUpdateByPrimaryKeyElement(XmlElement parentElement) {
        if (introspectedTable.getRules().generateUpdateByPrimaryKeySelective()) {
            AbstractXmlElementGenerator elementGenerator = new UpdateByPrimaryKeyWithoutBLOBsElementGenerator(
                    true);
            initializeAndExecuteGenerator(elementGenerator, parentElement);
        }
    }

    protected void initializeAndExecuteGenerator(
            AbstractXmlElementGenerator elementGenerator,
            XmlElement parentElement) {
        elementGenerator.setContext(context);
        elementGenerator.setIntrospectedTable(introspectedTable);
        elementGenerator.setProgressCallback(progressCallback);
        elementGenerator.setWarnings(warnings);
        elementGenerator.addElements(parentElement);
    }

    @Override
    public Document getDocument() {
        Document document = new Document(
                XmlConstants.MYBATIS3_MAPPER_PUBLIC_ID,
                XmlConstants.MYBATIS3_MAPPER_SYSTEM_ID);
        document.setRootElement(getSqlMapElement());

        if (!context.getPlugins().sqlMapDocumentGenerated(document,
                introspectedTable)) {
            document = null;
        }

        return document;
    }


    /**
     * create by l1
     */
    protected void addSelectOne(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new SelectOneElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    /**
     * create by l1
     */
    protected void addSelectList(XmlElement parentElement, String name) {
        AbstractXmlElementGenerator elementGenerator = new SelectListElementGenerator(name);
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    /**
     *  modify by l1
     */
    protected void addUpdateElement(XmlElement parentElement, String name) {
        if (introspectedTable.getRules().generateUpdateByPrimaryKeySelective()) {
            AbstractXmlElementGenerator elementGenerator = new UpdateElementGenerator(
                    true, name);
            initializeAndExecuteGenerator(elementGenerator, parentElement);
        }
    }

    /**
     * add by l1
     */
    protected void addInsertSelectiveElement(XmlElement parentElement) {
        if (introspectedTable.getRules().generateInsert()) {
            AbstractXmlElementGenerator elementGenerator = new InsertSelectiveElementGenerator();
            initializeAndExecuteGenerator(elementGenerator, parentElement);
        }
    }

    protected void addCountElement(XmlElement parentElement, String name) {
        if (introspectedTable.getRules().generateInsert()) {
            AbstractXmlElementGenerator elementGenerator = new CountElementGenerator(name);
            initializeAndExecuteGenerator(elementGenerator, parentElement);
        }
    }

}
