package model.rules;

import model.Dealer;
import model.Player;

/**
 * Rule interface for deciding who won the game when comparing scores.
 */
public interface WinnerStrategy {
  /**
   * Decides if the dealer wins the game or not.
   *
   * @param dealer The dealaer to check.
   * @param player The player to check.
   * @return True if the dealer wins.
   */
  public boolean isDealerWinner(Dealer dealer, Player player);

  public void accept(RuleVisitor visitor);
}
