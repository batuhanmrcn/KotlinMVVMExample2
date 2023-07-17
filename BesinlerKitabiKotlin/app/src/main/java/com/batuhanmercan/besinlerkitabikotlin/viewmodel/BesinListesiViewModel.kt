package com.batuhanmercan.besinlerkitabikotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.batuhanmercan.besinlerkitabikotlin.model.Besin

class BesinListesiViewModel : ViewModel() {
    val besinler = MutableLiveData<List<Besin>>()
    val besinHataMesaji = MutableLiveData<Boolean>()
    val besinYukleniyor = MutableLiveData<Boolean>()


    fun refreshData(){
        val muz = Besin("Muz","100","10","5","1","www.ss.com")
        val cilek = Besin("Çilek","100","10","5","1","www.ss.com")
        val elma = Besin("Elma","100","10","5","1","www.ss.com")

        val besinListesi = arrayListOf<Besin>(muz,cilek,elma)
        besinler.value = besinListesi
        besinHataMesaji.value = false
        besinYukleniyor.value = false

    }
}