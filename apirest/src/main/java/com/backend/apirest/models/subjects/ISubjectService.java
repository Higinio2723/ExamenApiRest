package com.backend.apirest.models.subjects;

import java.util.List;

public interface ISubjectService {

    SubjectsEntity findById(Integer id);

    List<SubjectsEntity> findAll();

}
