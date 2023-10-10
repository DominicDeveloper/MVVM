package com.asadbek.mvvmexample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.asadbek.mvvmexample.repository.MyDataRepository

class ViewModelFactory(private val myDataRepository: MyDataRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        if (modelClass.isAssignableFrom(MyViewmodel::class.java)){
            return MyViewmodel(myDataRepository) as T
        }
        throw IllegalArgumentException("Error")
    }
}