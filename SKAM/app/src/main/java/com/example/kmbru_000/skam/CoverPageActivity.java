package com.example.kmbru_000.skam;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.app.Fragment;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;

public class CoverPageActivity extends ActionBarActivity implements CoverPageFragment.OnButtonSelectedListener{

//>
/*
    private RecyclerView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;
    private  MyDrawerRecyclerViewAdapter mDrawerRecyclerViewAdapter;
*/
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
        mDrawerRecyclerViewAdapter = new MyDrawerRecyclerViewAdapter(this,  (new Drawer_Data()).getDrawerList());
        mDrawerRecyclerViewAdapter.SetOnItemClickListener(new MyDrawerRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                selectItem(position);
            }

        });
        /*mDrawerRecyclerViewAdapter.SetOnItemClickListener(new MyDrawerRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                selectItem(position);
            }

        });*/
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
        /* mDrawerList = (ListView)findViewById(R.id.drawer_list);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true); */
    }


//>
       /* mDrawerList = (ListView)findViewById(R.id.drawer_list);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
//
    }*/

//>
  /*  private void addDrawerItems() {
        String[] osArray = { "Android", "iOS", "Windows", "OS X", "Linux" };
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CoverPageActivity.this, "Time for an upgrade!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            // Called when a drawer has settled in a completely open state.
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Navigation!");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

             Called when a drawer has settled in a completely closed state.
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }
*/


    private void selectItem(int position) {
        // update the main content by replacing fragments
        Intent intent;

        switch (position) {
            case 0: //GPSU icon -> go to home page
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new CoverPageFragment())
                        .commit();
                break;
            case 1: //Locations & Information -> do nothing (go to libraries/dining hall info page?)
                /*getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new RecyclerViewFragment().newInstance(0))
                        .commit(); */
                break;
            case 3: // Libraries
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new CoverPageFragment())
                        .commit();
                break;
            case 4: // Dining Halls
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new CoverPageFragment())
                        .commit();
                break;
            default: //go to home page
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new CoverPageFragment())
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
//

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
        getFragmentManager().beginTransaction()
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
                intent = new Intent(this, CoverPageActivity.class);
                startActivity(intent);
                break;
            case R.id.weatherbutton:
                intent = new Intent(this, WeatherActivity.class);
                startActivity(intent);
                break;
            case R.id.settingsbutton:
                intent = new Intent(this, CoverPageActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }
        /*
        switch (id) {
            case R.id.button1:
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, new PlaceholderFragment())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.button2:
                intent = new Intent(this, ViewPagerActivity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(this, RecyclerViewActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }
         */
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

           /* int option = getArguments().getInt(ARG_OPTION);

            switch (option) {
                case R.id.busbutton:
                    rootView = inflater.inflate(R.layout.fragment_busing, container, false);
                    break;
                case R.id.settingsbutton:
                    rootView = inflater.inflate(R.layout.fragment_settings, container, false);
                    break;
            }*/
            return rootView;
        }
    }
}
