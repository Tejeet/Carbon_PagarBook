package com.example.pagarbook.Views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pagarbook.Models.Language
import com.example.pagarbook.R
import kotlinx.android.synthetic.main.langauge_item.view.*

class LanguageAdapter(var listLanguage: List<Language>) :
    RecyclerView.Adapter<LanguageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.langauge_item, parent, false)
        return LanguageViewHolder(view)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.setData(listLanguage.get(position))
    }

    override fun getItemCount(): Int {
        return listLanguage.size
    }

}

class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setData(language: Language) {
        itemView.tvLanguage.text = language.language
    }
}