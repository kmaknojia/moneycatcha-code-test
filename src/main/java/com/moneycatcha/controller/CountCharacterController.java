package com.moneycatcha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moneycatcha.api.CountCharactersApi;
import com.moneycatcha.model.SuccessResponse;
import com.moneycatcha.service.CountCharacterService;


@RestController
@RequestMapping(value = "/api")
public class CountCharacterController implements CountCharactersApi  {
	
	
	private CountCharacterService countService;
	
	@Autowired
	public CountCharacterController(CountCharacterService countService) {
		this.countService = countService;
	}

	@Override
	public ResponseEntity<SuccessResponse> countCharacters(List<String> words, String match) {
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new SuccessResponse().occurrence(countService.countCharacters(words, match)));
	}
}
