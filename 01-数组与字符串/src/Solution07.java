/**
 * ��дһ���㷨����MxN������ĳ��Ԫ��Ϊ0���������ڵ����뵽���㡣
 * Author: ������
 * Date: 2015-10-16
 * Time: 13:53
 * Declaration: All Rights Reserved !!!
 */
public class Solution07 {

    /**
     * �ⷨ������������ֱ��¼������Ԫ�ص������к��С�Ȼ����
     * �Ƕ��α�������ʱ���������л��б��Ϊ�㣬��Ԫ����Ϊ�㡣
     *
     * @param matrix
     */
    public void setZeros(int[][] matrix) {
        // ������������ݶ��ǺϷ���
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        // ��¼ֵΪ0��Ԫ��������������������
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // ����i������j�и�Ԫ��Ϊ0����matrix[i][j]����Ϊ0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * ʹ��O(1)�ڴ�Ľⷨ
     *
     * @param matrix
     */
    public void setZeros2(int[][] matrix) {
        // ��¼�Ƿ��0��Ҫ����
        boolean row = false;
        // ��¼�Ƿ��0��Ҫ����
        boolean col = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                // ����0�к͵�0��������������к����Ƿ�Ҫ����
                if (matrix[i][j] == 0) {
                    // ��j��Ҫ����Ϊ0
                    matrix[0][j] = 0;
                    // ��i��Ҫ����Ϊ0
                    matrix[i][0] = 0;

                    // ��0��Ҫ����
                    if (i == 0) {
                        row = true;
                    }
                    // ��0��Ҫ����
                    if (j == 0) {
                        col = true;
                    }
                }
            }
        }

        // ����0�������������
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        // ����0�������������
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // ����0������
        if (row) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        // ����0������
        if (col) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }


}
