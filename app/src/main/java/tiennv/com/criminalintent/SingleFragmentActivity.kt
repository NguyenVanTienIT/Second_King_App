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

        setContentView(R.layout.activity_fragment)

        var fm : FragmentManager = supportFragmentManager

        var fragment : Fragment? = fm.findFragmentById(R.id.fragment_container)   // tìm kiếm xem có fragemnt nằm trong fragment_container

        if(fragment == null){
            fragment = createFragment()
            fm.beginTransaction().add(R.id.fragment_container,fragment).commit()
        }

    }

}