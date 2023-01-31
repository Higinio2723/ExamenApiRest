package com.backend.apirest.moule.ratings;


import com.backend.apirest.moule.ratings.dto.RatingDto;
import com.backend.apirest.moule.ratings.dto.RatingsDataDto;

import java.util.List;

public interface IRatingsService {

    List<RatingDto> findByIdStudent(Integer id);

    void delete(Integer id);

    boolean existById(Integer id);

    void edit(RatingsDataDto ratingsDataDto);

    void save(RatingsDataDto ratingsDataDto);

}
