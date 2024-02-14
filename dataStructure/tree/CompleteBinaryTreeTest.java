package tree;

public class CompleteBinaryTreeTest {
	public static void main(String[] args) {
		CompleteBinaryTree<Character> tree = new CompleteBinaryTree();
		for (int i = 0; i < 10; i++) {
			tree.add((char) (65 + i));
		}
		
		tree.bfs();
		System.out.println();
		
		tree.preorderTraversal(1);
		System.out.println();
		
		tree.inorderTraversal(1);
		System.out.println();
		
		tree.postorderTraversal(1);
	}
}
