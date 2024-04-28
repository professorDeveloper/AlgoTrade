package com.azamovhudstc.tradingapp.ui.screen.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azamovhudstc.tradingapp.R
import com.azamovhudstc.tradingapp.data.remote.response.stock.DataX
import com.azamovhudstc.tradingapp.databinding.TrendItemBinding
import com.azamovhudstc.tradingapp.utils.createLetterAvatar
import com.azamovhudstc.tradingapp.utils.setAnimation

class TrendAdapter : RecyclerView.Adapter<TrendAdapter.TrendVh>() {

    private val list = ArrayList<DataX>()

    inner class TrendVh(private val binding: TrendItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun onBind(data: DataX) {
            binding.apply {
                val letter = data.n.get(0)
                val drawableLogo = createLetterAvatar(binding.root.context, letter.toString(), 55)
                binding.companyLogo.setImageDrawable(drawableLogo)
//                binding.companyBalance.text = data.companyPrice
//                binding.companyStatus.text = data.companyStatus
                if (data.change>0){
                    binding.root.setCardBackgroundColor(binding.root.context.getColor(R.color.basic_color))
                }else {
                    binding.root.setCardBackgroundColor(binding.root.context.getColor(R.color.redBasic))

                }
                binding.companyName.text = data.s
                binding.companyBalance.text = data.price.toString()
                binding.companyStatus.text = "${data.change} %"

                setAnimation(binding.root.context, binding.root)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendVh {
        return TrendVh(TrendItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    fun submitList(newList: ArrayList<DataX>) {
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