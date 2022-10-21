# A3_2_3

Assignment 3, grade 2 and 3.

## Contibutors
Ellinor Henriksson <eh224kr@student.lnu.se>

## Changes
- Game::Stand was implemented according to the sequence diagram of the task description
- An enum - Action - was implemented to be returned from the view to the controller class Player, to get rid of the hidden dependency between them.
- A class - Soft17HitStrategy - that implements the interface HitStrategy was created. The RulesFactory was changed to return this strategy instead of BasicHitStrategy.
- A WinnerStrategy interface was created, with two concrete Strategy classes implementing it - DealerWinsOnEqualStrategy and PlayerWinsOnEqualStrategy. One of the concrete strategies are returned from the RulesFactory method getWinnerRule() and set in the constructor in Dealer. The Dealer uses the strategy in the isDealerWinner() method to check who is the winner when comparing scores. Using DealerWinsOnEqualStartegy, the dealer wins if her score is higher or equal to the score of the player. Using the PlayerWinsOnEqualStrategy, the player wins in the opposite scenario.
