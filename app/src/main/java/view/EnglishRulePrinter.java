package view;

import model.rules.AmericanNewGameStrategy;
import model.rules.BasicHitStrategy;
import model.rules.DealerWinsOnEqualStrategy;
import model.rules.InternationalNewGameStrategy;
import model.rules.PlayerWinsOnEqualStrategy;
import model.rules.RuleVisitor;
import model.rules.Soft17HitStrategy;

/**
 * Prints the game rules in English.
 */
public class EnglishRulePrinter implements RuleVisitor {
  @Override
  public void visit(AmericanNewGameStrategy strategy) {
    System.out.println("New game rule: American");
  }

  @Override
  public void visit(InternationalNewGameStrategy strategy) {
    System.out.println("New game rule: International");
  }

  @Override
  public void visit(BasicHitStrategy strategy) {
    System.out.println("Hit rule: Basic");
  }

  @Override
  public void visit(Soft17HitStrategy strategy) {
    System.out.println("Hit rule: Soft 17");
  }

  @Override
  public void visit(DealerWinsOnEqualStrategy startegy) {
    System.out.println("Winner rule: Dealer wins on equal");
  }

  @Override
  public void visit(PlayerWinsOnEqualStrategy strategy) {
    System.out.println("Winner rule: Player wins on equal");
  }
}
