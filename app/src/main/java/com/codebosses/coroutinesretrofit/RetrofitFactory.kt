package com.codebosses.coroutinesretrofit

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitFactory {

    private const val BASE_URL = "https://api.themoviedb.org/3/"

    fun makeRetrofitService(): RetrofitService = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build().create(RetrofitService::class.java)

}