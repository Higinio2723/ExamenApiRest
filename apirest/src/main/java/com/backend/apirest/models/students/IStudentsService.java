package com.backend.apirest.models.students;

import com.backend.apirest.models.ratings.dto.RatingDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IStudentsService {

    StudentsEntity findByIdStudent(Integer id);

    List<StudentsEntity> findAll();

}
