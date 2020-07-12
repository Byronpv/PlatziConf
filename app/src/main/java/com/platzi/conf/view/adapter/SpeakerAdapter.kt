package com.platzi.conf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.platzi.conf.R
import com.platzi.conf.model.Speaker

class SpeakerAdapter(val speakerListener: SpeakerListener) : RecyclerView.Adapter<SpeakerAdapter.ViewHolderSpeaker>() {

    val listSpeaker = ArrayList<Speaker> ()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolderSpeaker(LayoutInflater.from(parent.context).inflate((R.layout.item_speaker),parent, false))


    override fun getItemCount()= listSpeaker.size

    override fun onBindViewHolder(holder: ViewHolderSpeaker, position: Int) {
        val speaker = listSpeaker[position]
        holder.tvNameSpeaker.text = speaker.name
        holder.tvJobTitleSpeaker.text = speaker.workplace

        Glide.with(holder.itemView.context)
            .load(speaker.image)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.ivImageSpeaker)

        holder.itemView.setOnClickListener {
            speakerListener.onSpeakerClick(speaker, position)
        }

    }

    fun updateData(data: List<Speaker>){
        listSpeaker.clear()
        listSpeaker.addAll(data)
        notifyDataSetChanged()
    }
    class ViewHolderSpeaker(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ivImageSpeaker = itemView.findViewById<ImageView>(R.id.ivImageSpeaker)
        val tvNameSpeaker = itemView.findViewById<TextView>(R.id.tvSpeakerName)
        val tvJobTitleSpeaker = itemView.findViewById<TextView>(R.id.tvJobTitleSpeaker)


    }

}