/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class JULY292026{
    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node){
        if(node == null){
            return null;
        }
        if(visited.containsKey(node)){
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val);
    
        visited.put(node, cloneNode);

        for(Node neighbor : node.neighbors){
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
}

//time complexity: O(N+E)  where N is the number of nodes and E is the number of edges, visiting each node and edge exactly once.
//space complexity: O(N)