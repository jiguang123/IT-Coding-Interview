import java.util.HashSet;
import java.util.Set;

/**
 * ��д���룬�Ƴ�δ���������е��ظ���㡣
 * ����
 * �����������ʱ������������ô�����
 * Author: ������
 * Date: 2015-10-16
 * Time: 16:04
 * Declaration: All Rights Reserved !!!
 */
public class Solution01 {

    private static class LinkedListNode {
        int data;
        LinkedListNode next;
    }

    /**
     * �ⷨ
     * Ҫ���Ƴ������е��ظ���㣬������Ҫ�跨��¼����Щ���ظ��ġ�����ֻҪ�õ�һ���򵥵�
     * ɢ�б�
     * ������Ľⷨ�У����ǻ�ֱ�ӵ�����������������ÿ��������ɢ�б����������ظ�Ԫ
     * �أ��򽫸ý����������Ƴ���Ȼ�����������
     * �����ʱ�临�Ӷ�ΪO(N) ������NΪ��������Ŀ��
     *
     * @param n
     */
    public static void deleteDups(LinkedListNode n) {
        Set<LinkedListNode> set = new HashSet<>();
        LinkedListNode previous = null;
        while (n != null) {
            if (set.contains(n)) {
                previous.next = n.next;
            } else {
                set.add(n);
                previous = n;
            }
            n = n.next;
        }
    }

    /**
     * ���ף� ����ʹ�û�����
     * �粻��������Ļ�����������������ָ���������� current����������������runner����
     * �������Ľ���Ƿ��ظ���
     *
     * @param head
     */
    public static void deleteDups2(LinkedListNode head) {
        if (head == null) {
            return;
        }

        LinkedListNode current = head;
        while (current != null) {
            LinkedListNode runner = current.next;
            while (runner.next != null) {
                // �������ͬ�ľ�ȥ���ظ��ڵ�
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    // ����ͬ���ƶ�����һ���ڵ�
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }
}
