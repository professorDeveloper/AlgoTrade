package com.azamovhudstc.tradingapp.ui.screen.wallet.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azamovhudstc.tradingapp.data.DepositeItem
import com.azamovhudstc.tradingapp.data.TrendItem
import com.azamovhudstc.tradingapp.databinding.DepositeItemBinding
import com.azamovhudstc.tradingapp.databinding.TrendItemBinding
import com.azamovhudstc.tradingapp.utils.setAnimation
import com.azamovhudstc.tradingapp.utils.setStringColor

class DepositeAdapter : RecyclerView.Adapter<DepositeAdapter.TrendVh>() {

    private val list = ArrayList<DepositeItem>()

    inner class TrendVh(private val binding: DepositeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: DepositeItem) {
            binding.apply {

                setAnimation(binding.root.context, binding.root)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendVh {
        return TrendVh(DepositeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    fun submitList(newList: ArrayList<DepositeItem>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TrendVh, position: Int) {
        holder.onBind(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }
}