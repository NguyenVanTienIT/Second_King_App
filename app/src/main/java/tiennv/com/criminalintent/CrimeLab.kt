package tiennv.com.criminalintent

import android.content.Context
import java.util.*

/**
 * Created by Asus on 3/15/2018.
 */
class CrimeLab(context: Context) {

    companion object {
        var sCrimeLab : CrimeLab? = null

        var mCrime : List<Crime>? = null

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

    public fun getCrime(id : UUID) : Crime?{    // lấy ra 1 đối tượng thuộc danh sách các đối tượng
        var i=0;
        for(i in mCrime!!.indices){
            if(mCrime!!.get(i).equals(id))  return mCrime!!.get(i)
        }
        return  null
    }


    init {    // hàm dựng này tạo mới 1 list các đối tượng
        mCrime = ArrayList<Crime>()
    }

}