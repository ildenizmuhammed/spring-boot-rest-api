package com.movieSpringBoot.springbootrestapi.service;

import com.movieSpringBoot.springbootrestapi.repository.MovieRepository;
import com.movieSpringBoot.springbootrestapi.model.Movie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getMovies(String name) {
        if(name == null){
            return movieRepository.findAll();
        }
        else {
            return movieRepository.findByName(name);
        }
    }

    public Movie getMovieById(String id) {
        return movieRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("id not found!"));
    }

    public Movie createMovie(Movie newMovie) {
        return movieRepository.save(newMovie);
    }

    public void updateMovie(String id, Movie newMovie) {
        Movie oldMovie = getMovieById(id);
        oldMovie.setName(newMovie.getName());
        oldMovie.setDirector(newMovie.getDirector());
        oldMovie.setYear(newMovie.getYear());
        movieRepository.save(oldMovie);

    }

    public void deleteMovie(String id) {
        movieRepository.deleteById(id);
    }
}
