/* Comparator for Candidate, comparator is reversed so that the higher confidence is first
 * If equal then compare word first.
 */

import java.util.Comparator;

public class Sort_by_Confidence implements Comparator<Candidate>{

	public int compare(Candidate arg0, Candidate arg1) {
		if (arg1.getConfidence() - arg0.getConfidence() == 0) {
			return arg0.getWord().compareTo(arg1.getWord());
		}
		return arg1.getConfidence() - arg0.getConfidence();
	}

}
