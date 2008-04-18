package BIT;


public class Arbiter {
	private Verdict verdict;
	private Verdict partialVerdict;
	
	public Verdict getVerdict(){
		return verdict;
	}
	
	public void setVerdict(boolean v, int i){
		if (v = true)
			partialVerdict = Verdict.pass;
		else
			if (i == 0)
				partialVerdict = Verdict.fail;
			else if (i == 1)
				partialVerdict = Verdict.inconclusive;
			else partialVerdict = Verdict.error;
				
	}
	
	public void definesPartialVerdict(){
		verdict = partialVerdict;
	}
}
