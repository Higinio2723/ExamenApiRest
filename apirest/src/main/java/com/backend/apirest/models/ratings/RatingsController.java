package com.backend.apirest.models.ratings;

import com.backend.apirest.models.ratings.dto.RatingDto;
import com.backend.apirest.models.ratings.dto.RatingFormatDto;
import com.backend.apirest.models.ratings.dto.RatingGeneralDto;
import com.backend.apirest.models.ratings.dto.RatingsDataDto;
import com.backend.apirest.util.FormatUtil;
import com.backend.apirest.util.dto.GeneralDto;
import com.backend.apirest.util.dto.GenericResponse;
import com.backend.apirest.util.ValidationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class RatingsController {

    private final Logger logger = LoggerFactory.getLogger(RatingsController.class);

    @Autowired
    RatingsService ratingsService;

    @GetMapping("/ratings/students/{idStudent}")
    public ResponseEntity<Object> findRatingsStudents(@PathVariable(name = "idStudent" , required = true)  Integer idStudent) {

        ResponseEntity<Object> result = null;

        List<RatingDto> ratings = ratingsService.findByIdStudent(idStudent);
        List<RatingFormatDto> ratingFormatDtos = new ArrayList<>();

        ratings.forEach(data -> {
            String dataString = FormatUtil.formatDateToStrings(data.getFecha_registro());

            ratingFormatDtos.add(RatingFormatDto.builder()
                            .id_calificacion(data.getId_t_calificacion())
                            .id_t_usuario(data.getId_t_usuario())
                            .nombre(data.getNombre())
                            .apellido(data.getApellido())
                            .materia(data.getMateria())
                            .calificacion(data.getCalificacion())
                            .fecha_registro(dataString)
                    .build());
        });


        result = new ResponseEntity<>(RatingGeneralDto.builder()
                .listData(ratingFormatDtos)
                .promedio(ValidationUtils.getAverage(ratings))
                .build(), HttpStatus.OK);

        return result;
    }


    @DeleteMapping("/ratings/{idRatings}")
    public ResponseEntity<Object> deleteRatings( @PathVariable(name = "idRatings") Integer idRatings){
        ResponseEntity<Object> result = null;


        if(!ratingsService.existById(idRatings)){
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


    @PutMapping("/ratings")
    public ResponseEntity<Object> updateRating(@Valid @RequestBody RatingsDataDto request)  {
        ResponseEntity<Object> result = null;

        if(!ratingsService.existById(request.getId())){
            GenericResponse genericResponse;
            List<String> messages = new ArrayList<>();
            messages.add("NOT_FOUND_RATING");

            genericResponse = GenericResponse.builder()
                    .timestamp(ValidationUtils.timestamp())
                    .status(HttpStatus.NOT_FOUND.value())
                    .error("Not found")
                    .message(messages)
                    .path("/ratings")
                    .build();

            result = new ResponseEntity<>(genericResponse, HttpStatus.NOT_FOUND);

        }else {

            ratingsService.edit(request);

            result = new ResponseEntity<>(GeneralDto.builder()
                    .success("ok")
                    .msg("calificacion actualizada")
                    .build(), HttpStatus.OK);

        }
        return result;

    }

    @PostMapping("/ratings")
    public ResponseEntity<Object> saveRating(@Valid @RequestBody RatingsDataDto request)  {
        ResponseEntity<Object> result = null;
            ratingsService.save(request);

            result = new ResponseEntity<>(GeneralDto.builder()
                    .success("ok")
                    .msg("calificacion registrada")
                    .build(), HttpStatus.OK);

        return result;

    }


    @PostMapping("/ratings_det")
    public ResponseEntity<Object> saveRatingDet(@Valid @RequestBody RatingsDataDto request)  {
        ResponseEntity<Object> result = null;
        ratingsService.saveDet(request);

        result = new ResponseEntity<>(GeneralDto.builder()
                .success("ok")
                .msg("calificacion registrada")
                .build(), HttpStatus.OK);

        return result;

    }


    }
