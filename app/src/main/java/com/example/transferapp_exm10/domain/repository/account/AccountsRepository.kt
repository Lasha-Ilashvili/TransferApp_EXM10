package com.example.transferapp_exm10.domain.repository.account

import com.example.transferapp_exm10.data.common.Resource
import com.example.transferapp_exm10.domain.model.account.GetAccount
import kotlinx.coroutines.flow.Flow

interface AccountsRepository {
    suspend fun getAccounts(): Flow<Resource<List<GetAccount>>>
    suspend fun getAccount(accountNumber: String): Flow<Resource<GetAccount>>
}