import java.util.ArrayList;

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
		list[s].AdjacencyList.add(new Edge(s,d,w));
	}

	public int[] bfs(int s){
		int visited[] = new int[vertices];
		visited[s] = 1;
		ArrayList<Integer> queue = new ArrayList<Integer>();

    queue.add(s);

		while(!queue.isEmpty())
		{
			int next = queue.remove(0);
			System.out.println("Visited node " + next);
			for(int i = 0; i < list[next].AdjacencyList.size(); i++)
			{
				Edge e1 = list[next].AdjacencyList.get(i);
				if(visited[e1.destination] != 1)
				{
					visited[e1.destination] = 1;
					queue.add(e1.destination);
				}
			}
		}
    return visited;
	}

}
