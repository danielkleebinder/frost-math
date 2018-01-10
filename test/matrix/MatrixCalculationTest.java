package matrix;

import org.frost.math.matrix.Matrix4f;

/**
 * @author Daniel Kleebinder
 */
public class MatrixCalculationTest {

	public static void main(String[] args) {
		Matrix4f a = new Matrix4f(
				-2, 4, 1, 3,
				0, 3, 0, 2,
				1, 0, 5, 1,
				4, 1, 7, 1
		);

		Matrix4f b = new Matrix4f(
				-6, 12, 3, 9,
				0, 3, 0, 2,
				1, 0, 5, 1,
				12, 3, 21, 3
		);

		Matrix4f c = new Matrix4f(
				1, 0, 5, 1,
				-2, 4, 1, 3,
				4, 1, 7, 1,
				0, 3, 0, 2
		);

		Matrix4f d = new Matrix4f(
				1, 0, 5, 1,
				0, 4, 11, 5,
				4, 1, 7, 1,
				0, 3, 0, 2
		);

		System.out.println(a.divide(a.invert()));
		System.out.println();
		System.out.println(Matrix4f.IDENTITY.determinant());
		System.out.println();
		System.out.println(a.determinant() + b.determinant());
		System.out.println(a.add(b).determinant());

		System.out.println("----------------");

		System.out.println(a.transpose().add(b.transpose()).determinant());
		System.out.println(b.transpose().add(c.transpose()).determinant());
		System.out.println(c.transpose().add(d.transpose()).determinant());
		System.out.println(d.transpose().add(a.transpose()).determinant());

		System.out.println("----------------");

		System.out.println(a.transpose().determinant());
		System.out.println(b.transpose().determinant());
		System.out.println(c.transpose().determinant());
		System.out.println(d.transpose().determinant());
	}
}
