
package javaCourse.game;
import java.util.Scanner;
public class Game {

    
    public void generateAddQuestions(Player[] players, int player){
        Scanner input = new Scanner(System.in);
        int num1 = (int)(Math.random() * 20);
        int num2 = (int)(Math.random() * 20);
        int actualAnswer = num1+num2;
        System.out.println("What is "+num1+" + "+num2+" ?");
        int userAnswer = input.nextInt();
        
        players[player].summary += "\n"+num1+"+"+num2+"="+userAnswer+":"+(userAnswer==actualAnswer);
        if(actualAnswer == userAnswer){
            ++players[player].score;
            //System.out.println("True");
        }else{
            //System.out.println("False");
        }
        
    }
    
    public void generateSubQuestions(Player[] players, int player){
        Scanner input = new Scanner(System.in);
        int num1 = (int)(Math.random() * 20);
        int num2 = (int)(Math.random() * 20);
        while(num2 > num1) {
        num2 = (int)(Math.random() * 20);
        }
        int actualAnswer = num1-num2;
        System.out.println("What is "+num1+" - "+num2+" ?");
        int userAnswer = input.nextInt();
        
        players[player].summary += "\n"+num1+"-"+num2+"="+userAnswer+":"+(userAnswer==actualAnswer);
        if(actualAnswer == userAnswer){
            ++players[player].score;
            //System.out.println("True");
        }else{
            //System.out.println("False");
        }
        
    }
    
    public void generateDivQuestions(Player[] players, int player){
        Scanner input = new Scanner(System.in);
        int num1 = (int)(Math.random() * 20);
        int num2 = (int)(Math.random() * 10);
        while(num2 == 0){
        	num2 = (int)(Math.random() * 10);
        }
        Double answer = ((double)num1/(double)num2);
        Double actualAnswer = Math.round(answer * 100.0) / 100.0;
        System.out.println("What is "+num1+" / "+num2+" ?");
        
        Double userAnswer = input.nextDouble();
        String[] splits = {null,null};
        splits = userAnswer.toString().split("\\.");
        while(splits[1].length() > 2) {
        	System.out.println("Please enter the answer to 2 decimal places.");
        	userAnswer = input.nextDouble();
            splits = userAnswer.toString().split("\\.");
        }
        
        players[player].summary += "\n"+num1+"/"+num2+"="+userAnswer+":"+ (Double.compare(userAnswer, actualAnswer) == 0);
        if(Double.compare(userAnswer, actualAnswer) == 0){
            ++players[player].score;
            //System.out.println("True");
        }else{
            //System.out.println("False");
        }
        
    }
    
    public void generateMultQuestions(Player[] players, int player){
        Scanner input = new Scanner(System.in);
        int num1 = (int)(Math.random() * 20);
        int num2 = (int)(Math.random() * 20);
        int actualAnswer = num1*num2;
        System.out.println("What is "+num1+" * "+num2+" ?");
        int userAnswer = input.nextInt();
        
        players[player].summary += "\n"+num1+"*"+num2+"="+userAnswer+":"+(userAnswer==actualAnswer);
        if(actualAnswer == userAnswer){
            ++players[player].score;
            //System.out.println("True");
        }else{
            //System.out.println("False");
        }
        
    }
    
    public void printSummary(Player[] players, int player){
        System.out.println("Your Score: "+players[player].score);
        System.out.println("\n------Summary------"+players[player].summary);
    }
}
