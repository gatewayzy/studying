package ai.ml.svd;

import Jama.Matrix;
import Jama.SingularValueDecomposition;

/**
 * SVD求解矩阵的特征值与奇异值<br>
 * A = U S V^T. U是左奇异向量，S是奇异值矩阵，V是右奇异向量<br>
 * 输入A求解S，选取主要奇异值。
 */
public class SVD {
	public static void main(String[] args) {
		// svd2();
	}

	/**
	 * 这是姚博的代码，步骤：<br>
	 * == 样本矩阵A，均可表示为A=U*S*V^T，使用Java Matrix Package 算出 USV<br>
	 * == 选取奇异值矩阵S中比重高的部分Ak进行降维
	 * 
	 */
	private static void svd2() {
		// create M-by-N matrix that doesn't have full rank
		int M = 8, N = 5;
		Matrix B = Matrix.random(5, 3);
		Matrix A = Matrix.random(M, N).times(B).times(B.transpose());
		System.out.print("A = ");
		A.print(9, 6);

		// compute the singular value decomposition
		System.out.println("A = U S V^T");
		System.out.println();
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

}