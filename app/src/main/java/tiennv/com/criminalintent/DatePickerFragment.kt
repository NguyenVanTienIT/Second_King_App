package tiennv.com.criminalintent

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.widget.DatePicker
import java.util.*

/**
 * Created by Asus on 4/4/2018.
 */
class DatePickerFragment() : DialogFragment() {

    companion object {
        final var ARG_DATE = "date"
        final var EXTRA_DATE = "gui du lieu date"

        fun newInstance(date : Date) : Fragment? {
            var args :  Bundle = Bundle()
            args.putSerializable(ARG_DATE, date)

            var fragment : DatePickerFragment = DatePickerFragment()
            fragment.arguments = args

            return fragment
        }
    }
    var mDataPiker : DatePicker? =null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var date : Date = arguments.getSerializable(ARG_DATE) as Date

        var calendar : Calendar = Calendar.getInstance()
        calendar.time = date

        var year = calendar.get(Calendar.YEAR)

        var month = calendar.get(Calendar.MONTH)

        var day =  calendar.get(Calendar.DAY_OF_MONTH)

        var view : View? = LayoutInflater.from(activity).inflate(R.layout.dialog_date, null)

        var datePicker : DatePicker = DatePicker(activity)


        var mDatePicker : DatePicker = view!!.findViewById(R.id.dialog_date_picker)
        mDatePicker.init(year, month, day, null)

        return AlertDialog
                .Builder(activity)
                .setView(view)
                .setTitle(R.string.date_picker_title)
                .setPositiveButton(android.R.string.ok, object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        var year : Int = mDatePicker.year
                        var month : Int = mDatePicker.month
                        var day : Int = mDatePicker.dayOfMonth

                        var date : Date = GregorianCalendar(year, month, day).time
                        sendResult(Activity.RESULT_OK, date)
                    }
                })
                .create()
    }

    fun sendResult(resultCode : Int, date : Date){
        if(targetFragment == null){
            return
        }

        var intent : Intent = Intent()

        intent.putExtra(EXTRA_DATE, date)

        targetFragment.onActivityResult(targetRequestCode, resultCode, intent)

    }


}