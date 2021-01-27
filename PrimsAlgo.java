import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class PrimsAlgo {
	static class Edge {
		int source;
		int destination;
		int weight;

		public Edge(int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
	}

	static class Graph {
		int vertices;
		ArrayList<Edge> allEdges = new ArrayList<>();
		Map<Integer, List<Edge>>  vertexMap = new HashMap<>();
		Graph(int vertices) {
			this.vertices = vertices;
		}

		public void addEgde(int source, int destination, int weight) {

			// Added for Prims

			Edge edge = new Edge(source, destination, weight);

			allEdges.add(edge);
			if(vertexMap.get(source)==null) {
				vertexMap.put(source, new ArrayList<Edge>());
			}
			if(vertexMap.get(destination)==null) {
				vertexMap.put(destination, new ArrayList<Edge>());
			}
			vertexMap.get(source).add(edge);
			vertexMap.get(destination).add(edge);
		}

		public void primsMST() {
			Set<Integer> visited = new HashSet<>();
			PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt((o) -> o.weight));

			// visited.add(initial);
			ArrayList<Edge> mst = new ArrayList<>();
			pq.addAll(vertexMap.get(0));
			do {
				Edge e = pq.remove();
				boolean formCircle = true;
				if (!visited.contains(e.source)) {
					visited.add(e.source);
					formCircle = false;
					pq.addAll(vertexMap.get(e.source));
				}
				if (!visited.contains(e.destination)) {
					visited.add(e.destination);
					formCircle = false;
					pq.addAll(vertexMap.get(e.destination));
				}
				if (!formCircle) {
					mst.add(e);
					
				}
				
			} while (!pq.isEmpty());
			System.out.println();
			// print MST
			System.out.println("Minimum Spanning Tree: ");
			printGraph(mst);
		}

		

		public void printGraph(ArrayList<Edge> edgeList) {
			for (int i = 0; i < edgeList.size(); i++) {
				Edge edge = edgeList.get(i);
				System.out.println("Edge-" + i + " source: " + edge.source + " destination: " + edge.destination
						+ " weight: " + edge.weight);
			}
		}
	}

	public static void main(String[] args) {
		int vertices = 6;
		Graph graph = new Graph(vertices);
		graph.addEgde(0, 1, 4);
		graph.addEgde(0, 2, 3);
		graph.addEgde(1, 2, 1);
		graph.addEgde(1, 3, 2);
		graph.addEgde(2, 3, 4);
		graph.addEgde(3, 4, 2);
		graph.addEgde(4, 5, 6);
		graph.primsMST();
	}
}