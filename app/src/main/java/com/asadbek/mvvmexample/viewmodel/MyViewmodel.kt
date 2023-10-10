package com.asadbek.mvvmexample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asadbek.mvvmexample.repository.MyDataRepository
import com.asadbek.mvvmexample.utils.Resource
import kotlinx.coroutines.launch

class MyViewmodel(val myDataRepository: MyDataRepository):ViewModel() {

    private val liveData = MutableLiveData<Resource<String>>()

    init {
        randomString()
    }

    fun randomString(indexString:String? = null) {
        viewModelScope.launch{
            try {
                var index:Int? = -1
                if (indexString == null) {
                    index = null
                }else {
                    index = indexString?.toInt()
                }

                if (index == null){
                    liveData.postValue(Resource.loading(null))
                }else{
                    if (index >= 0 && index < myDataRepository.getSize()){
                        liveData.postValue(Resource.success(myDataRepository.getData(index)))
                    }else{
                        liveData.postValue(Resource.error("Kiritilgan raqamdagi qiymat topilmadi",null))
                    }
                }
            }catch (e:Exception){
                liveData.postValue(Resource.error("Raqam kiriting",null))
            }

        }
    }
    fun getLiveData() = liveData

}