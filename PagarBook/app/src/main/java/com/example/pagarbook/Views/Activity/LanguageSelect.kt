package com.example.pagarbook.Views.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pagarbook.Models.Language
import com.example.pagarbook.R
import com.example.pagarbook.Views.LanguageAdapter
import com.example.pagarbook.Views.Listner.RadioButtonListner
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.langauge_item.*

class LanguageSelect : AppCompatActivity(),RadioButtonListner {

    var listLang= mutableListOf<Language>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listLang.add(Language("हिन्दी"))
        listLang.add(Language("English"))
        listLang.add(Language("ગુજરાતી"))
        listLang.add(Language("Hinglish"))
        listLang.add(Language("मराठी"))
        listLang.add(Language("தமிழ்"))
        listLang.add(Language("বাঙালি"))
        listLang.add(Language("ଓଡ଼ିଆ"))
        listLang.add(Language("ಕನ್ನಡ"))

        val adapter =LanguageAdapter(listLang,this)
        recyclerViewLanguage.layoutManager=GridLayoutManager(this,2)
        recyclerViewLanguage.adapter=adapter

//        if(LanguageIsSelect.){

    }

    override fun onBackPressed() {
        finish()
    }

    override fun ButtonPress(language: Language) {
        BtContinueLang.setOnClickListener {
            val intent=Intent(this@LanguageSelect, AccountLogin::class.java)
            startActivity(intent)
        }
    }
}