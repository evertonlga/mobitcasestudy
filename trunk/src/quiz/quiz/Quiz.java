package quiz.quiz;

import java.io.Serializable;
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

	private long initialTime;
	
	private long acumulatedTime;

	private int status;

	private int numberOfQuestions;

	private Result result;

	private QuestionGenerator questionGenerator;
	
	Scanner input = new Scanner(System.in);

	private final int READY = 0;

	private final int HELPING = 1;

	private final int RUNNING = 2;

	private final int ENDING = 3;
	
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
		this.initialTime = System.currentTimeMillis();
		this.acumulatedTime = 0;
		this.Responded = false;
		this.status = READY;

	}

	
	public void run() {
		synchronized (this) {
			initialOptions();
		}
		setStatus(RUNNING);
		for (int i = 0;i < numberOfQuestions; i++){
			Result res = new Result();
			setResponded(false);
			Question q = questionGenerator.getQuestion();
			
			System.out.println(q);
			int userAnswer = getAnswer(); 
			if (q.getAnswer() == userAnswer){				
				res.setScore(result.getScore()+1);
				getPartialResult().updateResultByCategory(q.getCategory(),true);
				res.setResultByCategory(result.getResultByCategory());
			}else {
				getPartialResult().updateResultByCategory(q.getCategory(),false);
				res.setResultByCategory(result.getResultByCategory());
			}
			
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
		setStatus(ENDING);
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

	private void initialOptions() {
		System.out.println("\nFor start press 1\nFor abort the Quiz press 2\n" +
		"For help press 3");
		int key = input.nextInt();
		switch (key) {
			case 1:				
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
		setStatus(HELPING);
		System.out.println("HELP!!!\n For back to Quiz press 0");
		int r = 100;
		while(r != 0){
			r = input.nextInt();
		}
		setStatus(RUNNING);
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
		setStatus(ENDING);
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
		return initialTime;
	}

	public long getAcumulatedTime() {
		return acumulatedTime;
	}

	public void setAcumulatedTime(long acumulatedTime) {
		this.acumulatedTime = acumulatedTime;
	}

	public void setInitialTime(long initialTime) {
		this.initialTime = initialTime;
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


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}

}
