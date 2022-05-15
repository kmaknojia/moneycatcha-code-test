package com.moneycatch.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.moneycatcha.service.CountCharacterService;


@ExtendWith(MockitoExtension.class)
public class CountCharacterServiceTest {

	private CountCharacterService service = new CountCharacterService();
	
	@Test
	private void whenWordsAndMatchingCharacterPassed_Then_itReturnsNumberOfOccurrence() {
		Assertions.assertEquals(1, service.countCharacters(List.of("abc","efg"), "e"));
	}
	
	@Test
	private void whenWordsAndMatchingCharacterPassedAndNoneMatched_Then_itReturnsZero() {
		Assertions.assertEquals(0, service.countCharacters(List.of("abc","efg"), "E"));
	}
}
