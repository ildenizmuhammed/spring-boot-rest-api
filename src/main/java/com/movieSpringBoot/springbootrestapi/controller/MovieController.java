package com.movieSpringBoot.springbootrestapi.controller;

import com.movieSpringBoot.springbootrestapi.model.Movie;
import com.movieSpringBoot.springbootrestapi.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(@RequestParam(required = false) String name){
        return new ResponseEntity<>(movieService.getMovies(name), OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable String id){
        return new ResponseEntity<>(getMovieById(id), OK);
    }

    private Movie getMovieById(String id) {
        return movieService.getMovieById(id);
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie newMovie){
        return new ResponseEntity<>(movieService.createMovie(newMovie), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMovie(@PathVariable String id, @RequestBody Movie newMovie){
        movieService.updateMovie(id,newMovie);
        return new ResponseEntity<>("updated successfully",OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable String id){
        movieService.deleteMovie(id);
        return new ResponseEntity<>("deleted successfully",OK);
    }
}


