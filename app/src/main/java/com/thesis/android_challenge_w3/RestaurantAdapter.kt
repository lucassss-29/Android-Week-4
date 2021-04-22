package com.thesis.android_challenge_w3

import android.renderscript.Script
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RestaurantAdapter:RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

//    private lateinit var mLayoutManager : GridLayoutManager
    private lateinit var view : View
    private val LIST_ITEM = 0
    private val GRID_ITEM = 1
    var isSwitchView : Boolean = true

    var data:List<Restaurant> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        if (viewType == LIST_ITEM)
        {
            view = layoutInflater.inflate(R.layout.restaurant_item_view, parent, false)
        } else {
            view = layoutInflater.inflate(R.layout.restaurant_grid_view, parent, false)
        }
        return ViewHolder(view)
    }

    fun toggleItemViewType():Boolean{
        isSwitchView = !isSwitchView
        return isSwitchView
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.tvResName.text = item.name
        holder.tvResAddress.text = item.address
        holder.imgAvatar.setImageResource(item.avatar)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
//        return if (mLayoutManager?.spanCount == 1) ViewType.LIST.ordinal
//        else ViewType.GRID.ordinal
        if (isSwitchView){
            return LIST_ITEM
        } else {
            return GRID_ITEM
        }
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val tvResName = itemView.findViewById<TextView>(R.id.tvResName)
        val tvResAddress = itemView.findViewById<TextView>(R.id.tvResAddress)
        val imgAvatar = itemView.findViewById<ImageView>(R.id.imageView)
    }



}