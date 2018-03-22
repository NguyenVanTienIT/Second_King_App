package tiennv.com.criminalintent

import android.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

class CrimeActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment? {
       return CrimeFragment()
    }


}
