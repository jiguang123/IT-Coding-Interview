/**
 * ��תһ���ַ�����
 * Author: ������
 * Date: 2015-10-12
 * Time: 15:01
 * Declaration: All Rights Reserved !!!
 */
public class Solution02 {
    /**
     * ��һ���ַ������з�ת�����ط�ת������ַ���
     *
     * @param str
     */
    public String reverse(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        char[] chars = str.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = chars[i];
        }

        return new String(chars);
    }
}
