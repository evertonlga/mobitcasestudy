package BIT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import quiz.quiz.Quiz;

@SuppressWarnings("serial")
public class TestableQuiz extends Quiz {
	
	//Option one
	public void setToReady() {
		
	}

	public void setToRunning() {
		Scanner input;
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("resp.txt")));
			setNumberOfQuestions(5);
			int r = Integer.parseInt(in.readLine());	
			initialOptions(r);
		} catch (Exception e) {}			
	}
	
	public void setToHelping(){
		
	}
	
	public void setToEnding(){
		
	}
	
	public boolean isInReady(){		
		return getStateQuiz().equals("ready");
	}

	public boolean isInRunning() {		
		return getStateQuiz().equals("running");
	}

	public boolean isInHelping() {		
		return getStateQuiz().equals("helping");
	}
	
	public boolean isInEnding() {		
		return getStateQuiz().equals("ending");
	}
	
	public TestableQuiz(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	//Option two
//	public void setToReady() {
//	}
//
//	public void setToRunning() {
//	}
//	
//	public void setToHelping(){
//	}
//	
//	public void setToEnding(){
//	}
//	
//	public boolean isInReady(){	
//		return true;
//	}
//
//	public boolean isInRunning() {
//		return true;
//	}
//
//	public boolean isInHelping() {
//		return true;
//	}
//	
//	public boolean isInEnding() {
//		return true;
//	}
}
