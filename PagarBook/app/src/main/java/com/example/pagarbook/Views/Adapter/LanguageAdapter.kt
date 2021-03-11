package com.example.pagarbook.Views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pagarbook.Models.Language
import com.example.pagarbook.R
import com.example.pagarbook.Views.Listner.LanguageSelectClickListner

class LanguageAdapter(var listLanguage: List<Language>, val listner: LanguageSelectClickListner) :
    RecyclerView.Adapter<LanguageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.langauge_item, parent, false)
        return LanguageViewHolder(view)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.mTvTitle.text = listLanguage[position].language
        holder.linearLayout.setOnClickListener {
            holder.radioBt.isChecked = true
            listner.onLanguageSelect(listLanguage[position])
        }

        holder.radioBt.isEnabled = listLanguage[position].isSelcted
    }

    override fun getItemCount(): Int {
        return listLanguage.size
    }



}

class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val mTvTitle: TextView =
        itemView.findViewById<TextView>(R.id.tvLanguage)
    val linearLayout: LinearLayout = itemView.findViewById(R.id.llLanguage)
    val radioBt: RadioButton = itemView.findViewById(R.id.LanguageIsSelect)

}
