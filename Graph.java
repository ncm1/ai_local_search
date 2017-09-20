import java.util.ArrayList;
import java.util.List;

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
		list[s].AdjacencyList.add(new Edge(s,d,w));
	}

  public int findDistance(TreeNode root, int goalVertex)
  {
   if(root.getChildren() == null)
     return -1;

   int distance = -1;

   int rootVert = root.getVertex();
   List<TreeNode> childrenList = root.getChildren();
   int numOfChildren = childrenList.size();

   if(rootVert == goalVertex)
   {
     return distance + 1;
   }

   TreeNode currNode;
   for(int i = 0; i < numOfChildren; i++){
     currNode = childrenList.get(i);
     if( (distance = findDistance(currNode, goalVertex)) >= 0)
       return distance + 1;
   }
   return distance;
  }

	public int[] bfs(int s)
  {
    //2D Auxilary matrix visited for keeping track of whether a vertex has been
    //visited or not
		int visited[] = new int[vertices];
    //Set the source node as visited
		visited[s] = 1;

    //Creating 2 queues for keeping
		ArrayList<Integer>  queue      = new ArrayList<Integer>();
    ArrayList<TreeNode> nodeQueue = new ArrayList<TreeNode>();

    TreeNode root = new TreeNode(s);
    TreeNode currNode = null;
    TreeNode newNode  = null;

    queue.add(s);
    nodeQueue.add(root);

		while(!queue.isEmpty())
		{
			int next = queue.remove(0);
      currNode = nodeQueue.remove(0);
      //System.out.println("visited node: " + next);
			for(int i = 0; i < list[next].AdjacencyList.size(); i++)
			{
				Edge e1 = list[next].AdjacencyList.get(i);
				if(visited[e1.destination] != 1)
				{
          //Create a new TreeNode that has not been visited
          newNode = new TreeNode(e1.destination);
          //Set the new node as being visited and place it in the queue
					visited[e1.destination] = 1;
          //Adding new node to the queue as well as the TreeNode
					queue.add(e1.destination);
          nodeQueue.add(newNode);
          //Add the new node as the dequed nodes child
          currNode.addChild(newNode);

          //System.out.println("Added node " + e1.destination + " to node " + currNode.getVertex());
				}
			}
		}

    int vertexHasBeenVisited;
    int numberOfMoves;

    List<TreeNode> children = root.getChildren();

    //For loop goes through the visited array and replaces the vertices that
    //have been visited with the number of moves it took to get there
    for(int j = 1; j < vertices; j++)
    {
      vertexHasBeenVisited = visited[j];
      if(vertexHasBeenVisited == 1)
      {
        //Find the number of moves to get to that vertex
        numberOfMoves = findDistance(root, j);
        //Set the value in the visited array as the number of moves
        visited[j] = numberOfMoves;
      }
    }//end for
    return visited;
  }
}
