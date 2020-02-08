import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Readable in = new InputStreamReader(System.in);
    Appendable out = System.out;
    Scanner scan = new Scanner(in);
    Model m = new Model(0);
    System.out.println("Would you like EASY or HARD?");
    /*
    if(scan.hasNext()) {
      String version = scan.next().toUpperCase();
      if(version.equals("EASY")) {
        m = new Model(6);
      }
      else {
        m = new Model(3);
      }
    }
*/
    m = new Model(6);
    ImmutableModel im = new ImmutableModel(m);

    //IHangmanView v = new TextualView(im, out);
      IHangmanView v = new VisualView(im);
    IHangmanController c = new Controller(m, v, in, out);

    c.play();
  }
}
