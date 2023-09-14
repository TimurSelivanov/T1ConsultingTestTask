package com.t1consulting.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class CharacterFrequencyServiceTest {

    @Mock
    private CharacterFrequencyService characterFrequencyService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateCharacterFrequencyMap() {
        // given
        String input = "aaaaabcccc";
        Map<Character, Integer> expectedResult = Map.of('a', 5, 'b', 1, 'c', 4);

        // mock for method calculateCharacterFrequencyMap
        when(characterFrequencyService.calculateCharacterFrequencyMap(anyString())).thenCallRealMethod();

        // when
        Map<Character, Integer> result = characterFrequencyService.calculateCharacterFrequencyMap(input);

        // then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }
}