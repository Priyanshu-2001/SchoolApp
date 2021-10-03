package com.geek.schoolapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.geek.schoolapp.repositoy.StudentRepository

class studentViewModelFactory(private val repository: StudentRepository , private val standard : String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return studentViewModel(repository,standard) as T
    }
}