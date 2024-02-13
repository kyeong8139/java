package queue;

public class LinkedQueue<E> {
	
	class Node<T> {
		T data;
		Node<T> next;
		
		public Node(T data, LinkedQueue<E>.Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	Node<E> head = null;
	Node<E> tail = null;
	int size = 0;
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void offer(E e) {
		if (isEmpty()) {
			head = new Node<E> (e, null);
			tail = head;
			size++;
			return;
		}
		
		tail.next = new Node<E> (e, null);
		tail = tail.next;
		size++;
	}
	
	public E poll() {
		if (isEmpty()) {
			return null;
		}
		
		E data = head.data;
		head = head.next;
		size--;
		
		return data;
	}
	
	public E peek() {
		return isEmpty() ? null : head.data;
	}
	
	public int size() {
		return size;
	}
}
