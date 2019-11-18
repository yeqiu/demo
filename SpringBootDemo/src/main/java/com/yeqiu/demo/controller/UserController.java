package com.yeqiu.demo.controller;

import com.yeqiu.demo.model.Result;
import com.yeqiu.demo.model.User;
import com.yeqiu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @project：demo
 * @author：小卷子
 * @date 2019-11-15
 * @describe：
 * @fix：
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Result getAll() {

        List<User> all = userService.findAll();
        Result<List<User>> result = new Result<>();
        result.setCode(0);
        result.setMsg("请求成功");
        result.setData(all);

        return result;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody User user) {
        userService.add(user);
        Result result = new Result();
        result.setCode(0);
        result.setMsg("请求成功");
        return result;
    }


    /**
     * 表单形式
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/addWhitForm", method = RequestMethod.POST)
    public Result addForm(User user) {
        userService.add(user);
        Result result = new Result();
        result.setCode(0);
        result.setMsg("请求成功");
        return result;
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result delete(int id) {
        userService.delete(id);
        Result result = new Result();
        result.setCode(0);
        result.setMsg("请求成功");
        return result;
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(User user) {
        userService.update(user);
        Result result = new Result();
        result.setCode(0);
        result.setMsg("请求成功");
        return result;
    }


}
