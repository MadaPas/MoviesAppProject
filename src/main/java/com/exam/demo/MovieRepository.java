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


    // Find all movies from database table movies
    public List<Movie> findAllMovies() {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM movie");
        List<Movie> movieList = new ArrayList<>();
        while (rs.next()) {
            Movie movie = new Movie();
            movie.setId(rs.getInt("id"));
            movie.setName(rs.getString("name"));
            movie.setDirName(rs.getString("dir_name"));
            movie.setReleaseDate(rs.getInt("release_date"));
            movie.setGenre(rs.getString("genre"));
            movie.setRating(rs.getDouble("rating"));
            movie.setIsSeries(rs.getString("is_series"));
            movie.setNoEpisodes(rs.getInt("no_episodes"));
            movie.setDuration(rs.getInt("episode_duration"));
            movieList.add(movie);
        }
        return movieList;
    }

    // Adding a movie to the MySQL database with JDBCtemplate.update
    public void saveMovie(Movie movie) {
        String query = String.format("INSERT INTO movie (name, dir_name, release_date, genre, rating, is_series, no_episodes, episode_duration) " +
                        " VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                movie.getName(), movie.getDirName(), movie.getReleaseDate(), movie.getGenre(), movie.getRating(), movie.getIsSeries(), movie.getNoEpisodes(), movie.getDuration());
        jdbc.update(query);
    }

    // Alex's version with PreparedStatement
    public Movie insert(Movie movie) {

        PreparedStatementCreator ps = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO movie VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)", new String[]{"id"});
                ps.setString(1, movie.getName());
                ps.setString(2, movie.getDirName());
                ps.setInt(3, movie.getReleaseDate());
                ps.setString(4, movie.getGenre());
                ps.setDouble(5, movie.getRating());
                ps.setString(6, movie.getIsSeries());
                ps.setInt(7, movie.getNoEpisodes());
                ps.setInt(8, movie.getDuration());

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

        PreparedStatementCreator ps = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("DELETE FROM movie WHERE id = ?");
                ps.setInt(1, movie.getId());

                return ps;
            }
        };

        jdbc.update(ps);

    }

    // Editing a movie inside the MySQL database with JDBCtemplate.update
    public void editMovie(Movie movie1, Movie movie2) {
        PreparedStatementCreator ps = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("UPDATE movie SET " +
                        "name = ?, " +
                        "dir_name = ?, " +
                        "release_date = ?, " +
                        "genre = ?, " +
                        "rating = ?, " +
                        "is_series = ?, " +
                        "no_episodes = ?, " +
                        "episode_duration = ? " +
                        "WHERE id = ?");
                ps.setString(1, movie1.getName());
                ps.setString(2, movie1.getDirName());
                ps.setInt(3, movie1.getReleaseDate());
                ps.setString(4, movie1.getGenre());
                ps.setDouble(5, movie1.getRating());
                ps.setString(6, movie1.getIsSeries());
                ps.setInt(7, movie1.getNoEpisodes());
                ps.setInt(8, movie1.getDuration());
                ps.setInt(9, movie2.getId());

                return ps;
            }
        };

        jdbc.update(ps);

    }
}
