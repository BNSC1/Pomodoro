package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class TextChangedListener(fragmentActivity: FragmentActivity) : TextWatcher {
    var view:View?=null
    var settings: SharedPreferences? = null
    var editor: Editor? = null
    var mContext:FragmentActivity?=null
    fun TextChangedListener(view:View){
        this.view=view
    }
    fun TextChangedListener(context: FragmentActivity){
        this.mContext=context
    }
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        // Inflate the layout for this fragment
        settings = mContext?.getSharedPreferences("Pomodoro Length", Context.MODE_PRIVATE)
    }

    override fun afterTextChanged(s: Editable?) {

    }
}
public class Util{}