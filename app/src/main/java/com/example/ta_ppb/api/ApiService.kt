package com.example.ta_ppb.api
import com.example.ta_ppb.model.ResponModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
interface ApiService {
    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String,
    ): Call<ResponModel>


    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("Email") username: String,
        @Field("password") password: String,
    ): Call<ResponModel>


}