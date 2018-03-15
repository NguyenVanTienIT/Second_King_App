package tiennv.com.criminalintent

import android.app.Fragment
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.*

/**
 * Created by suale on 3/10/18.
 */
class CrimeFragment : android.support.v4.app.Fragment(){

    var mCrime : Crime? = null
    var mTitleField : EditText? = null
    var mDateButton : Button? = null
    var mSolvedCheckBox : CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mCrime = Crime()

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        var v : View = inflater!!.inflate(R.layout.activity_fragment_crime, container , false)
        mTitleField = v.findViewById(R.id.crime_title)
        mDateButton = v.findViewById(R.id.crime_date)
        mSolvedCheckBox = v.findViewById(R.id.crime_solved)


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
        mDateButton!!.setEnabled(false);

        mSolvedCheckBox!!.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                mCrime!!.mSoloved = isChecked
            }


        })



        return v
    }

}