package com.tejeet.mvvmcoroutine.remote

import com.example.pagarbook.Models.OTPResponseDTOModel
import retrofit2.http.*

interface APIService {

    @Headers("Accept: application/json")
    @GET("/sendotp.php")

    //sendotp.php?sendOTP=ok&otp=2345&purpose=Signup&mobile=9763028519

    suspend fun getOTPFORLOGIN(
        @Header("Content-Type") contentType: String,
        @Query("sendOTP") sendOTP: String,
        @Query("purpose") purpose: String,
        @Query("mobile") mobile: String,
    ): OTPResponseDTOModel

}