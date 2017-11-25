/**
 * �ٶ���һ������isSubstring���ɼ��һ�������Ƿ�Ϊ�����ִ������Ӵ�����������
 * �ַ���s1��s2�����д������s2�Ƿ�Ϊs1��ת���ɣ� Ҫ��ֻ�ܵ���һ��isSubstring������
 * �磬 waterbottle ��erbottlewat ��ת����ַ�������
 * Author: ������
 * Date: 2015-10-16
 * Time: 14:21
 * Declaration: All Rights Reserved !!!
 */
public class Solution08 {

    /**
     * �ⷨ
     * �ٶ�s2 ��s l��ת���ɣ���ô�����ǿ����ҳ���ת�����ġ����磬����wat��waterbottle��
     * ת���ͻ�õ�erbottlewat ������ת�ַ���ʱ�����ǻ��sl�з�Ϊ�����֣�x��y��������������
     * ������ϳ�s2 ��
     * sl = xy = waterbottle
     * x = wat
     * y = erbottle
     * s2 = yx = erbottlewat
     * ��ˣ�������Ҫȷ����û�а취��s1�з�Ϊx��y ��������xy = s1��yx = s2 ������x��y֮
     * ��ķָ���ںδ������ǻᷢ��yx�϶���xyxy���Ӵ���Ҳ���� s2����s1s1���Ӵ���
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isRotation(String s1, String s2) {

        if (s1 == null && s2 == null) {
            return true;
        }

        if (s1 == null || s2 == null) {
            return false;
        }

        int len = s1.length();
        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }

        return false;
    }

    private boolean isSubstring(String s1s1, String s2) {
        return s1s1.substring(1).contains(s2);
    }
}
