package com.nadim.assignment_teleaus.Api;

import com.nadim.assignment_teleaus.Model.MainModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET("v1/experts")
    Call<MainModel> getData();

}
