package com.yeqiu.retrofit.retrofit;

import com.google.gson.JsonObject;
import com.yeqiu.retrofit.model.Result;
import com.yeqiu.retrofit.model.User;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * @project：retrofit
 * @author：小卷子
 * @date 2020/6/28
 * @describe：
 * @fix：
 */

public interface Api {


    @GET("getAll")
    Call<Result<User>> getAll();

    @GET("getById")
    Call<Result<User>> getById(@Query("id") long id);

    @GET("getUser")
    Call<Result<User>> getUser(@QueryMap Map<String, Object> params);

    @GET("get/{id}")
    Call<Result<User>> getWithPath(@Path("id") long id);


    @GET("getWithHead")
    @Headers("name:test")
    Call<Result<User>> getWithHead1();

    @GET("getWithHead")
    Call<Result<User>> getWithHead2(@Header("name") String name);


    @POST("post")
    @FormUrlEncoded
    Call<Result<User>> post(@Field("id") long id, @Field("name") String name);

    @POST("postBody")
    Call<Result<User>> postBody(@Body User user);



    @POST("postFile")
    @Multipart
    Call<Result<User>> postFile(@Part("name") String name,
                                @Part MultipartBody.Part file);


    @POST("oauth/token")
    @FormUrlEncoded
    Call<JsonObject> getToken(@Field("username") String username,
                              @Field("password") String password,
                              @Field("grant_type") String grant_type,
                              @Field("client_id") String client_id,
                              @Field("client_secret") String client_secret);


    @POST("post/list")
    @FormUrlEncoded
    Call<Result<Object>> postList(@Field("title") String title,
                                  @Field("list") List<String> list);


    @POST("postFileAndData")
    @Multipart
    Call<Result<Object>> postFileAndData(
            @PartMap Map<String, RequestBody> params,
            @Part("list") List<String> list);


    @POST("post/multipart/data")
    @Multipart
    Call<Result<Object>> postMultipartData(@PartMap Map<String, RequestBody> params,
                                           @Part List<MultipartBody.Part> files);


    @POST("post/complexData")
    @FormUrlEncoded
    Call<Result<Object>> complexData(@Field("user.id") long id,
                                     @Field("user.name")String name,
                                     @Field("str")String str);


}
