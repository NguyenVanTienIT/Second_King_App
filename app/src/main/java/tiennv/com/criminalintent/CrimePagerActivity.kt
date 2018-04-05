package tiennv.com.criminalintent

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import java.util.*

/**
 * Created by suale on 3/30/18.
 */
class CrimePagerActivity : AppCompatActivity() {

    var mViewPager : ViewPager? = null
    var mCrimes : ArrayList<Crime> ? =null


    companion object {
        final var EXTRA_CRIME_ID = "crimeId"

       public fun newIntent(context: Context , crimeId : UUID) : Intent?{
            var intent : Intent = Intent(context,CrimePagerActivity::class.java)
            intent.putExtra(EXTRA_CRIME_ID,crimeId)

           return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crime_pager)

        mViewPager = findViewById(R.id.crime_view_pager)
        mCrimes = CrimeLab.get(this)!!.getCrimes() as ArrayList<Crime>?

        var crime_id : UUID = intent.getSerializableExtra(EXTRA_CRIME_ID) as UUID



        var fragmentManager : FragmentManager = supportFragmentManager

        mViewPager!!.adapter = object: FragmentStatePagerAdapter(fragmentManager) {
            override fun getItem(position: Int): Fragment {
                var crime : Crime = mCrimes!!.get(position)
                return CrimeFragment.newInstance(crime.mId!!)!!
            }

            override fun getCount(): Int {
               return mCrimes!!.size
            }
        }

        for(i in mCrimes!!.indices){

            if(mCrimes!!.get(i).mId!!.equals(crime_id)){    // hien thi nhung fragment dung voi ID ma intent nhan duoc
                mViewPager!!.setCurrentItem(i)
                break;
            }

        }
    }

}