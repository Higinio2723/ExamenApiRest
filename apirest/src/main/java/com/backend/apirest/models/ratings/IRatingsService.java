package com.backend.apirest.models.ratings;


import com.backend.apirest.models.ratings.dto.RatingDto;
import com.backend.apirest.models.ratings.dto.RatingsDataDto;

import java.util.List;

public interface IRatingsService {

    List<RatingDto> findByIdStudent(Integer id);

    void delete(Integer id);

    boolean existById(Integer id);

    void edit(RatingsDataDto id);

}
