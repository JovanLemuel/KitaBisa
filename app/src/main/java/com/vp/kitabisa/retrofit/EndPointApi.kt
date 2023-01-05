package com.vp.kitabisa.retrofit

import com.vp.kitabisa.model.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface EndPointApi {
    //    users api
    @FormUrlEncoded
    @POST("recruiter")
    fun addRecruiter(
        @Field("recruiter_name") recruiter_name: String,
        @Field("recruiter_password") recruiter_password: String,
        @Field("recruiter_title") recruiter_title: String,
        @Field("recruiter_description") recruiter_description: String,
        @Field("recruiter_contact") recruiter_contact: String
    ): Call<SubmitRegisterRecruiter>

    @FormUrlEncoded
    @PATCH("recruiter")
    fun updateRecruiter(
        @Field("recruiter_id") recruiter_id: String,
        @Field("recruiter_name") recruiter_name: String,
        @Field("recruiter_password") recruiter_password: String,
        @Field("recruiter_title") recruiter_title: String,
        @Field("recruiter_description") recruiter_description: String,
        @Field("recruiter_contact") recruiter_contact: String
    ): Call<Updaterecruiter>

    //   get user by id
    @GET("recruiter/{id}")
    suspend fun getRecruiterById(
        @Path("recruiter_id") recruiter_id: Int
    ): Response<Recruiters>

    //cek login
    @FormUrlEncoded
    @POST("loginRecruiter")
    fun loginRecruiter(
        @Field("recruiter_name") recruiter_name: String,
        @Field("recruiter_password") recruiter_password: String
    ): Call<SubmitLoginRecruiter>

    @GET("postRecruiter/{id}")
    suspend fun getPostRecruiter(
        @Path("post_recruiter_id") post_recruiter_id: Int
    ): Response<PostRecruiter>

    @FormUrlEncoded
    @PATCH("postRecruiter")
    fun UpdateRecruiter(
        @Field("post_recruiter_id") post_recruiter_id: String,
        @Field("post_recruiter_description") post_recruiter_description: String,
        @Field("post_recruiter_title") post_recruiter_title: String,
        @Field("post_recruiter_type") post_recruiter_type: String
    ): Call<UpdateRecruiter>

    @FormUrlEncoded
    @POST("postRecruiter")
    fun AddRecruiter(
        @Field("id_recruiter") id_user: String,
        @Field("post_recruiter_description") post_recruiter_description: String,
        @Field("post_recruiter_title") post_recruiter_title: String,
        @Field("post_recruiter_type") post_recruiter_type: String
    ): Call<AddRecruiter>

    @DELETE("postRecruiter")
    fun DeleteRecruiter(
        @Query("post_recruiter_id") post_recruiter_id: String
    ): Call<DeleteRecruiter>
}