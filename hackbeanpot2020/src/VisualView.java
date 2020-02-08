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

  }

  @Override
  public void render() throws IOException {
    this.repaint();
  }

  public void addFeatures(Features f) {
    this.textInput.setListener(f);
  }
}
