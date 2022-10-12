package org.gcs.cassandra.entity;

import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
//@Table(value="bird_scan_data")
public class BirdScanData {

    //    @PrimaryKey
    private LocationDataPrimaryKey key;

    //   @Column(value ="bird_species")
    private String bird_species;

    //   @Column(value ="bird_species")
    private String bird_traits;

    //   @Column(value ="bird_species")
    private String id_bird;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BirdScanData that = (BirdScanData) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }
}