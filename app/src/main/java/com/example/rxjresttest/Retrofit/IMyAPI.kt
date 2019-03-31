package com.example.rxjresttest.Retrofit

import com.example.rxjresttest.Model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface IMyAPI {
    @get:GET("posts")
    val posts:Observable<List<Post>>
}