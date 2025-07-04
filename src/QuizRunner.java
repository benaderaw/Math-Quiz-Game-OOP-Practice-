public class QuizRunner {

    // OBJECTIVES
    // run quiz 5 times 🟢
    // display quiz 🟢
    // get user inout 🔴
    // validate 🔴
    // track score 🔴

    // create new Question instance object
    Question newQuestion = new Question();

    // generate 5 questions
    public void startQuiz(){

        // run quiz 5 times and display to console
        for(int i = 0; i < 5; i++){
            newQuestion.generateQuestion();
            System.out.println(newQuestion.getQuestion());
        }
    }




}
