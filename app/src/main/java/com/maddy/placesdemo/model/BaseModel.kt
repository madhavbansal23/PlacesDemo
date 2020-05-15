package com.maddy.placesdemo.model

data class BaseModel<T>(
    val status: Int = 1,
    val requestId: String? = "",
    val data: T? = null
)
