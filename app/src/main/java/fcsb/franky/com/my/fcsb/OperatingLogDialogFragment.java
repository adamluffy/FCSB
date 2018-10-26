package fcsb.franky.com.my.fcsb;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.Calendar;
import java.util.Date;


import utility.DateTimeUtility;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.YEAR;

public class OperatingLogDialogFragment extends DialogFragment{

    private TextInputLayout startTimeLayout, endTimeLayout;
    private TextInputEditText startTimeInput, endTimeInput;
    private MaterialBetterSpinner activitySpinner;

    private Date startTime, endTime;



    public interface OperatingLogListener{

    }

    private OperatingLogListener mListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.add_operating_log_dialog,null);

        startTimeLayout = view.findViewById(R.id.operating_start_time_layout);
        startTimeInput = view.findViewById(R.id.operating_start_time_input);

        startTimeInput.setOnClickListener(v -> {

            Calendar start = Calendar.getInstance();
            TimePickerDialog dialog = new TimePickerDialog(getActivity(), (view1, hourOfDay, minute) -> {

                 start.set(YEAR,Calendar.MONTH,DAY_OF_MONTH,hourOfDay,minute);
                 startTime = start.getTime();
                 startTimeInput.setText(DateTimeUtility.formatTime(startTime));

            },start.get(Calendar.HOUR_OF_DAY),start.get(Calendar.MINUTE),true);

            dialog.show();
        });

        endTimeLayout = view.findViewById(R.id.operating_end_time_layout);
        endTimeInput = view.findViewById(R.id.operating_end_time_input);

        endTimeInput.setOnClickListener(v -> {

            Calendar end = Calendar.getInstance();
            TimePickerDialog dialog = new TimePickerDialog(getActivity(), (view1, hourOfDay, minute) -> {

                end.set(YEAR,Calendar.MONTH,DAY_OF_MONTH,hourOfDay,minute);
                endTime = end.getTime();
                endTimeInput.setText(DateTimeUtility.formatTime(endTime));

            },end.get(Calendar.HOUR_OF_DAY),end.get(Calendar.MINUTE),true);

            dialog.show();
        });

        activitySpinner = view.findViewById(R.id.operating_activity_spinner);

        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setPositiveButton("OK", (dialog, which) -> {
                    if(validateInput()){
                        //TODO: send log back to fragment, and add into the recycler view

                    }
                })
                .setNegativeButton("CANCEL",((dialog, which) -> {

                }))
                .create();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (OperatingLogListener)getTargetFragment();
        }catch (ClassCastException e){
            throw new ClassCastException("Calling Fragment must implement OperatingLogListener");
        }
    }

    private boolean validateTime(){

        String start = startTimeInput.getText().toString();
        String end = endTimeInput.getText().toString();

        if(start.isEmpty()){
            startTimeLayout.setError("Please input start time");
            return false;
        }else{
            startTimeLayout.setErrorEnabled(false);
        }

        if(end.isEmpty()){
            endTimeLayout.setError("Please input end time");
            return false;
        }else{
            endTimeLayout.setErrorEnabled(false);
        }

        if(startTime.after(endTime)){
            endTimeInput.setError("please input valid end time");
            return false;
        }else{
            endTimeLayout.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateSpinner(){
        return true;
    }

    private boolean validateInput(){

        boolean isValid = true;

        if(!validateTime()){
            isValid = false;
        }

        if(!validateSpinner()){
            isValid = false;
        }

        return isValid;
    }
}
