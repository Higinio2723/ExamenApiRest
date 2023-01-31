package com.backend.apirest.moule.ratings.dto;

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
    private Double calificacion;

}
