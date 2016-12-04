package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
@EnableConfigurationProperties(ConferenceProperties.class)
public class Application {
	private SpeakerRepository speakerRepository;
	private ConferenceProperties conferenceProperties;
	
	public Application(SpeakerRepository speakerRepository, ConferenceProperties conferenceProperties) {
		super();
		this.speakerRepository = speakerRepository;
		this.conferenceProperties = conferenceProperties;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner loadSpeakers(){
		return (args) -> {
			Stream<Speaker> speakers = Stream.of(new Speaker("Phil Webb") , new Speaker("Josh Long"));
			speakers.forEach(speakerRepository::save);
		};
	}
	
	@Bean
	public CommandLineRunner messages(){
		return (args) -> {
			System.out.println(conferenceProperties.getName());
			System.out.println(conferenceProperties.getLocation());
		};
	}
	
	@Bean
	public HealthIndicator springOneHealthIndicator(){
		return () -> new Health.Builder().up().withDetail("message", "Spring One is Running").build();
	}
	
}
