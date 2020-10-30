package com.yeqiu.jetpack

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

/**
 * @project：jetpackDemo
 * @author：小卷子
 * @date 2020/9/2
 * @describe：
 * @fix：
 */
class MainAdapter(private val data: List<MainActivity.ActivityData>) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return MainViewHolder(view)

    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.tvMainItem.text = data[position].name

        holder.tvMainItem.setOnClickListener {

            val intent = Intent(App.context, data[position].clazz)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            App.context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int {
        return data.size
    }


    class MainViewHolder(view: View) : ViewHolder(view) {

        val tvMainItem: TextView = view.findViewById<TextView>(R.id.tvMainItem)

    }


}