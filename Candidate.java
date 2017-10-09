/* Candidate class, object is either empty or fill. If it is fill it contains information 
 * on the word and confidence.  The boolean end distinguishes whether or not the Candidate is filled.
 * Data object for storing information on candidate.
 */
public class Candidate{
	/* Constant for types of letters 
	 * Change to add functionality such as ".,-"*/
	public static final Integer MAX_CHAR = 26;
	
	Candidate[] childern;
	int confidence;
	String word;
	boolean end;
	
	public Candidate(String word) {
		if (word == null) {
			return;
		}
		this.word = word;
		confidence = 1;
		end = false;
		this.childern = new Candidate[MAX_CHAR];
	}
	
	public String getWord(){
		return word;
	}
	
	public int getConfidence() {
		return confidence;
	}
}
