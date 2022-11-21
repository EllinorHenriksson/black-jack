package model.rules;

import model.Dealer;
import model.Player;

/**
 * Winner strategy deciding that the player wins on equal score or higher.
 */
public class PlayerWinsOnEqualStrategy implements WinnerStrategy {

  @Override
  public boolean isDealerWinner(Dealer dealer, Player player) {
    return dealer.calcScore() > player.calcScore();
  }

  @Override
  public void accept(RuleVisitor visitor) {
    visitor.visit(this);
  }
}
