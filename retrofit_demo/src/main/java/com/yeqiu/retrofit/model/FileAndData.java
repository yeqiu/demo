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

public class FileAndData {

    private MultipartFile file;
    private String title;
    private List<String> list;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
