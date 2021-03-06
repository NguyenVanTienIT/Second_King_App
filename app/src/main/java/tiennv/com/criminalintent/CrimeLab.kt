package tiennv.com.criminalintent

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import java.util.*

/**
 * Created by Asus on 3/15/2018.
 */
class CrimeLab(context: Context) {

    companion object {
        var sCrimeLab : CrimeLab? = null

        var mCrime : ArrayList<Crime>? = null   // mảng các đối tượng Crime

        var mContext : Context? = null
        var mDatabase : SQLiteDatabase? = null

        fun get(context : Context) : CrimeLab? {
            if(sCrimeLab == null){
                sCrimeLab = CrimeLab(context)
            }
            return sCrimeLab
        }
    }


    public fun getCrimes() : List<Crime>? {   // trả về 1 mảng các đối tượng
        return mCrime
    }

    public fun getCrime(id : UUID) : Crime?{    // lấy ra 1 đối tượng có id đã cho thuộc danh sách các đối tượng
        var i=0;
        for(i in mCrime!!.indices){
            if(mCrime!!.get(i).mId!!.equals(id))  {
                return mCrime!!.get(i)
            }
        }
        return  null
    }

    public fun addCrime(c : Crime){
        mCrime?.add(c)
    }


    init {    // hàm dựng này tạo mới 1 list các đố
        // i tượng

        mContext = context.applicationContext
        mDatabase = CrimeBaseHelper(mContext!!).writableDatabase

        mCrime = ArrayList<Crime>()

        /*for(i in 1..100){
            var crime : Crime = Crime()
            crime.mTitle = "Crime #" + i;
            crime.mSoloved = i % 2 == 0
            mCrime?.add(crime)
        }*/
    }

}