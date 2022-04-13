package com.example.crimereportapp.ui.report;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.crimereportapp.R;
import com.example.crimereportapp.databinding.FragmentReportBinding;

import java.text.CollationElementIterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


public class ReportFragment extends Fragment {

    public TextView dateView = null;
    public TextView timeView = null;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_report, container, false);
        TextView dateView = (TextView) view.findViewById(R.id.InputDateofIncident);
        TextView location = (TextView) view.findViewById(R.id.inputLocation);
        TextView type = (TextView) view.findViewById(R.id.InputIncident);
        TextView details = (TextView) view.findViewById(R.id.DetailedInformation);
        dateView.setFocusable(false);      //Disable Your EditText
        dateView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                DialogFragment newFragment = new SelectDateFragment();
                newFragment.show(getParentFragmentManager(), "Set Date");

            }


        });
        TextView timeView = (TextView) view.findViewById(R.id.InputTimeofIncident);
        timeView.setFocusable(false);      //Disable Your EditText
        timeView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                DialogFragment newFragment = new SelectTimeFragment();
                newFragment.show(getParentFragmentManager(), "Set Time");

            }


        });


        Button submit = (Button) view.findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new SubmitDialog();
                newFragment.show(getParentFragmentManager(), "Report Submitted!");

                timeView.setText("");
                dateView.setText("");
                details.setText("");
                location.setText("");
                type.setText("");


            }
        });
        return view;
    }
    public static class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar calendar = Calendar.getInstance();
            int yy = calendar.get(Calendar.YEAR);
            int mm = calendar.get(Calendar.MONTH);
            int dd = calendar.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), this, yy, mm, dd);
        }

        public void onDateSet(DatePicker view, int yy, int mm, int dd) {
            populateSetDate(yy, mm+1, dd);
        }
        public void populateSetDate(int year, int month, int day) {
            View view = this.getParentFragment().getView();
            TextView dateView = (TextView) view.findViewById(R.id.InputDateofIncident);
            dateView.setText(month+"/"+day+"/"+year);
        }

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


public static class SelectTimeFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int h = calendar.get(Calendar.HOUR_OF_DAY);
        int m = calendar.get(Calendar.MINUTE);
        int am = calendar.get(Calendar.AM);
        return new TimePickerDialog(getActivity(), this, h, m,false);
    }

    public void onTimeSet(TimePicker view, int h, int m) {
        populateSetDate(h, m);
    }
    public void populateSetDate(int hour, int minute) {
        View view = this.getParentFragment().getView();
        TextView dateView = (TextView) view.findViewById(R.id.InputTimeofIncident);
        String prep = "";
        if (minute < 10) {
            prep = "0";
        }
        if (hour > 12 ) {
            dateView.setText((hour-12)+":"+ prep + minute + " pm");

        } else {
            dateView.setText(hour + ":" + prep + minute  + " am");
        }
    }

}

    public static class SubmitDialog extends DialogFragment {
        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            /*Dialog alert = new AlertDialog.Builder(requireContext())
                    .setMessage("Report Submitted")
                    .setPositiveButton("Go Back", (dialog, which) -> {} )
                    .create();

             */
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setMessage("Report Submitted\nCrime Report will analyze your Report\nwithin 24 hours");
            builder.setCancelable(false);
            builder.setPositiveButton("Go Back", null);
            AlertDialog dialog = builder.show();
            TextView messageView = dialog.findViewById(android.R.id.message);
            Button buttonView = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT); //create a new one
            layoutParams.weight = 1.0f ;
            layoutParams.gravity = Gravity.CENTER; //this is layout_gravity
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setLayoutParams(layoutParams);
            messageView.setGravity(Gravity.CENTER);

            return dialog;
        }
    }
}

