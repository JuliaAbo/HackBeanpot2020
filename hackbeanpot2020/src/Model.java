import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model implements IHangmanModel {
  private final static ArrayList<String> words = new ArrayList<>(List.of("Horse", "Roar",
          "Gargantuan", "HackBeanPot", "Sunshine"));
  private String word;
  private int lives;
  private ArrayList<Character> guessed;
  private char[] state;


  public Model(int lives) {
    this.lives = lives;

    Random rand = new Random();
    int index = rand.nextInt(this.words.size());

    this.word = words.get(index);

    this.guessed = new ArrayList<>();

    this.state = new char[this.word.length()]; // initialize _ _ _ _ _
    for(int i = 0; i < this.state.length; i++) {
      this.state[i] = '_';
    }
  }

  @Override
  public void guess(char c) {
    this.guessed.add(c);

    if (this.word.indexOf(c) > -1) {

      for (int i = 0; i < this.word.length(); i++) {
        if (this.word.charAt(i) == c) {
          this.state[i] = c;
        }
      }
    }
    else {
      this.lives -= 1;
    }
  }

  @Override
  public int getLives() {
    return this.lives;
  }

  @Override
  public char[] getCurrentState() {
    char[] duplicate = this.state.clone();
    return duplicate;
  }

  @Override
  public boolean isGameOver() {
    String convertedState = new String(this.state);
    return (convertedState.equals(this.word) || this.lives <= 0);
  }
}
