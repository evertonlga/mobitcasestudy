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
			arbiter.setVerdict(server.isInReady(),0);
			server.setToRunning();
			arbiter.setVerdict(server.isInRunning(),0);
			server.pause();
			arbiter.setVerdict(server.isInRunning(),0);
			server.setToHelping();
			arbiter.setVerdict(server.isInHelping(),0);
			server.setToRunning();
			arbiter.setVerdict(server.isInRunning(),0);
			server.setToEnding();
			arbiter.setVerdict(server.isInEnding(),0);
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
