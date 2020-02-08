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

    String livesString = new String("Lives");
    livesString.concat(Integer.toString(this.model.getLives()));
    g.drawString(livesString, 200, 200);

    Font myFont = new Font("Dialog", Font.PLAIN, 30 );
    this.setFont(myFont);

    for(int i = 0; i < this.model.getCurrentState().length; i ++ ){
      g.drawString(Character.toString(this.model.getCurrentState()[i]), 100 + i * 28, 400);
    }

    int lives = this.model.getLives();

    if(this.easy) {
      System.out.println("inside the if ");
      if(lives == 5) {
        g.drawOval(400, 103, 50, 50);
      }
      else if(lives == 4){
        g.drawOval(400, 103, 50, 50);
        g.fillRect(425, 153, 2, 100 );
      }
      else if(lives == 3) {
        g.drawOval(400, 103, 50, 50);
        g.fillRect(425, 153, 2, 100 );
        g.drawLine(425, 178, 375, 203);
      } else if (lives == 2) {
        g.drawOval(400, 103, 50, 50);
        g.fillRect(425, 153, 2, 100 );
        g.drawLine(425, 178, 375, 203);
        g.drawLine(425, 178, 475, 203);
      }
      else if(lives == 1) {
        g.drawOval(400, 103, 50, 50);
        g.fillRect(425, 153, 2, 100 );
        g.drawLine(425, 178, 375, 203);
        g.drawLine(425, 178, 475, 203);
        g.drawLine(425, 253, 375, 298);
      }
      else if(lives == 0){
        g.drawOval(400, 103, 50, 50);
        g.fillRect(425, 153, 2, 100 );
        g.drawLine(425, 178, 375, 203);
        g.drawLine(425, 178, 475, 203);
        g.drawLine(425, 253, 375, 298);
        g.drawLine(425, 253, 475, 298);
      }
    } else {
      if(lives == 2) {
        g.drawOval(400, 103, 50, 50);
        g.fillRect(425, 153, 2, 100 );
      }
      else if(lives == 1) {
        g.drawOval(400, 103, 50, 50);
        g.fillRect(425, 153, 2, 100 );
        g.drawLine(425, 178, 375, 203);
        g.drawLine(425, 178, 475, 203);
      }
      else if(lives == 0) {
        g.drawString("GAME OVER!",370, 50);
        g.drawOval(400, 103, 50, 50);
        g.fillRect(425, 153, 2, 100 );
        g.drawLine(425, 178, 375, 203);
        g.drawLine(425, 178, 475, 203);
        g.drawLine(425, 253, 375, 298);
        g.drawLine(425, 253, 475, 298);
      }
    }
  }




}
