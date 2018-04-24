package tiennv.com.criminalintent

import android.os.Bundle
import android.support.v4.app.Fragment

/**
 * Created by Asus on 3/22/2018.
 */
class CrimeListActivity : SingleFragmentActivity() {

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
    }

    override fun createFragment(): Fragment?
    {
       return CrimeListFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}