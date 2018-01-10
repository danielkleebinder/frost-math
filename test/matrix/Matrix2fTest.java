package matrix;

import org.frost.math.matrix.Matrix2f;
import org.frost.math.matrix.ReadOnlyMatrix2f;

/**
 * @author Daniel Kleebinder
 */
public class Matrix2fTest {

	public static void main(String[] args) {
		Matrix2f mat1 = new ReadOnlyMatrix2f(1.0f, 2.0f, 3.0f, 4.0f);
		Matrix2f mat2 = new ReadOnlyMatrix2f(1.0f, 2.0f, 3.0f, 4.0f);

		long l = System.currentTimeMillis();
		for (int i = 0; i < 1_000_000; i++) {
			Matrix2f.IDENTITY.multiplicate(mat1);
			Matrix2f.IDENTITY.multiplicate(mat2);
		}
		System.out.println("Calculation Time: " + (System.currentTimeMillis() - l));
	}
}
