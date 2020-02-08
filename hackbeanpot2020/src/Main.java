import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) {
    Readable in = new InputStreamReader(System.in);
    Appendable out = System.out;

    Model m = new Model(6);
    ImmutableModel im = new ImmutableModel(m);

    IHangmanView v = new TextualView(im, out);

    IHangmanController c = new Controller(m, v, in, out);

    c.play();
  }
}
