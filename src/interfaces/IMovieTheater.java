package interfaces;

import java.util.ArrayList;

import model.MovieTheater;

public interface IMovieTheater {

	void create(MovieTheater movies);
	void remove(String movies);
	void search(String movies);
	void sort();
	void average();
	
}
