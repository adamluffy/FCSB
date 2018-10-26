package fcsb.franky.com.my.fcsb;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import utility.DateTimeUtility;
import utility.ValidationUtility;


public class OperatingHourFragment extends Fragment implements DatePickerDialog.OnDateSetListener{

    private TextInputLayout dateLayout, startMeterLayout, endMeterLayout, siteLayout, machineLayout;
    private TextInputEditText dateInput , startMeterInput, endMeterInput;
    private AutoCompleteTextView siteInput, machineInput;
    private RecyclerView activityLogRecyclerView;
    private HomeActivity homeActivity;

    private Date date;

    public OperatingHourFragment() {
        // Required empty public constructor
    }


    public static OperatingHourFragment newInstance() {
        OperatingHourFragment fragment = new OperatingHourFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_operating_hour, container, false);
        homeActivity = ((HomeActivity)container.getContext());

        dateLayout = view.findViewById(R.id.operating_hour_date_layout);
        dateInput = view.findViewById(R.id.operating_hour_date_input);
        dateInput.setOnClickListener(v -> {

            Calendar c = Calendar.getInstance();
            DatePickerDialog dialog = new DatePickerDialog(homeActivity,this,c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH));
            dialog.show();

        });

        siteLayout = view.findViewById(R.id.operating_site_input_layout);
        siteInput = view.findViewById(R.id.operating_site_input);

        machineLayout = view.findViewById(R.id.operating_machine_input_layout);
        machineInput = view.findViewById(R.id.operating_machine_input);

        TextView addLogBtn = view.findViewById(R.id.add_log_btn);
        addLogBtn.setOnClickListener(v -> {

            OperatingLogDialogFragment dialog = new OperatingLogDialogFragment();
            dialog.show(homeActivity.getFragmentManager(),"Log");
        });

        Button saveOperatingBtn = view.findViewById(R.id.save_operating_hour_btn);
        saveOperatingBtn.setOnClickListener(v->{

            if (validateInput()){

            }
        });

        return view;
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Calendar newDate = Calendar.getInstance();
        newDate.set(year,month,dayOfMonth);
        date = newDate.getTime();

        dateInput.setText(DateTimeUtility.formatDate(date));
    }

    private boolean validateInput(){


        if(!ValidationUtility.validateDate(dateInput,dateLayout)){
            return false;
        }


        return true;
    }

}
