package com.batuhanmercan.besinlerkitabikotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.batuhanmercan.besinlerkitabikotlin.R
import com.batuhanmercan.besinlerkitabikotlin.model.Besin
import com.batuhanmercan.besinlerkitabikotlin.view.BesinListesiFragmentDirections
import kotlinx.android.synthetic.main.besin_recycler_row.view.isim
import kotlinx.android.synthetic.main.besin_recycler_row.view.kalori

class BesinRecyclerAdapter(val besinListesi : ArrayList<Besin>) : RecyclerView.Adapter<BesinRecyclerAdapter.BesinViewHolder>() {

    class BesinViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BesinViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.besin_recycler_row,parent,false)
        return BesinViewHolder(view)
    }

    override fun getItemCount(): Int {
        return besinListesi.size
    }

    override fun onBindViewHolder(holder: BesinViewHolder, position: Int) {
    holder.itemView.isim.text = besinListesi.get(position).besinIsim
        holder.itemView.kalori.text = besinListesi.get(position).besinKalori

        holder.itemView.setOnClickListener {
            val action = BesinListesiFragmentDirections.actionBesinListesiFragmentToBesinDetayiFragment(0)
                Navigation.findNavController(it)
                    .navigate(action)
        }
        //görsel kısmı eklenecek
    }

    fun besinListesiniGuncelle(yeniBesinListesi: List<Besin>){
        besinListesi.clear()
        besinListesi.addAll(besinListesi)
        notifyDataSetChanged()
    }

}