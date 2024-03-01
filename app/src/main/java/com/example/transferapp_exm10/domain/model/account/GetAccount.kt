package com.example.transferapp_exm10.domain.model.account



data class GetAccount(
    val id: Int,
    val accountName: String,
    val accountNumber: String,
    val currencyType: String,
    val cardType: String,
    val balance: Int?,
    val cardLogo: Any?
)