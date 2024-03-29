package BIT;

import quiz.questionGenerator.QuestionGenerator;

public class QuizTester{
	static TestableQuiz server;
	static Arbiter arbiter;


	public Verdict executeTest(TestableQuiz s) {
		arbiter = new Arbiter();
		server = s;
		
		TestableQuiz clone = (TestableQuiz) s.clonar();
		clone.setQuestionGenerator(new QuestionGenerator());
		testCase1();
		server = clone;
		testCase2();
		System.out.println(server.getState());
		return arbiter.getVerdict();

	}

	public static void testCase1(){
		try {
			server.setToReady();
			arbiter.setVerdict(server.isInReady(),0);
			server.configure(5);
			server.start();
			arbiter.setVerdict(server.isInRunning(),0);
			server.answerQuestion(1);
			arbiter.setVerdict(server.isInRunning(),0);
			server.answerQuestion(2);
			arbiter.setVerdict(server.isInRunning(),0);
			server.pause(1);
			arbiter.setVerdict(server.isInPausing(),0);
			server.pause(0);
			arbiter.setVerdict(server.isInRunning(),0);
			server.answerQuestion(3);
			arbiter.setVerdict(server.isInRunning(),0);
			server.help(1);
			arbiter.setVerdict(server.isInHelping(),0);
			server.help(0);
			arbiter.setVerdict(server.isInRunning(),0);
			server.answerQuestion(4);
			arbiter.setVerdict(server.isInRunning(),0);
			server.answerQuestion(5);
			arbiter.setVerdict(server.isInEnding(),0);

		} catch (Exception e) {
			arbiter.setVerdict(false, 1);
		} catch (Error e) {
			arbiter.setVerdict(false, 2);
		}  
        
        arbiter.definesPartialVerdict();
	}

	public static void testCase2(){
		try{
			server.setToReady();
			arbiter.setVerdict(server.isInReady(),0);
			server.configure(5);
			server.start();
			arbiter.setVerdict(server.isInRunning(),0);
			server.answerQuestion(1);
			arbiter.setVerdict(server.isInRunning(),0);
			server.answerQuestion(2);
			arbiter.setVerdict(server.isInRunning(),0);
			server.abort();
			arbiter.setVerdict(server.isInEnding(),0);
		} catch (Exception e) {
			arbiter.setVerdict(false, 1);
		} catch (Error e) {
			arbiter.setVerdict(false, 2);
		}  

		arbiter.definesPartialVerdict();
	}
	
	public static void testCase3(){
		try{
			server.setToReady();
			arbiter.setVerdict(server.isInReady(),0);
			server.configure(5);
			server.start();
			arbiter.setVerdict(server.isInRunning(),0);
			server.answerQuestion(1);
			arbiter.setVerdict(server.isInRunning(),0);
			server.answerQuestion(2);
			arbiter.setVerdict(server.isInRunning(),0);
			server.abort();
			arbiter.setVerdict(server.isInEnding(),0);
		} catch (Exception e) {
			arbiter.setVerdict(false, 1);
		} catch (Error e) {
			arbiter.setVerdict(false, 2);
		}  

		arbiter.definesPartialVerdict();
	}

}
