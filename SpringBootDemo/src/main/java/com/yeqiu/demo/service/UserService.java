package com.yeqiu.demo.service;

import com.yeqiu.demo.model.User;

import java.util.List;

/**
 * @project：demo
 * @author：小卷子
 * @date 2019-11-15
 * @describe：
 * @fix：
 */

public interface UserService {


    List<User> findAll();


    User findById(long id);


    void add(User user);


    void delete(long id);


    void update(User user);

}
