package com.yeqiu.retrofit.retrofit;

import com.google.gson.JsonObject;
import okhttp3.*;
import okio.Buffer;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @project：retrofit
 * @author：小卷子
 * @date 2020/7/6
 * @describe：
 * @fix：
 */

public class RetrofitLog {

    public static void logRequest(Request request) throws IOException {


        RequestBody requestBody = request.body();

        StringBuilder log = new StringBuilder();

        log.append("----> 请求开始 ")
                .append(" url = ")
                .append(request.url())
                .append(" ")
                .append(",method = ")
                .append(request.method())
                .append(" ")
                .append(",content-type = ")
                .append(requestBody.contentType())
                .append(" ");


        Headers headers = request.headers();
        if (headers != null && headers.size() > 0) {
            log.append(",head = ");
            JsonObject headJson = new JsonObject();
            for (int i = 0; i < headers.size(); i++) {
                headJson.addProperty(headers.name(i), headers.value(i));
            }
            log.append(headJson.toString());
        }


        JsonObject requestBodyString = new JsonObject();
        if (requestBody instanceof FormBody) {
            FormBody formBody = (FormBody) requestBody;
            for (int i = 0; i < formBody.size(); i++) {
                requestBodyString.addProperty(formBody.encodedName(i),URLDecoder.decode(formBody.encodedValue(i)
                        , "UTF-8"));

            }
        }

        if (requestBody instanceof MultipartBody){
            MultipartBody multipartBody = (MultipartBody) requestBody;
            Buffer buffer1 = new Buffer();
            requestBody.writeTo(buffer1);
            String postParams = buffer1.readUtf8();

            String[] split = postParams.split("\n");
            List<String> names = new ArrayList<>();
            for (String s : split) {
                if (s.contains("Content-Disposition")) {
                    names.add(s.replace("Content-Disposition: form-data; name=", "").replace("\"", ""));
                }
            }


            List<MultipartBody.Part> parts = multipartBody.parts();
            for (int i = 0; i < parts.size(); i++) {
                MultipartBody.Part part = parts.get(i);
                RequestBody body1 = part.body();
                if (body1.contentLength() < 100) {
                    Buffer buffer = new Buffer();
                    body1.writeTo(buffer);
                    String value = buffer.readUtf8();
                    //打印 name和value
                    if (names.size() > i) {
                        requestBodyString.addProperty(names.get(i),value);
                    }
                } else {
                    if (names.size() > i) {
                        requestBodyString.addProperty(names.get(i),"");
                    }
                }
            }

        }
        String body = "";
        if (requestBodyString.size() ==0){
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            try {
                body = URLDecoder.decode(buffer.readUtf8(), "UTF-8");
            }catch (Exception e){
                body = buffer.readUtf8();
            }
        }else{
            body = requestBodyString.toString();
        }


        log.append(",requestBody = ")
                .append(body)
                .append(" ");

        System.out.println(log.toString());




    }

    public static void logResponse(Response response) throws IOException {


        ResponseBody responseBody = response.peekBody(1024 * 1024);
        StringBuilder log = new StringBuilder();
        try {
            log.append("<---- 请求结束 ")
                    .append(",url = ")
                    .append(response.request().url())
                    .append(" ")
                    .append(",status = ")
                    .append(response.code())
                    .append(" ")
                    .append(",responseBody = ")
                    .append(responseBody.string());
        } catch (Exception e) {
        }

        System.out.println(log.toString());


    }


}
