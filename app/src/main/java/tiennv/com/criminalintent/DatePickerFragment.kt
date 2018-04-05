package tiennv.com.criminalintent

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.app.FragmentManager
import android.os.Bundle

/**
 * Created by Asus on 4/4/2018.
 */
class DatePickerFragment() : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog? {
        return AlertDialog
                .Builder(activity)
                .setTitle(R.string.date_picker_title)
                .setPositiveButton(android.R.string.ok,null)
                .create()
    }

    override fun show(manager: FragmentManager?, tag: String?) {
        super.show(manager, tag)
    }


}