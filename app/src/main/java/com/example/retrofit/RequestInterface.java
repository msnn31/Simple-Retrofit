package com.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("marvel")
    Call<List<PostModel>> getAllPost();
}
