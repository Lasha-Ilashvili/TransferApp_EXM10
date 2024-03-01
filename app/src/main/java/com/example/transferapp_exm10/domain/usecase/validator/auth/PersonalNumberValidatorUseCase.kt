package com.example.transferapp_exm10.domain.usecase.validator.auth

import javax.inject.Inject

private const val EXPECTED_LENGTH = 11

class PersonalNumberValidatorUseCase @Inject constructor() {

    operator fun invoke(personalNumber: String) =
        personalNumber.length == EXPECTED_LENGTH

}