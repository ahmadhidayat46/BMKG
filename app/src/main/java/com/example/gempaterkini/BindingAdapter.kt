package com.example.gempaterkini

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gempaterkini.network.Gempaterkini
import com.example.gempaterkini.ui.GempaterkiniApiStatus
import com.example.gempaterkini.ui.GempaterkiniListAdapter
import com.example.infogempa.R

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Gempaterkini>?) {
    val adapter = recyclerView.adapter as GempaterkiniListAdapter
    adapter.submitList(data)
}


@BindingAdapter("apiStatus")
fun bindstatus(statusImageView: ImageView, status: GempaterkiniApiStatus?) {
    when(status) {
       GempaterkiniApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loding_animation)
        }
       GempaterkiniApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        GempaterkiniApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        else -> throw IllegalStateException()
    }
}
