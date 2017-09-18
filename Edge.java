public class Edge {
  int source;
  int destination;
  int legalMove;

  public Edge(int s, int d, int legalMove){
    this.source      = s;
    this.destination = d;
    this.legalMove   = legalMove;
  }

  public int getDestination(){
    return destination;
  }
}
