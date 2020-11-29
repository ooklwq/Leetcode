class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public Node connect(Node root) {
        if(root == null) return null;
        Node levelStart = root;
        Node cur = null;
        while (levelStart.left != null && levelStart.right != null){
            cur = levelStart;
            while (cur != null) {
                cur.left.next = cur.right;
                cur.right.next = cur.next == null ? null : cur.next.left;
                cur = cur.next;
            }
            levelStart = levelStart.left;
        }
        return root;
    }
}