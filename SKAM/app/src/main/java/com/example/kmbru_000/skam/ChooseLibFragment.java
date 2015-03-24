package com.example.kmbru_000.skam;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link com.example.kmbru_000.skam.ChooseLibFragment.OnButtonSelectedListener} interface
 * to handle interaction events.
 * Use the {@link ChooseLibFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChooseLibFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //private OnFragmentInteractionListener mListener;
    private OnButtonSelectedListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChooseLibFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChooseLibFragment newInstance(String param1, String param2) {
        ChooseLibFragment fragment = new ChooseLibFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ChooseLibFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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

        (rootView.findViewById(R.id.button1)).setOnClickListener(onClickListener);
        (rootView.findViewById(R.id.button2)).setOnClickListener(onClickListener);
        (rootView.findViewById(R.id.button3)).setOnClickListener(onClickListener);
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

    public interface OnButtonSelectedListener {
        public void onButtonItemSelected(int position);
    }
}
