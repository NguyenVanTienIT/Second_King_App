package tiennv.com.criminalintent


import android.app.Activity
import android.app.PendingIntent
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.*
import android.widget.*
import tiennv.com.criminalintent.CrimeLab.Companion.mCrime
import tiennv.com.criminalintent.CrimeLab.Companion.sCrimeLab

/**
 * Created by Asus on 3/22/2018.
 */
   class CrimeListFragment : Fragment() {
    var mCrimeRecyclerView : RecyclerView? = null
    var mAdapter : CrimeAdapter? = null
    var mSubtitleVisible : Boolean = true

    companion object {
        final var REQUEST_CRIME = 1
        final var SAVE_SUBTITLE_VISIBLE = "subtitle"
    }

    override  fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mSubtitleVisible = true
        if(savedInstanceState != null){
            mSubtitleVisible = savedInstanceState.getBoolean(SAVE_SUBTITLE_VISIBLE)
        }

        setHasOptionsMenu(true)

        var view : View = inflater!!.inflate(R.layout.fragment_crime_list, container, false)

        mCrimeRecyclerView =  view.findViewById(R.id.crime_recycler_view)

        mCrimeRecyclerView?.layoutManager = LinearLayoutManager(getActivity())

        updateUI()

        return  view

    }

    override fun onResume() {
        super.onResume()
        updateUI()
    }



    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater!!.inflate(R.menu.fragment_crime_list,menu)
        var subtitleItem : MenuItem = menu!!.findItem(R.id.show_subtitle)
        if(!mSubtitleVisible){
            subtitleItem.setTitle(R.string.hide_subtitle)
        }
        else{
            subtitleItem.setTitle(R.string.show_subtitle)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.new_crime -> {
                var crime :  Crime = Crime()
                CrimeLab.get(activity)?.addCrime(crime)
                var intent : Intent = CrimePagerActivity?.newIntent(activity, crime?.mId!!)!!
                startActivity(intent)
                return true
            }
            R.id.show_subtitle -> {
                mSubtitleVisible = !mSubtitleVisible
                activity.invalidateOptionsMenu()
                updateSubtitle()
                return true
            }
            else -> return false
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putBoolean(SAVE_SUBTITLE_VISIBLE, mSubtitleVisible)
    }


    public fun updateSubtitle(){
        var crimeLab : CrimeLab = CrimeLab.get(activity)!!
        var crimeCount = crimeLab.getCrimes()?.size
        var subtitle = getString(R.string.subtitle_format, crimeCount)


        if(!mSubtitleVisible){
            subtitle = null
        }

        var activity : AppCompatActivity = getActivity() as AppCompatActivity
        activity.supportActionBar?.setSubtitle(subtitle)

    }


    fun updateUI(){
        var  crimeLab : CrimeLab = CrimeLab.get(getActivity())!!
        var crimes : ArrayList<Crime> = crimeLab.getCrimes() as ArrayList<Crime>

        if(mAdapter == null) {

            mAdapter = CrimeAdapter(crimes)
            mCrimeRecyclerView?.adapter = mAdapter
        }
        else{
            mAdapter!!.notifyDataSetChanged()
        }

        updateSubtitle()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CRIME){

        }

    }



   inner class CrimeHolder(inflater : LayoutInflater,parent : ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_crime,parent,false)), View.OnClickListener{

            var mTitleTextView : TextView? = null
            var mDateTextView : TextView? = null
            var mCrime : Crime? = null
            var mSolovedImageView : ImageView? = null

        init {
            mTitleTextView = itemView.findViewById(R.id.crime_title)
            mDateTextView = itemView.findViewById(R.id.crime_date)
            mSolovedImageView = itemView.findViewById(R.id.crime_solved)
            itemView.setOnClickListener(this)
        }

        fun bind(crime : Crime){
            mCrime = crime
            mTitleTextView!!.setText(mCrime!!.mTitle)
            mDateTextView!!.setText(mCrime!!.mDate.toString())
            if(mCrime!!.mSoloved == false)
            mSolovedImageView!!.visibility = View.VISIBLE
            else mSolovedImageView!!.visibility = View.GONE
        }


        override fun onClick(v: View?) {
            //Toast.makeText(activity,mCrime!!.mTitle+" clicked!",Toast.LENGTH_SHORT).show()
            //var itent :  Intent? = Intent(getActivity(),CrimeActivity::class.java)
            //var intent : Intent? = CrimeActivity.newIntent(getActivity(), mCrime!!.mId!!)
            var intent : Intent? = CrimePagerActivity.newIntent(getActivity(), mCrime!!.mId!!)
            startActivityForResult(intent, REQUEST_CRIME)
            //Log.d("itent","intent da tao")
        }

    }


   inner class CrimeAdapter(crimes : ArrayList<Crime>) : RecyclerView.Adapter<CrimeHolder>(){     // custom Arraylist tương tự trong listview

        var mCrime : ArrayList<Crime>? = null


        init {
            mCrime = crimes
        }

        override fun onBindViewHolder(holder: CrimeHolder?, position: Int) {
            var crime = mCrime!![position]

            holder!!.bind(crime)

        }

        override fun getItemCount(): Int {
            return mCrime!!.size
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {

            var layoutInflater : LayoutInflater = LayoutInflater.from(getActivity())

            return CrimeHolder(layoutInflater, parent)

        }

    }

}

