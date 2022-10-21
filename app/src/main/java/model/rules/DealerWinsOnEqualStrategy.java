package model.rules;

import model.Dealer;
import model.Player;

/**
 * Winner strategy deciding that the dealer wins on equal score or higher.
 */
public class DealerWinsOnEqualStrategy implements WinnerStrategy {

  @Override
  public boolean isDealerWinner(Dealer dealer, Player player) {
    return dealer.calcScore() >= player.calcScore();
  }
  
}
