package org.gcs.cassandra.entity;

import lombok.*;
//import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
//import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
//import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

//@PrimaryKeyClass
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@ToString
public class LocationDataPrimaryKey implements Serializable {

//    @PrimaryKeyColumn(name="location",ordinal = 1, type= PrimaryKeyType.CLUSTERED)
    private String location;

//    @PrimaryKeyColumn(name="scan_day",ordinal = 1, type= PrimaryKeyType.PARTITIONED)
    private LocalDate scan_day;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationDataPrimaryKey that = (LocationDataPrimaryKey) o;
        return Objects.equals(location, that.location) && Objects.equals(scan_day, that.scan_day);
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(scan_day.getDayOfMonth()%10).hashCode();
    }
}