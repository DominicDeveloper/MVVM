package com.asadbek.mvvmexample.model

class MyData {
    private val list = arrayOf("Kotlin","Java","Android")


    // suspend - vaqtincha bir soniyaga ishni kechiktirib turuvchi funktsiya
    // hisoblash yoki masovafiy foydalanish uchun ishlatiladi.
    suspend fun getData(index:Int):String = list[index]

    suspend fun getSize():Int = list.size
}