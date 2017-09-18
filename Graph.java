

public class Graph {

  Node list[];
	int vertices;

	Graph(int v){
		vertices = v;
		list = new Node[v];
		for(int i = 0; i < v; i++)
		  list[i] = new Node();
	}

	public void addEdge(int s,int d,int w){
		//Edge e1 = new Edge(s,d,w);
		list[s].AdjacenyList.add(new Edge(s,d,w));
	}

	/*public void bfs(){
		bfs(0);
	}*/

	/*private void bfs(int s){
		boolean visited[]=new boolean[vertices];
		visited[s]=true;
		ArrayList<Integer> queue=new ArrayList<Integer>();
		while(!q.isEmpty())
		{
			int next=queue.remove(0);
			System.out.println("Visited "+next+"node");
			for(int i=0;i<list[next].AdjacencyList.size();i++)
			{
				Edge e1=list[next].AdjacencyList.get(i);
				if(!visited[e1.d])
				{
					visited[e1.d]=true;
					queue.add(e1.d);
				}
			}
		}
	}*/
}
