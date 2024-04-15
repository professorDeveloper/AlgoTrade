package com.azamovhudstc.tradingapp.ui.screen.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azamovhudstc.tradingapp.data.MarketItem
import com.azamovhudstc.tradingapp.databinding.MarketItemBinding
import com.azamovhudstc.tradingapp.utils.setAnimation

class MarketAdapter : RecyclerView.Adapter<MarketAdapter.MarketVh>() {
    private val list = ArrayList<MarketItem>()

    inner class MarketVh(private val binding: MarketItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: MarketItem) {

            binding.apply {
                binding.coinLogo.setImageResource(data.icon)
                binding.coinData.text = data.titleDesc
                binding.coinName.text = data.title
                binding.priceCoin.text = data.price
                binding.coinStatus.text = data.status
                setAnimation(binding.root.context, binding.root)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketVh {
        return MarketVh(
            MarketItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun submitList(newList: ArrayList<MarketItem>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MarketVh, position: Int) {
        holder.onBind(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }
}