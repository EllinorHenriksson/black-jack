# Assignment 3
This describes the task for the third assignment, perform all the steps in order. Be sure to document all assumptions and changes you are making. Also, be sure to specify who participated in the work and be prepared to answer any questions about your model.   

Please use English in your models and documents.

## Goals
In this assignment you are to show that you:   

- Can understand and extend an existing object oriented codebase.
- Can refactor exising code to reduce code duplication, increase cohesion and decrease copuling.
- Can refactor exiting code to remove hidden/implicit dependencies.
- Can design and implement new features using GoF patterns.
- Can work within an architectural pattern (MVC) and know how to assign responsibilities within this architecture.
- Can deliver a working piece of software with high quality and use version management.
- Understands how implementation and diagrams conform to eachother and the differences between the diagrams (class, sequence and object).
- Can design and implement more advanced features within the constraints of the architecture (Grade 3).
- Can reuse the code at the architecural level and design and implement a new user interface (Grade 4).

## Requirements for Grade 2 (Passing Grade)
### Working Process
- You work with this grade in your project A3 in the main branch.   
- Commit and push to your work regularly.   
- When done you create a merge request for merging your main-branch to the release-branch and select the A3 Grade 2 milestone.
- Tick the corresponding check-boxes in the merge request. Do not close or merge, this is done by the course administration when the assignment is done.

### Task
You will continue the implementation and documentation of a Black Jack game. The design is similar to what we have done on the theory but it is not exactly the same. The focus is not on usability or a nice user interface but to have a robust and well-documented design that can handle change. In the provided code, you find a started but not a playable version of the game in Java. As there are many different variants of the rules one of the aims is to create a flexible design that supports different combinations of rules. There is also a class diagram that describes the packages, classes and the main relations in the implementation (note that there are dependencies in the implementation that are not shown in the diagram for readability purposes, e.g. there are many dependencies to the Card class). There is also a sequence diagram for one, not implemented, part of the game.

### Requirements
1. Build and run the game using gradle (it should run, but it’s not playable).
2. Study the class diagram and the source code to understand the design of the game.
3. Implement the operation Game::Stand using the sequence diagram Game_Stand. The game should now be playable.
4. Remove the bad, hidden, dependency between the controller and view (new game, hit, stand)
5. Design and implement a new rule variant for when the dealer should take one more card. The new variant is Soft 17, use the same design pattern already present for Hit. Soft 17 means that the dealer has 17 but in a combination of Ace and 6 (for example Ace, two, two, two). This means that the Dealer can get another card valued at 10 but still have 17 as the value of the ace is reduced to 1. Using the soft 17 rule the dealer should take another card (compared to the original rule when the dealer only takes cards on a score of 16 or lower). Hint: this is a typical behaviour you would like to have automatic test cases for.
6. Design and implement a variable rule for who wins the game. This variation could, for example, change who wins on an equal score (in one implementation the Dealer wins, in the other the Player). The design should make it easy to add other variants without changing the Dealer. Use the same design pattern as used in the Soft 17 design.
7. The code for getting a card from the deck, show the card and give it to a player is duplicated in a number of places. Make a refactoring to remove this duplication and that supports low coupling/high cohesion (i.e. check how you can evaluate different solutions to the problem and select the one that gives the best result according to low coupling/high cohesion). The code that is duplicated is similar to this:

```
Card c = deck.GetCard();
c.Show(true/false)
player.DealCard(c);
```

8. Use the Observer-pattern to send an event to the user interface that a player (human or dealer) has got a new card in his hand. When the event is handled the user interface should be "redrawn" to show the new hand (with the new card) and the game should be briefly paused to make the game a bit more exciting. The pausing code should be in the user interface (view or controller) and not in the model. You should design and implement the observer structure yourself and not use any library classes like java.util.observer etc. The pause should be when any player (dealer or human) gets a card.
For example, when starting the game the following “pattern” of pauses should present in the user interface:

```
Dealer:
Player: c1 (player gets the first card)
*pause*
Dealer: c1 (dealer gets the first card)
Player: c1
*pause*
Dealer: c1
Player: c1, c2 (player gets the second card)
*pause*
Dealer: c1, c2 (dealer gets the second card)
Player: c1, c2
```

