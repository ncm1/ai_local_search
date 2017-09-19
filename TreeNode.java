import java.util.ArrayList;
import java.util.List;

public class TreeNode{
 private int vertex;
 private final List<TreeNode> children = new ArrayList<>();

 public TreeNode(int vertex) {
  //this.parent = parent;
  this.vertex = vertex;
 }

 public int getVertex() {
  return vertex;
 }

 public void addChild(TreeNode child){
   children.add(child);
 }

 public List<TreeNode> getChildren() {
  return children;
 }

 public static int findDistance(TreeNode root, int goalVertex){
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

 //Reference: http://www.geeksforgeeks.org/find-distance-root-given-node-binary-tree/

}
