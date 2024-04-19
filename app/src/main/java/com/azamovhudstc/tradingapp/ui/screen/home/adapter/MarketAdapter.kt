package com.azamovhudstc.tradingapp.ui.screen.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azamovhudstc.tradingapp.R
import com.azamovhudstc.tradingapp.data.remote.response.Data
import com.azamovhudstc.tradingapp.databinding.MarketItemBinding
import com.azamovhudstc.tradingapp.tools.format
import com.azamovhudstc.tradingapp.utils.loadImage
import com.azamovhudstc.tradingapp.utils.setAnimation

class MarketAdapter : RecyclerView.Adapter<MarketAdapter.MarketVh>() {
    private val list = ArrayList<Data>()

    inner class MarketVh(private val binding: MarketItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun onBind(data: Data) {

            binding.apply {
                binding.coinLogo.loadImage("https://s2.coinmarketcap.com/static/img/coins/64x64/${data.id}.png")
                binding.coinData.text = data.name
                binding.coinName.text = data.symbol
                binding.priceCoin.text = "$ ${data.quote.USD.price.format(4)}"
                if (data.quote.USD.percent_change_24h < 0) {
                    binding.statusBg.setCardBackgroundColor(binding.root.context.getColor(R.color.redBasic))
                    binding.coinStatus.text =
                        "${data.quote.USD.percent_change_24h.format(2).toString()} %"
                } else {
                    binding.statusBg.setCardBackgroundColor(binding.root.context.getColor(R.color.greenBasic))
                    binding.coinStatus.text =
                        "+${data.quote.USD.percent_change_24h.format(2).toString()} %"
                }
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

    fun submitList(newList: ArrayList<Data>) {
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

