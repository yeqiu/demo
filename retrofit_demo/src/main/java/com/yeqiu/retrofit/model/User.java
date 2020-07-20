package com.yeqiu.retrofit.model;

import java.io.Serializable;

/**
 * @project：retrofit
 * @author：小卷子
 * @date 2020/6/28
 * @describe：
 * @fix：
 */

public class User implements Serializable {

    private long id;
    private String name;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
