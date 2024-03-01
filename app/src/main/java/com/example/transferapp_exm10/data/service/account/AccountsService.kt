package com.example.transferapp_exm10.data.service.account

import com.example.transferapp_exm10.data.model.account.AccountDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AccountsService {
    @GET("5c74ec0e-5cc1-445e-b64b-b76b286b215f")
    suspend fun getAccounts(): Response<List<AccountDto>>

    @GET("4253786f-3500-4148-9ebc-1fe7fb9dc8d5")
    suspend fun getAccount(@Query("account_number") accountNumber: String): Response<AccountDto>
}