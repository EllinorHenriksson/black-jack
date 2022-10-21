package model.rules;

/**
 * Creates concrete rules.
 */
public class RulesFactory {

  /**
   * Creates the rule to use for the dealer's hit behavior.

   * @return The rule to use
   */
  public HitStrategy getHitRule() {
    return new Soft17HitStrategy();
  }

  /**
   * Creates the rule to use when starting a new game.

   * @return The rule to use.
   */
  public NewGameStrategy getNewGameRule() {
    return new AmericanNewGameStrategy();
  }

  /**
   * Creates the rule to use when deciding who won the game by comparing scores.

   * @return The rule to use.
   */
  public WinnerStrategy getWinnerRule() {
    return new DealerWinsOnEqualStrategy();
  }
}