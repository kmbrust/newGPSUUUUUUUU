package com.example.kmbru_000.skam;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;

public class CoverPageActivity extends ActionBarActivity
        implements CoverPageFragment.OnButtonSelectedListener, ChooseLibFragment.OnButtonSelectedListener,
        LibCarnegie.OnFragmentInteractionListener, LibLaw.OnFragmentInteractionListener,
        LibMlk.OnFragmentInteractionListener, LibMoon.OnFragmentInteractionListener,
        LibArch.OnFragmentInteractionListener, LibBird.OnFragmentInteractionListener{

    private RelativeLayout mDrawer;
    private DrawerLayout mDrawerLayout;
    private RecyclerView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;
    private  MyDrawerRecyclerViewAdapter mDrawerRecyclerViewAdapter;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mPlanetTitles;


    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover_page);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawer = (RelativeLayout) findViewById(R.id.drawer);
        mDrawerList = (RecyclerView) findViewById(R.id.drawer_list);
        mDrawerList.setLayoutManager(new LinearLayoutManager(this));
        mDrawerRecyclerViewAdapter = new MyDrawerRecyclerViewAdapter(this, (new Drawer_Data()).getDrawerList());
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
    }

    // update the main content by replacing fragments
    private void selectItem(int position) {

        switch (position) {
            case 0://Locations & Information -> do nothing (go to libraries/dining hall info page?)
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new CoverPageFragment())
                        .addToBackStack("Home")
                        .commit();
                break;
            case 1: // Libraries
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new ChooseLibFragment())
                        .addToBackStack("Libraries")
                        .commit();
                break;
                /*getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new RecyclerViewFragment().newInstance(0))
                        .commit(); */

            case 2: //Dining Halls
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new CoverPageFragment())
                        .addToBackStack("Dining")
                        .commit();
                break;
            case 3: // Border Line

                break;
            case 4:  // Change Theme
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new CoverPageFragment())
                        .commit();
                break;
            case 5: // Exit
                System.exit(1);
                break;

            default: //go to home page
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new ChooseLibFragment())
                        .commit();
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
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cover_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.drawer_layout, PlaceholderFragment.newInstance(id))
                .commit();

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onButtonItemSelected(int id) {
        Intent intent;

        switch (id) {
            case R.id.mapbutton:
                intent = new Intent(this, MapsActivity.class);
                startActivity(intent);
                break;
            case R.id.busbutton:
                intent = new Intent(this, BusActivity.class);
                startActivity(intent);
                break;
            case R.id.weatherbutton:
                intent = new Intent(this, WeatherActivity.class);
                startActivity(intent);
                break;
            case R.id.settingsbutton:
                intent = new Intent(this, Directions.class);
                startActivity(intent);
                break;

            case R.id.bird:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new LibBirdO())
                        .addToBackStack("Bird Library")
                        .commit();
                break;

            case R.id.carnegie:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new LibCarnegie())
                        .addToBackStack("Carnegie Library")
                        .commit();
                break;
            case R.id.geology:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new LibGeology())
                        .addToBackStack("Geology Library")
                        .commit();
                break;
            case R.id.law:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new LibLaw())
                        .addToBackStack("Law Library")
                        .commit();
                break;
            case R.id.architecture:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new LibArch())
                        .addToBackStack("Architecture Reading Room")
                        .commit();
                break;
            case R.id.mlk:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new LibMlk())
                        .addToBackStack("MLK Jr. Library")
                        .commit();
                break;
            case R.id.moon:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new LibMoon())
                        .addToBackStack("Moon Library (ESF)")
                        .commit();
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed(){
        if(getFragmentManager().getBackStackEntryCount()!=0){
            getFragmentManager().popBackStack();
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
/*
    @Override
    public void onFragmentInteraction(Uri uri) { ///////////////////////////////////////////////////////////

    } */

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }
        private static final String ARG_OPTION = "section_number";

        public static PlaceholderFragment newInstance(int sectionNumber)
        {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_OPTION, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_cover_page, container, false);

            return rootView;
        }
    }
}
