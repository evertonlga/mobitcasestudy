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
	
	private ArrayList<CategoryInformation> numberOfQuestionForCategory;


	/**
	 * Constructor
	 *
	 */
	public Result() {
		this.score = 0;
		this.time = 0;
		this.numberOfQuestionForCategory = inicialize();
	}

	private ArrayList inicialize() {
		numberOfQuestionForCategory = new ArrayList<CategoryInformation>();
		CategoryKind [] c = CategoryKind.values();
		for (int i =0; i<c.length;i++){
			numberOfQuestionForCategory.add(new CategoryInformation(c[i]));
		}
		return numberOfQuestionForCategory;
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

	public ArrayList<CategoryInformation> setInformation(CategoryKind category, boolean correct) {
		for (int i = 0;i< numberOfQuestionForCategory.size();i++){
			CategoryInformation c = numberOfQuestionForCategory.get(i);
			if (c.getName().equals(category.name())){
				if (correct)
					c.setNumberOfCorrects(c.getNumberOfCorrects()+1);
				c.setNumberQuestions(c.numberQuestions+1);
			}
		}
		return numberOfQuestionForCategory;
	}

	public ArrayList<CategoryInformation> getNumberOfQuestionForCategory() {
		return numberOfQuestionForCategory;
	}

	public void setInformations(ArrayList<CategoryInformation> info) {
		this.numberOfQuestionForCategory = info;
		
	}


	
}

