public class Tree {
	Tree left;
	Tree right;
	int val;

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.val = 10;
		tree.left = new Tree();
		tree.left.val = 11;
		tree.right = new Tree();
		tree.right.val = 12;
		tree.left.left = new Tree();
		tree.left.left.val = 7;
		tree.right.right = new Tree();
		tree.right.right.val = 8;

		Tree another = new Tree();
		another.val = 10;
		another.left = new Tree();
		another.left.val = 11;
		another.right = new Tree();
		another.right.val = 12;
		another.left.left = new Tree();
		another.left.left.val = 7;
		another.right.right = new Tree();
		another.right.right.val = 8;
		// System.out.println(tree.equals(another));
		System.out.println(tree);
		tree.revert();
		System.out.println(tree);
		System.out.println(tree.isSymetric());

	}

	public boolean isSymetric() {
		return isSymetric(this);
	}

	private boolean isSymetric(Tree tree) {
		if (tree.left == null && tree.right == null) {
			return true;
		}

		if (tree.left == null || tree.right == null) {
			return false;
		}

		if (tree.left.val != tree.right.val) {
			return false;
		}

		return isSymetric(tree.left) && isSymetric(tree.right);
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