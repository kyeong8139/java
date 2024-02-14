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
	 * 현재 높이를 확인하며 bfs
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
				System.out.println("\n높이가 " + height + "인 노드의 갯수는 " + cnt + "개입니다.");
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
	public void preorderTraversal(int idx) {
		if (idx == 0 || idx > lastIdx) {
			return;
		}
		
		System.out.print(nodes[idx] + " ");
		
		if (idx * 2 <= lastIdx) {
			preorderTraversal(idx * 2);
		}
		
		if (idx * 2 + 1<= lastIdx) {
			preorderTraversal(idx * 2 + 1);
		}
	}
	
	/**
	 * 중위 순회
	 */
	public void inorderTraversal(int idx) {
		if (idx == 0 || idx > lastIdx) {
			return;
		}
		
		if (idx * 2 <= lastIdx) {
			inorderTraversal(idx * 2);
		}
		
		System.out.print(nodes[idx] + " ");
		
		if (idx * 2 + 1<= lastIdx) {
			inorderTraversal(idx * 2 + 1);
		}
	}
	
	/**
	 * 후위 순회
	 */
	public void postorderTraversal(int idx) {
		if (idx == 0 || idx > lastIdx) {
			return;
		}
		
		if (idx * 2 <= lastIdx) {
			postorderTraversal(idx * 2);
		}
		
		if (idx * 2 + 1<= lastIdx) {
			postorderTraversal(idx * 2 + 1);
		}
		
		System.out.print(nodes[idx] + " ");
	}
}
