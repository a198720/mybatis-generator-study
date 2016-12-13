#Mybatis 代码生成工具
主要根据封装好的baseDao框架,来自动生成相应的xml文件和实体类
##baseMapper
```java
package com.xin.mapper;

import java.util.List;

/**
 *
 * Created by l1 on 2016/12/13.
 */
interface BaseMapper<T> {
    T findByPk(Object pk);

    T findOne(Object o);

    List<T> findList(Object o);

    List<T> findByPage(Object o);

    /**
     * @param o 插入普通对象或者Map对象
     * @return 返回保存成功的行数
     */
    int insert(Object o);

    /**
     *
     * @param o 更新普通对象或者Map对象
     * @return 返回更新成功的行数
     */
    int update(Object o);

    int deleteByPk(Object pk);

    int delete(Object o);
}

```

##执行步骤
1. 修改sources中的配置文件
2. 修改main方法中的配置文件
3. 执行main方法
