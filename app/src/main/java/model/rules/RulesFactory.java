package model.rules;

/**
 * Interface for a factory that creates different game rules.
 */
public interface RulesFactory {

  /**
   * Creates the rule to use for the dealer's hit behavior.

   * @return The rule to use
   */
  public HitStrategy getHitRule();

  /**
   * Creates the rule to use when starting a new game.

   * @return The rule to use.
   */
  public NewGameStrategy getNewGameRule();

  /**
   * Creates the rule to use when deciding who won the game by comparing scores.

   * @return The rule to use.
   */
  public WinnerStrategy getWinnerRule();
}