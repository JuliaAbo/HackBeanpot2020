import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Model implements IHangmanModel {
  private String word;
  private int lives;
  private ArrayList<Character> guessed;
  private char[] state;


  public Model(int lives) {
    this.lives = lives;
    Random rand = new Random();
    try {
      int index = rand.nextInt(182);
      BufferedReader br = new BufferedReader(new FileReader("/Users/jules/IdeaProjects/HackBeanpot2020/hackbeanpot2020/src/Words.csv"));
      for(int i = 0; i < index - 1 ; i++) {
        br.readLine();
      }
      this.word = br.readLine();
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException();
    } catch (IOException e) {
      throw new IllegalArgumentException();
    }


    this.guessed = new ArrayList<>();

    this.state = new char[this.word.length()]; // initialize _ _ _ _ _
    for(int i = 0; i < this.state.length; i++) {
      this.state[i] = '_';
    }
  }

  @Override
  public void guess(char d) {
    char c = Character.toLowerCase(d);
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

  @Override
  public ArrayList<Character> getGuessed() {
    ArrayList<Character> duplicate = new ArrayList<Character>();
    duplicate.addAll(this.guessed);
    return duplicate;
  }

  @Override
  public String getWord() {
    String dup = new String(this.word);
    return dup;
  }
}
