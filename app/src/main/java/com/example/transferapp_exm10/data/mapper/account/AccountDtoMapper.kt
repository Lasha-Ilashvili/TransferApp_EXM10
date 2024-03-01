package com.example.transferapp_exm10.data.mapper.account

import com.example.transferapp_exm10.data.model.account.AccountDto
import com.example.transferapp_exm10.domain.model.account.GetAccount


fun AccountDto.toDomain() = GetAccount(
    id = id,
    accountName = accountName,
    accountNumber = accountNumber,
    currencyType = currencyType,
    cardType = cardType,
    balance = balance,
    cardLogo = cardLogo
)