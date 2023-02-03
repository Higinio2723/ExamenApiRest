package com.backend.apirest.models.subjects.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectDto {

    private Integer idMateria;

    private String nombre;

}
