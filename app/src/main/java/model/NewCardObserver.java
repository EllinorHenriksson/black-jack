package model;

/**
 * An interface for observing card dealings.
 */
public interface NewCardObserver {
  /**
   * Handles the event when a new card is given to a player.
   */
  public void update();
}
