package tiennv.com.criminalintent

import java.util.*

/**
 * Created by suale on 3/10/18.
 */
class Crime {
    var mId : UUID ? = null
    var mTitle : String? =null
    var mDate : Date? = null
    var  mSoloved : Boolean? = null

     fun Crime(){
         mId = UUID.randomUUID()
         mDate = Date()
     }


}