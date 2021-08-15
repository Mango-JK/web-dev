package com.edy.blog.springboot.repository;

import com.edy.blog.springboot.domain.Movie;

import java.util.List;

public interface MovieRepository {
	List<Movie> findByQuery(String query);
}
