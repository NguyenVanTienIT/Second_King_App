package tiennv.com.criminalintent

import android.app.Activity
import android.support.v4.app.Fragment
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.*
import java.util.*

/**
 * Created by suale on 3/10/18.
 */
class CrimeFragment : android.support.v4.app.Fragment(){

    var mCrime : Crime? = null
    var mTitleField : EditText? = null
    var mDateButton : Button? = null
    var mSolvedCheckBox : CheckBox? = null

    companion object {

        final var ARG_CRIME_ID = "crime_id"
        final var DIALOG_DATE : String = "DialogDate"

        final var REQUEST_DATE : Int  = 1

        public fun newInstance(crimeId : UUID) : CrimeFragment?{
            var bundle : Bundle = Bundle()
            bundle.putSerializable(ARG_CRIME_ID,crimeId)
            var fragment : CrimeFragment = CrimeFragment()

            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  var id_Crime : UUID = activity.intent.getSerializableExtra(CrimeActivity.EXTRA_CRIME_ID) as UUID
       // mCrime = CrimeLab.get(activity)!!.getCrime(id_Crime)

        var crimeId : UUID = arguments.getSerializable(ARG_CRIME_ID) as UUID
        mCrime = CrimeLab.get(activity)!!.getCrime(crimeId)
    }

    fun returResult(){
        activity.setResult(Activity.RESULT_OK,null)
    }

     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode != Activity.RESULT_OK){
            return
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         super.onCreateView(inflater, container, savedInstanceState)
        var v : View = inflater!!.inflate(R.layout.activity_fragment_crime, container , false)



         // lay 1 doi tuong crimeLab lay ra 1 crime theo id

        mTitleField = v.findViewById(R.id.crime_title)

        mDateButton = v.findViewById(R.id.crime_date)

        mSolvedCheckBox = v.findViewById(R.id.crime_solved)

        if(mCrime !=null) {

            mTitleField!!.setText(mCrime!!.mTitle.toString())
            mDateButton!!.setText(mCrime!!.mDate.toString())
            if (mCrime!!.mSoloved == null) {
                mSolvedCheckBox!!.isChecked = false
            } else
                mSolvedCheckBox!!.isChecked = mCrime!!.mSoloved!!


        }




        mTitleField!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                  mCrime!!.mTitle = p0.toString()
                  
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        }
        )

        mDateButton!!.setText(mCrime!!.mDate.toString())
        //mDateButton!!.setEnabled(false);

        mDateButton!!.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                //var dialog : DatePickerFragment = DatePickerFragment()
                    var dialog : DatePickerFragment = DatePickerFragment.newInstance(mCrime!!.mDate!!) as DatePickerFragment

                    dialog.setTargetFragment(this@CrimeFragment, REQUEST_DATE)

                    dialog.show(fragmentManager, DIALOG_DATE)

            }
        })


        mSolvedCheckBox!!.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                mCrime!!.mSoloved = isChecked
            }


        })

        return v
    }

}


