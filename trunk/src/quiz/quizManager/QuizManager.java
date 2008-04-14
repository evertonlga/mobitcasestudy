package quiz.quizManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import quiz.quiz.Quiz;
import quiz.util.Result;

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
	
	//private int numberOfQuizes;
	
	/**
	 * Constructor
	 *
	 */
	public QuizManager(){
		this.quizesResults = new ArrayList<Result>();
	}
	
	public void schedulerOfQuizes(ArrayList<Quiz> quizCollection){
		int numberOfQuestions = 5;
		for (Quiz quiz : quizCollection){
			quiz.configure(numberOfQuestions);
			Result result = quiz.begin();
			evaluateResult(result, numberOfQuestions);
			quizesResults.add(result);
		}
						
	}
	
	public void createUserProfile(){
		
	}

	public void evaluateResult(Result result, int numberOfQuestions){
		
	}
	
	public void evaluateFinalResult(){
		
	}
}
