package com.example.tbilisi_parking_final_exm.presentation.state.sign_up.create_account

import com.google.android.material.textfield.TextInputLayout


data class AccountState(
    val isLoading: Boolean = false,
    val errorTextInputLayout: TextInputLayout? = null,
    val isErrorEnabled: Boolean = false,
    val isButtonEnabled: Boolean = false,
    val errorMessage: String? = null
)