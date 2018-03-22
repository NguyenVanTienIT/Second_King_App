package tiennv.com.criminalintent

import android.support.v4.app.Fragment

/**
 * Created by Asus on 3/22/2018.
 */
class CrimeListActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment? {
       return CrimeListFragment()
    }

}