package com.example.kmbru_000.hw7navbar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class ActivityDemo extends android.support.v4.app.Fragment {

    static final String DATE_ARGS = "date";
    private static int i = 0;
    static int RESULT_OK = 0;

    public ActivityDemo() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_activity_demo, container, false);
        Button ok = (Button) rootView.findViewById(R.id.buttonOK);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View view) {
                Log.d("SimpleActivity", "before setResult");
                Intent intent = new Intent();
                intent.putExtra(DATE_ARGS, Integer.toString(i));
                getActivity().setResult(RESULT_OK, intent);

                //getActivity().finish();
                //ActivityDemo.this.startActivity(intent);

                getFragmentManager().beginTransaction().replace(R.id.container, new CoverFragment()).commit();


            }
        });

      /*  Intent myIntent = new Intent();
        myIntent.putExtra("key", value); //Optional parameters
        ActivityDemo.this.startActivity(myIntent);
      */
        return rootView;
    }
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.buttonOK:
                Toast.makeText(getApplicationContext(), "Clicked trash can", Toast.LENGTH_LONG).show();
                return true;
            case R.id.fragment_item:
                Toast.makeText(getApplicationContext(),"Clicked item", Toast.LENGTH_LONG).show();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
*/
}