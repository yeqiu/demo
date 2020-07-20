package com.yeqiu.retrofit.retrofit;

import com.google.gson.JsonObject;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * @project：retrofit
 * @author：小卷子
 * @date 2020/7/6
 * @describe：
 * @fix：
 */

public class RetrofitInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {

        Request.Builder builder = chain.request().newBuilder();

        if (true) {
            //todo 添加同一请求头
            // builder.addHeader("test", "111");
        }
        Request request = builder.build();
        Response response = chain.proceed(request);

        //打印请求体
        RetrofitLog.logRequest(request);
        //打印响应体
        RetrofitLog.logResponse(response);


        boolean tokenExpired = isTokenExpired(response);

        if (tokenExpired) {
            //登录
            String newToken = getNewToken();
            Request newRequest = chain.request().newBuilder().addHeader("authorization", "bearer " + newToken)
                    .build();
            return chain.proceed(newRequest);

        }

        return response;
    }

    private String getNewToken() throws IOException {


        String baseURL = "https://ssl-signcenter.xingyoucai.com/signcenter/";

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new RetrofitInterceptor())
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        Api api = retrofit.create(Api.class);


        Call<JsonObject> call = api.getToken("admin", "91863870edb74f3fe45930b7e4acd28a", "password",
                "client", "secret");

        retrofit2.Response<JsonObject> response = call.execute();
        JsonObject jsonObject = response.body();

        String token = jsonObject.get("access_token").getAsString();

        return token;

    }

    private boolean isTokenExpired(Response response) {

        return response.code() == 401;

    }

}
