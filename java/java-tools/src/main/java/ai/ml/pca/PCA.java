package ai.ml.pca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Jama.Matrix;
import Jama.SingularValueDecomposition;

/**
 * pca 使用特征向量分解的方法实现。<br>
 * 
 * @link http://www.cnblogs.com/zhangchaoyang/articles/2222048.html<br>
 *       jama 矩阵操作参考
 * @link http://www.cnblogs.com/zangbo/p/5622351.html
 */
public class PCA {
	public static void main(String[] a) throws Exception {
		// BufferedReader bReader = new BufferedReader(new
		// FileReader("src/main/resources/files/data/pca.txt"));
		BufferedReader bReader = new BufferedReader(new FileReader("C:\\Users\\delln\\Desktop\\qa/qa20161018_10.txt"));

		int m = 150, n = 4;
		// readMatrix(bReader, m, n);
		//pca1(bReader, m, n);
		pca2(bReader, m, n);

	}

	/**
	 * 读取matrix文件，进行pca的特征向量分解方法
	 * 
	 * @param bReader
	 * @param m
	 * @throws IOException
	 */
	private static void pca1(BufferedReader bReader, int m, int n) throws IOException {
		Matrix A = Matrix.read(bReader);
		A.print(m, n);
		// 特征中心化
		double a0 = 0, a1 = 0, a2 = 0, a3 = 0;
		for (int i = 0; i < m; i++) {
			a0 += A.get(i, 0);
			a1 += A.get(i, 1);
			a2 += A.get(i, 2);
			a3 += A.get(i, 3);
		}
		a0 /= m;
		a1 /= m;
		a2 /= m;
		a3 /= m;
		Matrix A0 = new Matrix(m, 1, a0);
		Matrix A1 = new Matrix(m, 1, a1);
		Matrix A2 = new Matrix(m, 1, a2);
		Matrix A3 = new Matrix(m, 1, a3);
	}

	/**
	 * 读取matrix文件，进行pca2的奇异值分解（SVD分解）
	 * 
	 * @param bReader
	 * @param m
	 * @throws IOException
	 */
	private static void pca2(BufferedReader bReader, int m, int n) throws IOException {
		Matrix A = Matrix.read(bReader);
		System.out.println("begin : "+A.getRowDimension());
		SingularValueDecomposition s = A.svd();
		System.out.print("U = ");
		Matrix U = s.getU();
		U.print(9, 6);
		System.out.print("Sigma = ");
		Matrix S = s.getS();
		S.print(9, 6);
		System.out.print("V = ");
		Matrix V = s.getV();
		V.print(9, 6);
		System.out.println("rank = " + s.rank());
		System.out.println("condition number = " + s.cond());
		System.out.println("2-norm = " + s.norm2());

		// print out singular values
		System.out.print("singular values = ");
		Matrix svalues = new Matrix(s.getSingularValues(), 1);
		svalues.print(9, 6);

		// 按列压缩，降维 Uk*Sk
		Matrix U_sub = U.getMatrix(0, U.getRowDimension() - 1, 0, 1);
		Matrix compress = U_sub.times(S.getMatrix(0, 1, 0, 1));
		compress.print(9, 6);

		// 近似矩阵 Uk*Sk*Vk^T
		Matrix approxiamte = compress.times(V.transpose().getMatrix(0, 1, 0, V.getColumnDimension() - 1));
		approxiamte.print(9, 6);

		// 按行压缩，舍去部分训练样本 Sk*Vk^T
		compress = S.getMatrix(0, 1, 0, 1).times(V.transpose().getMatrix(0, 1, 0, V.getColumnDimension() - 1));
		compress.print(9, 6);
	}

	/**
	 * 原始的从文件读取矩阵的方法，应该使用封装好的Matrix.read(bReader)
	 * 
	 * @param bReader
	 * @param m
	 * @param n
	 * @throws IOException
	 */
	private static void readMatrix(BufferedReader bReader, int m, int n) throws IOException {
		double[][] aArr = new double[m][n];
		String line = null;
		// read file for A
		int mi = 0;
		while ((line = bReader.readLine()) != null) {
			String[] aa = line.split(" ");
			for (int i = 0; i < aa.length; i++) {
				aArr[mi][i] = Double.valueOf(aa[i]);
			}
			mi++;
		}

		Matrix A = new Matrix(aArr);
		A.print(m, n);

	}
}