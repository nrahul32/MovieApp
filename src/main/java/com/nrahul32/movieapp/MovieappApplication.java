package com.nrahul32.movieapp;

import com.nrahul32.movieapp.dao.CustomerDao;
import com.nrahul32.movieapp.dao.MovieDao;
import com.nrahul32.movieapp.entities.Customer;
import com.nrahul32.movieapp.entities.Movie;
import com.nrahul32.movieapp.services.MovieService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@SpringBootApplication
public class MovieappApplication {

	public static void main(String[] args) {
		// SpringApplication.run returns ApplicationContext object
		ApplicationContext context = SpringApplication.run(MovieappApplication.class, args);

		// myService bean is created only in qa profile
		System.out.println("Total beans: " + context.getBeanDefinitionCount());
		System.out.println("myService bean created: " + Arrays.stream(context.getBeanDefinitionNames()).collect(Collectors.toList()).contains("myService"));

		// creating a customer object
		CustomerDao customerDao = context.getBean(CustomerDao.class);
		Customer customer = new Customer();
		customer.setFirstName("FName");
		customer.setLastName("LName");
		customer.setUserName("UName");
		customer.setPassword("****");
		customer.setDateOfBirth(LocalDateTime.of(1989, 12, 23, 0, 0));

		// performing read, update, delete operations using methods from cutomerDao
		System.out.println("Before saving: " + customer.toString());
		Customer savedCustomer = customerDao.save(customer);
		System.out.println("After saving: " + savedCustomer.toString());

		System.out.println("Before updating: " + customer.toString());
		customer.setUserName("UpdatedUName");
		Customer updatedCustomer = customerDao.update(customer);
		System.out.println("After saving: " + updatedCustomer.toString());

		System.out.println("Before deleting: " + customerDao.findById(customer.getCustomerId()));
		customerDao.delete(customer);
		System.out.println("After deleting: " + customerDao.findById(customer.getCustomerId()));

		// Creating a Movie object
		MovieDao movieDao = context.getBean(MovieDao.class);
		Movie movie = new Movie();
		movie.setMovieName("Avengers");
		movie.setMovieDescription("A super hero movie by marvel");
		movie.setReleaseDate(LocalDateTime.of(2005, 7,4,12,0));
		movie.setCoverPhotoUrl("Cover photo url");
		movie.setTrailerUrl("Trailer photo url");

		// Save operation
		System.out.println("Before saving: " + movie.toString());
		Movie savedMovie = movieDao.save(movie);
		System.out.println("After saving: " + savedMovie.toString());

		// Finding movie by Id
		Movie retrievedMovie = movieDao.findById(movie.getMovieId()).orElse(null);
		System.out.println("After retrieving: " + retrievedMovie);

		// Updating
		movie.setDuration(160);
		Movie updatedMovie = movieDao.save(movie);
		System.out.println("After updating: " + updatedMovie.toString());

		// Deleting
		movieDao.delete(movie);
		System.out.println("After deleting: " + movieDao.findById(movie.getMovieId()).orElse(null));

		// Testing Movie service
		MovieService movieService = context.getBean(MovieService.class);
		System.out.println("MovieService bean :" + movieService);
		Movie movie1 = new Movie();
		movie1.setMovieName("Avengers");
		movie1.setMovieDescription("A super hero movie by marvel");
		movie1.setReleaseDate(LocalDateTime.of(2005, 7,4,12,0));
		movie1.setCoverPhotoUrl("Cover photo url");
		movie1.setTrailerUrl("Trailer photo url");

		Movie addedMovie = movieService.acceptMovieDetails(movie1);
		System.out.println("After saving: " + addedMovie.toString());

		Movie searchedMovie = movieService.getMovieDetails(addedMovie.getMovieId());
		System.out.println("Searched movie: " + searchedMovie.toString());
	}

	// This will be hit on navigating to http://localhost:8080/
	@RequestMapping(value = "/")
	public String HelloWorld(){
		return "Hello world!";
	}

}
