
package javaCourse.game;

import java.util.Scanner;
public class KidsGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Game game = new Game();
        System.out.println("==== Math Learning Game ====\n1) Make a wish\n2) No Mistakes\n3) Take Chances (3 lives)\n4) Time Trial\nChoose a mode:");
        int mode = input.nextInt();
        System.out.println("How many players? (1-4)");
        int playerNum = input.nextInt();
        long startTime = System.currentTimeMillis();
        Player[] players = new Player[playerNum];
        
        if (mode == 1) {
        	System.out.println("How many questions?");
    		int nQuestions = input.nextInt();
    		while(nQuestions < 0) {
    			System.out.println("You can have negitive questions.n/How many questions?");
    			nQuestions = input.nextInt();
    		}
        	for( int i = 0; i < playerNum; i++) {
        		System.out.println("Enter your name: ");
        		players[i] = new Player();
        		players[i].name = input.next();
        		for(int j=0; j<nQuestions; j++){
        			int quest = (int)(Math.random() * 4);
        			if(quest == 3) {
        				game.generateAddQuestions(players, i);
        			}
        			else if(quest == 2) {
        				game.generateSubQuestions(players, i);
        			}
        			else if(quest == 1) {
        				game.generateDivQuestions(players, i);
        			}
        			else{
        				game.generateMultQuestions(players, i);
        			}
        		}
        		long endTime = System.currentTimeMillis();
                long totalTime = endTime - startTime;
                System.out.println("You have taken: "+totalTime/1000+"\tseconds");
                game.printSummary(players, i);
        	}
        }
        
        if (mode == 2) {
        	
        	int oldScore;
        	for( int i = 0; i < playerNum; i++) {
        		System.out.println("Enter your name: ");
        		players[i] = new Player();
        		players[i].name = input.next();
        		boolean right = true;
        		while(right == true) {
        			oldScore = players[i].score;
        			int quest = (int)(Math.random() * 4);
        			if(quest == 3) {
        				game.generateAddQuestions(players, i);
        				if(players[i].score == oldScore) {
        					right = false;
        				}
        			}
        			else if(quest == 2) {
                		game.generateSubQuestions(players, i);
                		if(players[i].score == oldScore) {
        					right = false;
        				}
            		}
        			else if(quest == 1) {
                		game.generateDivQuestions(players, i);
                		if(players[i].score == oldScore) {
        					right = false;
        				}
            		}
        			else{
                		game.generateMultQuestions(players, i);
                		if(players[i].score == oldScore) {
        					right = false;
        				}
            		}
        		}
        		long endTime = System.currentTimeMillis();
                long totalTime = endTime - startTime;
                System.out.println("You have taken: "+totalTime/1000+"\tseconds");
                game.printSummary(players, i);
        	}
        }
        
        if (mode == 3) {
        	for( int i = 0; i < playerNum; i++) {
        		System.out.println("Enter your name: ");
        		players[i] = new Player();
        		players[i].name = input.next();
        		int lives = 3;
        		int oldScore;
        		while(lives != 0 ){
        			System.out.println("Lives: " + lives);
        			oldScore = players[i].score;
        			int quest = (int)(Math.random() * 4);
        			if(quest == 3) {
        				game.generateAddQuestions(players, i);
        				if(players[i].score == oldScore) {
        					lives--;
        				}
        			}
        			else if(quest == 2) {
                		game.generateSubQuestions(players, i);
                		if(players[i].score == oldScore) {
        					lives--;
        				}
            		}
        			else if(quest == 1) {
                		game.generateDivQuestions(players, i);
                		if(players[i].score == oldScore) {
        					lives--;
        				}
            		}
        			else{
                		game.generateMultQuestions(players, i);
                		if(players[i].score == oldScore) {
        					lives--;
        				}
            		}
        		}
        		long endTime = System.currentTimeMillis();
                long totalTime = endTime - startTime;
                System.out.println("You have taken: "+totalTime/1000+"\tseconds");
                game.printSummary(players, i);
        	}
        }
        
        if (mode == 4) {
        	System.out.println("Enter time limit (seconds): ");
        	int timeLimit = input.nextInt();
        	for( int i = 0; i < playerNum; i++) {
        		System.out.println("Enter your name: ");
        		players[i] = new Player();
        		players[i].name = input.next();
        		long starts = System.currentTimeMillis();
        		while((System.currentTimeMillis()/1000) - (starts/1000) < timeLimit){
        			int quest = (int)(Math.random() * 4);
        			if(quest == 3) {
        				game.generateAddQuestions(players, i);
        			}
        			else if(quest == 2) {
        				game.generateSubQuestions(players, i);
        			}
        			else if(quest == 1) {
        				game.generateDivQuestions(players, i);
        			}
        			else{
        				game.generateMultQuestions(players, i);
        			}
        		}
                System.out.println("Times up");
                game.printSummary(players, i);
        	}
        }
        System.out.println("\n------Ranking (score)------");
        for(int i = 0; i<playerNum; i++) {
        	for(int j = 0; j<playerNum; j++) {
        		if(players[i].score > players[j].score) {
        			Player Temp = players[i];
        			players[i] = players[j];
        			players[j] =  Temp;
        		}
        	}
        }
        for(int i = 0; i<playerNum; i++) {
        	System.out.println(players[i].name+":\t"+players[i].score);
        	
        }

    }
}

