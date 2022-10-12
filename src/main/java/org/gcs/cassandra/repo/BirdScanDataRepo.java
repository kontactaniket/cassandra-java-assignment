package org.gcs.cassandra.repo;

import org.gcs.cassandra.entity.BirdScanData;
import org.gcs.cassandra.entity.LocationDataPrimaryKey;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BirdScanDataRepo {
    //        extends CrudRepository<BirdScanData, LocationDataPrimaryKey> {

    Map<LocationDataPrimaryKey, BirdScanData> scanData = new HashMap();

    public BirdScanData getBirdScanData(LocationDataPrimaryKey key) {
        if(scanData == null && scanData.isEmpty()){
            return null;
        }
        return scanData.get(key);
    }

    public void  saveBirdScanData(BirdScanData data) {
        scanData.put(data.getKey(), data);
    }
}