package com.example.kmbru_000.hw7navbar;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/*
        * Created by kmbru_000 on 2/19/2015.
        */
public class AboutMeFragment extends android.support.v4.app.Fragment {

    public AboutMeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_about_me, container, false);
        return rootView;
    }
}
