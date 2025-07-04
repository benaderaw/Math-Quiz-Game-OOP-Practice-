import java.util.Random;

public class Question {
    // IMPORTS
    private Random random = new Random();
    
    private String question;
    private int answer;
    private double divisionAnswer;
    private char divisionOperator;

    // get random number from 0 to 3
    private int randomOperation = random.nextInt(4);

    // fer random number from 1 to 100
    private int firstNum = 1;
    private int secondNum = 1;

    // get random operation
    public void generateQuestion(){
        firstNum  = random.nextInt(10) + 1;
        secondNum = random.nextInt(10) + 1;

        switch (randomOperation){
            case 0:
                getDisplayQuestion(" + ");
                answer = firstNum + secondNum;
                break;
            case 1:
                getDisplayQuestion(" - ");
                answer = firstNum - secondNum;
                break;
            case 2:
                getDisplayQuestion(" * ");
                answer = firstNum * secondNum;
                break;
            default:
                divisionOperator = '/';
                divide();
                break;
        }
    }

    // get question for display and answer to check users answer
    private void getDisplayQuestion(String operationSymbol){
        question = "What is " + firstNum + operationSymbol + secondNum + "?";
    }

    // divide - makes the larger bum be divisible by the smaller num
    private void divide(){
        if(secondNum > firstNum){
            question = "What is " + secondNum + " / " + firstNum + "?";
            double tempAnswer = (double) secondNum / firstNum;
            divisionAnswer = Math.round(tempAnswer * 100.0) / 100.0;
        }else{
            question = "What is " + firstNum + " / " + secondNum + "?";
            double tempAnswer = (double) firstNum / secondNum;
            divisionAnswer = Math.round(tempAnswer * 100.0) / 100.0;
        }
    }

    // GETTER METHODS
    public String getQuestion(){
        return question;
    }

    public int getAnswer() {
        return answer;
    }

    public double getDivisionAnswer() {
        return divisionAnswer;
    }

    public char getDivisionOperator() {
        return divisionOperator;
    }
}