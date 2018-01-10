package org.frost.math.matrix;

import org.frost.math.FastMath;

/**
 * Holds a 3x3 double matrix.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Matrix3d implements SquareMatrix<Matrix3d, Double> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 87676623844819649L;

	/**
	 * Identity matrix.
	 */
	public static final Matrix3d IDENTITY = new ReadOnlyMatrix3d();
	/**
	 * Matrix filled with ones.
	 */
	public static final Matrix3d ONE = new ReadOnlyMatrix3d(1.0f);
	/**
	 * Matrix filled with zeros.
	 */
	public static final Matrix3d ZERO = new ReadOnlyMatrix3d(0.0f);
	/**
	 * Matrix filled with negative ones.
	 */
	public static final Matrix3d NEGATIVE_ONE = new ReadOnlyMatrix3d(-1.0f);

	/**
	 * This matrix value is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption><tr>
	 * <td><b>1</b></td> <td>0</td> <td>0</td></tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td></tr> <tr> <td>0</td> <td>0</td> <td>1</td></table>This value
	 * is the index 0!
	 */
	public double m00;
	/**
	 * This matrix value is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td><b>0</b></td> <td>0</td></tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td></tr> <tr> <td>0</td> <td>0</td> <td>1</td></table>This value
	 * is the index 1!
	 */
	public double m01;
	/**
	 * This matrix value is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption><tr> <td>1</td>
	 * <td>0</td> <td><b>0</b></td></tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td></tr> <tr> <td>0</td> <td>0</td> <td>1</td></table>This value
	 * is the index 2!
	 */
	public double m02;
	/**
	 * This matrix value is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td>0</td></tr> <tr> <td><b>0</b></td> <td>1</td>
	 * <td>0</td></tr> <tr> <td>0</td> <td>0</td> <td>1</td></table>This value
	 * is the index 3!
	 */
	public double m10;
	/**
	 * This matrix value is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td>0</td></tr> <tr> <td>0</td> <td><b>1</b></td>
	 * <td>0</td></tr> <tr> <td>0</td> <td>0</td> <td>1</td></table>This value
	 * is the index 4!
	 */
	public double m11;
	/**
	 * This matrix value is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td>0</td></tr> <tr> <td>0</td> <td>1</td>
	 * <td><b>0</b></td></tr> <tr> <td>0</td> <td>0</td> <td>1</td></table>This
	 * value is the index 5!
	 */
	public double m12;
	/**
	 * This matrix value is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td>0</td></tr> <tr> <td>0</td> <td>1</td> <td>0</td></tr>
	 * <tr> <td><b>0</b></td> <td>0</td> <td>1</td></table>This value has the
	 * index 6!
	 */
	public double m20;
	/**
	 * This matrix value is the bold value in the matrix below.
	 * <table border="1"> <caption>Identity Matrix</caption><tr> <td>1</td>
	 * <td>0</td> <td>0</td></tr> <tr> <td>0</td> <td>1</td> <td>0</td></tr>
	 * <tr> <td>0</td> <td><b>0</b></td> <td>1</td></table>This value has the
	 * index 7!
	 */
	public double m21;
	/**
	 * This matrix value is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td>0</td></tr> <tr> <td>0</td> <td>1</td> <td>0</td></tr>
	 * <tr> <td>0</td> <td>0</td> <td><b>1</b></td></table>This value has the
	 * index 8!
	 */
	public double m22;

	/**
	 * Creates a new 3x3 matrix, which is initialized with the default identity
	 * values.
	 */
	public Matrix3d() {
		m01 = m02 = 0.0f;
		m10 = m12 = 0.0f;
		m20 = m21 = 0.0f;
		m00 = m11 = m22 = 1.0f;
	}

	/**
	 * Creates a new 3x3 matrix and sets all values of the matrix to the given
	 * value.
	 *
	 * @param value Value which all matrix values should have.
	 */
	public Matrix3d(double value) {
		this(value, value, value, value, value, value, value, value, value);
	}

	/**
	 * Creates a new 3x3 matrix with the given values.
	 *
	 * @param m00 Value 1.
	 * @param m01 Value 2.
	 * @param m02 Value 3.
	 * @param m10 Value 4.
	 * @param m11 Value 5.
	 * @param m12 Value 6.
	 * @param m20 Value 7.
	 * @param m21 Value 8.
	 * @param m22 Value 9.
	 */
	public Matrix3d(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22) {
		this.m00 = m00;
		this.m01 = m01;
		this.m02 = m02;
		this.m10 = m10;
		this.m11 = m11;
		this.m12 = m12;
		this.m20 = m20;
		this.m21 = m21;
		this.m22 = m22;
	}

	/**
	 * Creates a new 3x3 matrix from the given matrix. Takes over the matrix
	 * data from the given matrix!
	 *
	 * @param mat Given matrix.
	 */
	public Matrix3d(Matrix3d mat) {
		m00 = mat.m00;
		m01 = mat.m01;
		m02 = mat.m02;
		m10 = mat.m10;
		m11 = mat.m11;
		m12 = mat.m12;
		m20 = mat.m20;
		m21 = mat.m21;
		m22 = mat.m22;
	}

	@Override
	public Matrix3d set(Matrix3d mat) {
		m00 = mat.m00;
		m01 = mat.m01;
		m02 = mat.m02;
		m10 = mat.m10;
		m11 = mat.m11;
		m12 = mat.m12;
		m20 = mat.m20;
		m21 = mat.m21;
		m22 = mat.m22;
		return this;
	}

	/**
	 * Sets the matrix values to the given ones.
	 *
	 * @param m00 Value 1.
	 * @param m01 Value 2.
	 * @param m02 Value 3.
	 * @param m10 Value 4.
	 * @param m11 Value 5.
	 * @param m12 Value 6.
	 * @param m20 Value 7.
	 * @param m21 Value 8.
	 * @param m22 Value 9.
	 * @return This matrix.
	 */
	public Matrix3d set(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22) {
		this.m00 = m00;
		this.m01 = m01;
		this.m02 = m02;
		this.m10 = m10;
		this.m11 = m11;
		this.m12 = m12;
		this.m20 = m20;
		this.m21 = m21;
		this.m22 = m22;
		return this;
	}

	@Override
	public Matrix3d invert() {
		return new Matrix3d(this).invertLocal();
	}

	@Override
	public Matrix3d invertLocal() {
		double determination = determinant();
		if (FastMath.abs(determination) <= 0.0f) {
			return zero();
		}

		double f00 = m11 * m22 - m12 * m21;
		double f01 = m02 * m21 - m01 * m22;
		double f02 = m01 * m12 - m02 * m11;

		double f10 = m12 * m20 - m10 * m22;
		double f11 = m00 * m22 - m02 * m20;
		double f12 = m02 * m10 - m00 * m12;

		double f20 = m10 * m21 - m11 * m20;
		double f21 = m01 * m20 - m00 * m21;
		double f22 = m00 * m11 - m01 * m10;

		set(f00, f01, f02, f10, f11, f12, f20, f21, f22);

		return multiplicateLocal(1.0f / determination);
	}

	@Override
	public Matrix3d adjoint() {
		return new Matrix3d(this).adjointLocal();
	}

	@Override
	public Matrix3d adjointLocal() {
		double temp00 = m11 * m22 - m12 * m21;
		double temp01 = m02 * m21 - m01 * m22;
		double temp02 = m01 * m12 - m02 * m11;
		double temp10 = m12 * m20 - m10 * m22;
		double temp11 = m00 * m22 - m02 * m20;
		double temp12 = m02 * m10 - m00 * m12;
		double temp20 = m10 * m21 - m11 * m20;
		double temp21 = m01 * m20 - m00 * m21;
		double temp22 = m00 * m11 - m01 * m10;
		return set(temp00, temp01, temp02, temp10, temp11, temp12, temp20, temp21, temp22);
	}

	@Override
	public Matrix3d transpose() {
		return new Matrix3d(this).transposeLocal();
	}

	@Override
	public Matrix3d transposeLocal() {
		return set(
				m00, m10, m20,
				m01, m11, m21,
				m02, m12, m22
		);
	}

	@Override
	public Matrix3d identity() {
		m01 = m02 = 0.0f;
		m10 = m12 = 0.0f;
		m20 = m21 = 0.0f;
		m00 = m11 = m22 = 1.0f;
		return this;
	}

	@Override
	public Matrix3d zero() {
		return fill(0.0);
	}

	@Override
	public Matrix3d one() {
		return fill(1.0);
	}

	@Override
	public Matrix3d fill(Double v) {
		m00 = m01 = m02 = v;
		m10 = m11 = m12 = v;
		m20 = m21 = m22 = v;
		return this;
	}

	@Override
	public Matrix3d add(Double v) {
		return new Matrix3d(this).addLocal(v);
	}

	@Override
	public Matrix3d addLocal(Double v) {
		m00 += v;
		m01 += v;
		m02 += v;
		m10 += v;
		m11 += v;
		m12 += v;
		m20 += v;
		m21 += v;
		m22 += v;
		return this;
	}

	@Override
	public Matrix3d add(Matrix3d mat) {
		return new Matrix3d(this).addLocal(mat);
	}

	@Override
	public Matrix3d addLocal(Matrix3d mat) {
		m00 = m00 + mat.m00;
		m01 = m01 + mat.m01;
		m02 = m02 + mat.m02;
		m10 = m10 + mat.m10;
		m11 = m11 + mat.m11;
		m12 = m12 + mat.m12;
		m20 = m20 + mat.m20;
		m21 = m21 + mat.m21;
		m22 = m22 + mat.m22;
		return this;
	}

	@Override
	public Matrix3d subtract(Double v) {
		return new Matrix3d(this).subtractLocal(v);
	}

	@Override
	public Matrix3d subtractLocal(Double scalar) {
		m00 -= scalar;
		m01 -= scalar;
		m02 -= scalar;
		m10 -= scalar;
		m11 -= scalar;
		m12 -= scalar;
		m20 -= scalar;
		m21 -= scalar;
		m22 -= scalar;
		return this;
	}

	@Override
	public Matrix3d subtract(Matrix3d mat) {
		return new Matrix3d(this).subtractLocal(mat);
	}

	@Override
	public Matrix3d subtractLocal(Matrix3d mat) {
		m00 = m00 - mat.m00;
		m01 = m01 - mat.m01;
		m02 = m02 - mat.m02;
		m10 = m10 - mat.m10;
		m11 = m11 - mat.m11;
		m12 = m12 - mat.m12;
		m20 = m20 - mat.m20;
		m21 = m21 - mat.m21;
		m22 = m22 - mat.m22;
		return this;
	}

	@Override
	public Matrix3d multiplicate(Double v) {
		return new Matrix3d(this).multiplicateLocal(v);
	}

	@Override
	public Matrix3d multiplicateLocal(Double scalar) {
		m00 *= scalar;
		m01 *= scalar;
		m02 *= scalar;
		m10 *= scalar;
		m11 *= scalar;
		m12 *= scalar;
		m20 *= scalar;
		m21 *= scalar;
		m22 *= scalar;
		return this;
	}

	@Override
	public Matrix3d multiplicate(Matrix3d mat) {
		return new Matrix3d(this).multiplicateLocal(mat);
	}

	@Override
	public Matrix3d multiplicateLocal(Matrix3d mat) {
		double temp00 = m00 * mat.m00 + m01 * mat.m10 + m02 * mat.m20;
		double temp01 = m00 * mat.m01 + m01 * mat.m11 + m02 * mat.m21;
		double temp02 = m00 * mat.m02 + m01 * mat.m12 + m02 * mat.m22;
		double temp10 = m10 * mat.m00 + m11 * mat.m10 + m12 * mat.m20;
		double temp11 = m10 * mat.m01 + m11 * mat.m11 + m12 * mat.m21;
		double temp12 = m10 * mat.m02 + m11 * mat.m12 + m12 * mat.m22;
		double temp20 = m20 * mat.m00 + m21 * mat.m10 + m22 * mat.m20;
		double temp21 = m20 * mat.m01 + m21 * mat.m11 + m22 * mat.m21;
		double temp22 = m20 * mat.m02 + m21 * mat.m12 + m22 * mat.m22;
		return set(temp00, temp01, temp02, temp10, temp11, temp12, temp20, temp21, temp22);
	}

	@Override
	public Matrix3d divide(Double scalar) {
		return new Matrix3d(this).divideLocal(scalar);
	}

	@Override
	public Matrix3d divideLocal(Double scalar) {
		m00 /= scalar;
		m01 /= scalar;
		m02 /= scalar;
		m10 /= scalar;
		m11 /= scalar;
		m12 /= scalar;
		m20 /= scalar;
		m21 /= scalar;
		m22 /= scalar;
		return this;
	}

	@Override
	public Matrix3d divide(Matrix3d mat) {
		return new Matrix3d(this).divideLocal(mat);
	}

	@Override
	public Matrix3d divideLocal(Matrix3d mat) {
		double temp00 = m00 / mat.m00 + m01 / mat.m10 + m02 / mat.m20;
		double temp01 = m00 / mat.m01 + m01 / mat.m11 + m02 / mat.m21;
		double temp02 = m00 / mat.m02 + m01 / mat.m12 + m02 / mat.m22;
		double temp10 = m10 / mat.m00 + m11 / mat.m10 + m12 / mat.m20;
		double temp11 = m10 / mat.m01 + m11 / mat.m11 + m12 / mat.m21;
		double temp12 = m10 / mat.m02 + m11 / mat.m12 + m12 / mat.m22;
		double temp20 = m20 / mat.m00 + m21 / mat.m10 + m22 / mat.m20;
		double temp21 = m20 / mat.m01 + m21 / mat.m11 + m22 / mat.m21;
		double temp22 = m20 / mat.m02 + m21 / mat.m12 + m22 / mat.m22;
		return set(temp00, temp01, temp02, temp10, temp11, temp12, temp20, temp21, temp22);
	}

	@Override
	public Matrix3d absolute() {
		return new Matrix3d(this).absoluteLocal();
	}

	@Override
	public Matrix3d absoluteLocal() {
		m00 = FastMath.abs(m00);
		m01 = FastMath.abs(m01);
		m02 = FastMath.abs(m02);
		m10 = FastMath.abs(m10);
		m11 = FastMath.abs(m11);
		m12 = FastMath.abs(m12);
		m20 = FastMath.abs(m20);
		m21 = FastMath.abs(m21);
		m22 = FastMath.abs(m22);
		return this;
	}

	@Override
	public int getWidth() {
		return 3;
	}

	@Override
	public int getHeight() {
		return 3;
	}

	@Override
	public Matrix3d put(int i, Double v) {
		switch (i) {
			case 0:
				m00 = v;
				break;
			case 1:
				m01 = v;
				break;
			case 2:
				m02 = v;
				break;
			case 3:
				m10 = v;
				break;
			case 4:
				m11 = v;
				break;
			case 5:
				m12 = v;
				break;
			case 6:
				m20 = v;
				break;
			case 7:
				m21 = v;
				break;
			case 8:
				m22 = v;
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
				return m02;
			case 3:
				return m10;
			case 4:
				return m11;
			case 5:
				return m12;
			case 6:
				return m20;
			case 7:
				return m21;
			case 8:
				return m22;
			default:
				throw new IllegalArgumentException("Parameter is not in range!");
		}
	}

	@Override
	public Matrix3d put(int i, int j, Double v) {
		if (i == 0 && j == 0) {
			m00 = v;
		}
		if (i == 1 && j == 0) {
			m10 = v;
		}
		if (i == 2 && j == 0) {
			m20 = v;
		}
		if (i == 0 && j == 1) {
			m01 = v;
		}
		if (i == 0 && j == 2) {
			m02 = v;
		}
		if (i == 1 && j == 1) {
			m11 = v;
		}
		if (i == 2 && j == 2) {
			m22 = v;
		}
		if (i == 1 && j == 2) {
			m12 = v;
		}
		if (i == 2 && j == 1) {
			m21 = v;
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
		if (i == 2 && j == 0) {
			return m20;
		}
		if (i == 0 && j == 1) {
			return m01;
		}
		if (i == 0 && j == 2) {
			return m02;
		}
		if (i == 1 && j == 1) {
			return m11;
		}
		if (i == 2 && j == 2) {
			return m22;
		}
		if (i == 1 && j == 2) {
			return m12;
		}
		if (i == 2 && j == 1) {
			return m21;
		}

		throw new IllegalArgumentException("Parameters are not in range!");
	}

	@Override
	public Double[] getRow(int i) {
		if (i == 0) {
			return new Double[]{m00, m01, m02};
		}
		if (i == 1) {
			return new Double[]{m10, m11, m12};
		}
		if (i == 2) {
			return new Double[]{m20, m21, m22};
		}

		throw new IllegalArgumentException("Index not in range!");
	}

	@Override
	public Double[] getColumn(int i) {
		if (i == 0) {
			return new Double[]{m00, m10, m20};
		}
		if (i == 1) {
			return new Double[]{m01, m11, m21};
		}
		if (i == 2) {
			return new Double[]{m02, m12, m22};
		}

		throw new IllegalArgumentException("Index not in range!");
	}

	@Override
	public Matrix3d negate() {
		return new Matrix3d(this).negateLocal();
	}

	@Override
	public Matrix3d negateLocal() {
		m00 = -m00;
		m01 = -m01;
		m02 = -m02;
		m10 = -m10;
		m11 = -m11;
		m12 = -m12;
		m20 = -m20;
		m21 = -m21;
		m22 = -m22;
		return this;
	}

	@Override
	public Double determinant() {
		double fCo00 = m11 * m22 - m12 * m21;
		double fCo10 = m12 * m20 - m10 * m22;
		double fCo20 = m10 * m21 - m11 * m20;
		return m00 * fCo00 + m01 * fCo10 + m02 * fCo20;
	}

	@Override
	public boolean isIdentity() {
		return (m00 == 1 && m01 == 0 && m02 == 0)
				&& (m10 == 0 && m11 == 1 && m12 == 0)
				&& (m20 == 0 && m21 == 0 && m22 == 1);
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
		return (m00 == v && m01 == v && m02 == v)
				&& (m10 == v && m11 == v && m12 == v)
				&& (m20 == v && m21 == v && m22 == v);
	}

	@Override
	public void fromArray(Double... array) {
		m00 = array[0];
		m01 = array[1];
		m02 = array[2];
		m10 = array[3];
		m11 = array[4];
		m12 = array[5];
		m20 = array[6];
		m21 = array[7];
		m22 = array[8];
	}

	@Override
	public Double[] toArray() {
		return new Double[]{
			m00, m01, m02,
			m10, m11, m12,
			m20, m21, m22
		};
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m00) ^ (Double.doubleToLongBits(this.m00) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m01) ^ (Double.doubleToLongBits(this.m01) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m02) ^ (Double.doubleToLongBits(this.m02) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m10) ^ (Double.doubleToLongBits(this.m10) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m11) ^ (Double.doubleToLongBits(this.m11) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m12) ^ (Double.doubleToLongBits(this.m12) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m20) ^ (Double.doubleToLongBits(this.m20) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m21) ^ (Double.doubleToLongBits(this.m21) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m22) ^ (Double.doubleToLongBits(this.m22) >>> 32));
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
		final Matrix3d other = (Matrix3d) obj;
		if (Double.doubleToLongBits(this.m00) != Double.doubleToLongBits(other.m00)) {
			return false;
		}
		if (Double.doubleToLongBits(this.m01) != Double.doubleToLongBits(other.m01)) {
			return false;
		}
		if (Double.doubleToLongBits(this.m02) != Double.doubleToLongBits(other.m02)) {
			return false;
		}
		if (Double.doubleToLongBits(this.m10) != Double.doubleToLongBits(other.m10)) {
			return false;
		}
		if (Double.doubleToLongBits(this.m11) != Double.doubleToLongBits(other.m11)) {
			return false;
		}
		if (Double.doubleToLongBits(this.m12) != Double.doubleToLongBits(other.m12)) {
			return false;
		}
		if (Double.doubleToLongBits(this.m20) != Double.doubleToLongBits(other.m20)) {
			return false;
		}
		if (Double.doubleToLongBits(this.m21) != Double.doubleToLongBits(other.m21)) {
			return false;
		}
		return Double.doubleToLongBits(this.m22) == Double.doubleToLongBits(other.m22);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(16);

		result.append(m00);
		result.append(" ");
		result.append(m01);
		result.append(" ");
		result.append(m02);
		result.append("\n");

		result.append(m10);
		result.append(" ");
		result.append(m11);
		result.append(" ");
		result.append(m12);
		result.append("\n");

		result.append(m20);
		result.append(" ");
		result.append(m21);
		result.append(" ");
		result.append(m22);

		return result.toString();
	}

	@Override
	public Matrix3d clone() throws CloneNotSupportedException {
		return (Matrix3d) super.clone();
	}
}
