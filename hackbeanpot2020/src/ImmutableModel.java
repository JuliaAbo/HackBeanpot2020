import java.util.ArrayList;

public class ImmutableModel implements IHangmanModel {
  private Model model;

  public ImmutableModel(Model model) {
    this.model = model;

  }
  @Override
  public void guess(char c) {
  }

  @Override
  public int getLives() {
    return this.model.getLives();
  }

  @Override
  public char[] getCurrentState() {
    return this.model.getCurrentState();
  }

  @Override
  public boolean isGameOver() {
    return this.model.isGameOver();
  }

  @Override
  public ArrayList<Character> getGuessed() {
    return this.model.getGuessed();
  }

  @Override
  public String getWord() {
    return this.model.getWord();
  }
}
