package com.example.transferapp_exm10.presentation.screen.sign_up.create_account

import android.util.Log.d
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tbilisi_parking_final_exm.presentation.state.sign_up.create_account.AccountState
import com.example.transferapp_exm10.data.common.Resource
import com.example.transferapp_exm10.domain.usecase.account.GetAccountUseCase
import com.example.transferapp_exm10.domain.usecase.account.GetAccountsUseCase
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TransferViewModel @Inject constructor(
//    private val signUpUseCase: SignUpUseCase,
//    private val fieldsAreNotBlank: FieldsAreNotBlankUseCase,
//    private val emailValidator: EmailValidatorUseCase,
//    private val passwordValidator: SignUpPasswordValidatorUseCase
    private val accountsUseCase: GetAccountsUseCase,
    private val accountUseCase: GetAccountUseCase
) : ViewModel() {

    private val _accountState = MutableStateFlow(AccountState())
    val accountState get() = _accountState.asStateFlow()

    init {
        viewModelScope.launch {
            accountsUseCase().collect {
                if (it is Resource.Success)
                    d("CheckData", it.data.toString())
            }
            accountUseCase(accountNumber = "EU67JG7744036080300903").collect {
                if (it is Resource.Success)
                    d("CheckData", it.data.toString())
            }
        }
    }

    fun sm() {}

//    private val _uiEvent = MutableSharedFlow<AccountUiEvent>()
//    val uiEvent get() = _uiEvent

//    fun onEvent(event: CreateAccountEvent) = with(event) {
//        when (this) {
//            is CreateAccountEvent.SetButtonState -> setButtonState(fields = fields)
//
//            is CreateAccountEvent.SignUp -> validateFields(
//                firstName = firstName,
//                lastName = lastName,
//                email = email,
//                mobileNumber = mobileNumber,
//                password = password,
//                matchingPassword = matchingPassword,
//                personalNumber = personalNumber
//            )
//
//            CreateAccountEvent.ResetErrorMessage -> updateErrorMessage()
//        }
//    }

//    private fun validateFields(
//        firstName: String,
//        lastName: String,
//        email: TextInputLayout,
//        mobileNumber: String,
//        password: TextInputLayout,
//        matchingPassword: TextInputLayout,
//        personalNumber: String
//    ) {
//        val emailInput = email.editText?.text.toString()
//        val passwordInput = password.editText?.text.toString()
//        val matchingPasswordInput = matchingPassword.editText?.text.toString()
//
//        val isEmailValid = emailValidator(emailInput)
//        val isPasswordValid = passwordValidator(passwordInput, matchingPasswordInput)
//
//        val areFieldsValid =
//            listOf(isEmailValid, isPasswordValid)
//                .all { it }
//
//        validateField(isEmailValid, email)
//        validateField(isPasswordValid, password)
//        validateField(isPasswordValid, matchingPassword)
//
//        if (!areFieldsValid) {
//            return
//        }
//
//        val user = User(
//            firstName = firstName,
//            lastName = lastName,
//            email = emailInput,
//            mobileNumber = mobileNumber,
//            password = passwordInput,
//            matchingPassword = matchingPasswordInput,
//            personalNumber = personalNumber
//        )
//
//        signUp(user)
//    }

    private fun validateField(isFieldValid: Boolean, textInputLayout: TextInputLayout) {
        updateErrorTextInputLayout(
            errorTextInputLayout = textInputLayout,
            isErrorEnabled = !isFieldValid
        )
    }

//    private fun signUp(user: User) {
//        viewModelScope.launch {
//            signUpUseCase(user).collect {
//                when (it) {
//                    is Resource.Success -> {
//                        _uiEvent.emit(
//                            AccountUiEvent.NavigateBackToLogIn(
//                                userCredentials = it.data.toPresentation()
//                            )
//                        )
//                    }
//
//                    is Resource.Loading -> _accountState.update { currentState ->
//                        currentState.copy(isLoading = it.loading)
//                    }
//
//                    is Resource.Error -> updateErrorMessage(message = it.errorMessage)
//                }
//            }
//        }
//    }

//    private fun setButtonState(fields: List<TextInputLayout>) {
//        _accountState.update { currentState ->
//            currentState.copy(isButtonEnabled = fieldsAreNotBlank(fields))
//        }
//    }

    private fun updateErrorTextInputLayout(
        errorTextInputLayout: TextInputLayout,
        isErrorEnabled: Boolean
    ) {
        _accountState.update { currentState ->
            currentState.copy(
                errorTextInputLayout = errorTextInputLayout,
                isErrorEnabled = isErrorEnabled
            )
        }
    }

    private fun updateErrorMessage(message: String? = null) {
        _accountState.update { currentState ->
            currentState.copy(errorMessage = message)
        }
    }

//    sealed interface AccountUiEvent {
//        data class NavigateBackToLogIn(val userCredentials: UserCredentials) : AccountUiEvent
//    }
}