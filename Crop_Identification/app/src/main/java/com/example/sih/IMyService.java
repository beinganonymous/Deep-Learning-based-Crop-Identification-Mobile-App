package com.example.sih;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import io.reactivex.Observable;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface IMyService {

    @Multipart
    @POST("/analyze")
    Call<MessageResult> uploadImage(@Part MultipartBody.Part file, @Part("name") RequestBody requestBody);
}

