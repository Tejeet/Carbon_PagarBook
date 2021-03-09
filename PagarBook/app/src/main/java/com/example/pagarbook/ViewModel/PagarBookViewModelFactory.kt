package com.example.pagarbook.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pagarbook.Repository.PagarBookRepository

class PagarBookViewModelFactory(val repository: PagarBookRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  PagarBookViewModel(repository) as T
    }
}