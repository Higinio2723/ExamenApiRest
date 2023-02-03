package com.backend.apirest.models.subjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService implements ISubjectService {

    @Autowired
    SubjectsRepository subjectsRepository;

    @Override
    public SubjectsEntity findById(Integer id) {
        return subjectsRepository.findById(id).get();
    }

    @Override
    public List<SubjectsEntity> findAll() {
        return subjectsRepository.findAll();
    }
}
