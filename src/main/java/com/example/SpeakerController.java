package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpeakerController {
	private SpeakerRepository speakerRepository;

	public SpeakerController(SpeakerRepository speakerRepository) {
		super();
		this.speakerRepository = speakerRepository;
	}
	
	@GetMapping("/speakers")
	public String speakers(Model model){
		model.addAttribute("speakers", speakerRepository.findAll());
		return "speakers";
	}

}
