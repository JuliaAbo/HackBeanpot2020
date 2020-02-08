import java.util.ArrayList;

public interface IHangmanModel {

  void guess(char c);

  int getLives();

  char[] getCurrentState();

  boolean isGameOver();

  ArrayList<Character> getGuessed();

  String getWord();
}
