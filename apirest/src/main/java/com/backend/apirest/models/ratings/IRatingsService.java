package com.backend.apirest.models.ratings;


import com.backend.apirest.models.ratings.dto.RatingDto;

import java.util.List;

public interface IRatingsService {

    List<RatingDto> findByIdStudent(Integer id);

    boolean delete(Integer id);
}
