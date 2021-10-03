package com.geek.schoolapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geek.schoolapp.dataModel.student
import com.geek.schoolapp.repositoy.StudentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class studentViewModel(val repository: StudentRepository , val standard : String) : ViewModel() {
    init{
        GlobalScope.launch(Dispatchers.IO) {
            repository.getStudents(standard)
        }
    }
    val students : LiveData<student>
        get() = repository.list

}