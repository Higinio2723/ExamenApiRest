package com.backend.apirest.models.students;

import com.backend.apirest.models.ratings.RatingsController;
import com.backend.apirest.models.ratings.RatingsService;
import com.backend.apirest.models.ratings.dto.RatingDto;
import com.backend.apirest.models.ratings.dto.RatingFormatDto;
import com.backend.apirest.models.ratings.dto.RatingGeneralDto;
import com.backend.apirest.models.students.dto.StudentDto;
import com.backend.apirest.util.FormatUtil;
import com.backend.apirest.util.ValidationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentsController {


    private final Logger logger = LoggerFactory.getLogger(StudentsController.class);

    @Autowired
    StudentsService studentsService;

    @GetMapping("/students/{idStudent}")
    public ResponseEntity<Object> findStudentById(@PathVariable(name = "idStudent" , required = true)  Integer idStudent) {

        ResponseEntity<Object> result = null;

        StudentsEntity student = studentsService.findByIdStudent(idStudent);

        Map<String, StudentDto> data = new HashMap();


        data.put("student",StudentDto.builder()
                        .idStudent(student.getId())
                        .nombreCompleto(student.getName().concat(" ").concat(student.getLastName().concat(" ").concat(student.getSecondLastName())))
                .build());

        result = new ResponseEntity<>(data, HttpStatus.OK);

        return result;
    }


    @GetMapping("/students")
    public ResponseEntity<Object> findStudents() {

        ResponseEntity<Object> result = null;

        List<StudentsEntity> students = studentsService.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();

        students.forEach(student -> {
            studentDtos.add(StudentDto.builder()
                    .idStudent(student.getId())
                    .nombreCompleto(student.getName().concat(" ").concat(student.getLastName().concat(" ").concat(student.getSecondLastName())))
                    .build());
        });
        Map<String, List<StudentDto>> data = new HashMap();


        data.put("students", studentDtos);


        result = new ResponseEntity<>(data, HttpStatus.OK);

        return result;
    }


}
