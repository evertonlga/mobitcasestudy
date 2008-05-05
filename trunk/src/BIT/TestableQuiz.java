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
			
	}
	
	public void setToHelping(){
		
	}
	
	public void setToEnding(){
		
	}
	
	public void setToPausing(){
		
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
	
	public boolean isInPausing() {		
		return getStateQuiz().equals("pausing");
	}
	
	public boolean isInEnding() {		
		return getStateQuiz().equals("ending");
	}
	
	public TestableQuiz(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public TestableQuiz clonar(){
		try {
			return (TestableQuiz) clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
