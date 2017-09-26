import java.util.*;

public class EvalAndTime{

	int eval;
	long time;

	public static TimeEvalOutput sortEvalAndTimeByTime(LinkedList<EvalAndTime>[] arr ){
		EvalAndTime temp;
		Comparator comp = new EvalAndTimeComparator(); 
		PriorityQueue<EvalAndTime> q = new PriorityQueue<EvalAndTime>(50, comp);
		for (int i = 0; i < arr.length; ++i){
			for ( int j = 0; j < arr[i].size(); ++j){
				temp = arr[i].get(j);
				q.add(temp);
			}
		}
		// all objects are sorted according to their time objects
		int tempSize = q.size();
		TimeEvalOutput teo = new TimeEvalOutput();
		teo.evalLL = new LinkedList<Integer>();
		teo.timeLL = new LinkedList<Long>();
		while(q.size() > 0 ){
			//System.out.println(q.size());
			temp = checkIfDuplicate(q);
			teo.timeLL.add(temp.time);
			teo.evalLL.add(temp.eval);
		}
		
		return teo;
	}
	public static EvalAndTime checkIfDuplicate(PriorityQueue<EvalAndTime> q){
		EvalAndTime t1 = q.poll();
		EvalAndTime t2 = q.poll();
		if (t2 == null){
			return t1;
		}
		int sumEval = t1.eval;
		int numEval = 1;
		while(t1.time == t2.time){
			++numEval;
			sumEval += t2.eval;
			t2 = q.poll();
			if (t2 == null){
				t1.eval = sumEval / numEval; //average
				return t1;
			}
		} // modify t1, destroying t2.
		t1.eval = sumEval / numEval; //average 
		q.add(t2);
		return t1;
	}

}