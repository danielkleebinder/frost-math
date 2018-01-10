package org.frost.math.matrix;

import org.frost.math.FastMath;

/**
 * Holds a 2x2 float matrix.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Matrix2f implements SquareMatrix<Matrix2f, Float> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 786123984862534L;

	/**
	 * Identity matrix.
	 */
	public static final Matrix2f IDENTITY = new ReadOnlyMatrix2f();
	/**
	 * Matrix filled with ones.
	 */
	public static final Matrix2f ONE = new ReadOnlyMatrix2f(1.0f);
	/**
	 * Matrix filled with zeros.
	 */
	public static final Matrix2f ZERO = new ReadOnlyMatrix2f(0.0f);
	/**
	 * Matrix filled with negative ones.
	 */
	public static final Matrix2f NEGATIVE_ONE = new ReadOnlyMatrix2f(-1.0f);

	/**
	 * This matrix value is the bold value in the matrix below.
	 * <table border="1">
	 * <caption>Identity Matrix</caption>
	 * <tr><td><b>1</b></td> <td>0</td></tr>
	 * <tr> <td>0</td> <td>1</td></tr>
	 * </table>This value has the index 0!
	 */
	public float m00;
	/**
	 * This matrix value is the bold value in the matrix below.
	 * <table border="1">
	 * <caption>Identity Matrix</caption>
	 * <tr><td>1</td> <td><b>0</b></td></tr>
	 * <tr> <td>0</td> <td>1</td></tr>
	 * </table>This value has the index 1!
	 */
	public float m01;
	/**
	 * This matrix value is the bold value in the matrix below.
	 * <table border="1">
	 * <caption>Identity Matrix</caption>
	 * <tr><td>1</td> <td>0</td></tr>
	 * <tr><td><b>0</b></td> <td>1</td></tr>
	 * </table>This value has the index 2!
	 */
	public float m10;
	/**
	 * This matrix value is the bold value in the matrix below.
	 * <table border="1">
	 * <caption>Identity Matrix</caption>
	 * <tr><td>1</td> <td>0</td></tr>
	 * <tr> <td>0</td> <td><b>1</b></td></tr>
	 * </table>This value has the index 3!
	 */
	public float m11;

	/**
	 * Creates a new 2x2 matrix, which is initialized with the default identity
	 * values.
	 */
	public Matrix2f() {
		m01 = m10 = 0.0f;
		m00 = m11 = 1.0f;
	}

	/**
	 * Creates a new 2x2 matrix and sets all values of the matrix to the given
	 * value.
	 *
	 * @param value Value which all matrix values should have.
	 */
	public Matrix2f(float value) {
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
	public Matrix2f(float m00, float m01, float m10, float m11) {
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
	public Matrix2f(Matrix2f mat) {
		m00 = mat.m00;
		m01 = mat.m01;
		m10 = mat.m10;
		m11 = mat.m11;
	}

	@Override
	public Matrix2f set(Matrix2f mat) {
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
	public Matrix2f set(float m00, float m01, float m10, float m11) {
		this.m00 = m00;
		this.m01 = m01;
		this.m10 = m10;
		this.m11 = m11;
		return this;
	}

	@Override
	public Matrix2f invert() {
		return new Matrix2f(this).invertLocal();
	}

	@Override
	public Matrix2f invertLocal() {
		float determinant = determinant();
		if (FastMath.abs(determinant) <= 0.0f) {
			return zero();
		}

		float f00 = m11;
		float f11 = m00;

		float f01 = -m01;
		float f10 = -m10;

		set(f00, f01, f10, f11);
		return multiplicateLocal(1.0f / determinant);
	}

	@Override
	public Matrix2f adjoint() {
		return new Matrix2f(this).adjointLocal();
	}

	@Override
	public Matrix2f adjointLocal() {
		float f00 = m11;
		float f11 = m00;
		float f01 = -m01;
		float f10 = -m10;
		return set(f00, f01, f10, f11);
	}

	@Override
	public Matrix2f transpose() {
		return new Matrix2f(this).transposeLocal();
	}

	@Override
	public Matrix2f transposeLocal() {
		return set(
				m00, m10,
				m01, m11
		);
	}

	@Override
	public Matrix2f identity() {
		m01 = m10 = 0.0f;
		m00 = m11 = 1.0f;
		return this;
	}

	@Override
	public Matrix2f zero() {
		return fill(0.0f);
	}

	@Override
	public Matrix2f one() {
		return fill(1.0f);
	}

	@Override
	public Matrix2f fill(Float v) {
		m00 = m01 = v;
		m10 = m11 = v;
		return this;
	}

	@Override
	public Matrix2f add(Float v) {
		return new Matrix2f(this).addLocal(v);
	}

	@Override
	public Matrix2f addLocal(Float v) {
		m00 += v;
		m01 += v;
		m10 += v;
		m11 += v;
		return this;
	}

	@Override
	public Matrix2f add(Matrix2f mat) {
		return new Matrix2f(this).addLocal(mat);
	}

	@Override
	public Matrix2f addLocal(Matrix2f mat) {
		m00 = m00 + mat.m00;
		m01 = m01 + mat.m01;
		m10 = m10 + mat.m10;
		m11 = m11 + mat.m11;
		return this;
	}

	@Override
	public Matrix2f subtract(Float v) {
		return new Matrix2f(this).subtractLocal(v);
	}

	@Override
	public Matrix2f subtractLocal(Float scalar) {
		m00 -= scalar;
		m01 -= scalar;
		m10 -= scalar;
		m11 -= scalar;
		return this;
	}

	@Override
	public Matrix2f subtract(Matrix2f mat) {
		return new Matrix2f(this).subtractLocal(mat);
	}

	@Override
	public Matrix2f subtractLocal(Matrix2f mat) {
		m00 = m00 - mat.m00;
		m01 = m01 - mat.m01;
		m10 = m10 - mat.m10;
		m11 = m11 - mat.m11;
		return this;
	}

	@Override
	public Matrix2f multiplicate(Float v) {
		return new Matrix2f(this).multiplicateLocal(v);
	}

	@Override
	public Matrix2f multiplicateLocal(Float scalar) {
		m00 *= scalar;
		m01 *= scalar;
		m10 *= scalar;
		m11 *= scalar;
		return this;
	}

	@Override
	public Matrix2f multiplicate(Matrix2f mat) {
		return new Matrix2f(this).multiplicateLocal(mat);
	}

	@Override
	public Matrix2f multiplicateLocal(Matrix2f mat) {
		float temp00 = m00 * mat.m00 + m01 * mat.m10;
		float temp01 = m00 * mat.m01 + m01 * mat.m11;
		float temp10 = m10 * mat.m00 + m11 * mat.m10;
		float temp11 = m10 * mat.m01 + m11 * mat.m11;
		return set(temp00, temp01, temp10, temp11);
	}

	@Override
	public Matrix2f divide(Float scalar) {
		return new Matrix2f(this).divideLocal(scalar);
	}

	@Override
	public Matrix2f divideLocal(Float scalar) {
		m00 /= scalar;
		m01 /= scalar;
		m10 /= scalar;
		m11 /= scalar;
		return this;
	}

	@Override
	public Matrix2f divide(Matrix2f mat) {
		return new Matrix2f(this).divideLocal(mat);
	}

	@Override
	public Matrix2f divideLocal(Matrix2f mat) {
		float temp00 = m00 / mat.m00 + m01 / mat.m10;
		float temp01 = m00 / mat.m01 + m01 / mat.m11;
		float temp10 = m10 / mat.m00 + m11 / mat.m10;
		float temp11 = m10 / mat.m01 + m11 / mat.m11;
		return set(temp00, temp01, temp10, temp11);
	}

	@Override
	public Matrix2f absolute() {
		return new Matrix2f(this).absoluteLocal();
	}

	@Override
	public Matrix2f absoluteLocal() {
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
	public Matrix2f put(int i, Float v) {
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
	public Float get(int i) {
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
	public Matrix2f put(int i, int j, Float v) {
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
	public Float get(int i, int j) {
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
	public Float[] getRow(int i) {
		if (i == 0) {
			return new Float[]{m00, m01};
		}
		if (i == 1) {
			return new Float[]{m10, m11};
		}

		throw new IllegalArgumentException("Index not in range!");
	}

	@Override
	public Float[] getColumn(int i) {
		if (i == 0) {
			return new Float[]{m00, m10};
		}
		if (i == 1) {
			return new Float[]{m01, m11};
		}

		throw new IllegalArgumentException("Index not in range!");
	}

	@Override
	public Matrix2f negate() {
		return new Matrix2f(this).negateLocal();
	}

	@Override
	public Matrix2f negateLocal() {
		m00 = -m00;
		m01 = -m01;
		m10 = -m10;
		m11 = -m11;
		return this;
	}

	@Override
	public Float determinant() {
		return m00 * m11 - m01 * m10;
	}

	@Override
	public boolean isIdentity() {
		return (m00 == 1 && m11 == 1 && m01 == 0 && m10 == 0);
	}

	@Override
	public boolean isZero() {
		return isUnified(0.0f);
	}

	@Override
	public boolean isOne() {
		return isUnified(1.0f);
	}

	@Override
	public boolean isUnified(Float v) {
		return (m00 == v && m11 == v && m01 == v && m10 == v);
	}

	@Override
	public void fromArray(Float... array) {
		m00 = array[0];
		m01 = array[1];
		m10 = array[3];
		m11 = array[4];
	}

	@Override
	public Float[] toArray() {
		return new Float[]{
			m00, m01,
			m10, m11
		};
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 29 * hash + Float.floatToIntBits(this.m00);
		hash = 29 * hash + Float.floatToIntBits(this.m01);
		hash = 29 * hash + Float.floatToIntBits(this.m10);
		hash = 29 * hash + Float.floatToIntBits(this.m11);
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
		final Matrix2f other = (Matrix2f) obj;
		if (Float.floatToIntBits(this.m00) != Float.floatToIntBits(other.m00)) {
			return false;
		}
		if (Float.floatToIntBits(this.m01) != Float.floatToIntBits(other.m01)) {
			return false;
		}
		if (Float.floatToIntBits(this.m10) != Float.floatToIntBits(other.m10)) {
			return false;
		}
		return Float.floatToIntBits(this.m11) == Float.floatToIntBits(other.m11);
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
	public Matrix2f clone() throws CloneNotSupportedException {
		return (Matrix2f) super.clone();
	}
}
