package com.edy.blog.springboot.service;

import com.edy.blog.springboot.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {

	public List<Movie> query(final String query) {
		return Arrays.asList(
			Movie.builder().title("movie1").link("http://test.com").build(),
			Movie.builder().title("movie2").link("http://test2.com").build()
		);
	}
}
