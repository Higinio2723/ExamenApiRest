package com.backend.apirest.models.students;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="t_alumnos")
public class StudentsEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_t_usuarios",unique=true, nullable = false)
    private Integer id;

    @Column(nullable = false, name = "nombre" , length = 80)
    private String name;

    @Column(nullable = false, name = "ap_paterno" , length = 80)
    private String lastName;

    @Column(nullable = false, name = "ap_materno" , length = 80)
    private String secondLastName;

    @Column(nullable = false, name = "activo", columnDefinition="numeric(1)")
    private Integer enabled;


}
