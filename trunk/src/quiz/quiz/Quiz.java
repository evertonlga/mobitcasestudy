package src.quiz.quiz;

import java.io.Serializable;

import src.quiz.util.Result;

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
	
	private static final int START = 0;
	private static final int HELP = 1;
	private static final int PAUSE = 2;
	private static final int ABORT = 3;
	
	/**
	 * Constructor
	 *
	 */
	public Quiz(){
		
	}
	

	public void start(){
		
	}
	
	public void help(){
		
	}
	
	public void pause(){
		
	}
	
	public void abort(){
		
	}
	
	public Result getPartialResult(){
		return result;
	}
	
	public void setPartialResult(Result result){
		this.result = result;
	}
	
	public void configure(){
		
	}
}
