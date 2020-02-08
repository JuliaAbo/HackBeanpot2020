import java.io.IOException;

public class TextualView implements IHangmanView {

  private Appendable output;
  ImmutableModel model;
  private static final String[] dictionaryofpics = {"+---+ \n" +
                  "|   | " +
                  "    | \n" +
                  "    | \n" +
                  "    | \n" +
                  "    | \n" +
                  "=========\n",
                  "+---+ \n" +
                          "|   |\n"+
                          "O   |" +
          "    | \n" +
          "    | \n" +
          "    | \n" +
          "========= \n",
          "+---+ \n" +
          "|   | \n"+
          "O   |" +
          "|   | \n" +
          "    | \n" +
          "    | \n" +
          "========= \n" ,
          "+---+ \n" +
          "|   | \n" +
          "O   | \n " +
          "|   | \n" +
          "    | \n"+
          "    | \n"+
          "========= \n",
          "+---+ \n" +
          "|   | \n" +
  "O   | \n" +
          "/|\\  | \n" +
          "| \n" +
          "| \n"+
          "========= \n",
          "+---+ \n" +
          "|   | \n"+
  "O   |\n" +
          "/|\\  | \n"+
          "/    | \n"+
          "| \n" +
          "=========\n",
          "+---+ \n"+
          "|   | \n"+
  "O   | \n"+
          "/|\\  | \n" +
          "/ \\  | \n"+
          "| \n"+
          "=========\n"};


  public TextualView(ImmutableModel model, Appendable output) {
    this.model = model;
    this.output = output;
  }


  @Override
  public void render() throws IOException {
    int index = 6 - this.model.getLives();
    this.output.append(this.dictionaryofpics[index]);
  }
}
