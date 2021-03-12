package com.example.pagarbook.Views.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pagarbook.DataNConstants.ConstantsNData
import com.example.pagarbook.Models.Language
import com.example.pagarbook.R
import com.example.pagarbook.Views.Activity.AccountLogin
import com.example.pagarbook.Views.Activity.DashboardActivity
import com.example.pagarbook.Views.LanguageAdapter
import com.example.pagarbook.Views.Listner.LanguageSelectClickListner
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_sheet_language.view.*
import java.util.*

class BottomSheetLanguageFragment:BottomSheetDialogFragment(), LanguageSelectClickListner {

    var cn = ConstantsNData()
    lateinit var locale: Locale


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
        cn.setLanguageKey(context,language.language)
        when (language.languageCode) {
            "HINDi" -> setLocale("hi")
            "ENGLISH"-> setLocale("en")
            "GUJRATI" -> setLocale("gu")
            "HINGLISH" -> setLocale("en-rGB")
            "MARATHI" -> setLocale("mr")
            "KANNAD" -> setLocale("kn")
            "TAMIL" -> setLocale("ta")
            "ORIA" -> setLocale("or")
            "KERLA" -> setLocale("kn")
        }
           startActivity(Intent(context,DashboardActivity::class.java))
        }
    private fun setLocale(localeName: String) {

            locale = Locale(localeName)
            val res = resources
            val dm = res.displayMetrics
            val conf = res.configuration
            conf.locale = locale
            res.updateConfiguration(conf, dm)

    }


    }
