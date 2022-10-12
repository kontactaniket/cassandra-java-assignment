package org.gcs.cassandra.util;

import com.google.gson.GsonBuilder;
import java.time.LocalDate;
public class GsonBuilderUtil {
    public static GsonBuilder buildGsonBuilder() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
        return gsonBuilder;
    }
}