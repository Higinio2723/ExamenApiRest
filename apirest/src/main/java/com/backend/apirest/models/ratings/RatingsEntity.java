package com.backend.apirest.models.ratings;

import com.backend.apirest.models.students.StudentsEntity;
import com.backend.apirest.models.subjects.SubjectsEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="t_calificaciones")
public class RatingsEntity implements Serializable {
    @Id
    @Column(name = "id_t_calificaciones", columnDefinition = "serial")
    @Generated(GenerationTime.INSERT)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_t_materias", referencedColumnName = "id_t_materias ")
    private SubjectsEntity subject;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_t_usuarios", referencedColumnName = "id_t_usuarios")
    private StudentsEntity student;

    @Column(nullable = false, name = "calificacion", columnDefinition="DECIMAL(10,2)")
    private Double qualification;


    @Column(name = "fecha_registro")
    private Date registrationDate;



}
