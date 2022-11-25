package com.example.gempaterkini.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gempaterkini.network.Gempaterkini
import com.example.infogempa.databinding.ListViewItemBinding

class GempaterkiniListAdapter(val clickListener: GempaterkiniListener) :
    ListAdapter<Gempaterkini, GempaterkiniListAdapter.GempaterkiniViewHolder>(DiffCallback) {

    class GempaterkiniViewHolder(
        var binding: ListViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: GempaterkiniListener, gempaterkini: Gempaterkini) {
            binding.gempaterkini = gempaterkini
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Gempaterkini>() {

        override fun areItemsTheSame(oldItem: Gempaterkini, newItem: Gempaterkini): Boolean {
            return oldItem.wilayah == newItem.wilayah
        }

        override fun areContentsTheSame(oldItem: Gempaterkini, newItem: Gempaterkini): Boolean {
            return oldItem.tanggal == newItem.tanggal && oldItem.potensi == newItem.potensi
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GempaterkiniViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GempaterkiniViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GempaterkiniViewHolder, position: Int) {
        val gempaterkini = getItem(position)
        holder.bind(clickListener, gempaterkini)
    }
}

class GempaterkiniListener(val clickListener: (gempaterkini: Gempaterkini) -> Unit) {
    fun onClick(gempaterkini: Gempaterkini) = clickListener(gempaterkini)
}
