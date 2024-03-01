package com.example.transferapp_exm10.presentation.event.sign_up.terms


sealed class TermsEvent {
    data class SetButtonState(val isChecked: Boolean) : TermsEvent()
}