package quiz.quiz;

import java.io.Serializable;
import java.util.Scanner;

import quiz.questionGenerator.QuestionGenerator;
import quiz.util.Question;
import quiz.util.Result;
import quiz.util.StatusKind;

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

	private StatusKind status;

	private int numberOfQuestions;

	private Result result;

	private QuestionGenerator questionGenerator;
	
	Scanner input = new Scanner(System.in);
	
	private int currentQuestion;

	private boolean responded;

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
		this.responded = false;
		this.status = StatusKind.ready;

	}

	public String getStateQuiz(){
		return getStatus().name();
	}
	
	public void run(){
		System.out.println("RUN");
		setStatus(StatusKind.running);
		while (numberOfQuestions>0) {
			try {
				sleep(100);
			} catch (InterruptedException e) {}
		}
		setStatus(StatusKind.ending);
	}
	
//	public void run(){
//		synchronized (this) {
//			initialOptions(input.nextInt());
//		}
//	}
//	
//	public void begin() {
//		setStatus(StatusKind.running);
//		for (int i = 0;i < numberOfQuestions; i++){
//			Question q = questionGenerator.getQuestion();
//			System.out.println(q);
//			int userAnswer = getAnswer(); 
//			answerQuestion(q,userAnswer);
//			
//			currentQuestion = i;
//			synchronized (this) {
//				options();
//			}
//				
//		}
//		setStatus(StatusKind.ending);
//	}
	
	public void answerQuestion(int userAnswer) {
		Result res = getPartialResult().clone();
		setResponded(false);
		Question q = questionGenerator.getQuestion();
		System.out.println(q);
		System.out.println(userAnswer);
		if (q.getAnswer() == userAnswer){				
			res.setScore(result.getScore()+1);
			res.updateResultByCategory(q.getCategory(),true);
		}else {
			res.updateResultByCategory(q.getCategory(),false);
		}
		
		long acumulatedTimeBefore = getAcumulatedTime();
		setAcumulatedTime(acumulatedTimeBefore + (System.currentTimeMillis() - getInitialTime()));
		setInitialTime(System.currentTimeMillis());
		res.setTime(getAcumulatedTime());
		setPartialResult(res);
				
		setResponded(true);
		configure(numberOfQuestions-1);
		
	}


	private void options() {
		System.out.println("\nFor pause press 1\nFor abort the Quiz press 2\n" +
		"For help press 3");
		int key = input.nextInt();
		switch (key) {
			case 1:pause(key);				
			break;
			case 2:abort();
			break;
			case 3:help(key);
			break;
		}
		
	}

	
	
	public void initialOptions(int key) {
		System.out.println("\nFor start press 1\nFor abort the Quiz press 2\n" +
		"For help press 3");
		//int key = input.nextInt();
		switch (key) {
			case 1:			
			break;
			case 2:abort();
			break;
			case 3:help(key);
			break;
		}
		
	}
	

	private int getAnswer() {
		System.out.print("Give your answer:");
		return input.nextInt();
	}


	public void help(int i) {
		setStatus(StatusKind.helping);
//		System.out.println("HELP!!!\n For back to Quiz press 0");
//		int r = 100;
//		while(r != 0){
//			r = input.nextInt();
//		}
//		setStatus(StatusKind.running);
		if (i == 0)
			setStatus(StatusKind.running);
	}

	
	public void pause(int i) {
//		try {
//			System.out.println("For unpause press 0");
//			boolean b = true;
//			while(b == true){
//				sleep(10);
//				int p = input.nextInt();
//				if (p == 0)
//					b = false;
//			}
//			setInitialTime(System.currentTimeMillis());
//		} catch (InterruptedException e) {
//		}
		if (i != 0){
			setStatus(StatusKind.pausing);
			interrupt();
		} else {
			setStatus(StatusKind.running);
			setInitialTime(System.currentTimeMillis());
		}
	}

	public void abort() {
		synchronized (this) {
			super.stop();	
		}
		setStatus(StatusKind.ending);
	}

	public Result getPartialResult() {
		return result;
	}

	public void setPartialResult(Result res) {		
		this.result = res;
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
		return responded;
	}


	public void setResponded(boolean answer) {
		this.responded = answer;
	}


	public StatusKind getStatus() {
		return status;
	}


	public void setStatus(StatusKind status) {
		this.status = status;
	}

	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

}
