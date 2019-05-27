package com.exam.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {


    @Autowired // Handle this field and create the object that needs to be created
    private JdbcTemplate jdbc;


//    // find specific movie in table movies from database imovie by id
//    public Movie findMovie(int id) {
//        // Create query for sql and parse an object into class
//        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM movies_app WHERE id = " + id);
//        Movie movie = new Movie();
//        while (rs.next()) {
//            movie.setId(rs.getInt("id"));
//            movie.setName(rs.getString("name"));
//            movie.setDirSurname(rs.getString("dir_surname"));
//            movie.setDirForename(rs.getString("dir_forename"));
//            movie.setReleaseDate(rs.getInt("release_date"));
//            movie.setGenre(rs.getString("genre"));
//            movie.setRating(rs.getDouble("rating"));
//            movie.setDuration(rs.getInt("duration"));
//
//        }
//            return movie;
//    }

    // Find all movies from database table movies
    public List<Movie> findAllMovies() {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM movie");
        List<Movie> movieList = new ArrayList<>();
        while (rs.next()) {
            Movie movie = new Movie();
            movie.setId(rs.getInt("id"));
            movie.setName(rs.getString("name"));
            movie.setDirSurname(rs.getString("dir_surname"));
            movie.setDirForename(rs.getString("dir_forename"));
            movie.setReleaseDate(rs.getInt("release_date"));
            movie.setGenre(rs.getString("genre"));
            movie.setRating(rs.getDouble("rating"));
            movie.setDuration(rs.getInt("duration"));
            movieList.add(movie);
        }
        return movieList;
    }

    // Adding a movie to the MySQL database with JDBCtemplate.update
    public void saveMovie(Movie movie) {
        String query = String.format("INSERT INTO movie (name, dir_surname, dir_forename, release_date, genre, rating, duration) " +
                        " VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                movie.getName(), movie.getDirSurname(), movie.getDirForename(), movie.getReleaseDate(), movie.getGenre(), movie.getRating(), movie.getDuration());
        jdbc.update(query);
    }

    // Alex's version with PreparedStatement
    public Movie insert(Movie movie) {

        PreparedStatementCreator ps = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO movie VALUES (null, ?, ?, ?, ?, ?, ?, ?)", new String[]{"id"});
                ps.setString(1, movie.getName());
                ps.setString(2, movie.getDirSurname());
                ps.setString(3, movie.getDirForename());
                ps.setInt(4, movie.getReleaseDate());
                ps.setString(4, movie.getGenre());
                ps.setDouble(4, movie.getRating());
                ps.setInt(4, movie.getDuration());

                return ps;
            }
        };

        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbc.update(ps, keyholder);
        movie.setId(keyholder.getKey().intValue());
        return movie;

    }

    // Deleting a movie inside the MySQL database with JDBCtemplate.update
    public void deleteMovie(Movie movie) {
        String query = "DELETE FROM movie WHERE id = " + movie.getId();
        jdbc.update(query);
    }

    // Editing a movie inside the MySQL database with JDBCtemplate.update
    public void editMovie(Movie movie1, Movie movie2) {
        String query = String.format(("UPDATE movie "
                        + "SET name = '%s', "
                        + "dir_surname = '%s', "
                        + "dir_forename = '%s', "
                        + "release_date = '%s', "
                        + "genre = '%s', "
                        + "rating = '%s', "
                        + "duration = '%s' "
                        + "WHERE id = %s"),

                movie1.getName(), movie1.getDirSurname(), movie1.getDirForename(), movie1.getReleaseDate(), movie1.getGenre(), movie1.getRating(), movie1.getDuration(), movie2.getId());
        jdbc.update(query);
    }
}
