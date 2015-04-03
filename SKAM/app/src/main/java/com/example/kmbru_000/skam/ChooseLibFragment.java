package com.example.kmbru_000.skam;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link com.example.kmbru_000.skam.ChooseLibFragment.OnButtonSelectedListener} interface
 * to handle interaction events.
 * Use the {@link ChooseLibFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChooseLibFragment extends Fragment implements View.OnClickListener {

    //private OnFragmentInteractionListener mListener;
    private OnButtonSelectedListener mListener;


    public static ChooseLibFragment newInstance(String param1, String param2) {
        ChooseLibFragment fragment = new ChooseLibFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ChooseLibFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_choose_lib, container, false);
        View.OnClickListener onClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int id = view.getId();
                mListener.onButtonItemSelected(id);

            }
        };

        (rootView.findViewById(R.id.bird)).setOnClickListener(this);
        (rootView.findViewById(R.id.carnegie)).setOnClickListener(onClickListener);
        (rootView.findViewById(R.id.geology)).setOnClickListener(onClickListener);
        (rootView.findViewById(R.id.law)).setOnClickListener(onClickListener);
        (rootView.findViewById(R.id.architecture)).setOnClickListener(onClickListener);
        (rootView.findViewById(R.id.mlk)).setOnClickListener(onClickListener);
        (rootView.findViewById(R.id.moon)).setOnClickListener(onClickListener);

        View.OnClickListener handler = new View.OnClickListener(){
            public void onClick(View v) {
            }
        };

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnButtonSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnButtonSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {

    }

    public interface OnButtonSelectedListener {
        public void onButtonItemSelected(int position);
    }

}
