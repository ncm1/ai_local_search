import java.util.Comparator;

public class PuzzleOppositeComparator implements Comparator<Puzzle>{
	@Override
	public int compare(Puzzle puzzle1, Puzzle puzzle2){
		/*Note: this class has a natural ordering that is inconsistent with equals.
		 * Make sure that both puzzle objects have completed the evaluationFunction beforehand.
	     * 
	     * THIS IMPLEMENTS THE OPPOSITE COMPARISON IN ORDER TO CREATE A MAX HEAP FOR THE PRIORITY QUEUE
		 */
		
		return puzzle2.getEvaluationOutput() - puzzle1.getEvaluationOutput();
	}
}