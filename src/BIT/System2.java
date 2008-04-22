package BIT;

public class System2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestingQuizManager testing =new TestingQuizManager();
		QuizTester tester = new QuizTester();
		TestableQuiz testable = new TestableQuiz("x");
		
		testing.setServer(testable);
		testing.setTester(tester);
		testing.performTest();
		

	}

}
