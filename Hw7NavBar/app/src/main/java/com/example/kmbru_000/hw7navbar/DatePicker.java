package com.example.kmbru_000.hw7navbar;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;

import java.util.Date;


public class DatePicker{ /*} extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_date_picker, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onActivityResult(int reuestCode, int resultCode, Intent date) {
        Log.d("MovieDetailFragment", "onActivityResult");

        if(resultCode != Activity.RESULT_OK) return;
        if(requestCode == REQUEST_DATE) {
            Date date1 = (Date) data.getSerializableExtra(MyDialogFragment_DatePicker.DATE_ARGS);
            textView_result.setText(Date.toString());
        }
        if (requestCode == PICK_CONTACT_REQUEST){
            //Get the URI that points to the selected contact
            Uri contactUri = data.getData();

            //We only need the number and name columns,
            String[] projection = {
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                    ContactsContract.CommonDataKinds.Phone.NUMBER);

            Cursor cursor = getActivity().getContentResolver()
                    .query(contactUri, projection, null, null, null);
            cursor.moveToFirst();

            //retrieve the data
            int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            String number = cursor.getString(column);
            column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            String name = cursor.getString(column);

            textView_result.setText("Name: " + name + "/nTelephone: " + number);
            textView_result.startAnimation (
                    AnimationUtils.loadAnimation(getActivity(), R.anim.myanimatioin));
            )
            }
        }
    }*/
}
