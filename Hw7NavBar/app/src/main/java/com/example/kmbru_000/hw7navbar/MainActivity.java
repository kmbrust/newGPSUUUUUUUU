package com.example.kmbru_000.hw7navbar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
// RecyclerViewFragment.OnListItemSelectedListener,
public class MainActivity extends ActionBarActivity
        implements CoverFragment.OnButtonSelectedListener, RecyclerViewFragment.OnRecyclerViewItemSelectedListener
{
    private static final String DATE_ARGS = "date";
    private static Date mDate = new Date();
    private RelativeLayout mDrawer;
    private DrawerLayout mDrawerLayout;
    private RecyclerView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;
    private  MyDrawerRecyclerViewAdapter mDrawerRecyclerViewAdapter;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mPlanetTitles;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mDrawer = (RelativeLayout) findViewById(R.id.drawer);
        mDrawerList = (RecyclerView) findViewById(R.id.drawer_list);
        mDrawerList.setLayoutManager(new LinearLayoutManager(this));
        mDrawerRecyclerViewAdapter = new MyDrawerRecyclerViewAdapter(this,  (new Drawer_Data()).getDrawerList());
        mDrawerRecyclerViewAdapter.SetOnItemClickListener(new MyDrawerRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                selectItem(position);
            }

        });
        mDrawerList.setAdapter(mDrawerRecyclerViewAdapter);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                mToolbar,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }
        Intent intent = getIntent();
        int value = (int) intent.getIntExtra("DATE_ARGS", 0);
        //int value1 = (int) intent.getSerializableExtra(ActivityDemo.DATE_ARGS);
        Bundle bun = (Bundle) intent.getExtras();
