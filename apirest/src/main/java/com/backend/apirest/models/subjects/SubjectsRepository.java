package com.backend.apirest.models.subjects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectsRepository extends JpaRepository<SubjectsEntity, Integer > {
}
