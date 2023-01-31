package com.backend.apirest.util;

import com.backend.apirest.models.ratings.dto.RatingDto;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ValidationUtils {

    private ValidationUtils(){

    }

    public static Long timestamp(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();
    }


    public static Double getAverage(List<RatingDto> ratings){
        AtomicReference<Double> sumRatings = new AtomicReference<>(0.0);

        ratings.forEach(data -> {
            sumRatings.set(sumRatings.get() + data.getCalificacion());
        });

        double  average = sumRatings.get()/ratings.size();

        return average;
    }



}
