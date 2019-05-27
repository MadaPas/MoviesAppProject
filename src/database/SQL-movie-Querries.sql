DROP DATABASE imovie;
CREATE DATABASE IF NOT EXISTS imovie;

USE imovie;

CREATE TABLE IF NOT EXISTS movie (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    dir_name VARCHAR(255),
    release_date INT,
    genre VARCHAR(100),
    rating DOUBLE,
    is_series VARCHAR(100),
    no_episodes INT,
    episode_duration INT
    );

INSERT INTO movie (name, dir_name, release_date, genre, rating, is_series, no_episodes, episode_duration)
VALUES  ('Captain America: The First Avenger', 'Joe Johnson', 2011, 'Action, Adventure, Sci-Fi', 6.9, 'no', 1, 124),
		('Agent Carter (2015-2016)', 'Jennifer Getzinger, Metin Huseyin', 2015, 'Action, Adventure, Sci-Fi', 8.0,'yes, 2 seasons', 18, 42),
		('Captain Marvel', 'Anna Boden, Ryan Fleck', 2019, 'Action, Adventure, Sci-Fi', 7.1,'no', 1, 123),
		('Iron Man', 'Jon Favreau', 2008, 'Action, Adventure, Sci-Fi', 7.9,'no', 1, 126),
		('Iron Man 2', 'Jon Favreau', 2010, 'Action, Adventure, Sci-Fi', 7.0,'no', 1, 124),
		('The Incredible Hulk', 'Louis Leterrier', 2008, 'Action, Adventure, Sci-Fi', 6.7,'no', 1, 118),        
		('Thor', 'Kenneth Branagh', 2011, 'Action, Adventure, Fantasy', 7.0,'no', 1, 115),
		('Avengers Assemble (2013-now)', 'Jeff Allen, Eric Radomski', 2013, 'Animation, Action, Adventure, Sci-Fi', 7.0,'yes, 5 seasons', 126, 23),
		('Iron Man 3', 'Shane Black', 2013, 'Action, Adventure, Sci-Fi', 7.2,'no', 1, 130),
        ('Agent of S.H.I.E.L.D. (2013-present)', 'Kevin Tancharoen, Jesse Bochoco', 2013, 'Action, Adventure, Drama, Sci-Fi, Thriller', 7.5,'yes, 6 seasons and counting', 90, 45),
        ('Thor: The Dark World', 'Alan Taylor', 2013, 'Action, Adventure, Fantasy', 6.9,'no', 1, 118),
		('Captain America: The Winter Soldier', 'Anthony Russo, Joe Russo', 2014, 'Action, Adventure, Sci-Fi', 7.8,'no', 1, 136),
		('Guardians of the Galaxy', 'James Gunn', 2014, 'Action, Adventure, Comedy', 8.1,'no', 1, 121),
		('Guardians of the Galaxy vol 2', 'James Gunn', 2017, 'Action, Adventure, Comedy', 7.7,'no', 1, 126),
		('Daredevil (2015 - 2018)', 'Phil Abraham, Stephen Surjik', 2015, 'Action, Crime, Drama, Fantasy', 8.7,'yes, 3 seasons', 39, 54),
		('Jessica Jones (2015 - present)', 'Uta Briesewitz, Rosemary Rodriguez', 2015, 'Action, Crime, Drama, Sci-Fi, Thriller', 8.0,'yes, 2 seasons and counting', 26, 56),
        ('Avengers: Age Of Ultron', 'Joss Whedon', 2015, 'Action, Adventure, Sci-Fi', 7.3,'no', 1, 131),
        ('Luke Cage (2016 - 2018)', 'Andy Goddard, Marc Jobst', 2016, 'Action, Crime, Drama, Sci-Fi, Thriller', 7.4,'yes, 2 seasons', 23, 55),
        ('Ant Man', 'Peyton Reed', 2015, 'Action, Adventure, Comedy', 7.3,'no', 1, 117),
        ('Iron Fist (2017 - 2018)', 'Stephen Surjik, John Dahl', 2017, 'Action, Adventure, Crime, Fantasy, Sci-Fi', 6.6,'yes, 2 seasons', 23, 55),
        ('Captain America: Civil War', 'Anthony Russo, Joe Russo', 2016, 'Action, Adventure, Sci-Fi', 7.8,'no', 1, 147),
        ('The Defenders (2017)', 'S.J. Clarkson, Phil Abraham', 2017, 'Action, Adventure, Crime, Fantasy, Sci-Fi', 7.4,'yes, one season', 8, 50),
        ('Doctor Strange', 'Scott Derrickson', 2016, 'Action, Adventure, Fantasy', 7.5,'no', 1, 115),
        ('Black Panther', 'Ryan Coogler', 2018, 'Action, Adventure, Sci-Fi', 7.3,'no', 1, 134),
        ('Spider-Man: Homecoming', 'Jon Watts', 2017, 'Action, Adventure, Sci-Fi', 7.5,'no', 1, 133),
        ('Thor: Ragnarok', 'Taika Waititi', 2017, 'Action, Adventure, Comedy', 7.9,'no', 1, 130),
        ('Inhumans', 'Chris Fisher, Roel Reine', 2017, 'Action, Adventure, Sci-Fi', 5.1,'yes', 8, 43),
        ('The Punisher (2017 - 2019)', 'Jim Hanlon, Jeremy Weeb', 2017, 'Action, Adventure, Crime, Drama, Sci-Fi, Thriller', 8.6,'yes, 2 seasons', 26, 53),
        ('Runaways (2017 - present)', 'Jeffrey W. Byrd, Ramsey Nickell', 2017, 'Action, Drama, Sci-Fi', 7.2,'yes, 2 seasons and counting', 23, 60),
        ('Cloak & Dagger (2018 - present)', 'Ami Cannan Mann, Jennifer Phang', 2018, 'Action, Adventure, Drama, Sci-Fi', 6.9,'yes, 2 seasons', 20, 44),
        ('Ant-Man and the Wasp', 'Peyton Reed', 2018, 'Action, Adventure, Comedy', 7.1,'no', 1, 118),
        ('Avengers: Infinity War', 'Anthony Russo, Joe Russo', 2018, 'Action, Adventure, Sci-Fi', 8.5,'no', 1, 149),
        ('Avengers: Endgame', '', 2019, 'Action, Adventure, Sci-Fi', 8.8,'no', 1, 181);
        
        
        
        
        
        
        
        
        
        
        