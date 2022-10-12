package org.gcs.cassandra.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.springframework.data.cassandra.core.mapping.Column;
//import org.springframework.data.cassandra.core.mapping.PrimaryKey;
//import org.springframework.data.cassandra.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Table(value="scan_location_data")
public class LocationData {
//    @PrimaryKey
    private String location;
//    @Column
    private String name;

    @Override
    public String toString() {
        return "ScanLocationData{" +
                "location='" + location + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}