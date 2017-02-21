
import edu.princeton.cs.algs4.*;

public class NonRecursiveDfs {	
	private boolean connected;	
	
	public NonRecursiveDfs(Graph graph) {		
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] marked = new boolean[graph.V()];
				
		stack.push(0);
		marked[0] = true;
		int count = 1;
		
		while (!stack.isEmpty()) {
			int v = stack.pop();			
			for (int w : graph.adj(v)) {
				if (!marked[w]) {
					count++;
					stack.push(w);
					marked[w] = true;					
				}
			}
		}
		connected = (graph.V() == count);
	}
		
	
	public boolean connected() {
		return connected;
	}
	
	public static void main(String[] args) {
		In in = new In(args[0]);
		Graph graph = new Graph(in);
		NonRecursiveDfs nrDfs = new NonRecursiveDfs(graph);
		if (nrDfs.connected())
			StdOut.println("Graph is connected");
		else
			StdOut.println("Graph is not connected");		
	}
}
