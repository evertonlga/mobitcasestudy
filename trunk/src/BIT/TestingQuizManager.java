package BIT;

import quiz.quizManager.QuizManager;

public class TestingQuizManager extends QuizManager {
	private TestableQuiz server;
	private QuizTester tester;
	private Verdict verdict;
	public void setServer(TestableQuiz s) {
		server = s;
	}
	public void setTester(QuizTester t) {
		tester = t;
	}
	public void performTest() {
		
		if ((server != null) && (tester != null)) {
			verdict = tester.executeTest(server);
			
		}
	}
}