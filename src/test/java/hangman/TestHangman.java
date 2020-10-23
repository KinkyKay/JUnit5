package hangman;

import javafx.beans.binding.BooleanExpression;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestHangman {

    @Test
    public void testNoGuess_A() {
        Hangman hangman = new Hangman("A");
        assertThat(hangman.hint()).isEqualTo("_");
    }

}
