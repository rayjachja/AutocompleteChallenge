/* Driver to run program main has the passage + fragments
 * prints for training and inputs are included as well
 * Used for testing the functionality of the autocomplete provider.
 */
import java.util.List;

public class Driver {
	
	public static void main(String[] args) {
		AutocompleteProvider auto = new AutocompleteProvider();
		String training_passage = "The third thing that I need to tell you is that this thing does not think thoroughly.";
		String frag1 = "thi";
		String frag2 = "nee";
		String frag3 = "th";
		String frag4 = "water";
		
		auto.train(training_passage);
		List<Candidate> can1 = auto.getWords(frag1);
		List<Candidate> can2 = auto.getWords(frag2);
		List<Candidate> can3 = auto.getWords(frag3);
		List<Candidate> can4 = auto.getWords(frag4);
		
		print_train(training_passage);
		print_can_list(frag1, can1);
		print_can_list(frag2, can2);
		print_can_list(frag3, can3);
		print_can_list(frag4, can4);
		
		auto.train(training_passage);
		can1 = auto.getWords(frag1);
		can2 = auto.getWords(frag2);
		can3 = auto.getWords(frag3);
		can4 = auto.getWords(frag4);
		
		print_train(training_passage);
		print_can_list(frag1, can1);
		print_can_list(frag2, can2);
		print_can_list(frag3, can3);
		print_can_list(frag4, can4);
	}
	
	public static void print_train(String train) {
		System.out.println("Train: " + train);
		
	}
	public static void print_can_list(String frag, List<Candidate> can) {
		System.out.print("Input: " + frag + " --> " );
		if (can != null) {
			for(int i = 0; i < can.size() - 1; i++) {
				System.out.print('"' + can.get(i).getWord() + '"' + " (" + can.get(i).getConfidence() +"), ");
			}
			int i = can.size() - 1;
			System.out.print('"' + can.get(i).getWord() + '"' + " (" + can.get(i).getConfidence() +")");
			System.out.println("");
		}
	}

}
