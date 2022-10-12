# Cassandra CQL Statements

Use this file to include your DDL.  Also include any DML that you may have created.


## DDL

# TABLE: oboe.scan_location_data
CREATE TABLE oboe.scan_location_data (location VARCHAR PRIMARY KEY,name VARCHAR);

# TABLE: oboe.scan_location_result
CREATE TABLE oboe.bird_scan_data (location VARCHAR,scan_day date,id_bird VARCHAR,bird_species VARCHAR,bird_traits VARCHAR, PRIMARY KEY (location,scan_day));

## DML (if any)
# INSERT: oboe.scan_location_data
INSERT into oboe.scan_location_data (location,name)values('25N,71W','Bermuda Triangle');
