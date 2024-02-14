package tree;

public class MaxHeapTest {
	public static void main(String[] args) {
		MaxHeap heap = new MaxHeap();
		
		System.out.println("====add====");
		heap.add(1);
		heap.add(5);
		heap.add(3);
		heap.add(20);
		heap.add(10);
		heap.add(7);
		heap.bfs();
		
		System.out.println("====remove====");
		heap.remove();
		heap.bfs();
	}
}
