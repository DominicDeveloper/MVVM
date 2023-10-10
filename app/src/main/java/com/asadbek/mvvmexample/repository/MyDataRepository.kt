package com.asadbek.mvvmexample.repository

import com.asadbek.mvvmexample.model.MyData

class MyDataRepository(val myData: MyData) {

    suspend fun getData(index:Int) = myData.getData(index)

    suspend fun getSize() = myData.getSize()
}