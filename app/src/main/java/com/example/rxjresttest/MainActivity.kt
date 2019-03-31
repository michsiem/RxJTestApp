package com.example.rxjresttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager

import com.example.rxjresttest.Adapter.PostAdapter
import com.example.rxjresttest.Model.Post
import com.example.rxjresttest.Retrofit.IMyAPI
import com.example.rxjresttest.Retrofit.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    internal lateinit var jsonAPI: IMyAPI
    var compositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //API
        val retrofit = RetrofitClient.instance
        jsonAPI= retrofit.create(IMyAPI::class.java)

        //View
        recycler_posts_list.setHasFixedSize(true)
        recycler_posts_list.layoutManager=LinearLayoutManager(this)
        fetchData()

    }

    private fun fetchData() {
        compositeDisposable.add(jsonAPI.posts
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{posts->displayData(posts)}
        )
    }

    private fun displayData(posts: List<Post>?) {

        val adapter = PostAdapter(this,posts!!)
        recycler_posts_list.adapter = adapter

    }
}
