package assignment;

public class Game {
	public static int generateAddQuestions(Player[] players, int player){
        int num1 = (int)(Math.random() * 20);
        int num2 = (int)(Math.random() * 20);
        int actualAnswer = num1+num2;
        Assignment.display.setText(num1 + " + " + num2 + " =  ?");
        players[player].summary+= num1+"+"+num2+"=";
        return actualAnswer;
        
    }
    
    public static int generateSubQuestions(Player[] players, int player){
        int num1 = (int)(Math.random() * 20);
        int num2 = (int)(Math.random() * 20);
        while(num2 > num1) {
        num2 = (int)(Math.random() * 20);
        }
        int actualAnswer = num1-num2;
        Assignment.display.setText(num1 + " - " + num2 + " =  ?");
        players[player].summary+= num1+"-"+num2+"=";
        return actualAnswer;
    }
    
    public static int generateDivQuestions(Player[] players, int player){
        int num1 = (int)(Math.random() * 20);
        int num2 = (int)(Math.random() * 10);
        while(num2 == 0){
        	num2 = (int)(Math.random() * 10);
        }
        Double answer = ((double)num1/(double)num2);
        int actualAnswer = (int)Math.round(answer * 100.0);
        Assignment.display.setText(num1 + " / " + num2 + " =  ?");
        players[player].summary+= num1+"/"+num2+"=";
        return actualAnswer;
    }
    
    public static int generateMultQuestions(Player[] players, int player){
        int num1 = (int)(Math.random() * 20);
        int num2 = (int)(Math.random() * 20);
        int actualAnswer = num1*num2; 
        Assignment.display.setText(num1 + " * " + num2 + " =  ?");
        players[player].summary+= num1+"*"+num2+"=";
        return actualAnswer;
    }
    
    public static int getQuestion(Player[] players, int player, int quest){
    	int answer = 0;
    	if(quest == 3) {
			answer = generateAddQuestions(players, player);
		}
		else if(quest == 2) {
			answer = generateSubQuestions(players, player);
		}
		else if(quest == 1) {
			answer = generateDivQuestions(players, player);
		}
		else{
			answer = generateMultQuestions(players, player);
		}
    	return answer;
    }
}
