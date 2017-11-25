/**
 * �����ַ��ظ����ֵĻ�������дһ���򷨣�ʵ�ֻ��������ַ���ѹ�����ܡ����磬�ַ�
 * ��aabcccccaaa ���Ϊa2blc5a3o ����ѹ��������ַ���û���̣��򷵻�ԭ�ȵ��ַ�����
 * Author: ������
 * Date: 2015-10-15
 * Time: 08:02
 * Declaration: All Rights Reserved !!!
 */
public class Solution05 {

    /**
     * ��δ��벢δ����ѹ�����ַ�����ԭʼ�ַ������������������֮�⣬ȫ������Ҫ��
     * ��δ����ִ��ʱ��ΪO(p+k^2)������pΪԭʼ�ַ�������. kΪ�ַ����е����������磬��
     * �ַ���Ϊaabccdeeaa �����ܼ���6���ַ����С�ִ���ٶ�����ԭ�����ַ���ƴ�Ӳ�����ʱ�临��
     * ��ΪO(n^2)
     *
     * @param str
     * @return
     */
    public String compressBad(String str) {
        // ����ַ���Ϊnull���߳���С�ڵ���2����ԭ�����ַ���
        if (str == null || str.length() <= 2) {
            return str;
        }

        String mystr = "";
        char last = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            // �ҵ��ظ����ַ�
            if (str.charAt(i) == last) {
                count++;
            } else {
                // ������ظ��Ͱ���ͳ�Ƶ����ַ��ظ����ӵ�����ַ��ַ�������
                mystr += last + "" + count;
                last = str.charAt(i);
                count = 1;
            }
        }

        return mystr + last + count;
    }

    /**
     * ʹ��StringBuilder���������Ż�
     *
     * @param str
     * @return
     */
    public String compressBetter(String str) {
        // ���ѹ�����ַ����Ƿ���������
        int size = countCompress(str);
        if (size >= str.length()) {
            return str;
        }

        StringBuilder builder = new StringBuilder(str.length());
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            // �ҵ��ظ����ַ�
            if (str.charAt(i) == last) {
                count++;
            } else {
                // �����ַ�����Ŀ������last�ַ�
                // �����ַ�
                builder.append(last);
                // ������Ŀ
                builder.append(count);
                last = str.charAt(i);
                count = 1;
            }
        }

        // ������һ���ַ��ĸ���
        builder.append(last);
        builder.append(count);
        return builder.toString();
    }

    /**
     * ����ѹ������ַ���
     *
     * @param str
     * @return
     */
    private int countCompress(String str) {

        if (str == null || str.isEmpty()) {
            return 0;
        }

        char last = str.charAt(0);
        int size = 0;
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            // �ҵ��ظ����ַ�
            if (str.charAt(i) == last) {
                count++;
            } else {
                last = str.charAt(i);
                size += 1 + String.valueOf(count).length();
                count = 1;
            }
        }

        size += 1 + String.valueOf(count).length();
        return size;
    }

    public String compressButter2(String str) {

        if (str == null || str.length() <= 2) {
            return str;
        }

        StringBuilder builder = new StringBuilder(str.length());
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            // �ҵ��ظ����ַ�
            if (str.charAt(i) == last) {
                count++;
            } else {
                // �����ַ�����Ŀ������last�ַ�
                // �����ַ�
                builder.append(last);
                // ������Ŀ
                builder.append(count);
                last = str.charAt(i);
                count = 1;

                // ���builder���ַ�����str�еĻ�Ҫ������˵��ѹ������ø�����
                // ����ԭ�����ַ���
                if (builder.length() >= str.length()) {
                    return str;
                }
            }
        }

        // ������һ���ַ��ĸ���
        builder.append(last);
        builder.append(count);
        return builder.toString();
    }

    /**
     * ��ʹ���ַ�����ص�����ʵ��
     *
     * @param str
     * @return
     */
    public String compressAlternate(String str) {
        // ���ѹ�����ַ����Ƿ���������
        int size = countCompress(str);
        if (size >= str.length()) {
            return str;
        }

        char[] array = new char[size];
        int index = 0;
        char last = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            // �ҵ��ظ����ַ�
            if (str.charAt(i) == last) {
                count++;
            } else {
                // �����ظ��ַ�����Ŀ
                index = setChar(array, last, index, count);
                last = str.charAt(i);
                count = 1;
            }
        }
        // �������һ���ظ��ַ�����Ŀ
        index = setChar(array, last, index, count);
        return String.valueOf(array);
    }

    private int setChar(char[] array, char c, int index, int count) {
        array[index] = c;
        index++;

        char[] cnt = String.valueOf(count).toCharArray();

        for (char x : cnt) {
            array[index] = x;
            index++;
        }

        return index;
    }


}
