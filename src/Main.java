import java.util.Random;

public class Main {
    public static void main(String[] args){
        System.out.println("<===== Math Quiz Game (OOP Practice) =====>");

        Question question = new Question();

        question.generateQuestion();

        System.out.println(question.getQuestion());
        System.out.println(question.getAnswer());
        System.out.println(question.getDivisionAnswer());
    }
}
