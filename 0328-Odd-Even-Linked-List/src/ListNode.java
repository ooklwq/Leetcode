public class ListNode {

    public int val;
    public ListNode next = null;
    private ListNode cycleNode = null;

    public ListNode(int x) {
        val = x;
    }

    public ListNode (int[] arr, int pos){
        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");
        //尾插法建立单链表
        this.val = arr[0];
        ListNode curNode = this;
        for(int i = 1 ; i < arr.length ; i ++){
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
        if (pos >= 0){//建立环
            cycleNode = this;
            for (int i = 0; i < pos; i++) {
                cycleNode = cycleNode.next;
            }
            curNode.next = cycleNode;
        }
    }

    ListNode findNode(int x){
        ListNode curNode = this;
        while(curNode != null){
            if(curNode.val == x)
                return curNode;
            curNode = curNode.next;
        }
        return null;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("");
        int count = 0;//循环节点出现次数
        ListNode curNode = this;
        while(curNode != null){
            s.append(Integer.toString(curNode.val));
            s.append(" -> ");
            if (curNode == cycleNode){//如果有环，为了避免无限循环，只让环节点出现2次
                count++;
                if (count >=2 ) break;
            }
            curNode = curNode.next;
        }
        s.append("NULL");
        return s.toString();
    }
}