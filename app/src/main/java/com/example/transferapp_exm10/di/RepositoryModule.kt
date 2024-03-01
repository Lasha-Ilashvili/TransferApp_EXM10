package com.example.transferapp_exm10.di

import com.example.transferapp_exm10.data.common.HandleResponse
import com.example.transferapp_exm10.data.repository.account.AccountsRepositoryImpl
import com.example.transferapp_exm10.data.service.account.AccountsService
import com.example.transferapp_exm10.domain.repository.account.AccountsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideAccountsRepository(
        accountsService: AccountsService,
        handleResponse: HandleResponse
    ): AccountsRepository {
        return AccountsRepositoryImpl(
            accountsService = accountsService,
            handleResponse = handleResponse
        )
    }
}