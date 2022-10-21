package controller;

import model.Game;
import model.NewCardObserver;
import view.Action;
import view.View;

/**
 * Scenario controller for playing the game.
 */
public class Player implements NewCardObserver {
  private Game game;
  private View view;

  /**
   * Instantiates a Player object.
   *
   * @param game The game to play.
   * @param view The view to use.
   */
  public Player(Game game, View view) {
    this.game = game;
    this.view = view;

    this.game.subscribe(this);
  }

  /**
   * Runs the play use case.

   * @return True as long as the game should continue.
   */
  public boolean play() {
    view.displayWelcomeMessage();

    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore());

    if (game.isGameOver()) {
      view.displayGameOver(game.isDealerWinner());
    }

    Action choice = view.getAction();

    if (choice == Action.PLAY) {
      game.newGame();
    } else if (choice == Action.HIT) {
      game.hit();
    } else if (choice == Action.STAND) {
      game.stand();
    }

    return choice != Action.QUIT;
  }

  /**
   * Pauses the execution for 2 seconds and then displays the current hand of the dealer and the player.
   */
  public void update() {
    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore());

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      System.out.println("" + e);
    }
  }
}