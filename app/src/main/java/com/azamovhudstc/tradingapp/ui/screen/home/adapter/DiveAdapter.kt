package com.azamovhudstc.tradingapp.ui.screen.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azamovhudstc.tradingapp.data.DiveItem
import com.azamovhudstc.tradingapp.databinding.ItemHomeTypeBinding
import com.azamovhudstc.tradingapp.utils.setAnimation
import com.azamovhudstc.tradingapp.utils.setSlideIn

class DiveAdapter : RecyclerView.Adapter<DiveAdapter.DiveVh>() {
    private val list = ArrayList<DiveItem>()

    inner class DiveVh(private val binding: ItemHomeTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(diveItem: DiveItem) {
            binding.apply {
                setAnimation(binding.root.context, binding.root)
                binding.diveIcon.setImageResource(diveItem.imgFromRes)
                binding.diveTitle.text = diveItem.title
                binding.diveTitle.animation = setSlideIn()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiveVh {
        return DiveVh(
            ItemHomeTypeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DiveVh, position: Int) {
        holder.onBind(list.get(position))
    }

    fun submitList(newList: ArrayList<DiveItem>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}