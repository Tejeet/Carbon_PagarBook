package com.example.pagarbook.Views.Activity

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pagarbook.DataNConstants.ConstantsNData
import com.example.pagarbook.Models.Language
import com.example.pagarbook.R
import com.example.pagarbook.Views.LanguageAdapter
import com.example.pagarbook.Views.Listner.LanguageSelectClickListner
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class LanguageSelect : AppCompatActivity(),LanguageSelectClickListner {


    var cn = ConstantsNData()
    lateinit var locale: Locale
    private var currentLanguage = "en"

    var listLang = mutableListOf<Language>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listLang.add(Language("हिन्दी", false, "HINDi"))
        listLang.add(Language("English", false, "ENGLISH"))
        listLang.add(Language("ગુજરાતી", false, "GUJRATI"))
        listLang.add(Language("Hinglish", false, "HINGLISH"))
        listLang.add(Language("मराठी", true, "MARATHI"))
        listLang.add(Language("தமிழ்", false, "KANNAD"))
        listLang.add(Language("বাঙালি", false, "TAMIL"))
        listLang.add(Language("ଓଡ଼ିଆ", false, "ORIA"))
        listLang.add(Language("ಕನ್ನಡ", false, "KERLA"))

        val adapter = LanguageAdapter(listLang, this)
        recyclerViewLanguage.layoutManager = GridLayoutManager(this, 2)
        recyclerViewLanguage.adapter = adapter

//        if(LanguageIsSelect.){

        BtContinueLang.setOnClickListener {
            val intent = Intent(this@LanguageSelect, AccountLogin::class.java)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
        finish()
    }

    override fun onLanguageSelect(language: Language) {
        cn.setLanguageKey(this,language.language)

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

        val intent = Intent(this@LanguageSelect, AccountLogin::class.java)
        intent.putExtra("LANG", language.languageCode)
        startActivity(intent)

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
