package com.exam.demo;


public class Movie {

    private int id;
    private String name;
    private String dirSurname;
    private String dirForename;
    private int releaseDate;
    private String genre;
    private double rating;
    private int duration;

    public Movie () {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDirSurname() {
        return dirSurname;
    }

    public String getDirForename() {
        return dirForename;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDirSurname(String dirSurname) {
        this.dirSurname = dirSurname;
    }

    public void setDirForename(String dirForename) {
        this.dirForename = dirForename;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", dirSurname='" + dirSurname + '\'' +
                ", dirForename='" + dirForename + '\'' +
                ", releaseDate=" + releaseDate +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", duration=" + duration +
                '}';
    }
}