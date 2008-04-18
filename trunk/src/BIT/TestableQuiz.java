package BIT;

import quiz.quiz.Quiz;

@SuppressWarnings("serial")
public class TestableQuiz extends Quiz {

	//Option one
//	public void setToReady() {
//		setState("ready");
//	}
//
//	public void setToRunning() {
//		setState("running");
//	}
//	
//	public void setToHelping(){
//		setState("helping");
//	}
//	
//	public void setToEnding(){
//		setState("helping");
//	}
//	
//	public boolean isInReady(){		
//		return getState().equals("ready");
//	}
//
//	public boolean isInRunning() {		
//		return getState().equals("running");
//	}
//
//	public boolean isInAccountHelping() {		
//		return getState().equals("helping");
//	}
//	
//	public boolean isInAccountEnding() {		
//		return getState().equals("ending");
//	}
	
	public TestableQuiz(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	//Option two
	public void setToReady() {
	}

	public void setToRunning() {
	}
	
	public void setToHelping(){
	}
	
	public void setToEnding(){
	}
	
	public boolean isInReady(){	
		return true;
	}

	public boolean isInRunning() {
		return true;
	}

	public boolean isInHelping() {
		return true;
	}
	
	public boolean isInEnding() {
		return true;
	}
}
