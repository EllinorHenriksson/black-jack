package view;

import model.rules.AmericanNewGameStrategy;
import model.rules.BasicHitStrategy;
import model.rules.DealerWinsOnEqualStrategy;
import model.rules.InternationalNewGameStrategy;
import model.rules.PlayerWinsOnEqualStrategy;
import model.rules.RuleVisitor;
import model.rules.Soft17HitStrategy;

/**
 * Prints the game rules in Swedish.
 */
public class SwedishRulePrinter implements RuleVisitor {
  @Override
  public void visit(AmericanNewGameStrategy rule) {
    System.out.println("Nytt spel-regel: Amerikansk");
  }

  @Override
  public void visit(InternationalNewGameStrategy rule) {
    System.out.println("Nytt spel-regel: Internationell");
  }

  @Override
  public void visit(BasicHitStrategy rule) {
    System.out.println("Dra-regel: Basic");
  }

  @Override
  public void visit(Soft17HitStrategy rule) {
    System.out.println("Dra-regel: Soft 17");
  }

  @Override
  public void visit(DealerWinsOnEqualStrategy rule) {
    System.out.println("Vinnare-regel: Croupiern vinner vid jämnt");
  }

  @Override
  public void visit(PlayerWinsOnEqualStrategy rule) {
    System.out.println("Vinnare-regel: Spelaren vinner vid jämnt");
  }
}
