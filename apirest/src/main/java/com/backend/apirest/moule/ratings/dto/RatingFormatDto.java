package com.backend.apirest.moule.ratings.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RatingFormatDto {

   private Integer id_t_usuario;
   private String nombre;
   private String apellido;
   private String materia;
   private Double calificacion;
   private String fecha_registro;


}