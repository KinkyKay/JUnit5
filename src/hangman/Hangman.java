package hangman;

public class Hangman {
    private String word;
    private String hint = "_";

    public Hangman(String a) {
        word = a;
    }

    public Object hint() {
        return hint;
    }
}
