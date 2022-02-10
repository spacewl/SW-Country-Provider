package com.spacewl.countryprovider

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.spacewl.countryprovider.databinding.ItemCountryBinding

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.VH>() {
    private val items: MutableList<Country> = mutableListOf()

    fun replace(items: List<Country>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            binding = ItemCountryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        with(holder) {
            fill(item)
        }
    }

    override fun getItemCount(): Int = items.size

    class VH(val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun fill(item: Country) {
            with(binding) {
                ivFlag.setImageResource(item.flagIcon)
                tvName.text = item.name
                tvCode.text = item.dialCode
            }
        }
    }
}