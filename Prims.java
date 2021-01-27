import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.BiFunction;
import java.util.function.Function;


public class Prims {
    static class Edge {
    	Vertex source;
    	Vertex destination;
        int weight;

        public Edge(Vertex source, Vertex destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    
    static class Vertex{
    	int val;
    	
    	PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(u->u.weight));
    	
    	public Vertex(int val){
    		this.val = val;
    	}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + val;
			return result;
		}

		@Override
		public String toString() {
			return "Vertex [val=" + val + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Vertex other = (Vertex) obj;
			if (val != other.val)
				return false;
			return true;
		}
    	
    	
    }

    static class Graph {
        int vertices;
        ArrayList<Edge> allEdges = new ArrayList<>();
        ArrayList<Vertex> allVertices = new ArrayList<>();


        Graph(int vertices) {
            this.vertices = vertices;
        }
        
        Function<ArrayList<Vertex>, BiFunction< Vertex,Edge, Boolean>> function = u->(v,w)-> {
        	if(u.contains(v)){
            	u.get(u.indexOf(v)).edges.add(w);
            }else{
            	v.edges.add(w);
            	u.add(v);
            }
        	return true;
        };

        public void addEgde(int source, int destination, int weight) {
           
            //Added for Prims
            Vertex vertexSource = new Vertex(source);
            if(allVertices.contains(vertexSource)){
            	vertexSource = allVertices.get(allVertices.indexOf(vertexSource));
            }
            
            Vertex vertexDest = new Vertex(destination);
            if(allVertices.contains(vertexDest)){
            	vertexDest = allVertices.get(allVertices.indexOf(vertexDest));
            }
            Edge edge = new Edge(vertexSource, vertexDest, weight);

            function.apply(allVertices).apply(vertexSource, edge);
           // function.apply(allVertices).apply(vertexDest, edge);
            
            System.out.println(allVertices);
        }
        
        public void kruskalMST(){
         /*   PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(o -> o.weight));

            //add all the edges to priority queue, //sort the edges on weights
            for (int i = 0; i <allEdges.size() ; i++) {
                pq.add(allEdges.get(i));
            }

            //create a parent []
            int [] parent = new int[vertices];

            //makeset
            makeSet(parent);

            ArrayList<Edge> mst = new ArrayList<>();

            //process vertices - 1 edges
            int index = 0;
            while(index<vertices-1){
                Edge edge = pq.remove();
                //check if adding this edge creates a cycle
                int x_set = find(parent, edge.source);
                int y_set = find(parent, edge.destination);

                if(x_set==y_set){
                    //ignore, will create cycle
                }else {
                    //add it to our final result
                    mst.add(edge);
                    index++;
                    union(parent,x_set,y_set);
                }
            }*/
        	List<Vertex> visited = new ArrayList<>();
        	
        	Vertex initial = allVertices.get(0);
        	
        	//visited.add(initial);
            ArrayList<Edge> mst = new ArrayList<>();
            LinkedList<Vertex> temp = new LinkedList<>();
            temp.offer(initial);
            while(!temp.isEmpty()){
            	Vertex v = temp.poll();
            	if(!visited.contains(v)){
            		visited.add(v);
            	}
            	if(!v.edges.isEmpty()){
	            	Edge e= v.edges.remove();
	            	mst.add(e);
	            	temp.add(e.destination);
	            	//visited.add(e.destination);
            	}
	           
            }
        	System.out.println(visited);
            //print MST
            System.out.println("Minimum Spanning Tree: ");
           printGraph(mst);
        }

        public void makeSet(int [] parent){
            //Make set- creating a new element with a parent pointer to itself.
            for (int i = 0; i <vertices ; i++) {
                parent[i] = i;
            }
        }

        public int find(int [] parent, int vertex){
            //chain of parent pointers from x upwards through the tree
            // until an element is reached whose parent is itself
            if(parent[vertex]!=vertex)
                return find(parent, parent[vertex]);;
            return vertex;
        }

        public void union(int [] parent, int x, int y){
            int x_set_parent = find(parent, x);
            int y_set_parent = find(parent, y);
            //make x as parent of y
            parent[y_set_parent] = x_set_parent;
        }

        public void printGraph(ArrayList<Edge> edgeList){
            for (int i = 0; i <edgeList.size() ; i++) {
                Edge edge = edgeList.get(i);
                System.out.println("Edge-" + i + " source: " + edge.source +
                        " destination: " + edge.destination +
                        " weight: " + edge.weight);
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
            graph.kruskalMST();
    }
}