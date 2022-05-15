package com.moneycatcha.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.moneycatcha.exception.IncorrectMatchCharacterException;

@Service
public class CountCharacterService {

	public Integer countCharacters(List<String> words, String character) {
		if (character.trim().length() != 1) {
			throw new IncorrectMatchCharacterException();
		}
		
		return StringUtils.countMatches(words.stream().collect(Collectors.joining()), character);
	}
}
