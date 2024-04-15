package com.azamovhudstc.tradingapp.ui.screen.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azamovhudstc.tradingapp.data.TrendItem
import com.azamovhudstc.tradingapp.databinding.TrendItemBinding
import com.azamovhudstc.tradingapp.utils.setAnimation
import com.azamovhudstc.tradingapp.utils.setStringColor

class TrendAdapter : RecyclerView.Adapter<TrendAdapter.TrendVh>() {

    private val list = ArrayList<TrendItem>()

    inner class TrendVh(private val binding: TrendItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: TrendItem) {
            binding.apply {
                binding.companyLogo.setImageResource(data.appLogo)
                binding.companyBalance.text = data.companyPrice
                binding.companyStatus.text = data.companyStatus
                binding.root.setStringColor(data.color)
                binding.companyName.text = data.companyName
                setAnimation(binding.root.context, binding.root)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendVh {
        return TrendVh(TrendItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    fun submitList(newList: ArrayList<TrendItem>) {
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