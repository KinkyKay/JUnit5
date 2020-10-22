package hangman;

import javafx.beans.binding.BooleanExpression;
import org.junit.jupiter.api.Test;

public class TestHangman {

    @Test
    public void testNoGuess_A() {
        Hangman hangman = new Hangman("A");
        assert(hangman.hint()).equals("_");
    }

}
