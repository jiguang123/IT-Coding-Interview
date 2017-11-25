/**
 * ����һ����NxN �����ʾ��ͼ������ÿ�����صĴ�СΪ4�ֽڣ� ��дһ����������
 * ͼ����ת90�ȡ���ռ�ö����ڴ�ռ��ܷ�������
 * Author: ������
 * Date: 2015-10-15
 * Time: 08:57
 * Declaration: All Rights Reserved !!!
 */
public class Solution06 {

    /**
     * �ⷨ
     * Ҫ��������ת90�ȣ���򵥵���������һ��һ�������ת����ÿһ��ִ�л�״��ת�� circular
     * rotation �������ϱ��Ƶ��ұߡ��ұ��Ƶ��±ߡ��±��Ƶ���ߡ�����Ƶ��ϱߡ��㷨��ʱ�临�Ӷ�ΪO(N^2����
     * ���������ŵ���������Ϊ�κ��㷨����Ҫ��������Ni��Ԫ��
     *
     * @param matrix
     * @param n
     */
    public void rotate(int[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; ++layer) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = layer; i < last; i++) {
                int offset = i - first;
                // �洢�ϱ�
                int top = matrix[first][i];
                // ����
                matrix[first][i] = matrix[last - offset][first];
                // �µ���
                matrix[last - offset][first] = matrix[last][last - offset];
                // �ҵ���
                matrix[last][last - offset] = matrix[i][last];
                // �ϵ���
                matrix[i][last] = top;
            }
        }
    }

    /**
     * �ⷨ�����Ƚ��������ת�����ٶ�ÿһ�н��з�ת��Ч�ʲ����һ�ָ�
     *
     * @param matrix
     * @param n
     */
    public void rotate2(int[][] matrix, int n) {

    }
}
