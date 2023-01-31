package com.backend.apirest.models.ratings;

import com.backend.apirest.models.ratings.dto.RatingDto;
import com.backend.apirest.models.ratings.dto.RatingsDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RatingsService implements IRatingsService{

    @Autowired
    RatingsRepository ratingsRepository;

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


}
