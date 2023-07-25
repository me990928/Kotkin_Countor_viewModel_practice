package com.example.mycountor.CountorViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException


// インスタンス化する場所?
class CountorViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountorViewModel::class.java)){
            return CountorViewModel() as T
        }
        throw IllegalArgumentException("Unkown ViewModel class")
    }
}