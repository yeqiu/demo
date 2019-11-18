package com.yeqiu.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project：demo
 * @author：小卷子
 * @date 2019-11-15
 * @describe：
 * @fix：
 */
@RestController
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {

        return "test";
    }


    @Autowired
    DataSource dataSource;


    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    public Object getAllData() throws Exception {

        Connection connection = dataSource.getConnection();
        String sql = "SELECT * FROM `user`";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet result = preparedStatement.executeQuery();

        List<Map<String, Object>> list = new ArrayList<>();
        while (result.next()) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", result.getObject("id"));
            map.put("name", result.getObject("name"));
            list.add(map);
        }

        if (result!=null){
            result.close();
        }
        if(preparedStatement!= null ) {
            preparedStatement.close();
        }
        if(connection!= null ) {
            connection.close();
        }
        return list;
    }



}
