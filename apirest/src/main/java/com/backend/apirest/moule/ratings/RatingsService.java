package com.backend.apirest.moule.ratings;

import com.backend.apirest.moule.ratings.dto.RatingDto;
import com.backend.apirest.moule.ratings.dto.RatingsDataDto;
import com.backend.apirest.moule.students.StudentsEntity;
import com.backend.apirest.moule.students.StudentsRepository;
import com.backend.apirest.moule.subjects.SubjectsEntity;
import com.backend.apirest.moule.subjects.SubjectsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RatingsService implements IRatingsService{

    private final Logger logger = LoggerFactory.getLogger(RatingsService.class);

    @Autowired
    RatingsRepository ratingsRepository;

    @Autowired
    StudentsRepository studentsRepository;

    @Autowired
    SubjectsRepository subjectsRepository;

    @Override
    public List<RatingDto> findByIdStudent(Integer id) {
        return ratingsRepository.findAllByStudentId(id);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        ratingsRepository.deleteById(id);
    }

    @Override
    public boolean existById(Integer id) {
        return ratingsRepository.existsById(id);
    }

    @Override
    public void edit(RatingsDataDto ratingsDataDto) {
        Optional<RatingsEntity> ratingsEntity =  ratingsRepository.findById(ratingsDataDto.getId());
        RatingsEntity data = ratingsEntity.get();
        data.setQualification(ratingsDataDto.getCalificacion());

        ratingsRepository.save(data);
    }

    @Override
    @Transactional
    public void save(RatingsDataDto ratingsDataDto) {
        logger.info("############### {}",ratingsDataDto);
        Optional<StudentsEntity> student = studentsRepository.findById(ratingsDataDto.getIdAlumno());
        Optional<SubjectsEntity> subject = subjectsRepository.findById(ratingsDataDto.getIdMateria());

        StudentsEntity studentData = student.get();

        logger.info("################ studentData {}",studentData);

        RatingsEntity ratingsEntity = RatingsEntity.builder()
                .student(studentData)
                .subject(subject.get())
                .qualification(ratingsDataDto.getCalificacion())
                .build();

        ratingsRepository.save(ratingsEntity);
    }


}
