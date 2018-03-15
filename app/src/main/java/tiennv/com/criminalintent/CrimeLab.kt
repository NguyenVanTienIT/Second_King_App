package tiennv.com.criminalintent

import android.content.Context

/**
 * Created by Asus on 3/15/2018.
 */
class CrimeLab {

    companion object {
        var sCrimeLab : CrimeLab? = null

        fun get(context : Context) : CrimeLab? {
            if(sCrimeLab == null){
                sCrimeLab = CrimeLab(context)
            }

            return sCrimeLab
        }


        fun CrimeLab(context : Context): CrimeLab? {
            return null
        }
    }

}