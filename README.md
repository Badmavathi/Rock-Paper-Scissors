# Rock-Paper-Scissors Game

Build a game in which two players compete in a game of Rock-Paper-Scissors with different
strategies. Who will win more rounds?

## Rules

- Scissors beats Paper
- Rock beat Scissors
- Paper beats Rock
- If both players choose the same, the round is counted as a tie.

Implement two players:

 - Player A always chooses Paper
 - Player B chooses randomly

The game consists of 100 rounds of above two players competing. The output of the program
should be like the following:

"Player A wins 31 of 100 games"
"Player B wins 37 of 100 games"
"Tie: 32 of 100 games"


## Usage

To run a project:

1. Build a jar with 'Maven build' with Goals as 'clean install'
2. Run project with following command: 'java -jar RockPapercissors.jar'


## Advantages :

1. This is a well developed Java project with core OOPS concepts like 
	Encapsulation which follows Single Responsibility Principle.

2. This code is flexible to make it as multiple player configuration to
	the league level with minimal changes in the code and update 
 	Player information in the config.json file.
 	
## Disadvantages : 

1. Unit test can be improved to make it as clean tests and mockito tests.


