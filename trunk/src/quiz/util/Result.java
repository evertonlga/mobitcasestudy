package quiz.util;

import java.util.ArrayList;

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
	
	private ArrayList<CategoryResult> resultByCategory;


	/**
	 * Constructor
	 *
	 */
	public Result() {
		this.score = 0;
		this.time = 0;
		this.resultByCategory = inicialize();
	}

	private ArrayList inicialize() {
		resultByCategory = new ArrayList<CategoryResult>();
		CategoryKind [] c = CategoryKind.values();
		for (int i =0; i<c.length;i++){
			resultByCategory.add(new CategoryResult(c[i].name()));
		}
		return resultByCategory;
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

	public void updateResultByCategory(CategoryKind category, boolean correct) {
		for (int i = 0;i< resultByCategory.size();i++){
			CategoryResult c = resultByCategory.get(i);
			if (c.getName().equals(category.name())){
				if (correct)
					c.setNumberOfCorrects(c.getNumberOfCorrects()+1);
				c.setNumberQuestions(c.numberQuestions+1);
			}
		}
	}

	public ArrayList<CategoryResult> getResultByCategory() {
		return resultByCategory;
	}

	public void setResultByCategory(ArrayList<CategoryResult> info) {
		this.resultByCategory = info;
		
	}

	public Result clone(){
		Result result = new Result();
		result.setScore(this.score);
		result.setTime(this.time);
		result.setResultByCategory(this.resultByCategory);
		return result;
		
	}
	
}

