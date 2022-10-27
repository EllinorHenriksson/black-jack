package controller;

import model.Game;
import model.rules.InternationalSoftPlayerFactory;
import model.rules.RuleVisitor;
import model.rules.RulesFactory;
import view.EnglishRulePrinter;
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
    View v = new EnglishView();
    Player ctrl = new Player(g, v);
    RuleVisitor visitor = new EnglishRulePrinter();

    g.visitRules(visitor);
    while (ctrl.play()) {

    }
  }
}