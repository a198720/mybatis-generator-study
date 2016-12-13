package org.mybatis.generator;

/**
 *
 * Created by l1 on 2016/8/24.
 */
public enum GeneratorCondition {
    equalWhere("equalWhere"),equalLikeWhere("equalLikeWhere"),equalSet("equalSet");
    private String value;
    GeneratorCondition(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
}
