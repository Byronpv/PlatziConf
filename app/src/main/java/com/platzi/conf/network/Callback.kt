package com.platzi.conf.network

import java.lang.Exception

interface Callback<T> {

    fun OnSucess (result: T?){}
    fun onFailed(exception: Exception){}
}