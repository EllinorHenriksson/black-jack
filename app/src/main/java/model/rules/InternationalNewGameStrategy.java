package model.rules;

import model.Dealer;
import model.Player;


class InternationalNewGameStrategy implements NewGameStrategy {

  public boolean newGame(Dealer dealer, Player player) {
    Boolean show = true;

    dealer.drawAndDealCard(show, player);
    dealer.drawAndDealCard(show, dealer);
    dealer.drawAndDealCard(show, player);

    return true;
  }
}