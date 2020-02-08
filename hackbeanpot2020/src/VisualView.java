import java.awt.*;
import java.io.IOException;

import javax.swing.*;

public class VisualView extends JFrame implements IHangmanView {
  private final TextInputPanel textInput;
  private ImmutableModel model;

  /**
   * Constructs a visual view of a spreadsheet.
   */
  public VisualView(ImmutableModel m) {
    super("Hangman");
    this.model = m;

    this.setSize(500, 300);
    this.setLocation(200, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setPreferredSize(new Dimension(740, 500));
    this.setLayout(new BorderLayout());

    this.textInput = new TextInputPanel();

    HangmanPanel panel = new HangmanPanel(this.model);

    this.add(panel, BorderLayout.CENTER);
    this.add(this.textInput, BorderLayout.PAGE_END);

    this.pack();
    this.setVisible(true);

    /*
    // display
    Button enter = new Button();
    JTextField userinput = new JTextField();
    userinput.setPreferredSize(new Dimension(70, 30));
    JPanel userInter = new JPanel();
    //userInter.setLayout(new BorderLayout());

   // userInter.add(userinput);
    userInter.add(enter, BorderLayout.EAST);
    HangmanPanel panel = new HangmanPanel(this.model);

    this.add(panel, BorderLayout.CENTER);
    //this.add(userInter, BorderLayout.SOUTH);
    //this.add(userinput, BorderLayout.SOUTH);
    //this.add(enter, BorderLayout.SOUTH);
    this.pack();
    this.setVisible(true);
    this.add(new Button(), BorderLayout.CENTER);

    */
  }

  @Override
  public void render() throws IOException {
    this.repaint();
  }

  public void addFeatures(Features f) {
    this.textInput.setListener(f);
  }
}
