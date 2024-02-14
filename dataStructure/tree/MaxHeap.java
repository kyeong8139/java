package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxHeap{
	public int[] heap = new int[10];
	private int lastIdx = 0;
	
	public void add(int e) {
		if (isFull()) {
			return;
		}
		
		heap[++lastIdx] = e;
		
		int curIdx = lastIdx;
		while (true) {
			int parentIdx = curIdx / 2;
			if (parentIdx == 0 || heap[curIdx] <= heap[parentIdx]) {
				break;
			}
			
			swap(curIdx, parentIdx);
			curIdx = parentIdx;
		}
	}
	
	/**
	 * 힙에서는 루트 노드의 원소만을 삭제할 수 있음
	 * @return
	 */
	public int remove() {
		int data = heap[1];
		
		heap[1] = heap[lastIdx];
		lastIdx--;
		
		int curIdx = 1;
		while (true) {
			int leftIdx = curIdx * 2;
			int rightIdx = curIdx * 2 + 1;
			
			if (leftIdx > lastIdx) {
				break;
			} else if (leftIdx == lastIdx) {
				if (heap[leftIdx] > heap[lastIdx]) {
					swap(leftIdx, lastIdx);
				}
				break;
			}
			
			int maxIdx = heap[leftIdx] >= heap[rightIdx] ? leftIdx : rightIdx;
			swap(curIdx, maxIdx);
			
			curIdx = maxIdx;
		}
		
		return data;
	}
	
	private void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	public void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		
		int height = 1;
		int cnt = 1;
		while(!queue.isEmpty()) {
			
			if (cnt == 0) {
				height++;
				cnt = queue.size();
				System.out.println();
			}
			
			cnt--;
			int cur = queue.poll();
			
			System.out.print(heap[cur] + " ");

			// 왼쪽 자식 노드
			if (cur * 2 <= lastIdx) {
				queue.offer(cur * 2);
			}

			// 오른쪽 자식 노드
			if (cur * 2 + 1 <= lastIdx) {
				queue.offer(cur * 2 + 1);
			}
		}
		System.out.println();
	}
	
	public boolean isFull() {
		return lastIdx == heap.length - 1;
	}
}
