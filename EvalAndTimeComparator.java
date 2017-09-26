

import java.util.Comparator;

public class EvalAndTimeComparator implements Comparator<EvalAndTime>{
	@Override
	public int compare(EvalAndTime t1, EvalAndTime t2){
		/*Note: this class has a natural ordering that is inconsistent with equals.
		 * Make sure that both puzzle objects have completed the evaluationFunction beforehand.
	     * 
	     * THIS IMPLEMENTS THE OPPOSITE COMPARISON IN ORDER TO CREATE A MAX HEAP FOR THE PRIORITY QUEUE
		 */
		
		return (int)(t1.time - t2.time);
	}
}