package com.example.transferapp_exm10.domain.usecase.validator.auth

import javax.inject.Inject

private const val EXPECTED_LENGTH = 9

class MobileNumberValidatorUseCase @Inject constructor() {
    operator fun invoke(mobileNumber: String) =
        mobileNumber.length == EXPECTED_LENGTH

}