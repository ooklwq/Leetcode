class Solution2 {

    class MyTreeNode{
        int val;
        int count;//以该节点为根节点的子树的所有节点数
        MyTreeNode left;
        MyTreeNode right;
        MyTreeNode(){}
        MyTreeNode(int val){
            this.val = val;
            this.count = 1;
        }
        MyTreeNode(int val, MyTreeNode left, MyTreeNode right){
            this.val = val;
            this.count = 1;
            this.left = left;
            this.right = right;
        }
    }

    private MyTreeNode buildMyTree(TreeNode root){
        if (root == null) return null;
        MyTreeNode myTreeNode = new MyTreeNode(root.val);
        myTreeNode.left = buildMyTree(root.left);
        myTreeNode.right = buildMyTree(root.right);
        if (myTreeNode.left != null) {
            myTreeNode.count += myTreeNode.left.count;
        }
        if (myTreeNode.right != null){
            myTreeNode.count += myTreeNode.right.count;
        }
        return myTreeNode;
    }

    public int kthSmallest(TreeNode root, int k) {
        MyTreeNode node = buildMyTree(root);
        return helper(node, k);
    }

    private int helper(MyTreeNode node, int k){
        if (node.left != null){
            int count = node.left.count;
            if (k <= count){
                return helper(node.left, k);
            }else if (k > count+1){
                return helper(node.right, k-count-1);
            }else return node.val;
        }else {
            if (k == 1) return node.val;
            return helper(node.right, k-1);
        }
    }

}