In this example video, of a graphical user interface to the black jack game, these pauses are used to animate the cards and play a sound.

9. Update the class diagram to reflect the changes you make (it is not necessary to recreate the whole diagram only the parts that have been affected by your changes).
10. Proper use of versioning: there should be a number of commits (at least 20) that shows a natural progression of the application. "Big bang" delivery will result in a failed submission.
11. Use of gitlab build pipeline, gradle and quality-tests. Build using gradle regularley, fix any quality issues. Do not change the build-pipeline.
12. You are free to add additional automatic tests of your code.

### Deliverables
- Everything should be neatly available in your branch as per the working process.
- Source code that can be immediately built and run by gradle. Do not add the compiled java files i.e. ´.class´ files, project files or other things to the project. There is a .gitignore that should cover most things but you may be working in a special environment, os etc. so take care. git rm is your friend.
- a README.md that explains usage of your application and if there are any parts missing.
- a design.md that shows your updated class diagram and any text needed to explain the design.

## Requirements for Grade 3
### Working Process
- You work with this grade in your project A3
- Create a new branch based on your main-branch named grade_3 this ensures that you can continue to work from where you handed in for grade 2. It is simplest to create this new branch using gitlab.
- Do not forget to switch branch e.g. git checkout grade_3
- Commit to your work regularly to your working branch, you should not commit anything more to the main branch
- When done you create a merge request for merging your final grade_3-branch to the release-branch and select the A3 Grade 3 milestone.
- Tick the corresponding check-boxes in the merge request. Do not close or merge, this is done by the course administration when the assignment is done.

### Task
You will continue the implementation and documentation of a Black Jack game. The focus is to implement some additional patterns to gain further flexibility.

- Grade 2 must be done.
- Expand the application by adding the following requirements.

### Requirements
1. Use the design pattern Abstract Factory to offer some “finished” rule factories for different rule combinations. Parameterize the Game class in the constructor with the factory to use.
2. Use the design pattern Visitor to enable the view to print what rules are used at the start of the game. The model classes shoul not have any form of “type”-attribute (string, enum, int etc) or use some form of reflexion (i.e. print the class name).
3. The two views implementations seems to have things in common. Design and implement a solution to minimise duplication.
4. Update the class diagram.
   
### Deliverables
- Everything should be neatly available in your branch as per the working process.
- Source code that can be immediately built and run by gradle. Do not add the compiled java files i.e. ´.class´ files, project files or other things to the project. There is a .gitignore that should cover most things but you may be working in a special environment, os etc. so take care. git rm is your friend.
- a README.md that explains usage of your application and if there are any parts missing.
- a design.md that shows your class diagram and any text needed to explain the design.

## Requirements for Grade 4
### Working Process
- You work with this grade in your project A3
- Create a new branch based on your main-branch named grade_4 this ensures that you can continue to work from where you handed in for grade 2. It is simplest to create this new branch using gitlab.
- Do not forget to switch branch e.g. git checkout grade_4
- Commit to your work regularly to your working branch, you should not commit anything more to the main branch
- When done you create a merge request for merging your final grade_4-branch to the release-branch and select the A3 Grade 4 milestone.
- Tick the corresponding check-boxes in the merge request. Do not close or merge, this is done by the course administration when the assignment is done.

### Task
You should design and implement a new view. This view should not be a console based view. You are free to use any libraries or frameworks.

- Grade 2 and grade 3 must be done

### Requirements
1. Design and implement a new (not console based) user interface (view/controller) to the game, for example using Swing, WPF, OpenGL, XNA or a web-based variant (you are free to convert it to another language than C#/Java if you want). Use as much of the present design as possible but change it if it is needed, i.e. try to keep the model intact.
2. It should be possible to build and run the application using gradle.
3. Construct a class diagram over the application.
4. Write a short report on the conversion, what went well, what needed to be changed, why and how was the change made.

### Deliverables
- Everything should be neatly available in your branch as per the working process.
- Source code that can be immediately built and run by gradle. Do not add the compiled java files i.e. ´.class´ files, project files or other things to the project. There is a .gitignore that should cover most things but you may be working in a special environment, os etc. so take care. git rm is your friend.
- a README.md that explains usage of your application and if there are any parts missing.
- a design.md that shows your class diagram and any text needed to explain the design.
- a report.md that contains the report.
