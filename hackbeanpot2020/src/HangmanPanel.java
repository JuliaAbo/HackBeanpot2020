import java.awt.*;

import javax.swing.*;

public class HangmanPanel extends JPanel {

  ImmutableModel model;
  boolean easy;

  public HangmanPanel(ImmutableModel model){
    this.model = model;
    this.easy = model.getLives() == 6;
    this.setBackground(new Color(255, 255, 255));
    this.setPreferredSize(new Dimension(740, 500));

  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.fillRect(500,100, 3, 300);
    g.fillRect(425, 100, 75, 3);
    g.fillRect(450, 400, 100, 3);

    g.drawString("Lives: " + Integer.toString(this.model.getLives()), 200, 200);

    Font myFont = new Font("Dialog", Font.PLAIN, 30 );
    this.setFont(myFont);

    for(int i = 0; i < this.model.getCurrentState().length; i ++ ){
      g.drawString(Character.toString(this.model.getCurrentState()[i]), 100 + i * 28, 400);
    }
  }
}
