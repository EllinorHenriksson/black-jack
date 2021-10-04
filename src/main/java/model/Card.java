package model;

/**
 * Represents a common playing card that can be hidden i.e. face down.
 */
public class Card {

  /**
   * Represents the four playing card colors, as well as a hidden color.
   */
  public enum Color {
    Hearts, Spades, Diamonds, Clubs, Count, Hidden
  }

  /**
   * Represents the 13 card values, as well as a hidden value.
   */
  public enum Value {
    Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Knight, Queen, King, Ace, Count, Hidden
  }

  private Color color;
  private Value value;
  private boolean isHidden;

  /**
   * Initalizing constructor that creates a hidden card.

   * @param color The color of the card.
   * @param value The value of the card.
   */
  public Card(Color color, Value value) {
    this.value = value;
    this.color = color;
    isHidden = true;
  }

  /**
   * Returns the color of the card or hidden if the card is face down.

   * @return The card color.
   */
  public Color getColor() {
    if (isHidden) {
      return Color.Hidden;
    }
    return color;
  }

  /**
   * returns the value of the card or hidden if the card is face down.

   * @return The card value.
   */
  public Value getValue() {
    if (isHidden) {
      return Value.Hidden;
    }
    return value;
  }

  /**
   * Shows or hides a card.

   * @param show False if the card should have the face down.
   */
  public void show(boolean show) {
    isHidden = !show;
  }
}