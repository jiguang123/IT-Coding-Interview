/**
 * ���⣺ʵ��һ���㷨��ȷ��һ���ַ����������ַ��Ƿ�ȫ����ͬ����ʹ������ʹ�ö�������ݽṹ���ָ���δ���
 * �ٶ��ַ���ΪASCII������������⣬���ǿ�����һ���򵥵��Ż������ַ����ĳ��ȴ�����
 * ĸ���е��ַ���������ֱ�ӷ���false ���Ͼ�������ĸ��ֻ��256���ַ��� �ַ�����Ͳ�������280
 * ��������ͬ���ַ���
 * Author: ������
 * Date: 2015-10-12
 * Time: 14:45
 * Declaration: All Rights Reserved !!!
 */
public class Solution01 {

    /**
     * ����Ĵ���ٶ��ַ���ֻ����Сд��ĸa��z������һ��������ֻ��ʹ��һ��int�ͱ�����
     *
     * @param str
     * @return
     */
    public boolean isUniqueChars(String str) {
        // ����ַ���Ϊ����Ϊ�����ظ����ַ�
        if (str == null) {
            return true;
        }

        // ���ȴ���256��һ�����ظ���
        if (str.length() > 256) {
            return false;
        }

        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            // ����ĸ����ţ���0��ʼ
            int val = str.charAt(i) - 'a';
            // �����val����ĸ�Ѿ����ֹ�����false
            if ((checker & (1 << val)) > 0) {
                return false;
            } else {
                // ��ǵ�val�������Ѿ�������
                checker |= (1 << val);
            }
        }

        return true;
    }

    /**
     * ��һ�ֽⷨ�ǹ���һ������ֵ�����飬����ֵi��Ӧ�ı��ָʾ���ַ����Ƿ�����ĸ���i
     * ���ַ���������ַ��ڶ��γ��֣�����������false ��
     * ʹ��λ������ bit vector �������Խ��ռ�ռ�ü���Ϊԭ�ȵ�1/8 ��
     *
     * @param str
     * @return
     */
    public boolean isUniqueChars2(String str) {

        // ����ַ���Ϊ����Ϊ�����ظ����ַ�
        if (str == null) {
            return true;
        }

        // ���ȴ���256��һ�����ظ���
        if (str.length() > 256) {
            return false;
        }

        boolean[] charSet = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            // ���֮ǰ�Ѿ����ֹ����ַ����ͷ���false
            if (charSet[val]) {
                return false;
            } else {
                // ����ַ��Ѿ����ֹ�
                charSet[val] = true;
            }
        }

        // û�г��ֹ��ظ����ַ�
        return true;
    }
    /**
     * �����Ľⷨ��
     * (1�����ַ����е�ÿһ���ַ��������ַ����бȽϡ����ַ�����ʱ�临�Ӷ�ΪO��n^2���� �ռ临
     * �Ӷ�ΪO��1����
     * (2���������޸������ַ�����������O(nlog(nx))ʱ������ַ�������Ȼ�����Լ����������
     * �����ַ���ȫ��ͬ�������������ֵ��ע����ǣ� �ܶ������㷨��ռ�ö���Ŀռ䡣
     */
}
