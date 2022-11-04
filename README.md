# Implementation Rules and Checklist

- [ ] Create a new branch for desired feature

- [ ] Complete feature, commit and push to the **new branch** when you need to save

- [ ] Check for merge conflicts

- [ ] Repair any merge conflicts and recheck

- [ ] When feature is complete, submit a **pull request** to merge into *parent branch* *[**MUST** be approved by at least **three** other team members]*

---

# Internal Milestones

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

# Project Template

This is a template repository for CSC 207 projects. 
This repository contains starter code for a gradle project.
It also contains workflow documents that give instructions on how to manage your Github repository and how to use Github Projects for efficient collaboration.

## Checklist For Your Project

- [ ] Verify the correct settings for your project repository
- [ ] Set up Github Projects
- [ ] Create the implementation plan using issues and Github Projects
- [ ] Create deveopment branches for your features
- [ ] Use pull requests to merge finished features into main branch
- [ ] Conduct code reviews

**If your team has trouble with any of these steps, please ask on Piazza. For example, with how GitHub Classroom works, your team *may* not have permissions to do some of the first few steps, in which case we'll post alternative instructions as needed.**

## Workflow Documents

* Github Workflow: Please refer to the workflow that was introduced in the first lab. You should follow this when working on your code. The following document provides additional details too.

* [Project Planning and Development Guide](project_plan_dev.md): This document helps you to understand how to create and maintain a project plan for your class project. **This document helps you to complete the Implementation Plan Milestone.**

## Gradle Project

Import this project into your Intellij editor. It should automatically recognise this as a gradle repository.
The starter code was built using SDK version 11.0.1. Ensure that you are using this version for this project. (You can, of course, change the SDK version as per your requirement if your team has all agreed to use a different version)

You have been provided with two starter files for demonstration: HelloWorld and HelloWorldTest.

You will find HelloWorld in `src/main/java/tutorial` directory. Right click on the HelloWorld file and click on `Run HelloWorld.main()`.
This should run the program and print on your console.

You will find HelloWorldTest in `src/test/java/tutorial` directory. Right click on the HelloWorldTest file and click on `Run HelloWorldTest`.
All tests should pass. Your team can remove this sample of how testing works once you start adding your project code to the repo.

Moving forward, we expect you to maintain this project structure. You *should* use Gradle as the build environment, but it is fine if your team prefers to use something else -- just remove the gradle files and push your preferred project setup. Assuming you stick with Gradle, your source code should go into `src/main/java` (you can keep creating more subdirectories as per your project requirement). Every source class can auto-generate a test file for you. For example, open HelloWorld.java file and click on the `HelloWorld` variable as shown in the image below. You should see an option `Generate` and on clicking this your should see an option `Test`. Clicking on this will generate a JUnit test file for `HelloWorld` class. This was used to generate the `HelloWorldTest`.

![image](https://user-images.githubusercontent.com/5333020/196066655-d3c97bf4-fdbd-46b0-b6ae-aeb8dbcf351d.png)

You can create another simple class and try generating a test for this class.
