package model.rules;

import model.Dealer;
import model.Player;

/**
 * Represents an American new game strategy.
 */
public class AmericanNewGameStrategy implements NewGameStrategy {

  /**
   * Deals cards to dealer and pleyer according to the american new game rule.
   */
  public boolean newGame(Dealer dealer, Player player) {
    boolean show = true;
    boolean hide = false;

    dealer.drawAndDealCard(show, player);
    dealer.drawAndDealCard(show, dealer);
    dealer.drawAndDealCard(show, player);
    dealer.drawAndDealCard(hide, dealer);

    return true;
  }

  @Override
  public void accept(RuleVisitor visitor) {
    visitor.visit(this);
  }
}