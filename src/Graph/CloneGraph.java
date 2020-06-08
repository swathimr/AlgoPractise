package Graph;

import java.util.*;

/**
 * Same as BFS graph
 * time and space O(n)
 */
public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        Queue<Node> queue = new LinkedList<>();
        Map<Node,Node> visited = new HashMap<>();
        queue.add(node);
        visited.put(node, new Node(node.val, new ArrayList<>()));
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            for(Node neigh : n.neighbors) {
                if(!visited.containsKey(neigh)) {
                    visited.put(neigh, new Node(neigh.val, new ArrayList<>()));
                    queue.add(neigh);
                }
                visited.get(n).neighbors.add(visited.get(neigh));
            }

        }
        return visited.get(node);
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
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
}
