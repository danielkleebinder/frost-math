package org.frost.math.matrix;

import org.frost.math.FastMath;

/**
 * Holds a 2x2 double matrix.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Matrix2d implements SquareMatrix<Matrix2d, Double> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 786123984862534L;

	/**
	 * Identity matrix.
	 */
	public static final Matrix2d IDENTITY = new ReadOnlyMatrix2d();
	/**
	 * Matrix filled with ones.
	 */
	public static final Matrix2d ONE = new ReadOnlyMatrix2d(1.0f);
	/**
	 * Matrix filled with zeros.
	 */
	public static final Matrix2d ZERO = new ReadOnlyMatrix2d(0.0f);
	/**
	 * Matrix filled with negative ones.
	 */
	public static final Matrix2d NEGATIVE_ONE = new ReadOnlyMatrix2d(-1.0f);

	/**
	 * This matrix value is the bold value in the matrix below.
	 * <table border="1">
	 * <caption>Identity Matrix</caption>
	 * <tr><td><b>1</b></td> <td>0</td></tr>
	 * <tr> <td>0</td> <td>1</td></tr>
	 * </table>This value has the index 0!
	 */
	public double m00;
	/**
	 * This matrix value is the bold value in the matrix below.
	 * <table border="1">
	 * <caption>Identity Matrix</caption>
	 * <tr><td>1</td> <td><b>0</b></td></tr>
	 * <tr> <td>0</td> <td>1</td></tr>
	 * </table>This value has the index 1!
	 */
	public double m01;
	/**
	 * This matrix value is the bold value in the matrix below.
	 * <table border="1">
	 * <caption>Identity Matrix</caption>
	 * <tr><td>1</td> <td>0</td></tr>
	 * <tr><td><b>0</b></td> <td>1</td></tr>
	 * </table>This value has the index 2!
	 */
	public double m10;
	/**
	 * This matrix value is the bold value in the matrix below.
	 * <table border="1">
	 * <caption>Identity Matrix</caption>
	 * <tr><td>1</td> <td>0</td></tr>
	 * <tr> <td>0</td> <td><b>1</b></td></tr>
	 * </table>This value has the index 3!
	 */
	public double m11;

	/**
	 * Creates a new 2x2 matrix, which is initialized with the default identity
	 * values.
	 */
	public Matrix2d() {
		m01 = m10 = 0.0f;
		m00 = m11 = 1.0f;
	}

	/**
	 * Creates a new 2x2 matrix and sets all values of the matrix to the given
	 * value.
	 *
	 * @param value Value which all matrix values should have.
	 */
	public Matrix2d(double value) {
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
	public Matrix2d(double m00, double m01, double m10, double m11) {
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
	public Matrix2d(Matrix2d mat) {
		m00 = mat.m00;
		m01 = mat.m01;
		m10 = mat.m10;
		m11 = mat.m11;
	}

	@Override
	public Matrix2d set(Matrix2d mat) {
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
	public Matrix2d set(double m00, double m01, double m10, double m11) {
		this.m00 = m00;
		this.m01 = m01;
		this.m10 = m10;
		this.m11 = m11;
		return this;
	}

	@Override
	public Matrix2d invert() {
		return new Matrix2d(this).invertLocal();
	}

	@Override
	public Matrix2d invertLocal() {
		double determinant = determinant();
		if (FastMath.abs(determinant) <= 0.0f) {
			return zero();
		}

		double f00 = m11;
		double f11 = m00;

		double f01 = -m01;
		double f10 = -m10;

		set(f00, f01, f10, f11);
		return multiplicateLocal(1.0f / determinant);
	}

	@Override
	public Matrix2d adjoint() {
		return new Matrix2d(this).adjointLocal();
	}

	@Override
	public Matrix2d adjointLocal() {
		double f00 = m11;
		double f11 = m00;
		double f01 = -m01;
		double f10 = -m10;
		return set(f00, f01, f10, f11);
	}

	@Override
	public Matrix2d transpose() {
		return new Matrix2d(this).transposeLocal();
	}

	@Override
	public Matrix2d transposeLocal() {
		return set(
				m00, m10,
				m01, m11
		);
	}

	@Override
	public Matrix2d identity() {
		m01 = m10 = 0.0f;
		m00 = m11 = 1.0f;
		return this;
	}

	@Override
	public Matrix2d zero() {
		return fill(0.0);
	}

	@Override
	public Matrix2d one() {
		return fill(1.0);
	}

	@Override
	public Matrix2d fill(Double v) {
		m00 = m01 = v;
		m10 = m11 = v;
		return this;
	}

	@Override
	public Matrix2d add(Double v) {
		return new Matrix2d(this).addLocal(v);
	}

	@Override
	public Matrix2d addLocal(Double v) {
		m00 += v;
		m01 += v;
		m10 += v;
		m11 += v;
		return this;
	}

	@Override
	public Matrix2d add(Matrix2d mat) {
		return new Matrix2d(this).addLocal(mat);
	}

	@Override
	public Matrix2d addLocal(Matrix2d mat) {
		m00 = m00 + mat.m00;
		m01 = m01 + mat.m01;
		m10 = m10 + mat.m10;
		m11 = m11 + mat.m11;
		return this;
	}

	@Override
	public Matrix2d subtract(Double v) {
		return new Matrix2d(this).subtractLocal(v);
	}

	@Override
	public Matrix2d subtractLocal(Double scalar) {
		m00 -= scalar;
		m01 -= scalar;
		m10 -= scalar;
		m11 -= scalar;
		return this;
	}

	@Override
	public Matrix2d subtract(Matrix2d mat) {
		return new Matrix2d(this).subtractLocal(mat);
	}

	@Override
	public Matrix2d subtractLocal(Matrix2d mat) {
		m00 = m00 - mat.m00;
		m01 = m01 - mat.m01;
		m10 = m10 - mat.m10;
		m11 = m11 - mat.m11;
		return this;
	}

	@Override
	public Matrix2d multiplicate(Double v) {
		return new Matrix2d(this).multiplicateLocal(v);
	}

	@Override
	public Matrix2d multiplicateLocal(Double scalar) {
		m00 *= scalar;
		m01 *= scalar;
		m10 *= scalar;
		m11 *= scalar;
		return this;
	}

	@Override
	public Matrix2d multiplicate(Matrix2d mat) {
		return new Matrix2d(this).multiplicateLocal(mat);
	}

	@Override
	public Matrix2d multiplicateLocal(Matrix2d mat) {
		double temp00 = m00 * mat.m00 + m01 * mat.m10;
		double temp01 = m00 * mat.m01 + m01 * mat.m11;
		double temp10 = m10 * mat.m00 + m11 * mat.m10;
		double temp11 = m10 * mat.m01 + m11 * mat.m11;
		return set(temp00, temp01, temp10, temp11);
	}

	@Override
	public Matrix2d divide(Double scalar) {
		return new Matrix2d(this).divideLocal(scalar);
	}

	@Override
	public Matrix2d divideLocal(Double scalar) {
		m00 /= scalar;
		m01 /= scalar;
		m10 /= scalar;
		m11 /= scalar;
		return this;
	}

	@Override
	public Matrix2d divide(Matrix2d mat) {
		return new Matrix2d(this).divideLocal(mat);
	}

	@Override
	public Matrix2d divideLocal(Matrix2d mat) {
		double temp00 = m00 / mat.m00 + m01 / mat.m10;
		double temp01 = m00 / mat.m01 + m01 / mat.m11;
		double temp10 = m10 / mat.m00 + m11 / mat.m10;
		double temp11 = m10 / mat.m01 + m11 / mat.m11;
		return set(temp00, temp01, temp10, temp11);
	}

	@Override
	public Matrix2d absolute() {
		return new Matrix2d(this).absoluteLocal();
	}

	@Override
	public Matrix2d absoluteLocal() {
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
	public Matrix2d put(int i, Double v) {
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
	public Double get(int i) {
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
	public Matrix2d put(int i, int j, Double v) {
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
	public Double get(int i, int j) {
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
	public Double[] getRow(int i) {
		if (i == 0) {
			return new Double[]{m00, m01};
		}
		if (i == 1) {
			return new Double[]{m10, m11};
		}

		throw new IllegalArgumentException("Index not in range!");
	}

	@Override
	public Double[] getColumn(int i) {
		if (i == 0) {
			return new Double[]{m00, m10};
		}
		if (i == 1) {
			return new Double[]{m01, m11};
		}

		throw new IllegalArgumentException("Index not in range!");
	}

	@Override
	public Matrix2d negate() {
		return new Matrix2d(this).negateLocal();
	}

	@Override
	public Matrix2d negateLocal() {
		m00 = -m00;
		m01 = -m01;
		m10 = -m10;
		m11 = -m11;
		return this;
	}

	@Override
	public Double determinant() {
		return m00 * m11 - m01 * m10;
	}

	@Override
	public boolean isIdentity() {
		return (m00 == 1 && m11 == 1 && m01 == 0 && m10 == 0);
	}

	@Override
	public boolean isZero() {
		return isUnified(0.0);
	}

	@Override
	public boolean isOne() {
		return isUnified(1.0);
	}

	@Override
	public boolean isUnified(Double v) {
		return (m00 == v && m11 == v && m01 == v && m10 == v);
	}

	@Override
	public void fromArray(Double... array) {
		m00 = array[0];
		m01 = array[1];
		m10 = array[3];
		m11 = array[4];
	}

	@Override
	public Double[] toArray() {
		return new Double[]{
			m00, m01,
			m10, m11
		};
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 13 * hash + (int) (Double.doubleToLongBits(this.m00) ^ (Double.doubleToLongBits(this.m00) >>> 32));
		hash = 13 * hash + (int) (Double.doubleToLongBits(this.m01) ^ (Double.doubleToLongBits(this.m01) >>> 32));
		hash = 13 * hash + (int) (Double.doubleToLongBits(this.m10) ^ (Double.doubleToLongBits(this.m10) >>> 32));
		hash = 13 * hash + (int) (Double.doubleToLongBits(this.m11) ^ (Double.doubleToLongBits(this.m11) >>> 32));
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
		final Matrix2d other = (Matrix2d) obj;
		if (Double.doubleToLongBits(this.m00) != Double.doubleToLongBits(other.m00)) {
			return false;
		}
		if (Double.doubleToLongBits(this.m01) != Double.doubleToLongBits(other.m01)) {
			return false;
		}
		if (Double.doubleToLongBits(this.m10) != Double.doubleToLongBits(other.m10)) {
			return false;
		}
		return Double.doubleToLongBits(this.m11) == Double.doubleToLongBits(other.m11);
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
	public Matrix2d clone() throws CloneNotSupportedException {
		return (Matrix2d) super.clone();
	}
}
