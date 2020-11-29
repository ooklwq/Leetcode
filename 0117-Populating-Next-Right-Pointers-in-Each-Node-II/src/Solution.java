class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(h)
    public Node connect(Node root) {
        if (root == null) return null;
        Node next = root.next;
        while (next != null){
            if (next.left != null){
                next = next.left;
                break;
            }
            if (next.right != null){
                next = next.right;
                break;
            }
            next = next.next;
        }
        if (root.right != null){
            root.right.next = next;
        }
        if (root.left != null){
            root.left.next = root.right != null ? root.right : next;
        }
        connect(root.left);
        connect(root.right);
//        connect(root.left);
        return root;
    }
}
