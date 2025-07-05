import java.util.Scanner;

public class QuizRunner {
    // OBJECTIVES
    // run quiz 5 times 🟢
    // display quiz 🟢
    // get user inout 🟢
    // answer validation 🟢
    // track result 🟢

    Scanner scanner = new Scanner(System.in);
    Question newQuestion = new Question();

    private int intUserInput = 0;
    private double doubleUserInput = 0.0;
    private boolean isCorrect = false;
    private int result = 0;

    // generate 5 questions
    public void startQuiz(){
        System.out.println("<=== QUIZ STARTED ===>");

        int intAnswer = 0;
        double doubleAnswer = 0.0;

        // run quiz 5 times and display to console
        for(int i = 1; i <= 5; i++){
            System.out.print(i + ". ");
            newQuestion.generateQuestion();
            System.out.println(newQuestion.getQuestion());

            // check if the new question is division
            char operator = newQuestion.getDivisionOperator();

            if(operator == '/'){
                doubleInputValidation();
                doubleAnswerValidation(doubleAnswer);
            }else{
                intInputValidation();
                intAnswerValidation(intAnswer);
            }

            result = (isCorrect) ? result + 1 : result;
        }

        System.out.println("=== RESULT ===");
        System.out.println("You got " + result + " questions right.");
    }

    // int input validation
    private void intInputValidation(){
        while(true){
            System.out.print("Your answer: ");

            if(scanner.hasNextInt()){
                intUserInput = scanner.nextInt();
                scanner.nextLine();
                break;
            }else{
                scanner.nextLine();
                System.out.println("🔶Answer must be a number...");
            }
        }
    }

    // double input validation
    private void doubleInputValidation(){
        while(true){
            System.out.print("Your answer: ");

            if(scanner.hasNextDouble()){
                doubleUserInput = scanner.nextDouble();
                scanner.nextLine();
                break;
            }else{
                scanner.nextLine();
                System.out.println("🔶Answer must be a number...");
            }
        }
    }

    // int answer validation
    private void intAnswerValidation(int answer){
        answer = newQuestion.getAnswer();

        if(intUserInput == answer){
            System.out.println("Correct!");
            isCorrect = true;
        }else{
            System.out.println("Incorrect");
            isCorrect = false;
        }

        System.out.print("\n");
    }

    // double answer validation
    private void doubleAnswerValidation(double answer){
        answer = newQuestion.getDivisionAnswer();

        if(doubleUserInput == answer){
            System.out.println("Correct!");
            isCorrect = true;
        }else{
            System.out.println("Incorrect");
            isCorrect = false;
        }

        System.out.print("\n");
    }
}
