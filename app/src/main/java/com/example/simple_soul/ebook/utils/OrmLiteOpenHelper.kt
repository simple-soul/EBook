package com.example.simple_soul.ebook.utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.support.ConnectionSource

const val DB_NAME = "EBook"

class OrmLiteOpenHelper(context: Context, databaseName: String, factory: SQLiteDatabase.CursorFactory? = null, databaseVersion: Int):OrmLiteSqliteOpenHelper(context, databaseName, factory, databaseVersion) {

    override fun onCreate(database: SQLiteDatabase?, connectionSource: ConnectionSource?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun onUpgrade(database: SQLiteDatabase?, connectionSource: ConnectionSource?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

}
