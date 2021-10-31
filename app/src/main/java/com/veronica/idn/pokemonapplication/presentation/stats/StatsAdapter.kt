package com.veronica.idn.pokemonapplication.presentation.stats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.veronica.idn.pokemonapplication.R
import com.veronica.idn.pokemonapplication.databinding.ItemStatBinding
import com.veronica.idn.pokemonapplication.domain.entity.Stat


class StatsAdapter(private val items: MutableList<Stat>) :
    RecyclerView.Adapter<StatsAdapter.Holder>() {

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
            LayoutInflater.from(parent.context).inflate(R.layout.item_stat, parent, false)
        )

        private val binding = ItemStatBinding.bind(itemView)
        fun bind(item: Stat) {
            val name =
                item.name.replace("special", "s").replace("attack", "atk").replace("defense", "def")
                    .replace("speed", "spd")
                    .uppercase()
            binding.name.text = name
            "%03d".format(item.base).also { binding.base.text = it }
            binding.progress.progress = item.base
        }

    }
}