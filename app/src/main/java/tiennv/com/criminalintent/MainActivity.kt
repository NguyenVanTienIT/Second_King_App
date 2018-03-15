package tiennv.com.criminalintent

import android.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fm : FragmentManager = supportFragmentManager

        var fragment : Fragment? = fm.findFragmentById(R.id.fragment_container)

        if(fragment == null){
            fragment = CrimeFragment()
            var fragmentTransaction : android.support.v4.app.FragmentTransaction? = fm.beginTransaction()
            fragmentTransaction!!.add(R.id.fragment_container,fragment)
            fragmentTransaction!!.commit()
        }
    }
}
