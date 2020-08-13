package com.example.myapplication

import android.content.Context
import android.widget.Toast

object Message {
    @JvmStatic
    fun message(context: Context?, message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}