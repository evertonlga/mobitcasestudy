package quiz.util;

public class CategoryInformation{
	
	String name;
	int numberQuestions;
	int numberOfCorrects;
	
	public CategoryInformation(CategoryKind kind) {
		this.name = kind.name();
		this.numberQuestions = 0;
		this.numberOfCorrects = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfCorrects() {
		return numberOfCorrects;
	}

	public void setNumberOfCorrects(int numberOfCorrects) {
		this.numberOfCorrects = numberOfCorrects;
	}

	public int getNumberQuestions() {
		return numberQuestions;
	}

	public void setNumberQuestions(int numberQuestions) {
		this.numberQuestions = numberQuestions;
	}
}
