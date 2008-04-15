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
	
	Scanner input = new Scanner(System.in);

	private static final int STARTING = 0;

	private static final int HELPING = 1;

	private static final int PAUSING = 2;

	private static final int ABORTING = 3;
	
	private int currentQuestion;

	private boolean Responded;

	/**
	 * Constructor
	 *
	 */
	public Quiz(String name) {
		super(name);

		this.questionGenerator = new QuestionGenerator();
		this.result = new Result();
		this.InitialTime = System.currentTimeMillis();
		this.acumulatedTime = 0;
		this.Responded = false;

	}

	
	public void run() {

		for (int i = 0;i < numberOfQuestions; i++){
			Result res = new Result();
			setResponded(false);
			Question q = questionGenerator.getQuestion();
			
			System.out.println(q);
			int userAnswer = getAnswer(); 
			if (q.getAnswer() == userAnswer)				
				res.setScore(result.getScore()+1);
			
			long acumulatedTimeBefore = getAcumulatedTime();
			setAcumulatedTime(acumulatedTimeBefore + (System.currentTimeMillis() - getInitialTime()));
			setInitialTime(System.currentTimeMillis());
			res.setTime(getAcumulatedTime());
			setPartialResult(res);
			
			currentQuestion = i;
			setResponded(true);
			synchronized (this) {
				options();
			}
			
			
			
		}
	}
	
	private void options() {
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


	private int getAnswer() {
		System.out.print("Give your answer:");
		return input.nextInt();
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
			System.out.println("For unpause press 0");
			boolean b = true;
			while(b == true){
				sleep(10);
				int p = input.nextInt();
				if (p == 0)
					b = false;
			}
			setInitialTime(System.currentTimeMillis());
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


	public boolean isResponded() {
		return Responded;
	}


	public void setResponded(boolean answer) {
		this.Responded = answer;
	}

}
