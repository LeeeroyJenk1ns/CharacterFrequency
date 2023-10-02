package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CharacterFrequencyService {

    public Map<Character, Integer> getCharacterFrequency(String input) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : input.toLowerCase().toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        return charCount.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));
    }
}
