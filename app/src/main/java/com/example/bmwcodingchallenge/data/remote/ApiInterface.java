package com.example.bmwcodingchallenge.data.remote;

import com.example.bmwcodingchallenge.data.LocationPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("api/locations")
    Call<List<LocationPojo>> getLocations();
}
