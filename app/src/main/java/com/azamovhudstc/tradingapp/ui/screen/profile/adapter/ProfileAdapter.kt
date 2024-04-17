package com.azamovhudstc.tradingapp.ui.screen.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azamovhudstc.tradingapp.data.ProfileItem
import com.azamovhudstc.tradingapp.databinding.ProfileItemBinding
import com.azamovhudstc.tradingapp.utils.setAnimation

class ProfileAdapter : RecyclerView.Adapter<ProfileAdapter.ProfileVh>() {

    private val list = ArrayList<ProfileItem>()


    fun submitList(newList: ArrayList<ProfileItem>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class ProfileVh(private val binding: ProfileItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: ProfileItem) {
            binding.apply {
                setAnimation(binding.root.context, binding.root)
                shapeableImageView4.setImageResource(data.icon)
                textView6.text = data.itemTitle
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileVh {
        return ProfileVh(
            ProfileItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProfileVh, position: Int) {
        holder.onBind(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }
}