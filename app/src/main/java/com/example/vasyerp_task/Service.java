package com.example.vasyerp_task;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface Service {
    public String Base_URl="https://reqres.in/api/";
    public String Feed="users";

    Retrofit retrofit= new Retrofit.Builder().baseUrl(Base_URl).addConverterFactory(GsonConverterFactory.create())
                                    .build();


    @GET(Feed)
    Call<Root>getList();

}
