package controller;

import model.Game;
import model.rules.InternationalSoftPlayerFactory;
import model.rules.RulesFactory;
import view.EnglishView;
import view.View;

/**
 * Starts the application using the console.
 */
public class App {
  /**
   * Starts the game.

  * @param args Not used.
  */
  public static void main(String[] args) {
    RulesFactory rulesFactory = new InternationalSoftPlayerFactory();
    Game g = new Game(rulesFactory);
    View v = new EnglishView(); // new SwedishView();
    Player ctrl = new Player(g, v);

    while (ctrl.play()) {

    }
  }
}