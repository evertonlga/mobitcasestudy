package quiz.util;

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

	private long time;

	private int score;


	/**
	 * Constructor
	 *
	 */
	public Result() {
		this.score = 0;
		this.time = 0;
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
	public long getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(long time) {
		this.time = time;
	}
	
	public String toString(){
		return "Final Time: "+getTime()/1000L+"\nFinal Score: "+ getScore();
	}


	
}
