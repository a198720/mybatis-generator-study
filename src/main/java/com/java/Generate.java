package com.java;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * Created by l1 on 2016/8/24.
 */
public class Generate {
    public static void main(String[] args) throws Exception{
        List<String> warnings = new ArrayList<String>();

        File configFile = new File(
                "mybatis-generator-study/src/main/resources/" +
                        "generatorConfig-mysql-test.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        Set<String> contextIds = new HashSet<String>();
        contextIds.add("my");
        myBatisGenerator.generate(null,contextIds);

        System.out.println("完成...");
    }
}
