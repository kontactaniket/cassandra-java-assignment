package org.gcs.cassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LocationScanApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocationScanApplication.class, args);
    }

//    static Queue<String> q1 = new LinkedList();
//    public static void main(String[] args) {
//        fetchNumber();
//        for (int i=0;i<100;i++){
//            q1.add("Number "+i);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//    public static void fetchNumber(){
//
//        Observable.just(q1).delay(1000, TimeUnit.MILLISECONDS).repeat(200).forEach(x->{
//            System.out.println(x.poll());
//        });
//        System.out.println("Exiting!!!");
//    }

}