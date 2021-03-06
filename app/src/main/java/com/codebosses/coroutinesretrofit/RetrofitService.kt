package com.codebosses.coroutinesretrofit

import Movie
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService{

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(@Query("api_key") apiKey: String, @Query("language") language: String,
                                  @Query("page") page: Int) : Response<Movie>

}