package com.yeditepe.acm431section2.persistence

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StudentViewModel(val dao: StudentDAO): ViewModel(

) {

    private var _allStudents= MutableStateFlow(mutableListOf<Student>())
    val allStudents = _allStudents.asStateFlow()
    init{
         viewModelScope.launch {
              _allStudents.value = dao.getAllStud()
         }
    }
}