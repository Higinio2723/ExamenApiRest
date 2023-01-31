package com.backend.apirest.util.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class GenericResponse {

    private Long timestamp;
    private Integer status;
    private String error;
    private List<String> message;
    private String path;

}
