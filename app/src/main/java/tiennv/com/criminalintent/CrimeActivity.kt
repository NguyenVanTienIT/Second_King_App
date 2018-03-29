package tiennv.com.criminalintent

import android.app.FragmentTransaction
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import java.util.*

class CrimeActivity : SingleFragmentActivity() {

    companion object {
       final var EXTRA_CRIME_ID : String = "Id Of Crime"

         fun newIntent(context: Context,crime_id : UUID): Intent{
            var itent : Intent = Intent(context,CrimeActivity::class.java)
            itent.putExtra(EXTRA_CRIME_ID,crime_id)
             return itent
        }

    }




    override fun createFragment(): Fragment? {
       return CrimeFragment()
    }

}
