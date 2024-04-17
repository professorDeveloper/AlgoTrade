package com.azamovhudstc.tradingapp.ui.screen.coin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azamovhudstc.tradingapp.data.CoinItem
import com.azamovhudstc.tradingapp.databinding.CoinHorizontalItemBinding
import com.azamovhudstc.tradingapp.utils.setAnimation

class CoinAdapter : RecyclerView.Adapter<CoinAdapter.CoinVh>() {
    private val list = ArrayList<CoinItem>()


    fun submitList(newList: ArrayList<CoinItem>) {
        list.clear()
        list.addAll(newList)
    }

    inner class CoinVh(private val binding: CoinHorizontalItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: CoinItem) {
            binding.apply {
                setAnimation(binding.root.context, binding.root)
                balance.text = data.balance
                dateTxt.text = data.date
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinVh {
        return CoinVh(
            CoinHorizontalItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CoinVh, position: Int) {
        holder.onBind(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }
}