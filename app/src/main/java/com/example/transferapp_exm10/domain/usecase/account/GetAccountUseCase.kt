package com.example.transferapp_exm10.domain.usecase.account

import com.example.transferapp_exm10.domain.repository.account.AccountsRepository
import javax.inject.Inject

class GetAccountsUseCase @Inject constructor(
    private val accountsRepository: AccountsRepository
) {

    suspend operator fun invoke() =
        accountsRepository.getAccounts()
}