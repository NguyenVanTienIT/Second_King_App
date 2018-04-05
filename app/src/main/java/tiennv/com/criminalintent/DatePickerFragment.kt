package tiennv.com.criminalintent

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View

/**
 * Created by Asus on 4/4/2018.
 */
class DatePickerFragment() : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var view : View? = LayoutInflater.from(activity).inflate(R.layout.dialog_date, null)

        return AlertDialog
                .Builder(activity)
                .setView(view)
                .setTitle(R.string.date_picker_title)
                .setPositiveButton(android.R.string.ok,null)
                .create()
    }


}