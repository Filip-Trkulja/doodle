package com.doodle.polls.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doodle.polls.model.Poll;
import com.doodle.polls.repository.PollRepository;

@Component
@ConfigurationProperties
@RestController
@RequestMapping("/api")
public class PollController {

	@Autowired
	PollRepository pollRepository;

	@GetMapping(path = "/polls", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Poll>> getAllPolls(@RequestParam(required = false) String text,
			@RequestParam(value = "since", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date sinceDate) {
		return ResponseEntity.ok(pollRepository.findPollsByCriterias(text, sinceDate));
	}

	@GetMapping(path = "/user/email/{email}/polls", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Poll>> getAllPollsByUserEmail(
			@PathVariable(value = "email", required = true) String email, @RequestParam(required = false) String text,
			@RequestParam(value = "since", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date sinceDate) {
		return ResponseEntity.ok(pollRepository.findPollsByEmailAndCriterias(email, text, sinceDate));
	}

}
