import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {
    // Store the adjacency list of the graph where each node maps to a list of its neighbors
    private Map<Integer, List<Integer>> adjacencyList;

    // Constructor to initialize the graph
    public GraphTraversal() {
        this.adjacencyList = new HashMap<>();  // Initialize the adjacency list as an empty map
    }

    // Method to print the graph
    public void printGraph() {
    	System.out.print("\nGraph: \n");
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (Integer neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
        System.out.print("\n");
    }
    
    // Method to add an edge between two nodes in the graph
    public void addEdge(int src, int dest) {
        // Add the destination node to the source node's adjacency list
        if (!adjacencyList.containsKey(src)) {
            adjacencyList.put(src, new ArrayList<>());
        }
        adjacencyList.get(src).add(dest);

        // Add the source node to the destination node's adjacency list (since it's an undirected graph)
        if (!adjacencyList.containsKey(dest)) {
            adjacencyList.put(dest, new ArrayList<>());
        }
        adjacencyList.get(dest).add(src);
    }

    // Method to perform Depth-First Search starting from a given node
    public void dfs(int startNode) {
        // Create a set to keep track of visited nodes to avoid revisiting
        Set<Integer> visited = new HashSet<>();
        // Print the DFS traversal header
        System.out.println("DFS Traversal:");
        // Start DFS from the given startNode
        // We will use an explicit stack for DFS (instead of recursion) for clarity
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);  // Push the startNode to the stack

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();  // Pop the top node from the stack
            // If the current node has not been visited, we visit it
            if (!visited.contains(currentNode)) {
                System.out.print(currentNode + " ");  // Print the current node
                visited.add(currentNode);  // Mark the current node as visited

                // Now, push all unvisited neighbors of the current node to the stack
                // We traverse neighbors in reverse order to maintain a consistent order of traversal
                List<Integer> neighbors = adjacencyList.getOrDefault(currentNode, new ArrayList<>());
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int neighbor = neighbors.get(i);
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);  // Push unvisited neighbors onto the stack
                    }
                }
            }
        }
        // Print a new line after the DFS traversal is complete
        System.out.println();
    }

    // Method to perform Breadth-First Search starting from a given node
    public void bfs(int startNode) {
        // Create a set to keep track of visited nodes to avoid revisiting
        Set<Integer> visited = new HashSet<>();
        // Create a queue for BFS (FIFO structure)
        Queue<Integer> queue = new LinkedList<>();
        // Start BFS by enqueuing the startNode and marking it as visited
        queue.offer(startNode);
        visited.add(startNode);

        // Print the BFS traversal header
        System.out.println("BFS Traversal:");
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();  // Dequeue the front node from the queue
            // If the node is not yet visited, we print it
            System.out.print(currentNode + " ");  // Print the current node

            // Add all unvisited neighbors of the current node to the queue
            List<Integer> neighbors = adjacencyList.getOrDefault(currentNode, new ArrayList<>());
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);  // Mark this neighbor as visited
                    queue.offer(neighbor);  // Enqueue the neighbor for future processing
                }
            }
        }
        // Print a new line after the BFS traversal is complete
        System.out.println();
    }

   
}
