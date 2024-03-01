package com.example.transferapp_exm10.presentation.screen.sign_up.create_account

import androidx.fragment.app.viewModels
import com.example.transferapp_exm10.databinding.FragmentTransferBinding
import com.example.transferapp_exm10.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TransferFragment :
    BaseFragment<FragmentTransferBinding>(FragmentTransferBinding::inflate) {

    private val viewModel: TransferViewModel by viewModels()

    override fun setUp() {
        viewModel.sm()
    }

//    override fun bindViewActionListeners() {
//        with(binding) {
//            btnBack.setOnClickListener {
//                findNavController().popBackStack()
//            }
//
//            addTextListeners(listOf(etEmail, etPassword, etRepeatPassword))
//
//            btnNext.setOnClickListener {
//                signUp()
//            }
//        }
//    }

//    override fun bindObserves() {
//        viewLifecycleOwner.lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                viewModel.createAccountState.collect {
//                    handleState(it)
//                }
//            }
//        }
//
//        viewLifecycleOwner.lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                viewModel.uiEvent.collect {
//                    handleNavigationEvents(event = it)
//                }
//            }
//        }
//    }

    /* IMPLEMENTATION DETAILS */

//    override fun bind() {}

//    private fun addTextListeners(fields: List<TextInputLayout>) {
//        fields.forEach { textInputLayout ->
//            textInputLayout.editText?.doAfterTextChanged {
//                viewModel.onEvent(CreateAccountEvent.SetButtonState(fields))
//            }
//        }
//    }
//
//    private fun signUp() = with(binding) {
//        viewModel.onEvent(
//            CreateAccountEvent.SignUp(
//                    firstName = args.firstName,
//                    lastName = args.lastName,
//                    email = etEmail,
//                    mobileNumber = args.mobileNumber,
//                    password = etPassword,
//                    matchingPassword = etRepeatPassword,
//                    personalNumber = args.personalNumber
//            )
//        )
//    }
//
//    private fun handleState(createAccountState: AccountState) =
//        with(createAccountState) {
//
//            binding.progressBar.root.visibility =
//                if (isLoading) View.VISIBLE else View.GONE
//
//            errorMessage?.let {
//                binding.root.showToast(errorMessage)
//                viewModel.onEvent(CreateAccountEvent.ResetErrorMessage)
//            }
//
//            binding.btnNext.isEnabled = isButtonEnabled
//
//            errorTextInputLayout?.let {
//                it.error = getString(R.string.invalid_input)
//                it.isErrorEnabled = isErrorEnabled
//            }
//        }
//
//    private fun handleNavigationEvents(event: TransferViewModel.AccountUiEvent) =
//        with(event) {
//            when (this) {
//                is TransferViewModel.AccountUiEvent.NavigateBackToLogIn -> {
//                    val resultBundle = Bundle().apply {
//                        putString("email", userCredentials.email)
//                        putString("password", userCredentials.password)
//                    }
//
//                    parentFragmentManager.setFragmentResult("requestKey", resultBundle)
//
//                    findNavController().navigate(
//                        CreateAccountFragmentDirections.actionCreateAccountFragmentToLogInFragment()
//                    )
//                }
//            }
//        }
}