package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie){
       return movieRepository.addMovie(movie);
    }
    public String addDirector(Director director){
       return movieRepository.addDirector(director);
    }

    public String movieDirectorPair(String movieName, String directorName){
      return movieRepository.movieDirectorPair(movieName,directorName);
    }

    public Movie findMovie(String movieName){
        return movieRepository.findMovie(movieName);
    }

    public Director findDirector(String directorName){
        return movieRepository.findDirector(directorName);
    }

    public List<String> findMoviesByDirector(String directorName){
        return movieRepository.findMoviesByDirector(directorName);
    }

    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    public void deleteMoviesOfDirector(String director){
       movieRepository.deleteMoviesOfDirector(director);

    }

    public void deleteAllDirMov(){
        movieRepository.deleteAllDirMov();
    }
}
