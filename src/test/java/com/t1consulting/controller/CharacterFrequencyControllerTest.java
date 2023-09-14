package com.t1consulting.controller;

import com.t1consulting.service.CharacterFrequencyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class CharacterFrequencyControllerTest {

    @Mock
    private CharacterFrequencyService characterFrequencyService;
    private CharacterFrequencyController characterFrequencyController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        characterFrequencyController = new CharacterFrequencyController(characterFrequencyService);
    }

    @Test
    public void testGetCharacterFrequencyHTTPValidInput() {
        //given
        String input = "aaaaabcccc";
        String expectedResult = "{a=5, c=4, b=1}";

        // mock for characterFrequencyService
        when(characterFrequencyService.calculateCharacterFrequency(anyString())).thenReturn(expectedResult);

        //when
        ResponseEntity<?> responseEntity = characterFrequencyController.getCharacterFrequencyHTTP(input);

        // check response status - OK
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        // then
        assertThat(responseEntity.getBody()).isEqualTo(expectedResult);
    }

    @Test
    public void testGetCharacterFrequencyHTTPEmptyInput() {
        //given
        String input = "";

        //when
        ResponseEntity<?> responseEntity = characterFrequencyController.getCharacterFrequencyHTTP(input);

        // check response status - BAD_REQUEST
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

        // then
        assertThat(responseEntity.getBody()).isEqualTo("Input can not be empty");
    }

}