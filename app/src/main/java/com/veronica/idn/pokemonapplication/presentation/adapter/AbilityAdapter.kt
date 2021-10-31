package com.veronica.idn.pokemonapplication.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.veronica.idn.pokemonapplication.R
import com.veronica.idn.pokemonapplication.databinding.ItemAbilityBinding
import com.veronica.idn.pokemonapplication.domain.entity.Ability


class AbilityAdapter(private val items: MutableList<Ability>) :
    RecyclerView.Adapter<AbilityAdapter.Holder>() {

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
            LayoutInflater.from(parent.context).inflate(R.layout.item_ability, parent, false)
        )

        private val binding = ItemAbilityBinding.bind(itemView)
        fun bind(item: Ability) {
            binding.tvNameItemAbility.text = item.name
            binding.tvFlavorItemAbility.text = item.flavorText
            val drawable = if (item.isHidden) R.drawable.ic_hidden_20 else 0
            binding.tvNameItemAbility.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0)
        }

    }
}