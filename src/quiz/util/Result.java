package src.quiz.util;

/**
 * This class represents a Result of the Quiz. <br>
 * 
 * @author Camila Maciel, Everton Leandro
 * @since 03/04/2008
 * @version 1.0
 * 
 */
public class Result {

	// attributes

	private int time;

	private int score;

	/**
	 * Constructor
	 *
	 */
	public Result() {

	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}

}

