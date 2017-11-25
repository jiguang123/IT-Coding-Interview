/**
 * Author: 王俊超
 * Date: 2016-01-07 09:47
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {


    public static void main(String[] args) {
        ListNode head = makeList();
        Solution s = new Solution();

        for (int i = 1; i <= 10; i++) {
            ListNode n = s.FindKthToTail(head, i);
            System.out.println(n == null ? null : n.val);
        }
    }

    public static ListNode makeList() {
        ListNode head = new ListNode(1);
        ListNode next = head;

        for (int i = 2; i <= 9; i++) {
            next.next = new ListNode(i);
            next = next.next;
        }

        return head;
    }

    /**
     *             6
     *          /    \
     *         5      9
     *        / \    / \
     *       3   4  8  10
     *      / \    /    \
     *     1   2  7     11
     * @return
     */
    public static TreeNode makeTree() {
        TreeNode root = new TreeNode(6);

        root.left = new TreeNode(5);
        root.right = new TreeNode(9);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(8);
        root.right.left.left = new TreeNode(7);

        root.right.right = new TreeNode(10);
        root.right.right.right = new TreeNode(11);

        return root;
    }

    public static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + "->");
            printTree(root.right);
        }
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

}
