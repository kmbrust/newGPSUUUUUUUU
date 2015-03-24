package com.example.kmbru_000.skam;

/**
 * Created by kmbru_000 on 3/21/2015.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Drawer_Data {

    List<Map<String,?>> drawerList;
    public static final int TYPE0 = 0;
    public static final int TYPE1 = 1;
    public static final int TYPE2 = 2;
    public static final int TYPE3 = 3;

    public List<Map<String, ?>> getDrawerList() {
        return drawerList;
    }

    public int getSize(){
        return drawerList.size();
    }

    public HashMap getItem(int i){
        return (HashMap) drawerList.get(i);
    }

    public Drawer_Data(){
        HashMap item;
        drawerList =new ArrayList<Map<String,?>>();

        item = new HashMap();
        item.put("type",TYPE0); item.put("title", "Locations & Information");
        drawerList.add(item);

////////////

        item = new HashMap();
        item.put("type",TYPE1); item.put("icon", R.drawable.book); item.put("title", "Libraries");
        drawerList.add(item);
        item = new HashMap();
        item.put("type",TYPE1); item.put("icon", R.drawable.fork); item.put("title", "Dining Halls");
        drawerList.add(item);

/////////////

        item = new HashMap();
        item.put("type",TYPE2); item.put("icon", R.drawable.simple_line);
        drawerList.add(item);

/////////////

        item = new HashMap();
        item.put("type",TYPE3); item.put("title", "Change Theme");
        drawerList.add(item);
        item = new HashMap();
        item.put("type",TYPE3);  item.put("title", "Exit gpSU");
        drawerList.add(item);
    }
}
