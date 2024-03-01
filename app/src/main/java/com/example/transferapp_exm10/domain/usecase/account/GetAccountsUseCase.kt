package com.example.transferapp_exm10.domain.usecase.account

import com.example.transferapp_exm10.domain.repository.account.AccountsRepository
import javax.inject.Inject

class GetAccountUseCase @Inject constructor(
    private val accountsRepository: AccountsRepository
) {

    suspend operator fun invoke(accountNumber: String) =
        accountsRepository.getAccount(accountNumber)
}