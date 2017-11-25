import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ���������ַ��������д����ȷ������һ���ַ������ַ��������к��ܷ�����
 * һ���ַ�����
 * �������������һ���� ��������Ӧ�������Թ�ȷ��һЩϸ�ڣ�Ū�����λ��
 * �� anagram : ��λ�����ɱ任ĳ���ʻ�������ĸ˳������ɵ��µĴʻ���
 * �Ƚ��Ƿ����ִ�Сд�����磬 God�Ƿ�Ϊdog�ı�λ�ʣ����⣬���ǻ�Ӧ��������Ƿ�Ҫ���ǿհ�
 * �ַ�������ٶ���λ�ʱȽ����ִ�Сд���հ�ҲҪ�������ڡ�Ҳ����˵����god �����ǡ�dog����
 * ��λ�ʡ��Ƚ������ַ���ʱ��ֻҪ���߳��Ȳ�ͬ���Ͳ������Ǳ�λ�ʡ������������������򵥵Ľ��������
 * ���Ҷ������������Ż������ȱȽ��ַ������ȡ�
 * Author: ������
 * Date: 2015-10-12
 * Time: 15:14
 * Declaration: All Rights Reserved !!!
 */
public class Solution03 {

    /**
     * ���ַ����������򣬲��ҷ����������ַ������ٶ�����Ĵ���Ϊ��
     *
     * @param s
     * @return
     */
    public String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    /**
     * �ⷨ1 �������ַ���
     * �������ַ�����Ϊ��λ�ʣ���ô����ӵ��ͬһ���ַ���ֻ����˳��ͬ����ˣ����ַ�����
     * �������������λ�ʵ��ַ��ͻ�����ͬ��˳������ֻ��Ƚ��������ַ�����
     *
     * @param s
     * @param t
     * @return
     */
    public boolean permutation(String s, String t) {
        // �����ַ�����Ϊ���Ƿ���true
        if (s == null && t == null) {
            return true;
        }

        // ֻ��һ��Ϊ��ʱ����false������������Ϊ�գ����ҳ��Ȳ����
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        // �����������ַ���������ȵ����
        return sort(s).equals(sort(t));
    }

    /**
     * �ⷨ2����������ַ����ĸ��ַ����Ƿ���ͬ��ǰ����������ַ�ֻ��ASCII
     * ���ǻ����Գ�����ñ�λ�ʵĶ���һһ����������ʵ��ַ�����ͬһһ��ʵ������㷨����
     * ��ֻ�������ĸ������ÿ���ַ����ֵĴ�����Ȼ�󣬱Ƚ����������鼴�ɡ�
     *
     * @param s
     * @param t
     * @return
     */
    public boolean permutation2(String s, String t) {
        // �����ַ�����Ϊ���Ƿ���true
        if (s == null && t == null) {
            return true;
        }

        // ֻ��һ��Ϊ��ʱ����false������������Ϊ�գ����ҳ��Ȳ����
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        // �����������ַ���������ȵ����

        // ����������ַ���ASCII
        int[] letters = new int[256];
        // ͳ��s���ַ�����Ŀ
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            letters[val]++;
        }

        // t�к��ַ�������Ժ�s�е��ַ���ȫ��������˵����������
        for (int i = 0; i < t.length(); i++) {
            int val = t.charAt(i);
            letters[val]--;
            if (letters[val] < 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * �ⷨ3����������ַ�ʹ��Unicode�ַ���ʱ������ʹ��HashMap�����д��������ڽⷨ2
     *
     * @param s
     * @param t
     * @return
     */
    public boolean permutation3(String s, String t) {
        // �����ַ�����Ϊ���Ƿ���true
        if (s == null && t == null) {
            return true;
        }

        // ֻ��һ��Ϊ��ʱ����false������������Ϊ�գ����ҳ��Ȳ����
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        // �����������ַ���������ȵ����
        Map<Character, Integer> map = new HashMap<>(256);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // ����ַ��Ѿ����ֹ��˾��ۼ�
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                // ��һ�γ��־�����Ϊ0
                map.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            // ����������c��ȵ�key
            if (map.containsKey(c)) {
                int num = map.get(c);
                // ֻ��һ���˾�ɾ��
                if (num == 1) {
                    map.remove(c);
                } else {
                    // ����ֵ�ͼ�һ
                    map.put(c, map.get(c) - 1);
                }

            } else {
                return false;
            }
        }

        return true;
    }
}
