import java.util.HashMap;
import java.util.Map;

public class Dijkstras {
	
	public static void main(String[] args) {
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D"); 
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		 
		nodeA.addDestination(nodeB, 10);
		nodeA.addDestination(nodeC, 15);
		 
		nodeB.addDestination(nodeD, 17);
		nodeB.addDestination(nodeF, 15);
		 
		nodeC.addDestination(nodeE, 10);
		 
		nodeD.addDestination(nodeE, 2);
		nodeD.addDestination(nodeF, 1);
		 
		nodeF.addDestination(nodeE, 5);
		 
		Graph graph = new Graph();
		 
		graph.startNode = nodeA;
		performDijkstra(graph);
		printDijkstra(graph);
		
	}
	
	public static void printDijkstra(Graph g) {
		Node startNode = g.startNode;
		startNode.distance =0;
		printRecursive(startNode);
	}
	public static void performDijkstra(Graph g) {
		Node startNode = g.startNode;
		startNode.distance =0;
		performRecursive(startNode);
	}
	
	public static void printRecursive(Node parent) {
		if(parent.adjacentNodes.isEmpty()) {
			return;
		}
		for(Map.Entry<Node, Integer> entry: parent.adjacentNodes.entrySet()) {
			Node n = entry.getKey();
			System.out.println("Node "+n);
			printRecursive(n);
		}
	}
	
	public static void performRecursive(Node parent) {
		if(parent.adjacentNodes.isEmpty()) {
			return;
		}
		for(Map.Entry<Node, Integer> entry: parent.adjacentNodes.entrySet()) {
			Node n = entry.getKey();
			int distance = entry.getValue();
			if(n.distance > parent.distance+distance) {
				n.predecessor = parent;
				n.distance = parent.distance+distance;
			}
			performRecursive(n);
		}
	}
	
	public static class Graph{
		public Node startNode =null;
	}
	
	public static class Node{
		
		public Node(String name) {
			super();
			this.name = name;
		}

		@Override
		public String toString() {
			return "Node [name=" + name + ", predecessor=" + predecessor + ", distance=" + distance + "]";
		}

		Map<Node, Integer> adjacentNodes = new HashMap<>();
		
		private String name;
		
		
		Node predecessor =null;
		
		int distance = Integer.MAX_VALUE;
		
		public void addDestination(Node destination, int distance) {
	        adjacentNodes.put(destination, distance);
	    }

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		
		
	}
	
	
	
	

}
