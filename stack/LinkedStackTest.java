package stack;

public class LinkedStackTest {
	public static void main(String[] args) {
		LinkedStack<Integer> stack = new LinkedStack<>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println("size: " + stack.size);
		System.out.println(stack.peek());
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		System.out.println(stack.isEmpty());
		
	}
}
