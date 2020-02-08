public interface IHangmanModel {

  void guess(char c);

  int getLives();

  char[] getCurrentState();

  boolean isGameOver();
}
