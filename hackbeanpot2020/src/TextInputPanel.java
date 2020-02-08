import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TextInputPanel extends JPanel{
  private JButton guess;
  private JTextField text;

  public TextInputPanel() {
    this.setLayout(new FlowLayout());

    this.text = new JTextField();
    this.text.setPreferredSize(new Dimension(250, 20));

    this.guess = new JButton("Guess");
    //this.guess.setActionCommand("Guess");

    this.guess.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });

    this.add(this.text);
    this.add(this.guess);

  }

  public void setListener(Features features) {
    this.guess.addActionListener(evt -> {
      features.makeGuess(this.grabText());
      this.clear();
    });
  }

  private String grabText() {
    return this.text.getText();
  }

  private void clear() {
    this.text.setText("");
  }
}
