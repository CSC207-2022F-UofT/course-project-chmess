# Implementation Rules and Checklist

- [ ] Create a new branch for desired feature

- [ ] Complete feature, commit and push to the **new branch** when you need to save

- [ ] Check for merge conflicts

- [ ] Repair any merge conflicts and recheck

- [ ] When feature is complete, submit a **pull request** to merge into *parent branch* *[**MUST** be approved by at least **three** other team members]*

---
# Updated Summary of Features Implemented and Design of the Program

A table listing the originally planned milestones and implementation goals can be found at the bottom of the document.
The main features on which our implementation was focused by the end of the term were:
  - A playable version of Chess, possibly lacking a fancy user interface, which is aligned with all normal rules of Chess and allows all and only those moves allowed in normal Chess.
  - The ability to undo moves.
  - The ability to import a game in progress, in the form of a text file, allowing the user to continue the game from where it left off.

The final implementation of the game includes all of the above mentioned features. The game was implemented with a text-based UI; as such one of the main features  originally planned and since removed was a GUI. This was seen as unimportant as the user could still experience a fully functional game and it left more time to implement more crucial aspects of the program. Unfortunately, we also had to dismiss the ability to import/export games from text files. Again, our focus was on implementing Chess functionality and this took priority until the last days of development. These two features are the most obvious candidates for work that could be done in the future.

As of now, possibly with slight variation in execution, the pizza party will still occur.

# Original Internal Milestones

## Internal Milestone 1

*The following deliverables should be complete*

| Name                                | Description                                                                                                                                                                              |
| ----------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Board class and subclasses          | The board class must be **fully implemented** and ready for testing use                                                                                                                  |
| Piece classes                       | The piece abstract class must be **fully implemented** and ready for testing use. Sub piece classes should be well into development with minor exceptions which may be implemented later |
| **No** checkmate implementation     | The checkmate implmeentation need not be completed. This requires the completion of the post move validator class which should be done by ***internal milestone 2***.                    |
| **No restriction** on King movement | The king piece simply needs to implement the abstract piece class with no restriction on where the king can move (apart from the normal ones eg. the square is occupied).                |
| CLI implementation                  | Command line style GUI, proper GUI will be implemented later, this is simply just allows testing of piece and core game features                                                         |

## Internal Milestone 2

*The following deliverables should be complete*

| Name                                  | Description                                                                                                                                                                                          |
| ------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| PostMoveValidator                     | Post move validator class should be implemented and fully completed.                                                                                                                                 |
| Core GUI                              | Core aspects of the GUI implemented (menus and board). Does **not** need to look polished/nice (polish is for ***internal milestone 3***)                                                            |
| Checkmate implementation              | The checkmate implmentation **needs** be completed.                                                                                                                                                  |
| Piece (and King) movement restriction | The King piece must follow all rules outlined in the game of chess (cannot move into check, must move on check, must recognize checkmate). Pieces **cannot move** if they place the King into check. |
| Game save system                      | Command line style GUI, proper GUI will be implemented later, this is simply just                                                                                                                    |

## Internal Milestone 3

*The following deliverables should be complete*

| Name               | Description                                                    |
| ------------------ | -------------------------------------------------------------- |
| Project Completion | Project should be fully completed and polished at this point   |
| Extra Features     | Any extra features (not in MVP) can now be implemented/started |
| Pizza party        | Food Yummy                                                     |

----

