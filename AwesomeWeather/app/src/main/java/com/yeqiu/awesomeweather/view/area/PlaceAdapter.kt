package com.yeqiu.awesomeweather.view.area

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yeqiu.awesomeweather.R
import com.yeqiu.awesomeweather.data.model.Place

/**
 * @project：AwesomeWeather
 * @author：小卷子
 * @date 2020/10/13
 * @describe：
 * @fix：
 */
class PlaceAdapter(private val places: List<Place>) :
    RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val placeName: TextView = view.findViewById(R.id.placeName)
        val placeAddress: TextView = view.findViewById(R.id.placeAddress)
    }


    private var listener: (Int) -> Unit = {}


    fun setListener(listener: (Int) -> Unit) {
        this.listener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_place, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = places[position]
        holder.placeName.text = place.name
        holder.placeAddress.text = place.address

        holder.placeName.setOnClickListener {
            //高阶函数
            listener(position)
        }


    }

    override fun getItemCount(): Int = places.size
}