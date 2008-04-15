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
	
	static List<Result> lista;
	
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
			
			quiz.start();
			
			lista = new ArrayList<Result>();				
			int currentQuestion = -1;
			while (quiz.isAlive() ){
				int question = quiz.currentQuestion();
				if (quiz.isAnswer())
					if (currentQuestion != question){
						Result result = quiz.getPartialResult();
						lista.add(result);
						currentQuestion = question;
					}
				
				
			}
			
			System.out.println(lista.size());
			for (int i = 0; i < lista.size(); i++) {
				Result result2 = (Result)lista.get(i);
				System.out.println("=>>  TIME "+result2.getTime()/1000L+" =>>  SCORE "+result2.getScore());
			}
			
			
			Result finalResult =  quiz.getPartialResult();
			System.out.println(finalResult);
			evaluateResult(finalResult, numberOfQuestions);
			quizesResults.add(finalResult);
					
		}
						
	}
	
	public void createUserProfile(){
		
	}

	public void evaluateResult(Result result, int numberOfQuestions){
		
	}
	
	public void evaluateFinalResult(){
		
	}
}
