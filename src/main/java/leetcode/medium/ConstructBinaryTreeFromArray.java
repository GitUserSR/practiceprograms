package leetcode.medium;

public class ConstructBinaryTreeFromArray {

	public static void main(String[] args) {
		ConstructBinaryTreeFromArray cb = new ConstructBinaryTreeFromArray();
		int[] preOrder = {3,9,20,15,7};
		
		TreeNode treeNode = new TreeNode();
		cb.createBinaryTreeFromPreOrderTraversal(preOrder);

	}
	
	void createBinaryTreeFromPreOrderTraversal() {
		
	}
	
	void createBinaryTreeFromPreOrderTraversal(int[] preOrder, int index) {
		TreeNode treeNode = null;
		for(int i: preOrder) { 
			if(treeNode == null) {
				treeNode = new TreeNode(i);
			}else {
				if(treeNode.left == null) {
					treeNode.left = new TreeNode(i);
					createBinaryTreeFromPreOrderTraversal(preOrder, i);
				}
				if(treeNode.right == null) {
					treeNode.right = new TreeNode(i);
					createBinaryTreeFromPreOrderTraversal(preOrder, i);
				}
			}
		}
		System.out.println("treeNode" + treeNode);
	}
	
	 public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
}
