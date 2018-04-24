package tiennv.com.criminalintent

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by suale on 4/24/18.
 */
class CrimeBaseHelper : SQLiteOpenHelper {

    companion object {

        var VERSION : Int = 1
        var DATABASE_NAME = "crimeBase.db"

    }


    constructor(context: Context) :  super(context, DATABASE_NAME, null, VERSION){

    }


    override fun onCreate(p0: SQLiteDatabase?) {

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }







}