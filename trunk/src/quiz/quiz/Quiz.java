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

	private int time;

	private int status;

	private int numberOfQuestions;

	private Result result;

	private QuestionGenerator questionGenerator;
	
	private ArrayList<Question> questions ;

	private static Quiz instance = null;

	private long antes;

	private long depois;

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
		time = (int) (Math.random() * 5000);
		System.err.println("Name: " + getName() + "; sleep: " + time);
		this.questionGenerator = new QuestionGenerator();
		this.questions = questionGenerator.returnQuestions();
		this.result = new Result();

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
		for (int i = 0;i < numberOfQuestions; i++){
			Question q = getQuestion();
			System.out.println(q);
			int userAnswer = input.nextInt();
			if (q.getAnswer() == userAnswer){
				Result r = getPartialResult();
				r.setScore(r.getScore()+1);
				setPartialResult(r);
			}
		}
	}

	public Question getQuestion() {
		Collections.shuffle(questions);
		Question question = questions.get(0);
		questions.remove(question);
		return question;
	}
	
	public void help() {

	}

	public void pause() {

	}

	public void abort() {

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
}
