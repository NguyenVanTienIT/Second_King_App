package tiennv.com.criminalintent

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity

/**
 * Created by Asus on 3/22/2018.
 */
 abstract class SingleFragmentActivity : AppCompatActivity() {

   public abstract fun  createFragment() : Fragment?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fragment_crime)

        var fm : FragmentManager = supportFragmentManager

        var fragment : Fragment? = fm.findFragmentById(R.id.fragment_container)

        if(fragment == null){
            fragment = CrimeFragment()
            var fragmentTransaction : android.support.v4.app.FragmentTransaction? = fm.beginTransaction()
            fragmentTransaction?.add(R.id.fragment_container,fragment)
            fragmentTransaction?.commit()
        }

    }

}