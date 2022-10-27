package model.rules;

import java.util.Iterator;
import model.Card;
import model.Player;

/**
 * Hit strategy using the soft 17 rule.
 */
public class Soft17HitStrategy implements HitStrategy {
  private static final int hitLimit = 17;

  @Override
  public boolean doHit(Player dealer) {
    int score = dealer.calcScore();

    if (score < hitLimit) {
      return true;
    }

    if (score == hitLimit) {
      Iterable<Card> hand = dealer.getHand();
      Iterator<Card> it = hand.iterator();

      Card firstAce = null;
      while (it.hasNext()) {
        Card c = it.next();
        if (c.getValue() == Card.Value.Ace) {
          if (firstAce == null) {
            firstAce = c;
            it.remove();
          }
        }
      }

      if (firstAce != null) {
        int scoreOfRemaingCards = calcScore(it);
        if (scoreOfRemaingCards == 6) {
          return true;
        }
      }
    }

    return false;
  }

  /**
   * Calculates the score of the cards of the iterator, giving aces the value 1.

   * @param it the iterator of cards.
   * @return the score of the cards.
   */
  private int calcScore(Iterator<Card> it) {
    int[] cardScores = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1 };
    assert (cardScores.length == Card.Value.Count.ordinal())
        : "Card Scores array size does not match number of card values";

    int score = 0;
    while (it.hasNext()) {
      Card c = it.next();
      if (c.getValue() != Card.Value.Hidden) {
        score += cardScores[c.getValue().ordinal()];
      }
    }

    return score;
  }

  @Override
  public void accept(RuleVisitor visitor) {
    visitor.visit(this);
  }
}
