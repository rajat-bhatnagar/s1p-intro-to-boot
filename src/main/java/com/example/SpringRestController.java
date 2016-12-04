package com.example;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class SpringRestController {
	private SpeakerRepository speakerRepository;

	public SpringRestController(SpeakerRepository speakerRepository) {
		super();
		this.speakerRepository = speakerRepository;
	}
	
	@GetMapping
	public List<Speaker> list(){
		return this.speakerRepository.findAll();
	}
}
