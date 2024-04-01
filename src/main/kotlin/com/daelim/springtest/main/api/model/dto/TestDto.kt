package com.daelim.springtest.main.api.model.dto

data class TestDto(
    val id: String,
    val address: String,
    val email: String,
    val tel: String? = null,
    val age: Int,
)

data class TestDtoRequest(
    val id: String,
)
