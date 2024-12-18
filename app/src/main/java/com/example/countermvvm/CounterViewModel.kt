package com.example.countermvvm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel() : ViewModel() {
    private val _repository: CounterModel.CounterRepository = CounterModel.CounterRepository()
    private val _count = mutableStateOf(_repository.getCounter().count)
    //Expose the count as immutable state so we can save our data even screen is tilted
    val count: MutableState<Int> = _count

    fun Increment(){
        _repository.incrementCounter()
        _count.value = _repository.getCounter().count
    }
    fun decrement(){
        _repository.decrementCounter()
        _count.value =_repository.getCounter().count
    }


}