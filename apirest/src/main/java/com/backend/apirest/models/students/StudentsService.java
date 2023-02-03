package com.backend.apirest.models.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService implements IStudentsService{

    @Autowired
    StudentsRepository studentsRepository;

    @Override
    public StudentsEntity findByIdStudent(Integer id) {
        return studentsRepository.findById(id).get();
    }

    @Override
    public List<StudentsEntity> findAll() {
        List<StudentsEntity> list = studentsRepository.findAll();
        return list;
    }
}
