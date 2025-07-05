import java.util.Random;

public class Question {
    // ENUMs
    private enum Operator {ADD, SUBTRACT, MULTIPLY, DIVIDE}

    // IMPORTS
    private Random random = new Random();

    // FIELDS
    private String question;
    private int answer;
    private double divisionAnswer;
    private char divisionOperator;
    // for random number from 1 to 100
    private int firstNum = 1;
    private int secondNum = 1;

    // get random operation
    public void generateQuestion(){
        // get random operator from ENUM
        Operator[] operators = Operator.values();
        int rand = random.nextInt(operators.length);
        Operator randomOperator = operators[rand];

        // get random numbers for quiz
        firstNum  = random.nextInt(15) + 1;
        secondNum = random.nextInt(15) + 1;
        divisionOperator = ' ';

        switch (randomOperator){
            case ADD:
                displayQuestion(" + ");
                answer = firstNum + secondNum;
                break;
            case SUBTRACT:
                displayQuestion(" - ");
                answer = firstNum - secondNum;
                break;
            case MULTIPLY:
                displayQuestion(" * ");
                answer = firstNum * secondNum;
                break;
            case DIVIDE:
                displayQuestion(" / ");
                divisionOperator = '/';
                divide();
                break;
            default:
                System.out.println("🔴[ERROR] Something went wrong...");
                break;
        }
    }

    // get question for display and answer to check users answer
    private void displayQuestion(String operationSymbol){
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

    // check if question is division
    public boolean isDivisionQuestion() {
        return divisionOperator == '/';
    }

    // GETTER
    public String getQuestion(){
        return question;
    }

    public int getAnswer() {
        return answer;
    }

    public double getDivisionAnswer() {
        return divisionAnswer;
    }
}