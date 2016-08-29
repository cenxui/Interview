import java.awt.Checkbox;
import java.util.ArrayList;
import java.util.List;

public class Tree {
	private Tree left;
	private Tree right;
	private int val;

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.val = 1;
		tree.left = new Tree();
		tree.left.val = 2;
		tree.right = new Tree();
		tree.right.val = 1;
		tree.left.left = new Tree();
		tree.left.left.val = 2;
		tree.right.right = new Tree();
		tree.right.right.val = 1;

		System.out.println(tree.getPath(3));

		// Tree another = new Tree();
		// another.val = 10;
		// another.left = new Tree();
		// another.left.val = 11;
		// another.right = new Tree();
		// another.right.val = 12;
		// another.left.left = new Tree();
		// another.left.left.val = 7;
		// another.right.right = new Tree();
		// another.right.right.val = 8;
		// // System.out.println(tree.equals(another));
		// System.out.println(tree);
		// tree.revert();
		// System.out.println(tree);
		// System.out.println(tree.isSymetric());

	}

	public Tree() {
		this(null, null);
	}

	public Tree(Tree left, Tree right) {
		this.left = left;
		this.right = right;
	}

	public boolean isSymetric() {
		return isSymetric(this.left, this.right);
	}
	
	private boolean isSymetric(Tree left, Tree right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		if (left.val != right.val)
			return false;
		return isSymetric(left.left, right.right) && isSymetric(left.right, right.left);
	}

	public void revert() {
		revertTree(this);
	}

	private void revertTree(Tree tree) {
		if (tree == null)
			return;

		Tree temp = tree.left;
		tree.left = tree.right;
		tree.right = temp;

		revertTree(tree.left);
		revertTree(tree.right);
	}
	
	/**
	 * given sum that find all path lead to the sum
	 * @param sum the number of tree value sum 
	 * @return result the path lead to the sum
	 */
	
	public List<String> getPath(int sum) {
		List<String> result = new ArrayList<>();
		
		checkPath(result, new StringBuilder(), this, sum);
		
		return result;
	}
	
	private void checkPath(List<String> result, StringBuilder path, Tree treeNode, int sum) {
		if (treeNode == null) {
			return;
		}
		
		sum = sum - treeNode.val;
		if (sum < 0) {
			return;
		}
		path.append("->").append(treeNode.val);
		if (sum == 0) {
			result.add(path.toString());
			return;
		}
		checkPath(result, new StringBuilder(path), treeNode.left, sum);	
		checkPath(result, path, treeNode.right, sum);		
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(" value : ").append(this.val);

		if (this.left != null) {
			stringBuilder.append(this.left);
		}

		if (this.right != null) {
			stringBuilder.append(this.right);
		}

		return stringBuilder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof Tree) {
			if (this.val != ((Tree) obj).val) {
				return false;
			}

			if (this.left == null && this.right == null) {
				return ((Tree) obj).left == null && ((Tree) obj).right == null;
			}

			if (this.left != null && this.right == null) {
				return ((Tree) obj).right == null && this.left.equals(((Tree) obj).left);
			}

			if (this.left == null && this.right != null) {
				return ((Tree) obj).left == null && this.right.equals(((Tree) obj).right);
			}

			return this.left.equals(((Tree) obj).left) && this.right.equals(((Tree) obj).right);

		}
		return false;
	}
}
