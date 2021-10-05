package com.geek.schoolapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geek.schoolapp.dataModel.studentX
import com.geek.schoolapp.repositoy.StudentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class studentViewModel(val repository: StudentRepository , val standard : Int) : ViewModel() {
    init{
        GlobalScope.launch() {
            repository.getStudents(standard)
        }
    }
    val students : LiveData<studentX>
        get() = repository.list

}