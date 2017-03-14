package com.example.sungeun.myapplication;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by sungeun on 2017-03-12.
 */

public class DatePickerDialogOut extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datepickerdialog = new DatePickerDialog(getActivity(),
                AlertDialog.THEME_DEVICE_DEFAULT_DARK,this,year,month,day);

        return datepickerdialog;
    }

    public void onDateSet(DatePicker view, int year, int month, int day){


        Button leavinghospital = (Button) getActivity().findViewById(R.id.btn_out);
        leavinghospital.setText(year + ":" + (month+1) + ":" + day);


    }


}
