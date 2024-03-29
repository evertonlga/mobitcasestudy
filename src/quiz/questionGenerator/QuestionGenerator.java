package quiz.questionGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import quiz.util.Question;

import com.thoughtworks.xstream.XStream;

/**
 * This class represents a Question Generator. <br>
 * 
 * @author Camila Maciel, Everton Leandro
 * @since 03/04/2008
 * @version 1.0
 * 
 */
public class QuestionGenerator implements Cloneable{

	public ArrayList<Question> questions;

	/**
	 * Constructor
	 *
	 */
	public QuestionGenerator() {
		questions = getQuestions();
	}

	/**
	 * Returns a question.
	 * @return a question.
	 */
	public Question getQuestion() {
		// uma forma de pegar uma quest�o aleat�ria
		Collections.shuffle(questions);
		Question question = questions.get(0);
		questions.remove(question);
		return question;
	}

	/**
	 * Returns a list of questions.
	 * 
	 * @return A list of questions.
	 */
	@SuppressWarnings("unchecked")
	private ArrayList<Question> getQuestions() {
		XStream xstream = new XStream();
		ArrayList<Question> questions = new ArrayList<Question>();
		try {
			FileReader file = new FileReader(
					"src/quiz/questionGenerator/questions.xml");
			questions = (ArrayList) xstream.fromXML(new BufferedReader(file));
			file.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return questions;
	}

	public ArrayList<Question> returnQuestions() {
		return this.questions;
	}
	
	public QuestionGenerator clonar(){
		try {
			return (QuestionGenerator) clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
