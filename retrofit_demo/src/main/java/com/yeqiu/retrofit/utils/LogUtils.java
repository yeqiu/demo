package com.yeqiu.retrofit.utils;

import com.google.gson.Gson;

/**
 * @project：xinhe-signcenter
 * @author：小卷子
 * @date 2020-02-24
 * @describe：
 * @fix：
 */

public class LogUtils {


    public static void log(String tag, Object msg) {

        if (msg == null) {
            System.out.println("======= " + tag + "= " + null);
        } else if (msg instanceof String) {
            System.out.println("======= " + tag + "= " + msg);
        } else {

            try {
                System.out.println("======= " + tag + "= " + new Gson().toJson(msg));
            } catch (Exception e) {

            }
        }
    }


}
