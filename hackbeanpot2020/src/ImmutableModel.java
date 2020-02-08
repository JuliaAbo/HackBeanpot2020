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
}
