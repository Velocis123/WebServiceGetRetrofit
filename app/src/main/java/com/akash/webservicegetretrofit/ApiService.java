package com.akash.webservicegetretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {


    @GET("movies.json")
    Call<List<Movies>> getaAllMovies();




}
