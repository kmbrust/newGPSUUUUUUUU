package com.example.kmbru_000.hw7navbar;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CoverFragment extends Fragment {


    private OnButtonSelectedListener mListener;


    public static CoverFragment newInstance(String param1, String param2) {
        CoverFragment fragment = new CoverFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    public CoverFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_cover, container, false);
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
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnButtonSelectedListener {
        public void onButtonItemSelected(int position);
    }

}
