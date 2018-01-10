package org.frost.math.matrix;

import org.frost.math.FastMath;

/**
 * Holds a 2x2 int matrix.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Matrix2i implements SquareMatrix<Matrix2i, Integer> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 786123984862534L;

	/**
	 * Identity matrix.
	 */
	public static final Matrix2i IDENTITY = new ReadOnlyMatrix2i();
	/**
	 * Matrix filled with ones.
	 */
	public static final Matrix2i ONE = new ReadOnlyMatrix2i(1);
	/**
	 * Matrix filled with zeros.
	 */
	public static final Matrix2i ZERO = new ReadOnlyMatrix2i(0);
	/**
	 * Matrix filled with negative ones.
	 */
	public static final Matrix2i NEGATIVE_ONE = new ReadOnlyMatrix2i(-1);

	/**
	 * This matrix value is the bold value in the matrix below.
	 * <table border="1">
	 * <caption>Identity Matrix</caption>
	 * <tr><td><b>1</b></td> <td>0</td></tr>
	 * <tr> <td>0</td> <td>1</td></tr>
	 * </table>This value has the index 0!
	 */
	public int m00;
	/**
	 * This matrix value is the bold value in the matrix below.
	 * <table border="1">
	 * <caption>Identity Matrix</caption>
	 * <tr><td>1</td> <td><b>0</b></td></tr>
	 * <tr> <td>0</td> <td>1</td></tr>
	 * </table>This value has the index 1!
	 */
	public int m01;
	/**
	 * This matrix value is the bold value in the matrix below.
	 * <table border="1">
	 * <caption>Identity Matrix</caption>
	 * <tr><td>1</td> <td>0</td></tr>
	 * <tr><td><b>0</b></td> <td>1</td></tr>
	 * </table>This value has the index 2!
	 */
	public int m10;
	/**
	 * This matrix value is the bold value in the matrix below.
	 * <table border="1">
	 * <caption>Identity Matrix</caption>
	 * <tr><td>1</td> <td>0</td></tr>
	 * <tr> <td>0</td> <td><b>1</b></td></tr>
	 * </table>This value has the index 3!
	 */
	public int m11;

	/**
	 * Creates a new 2x2 matrix, which is initialized with the default identity
	 * values.
	 */
	public Matrix2i() {
		m01 = m10 = 0;
		m00 = m11 = 1;
	}

	/**
	 * Creates a new 2x2 matrix and sets all values of the matrix to the given
	 * value.
	 *
	 * @param value Value which all matrix values should have.
	 */
	public Matrix2i(int value) {
		this(value, value, value, value);
	}

	/**
	 * Creates a new 2x2 matrix with the given values.
	 *
	 * @param m00 Value 1.
	 * @param m01 Value 2.
	 * @param m10 Value 3.
	 * @param m11 Value 4.
	 */
	public Matrix2i(int m00, int m01, int m10, int m11) {
		this.m00 = m00;
		this.m01 = m01;
		this.m10 = m10;
		this.m11 = m11;
	}

	/**
	 * Creates a new 2x2 matrix from the given matrix. Takes over the matrix
	 * data from the given matrix!
	 *
	 * @param mat Given matrix.
	 */
	public Matrix2i(Matrix2i mat) {
		m00 = mat.m00;
		m01 = mat.m01;
		m10 = mat.m10;
		m11 = mat.m11;
	}

	@Override
	public Matrix2i set(Matrix2i mat) {
		m00 = mat.m00;
		m01 = mat.m01;
		m10 = mat.m10;
		m11 = mat.m11;
		return this;
	}

	/**
	 * Sets the matrix values to the given ones.
	 *
	 * @param m00 Value 1.
	 * @param m01 Value 2.
	 * @param m10 Value 3.
	 * @param m11 Value 4.
	 * @return This matrix.
	 */
	public Matrix2i set(int m00, int m01, int m10, int m11) {
		this.m00 = m00;
		this.m01 = m01;
		this.m10 = m10;
		this.m11 = m11;
		return this;
	}

	@Override
	public Matrix2i invert() {
		return new Matrix2i(this).invertLocal();
	}

	@Override
	public Matrix2i invertLocal() {
		int determinant = determinant();
		if (FastMath.abs(determinant) <= 0.0f) {
			return zero();
		}

		int f00 = m11;
		int f11 = m00;

		int f01 = -m01;
		int f10 = -m10;

		set(f00, f01, f10, f11);
		return multiplicateLocal(FastMath.roundToInt(1.0f / determinant));
	}

	@Override
	public Matrix2i adjoint() {
		return new Matrix2i(this).adjointLocal();
	}

	@Override
	public Matrix2i adjointLocal() {
		int f00 = m11;
		int f11 = m00;
		int f01 = -m01;
		int f10 = -m10;
		return set(f00, f01, f10, f11);
	}

	@Override
	public Matrix2i transpose() {
		return new Matrix2i(this).transposeLocal();
	}

	@Override
	public Matrix2i transposeLocal() {
		return set(
				m00, m10,
				m01, m11
		);
	}

	@Override
	public Matrix2i identity() {
		m01 = m10 = 0;
		m00 = m11 = 1;
		return this;
	}

	@Override
	public Matrix2i zero() {
		return fill(0);
	}

	@Override
	public Matrix2i one() {
		return fill(1);
	}

	@Override
	public Matrix2i fill(Integer v) {
		m00 = m01 = v;
		m10 = m11 = v;
		return this;
	}

	@Override
	public Matrix2i add(Integer v) {
		return new Matrix2i(this).addLocal(v);
	}

	@Override
	public Matrix2i addLocal(Integer v) {
		m00 += v;
		m01 += v;
		m10 += v;
		m11 += v;
		return this;
	}

	@Override
	public Matrix2i add(Matrix2i mat) {
		return new Matrix2i(this).addLocal(mat);
	}

	@Override
	public Matrix2i addLocal(Matrix2i mat) {
		m00 = m00 + mat.m00;
		m01 = m01 + mat.m01;
		m10 = m10 + mat.m10;
		m11 = m11 + mat.m11;
		return this;
	}

	@Override
	public Matrix2i subtract(Integer v) {
		return new Matrix2i(this).subtractLocal(v);
	}

	@Override
	public Matrix2i subtractLocal(Integer scalar) {
		m00 -= scalar;
		m01 -= scalar;
		m10 -= scalar;
		m11 -= scalar;
		return this;
	}

	@Override
	public Matrix2i subtract(Matrix2i mat) {
		return new Matrix2i(this).subtractLocal(mat);
	}

	@Override
	public Matrix2i subtractLocal(Matrix2i mat) {
		m00 = m00 - mat.m00;
		m01 = m01 - mat.m01;
		m10 = m10 - mat.m10;
		m11 = m11 - mat.m11;
		return this;
	}

	@Override
	public Matrix2i multiplicate(Integer v) {
		return new Matrix2i(this).multiplicateLocal(v);
	}

	@Override
	public Matrix2i multiplicateLocal(Integer scalar) {
		m00 *= scalar;
		m01 *= scalar;
		m10 *= scalar;
		m11 *= scalar;
		return this;
	}

	@Override
	public Matrix2i multiplicate(Matrix2i mat) {
		return new Matrix2i(this).multiplicateLocal(mat);
	}

	@Override
	public Matrix2i multiplicateLocal(Matrix2i mat) {
		int temp00 = m00 * mat.m00 + m01 * mat.m10;
		int temp01 = m00 * mat.m01 + m01 * mat.m11;
		int temp10 = m10 * mat.m00 + m11 * mat.m10;
		int temp11 = m10 * mat.m01 + m11 * mat.m11;
		return set(temp00, temp01, temp10, temp11);
	}

	@Override
	public Matrix2i divide(Integer scalar) {
		return new Matrix2i(this).divideLocal(scalar);
	}

	@Override
	public Matrix2i divideLocal(Integer scalar) {
		m00 /= scalar;
		m01 /= scalar;
		m10 /= scalar;
		m11 /= scalar;
		return this;
	}

	@Override
	public Matrix2i divide(Matrix2i mat) {
		return new Matrix2i(this).divideLocal(mat);
	}

	@Override
	public Matrix2i divideLocal(Matrix2i mat) {
		int temp00 = m00 / mat.m00 + m01 / mat.m10;
		int temp01 = m00 / mat.m01 + m01 / mat.m11;
		int temp10 = m10 / mat.m00 + m11 / mat.m10;
		int temp11 = m10 / mat.m01 + m11 / mat.m11;
		return set(temp00, temp01, temp10, temp11);
	}

	@Override
	public Matrix2i absolute() {
		return new Matrix2i(this).absoluteLocal();
	}

	@Override
	public Matrix2i absoluteLocal() {
		m00 = FastMath.abs(m00);
		m01 = FastMath.abs(m01);
		m10 = FastMath.abs(m10);
		m11 = FastMath.abs(m11);
		return this;
	}

	@Override
	public int getWidth() {
		return 2;
	}

	@Override
	public int getHeight() {
		return 2;
	}

	@Override
	public Matrix2i put(int i, Integer v) {
		switch (i) {
			case 0:
				m00 = v;
				break;
			case 1:
				m01 = v;
				break;
			case 2:
				m10 = v;
				break;
			case 3:
				m11 = v;
				break;
			default:
				throw new IllegalArgumentException("Parameter is not in range!");
		}
		return this;
	}

	@Override
	public Integer get(int i) {
		switch (i) {
			case 0:
				return m00;
			case 1:
				return m01;
			case 2:
				return m10;
			case 3:
				return m11;
			default:
				throw new IllegalArgumentException("Parameter is not in range!");
		}
	}

	@Override
	public Matrix2i put(int i, int j, Integer v) {
		if (i == 0 && j == 0) {
			m00 = v;
		}
		if (i == 1 && j == 0) {
			m10 = v;
		}
		if (i == 0 && j == 1) {
			m01 = v;
		}
		if (i == 1 && j == 1) {
			m11 = v;
		}

		throw new IllegalArgumentException("Parameters are not in range!");
	}

	@Override
	public Integer get(int i, int j) {
		if (i == 0 && j == 0) {
			return m00;
		}
		if (i == 1 && j == 0) {
			return m10;
		}
		if (i == 0 && j == 1) {
			return m01;
		}
		if (i == 1 && j == 1) {
			return m11;
		}

		throw new IllegalArgumentException("Parameters are not in range!");
	}

	@Override
	public Integer[] getRow(int i) {
		if (i == 0) {
			return new Integer[]{m00, m01};
		}
		if (i == 1) {
			return new Integer[]{m10, m11};
		}

		throw new IllegalArgumentException("Index not in range!");
	}

	@Override
	public Integer[] getColumn(int i) {
		if (i == 0) {
			return new Integer[]{m00, m10};
		}
		if (i == 1) {
			return new Integer[]{m01, m11};
		}

		throw new IllegalArgumentException("Index not in range!");
	}

	@Override
	public Matrix2i negate() {
		return new Matrix2i(this).negateLocal();
	}

	@Override
	public Matrix2i negateLocal() {
		m00 = -m00;
		m01 = -m01;
		m10 = -m10;
		m11 = -m11;
		return this;
	}

	@Override
	public Integer determinant() {
		return m00 * m11 - m01 * m10;
	}

	@Override
	public boolean isIdentity() {
		return (m00 == 1 && m11 == 1 && m01 == 0 && m10 == 0);
	}

	@Override
	public boolean isZero() {
		return isUnified(0);
	}

	@Override
	public boolean isOne() {
		return isUnified(1);
	}

	@Override
	public boolean isUnified(Integer v) {
		return (m00 == v && m11 == v && m01 == v && m10 == v);
	}

	@Override
	public void fromArray(Integer... array) {
		m00 = array[0];
		m01 = array[1];
		m10 = array[3];
		m11 = array[4];
	}

	@Override
	public Integer[] toArray() {
		return new Integer[]{
			m00, m01,
			m10, m11
		};
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 89 * hash + this.m00;
		hash = 89 * hash + this.m01;
		hash = 89 * hash + this.m10;
		hash = 89 * hash + this.m11;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Matrix2i other = (Matrix2i) obj;
		if (this.m00 != other.m00) {
			return false;
		}
		if (this.m01 != other.m01) {
			return false;
		}
		if (this.m10 != other.m10) {
			return false;
		}
		return this.m11 == other.m11;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(16);

		result.append(m00);
		result.append(" ");
		result.append(m01);
		result.append("\n");

		result.append(m10);
		result.append(" ");
		result.append(m11);

		return result.toString();
	}

	@Override
	public Matrix2i clone() throws CloneNotSupportedException {
		return (Matrix2i) super.clone();
	}
}
