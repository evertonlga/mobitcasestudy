package quiz.quizManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import quiz.quiz.Quiz;
import quiz.util.CategoryInformation;
import quiz.util.CategoryKind;
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
				if (quiz.isResponded())
					if (currentQuestion != question){
						Result result = quiz.getPartialResult();
						lista.add(result);
						currentQuestion = question;
					}
				
				
			}
			
//			System.out.println(lista.size());
//			for (int i = 0; i < lista.size(); i++) {
//				Result result2 = (Result)lista.get(i);
//				System.out.println("=>>  TIME "+result2.getTime()/1000L+" =>>  SCORE "+result2.getScore());
//			}
			
			
			Result finalResult =  quiz.getPartialResult();
			//System.out.println(finalResult);
			evaluateResult(finalResult, numberOfQuestions);
			quizesResults.add(finalResult);
					
		}
		evaluateFinalResult(quizesResults,numberOfQuestions);
		createUserProfile(quizesResults);
						
	}
	
	public void createUserProfile(List quizesResults){
		System.out.println("\n\n User Profile:\n");
		CategoryKind [] categorys = CategoryKind.values();
		for (int i= 0; i< categorys.length; i++){
			String categoryName = categorys[i].name();
			int numberOfQuestions = 0;
			int numberOfCorrectAnswers = 0;
			for (int j=0; j< quizesResults.size();j++){
				Result r = (Result) quizesResults.get(j);
				ArrayList<CategoryInformation> array = r.getNumberOfQuestionForCategory();
				CategoryInformation categoryInfo = array.get(i);
				numberOfQuestions+= categoryInfo.getNumberQuestions();
				numberOfCorrectAnswers+= categoryInfo.getNumberOfCorrects();
			}
			System.out.println("In the category "+ categoryName+"("+numberOfQuestions+
					" questions answered)the user obtained a profit of "+
					new Double(numberOfCorrectAnswers)/numberOfQuestions*100+"%");
			
		}
		
//		for (int i=0; i< quizesResults.size();i++){
//			Result r = (Result) quizesResults.get(i);
//			ArrayList<CategoryInformation> array = r.getNumberOfQuestionForCategory();
//			String categoryNome = array.get(0).getName();
//			int numberOfQuestions = 0;
//			int numberOfCorrectAnswers = 0;
//			for (CategoryInformation c : array){
//				numberOfQuestions+=c.getNumberQuestions();
//				numberOfCorrectAnswers+=c.getNumberOfCorrects();
//			}
//			System.out.println("The user obtained a profit of "+
//					new Double(numberOfCorrectAnswers)/numberOfQuestions+"% in the category"+
//					categoryNome);
			
//		}
//			Result r = (Result) quizesResults.get(i);
//			for (int j=0; j<r.getNumberOfQuestionForCategory().size();j++){
//				
//			}
//		}
		
	}

	public void evaluateResult(Result result, int numberOfQuestions){
		double d = result.getScore()/numberOfQuestions*100;
		System.out.println(result+"\nThe percentage of successes was: "+
				new Double(result.getScore())/numberOfQuestions*100+"%");
		
	}
	
	public void evaluateFinalResult(List quizesResults, int numberOfQuestions){
		System.out.println("Final results of quizes:");
		for (int i = 0; i < quizesResults.size(); i++){
			System.out.println("The percentage of successes in the quiz "+(i+1)+" was:"+
				new Double(((Result)quizesResults.get(i)).getScore())/numberOfQuestions*100+"%");
		}
	}
}
