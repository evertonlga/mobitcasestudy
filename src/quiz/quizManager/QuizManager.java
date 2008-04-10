package quiz.quizManager;

import java.io.Serializable;
import java.util.List;

import quiz.quiz.Quiz;

/**
 * This class represents a Quiz Manager. <br>
 * 
 * @author Camila Maciel, Everton Leandro
 * @since 03/04/2008
 * @version 1.0
 * 
 */
public class QuizManager implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List quizesResults;
	
	private int numberOfQuizes;
	
	/**
	 * Constructor
	 *
	 */
	public QuizManager(){
		
	}
	
	public void schedulerOfQuizes(){
		Quiz quiz1 = Quiz.getInstance("Quiz 1");
		Quiz quiz2 = Quiz.getInstance("Quiz 2");
		Quiz quiz3 = Quiz.getInstance("Quiz 3");
		Quiz quiz4 = Quiz.getInstance("Quiz 4");
		Quiz quiz5 = Quiz.getInstance("Quiz 5");
		
		quiz1.start();
		quiz2.start();
		quiz3.start();
		quiz4.start();
		quiz5.start();
				
	}
	
	public void createUserProfile(){
		
	}

	public void evaluateResult(){
		
	}
	
	public void evaluateFinalResult(){
		
	}
}