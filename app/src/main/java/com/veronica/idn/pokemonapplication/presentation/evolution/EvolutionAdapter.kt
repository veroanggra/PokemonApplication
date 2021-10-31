package com.veronica.idn.pokemonapplication.presentation.evolution

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.veronica.idn.pokemonapplication.R
import com.veronica.idn.pokemonapplication.databinding.ItemEvolutionBinding
import com.veronica.idn.pokemonapplication.domain.entity.Evolution


class EvolutionAdapter(private val items: MutableList<Evolution>) :
    RecyclerView.Adapter<EvolutionAdapter.Holder>() {

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
            LayoutInflater.from(parent.context).inflate(R.layout.item_evolution, parent, false)
        )

        private val binding = ItemEvolutionBinding.bind(itemView)
        fun bind(item: Evolution) {
            Glide.with(itemView.context)
                .load(item.fromSprite)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.ivTypeStartEvolution)

            Glide.with(itemView.context)
                .load(item.toSprite)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.ivTypeFinalEvolution)

            binding.tvTypeStartEvolution.text = item.fromName
            binding.tvTypeFinalEvolution.text = item.toName
            binding.specs.text = item.triggerSpecs
        }

    }
}