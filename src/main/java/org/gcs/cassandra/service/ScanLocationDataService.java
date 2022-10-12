package org.gcs.cassandra.service;

import com.google.gson.Gson;
import org.gcs.cassandra.entity.BirdScanData;
import org.gcs.cassandra.entity.LocationData;
import org.gcs.cassandra.entity.LocationDataPrimaryKey;
import org.gcs.cassandra.repo.BirdScanDataRepo;
import org.gcs.cassandra.repo.ScanLocationDataRepo;
import org.gcs.cassandra.util.GsonBuilderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import rx.Observable;
import javax.annotation.PreDestroy;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
@Service
public class ScanLocationDataService {
    @Autowired
    ScanLocationDataRepo locationRepo;
    @Autowired
    BirdScanDataRepo birdRepo;
    Queue<LocationData> locations = new LinkedList();
    List<LocationData> locationBatch = new ArrayList<>();
    Gson gson = GsonBuilderUtil.buildGsonBuilder().setPrettyPrinting().create();
    public Mono<String> addLocations(String locationJson) {
        return Mono.just(locationJson)
                .doFinally(x->{
                    locations.add(gson.fromJson(locationJson, LocationData.class));
                    System.out.println("Location Json: "+locationJson);
                }).thenReturn("Location added to savedown list:"+locationJson);
    }
    public Mono<String> getLocations(String location) {
        return Mono.just(location)
                .thenReturn(locationRepo.getLocation(location))
                .onErrorReturn("Error occurred while fetching location: "+location);
    }

    public Mono<String> addScanResult(String scanResultJson) {
        return Mono.just(scanResultJson)
                .doFinally(x->{
                    try {
                        birdRepo.saveBirdScanData(gson.fromJson(scanResultJson, BirdScanData.class));
                        System.out.println("Bird details added: " + scanResultJson);
                    } catch (Exception ex) {
                        System.out.println("Exception occurred while saving down bird details: "+ex.getMessage());
                    }
                }).onErrorReturn("Error occurred while saving bird details"+scanResultJson);
    }

    public Mono<String> getBirdScanData(String location, String scanDate) {
        LocationDataPrimaryKey key = new LocationDataPrimaryKey(location, LocalDate.parse(scanDate));
        return Mono.just(gson.toJson(key))
                .thenReturn(gson.toJson(birdRepo.getBirdScanData(key)));
    }

    @Scheduled(initialDelay = 1000, fixedDelay = 10000)
    private void processBatchLocation() {
        Observable.just(locations)
                .subscribe(this::createAndSubmitBatch);
    }

    private void createAndSubmitBatch(Queue<LocationData> scanLocationData) {
        LocationData data = scanLocationData.poll();
        if(data!=null){
            locationBatch.add(data);
            System.out.println("size: "+locationBatch.size());
            if(locationBatch.size()>1) {
                locationRepo.saveLocations(locationBatch);
                System.out.println("Locations Saved Down: ");
                System.out.println("---------------------------------");
                locationBatch.clear();
            }
        }
    }

    @PreDestroy
    public void saveRemainingBeforeDestroy() {
        locationRepo.saveLocations(locationBatch);
    }
}