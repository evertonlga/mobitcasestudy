package quiz;

import quiz.quiz.Quiz;
import quiz.quizManager.QuizManager;

/**
* This class represents the Context. <br>
* 
* @author Camila Maciel, Everton Leandro
* @since 03/04/2008
* @version 1.0
* 
*/
public class System {

	public static void main(String[] args) {
		QuizManager quizManager = new QuizManager();
		
		//cria os quizes (instance == null)
		Quiz quiz1 = Quiz.getInstance("Quiz 1");
		Quiz quiz2 = Quiz.getInstance("Quiz 2");
		Quiz quiz3 = Quiz.getInstance("Quiz 3");
		Quiz quiz4 = Quiz.getInstance("Quiz 4");
		Quiz quiz5 = Quiz.getInstance("Quiz 5");
		
		quizManager.schedulerOfQuizes();
	}
}
