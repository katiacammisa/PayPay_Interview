package com.katiacammisa.paypal_interview.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.katiacammisa.paypal_interview.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository,
): ViewModel() {

    private var _wrongCredentials = MutableStateFlow(false)
    val wrongCredentials = _wrongCredentials.asStateFlow()

    fun submitLoginCredentials(username: String, password: String, onSuccess: () -> Unit) {
        val areCredentialsValid = userRepository.validateCredentials(username, password)
        viewModelScope.launch {
            if (areCredentialsValid) {
                _wrongCredentials.emit(false)
                onSuccess()
            } else {
                _wrongCredentials.emit(true)
            }
        }
    }
}