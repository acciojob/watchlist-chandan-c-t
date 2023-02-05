package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
         movieService.addMovie(movie);
         return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector( @RequestBody Director director){
         movieService.addDirector(director);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public  ResponseEntity<String> movieDirectorPair(@RequestParam("movieName") String movieName,@RequestParam("directorName") String directorName){
         movieService.movieDirectorPair(movieName,directorName);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{movieName}")
    public ResponseEntity<Movie> findMovie(@PathVariable("movieName") String movieName){
        Movie movie =  movieService.findMovie(movieName);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{directorName}")
    public ResponseEntity<Director> findDirector(@PathVariable("directorName") String directorName){
        Director director= movieService.findDirector(directorName);
        return new ResponseEntity<>(director, HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{directorName}")
    public ResponseEntity<List<String>> findMoviesByDirector(@PathVariable("directorName") String directorName){
        List<String> list =  movieService.findMoviesByDirector(directorName);
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> list =  movieService.findAllMovies();
        return new ResponseEntity<>(list,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteMoviesOfDirector(@RequestParam("director") String director){
       movieService.deleteMoviesOfDirector(director);
       return new ResponseEntity<>("success",HttpStatus.CREATED);

    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirMov(){
        movieService.deleteAllDirMov();
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
}
