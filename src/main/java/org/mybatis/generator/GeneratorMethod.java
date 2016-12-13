package org.mybatis.generator;

/**
 * 枚举方法变量
 * Created by l1 on 2016/8/24.
 */
public enum GeneratorMethod {
    //查询单条记录
    selectOne("selectOne"),
    //查询多条记录
    selectList("selectList"),
    //按照主键更新记录
    updateByPrimaryKey("updateByPrimaryKey"),
    //按照主键删除
    deleteByPrimaryKey("deleteByPrimaryKey"),
    //可选择插入数据
    insertSelective("insertSelective");

    private String value;

    GeneratorMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
