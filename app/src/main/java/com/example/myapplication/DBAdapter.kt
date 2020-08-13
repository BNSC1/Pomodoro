package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.myapplication.Message.message
import java.text.SimpleDateFormat
import java.util.*

class DBAdapter(context: Context) {
    private var myhelper: myDbHelper
    fun insertData(date: String?): Long {
        val dbb = myhelper.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(myDbHelper.POMODOROCOUNT, 1)
        contentValues.put(myDbHelper.DATE, date)
        return dbb.insert(myDbHelper.TABLE_NAME, null, contentValues)
    }

    fun getData(date:String): String{
            val db = myhelper.writableDatabase
            val columns = arrayOf(myDbHelper.DATE, myDbHelper.POMODOROCOUNT)
            val cursor = db.rawQuery("SELECT "+ myDbHelper.POMODOROCOUNT + " FROM " + myDbHelper.TABLE_NAME,null)
            val buffer = StringBuffer()
            var pomodoroCount: String =""
            while (cursor.moveToNext()) {
//                val date= cursor.getString(cursor.getColumnIndex(myDbHelper.DATE))
                pomodoroCount = cursor.getString(cursor.getColumnIndex(myDbHelper.POMODOROCOUNT))
//                buffer.append("$pomodoroCount")
//                Log.v("db","Append data?")
            }
            cursor.close()
            db.close()
//            return buffer.toString()
        return pomodoroCount
        }

    fun delete(uname: String): Int {
        val db = myhelper.writableDatabase
        val whereArgs = arrayOf(uname)
        return db.delete(myDbHelper.TABLE_NAME, myDbHelper.POMODOROCOUNT + " = ?", whereArgs)
    }

    fun updateData(date: String, pomodoroCount: String?): Int {

        val db = myhelper.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(myDbHelper.POMODOROCOUNT, pomodoroCount)
        contentValues.put(myDbHelper.DATE,date)
//        val whereArgs = arrayOf(oldName)
        return db.update(myDbHelper.TABLE_NAME, contentValues, myDbHelper.DATE + " = ?", arrayOf(date))
    }

    internal class myDbHelper(private val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_Version) {
        override fun onCreate(db: SQLiteDatabase) {
            try {
                db.execSQL(CREATE_TABLE)
            } catch (e: Exception) {
                message(context, "" + e)
            }
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            try {
                message(context, "OnUpgrade")
                db.execSQL(DROP_TABLE)
                onCreate(db)
            } catch (e: Exception) {
                message(context, "" + e)
            }
        }

        companion object {
            private const val DATABASE_NAME = "Pomodoro_DB" // Database Name
            internal const val TABLE_NAME = "Pomodoro_Table" // Table Name
            private const val DATABASE_Version = 1 // Database Version
//            internal const val UID = "_id" // Column I (Primary Key)
            internal const val DATE= "Date"
//            internal val FormatDate=SimpleDateFormat("YYYY-MM-DD")
            internal const val POMODOROCOUNT = "PomodoroCount" //Column II
            private const val CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
                    " (" +
                    DATE + " DATE NOT NULL, " + POMODOROCOUNT + " SMALLINT DEFAULT 0 NOT NULL" +
                    ");"
            private const val DROP_TABLE = "DROP TABLE IF EXISTS '$TABLE_NAME';"
        }

    }

    init {
        myhelper = myDbHelper(context)
    }
}