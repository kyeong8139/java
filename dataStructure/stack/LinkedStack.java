package stack;

public class LinkedStack<E> {
	
	class Node<T> {
		T data;
		Node<T> next;
		
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	Node<E> top = new Node<E>(null, null);
	int size = 0;
	
	public void push(E element) {
		top = new Node<E>(element, top);
		size++;
		return;
	}
	
	public E pop() {
		E data = top.data;
		
		if (!isEmpty()) {
			top = top.next;
			size--;
		}
		return data;
	}
	
	public E peek() {
		return top.data;
	}
	
	public boolean isEmpty() {
		return top.data == null;
	}
	
	public int size() {
		return size;
	}
}
