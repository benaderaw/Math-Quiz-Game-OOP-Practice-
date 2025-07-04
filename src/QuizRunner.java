import java.util.Scanner;

public class QuizRunner {

    // OBJECTIVES
    // run quiz 5 times 🟢
    // display quiz 🟢
    // get user inout 🟢
    // validate 🔴
    // track score 🔴

    // scanner
    Scanner scanner = new Scanner(System.in);
    int intUserInput = 0;
    double doubleUserInput = 0.0;


    // create new Question instance object
    Question newQuestion = new Question();


    // generate 5 questions
    public void startQuiz(){
        System.out.println("<=== QUIZ STARTED ===>");

        // run quiz 5 times and display to console
        for(int i = 1; i <= 5; i++){
            System.out.print(i + ". ");
            newQuestion.generateQuestion();
            System.out.println(newQuestion.getQuestion());
            System.out.print("Your answer: ");

            char operator = newQuestion.getDivisionOperator();

            if(operator == '/'){
                doubleInputValidation();
            }else{
                intInputValidation();
            }
        }
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




}
