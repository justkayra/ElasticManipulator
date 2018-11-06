package com.semantyca.ess.store;

import java.util.HashMap;
import java.util.Map;

public class Mapping {

    public Map get(){
        Map<String, Object> jsonMap = new HashMap<>();
        Map<String, Object> properties = new HashMap<>();


        Map<String, Object> gridLocation = new HashMap<>();
        gridLocation.put("PropertyEasting", "long");
        gridLocation.put("PropertyNorthing", "long");
        gridLocation.put("Latitude", "geo_point");
        gridLocation.put("Longitude", "geo_point");

        Map<String, Object> address = new HashMap<>();
        address.put("type", "nested");
        address.put("GridLocation", gridLocation);

        properties.put("Address", address);
        jsonMap.put("properties", properties);
        return jsonMap;
   }

}