package com.batuhanmercan.besinlerkitabikotlin.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import com.batuhanmercan.besinlerkitabikotlin.BesinDetayiFragmentArgs
import com.batuhanmercan.besinlerkitabikotlin.R
import com.batuhanmercan.besinlerkitabikotlin.viewmodel.BesinDetayiViewModel
import kotlinx.android.synthetic.main.activity_main.fragment
import kotlinx.android.synthetic.main.fragment_besin_detayi.besinIsim
import kotlinx.android.synthetic.main.fragment_besin_detayi.besinKalori
import kotlinx.android.synthetic.main.fragment_besin_detayi.besinKarbonhidrat
import kotlinx.android.synthetic.main.fragment_besin_detayi.besinProtein
import kotlinx.android.synthetic.main.fragment_besin_detayi.besinYag


class BesinDetayiFragment : Fragment() {
private var besinId = 0
    private lateinit var viewModel : BesinDetayiViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_besin_detayi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get()
        viewModel.roomVerisiniAl()

        arguments?.let {
        besinId = BesinDetayiFragmentArgs.fromBundle(it).besinId
        }
        observeLiveData()
    }

    fun observeLiveData(){
        viewModel.besinLiveData.observe(viewLifecycleOwner, Observer {besin->
            besin?.let {
                besinIsim.text = it.besinIsim
                besinProtein.text = it.besinProtein
                besinKarbonhidrat.text = it.besinKarbonhidrat
                besinYag.text = it.besinYag
                besinKalori.text = it.besinKalori
            }
        })
    }
}