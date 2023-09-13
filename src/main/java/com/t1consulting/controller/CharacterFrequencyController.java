package com.t1consulting.controller;

import com.t1consulting.service.CharacterFrequencyService;
import com.t1consulting.util.validation.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@Validated
public class CharacterFrequencyController {

    private final CharacterFrequencyService characterFrequencyService;


    @Autowired
    public CharacterFrequencyController(CharacterFrequencyService characterFrequencyService) {
        this.characterFrequencyService = characterFrequencyService;
    }

    //method to process HTTP request
    @GetMapping("/character-frequency")
    public ResponseEntity<String> getCharacterFrequencyHTTP(@RequestParam String input) {
        if (input == null || input.isEmpty()) {
            return ResponseEntity.badRequest().body("Input can not be empty");
        }

        return ResponseEntity.ok(characterFrequencyService.calculateCharacterFrequency(input));
    }

    //method to process JSON request
    @PostMapping("/character-frequency")
    public ResponseEntity<?> getCharacterFrequencyJSON(@RequestBody(required = false) Map<String, String> request) {
        if (request == null || !request.containsKey("input") || request.get("input").isEmpty()) {
            ErrorMessage errorMessage = new ErrorMessage("Request can not be empty");
            return ResponseEntity.badRequest().body(errorMessage);
        }

        String input = request.get("input");

        return ResponseEntity.ok(characterFrequencyService.calculateCharacterFrequencyMap(input));
    }

}
