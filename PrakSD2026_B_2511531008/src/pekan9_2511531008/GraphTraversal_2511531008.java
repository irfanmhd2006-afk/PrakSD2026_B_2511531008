package pekan9_2511531008;
import java.util.*;
public class GraphTraversal_2511531008 {

	private Map<String,List<String>> graph_1008 = new HashMap<>();
	// Menambahkan edge (graf tak berarah)

	public void addEdge(String node1_1008, String node2_1008) {
		graph_1008.putIfAbsent(node1_1008, new ArrayList<>());
		graph_1008.putIfAbsent(node2_1008, new ArrayList<>());
		graph_1008.get(node1_1008).add(node2_1008);
		graph_1008.get(node2_1008).add(node1_1008);
		
	}
	//menampilkan graf awal
	public void printgraph_1008() {
		System.out.println("Graf Awal (Adjacency List) :");
		for (String node_1008 : graph_1008.keySet()) {
			System.out.print(node_1008 + " - > ");
			List<String> neighbors_1008 = graph_1008.get(node_1008);
			System.out.println(String.join(", ",neighbors_1008));
		}
	}
	//dfs rekursif
	public void dfs_1008(String start_1008) {
		Set<String> visited_1008 = new HashSet<>();
		System.out.println("Penelusuran DFS:");
		dfsHelper_1008(start_1008,visited_1008);
		System.out.println();
	}
	private void dfsHelper_1008(String current_1008,Set<String> visited_1008) {
		if (visited_1008.contains(current_1008)) return ;
		visited_1008.add(current_1008);
		System.out.print(current_1008 + " ");
		for(String neighbor : graph_1008.getOrDefault(current_1008, new ArrayList<>())) {
			dfsHelper_1008(neighbor,visited_1008);
		}
	}
	//BFS iteratif
	public void bfs_1008(String start_1008) {
		Set<String> visited_1008 = new HashSet<>();
		Queue<String> queue_1008 = new LinkedList<>();
		queue_1008.add(start_1008);
		visited_1008.add(start_1008);
		System.out.println("penelurusan BFS:");
		while(!queue_1008.isEmpty()) {
			String current_1008 = queue_1008.poll();
			System.out.print(current_1008 + " ");
			for(String neighbor : graph_1008.getOrDefault(current_1008, new ArrayList<>()))
			if(!visited_1008.contains(neighbor)) {
				queue_1008.add(neighbor);
				visited_1008.add(neighbor);
			}
		}
		System.out.println();
	}
	// main
	public static void main(String[] args) {
		GraphTraversal_2511531008 graph_1008 = new GraphTraversal_2511531008();
		//contoh graf : A-B, A-C, B-D, B-E
		graph_1008.addEdge("A", "B");
		graph_1008.addEdge("A", "C");
		graph_1008.addEdge("B", "D");
		graph_1008.addEdge("B", "E");
		//cetak graf awal
		System.out.println("graf awal adalah: ");
		graph_1008.printgraph_1008();
		//lakukan penelusuran
		graph_1008.dfs_1008("A");
		graph_1008.bfs_1008("A");
	}

}
