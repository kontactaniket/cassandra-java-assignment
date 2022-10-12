package org.gcs.cassandra.repo;

import org.gcs.cassandra.entity.LocationData;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ScanLocationDataRepo {
    //        extends CrudRepository<ScanLocationData, String> {
    Map<String,String> locationStore = new HashMap();
    public List<LocationData> saveLocations(List<LocationData> locations){

        locations.forEach(x->{
            locationStore.put(x.getLocation(),x.getName());
        });
        return locations;
    }

    public String getLocation(String location){
        if(locationStore.containsKey(location)){
            return locationStore.get(location);
        }
        return "Location was not added !!!";
    }
}