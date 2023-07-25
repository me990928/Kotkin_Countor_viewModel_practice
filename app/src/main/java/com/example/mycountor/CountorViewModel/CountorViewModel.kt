package com.example.mycountor.CountorViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

// ViewModelのクラス
class CountorViewModel:ViewModel() {

    var count by mutableStateOf(0)
        private set

    fun countUp(){
        count++
    }

    fun countDw(){
        count--
    }

    fun countRs(){
        count = 0
    }

}