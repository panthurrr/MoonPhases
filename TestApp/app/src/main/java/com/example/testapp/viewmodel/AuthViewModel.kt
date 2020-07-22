package com.example.testapp.viewmodel

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class AuthViewModel @Inject constructor(): ViewModel() {
    var counter: Int = 0
}