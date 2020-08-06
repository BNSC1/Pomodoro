package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class mTextWatcher(fragmentActivity: FragmentActivity) : TextWatcher {
    var view:View?=null
    var mContext:Context?=SettingsFragment.getaContext()
    var settings: SharedPreferences? = mContext?.getSharedPreferences("settings",Context.MODE_PRIVATE)
    var editor: Editor? = settings?.edit()
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }

    override fun afterTextChanged(s: Editable?) {

    }
}