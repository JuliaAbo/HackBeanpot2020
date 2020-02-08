import java.io.IOException;
import java.util.Scanner;

public class Controller implements IHangmanController {
  private Readable input;
  private Appendable output;

  private IHangmanModel model;
  private IHangmanView view;

  private boolean quit; // true if user quits

  public Controller(IHangmanModel m, IHangmanView v, Readable r, Appendable a) {
    if (r == null || a == null || m == null) {
      throw new IllegalArgumentException();
    }
    else {
      this.input = r;
      this.output = a;
    }

    this.model = m;
    this.view = v;
  }

  @Override
  public void play() {
    Scanner scan = new Scanner(this.input);

    System.out.println("Welcome to Hangman. Guess a letter. If you'd like to quit the game, " +
            "enter *");
    try {
      this.view.render();
    } catch (IOException e) {
      System.out.print("The game could not load");
    }

    while(!this.model.isGameOver() && scan.hasNext() && !this.quit) {

      char guess = scan.next().charAt(0);

      if (guess == '*') {
        this.quit = true;
        break;
      }
      else if (Character.isDigit(guess)) {
        System.out.println("Bad input. Please enter a letter, or a sequence of letters.");
      }
      else {
        this.model.guess(guess);

        try {
          this.view.render();
        }
        catch (IOException e) {
          System.out.print("Could not render.");
        }
      }
    }

    if (this.quit == true) {
      System.out.println("Thanks for playing.");
    }
    else if (this.model.isGameOver() && this.model.getLives() > 0) {
      System.out.println("You won!");
    }
    else if (this.model.getLives() <= 0) {
      System.out.println("You lost. Better luck next time.");
      System.out.println("The answer was:" + this.model.getWord());
    }
  }
}
