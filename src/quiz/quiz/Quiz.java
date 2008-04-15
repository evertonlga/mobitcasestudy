package quiz.quiz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import quiz.questionGenerator.QuestionGenerator;
import quiz.util.Question;
import quiz.util.Result;

/**
 * This class represents a Quiz. <br>
 * 
 * @author Camila Maciel, Everton Leandro
 * @since 03/04/2008
 * @version 1.0
 * 
 */
public class Quiz extends Thread implements Serializable {

	private static final long serialVersionUID = 1L;

	private long InitialTime;
	
	private long acumulatedTime;

	private int status;

	private int numberOfQuestions;

	private Result result;

	private QuestionGenerator questionGenerator;
	
	private ArrayList<Question> questions ;

	private static Quiz instance = null;

	Scanner input = new Scanner(System.in);

	private static final int STARTING = 0;

	private static final int HELPING = 1;

	private static final int PAUSING = 2;

	private static final int ABORTING = 3;
	
	private int currentQuestion;

	private boolean answer;

	/**
	 * Constructor
	 *
	 */
	public Quiz(String name) {
		super(name);

		this.questionGenerator = new QuestionGenerator();
		this.questions = questionGenerator.returnQuestions();
		this.result = new Result();
		this.InitialTime = System.currentTimeMillis();
		this.acumulatedTime = 0;
		this.answer = false;

	}

	
	public Result begin(){
		run();
		return result;
	}
	
	public void run() {

		Scanner input = new Scanner(System.in);
		Result r = getPartialResult();
		for (int i = 0;i < numberOfQuestions; i++){
			Result res = new Result();
			setAnswer(false);
			Question q = questionGenerator.getQuestion();
			
			System.out.println(q);
			System.out.print("Give your answer:");
			int userAnswer = input.nextInt();
			if (q.getAnswer() == userAnswer)				
				res.setScore(result.getScore()+1);
			
			setAcumulatedTime(getAcumulatedTime()+ (System.currentTimeMillis() - getInitialTime()));
			
			
			res.setTime(getAcumulatedTime());
			setPartialResult(res);
			
			currentQuestion = i;
			setAnswer(true);
			synchronized (this) {
				System.out.println("\nFor pause press 1\nFor abort the Quiz press 2\n" +
						"For help press 3");
				int key = input.nextInt();
				switch (key) {
				case 1:pause();				
					break;
				case 2:abort();
					break;
				case 3:help();
					break;
				}
			}
			
		}
	}
	
	public void help() {
		System.out.println("HELP!!!\n For back to Quiz press 0");
		int r = 100;
		while(r != 0){
			r = input.nextInt();
		}
	}

	public void pause() {
		try {
			setInitialTime(System.currentTimeMillis());
			System.out.println("For unpause press 0");
			boolean b = true;
			while(b == true){
				wait(10);
				int p = input.nextInt();
				if (p == 0){
					b = false;
					notifyAll();
				}
			}
		} catch (InterruptedException e) {
		}
	}

	public void abort() {
		synchronized (this) {
			super.stop();	
		}
	}

	public Result getPartialResult() {
		return result;
	}

	public void setPartialResult(Result result) {
		this.result = result;
	}

	public void configure(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	public long getInitialTime() {
		return InitialTime;
	}

	public long getAcumulatedTime() {
		return acumulatedTime;
	}

	public void setAcumulatedTime(long acumulatedTime) {
		this.acumulatedTime = acumulatedTime;
	}

	public void setInitialTime(long initialTime) {
		InitialTime = initialTime;
	}
		
	public int currentQuestion(){
		return currentQuestion;
	}


	public boolean isAnswer() {
		return answer;
	}


	public void setAnswer(boolean answer) {
		this.answer = answer;
	}

}
