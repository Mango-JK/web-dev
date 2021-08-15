package com.edy.blog.springboot.repository;

import com.edy.blog.springboot.config.NaverProperties;
import com.edy.blog.springboot.domain.Movie;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class MovieRepositoryImpl implements MovieRepository{

	private final RestTemplate restTemplate;
	private final NaverProperties naverProperties;

	public MovieRepositoryImpl(RestTemplate restTemplate, NaverProperties naverProperties) {
		this.restTemplate = restTemplate;
		this.naverProperties = naverProperties;
	}

	@Override
	public List<Movie> findByQuery(String query) {
		return null;
	}
}
