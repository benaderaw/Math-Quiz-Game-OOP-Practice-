import java.util.Scanner;

public class QuizRunner {
    // OBJECTIVES
    // run quiz 5 times 🟢
    // display quiz 🟢
    // get user inout 🟢
    // answer validation 🟢
    // track result 🟢

    // OBJECT INSTANCES
    Scanner scanner = new Scanner(System.in);
    Question newQuestion = new Question();

    // FIELDS
    private int intUserAnswer = 0;
    private double doubleUserAnswer = 0.0;
    private boolean isCorrect = false;
    private int result = 0;

    // generate 5 questions
    public void startQuiz(){
        System.out.println("<=== QUIZ STARTED ===>");

        // get number of questions from user
        int numOfQuestions = numOfQuestions();

        // run quiz 5 times and display to console
        for(int i = 1; i <= numOfQuestions; i++){
            System.out.print(i + ". ");

            // generate and display question
            newQuestion.generateQuestion();
            System.out.println(newQuestion.getQuestion());

            // validate answer
            if(newQuestion.isDivisionQuestion()){
                doubleInputValidation();
                doubleAnswerValidation();
            }else{
                intInputValidation();
                intAnswerValidation();
            }

            // track result
            result = (isCorrect) ? result + 1 : result;
        }

        // display result
        System.out.println("=== RESULT ===");
        System.out.println("You got " + result + " questions out of " + numOfQuestions + " right.");
    }

    // number of questions
    private int numOfQuestions(){
        int num;

        while(true) {
            System.out.print("How many questions do you want: ");
            if(scanner.hasNextInt()){
                num = scanner.nextInt();
                scanner.nextLine();
                break;
            }else{
                scanner.nextLine();
                System.out.println("🔶Must be a number...\n");
            }
        }
        
        return num;
    }

    // int input validation
    private void intInputValidation(){
        while(true){
            System.out.print("Your answer: ");

            if(scanner.hasNextInt()){
                intUserAnswer = scanner.nextInt();
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
                doubleUserAnswer = scanner.nextDouble();
                scanner.nextLine();
                break;
            }else{
                scanner.nextLine();
                System.out.println("🔶Answer must be a number...");
            }
        }
    }

    // int answer validation
    private void intAnswerValidation(){
        int intAnswer = newQuestion.getAnswer();

        if(intUserAnswer == intAnswer){
            System.out.println("Correct!");
            isCorrect = true;
        }else{
            System.out.println("Incorrect");
            isCorrect = false;
        }

        System.out.print("\n");
    }

    // double answer validation
    private void doubleAnswerValidation(){
            double doubleAnswer = newQuestion.getDivisionAnswer();

            if(doubleUserAnswer == doubleAnswer){
                System.out.println("Correct!");
                isCorrect = true;
            }else{
                System.out.println("Incorrect");
                isCorrect = false;
            }

            System.out.print("\n");
    }
}
