/**
 * ��дһ���㷨�����ַ�����Ŀո�ȫ���滻Ϊ��%20�����ٶ����ַ���β�����㹻��
 * �ռ�洢�����ַ�������֪���ַ����ġ���ʵ�����ȡ���ע����Javaʵ�ֵĻ�����ʹ���ַ�����
 * ʵ�֣��Ա�ֱ���������ϲ�������
 * Author: ������
 * Date: 2015-10-12
 * Time: 15:50
 * Declaration: All Rights Reserved !!!
 */
public class Solution04 {
    /**
     * �ⷨ
     * �����ַ�����������ʱ�����������Ǵ��ַ���β����ʼ�༭���Ӻ���ǰ�����������������
     * �����ã���Ϊ�ַ���β���ж���Ļ��壬����ֱ���޸ģ����ص��ĻḲдԭ�����ݡ�
     * ���ǽ����������������������㷨���������ɨ�衣��һ��ɨ���������ַ������ж��ٿո�
     * �Ӷ�������յ��ַ����ж೤���ڶ���ɨ���������ʼ����༭�ַ�������⵽�ո���%20��
     * �Ƶ���һ��λ�ã������ǿհף��͸���ԭ�ȵ��ַ���
     *
     * @param str    ���滻���ַ���
     * @param length �ӵ�һ��λ�ÿ�ʼ�����Ӵ�ŵ��ַ�����
     * @return �滻����ַ�����ĳ���
     */
    public int replaceSpaces(char[] str, int length) {
        int spaceCount = 0;
        int newLength = 0;

        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        newLength = length + 2 * spaceCount;
        spaceCount = newLength - 1;
        for (int i = length - 1; i >= 0; i++) {
            if (str[i] == ' ') {
                str[spaceCount] = '0';
                str[spaceCount - 1] = '2';
                str[spaceCount - 2] = '%';
                spaceCount -= 3;
            } else {
                str[spaceCount] = str[i];
                spaceCount--;
            }
        }

        return newLength;
    }
}
