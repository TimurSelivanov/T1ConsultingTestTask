package com.t1consulting.controller;

import com.t1consulting.service.CharacterFrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CharacterFrequencyController {

    @Autowired
    private CharacterFrequencyService characterFrequencyService;

    //method to process HTTP request
    @GetMapping("/character-frequency")
    public ResponseEntity<String> getCharacterFrequencyHTTP(@RequestParam String input) {
        if (input == null || input.isEmpty()) {
            return ResponseEntity.badRequest().body("Input can not be empty");
        }
        String result = characterFrequencyService.calculateCharacterFrequency(input);

        return ResponseEntity.ok(result);
    }

    //TODO method to process JSON request

}
