package src.quiz.questionGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.quiz.util.Question;

import com.thoughtworks.xstream.XStream;

/**
 * This class represents a Question Generator. <br>
 * 
 * @author Camila Maciel, Everton Leandro
 * @since 03/04/2008
 * @version 1.0
 * 
 */
public class QuestionGenerator {

	public List<Question> questions;

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
		// uma forma de pegar uma questão aleatória
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
	private List<Question> getQuestions() {
		XStream xstream = new XStream();
		List<Question> questions = new ArrayList<Question>();
		try {
			FileReader file = new FileReader(
					"src/quiz/questionGenerator/questions.xml");
			questions = (List) xstream.fromXML(new BufferedReader(file));
			file.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return questions;
	}
}
