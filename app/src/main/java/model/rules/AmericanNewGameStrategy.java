package model.rules;

import model.Dealer;
import model.Player;

class AmericanNewGameStrategy implements NewGameStrategy {

  public boolean newGame(Dealer dealer, Player player) {
    boolean show = true;
    boolean hide = false;

    dealer.drawAndDealCard(show, player);
    dealer.drawAndDealCard(show, dealer);
    dealer.drawAndDealCard(show, player);
    dealer.drawAndDealCard(hide, dealer);

    return true;
  }
}