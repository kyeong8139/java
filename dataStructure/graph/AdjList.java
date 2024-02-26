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

// 무방향 그래프
public class AdjList {

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", next=" + next + "]";
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		Node[] adjList = new Node[V]; 
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}

		for (Node node : adjList) {
			System.out.println(node.toString());
		}
	}
}
