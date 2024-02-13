package queue;

public class LinkedQueueTest {
	public static void main(String[] args) {
		LinkedQueue<Integer> queue = new LinkedQueue<>();
		
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		
		System.out.println("size: " + queue.size);
		System.out.println(queue.peek());
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
		System.out.println(queue.isEmpty());
		
	}
}
