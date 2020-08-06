package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class mTextWatcher(context: SettingsFragment) : TextWatcher {
    var pomodoroLength:EditText?=null;var breakLength:EditText?=null;var restLength:EditText?=null
    var mContext:Context?=SettingsFragment.getaContext()
    var context:SettingsFragment?=context
    var settings: SharedPreferences? = context.getSharedPreferences("settings",Context.MODE_PRIVATE)
    var editor: Editor? = settings?.edit()
    fun objects(pomodoroLength: EditText,breakLength:EditText,restLength:EditText,alertType: Spinner){

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        breakLength?.setText(pomodoroLength?.getText())
    }

    override fun afterTextChanged(s: Editable?) {

    }
}