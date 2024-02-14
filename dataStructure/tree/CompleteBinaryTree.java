package tree;

import java.util.ArrayDeque;
import java.util.Queue;

// 완전이진 트리 - 배열 구현
public class CompleteBinaryTree<T> {

	private Object[] nodes;
	private int size;
	private int lastIdx; // 마지막으로 저장된 노드의 인덱스

	public CompleteBinaryTree() {
		size = 5;
		nodes = new Object[size + 1]; // 0인덱스 사용하지 않음
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
	 * breadth 단위로 height 조절
	 */
	public void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		
		int height = -1;
		int cnt = 0;
		while(!queue.isEmpty()) {
			
			if (cnt == 0) {
				height++;
				cnt = queue.size();
			}
			
			cnt--;
			int cur = queue.poll();
			
			System.out.print(nodes[cur] + " ");

			// 왼쪽 자식 노드
			if (cur * 2 <= lastIdx) {
				queue.offer(cur * 2);
			}

			// 오른쪽 자식 노드
			if (cur * 2 + 1 <= lastIdx) {
				queue.offer(cur * 2 + 1);
			}
		}
	}
	
	/**
	 * 전위 순회
	 */
	public void dfsByPreorder(int idx) {
		if (idx == 0 || idx > lastIdx) {
			return;
		}
		
		System.out.print(nodes[idx] + " ");
		
		if (idx * 2 <= lastIdx) {
			dfsByPreorder(idx * 2);
		}
		
		if (idx * 2 + 1<= lastIdx) {
			dfsByPreorder(idx * 2 + 1);
		}
	}
	
	/**
	 * 중위 순회
	 */
	public void dfsByInorder(int idx) {
		if (idx == 0 || idx > lastIdx) {
			return;
		}
		
		if (idx * 2 <= lastIdx) {
			dfsByInorder(idx * 2);
		}
		
		System.out.print(nodes[idx] + " ");
		
		if (idx * 2 + 1<= lastIdx) {
			dfsByInorder(idx * 2 + 1);
		}
	}
	
	/**
	 * 후위 순회
	 */
	public void dfsByPostorder(int idx) {
		if (idx == 0 || idx > lastIdx) {
			return;
		}
		
		if (idx * 2 <= lastIdx) {
			dfsByPostorder(idx * 2);
		}
		
		if (idx * 2 + 1<= lastIdx) {
			dfsByPostorder(idx * 2 + 1);
		}
		
		System.out.print(nodes[idx] + " ");
	}
}
