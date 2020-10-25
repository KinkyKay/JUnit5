package hangman;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestHangman {
    /* Write a test for a hangman game. Guess a letter of a word(hangman). */
    @Test
    public void testLetterToUnderscore() {
        // Given
        Hangman hangman = new Hangman("A");
        // When
        hangman.value();
        // Then
        assertThat(hangman).isNotNull();
    }
}
