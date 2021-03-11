package com.example.pagarbook.Models

import java.io.Serializable

data class OTPResponseDTOModel(
    var success: Int? = null,
    var otpIS: Int? = null,
    var message: String? = null
)