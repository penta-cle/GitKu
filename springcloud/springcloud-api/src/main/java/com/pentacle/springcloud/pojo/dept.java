package com.pentacle.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

//实体类实现序列化
@Data
@NoArgsConstructor
@Accessors(chain = true) //链式写法
/**
 * 链式写法
 * Dept dept = new Dept();
 *      dept.setDeptNo(11).setDname("安全部").setDb_source('01')
 * **/
public class Dept implements Serializable { //Dept 实体类

    private Long deptno;
    private String dname;
    //这个数据存在哪个数据库的字段，微服务一个服务对应一个数据库，同一个信息可能存在不同的数据库，区分作用
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }
}
