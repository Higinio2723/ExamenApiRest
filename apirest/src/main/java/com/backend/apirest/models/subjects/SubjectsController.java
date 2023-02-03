package com.backend.apirest.models.subjects;

import com.backend.apirest.models.students.StudentsController;
import com.backend.apirest.models.students.StudentsEntity;
import com.backend.apirest.models.students.StudentsService;
import com.backend.apirest.models.students.dto.StudentDto;
import com.backend.apirest.models.subjects.dto.SubjectDto;
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
public class SubjectsController {

    private final Logger logger = LoggerFactory.getLogger(SubjectsController.class);

    @Autowired
    SubjectService subjectService;

    @GetMapping("/subjects/{idSubject}")
    public ResponseEntity<Object> findSubjectById(@PathVariable(name = "idSubject" , required = true)  Integer idSubject) {

        ResponseEntity<Object> result = null;

        SubjectsEntity subjects = subjectService.findById(idSubject);

        Map<String, SubjectDto> data = new HashMap();


        data.put("subject",SubjectDto.builder()
                .idMateria(subjects.getId())
                .nombre(subjects.getName())
                .build());

        result = new ResponseEntity<>(data, HttpStatus.OK);

        return result;
    }


    @GetMapping("/subjects")
    public ResponseEntity<Object> findSubjects() {

        ResponseEntity<Object> result = null;

        List<SubjectsEntity> subjects = subjectService.findAll();
        List<SubjectDto> subjectDtos = new ArrayList<>();

        subjects.forEach(subject -> {
            subjectDtos.add(SubjectDto.builder()
                    .idMateria(subject.getId())
                    .nombre(subject.getName())
                    .build());
        });
        Map<String, List<SubjectDto>> data = new HashMap();


        data.put("subjects", subjectDtos);


        result = new ResponseEntity<>(data, HttpStatus.OK);

        return result;
    }

}
