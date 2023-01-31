package com.backend.apirest.models.ratings;

import com.backend.apirest.models.ratings.dto.RatingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingsService implements IRatingsService{

    @Autowired
    RatingsRepository ratingsRepository;

    @Override
    public List<RatingDto> findByIdStudent(Integer id) {
        return ratingsRepository.findAllByStudentId(id);
    }
}
