import java.io.IOException;

public class TextualView implements IHangmanView {

  private Appendable output;
  ImmutableModel model;
  boolean easy;
  private static final String[] easydictionaryofpics = {" +---+ \n" +
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
  private static final String[] harddictionaryofpics = {" +---+ \n" +
          " |   | \n" +
          "     | \n" +
          "     | \n" +
          "     | \n" +
          "     | \n" +
          " =========\n",
          " +---+ \n" +
                  " |   | \n"+
                  " O   | \n" +
                  " |   | \n" +
                  "     | \n" +
                  "     | \n" +
                  " O========= \n" ,
          " +---+ \n" +
                  " |   | \n" +
                  " O   | \n" +
                  "/|\\  | \n" +
                  "     |\n" +
                  "     | \n"+
                  "========= \n",
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
    this.easy = (this.model.getLives() == 6);
  }


  @Override
  public void render() throws IOException {
    int index = 0;
    if(this.easy) {
      index = 6 - this.model.getLives();
      this.output.append(this.easydictionaryofpics[index]);
    }
    else {
      index = 3 - this.model.getLives();
      this.output.append(this.harddictionaryofpics[index]);
    }
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
