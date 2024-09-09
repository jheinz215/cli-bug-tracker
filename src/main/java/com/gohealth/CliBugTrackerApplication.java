package com.gohealth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.gohealth.command.CommandController;

@SpringBootApplication
public class CliBugTrackerApplication implements CommandLineRunner{
	
	@Autowired
	CommandController controller;

	public static void main(String[] args) {
		final ConfigurableApplicationContext context = SpringApplication
				.run(CliBugTrackerApplication.class, args);
		//System.out.println("App finished.");
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Inside run.");
		if( args.length > 0 ) {
			controller.onCommand(args);
		}
	}

}
