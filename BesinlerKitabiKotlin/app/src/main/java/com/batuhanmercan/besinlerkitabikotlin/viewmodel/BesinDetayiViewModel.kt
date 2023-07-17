package com.batuhanmercan.besinlerkitabikotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.batuhanmercan.besinlerkitabikotlin.model.Besin

class BesinDetayiViewModel : ViewModel() {
    val besinLiveData = MutableLiveData<Besin>()

    fun roomVerisiniAl(){
        val muz = Besin("Muz","100","10","5","1","www.ss.com")
        besinLiveData.value = muz
    }
}