package com.example.transferapp_exm10.data.repository.account

import com.example.transferapp_exm10.data.common.HandleResponse
import com.example.transferapp_exm10.data.common.Resource
import com.example.transferapp_exm10.data.mapper.account.toDomain
import com.example.transferapp_exm10.data.mapper.base.asResource
import com.example.transferapp_exm10.data.service.account.AccountsService
import com.example.transferapp_exm10.domain.model.account.GetAccount
import com.example.transferapp_exm10.domain.repository.account.AccountsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AccountsRepositoryImpl @Inject constructor(
    private val accountsService: AccountsService,
    private val handleResponse: HandleResponse,
) : AccountsRepository {

    override suspend fun getAccounts(): Flow<Resource<List<GetAccount>>> {
        return handleResponse.safeApiCall {
            accountsService.getAccounts()
        }.asResource {
            it.map { dto ->
                dto.toDomain()
            }
        }
    }

    override suspend fun getAccount(accountNumber: String): Flow<Resource<GetAccount>> {
        return handleResponse.safeApiCall {
            accountsService.getAccount(accountNumber)
        }.asResource { dto ->
            dto.toDomain()
        }
    }
}