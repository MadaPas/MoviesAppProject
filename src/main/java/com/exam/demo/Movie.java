package com.exam.demo;


public class Movie {

    private int id;
    private String name;
    private String dirName;
    private int releaseDate;
    private String genre;
    private double rating;
    private String isSeries;
    private int noEpisodes;
    private int duration;

    public Movie () {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getIsSeries() {
        return isSeries;
    }

    public void setIsSeries(String isSeries) {
        this.isSeries = isSeries;
    }

    public int getNoEpisodes() {
        return noEpisodes;
    }

    public void setNoEpisodes(int noEpisodes) {
        this.noEpisodes = noEpisodes;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", dirName='" + dirName + '\'' +
                ", releaseDate=" + releaseDate +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", isSeries='" + isSeries + '\'' +
                ", noEpisodes='" + noEpisodes +
                ", duration=" + duration +
                '}';
    }
}