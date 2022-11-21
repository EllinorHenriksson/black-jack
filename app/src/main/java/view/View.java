package view;

/**
 * Encapsulates the generic view functionality.
 */
public abstract class View {
  /**
   * Transform input from the keyboard to a user action and returns it.

   * @return the user action.
   */
  public Action getAction() {
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }

      if (c == 'p') {
        return Action.PLAY;
      } else if (c == 'h') {
        return Action.HIT;
      } else if (c == 's') {
        return Action.STAND;
      } else if (c == 'q') {
        return Action.QUIT;
      }
      return Action.INVALID;
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return Action.INVALID;
    }
  }
  
  /**
   * Shows a welcome message.
   */
  public abstract void displayWelcomeMessage();

  /**
   * Displays a card.

   * @param card The card to display.
   */
  public abstract void displayCard(model.Card card);

  /**
   * Displays the cards and score of the player.

   * @param hand the player's hand.
   * @param score the player's score.
   */
  public abstract void displayPlayerHand(Iterable<model.Card> hand, int score);

  /**
   * Displays the cards and score of the dealer.

   * @param hand the dealer's score.
   * @param score the players's score.
   */
  public abstract void displayDealerHand(Iterable<model.Card> hand, int score);

  /**
   * Displays the winner of the game.

   * @param dealerIsWinner True if the dealer is the winner.
   */
  public abstract void displayGameOver(boolean dealerIsWinner);
}