package com.example.transferapp_exm10.domain.usecase.validator.auth

import com.google.android.material.textfield.TextInputLayout
import javax.inject.Inject

class FieldsAreNotBlankUseCase @Inject constructor() {

    operator fun invoke(fields: List<TextInputLayout>): Boolean = fields.all {
        it.editText?.text.toString().isNotBlank()
    }
}