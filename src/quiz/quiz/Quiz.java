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

	/**
	 * Constructor
	 *
	 */
	private Quiz(String name) {
		super(name);

		// dorme entre 0 e 5 segundos
//		time = (int) (Math.random() * 5000);
//		System.err.println("Name: " + getName() + "; sleep: " + time);
		this.questionGenerator = new QuestionGenerator();
		this.questions = questionGenerator.returnQuestions();
		this.result = new Result();
		this.InitialTime = System.currentTimeMillis();
		this.acumulatedTime = 0;

	}

	/**
	 * Returns a instance of Quiz 
	 * @param name The Quiz name
	 * @return The instance
	 */
	public static Quiz getInstance(String name) {
		if (instance == null) {
			return new Quiz(name);
		}
		return instance;
	}

	public void run() {
//		antes = System.currentTimeMillis();
//		try {
//			Thread.sleep(time);
//		} catch (InterruptedException exception) {
//			System.err.println(exception.toString());
//		}
//
//		depois = System.currentTimeMillis();
//
//		System.out.println((depois - antes) + " ms");
		Scanner input = new Scanner(System.in);
		Result r = getPartialResult();
		for (int i = 0;i < numberOfQuestions; i++){
			Question q = getQuestion();
			System.out.println(q);
			System.out.print("Give your answer:");
			int userAnswer = input.nextInt();
			if (q.getAnswer() == userAnswer)				
				r.setScore(r.getScore()+1);
			
			setAcumulatedTime(getAcumulatedTime()+ (System.currentTimeMillis() - getInitialTime()));
			r.setTime(getAcumulatedTime());
			setPartialResult(r);
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
		System.out.println(result);
	}

	public Question getQuestion() {
		Collections.shuffle(questions);
		Question question = questions.get(0);
		questions.remove(question);
		return question;
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
}
