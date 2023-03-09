package controller;

import java.util.ArrayList;
import java.util.Scanner;

import interfaces.IMovieTheater;
import model.MovieTheater;
import service.MovieTheaterImp;

public class MovieTheaterMain {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		IMovieTheater obj = new MovieTheaterImp();
		
		int choice =0;
		try {
		do {
			System.out.println("********Movie Theater***********");
			System.out.println("Enter 1 to add movie");
			System.out.println("Enter 2 to remove movie");
			System.out.println("Enter 3 to search movie");
			System.out.println("Enter 4 to sort by rating");
			System.out.println("Enter 5 for calculating average rating");
			
			switch(sc.nextInt()) {
			case 1:
				System.out.println("Creating movies");
				obj.create(getMovie());
				break;
			case 2:
				System.out.println("Enter the Movie Name to remove : ");
				String nameR = sc.next();
				obj.remove(nameR);
			case 3:
				System.out.println("Enter the Mobie Name to Search : ");
				String nameS = sc.next();
				obj.search(nameS);
			case 4:
				obj.sort();
			case 5:
				obj.average();
			}
			
			System.out.println("Enter 1 to continue : ");
			choice = sc.nextInt();
		}while(choice==1);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	private static MovieTheater getMovie() {
		
		MovieTheater movie = new MovieTheater();
		
		System.out.println("Enter the Moive Name : ");
		String movieName = sc.next();
		movie.setMovies(movieName);
		
		System.out.println("Enter the Rating : ");
		int rating = sc.nextInt();
		movie.setRating(rating);
		
		System.out.println("Enter the Price : ");
		int price = sc.nextInt();
		movie.setPrice(price);
		
		return movie;
	}
}
