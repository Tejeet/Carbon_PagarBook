package com.example.pagarbook.Views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pagarbook.Models.Language
import com.example.pagarbook.R
import com.example.pagarbook.Views.LanguageAdapter
import com.example.pagarbook.Views.Listner.LanguageSelectClickListner
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_sheet_language.view.*

class BottomSheetLanguageFragment:BottomSheetDialogFragment(), LanguageSelectClickListner {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_language,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var listLang = mutableListOf<Language>()
        listLang.add(Language("हिन्दी", false, "HINDi" ))
        listLang.add(Language("English",false, "ENGLISH"))
        listLang.add(Language("ગુજરાતી",false, "GUJRATI"))
        listLang.add(Language("Hinglish",false, "HINGLISH"))
        listLang.add(Language("मराठी",true, "MARATHI"))
        listLang.add(Language("தமிழ்",false, "KANNAD"))
        listLang.add(Language("বাঙালি",false, "TAMIL"))
        listLang.add(Language("ଓଡ଼ିଆ",false, "ORIA"))
        listLang.add(Language("ಕನ್ನಡ",false, "KERLA"))

        val adapter = LanguageAdapter(listLang,this)
        view.recyclerViewBottomsheet.layoutManager= GridLayoutManager(context,2)
        view.recyclerViewBottomsheet.adapter=adapter

    }

    override fun onLanguageSelect(language: Language) {

    }
}