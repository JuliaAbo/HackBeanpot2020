import java.io.IOException;

public class TextualView implements IHangmanView {

  private Appendable output;
  ImmutableModel model;
  private static final String[] dictionaryofpics = {" +---+ \n" +
                  " |   | \n" +
                  "     | \n" +
                  "     | \n" +
                  "     | \n" +
                  "     | \n" +
                  " =========\n",
                  "+---+ \n" +
                          " |   |\n"+
                          " O   |\n" +
          "     | \n" +
          "     | \n" +
          "     | \n" +
          " ========= \n",
          " +---+ \n" +
          " |   | \n"+
          " O   | \n" +
          " |   | \n" +
          "     | \n" +
          "     | \n" +
          " O========= \n" ,
          "  +---+ \n" +
          "  |   | \n" +
          "  O   | \n " +
          "/|   | \n" +
          "      | \n"+
          "      | \n"+
          "========= \n",
          " +---+ \n" +
          " |   | \n" +
          " O   | \n" +
          "/|\\  | \n" +
          "     |\n" +
          "     | \n"+
          "========= \n",
          " +---+ \n" +
          " |   | \n"+
          " O   |\n" +
          "/|\\  | \n"+
          "/    | \n"+
          "     | \n" +
          "=========\n",
          " +---+ \n"+
          " |   | \n"+
          " O   | \n"+
          "/|\\  | \n" +
          "/ \\  | \n"+
          "     | \n"+
          "=========\n"};


  public TextualView(ImmutableModel model, Appendable output) {
    this.model = model;
    this.output = output;
  }


  @Override
  public void render() throws IOException {
    int index = 6 - this.model.getLives();
    this.output.append(this.dictionaryofpics[index]);
    char[] curState = this.model.getCurrentState();
    this.output.append("Lives: " + this.model.getLives() + "\n");
    for(int i = 0 ; i < curState.length; i++){
      this.output.append(curState[i]);
      this.output.append(" ");
    }
    this.output.append("\n");
    this.output.append("Guesses: \n");
    this.output.append(this.model.getGuessed().toString() + "\n");
  }
}
