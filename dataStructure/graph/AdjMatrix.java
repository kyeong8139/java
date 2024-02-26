package dataStructure.graph;

import java.util.Arrays;
import java.util.Scanner;

public class AdjMatrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		int[][] adjMatrix = new int[V][V];
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			adjMatrix[from][to] = 1;
			adjMatrix[to][from] = 1;
		}
		
		for (int[] adj : adjMatrix) {
			System.out.println(Arrays.toString(adj));
		}
	}
}
