package BIT;

public class QuizTester{
	static TestableQuiz server;
	static Arbiter arbiter;


	public Verdict executeTest(TestableQuiz s) {
		arbiter = new Arbiter();
		server = s;
		testCase1();
		testCase2();
		return arbiter.getVerdict();

	}

	public static void testCase1(){
		try {
			server.setToReady();
			System.out.println(server.getStateQuiz());
			arbiter.setVerdict(server.isInReady(),0);
			server.configure(5);
			server.start();
			System.out.println(server.getStateQuiz());
			server.answerQuestion(1);
			System.out.println(server.getStateQuiz());
			server.answerQuestion(2);
			System.out.println(server.getStateQuiz());
			server.pause(1);
			System.out.println(server.getStateQuiz());
			server.pause(0);
			System.out.println(server.getStateQuiz());
			server.answerQuestion(3);
			System.out.println(server.getStateQuiz());
			server.help(1);
			System.out.println(server.getStateQuiz());
			server.help(0);
			System.out.println(server.getStateQuiz());
			server.answerQuestion(4);
			System.out.println(server.getStateQuiz());
			server.answerQuestion(5);
//			server.abort();
			System.out.println(server.getStateQuiz());

//			server.setToHelping();
//			arbiter.setVerdict(server.isInHelping(),0);
//			server.setToRunning();
//			arbiter.setVerdict(server.isInRunning(),0);
//			server.pause(1);
//			arbiter.setVerdict(server.isInRunning(),0);
//			server.pause(0);
//			arbiter.setVerdict(server.isInRunning(),0);
//			server.setToEnding();
//			arbiter.setVerdict(server.isInEnding(),0);
		} catch (Exception e) {
			arbiter.setVerdict(false, 1);
		} catch (Error e) {
			arbiter.setVerdict(false, 2);
		}  
        
        arbiter.definesPartialVerdict();
	}

	public static void testCase2(){
		//code		
		arbiter.definesPartialVerdict();
	}

}
