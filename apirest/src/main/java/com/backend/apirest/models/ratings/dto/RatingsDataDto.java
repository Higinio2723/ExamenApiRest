package com.backend.apirest.models.ratings.dto;

import com.backend.apirest.models.students.dto.StudentDto;
import com.backend.apirest.models.subjects.dto.SubjectDto;
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

    private StudentDto alumno;

    private SubjectDto materia;

    private Double calificacion;

}
