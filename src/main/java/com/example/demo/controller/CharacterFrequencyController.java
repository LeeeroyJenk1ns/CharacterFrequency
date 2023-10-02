package com.example.demo.controller;

import com.example.demo.service.CharacterFrequencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CharacterFrequencyController {
    private final CharacterFrequencyService characterFrequencyService;


    public CharacterFrequencyController(CharacterFrequencyService characterFrequencyService) {
        this.characterFrequencyService = characterFrequencyService;
    }

    @GetMapping("/api/character-frequency")
    public ResponseEntity<Map<Character, Integer>> getCharacterFrequency(@RequestParam("string") String input) {
        return new ResponseEntity<>(characterFrequencyService.getCharacterFrequency(input), HttpStatus.OK);
    }
}
