package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {

 private   HashMap<String,Movie> movieMap;
  private  HashMap<String,Director> directorMap;
  private  HashMap<String, List<String>> directorMovieMap;

    public MovieRepository(){
        this.movieMap= new HashMap<String,Movie>();
        this.directorMap= new HashMap<String,Director>();
        this.directorMovieMap = new HashMap<String,List<String>>();
    }

    public String addMovie(Movie movie){
        movieMap.put(movie.getName(), movie);
        return "movie added successfully";
    }
    public String addDirector(Director director){
        directorMap.put(director.getName(), director);
        return "director added successfully";
    }

    public String movieDirectorPair(String movieName, String directorName){
        if(movieMap.containsKey(movieName) && directorMap.containsKey(directorName)){
            List<String> pairs = new ArrayList<>();
            if(directorMovieMap.containsKey(directorName)){
                pairs = directorMovieMap.get(directorName);
            }
            pairs.add(movieName);
            directorMovieMap.put(directorName,pairs);

            return "pair created";
        }

        return "Invalid director or Movie name";
    }

    public Movie findMovie(String movieName){
        return movieMap.get(movieName);
    }

    public Director findDirector(String directorName){
        return directorMap.get(directorName);
    }

    public List<String> findMoviesByDirector(String directorName){
        return directorMovieMap.get(directorName);
    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteMoviesOfDirector(String director){
        List<String> list = new ArrayList<>();
        if (directorMovieMap.containsKey(director)) {
            list = directorMovieMap.get(director);

            for(String movie: list){
                if(movieMap.containsKey(movie)){
                    movieMap.remove(movie);
                }
        }

            directorMovieMap.remove(director);
        }


            if(directorMap.containsKey(director)){
                directorMap.remove(director);
            }

    }

    public void deleteAllDirMov(){
//        for(String director: directorMovieMap.keySet()){
//            List<String> list = new ArrayList<>(directorMovieMap.get(director));
//            for(String movie: list){
//                if(movieMap.containsKey(movie)){
//                    movieMap.remove(movie);
//                }
//            }
//        }

        HashSet<String> moviesSet = new HashSet<String>();

        for(String director: directorMovieMap.keySet()){
            for(String movie: directorMovieMap.get(director)){
                moviesSet.add(movie);
            }
        }

        for(String movie: moviesSet){
            if(movieMap.containsKey(movie)){
                movieMap.remove(movie);
            }
        }

    }
}
