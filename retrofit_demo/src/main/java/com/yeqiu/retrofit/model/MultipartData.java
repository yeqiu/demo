package com.yeqiu.retrofit.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @project：retrofit
 * @author：小卷子
 * @date 2020/7/14
 * @describe：
 * @fix：
 */

public class MultipartData {


    private String name;
    private String title;
    private List<User> users;
    private List<MultipartFile> files;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }
}
