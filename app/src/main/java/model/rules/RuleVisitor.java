package model.rules;

/**
 * A visitor interface for the game rules.
 */
public interface RuleVisitor {
  void visit(AmericanNewGameStrategy rule);

  void visit(InternationalNewGameStrategy rule);

  void visit(BasicHitStrategy rule);

  void visit(Soft17HitStrategy rule);

  void visit(DealerWinsOnEqualStrategy rule);
  
  void visit(PlayerWinsOnEqualStrategy rule);
}
