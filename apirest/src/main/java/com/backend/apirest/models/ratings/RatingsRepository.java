package com.backend.apirest.models.ratings;


import com.backend.apirest.models.ratings.dto.RatingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingsRepository extends JpaRepository<RatingsEntity, Integer > {


    @Query(value = "SELECT new com.backend.apirest.models.ratings.dto.RatingDto(" +
            " r.id, s.id, s.name, s.lastName , su.name , " +
            " r.qualification , r.registrationDate) " +
            " FROM RatingsEntity r INNER JOIN StudentsEntity s ON (r.student.id = s.id " +
            " AND s.enabled = 1 )" +
            " INNER JOIN SubjectsEntity su   ON ( r.subject.id =  su.id  AND su.enabled = 1 )" +
            " WHERE s.id =:idStudent ORDER BY r.id "
    )
    List<RatingDto> findAllByStudentId(@Param("idStudent") Integer idStudent);

}
