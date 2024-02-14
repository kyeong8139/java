package tree;

public class CompleteBinaryTreeTest {
	public static void main(String[] args) {
		CompleteBinaryTree<Character> tree = new CompleteBinaryTree();
		for (int i = 0; i < 10; i++) {
			tree.add((char) (65 + i));
		}
		
		System.out.println("===bfs===");
		tree.bfs();
		
		System.out.println("\n===PreOrder===");
		tree.dfsByPreorder(1);
		
		System.out.println("\n===InOrder===");
		tree.dfsByInorder(1);
		
		System.out.println("\n===PostOrder===");
		tree.dfsByPostorder(1);
	}
}
