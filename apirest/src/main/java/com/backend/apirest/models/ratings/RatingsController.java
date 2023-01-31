package com.backend.apirest.models.ratings;

import com.backend.apirest.models.ratings.dto.RatingDto;
import com.backend.apirest.models.ratings.dto.RatingGeneralDto;
import com.backend.apirest.util.dto.GeneralDto;
import com.backend.apirest.util.dto.GenericResponse;
import com.backend.apirest.util.validation.ValidationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
public class RatingsController {

    private final Logger logger = LoggerFactory.getLogger(RatingsController.class);

    @Autowired
    RatingsService ratingsService;

    @GetMapping("/ratings/students/{idStudent}")
    public ResponseEntity<Object> findRatingsStudents(@PathVariable(name = "idStudent" , required = true)  Integer idStudent) {

        ResponseEntity<Object> result = null;

        List<RatingDto> ratings = ratingsService.findByIdStudent(idStudent);

        AtomicReference<Double> average = new AtomicReference<>(0.0);

        ratings.forEach(data -> {
            average.set(average.get() + data.getCalificacion());
        });

        logger.info("####################### average {}",average);

        result = new ResponseEntity<>(RatingGeneralDto.builder()
                .listData(ratings)
                .promedio(average.get())
                .build(), HttpStatus.OK);

        return result;
    }


    @DeleteMapping("/ratings/{idRatings}")
    public ResponseEntity<Object> deleteRatings( @PathVariable(name = "idRatings") Integer idRatings){
        ResponseEntity<Object> result = null;


        if(ratingsService.existById(idRatings)){
            GenericResponse genericResponse;
            ResponseEntity<Object> response;
            List<String> messages = new ArrayList<>();
            messages.add("NOT_FOUND_RATING");

            genericResponse = GenericResponse.builder()
                    .timestamp(ValidationUtils.timestamp())
                    .status(HttpStatus.NOT_FOUND.value())
                    .error("Not found")
                    .message(messages)
                    .path("/ratings/" + idRatings)
                    .build();

            result = new ResponseEntity<>(genericResponse, HttpStatus.NOT_FOUND);

        }else {

            ratingsService.delete(idRatings);

                result = new ResponseEntity<>(GeneralDto.builder()
                        .success("ok")
                        .msg("calificacion eliminada")
                        .build(), HttpStatus.OK);

        }
        return result;
    }




}
