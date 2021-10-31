package com.veronica.idn.pokemonapplication.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.veronica.idn.pokemonapplication.R
import com.veronica.idn.pokemonapplication.databinding.ItemWeaknessBinding
import com.veronica.idn.pokemonapplication.domain.entity.Weakness


class WeaknessAdapter(private val items: MutableList<Weakness>) :
    RecyclerView.Adapter<WeaknessAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position])
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        constructor(parent: ViewGroup) : this(
            LayoutInflater.from(parent.context).inflate(R.layout.item_weakness, parent, false)
        )

        private val binding = ItemWeaknessBinding.bind(itemView)
        fun bind(item: Weakness) {
            Glide.with(itemView.context)
                .load(item.type.typeRes)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.type)

            binding.multiplier.text = item.multiplierLabel()
        }

    }
}