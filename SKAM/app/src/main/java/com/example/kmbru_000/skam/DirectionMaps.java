package com.example.kmbru_000.skam;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DirectionMaps extends FragmentActivity {

    private LatLng current;
    private Location myLocation;

    GoogleMap googleMap;
    final String TAG = "PathGoogleMapActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        googleMap = fm.getMap();

       /* MarkerOptions options = new MarkerOptions();
        options.position(LOWER_MANHATTAN);
        options.position(BROOKLYN_BRIDGE);
        options.position(WALL_STREET);
        googleMap.addMarker(options);*/
        String url = getMapsApiDirectionsUrl();
        ReadTask downloadTask = new ReadTask();
        downloadTask.execute(url);

        LocationManager locationManager =(LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, true);

        myLocation = locationManager.getLastKnownLocation(provider);
        current = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(current,
                16));
        addMarkers();

    }

    private String getMapsApiDirectionsUrl() {
        /*String waypoints = "waypoints=optimize:true|"
                + LOWER_MANHATTAN.latitude + "," + LOWER_MANHATTAN.longitude
                + "|" + "|" + BROOKLYN_BRIDGE.latitude + ","
                + BROOKLYN_BRIDGE.longitude + "|" + WALL_STREET.latitude + ","
                + WALL_STREET.longitude;*/

        Intent intent = getIntent();
        String sensor = "sensor=false";
        String params =  sensor;
        String output = "json";
        String url = "https://maps.googleapis.com/maps/api/directions/"
                + output + "?" + params;
        String origin ="LifeSciencesComplexSyracuse";
        origin = intent.getStringExtra(Diretions.START).replaceAll("\\s", "");
        if(origin.toLowerCase().equals("currentlocation")) {
            origin = myLocation.getLatitude() + "," + myLocation.getLongitude();
        }
        if(origin.toLowerCase().substring(0,11).equals("lifesciences")){
            origin="LifeSciencesComplexSyracuse";
        }
        String destianation ="LinkSyracuse";
        destianation = intent.getStringExtra(Diretions.DESTINATION).replaceAll("\\s", "");
        if(destianation.toLowerCase().substring(0,11).equals("lifesciences")){
            destianation="LifeSciencesComplexSyracuse";
        }
        String waypoint = "";
        url = "https://maps.googleapis.com/maps/api/directions/json?origin="+origin+"&destination="+destianation+"&waypoints="+waypoint+"&mode=walking";
        System.out.println(url);
        return url;
    }

    private void addMarkers() {
        if (googleMap != null) {
            googleMap.addMarker(new MarkerOptions().position(current)
                    .title("First Point"));
        }
    }

    private class ReadTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... url) {
            String data = "";
            try {
                HttpConnection http = new HttpConnection();
                data = http.readUrl(url[0]);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            new ParserTask().execute(result);
        }
    }

    private class ParserTask extends
            AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        @Override
        protected List<List<HashMap<String, String>>> doInBackground(
                String... jsonData) {
            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                PathJSONParser parser = new PathJSONParser();
                System.out.println(jObject);
                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> routes) {
            ArrayList<LatLng> points = null;
            PolylineOptions polyLineOptions = null;

            // traversing through routes
            for (int i = 0; i < routes.size(); i++) {
                points = new ArrayList<LatLng>();
                polyLineOptions = new PolylineOptions();
                List<HashMap<String, String>> path = routes.get(i);

                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                polyLineOptions.addAll(points);
                polyLineOptions.width(3);
                polyLineOptions.color(Color.BLUE);
                googleMap.addPolyline(polyLineOptions);
            }
        }
    }
}