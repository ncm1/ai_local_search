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
		int visited[] = new int[vertices];
		visited[s] = 1;
		ArrayList<Integer> queue = new ArrayList<Integer>();
    ArrayList<TreeNode> nodeQueue = new ArrayList<TreeNode>();
    int counter = 0;

    TreeNode root = new TreeNode(s);

    queue.add(s);
    nodeQueue.add(root);


    TreeNode currNode = null;
    TreeNode newNode;

    int init = 1;
		while(!queue.isEmpty())
		{
			int next = queue.remove(0);
      currNode = nodeQueue.remove(0);

      /*if(init != 1)
      {
        currNode = new TreeNode(next);
      }*/

			// /System.out.println("Visited node " + next);

			for(int i = 0; i < list[next].AdjacencyList.size(); i++)
			{
				Edge e1 = list[next].AdjacencyList.get(i);
				if(visited[e1.destination] != 1)
				{
          newNode = new TreeNode(e1.destination);
					visited[e1.destination] = 1;

					queue.add(e1.destination);
          nodeQueue.add(newNode);
          currNode.addChild(newNode);
          //System.out.println("Added node  " + e1.destination + " as child of " + next);
          /*if(init == 1)
          {
            newNode = new TreeNode(e1.destination);
            root.addChild(newNode);
            System.out.println("Added " + newNode.getVertex() + " to root " + root.getVertex());
          }
          else
          {
            newNode = new TreeNode(e1.destination);
            currNode.addChild(newNode);
            System.out.println("Added " + newNode.getVertex() + " to currNode " + currNode.getVertex());
            System.out.println("currNode.getChildren.size(): " + currNode.getChildren().size());
          }*/
				}
			}
      init = 0;
		}

    int vertexHasBeenVisited;
    int numberOfMoves;

    List<TreeNode> children = root.getChildren();

    numberOfMoves = findDistance(root, 4);
    System.out.println("Number of moves to 4: " + numberOfMoves);
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
    }

    return visited;
  }
}
