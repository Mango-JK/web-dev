package com.whiteship.demospringboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner {

	@Value("${my.duration:20s}")
	private String duration;

	@Value("${print:20}")
	private int print;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("Print : " + print);
		log.info("Duration : " + duration);
	}
}
