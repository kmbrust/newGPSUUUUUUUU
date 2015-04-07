package com.example.kmbru_000.hw7navbar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



/*
public void showDatePickerDialog() {
    Date date = new Date(System.currentTimeMillis();
    MyDialogFragment_DatePicker dialog = MyDialogFragment_DatePicker.newInstance(date);
    dialog.show(getFragmentManager(), "DatePicker Dialog");
}

private static final int REQUEST_DATE = 0;
public void showDatePickerDialogGetResult() {
    Date date= new Date(System.currentTimeMillis());
    dialog.setTargetFragment(DemoFragment.this, REQUEST_DATE);
    dialog.show(getFragmentManager(), "DatePicker Dialog: Get Result");
}

private TextView textView_result;

@Override
public void OnActivityResult(int requestCode, int resultCode, Intent data) {
    Log.d("MovieDetailFragment", "onActivityResult");

    if(resultCode != Activity.RESULT_OK) return;
    if(requestCode == REQUEST_DATE) {
        Date date = (Date) data.getSerializableExtra(MyDialogFragment_DatePicker.DATE_ARGS);
        textView_result.setText(date.toString());
 */

public class MyDialogFragment_DatePicker {/*extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String DATE_ARGS = "date";
    private static Date mDate = new Date();
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    // TODO: Rename and change types and number of parameters
    public static MyDialogFragment_DatePicker newInstance(String param1, String param2) {
        MyDialogFragment_DatePicker fragment = new MyDialogFragment_DatePicker();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MyDialogFragment_DatePicker() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mDate = (Date)getArguments().getSerializable(DATE_ARGS);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mDate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_date, null);

        DatePicker datePicker = (DatePicker) v.findViewById(R.id.datePicker);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener(){
           public void onDateChanged(DatePicker view, int year, int month, int day) {
               mDate - new GregorianCalendar(year, month, day).getTime();
               getArguments().putSerializable(DATE_ARGS, mDate);
           }
        });

        AlertDialog.Builder alertDialogBuilder = new AlertDialog(getActivity());
        alertDialogBuilder.setView(v)
                .setTitle("Date Picker")
                .setMessage("Please select a date")
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if (getTargetFragment() != null) {
                                    Intent i = new Intent();
                                    i.putExtra(DATE_ARGS, mDate);
                                    getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, i);
                                } else
                                    Toast.makeText(getActivity(), "no need to return results", Toast.LENGTH_LONG).show();
                            }
                        });
        return alertDialogBuilder.create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_dialog_fragment__date_picker, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }
*/
}
