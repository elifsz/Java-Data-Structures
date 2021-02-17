
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void main(String a[]) {
        Node A = new Node("A", null);
        Node B = new Node("B", null);
        Node C = new Node("C", null);
        Node D = new Node("D", null);
        Node E = new Node("E", null);
        Node F = new Node("F", null);
        Node G = new Node("G", null);
        Node H = new Node("H", null);

        A.adjList = new Node[]{B, C};
        B.adjList = new Node[]{A};
        C.adjList = new Node[]{A, D};
        D.adjList = new Node[]{E, F};
        E.adjList = new Node[]{D};
        F.adjList = new Node[]{D, G};
        G.adjList = new Node[]{F};
        H.adjList = new Node[]{};

        System.out.println(Node.shortestPath(B, G));

    }

}

class Node {

    String nodeName;   //attribute to label nodes
    Node[] adjList; //attribute to store adjacent nodes

    public Node(String nodeName, Node[] adjList) {
        this.nodeName = nodeName;
        this.adjList = adjList;
    }

    public static String shortestPath(Node start, Node end) {
        //BFS use queue
        Queue<Node> bfsQueue = new LinkedList<>();
        HashMap<Node, Boolean> visited = new HashMap<>();
        //default boolean -> false
        //default Boolean -> null

        //for parent node
        HashMap<Node, Node> prev = new HashMap<>();
        Node currentNode;
        boolean checkShortestPath = false;
        String path = "";

        bfsQueue.add(start);
        visited.put(start, true);
        while (!bfsQueue.isEmpty()) {
            currentNode = bfsQueue.poll();
            if (currentNode.nodeName.equals(end.nodeName)) {
                checkShortestPath = true;
                break;
            }
            for (int i = 0; i < currentNode.adjList.length; i++) {
                Node adjNode = currentNode.adjList[i];
                if (visited.containsKey(adjNode) != true) {
                    visited.put(adjNode, true);
                    bfsQueue.add(adjNode);
                    prev.put(currentNode, adjNode);
                }
            }
        }//end while

        //return path;
        if (!checkShortestPath) {
            return "The Node " + start.nodeName + " is not reachable from the Node " + end.nodeName;
        } else {
            for (Node node = start; node != null; node = prev.get(node)) {
                if (node.nodeName.equals(end.nodeName)) {
                    path += node.nodeName;
                } else {
                    path += node.nodeName + "->";
                }
            }
        }
        return path;
    }
}
