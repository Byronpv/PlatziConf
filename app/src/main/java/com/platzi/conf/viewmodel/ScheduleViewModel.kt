package com.platzi.conf.viewmodel

import androidx.lifecycle.MutableLiveData
import com.platzi.conf.model.Speaker
import com.platzi.conf.network.Callback
import com.platzi.conf.network.FirestoreServices
import java.lang.Exception

class ScheduleViewModel {

    val firestoreServices = FirestoreServices ();
    var listSchedule: MutableLiveData<List<Speaker>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getSheduleFromFirebase()
    }

      private fun getSheduleFromFirebase() {
        firestoreServices.getSchedule(object : Callback<List<Speaker>> {
            override fun OnSucess(result: List<Speaker>?) {
                listSchedule.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                super.onFailed(exception)
                processFinished()
            }
        })
    }
      fun processFinished() {
        isLoading.value=true
    }

}