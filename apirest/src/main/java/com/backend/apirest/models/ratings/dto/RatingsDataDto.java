package com.backend.apirest.models.ratings.dto;

import com.backend.apirest.models.students.dto.StudentDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RatingsDataDto {

    private Integer id;

    private Integer idAlumno;

    private Integer idMateria;

    private StudentDto studentDto;


    private Double calificacion;

}
