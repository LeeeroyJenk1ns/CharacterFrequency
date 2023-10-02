package com.example.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CharacterFrequencyServiceTest {
    private CharacterFrequencyService characterFrequencyService;

    @BeforeEach
    public void setup() {
        characterFrequencyService = new CharacterFrequencyService();
    }

    @Test
    public void testGetCharacterFrequency() {
        String input = "Hello, World!";
        Map<Character, Integer> result = characterFrequencyService.getCharacterFrequency(input);

        assertNotNull(result);
        assertEquals(10, result.size());
        assertEquals(3, result.get('l'));
        assertEquals(2, result.get('o'));
        assertEquals(1, result.get('h'));
        assertEquals(1, result.get('e'));
        assertEquals(1, result.get(','));
        assertEquals(1, result.get(' '));
        assertEquals(1, result.get('w'));
        assertEquals(1, result.get('r'));
        assertEquals(1, result.get('d'));
        assertEquals(1, result.get('!'));
    }
}
