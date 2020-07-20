package com.yeqiu.retrofit.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * @project：retrofit
 * @author：小卷子
 * @date 2020/7/6
 * @describe：
 * @fix：
 */

public class FileModel {

    private MultipartFile file;
    private String name;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
