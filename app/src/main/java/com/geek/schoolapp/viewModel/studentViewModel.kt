package com.geek.schoolapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geek.schoolapp.dataModel.studentItem
import com.geek.schoolapp.repositoy.StudentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class studentViewModel(private val repository: StudentRepository, val standard: Int) : ViewModel() {
    init {
        GlobalScope.launch(Dispatchers.IO) {
            repository.getStudents(standard)
        }
    }

    val students: LiveData<List<studentItem>>
        get() = repository.list


    fun refreshlist() {
        CoroutineScope(Dispatchers.Main).launch {
            repository.getStudents(standard)
        }
    }
}