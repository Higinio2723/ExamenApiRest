package com.backend.apirest.models.ratings.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {

   private Integer id_t_usuario;
   private String nombre;
   private String apellido;
   private String materia;
   private Double calificacion;
   private Date fecha_registro;


}
