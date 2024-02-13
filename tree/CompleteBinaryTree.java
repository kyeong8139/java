package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

// 완전이진 트리 - 배열 구현
public class CompleteBinaryTree<T> {
	
	private Object[] nodes;
	private int size;
	private int lastIdx; // 마지막으로 저장된 노드의 인덱스
	
	public CompleteBinaryTree() {
		size = 5;
		nodes = new Object[size+1]; // 0인덱스 사용하지 않음
	}
	
	public boolean isEmpty() {
		return lastIdx == 0;
	}
	
	public boolean isFull() {
		return lastIdx == size;
	}
	
	// 트리의 사이즈 변경
	private void expandTree() {
		Object[] temp = new Object[size * 2 + 1];
		System.arraycopy(nodes, 1, temp, 1, size);
		
		size *= 2;
		nodes = temp;
	}
	
	public void add(T e) {
		if (isFull()) {
			expandTree();
		}
		nodes[++lastIdx] = e;
	}
	
	/**
	 * 높이와 함께 노드 출력
	 */
	public void bfs() {
		if(isEmpty()) {
			return;
		}
		
		Queue<Integer> queue = new ArrayDeque<>(); // 
		queue.offer(1); // 루트 노트의 인덱스를 넣음
		
		int height = 0;
		while (true) {
			System.out.print("height" + height++ + " : ");
			Queue<Integer> nextQueue = new ArrayDeque<>();
			
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				System.out.print(nodes[cur] + " ");
				
				// 왼쪽 자식 노드
				if (cur * 2 <= lastIdx) {
					nextQueue.offer(cur * 2);
				}
				
				// 오른쪽 자식 노드
				if (cur * 2  + 1 <= lastIdx) {
					nextQueue.offer(cur * 2 + 1);
				}
			}
			
			if (nextQueue.isEmpty()) {
				break;
			}
			
			queue = nextQueue;
			System.out.println();
		}
		
	}
}
