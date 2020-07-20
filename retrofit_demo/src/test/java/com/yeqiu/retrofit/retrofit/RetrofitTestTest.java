package com.yeqiu.retrofit.retrofit;

import com.google.gson.Gson;
import com.yeqiu.retrofit.model.Result;
import com.yeqiu.retrofit.model.User;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project：retrofit
 * @author：小卷子
 * @date 2020/6/28
 * @describe：
 * @fix：
 */

class RetrofitTestTest {


    public Api getApi() {
        String baseURL = "http://localhost:8099/retrofit/test/";
//        String baseURL = "https://ssl-signcenter.xingyoucai.com/signcenter/";


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new RetrofitInterceptor())
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        Api api = retrofit.create(Api.class);
        return api;
    }


    public void log(Object data) {
        System.out.println(new Gson().toJson(data));
    }


    @Test
    public void getAll() throws IOException {
        Call<Result<User>> call = getApi().getAll();
        Response<Result<User>> response = call.execute();
        Result<User> result = response.body();
        log(result);
    }

    @Test
    public void getById() throws IOException {

        Call<Result<User>> call = getApi().getById(1);
        Response<Result<User>> response = call.execute();
        Result<User> result = response.body();
        log(result);


    }

    @Test
    public void getUser() throws IOException {

        Map<String, Object> params = new HashMap<>();
        params.put("id", 999);
        params.put("name", "超极兵");
        Call<Result<User>> call = getApi().getUser(params);
        Response<Result<User>> response = call.execute();
        Result<User> result = response.body();
        log(result);

    }


    @Test
    public void getWithPath() throws IOException {
        Call<Result<User>> call = getApi().getWithPath(1);
        Response<Result<User>> response = call.execute();
        Result<User> result = response.body();
        log(result);
    }

    @Test
    public void getWithHead1() throws IOException {
        Call<Result<User>> call = getApi().getWithHead1();
        Response<Result<User>> response = call.execute();
        Result<User> result = response.body();
        log(result);
    }


    @Test
    public void getWithHead2() throws IOException {
        Call<Result<User>> call = getApi().getWithHead2("test");
        Response<Result<User>> response = call.execute();
        Result<User> result = response.body();
        log(result);
    }


    @Test
    public void post() throws IOException {
        Call<Result<User>> call = getApi().post(1, "宫本武藏");
        Response<Result<User>> response = call.execute();
        Result<User> result = response.body();
        log(result);
    }


    @Test
    public void postBody() throws IOException {

        User user = new User();
        user.setId(999);
        user.setName("宫本武藏");
        Call<Result<User>> call = getApi().postBody(user);
        Response<Result<User>> response = call.execute();
        Result<User> result = response.body();
        log(result);
    }


    @Test
    public void postFile() throws IOException {

        File file = new File("/Users/yeqiu/Desktop/测试文档/pdf/悟空线上合同模板V20190815.pdf");
        RequestBody fileBody = RequestBody.create(MediaType.parse("file/pdf"), file);
        MultipartBody.Part file1 = MultipartBody.Part.createFormData("file", file.getName(), fileBody);


        Call<Result<User>> call = getApi().postFile("悟空线上合同模板V20190815", file1);
        Response<Result<User>> response = call.execute();
        Result<User> result = response.body();
        log(result);
    }


    @Test
    public void postList() throws IOException {

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Call<Result<Object>> call = getApi().postList("test", list);
        Response<Result<Object>> response = call.execute();
        Result<Object> result = response.body();
        log(result);

    }


    @Test
    public void postFileAndData() throws IOException {

        Map<String, RequestBody> params = new HashMap<>();
        File file = new File("/Users/yeqiu/Desktop/测试文档/pdf/悟空线上合同模板V20190815.pdf");
        RequestBody fileBody = RequestBody.create(MediaType.parse("file/pdf"), file);
        params.put("file\"; filename=\"file", fileBody);
        params.put("title", RequestBody.create(MediaType.parse("text/plain"), "title"));
        List<String> list = new ArrayList<>();
        list.add("list1");
        list.add("list2");
        list.add("list3");
        list.add("list4");
        list.add("list5");

        Call<Result<Object>> call = getApi().postFileAndData(params, list);
        Response<Result<Object>> response = call.execute();
        Result<Object> result = response.body();
        log(result);
    }


    @Test
    public void postMultipartData() throws IOException {

        User user = new User();
        user.setId(1);
        user.setName("宫本武藏");
        User user2 = new User();
        user2.setId(2);
        user2.setName("蓝色超级兵");
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);

        RequestBody nameBody = RequestBody.create(MediaType.parse("text/plain"), "名字");
        RequestBody titleBody = RequestBody.create(MediaType.parse("text/plain"), "标题");
        Map<String, RequestBody> params = new HashMap<>();
        params.put("name", nameBody);
        params.put("title", titleBody);

        for (int i = 0; i < users.size(); i++) {
            User u1 = users.get(i);
            RequestBody id = RequestBody.create(MediaType.parse("text/plain"), String.valueOf(u1.getId()));
            RequestBody name = RequestBody.create(MediaType.parse("text/plain"), u1.getName());
            params.put("users[" + i + "].id", id);
            params.put("users[" + i + "].name", name);
        }

        List<File> files = new ArrayList<>();
        files.add(new File("/Users/yeqiu/Desktop/测试文档/pdf/悟空线上合同模板V20190815.pdf"));
        files.add(new File("/Users/yeqiu/Desktop/测试文档/pdf/表格测试.pdf"));
        files.add(new File("/Users/yeqiu/Desktop/测试文档/pdf/印章位置.pdf"));

        List<MultipartBody.Part> parts = new ArrayList<>();

        for (int i = 0; i < files.size(); i++) {
            File file = files.get(i);
            RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
            MultipartBody.Part filePart = MultipartBody.Part.createFormData("files[" + i + "]", file.getName(), fileBody);
            parts.add(filePart);
        }

        Call<Result<Object>> call = getApi().postMultipartData(params,parts);
        Response<Result<Object>> response = call.execute();
        Result<Object> result = response.body();
        log(result);

    }


    @Test
    public void complexData() throws IOException {

        Call<Result<Object>> call = getApi().complexData(999, "宫本武藏", "complexData");
        Response<Result<Object>> response = call.execute();
        Result<Object> result = response.body();
        log(result);
    }

}