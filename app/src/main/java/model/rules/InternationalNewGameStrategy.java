package model.rules;

import model.Dealer;
import model.Player;

/**
 * Represents an international new game strategy.
 */
public class InternationalNewGameStrategy implements NewGameStrategy {
  /**
   * Deals cards to dealer and player acording to the international new game rule.
   */
  public boolean newGame(Dealer dealer, Player player) {
    Boolean show = true;

    dealer.drawAndDealCard(show, player);
    dealer.drawAndDealCard(show, dealer);
    dealer.drawAndDealCard(show, player);

    return true;
  }

  @Override
  public void accept(RuleVisitor visitor) {
    visitor.visit(this);
  }
}