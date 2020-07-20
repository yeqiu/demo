package com.yeqiu.retrofit.controller;

import com.yeqiu.retrofit.model.*;
import com.yeqiu.retrofit.utils.LogUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;

/**
 * @project：retrofit
 * @author：小卷子
 * @date 2020/7/3
 * @describe：
 * @fix：
 */
@RestController
@RequestMapping("/test")
public class RetrofitController {


    @GetMapping("/getAll")
    public Result<User> getAllUser() {
        Result<User> result = Result.getInstance();
        result.setData(getUser());
        result.setMessage("getAll");
        return result;
    }


    @GetMapping("/getById")
    public Result<User> getById(long id) {
        Result<User> result = Result.getInstance();
        if (id == 1) {
            result.setData(getUser());
        }
        result.setMessage("get");
        return result;
    }

    @GetMapping("/getUser")
    public Result<User> getUser(long id, String name) {
        Result<User> result = Result.getInstance();
        User user = new User();
        user.setId(id);
        user.setName(name);
        result.setData(user);
        result.setMessage("getUser/");
        return result;
    }


    @GetMapping("/get/{id}")
    public Result<User> getUser(@PathVariable("id") long id) {
        Result<User> result = Result.getInstance();
        if (id == 1) {
            result.setData(getUser());
        }
        result.setMessage("get/" + id);
        return result;
    }


    @GetMapping("/getWithHead")
    public Result<User> getWithHead(@RequestHeader("name") String head) {
        Result<User> result = Result.getInstance();
        if (head.equals("test")) {
            result.setData(getUser());
        }
        result.setMessage("getWithHead/");
        return result;
    }


    @PostMapping("/post")
    public Result<User> addUser(User user) {
        Result<User> result = Result.getInstance();
        result.setData(user);
        result.setMessage("post/,表单");
        return result;
    }

    @PostMapping("/post/list")
    public Result<ListData> addList(ListData data) {
        Result<ListData> result = Result.getInstance();
        result.setData(data);
        result.setMessage("post/,list");
        return result;
    }


    @PostMapping("/postBody")
    public Result<User> addUserByBody(@RequestBody User user) {
        Result<User> result = Result.getInstance();
        result.setData(user);
        result.setMessage("post/,Body/json");
        return result;
    }


    @PostMapping("/postFile")
    public Result<User> postFile(FileModel fileModel) {
        Result<User> result = Result.getInstance();
        User user = new User();
        user.setId(999);
        user.setName(fileModel.getName());
        result.setData(user);

        LogUtils.log("file = ",fileModel.getFile().getOriginalFilename());
        return result;

    }


    @PostMapping("/postFileAndData")
    public Result<Object> FileAndData(FileAndData fileAndData) {
        Result<Object> result = Result.getInstance();
        result.setData(fileAndData.getList());
        return result;
    }

    @PostMapping("/post/multipart/data")
    public Result<Object> MultipartData(MultipartData data) throws UnsupportedEncodingException {
        Result<Object> result = Result.getInstance();

        LogUtils.log("data.getName()", data.getName());
        LogUtils.log("data.getTitle()", data.getTitle());
        LogUtils.log("data.getUsers()", data.getUsers());

        for (MultipartFile file : data.getFiles()) {
            LogUtils.log("name",file.getOriginalFilename());
        }

        return result;
    }


    @PostMapping("/post/complexData")
    public Result complexData(ComplexData data){
        Result<ComplexData> result = Result.getInstance();
        result.setData(data);
        return result;
    }


    private User getUser() {
        User user = new User();
        user.setId(1);
        user.setName("宫本武藏");
        return user;
    }

}
