package quiz.util;

import java.util.List;

/**
 * This class represents a Question of the Quiz. <br>
 * 
 * @author Camila Maciel, Everton Leandro
 * @since 03/04/2008
 * @version 1.0
 * 
 */
public class Question {

	// attributes

	private String description;

	private CategoryKind category;
	
	private List<String> alternatives;
	
	private int answer;

	/**
	 * Question class constructor
	 *
	 */
	public Question() {

	}

	/**
	 * @return the category
	 */
	public CategoryKind getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(CategoryKind category) {
		this.category = category;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the alternatives
	 */
	public List<String> getAlternatives() {
		return alternatives;
	}

	/**
	 * @param alternatives the alternatives to set
	 */
	public void setAlternatives(List<String> alternatives) {
		this.alternatives = alternatives;
	}

	/**
	 * @return the answer
	 */
	public int getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	
	

}
