package com.exam.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MovieController {

    @Autowired // Handle this field and create the object that needs to be created
    private MovieRepository movieRepo;

    private static List<Movie> movieList = new ArrayList<>();

    // from MySQL database  data
    @GetMapping("/movies")
    public String movie(Model model){
        movieList = movieRepo.findAllMovies();
        model.addAttribute("movies", movieList);
        model.addAttribute("newMovie", new Movie());
        return "movies-page";
    }

    // View of editing movies
    @GetMapping("/movies/edit/{index}")
    public String handleEditMovie(@PathVariable int index, Model model) {
        Movie editMovie = movieList.get(index);
        model.addAttribute("index", index);
        model.addAttribute("editMovie", editMovie);
        return "edit-movie";
    }

    @GetMapping(value = "/movies/add_movie")
    public String addMovie (Model model) {
        model.addAttribute("newMovie", new Movie ());
        return "add-movie";
    }

    @PostMapping(value = "/movies/add_movie")
    public String handleAddMovie (@ModelAttribute Movie movie) {
        movie = movieRepo.insert(movie);
        movieList.add(movie);
        return "redirect:/movies";
    }

    // Delete movie from MySQL database  and redirect back to /mymovie
    @GetMapping(value = "/movies/delete/{index}")
    public String handleDeleteMovie(@PathVariable int index) {
//        movieList.remove(index);
        movieRepo.deleteMovie(movieList.get(index));
        return "redirect:/movies";
    }

    // Add movie to MySQL database
    // Can also use @PostMapping which is short for the @RequestMapping with RequestMethod.POST
    @PostMapping(value = "/movies")
    public String handleAddMovie1(@ModelAttribute Movie movie) {
        //movieList.add(movie);
        movieRepo.saveMovie(movie);

        return "redirect:/movies";
    }

    @PostMapping(value = "/savemovie")
    public String saveMovie(@ModelAttribute Movie movie) {
        movie = movieRepo.insert(movie);
        return "redirect:/movies";
    }

    // Edit movie from MySQL database and redirect back to /mymovie
    @PostMapping(value = "/movies/edit/{index}")
    public String handleEditMovie(@PathVariable int index, @ModelAttribute Movie movie) {
//        movieList.set(index, movie);
        movieRepo.editMovie(movie, movieList.get(index));
        return "redirect:/movies";
    }
}