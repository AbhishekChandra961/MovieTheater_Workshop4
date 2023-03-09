package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import interfaces.IMovieTheater;
import model.MovieTheater;

public class MovieTheaterImp implements IMovieTheater {

	public static ArrayList<MovieTheater> movieDetails = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	
	
	@Override
	public void create(MovieTheater movies) {
		
		movieDetails.add(movies);
		
	}

	@Override
	public void remove(String movies) {
		
		movieDetails
			.removeAll(movieDetails.stream()
						.filter(data->data.getMovies()
									.contains(movies)).collect(Collectors.toList()));
		
	}

	@Override
	public void search(String movies) {
		
		movieDetails.stream()
			.filter(data->data.getMovies()
					.contains(movies))
						.forEach(data->displayMovie(data));
		
	}

	
	private void sorted(ArrayList<MovieTheater> moviesDetails) {
		
		List<MovieTheater> sortedMovies = moviesDetails.stream()
											.sorted(Comparator.comparingInt(MovieTheater::getRating).reversed())
												.toList();
		for(MovieTheater movie : sortedMovies) {
			System.out.println("Movie Name : "+movie.getMovies()+" Rating : "+movie.getRating()+" Pricing : "+movie.getPrice());
		}
	}

	@Override
	public void sort(){
		 sorted(movieDetails);
	}
	
	private void displayMovie(MovieTheater movies) {
		if(null!=movies) {
			System.out.println("********Movie Theater*********");
			System.out.println("Movie Name : "+movies.getMovies());
			System.out.println("Rating : "+movies.getRating());
			System.out.println("Price : "+movies.getPrice());
		}
	}

	@Override
	public void average() {
		averageCalc(movieDetails);
	}
	
	private void averageCalc(ArrayList<MovieTheater> moviesDetails) {
		int averageRating = (int) moviesDetails.stream()
								.mapToInt(MovieTheater::getRating)
									.average()
										.orElse(0.0);
		
		System.out.println("Average Rating of Movies are : "+ averageRating);
	}
}
