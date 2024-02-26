package dataStructure.graph;

import java.util.Scanner;

/*
7
8
0 1
0 2
0 5
0 6
4 3
5 3
5 4
6 4
 */

public class EdgeList {
	static class Edge {
		int to;
		int from;

		public Edge(int to, int from) {
			super();
			this.to = to;
			this.from = from;
		}

		@Override
		public String toString() {
			return "Edge [to=" + to + ", from=" + from + "]";
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		Edge[] edgeList = new Edge[E];
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			edgeList[i] = new Edge(from, to);
		}
		
		for (Edge edge : edgeList) {
			System.out.println(edge);
		}
	}
}