/*        int value1 = Integer.parseInt((String) bun.get("DATE_ARGS"));
        System.out.println("** \n Date-args" + value1 + "**\n");
        TextView textView_result = null;
        //if(resultCode != Activity.RESULT_OK), return;
//            Date date = (Date) data.getSerializableExtra(DATE_ARGS);//MyDialogFragment_DatePicker)
        textView_result.setText(Integer.toString(value1));
  */     // textView_result.setText(Integer.toString(value));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private void selectItem(int position) {
        // update the main content by replacing fragments
        Intent intent;

        switch(position) {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new CoverFragment()).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new RecyclerViewFragment().newInstance(0))
                        .commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new RecyclerViewFragment().newInstance(1))
                        .commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new CoverFragment()).commit();
                break;
            case 4:
                break;
            case 5:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new AboutMeFragment()).commit();
                break;
            case 6:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new SettingsFragment()).commit();
                break;
            case 7:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new LogoutFragment()).commit();
                break;
            default:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new CoverFragment()).commit();
                break;
        }


    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
    Intent intent;
    @Override
    public void onButtonItemSelected(int id){

        final Context context = this;
        switch (id){
            case R.id.button1:

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService
                        (Context.LAYOUT_INFLATER_SERVICE);
                LinearLayout ll= (LinearLayout)inflater.inflate(R.layout.fragment_calendar, null, false);

                alertDialogBuilder
                        .setTitle("Event Calendar")
                        .setMessage("Click to schedule or view events.")
                        .setView(ll)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                // Do nothing.
                            }
                        }
                ).show();

                break;
            case R.id.button2:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new ActivityDemo())
                        .commit();



                /*
                intent = new Intent(this, RecyclerViewActivity.class);
                startActivity(intent);
                */
                break;
            case R.id.button3:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new ContactApp())
                        .commit();

                /*
                intent = new Intent(this, ViewPagerActivity.class);
                startActivity(intent);
                */
                break;

            default:
                break;
        }
    }
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setRetainInstance(true);
            movieData = new MovieData();
        }

        private static final String ARG_SECTION_NUMBER = "section_number";
        private MovieData movieData;


        public static PlaceholderFragment newInstance(int sectionNumber)
        {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_about_me, container, false);

            mDate = (Date)getArguments().getSerializable(DATE_ARGS);
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            DatePicker datePicker = (DatePicker) container.findViewById(R.id.datePicker);
            datePicker.init(year, month, day, new DatePicker.OnDateChangedListener(){
                public void onDateChanged(DatePicker view, int year, int month, int day) {
                    new GregorianCalendar(year, month, day).getTime();
                    getArguments().putSerializable(DATE_ARGS, mDate);
                }
            });

            Button done = (Button) rootView.findViewById(R.id.done);
            done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("SimpleActivity", "beforesetResult");
                    Intent intentl = new Intent();
                    intentl.putExtra(DATE_ARGS, mDate);
                    getActivity().setResult(RESULT_OK, intentl);
                    getActivity().finish();
                }
            });
            int REQUEST_DATE = 0;
            Date date = new Date(System.currentTimeMillis());
            Intent i = new Intent(getActivity(), MainActivity.class);
            startActivityForResult(i, REQUEST_DATE);

            //activity demo
            rootView = inflater.inflate(R.layout.fragment_activity_demo, container, false);
            Button ok = (Button) rootView.findViewById(R.id.buttonOK);
            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("SimpleActivity", "before setResult");
                    Intent intent = new Intent();
                    intent.putExtra(DATE_ARGS, mDate);
                    getActivity().setResult(RESULT_OK, intent);
                    getActivity().finish();


                }
            });

            return rootView;


        }
        /*public void getNewClass() {
            MainActivity.getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new RecyclerViewFragment().newInstance(1))
                    .commit();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new CoverFragment())
                    .commit();
        } */
    }
    /*  @Override
      public void onListItemSelected(int position,HashMap<String,?> movie){
          getSupportFragmentManager().beginTransaction()
                  .replace(R.id.item_list_container, DetailViewFragment.newInstance(movie))
                  .addToBackStack(null)
                  .commit();

      } */

    @Override
    public void onItemSelected(int position,HashMap<String,?> movie){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.item_list_container, DetailViewFragment.newInstance(movie))
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("MovieDetailFragment", "onActivityResult");
        int REQUEST_DATE = 0;
        TextView textView_result = null;
        //if(resultCode != Activity.RESULT_OK), return;
        if(requestCode == REQUEST_DATE){
            Date date = (Date) data.getSerializableExtra(DATE_ARGS);//MyDialogFragment_DatePicker)
            textView_result.setText(date.toString());
        }
        if (resultCode==RESULT_OK) {

            String text=data.getStringExtra("DATE_ARGS");
            textView_result.setText(text);

        }
        Log.d("MovieDetailFragment", "onActivityResult");

        if(resultCode != Activity.RESULT_OK) return;
        if(requestCode == REQUEST_DATE) {
            Date date1 = (Date) data.getSerializableExtra(MyDialogFragment_DatePicker.DATE_ARGS);
            textView_result.setText(Date.toString());
        }
        final int PICK_CONTACT_REQUEST = 0;

        if (requestCode == PICK_CONTACT_REQUEST){
            //Get the URI that points to the selected contact
            Uri contactUri = data.getData();

            //We only need the number and name columns,
            String[] projection = {
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                    ContactsContract.CommonDataKinds.Phone.NUMBER};

            Cursor cursor = getActivity().getContentResolver()
                    .query(contactUri, projection, null, null, null);
            cursor.moveToFirst();

            //retrieve the data
            int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            String number = cursor.getString(column);
            column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            String name = cursor.getString(column);

            textView_result.setText("Name: " + name + "/nTelephone: " + number);
           /* textView_result.startAnimation (
                    AnimationUtils.loadAnimation(getActivity(), R.anim.myanimation));

            }*/
        }
    }

    }
}
/*
alertDialogBuilder
                        .setTitle("DatePicker")
                        .setMessage("Click go to datepicker")
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, close
                                // current activity
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, new SettingsFragment()).commit();

                            }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        })
                        .setNeutralButton("neutral",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });
 */