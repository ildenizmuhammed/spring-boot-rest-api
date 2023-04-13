package com.movieSpringBoot.springbootrestapi.repository;

import com.movieSpringBoot.springbootrestapi.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie,String> {
    List<Movie> findByName(String name);
}
