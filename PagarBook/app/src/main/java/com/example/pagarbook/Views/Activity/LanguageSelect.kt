package com.example.pagarbook.Views.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pagarbook.Models.Language
import com.example.pagarbook.R
import com.example.pagarbook.Views.LanguageAdapter
import com.example.pagarbook.Views.Listner.LanguageSelectClickListner
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.langauge_item.*

class LanguageSelect : AppCompatActivity(),LanguageSelectClickListner {

    var listLang= mutableListOf<Language>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listLang.add(Language("हिन्दी", false, "HINDi" ))
        listLang.add(Language("English",false, "ENGLISH"))
        listLang.add(Language("ગુજરાતી",false, "GUJRATI"))
        listLang.add(Language("Hinglish",false, "HINGLISH"))
        listLang.add(Language("मराठी",true, "MARATHI"))
        listLang.add(Language("தமிழ்",false, "KANNAD"))
        listLang.add(Language("বাঙালি",false, "TAMIL"))
        listLang.add(Language("ଓଡ଼ିଆ",false, "ORIA"))
        listLang.add(Language("ಕನ್ನಡ",false, "KERLA"))

        val adapter =LanguageAdapter(listLang,this)
        recyclerViewLanguage.layoutManager=GridLayoutManager(this,2)
        recyclerViewLanguage.adapter=adapter

//        if(LanguageIsSelect.){

        BtContinueLang.setOnClickListener {
            val intent=Intent(this@LanguageSelect, AccountLogin::class.java)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
        finish()
    }

    override fun onLanguageSelect(language: Language) {

        val intent=Intent(this@LanguageSelect, AccountLogin::class.java)
        intent.putExtra("LANG", language.languageCode)
        startActivity(intent)

    }

}