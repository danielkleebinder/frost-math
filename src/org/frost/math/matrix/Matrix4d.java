package org.frost.math.matrix;

import org.frost.math.FastMath;

/**
 * Holds a 4x4 double matrix.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Matrix4d implements SquareMatrix<Matrix4d, Double> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 78951854765134L;

	/**
	 * Identity matrix.
	 */
	public static final Matrix4d IDENTITY = new ReadOnlyMatrix4d();
	/**
	 * Matrix filled with zeros.
	 */
	public static final Matrix4d ZERO = new ReadOnlyMatrix4d(0.0f);
	/**
	 * Matrix filled with ones.
	 */
	public static final Matrix4d ONE = new ReadOnlyMatrix4d(1.0f);
	/**
	 * Matrix filled with negative ones.
	 */
	public static final Matrix4d NEGATIVE_ONE = new ReadOnlyMatrix4d(-1.0f);

	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr>
	 * <td><b>1</b></td> <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td>
	 * <td>1</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td>
	 * <td>1</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td>
	 * <td>1</td> </tr> </table>This value is the index 0!
	 */
	public double m00;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td><b>0</b></td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td>1</td> </tr>
	 * </table>This value is the index 1!
	 */
	public double m01;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td><b>0</b></td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td>1</td> </tr>
	 * </table>This value is the index 2!
	 */
	public double m02;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td><b>0</b></td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td>1</td> </tr>
	 * </table>This value is the index 3!
	 */
	public double m03;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"> <caption>Identity Matrix</caption><tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td><b>0</b></td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td>1</td> </tr>
	 * </table>This value is the index 4!
	 */
	public double m10;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"> <caption>Identity Matrix</caption><tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td><b>1</b></td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td>1</td> </tr>
	 * </table>This value is the index 5!
	 */
	public double m11;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td><b>0</b></td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td>1</td> </tr>
	 * </table>This value is the index 6!
	 */
	public double m12;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td><b>0</b></td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td>1</td> </tr>
	 * </table>This value is the index 7!
	 */
	public double m13;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td><b>0</b></td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td>1</td> </tr>
	 * </table>This value is the index 8!
	 */
	public double m20;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"> <caption>Identity Matrix</caption><tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td><b>0</b></td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td>1</td> </tr>
	 * </table>This value is the index 9!
	 */
	public double m21;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td><b>1</b></td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td>1</td> </tr>
	 * </table>This value is the index 10!
	 */
	public double m22;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td><b>0</b></td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td>1</td>
	 * </tr> </table>This value is the index 11!
	 */
	public double m23;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td><b>0</b></td> <td>0</td> <td>0</td> <td>1</td>
	 * </tr> </table>This value is the index 12!
	 */
	public double m30;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td><b>0</b></td> <td>0</td> <td>1</td>
	 * </tr> </table>This value is the index 13!
	 */
	public double m31;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"> <caption>Identity Matrix</caption><tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td><b>0</b></td> <td>1</td>
	 * </tr> </table>This value is the index 14!
	 */
	public double m32;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"> <caption>Identity Matrix</caption><tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td><b>1</b></td>
	 * </tr> </table>This value is the index 15!
	 */
	public double m33;

	/**
	 * Creates a new 4x4 matrix, which is initialized with the default identity
	 * values.
	 */
	public Matrix4d() {
		m01 = m02 = m03 = 0.0f;
		m10 = m12 = m13 = 0.0f;
		m20 = m21 = m23 = 0.0f;
		m30 = m31 = m32 = 0.0f;
		m00 = m11 = m22 = m33 = 1.0f;
	}

	/**
	 * Creates a new 4x4 matrix and sets all values of the matrix to the given
	 * value.
	 *
	 * @param value Value which all matrix values should have.
	 */
	public Matrix4d(double value) {
		this(value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value);
	}

	/**
	 * Creates a new 4x4 matrix with the given values.
	 *
	 * @param m00 Value 1.
	 * @param m01 Value 2.
	 * @param m02 Value 3.
	 * @param m03 Value 4.
	 * @param m10 Value 5.
	 * @param m11 Value 6.
	 * @param m12 Value 7.
	 * @param m13 Value 8.
	 * @param m20 Value 9.
	 * @param m21 Value 10.
	 * @param m22 Value 11.
	 * @param m23 Value 12.
	 * @param m30 Value 13.
	 * @param m31 Value 14.
	 * @param m32 Value 15.
	 * @param m33 Value 16.
	 */
	public Matrix4d(double m00, double m01, double m02, double m03, double m10, double m11, double m12, double m13, double m20, double m21, double m22, double m23, double m30, double m31, double m32, double m33) {
		this.m00 = m00;
		this.m01 = m01;
		this.m02 = m02;
		this.m03 = m03;
		this.m10 = m10;
		this.m11 = m11;
		this.m12 = m12;
		this.m13 = m13;
		this.m20 = m20;
		this.m21 = m21;
		this.m22 = m22;
		this.m23 = m23;
		this.m30 = m30;
		this.m31 = m31;
		this.m32 = m32;
		this.m33 = m33;
	}

	/**
	 * Creates a new 4x4 matrix from the given matrix. Takes the matrix data
	 * from the given matrix!
	 *
	 * @param mat Given matrix.
	 */
	public Matrix4d(Matrix4d mat) {
		m00 = mat.m00;
		m01 = mat.m01;
		m02 = mat.m02;
		m03 = mat.m03;
		m10 = mat.m10;
		m11 = mat.m11;
		m12 = mat.m12;
		m13 = mat.m13;
		m20 = mat.m20;
		m21 = mat.m21;
		m22 = mat.m22;
		m23 = mat.m23;
		m30 = mat.m30;
		m31 = mat.m31;
		m32 = mat.m32;
		m33 = mat.m33;
	}

	/**
	 * Sets the matrix values to the given ones.
	 *
	 * @param m00 Value 1.
	 * @param m01 Value 2.
	 * @param m02 Value 3.
	 * @param m03 Value 4.
	 * @param m10 Value 5.
	 * @param m11 Value 6.
	 * @param m12 Value 7.
	 * @param m13 Value 8.
	 * @param m20 Value 9.
	 * @param m21 Value 10.
	 * @param m22 Value 11.
	 * @param m23 Value 12.
	 * @param m30 Value 13.
	 * @param m31 Value 14.
	 * @param m32 Value 15.
	 * @param m33 Value 16.
	 * @return This matrix.
	 */
	public Matrix4d set(double m00, double m01, double m02, double m03, double m10, double m11, double m12, double m13, double m20, double m21, double m22, double m23, double m30, double m31, double m32, double m33) {
		this.m00 = m00;
		this.m01 = m01;
		this.m02 = m02;
		this.m03 = m03;
		this.m10 = m10;
		this.m11 = m11;
		this.m12 = m12;
		this.m13 = m13;
		this.m20 = m20;
		this.m21 = m21;
		this.m22 = m22;
		this.m23 = m23;
		this.m30 = m30;
		this.m31 = m31;
		this.m32 = m32;
		this.m33 = m33;
		return this;
	}

	@Override
	public Matrix4d invert() {
		return new Matrix4d(this).invertLocal();
	}

	@Override
	public Matrix4d invertLocal() {
		double fA0 = m00 * m11 - m01 * m10;
		double fA1 = m00 * m12 - m02 * m10;
		double fA2 = m00 * m13 - m03 * m10;
		double fA3 = m01 * m12 - m02 * m11;
		double fA4 = m01 * m13 - m03 * m11;
		double fA5 = m02 * m13 - m03 * m12;
		double fB0 = m20 * m31 - m21 * m30;
		double fB1 = m20 * m32 - m22 * m30;
		double fB2 = m20 * m33 - m23 * m30;
		double fB3 = m21 * m32 - m22 * m31;
		double fB4 = m21 * m33 - m23 * m31;
		double fB5 = m22 * m33 - m23 * m32;

		double determination = fA0 * fB5 - fA1 * fB4 + fA2 * fB3 + fA3 * fB2 - fA4 * fB1 + fA5 * fB0;

		if (FastMath.abs(determination) <= 0.0f) {
			return zero();
		}

		double f00 = +m11 * fB5 - m12 * fB4 + m13 * fB3;
		double f10 = -m10 * fB5 + m12 * fB2 - m13 * fB1;
		double f20 = +m10 * fB4 - m11 * fB2 + m13 * fB0;
		double f30 = -m10 * fB3 + m11 * fB1 - m12 * fB0;
		double f01 = -m01 * fB5 + m02 * fB4 - m03 * fB3;
		double f11 = +m00 * fB5 - m02 * fB2 + m03 * fB1;
		double f21 = -m00 * fB4 + m01 * fB2 - m03 * fB0;
		double f31 = +m00 * fB3 - m01 * fB1 + m02 * fB0;
		double f02 = +m31 * fA5 - m32 * fA4 + m33 * fA3;
		double f12 = -m30 * fA5 + m32 * fA2 - m33 * fA1;
		double f22 = +m30 * fA4 - m31 * fA2 + m33 * fA0;
		double f32 = -m30 * fA3 + m31 * fA1 - m32 * fA0;
		double f03 = -m21 * fA5 + m22 * fA4 - m23 * fA3;
		double f13 = +m20 * fA5 - m22 * fA2 + m23 * fA1;
		double f23 = -m20 * fA4 + m21 * fA2 - m23 * fA0;
		double f33 = +m20 * fA3 - m21 * fA1 + m22 * fA0;

		set(f00, f01, f02, f03, f10, f11, f12, f13, f20, f21, f22, f23, f30, f31, f32, f33);
		return multiplicateLocal(1.0f / determination);
	}

	@Override
	public Matrix4d adjoint() {
		return new Matrix4d(this).adjointLocal();
	}

	@Override
	public Matrix4d adjointLocal() {
		double fA0 = m00 * m11 - m01 * m10;
		double fA1 = m00 * m12 - m02 * m10;
		double fA2 = m00 * m13 - m03 * m10;
		double fA3 = m01 * m12 - m02 * m11;
		double fA4 = m01 * m13 - m03 * m11;
		double fA5 = m02 * m13 - m03 * m12;
		double fB0 = m20 * m31 - m21 * m30;
		double fB1 = m20 * m32 - m22 * m30;
		double fB2 = m20 * m33 - m23 * m30;
		double fB3 = m21 * m32 - m22 * m31;
		double fB4 = m21 * m33 - m23 * m31;
		double fB5 = m22 * m33 - m23 * m32;

		double f00 = +m11 * fB5 - m12 * fB4 + m13 * fB3;
		double f10 = -m10 * fB5 + m12 * fB2 - m13 * fB1;
		double f20 = +m10 * fB4 - m11 * fB2 + m13 * fB0;
		double f30 = -m10 * fB3 + m11 * fB1 - m12 * fB0;
		double f01 = -m01 * fB5 + m02 * fB4 - m03 * fB3;
		double f11 = +m00 * fB5 - m02 * fB2 + m03 * fB1;
		double f21 = -m00 * fB4 + m01 * fB2 - m03 * fB0;
		double f31 = +m00 * fB3 - m01 * fB1 + m02 * fB0;
		double f02 = +m31 * fA5 - m32 * fA4 + m33 * fA3;
		double f12 = -m30 * fA5 + m32 * fA2 - m33 * fA1;
		double f22 = +m30 * fA4 - m31 * fA2 + m33 * fA0;
		double f32 = -m30 * fA3 + m31 * fA1 - m32 * fA0;
		double f03 = -m21 * fA5 + m22 * fA4 - m23 * fA3;
		double f13 = +m20 * fA5 - m22 * fA2 + m23 * fA1;
		double f23 = -m20 * fA4 + m21 * fA2 - m23 * fA0;
		double f33 = +m20 * fA3 - m21 * fA1 + m22 * fA0;

		return set(f00, f01, f02, f03, f10, f11, f12, f13, f20, f21, f22, f23, f30, f31, f32, f33);
	}

	@Override
	public Matrix4d transpose() {
		return new Matrix4d(this).transposeLocal();
	}

	@Override
	public Matrix4d transposeLocal() {
		return set(
				m00, m10, m20, m30,
				m01, m11, m21, m31,
				m02, m12, m22, m32,
				m03, m13, m23, m33
		);
	}

	@Override
	public Matrix4d set(Matrix4d mat) {
		m00 = mat.m00;
		m01 = mat.m01;
		m02 = mat.m02;
		m03 = mat.m03;
		m10 = mat.m10;
		m11 = mat.m11;
		m12 = mat.m12;
		m13 = mat.m13;
		m20 = mat.m20;
		m21 = mat.m21;
		m22 = mat.m22;
		m23 = mat.m23;
		m30 = mat.m30;
		m31 = mat.m31;
		m32 = mat.m32;
		m33 = mat.m33;
		return this;
	}

	@Override
	public Matrix4d identity() {
		m01 = m02 = m03 = 0.0f;
		m10 = m12 = m13 = 0.0f;
		m20 = m21 = m23 = 0.0f;
		m30 = m31 = m32 = 0.0f;
		m00 = m11 = m22 = m33 = 1.0f;
		return this;
	}

	@Override
	public Matrix4d zero() {
		return fill(0.0);
	}

	@Override
	public Matrix4d one() {
		return fill(1.0);
	}

	@Override
	public Matrix4d fill(Double v) {
		m00 = m01 = m02 = m03 = v;
		m10 = m11 = m12 = m13 = v;
		m20 = m21 = m22 = m23 = v;
		m30 = m31 = m32 = m33 = v;
		return this;
	}

	@Override
	public Matrix4d add(Double v) {
		return new Matrix4d(this).addLocal(v);
	}

	@Override
	public Matrix4d addLocal(Double v) {
		m00 += v;
		m01 += v;
		m02 += v;
		m03 += v;
		m10 += v;
		m11 += v;
		m12 += v;
		m13 += v;
		m20 += v;
		m21 += v;
		m22 += v;
		m23 += v;
		m30 += v;
		m31 += v;
		m32 += v;
		m33 += v;
		return this;
	}

	@Override
	public Matrix4d add(Matrix4d mat) {
		return new Matrix4d(this).addLocal(mat);
	}

	@Override
	public Matrix4d addLocal(Matrix4d mat) {
		m00 += mat.m00;
		m01 += mat.m01;
		m02 += mat.m02;
		m03 += mat.m03;
		m10 += mat.m10;
		m11 += mat.m11;
		m12 += mat.m12;
		m13 += mat.m13;
		m20 += mat.m20;
		m21 += mat.m21;
		m22 += mat.m22;
		m23 += mat.m23;
		m30 += mat.m30;
		m31 += mat.m31;
		m32 += mat.m32;
		m33 += mat.m33;
		return this;
	}

	@Override
	public Matrix4d subtract(Double v) {
		return new Matrix4d(this).subtractLocal(v);
	}

	@Override
	public Matrix4d subtractLocal(Double v) {
		m00 += v;
		m01 += v;
		m02 += v;
		m03 += v;
		m10 += v;
		m11 += v;
		m12 += v;
		m13 += v;
		m20 += v;
		m21 += v;
		m22 += v;
		m23 += v;
		m30 += v;
		m31 += v;
		m32 += v;
		m33 += v;
		return this;
	}

	@Override
	public Matrix4d subtract(Matrix4d mat) {
		return new Matrix4d(this).subtractLocal(mat);
	}

	@Override
	public Matrix4d subtractLocal(Matrix4d mat) {
		m00 -= mat.m00;
		m01 -= mat.m01;
		m02 -= mat.m02;
		m03 -= mat.m03;
		m10 -= mat.m10;
		m11 -= mat.m11;
		m12 -= mat.m12;
		m13 -= mat.m13;
		m20 -= mat.m20;
		m21 -= mat.m21;
		m22 -= mat.m22;
		m23 -= mat.m23;
		m30 -= mat.m30;
		m31 -= mat.m31;
		m32 -= mat.m32;
		m33 -= mat.m33;
		return this;
	}

	@Override
	public Matrix4d multiplicate(Double v) {
		return new Matrix4d(this).multiplicateLocal(v);
	}

	@Override
	public Matrix4d multiplicateLocal(Double scalar) {
		m00 *= scalar;
		m01 *= scalar;
		m02 *= scalar;
		m03 *= scalar;
		m10 *= scalar;
		m11 *= scalar;
		m12 *= scalar;
		m13 *= scalar;
		m20 *= scalar;
		m21 *= scalar;
		m22 *= scalar;
		m23 *= scalar;
		m30 *= scalar;
		m31 *= scalar;
		m32 *= scalar;
		m33 *= scalar;
		return this;
	}

	@Override
	public Matrix4d multiplicate(Matrix4d mat) {
		return new Matrix4d(this).multiplicateLocal(mat);
	}

	@Override
	public Matrix4d multiplicateLocal(Matrix4d mat) {
		double temp00 = m00 * mat.m00 + m10 * mat.m01 + m20 * mat.m02 + m30 * mat.m03;
		double temp01 = m01 * mat.m00 + m11 * mat.m01 + m21 * mat.m02 + m31 * mat.m03;
		double temp02 = m02 * mat.m00 + m12 * mat.m01 + m22 * mat.m02 + m32 * mat.m03;
		double temp03 = m03 * mat.m00 + m13 * mat.m01 + m23 * mat.m02 + m33 * mat.m03;
		double temp10 = m00 * mat.m10 + m10 * mat.m11 + m20 * mat.m12 + m30 * mat.m13;
		double temp11 = m01 * mat.m10 + m11 * mat.m11 + m21 * mat.m12 + m31 * mat.m13;
		double temp12 = m02 * mat.m10 + m12 * mat.m11 + m22 * mat.m12 + m32 * mat.m13;
		double temp13 = m03 * mat.m10 + m13 * mat.m11 + m23 * mat.m12 + m33 * mat.m13;
		double temp20 = m00 * mat.m20 + m10 * mat.m21 + m20 * mat.m22 + m30 * mat.m23;
		double temp21 = m01 * mat.m20 + m11 * mat.m21 + m21 * mat.m22 + m31 * mat.m23;
		double temp22 = m02 * mat.m20 + m12 * mat.m21 + m22 * mat.m22 + m32 * mat.m23;
		double temp23 = m03 * mat.m20 + m13 * mat.m21 + m23 * mat.m22 + m33 * mat.m23;
		double temp30 = m00 * mat.m30 + m10 * mat.m31 + m20 * mat.m32 + m30 * mat.m33;
		double temp31 = m01 * mat.m30 + m11 * mat.m31 + m21 * mat.m32 + m31 * mat.m33;
		double temp32 = m02 * mat.m30 + m12 * mat.m31 + m22 * mat.m32 + m32 * mat.m33;
		double temp33 = m03 * mat.m30 + m13 * mat.m31 + m23 * mat.m32 + m33 * mat.m33;
		return set(temp00, temp01, temp02, temp03, temp10, temp11, temp12, temp13, temp20, temp21, temp22, temp23, temp30, temp31, temp32, temp33);
	}

	@Override
	public Matrix4d divide(Double scalar) {
		return new Matrix4d(this).divideLocal(scalar);
	}

	@Override
	public Matrix4d divideLocal(Double scalar) {
		m00 /= scalar;
		m01 /= scalar;
		m02 /= scalar;
		m03 /= scalar;
		m10 /= scalar;
		m11 /= scalar;
		m12 /= scalar;
		m13 /= scalar;
		m20 /= scalar;
		m21 /= scalar;
		m22 /= scalar;
		m23 /= scalar;
		m30 /= scalar;
		m31 /= scalar;
		m32 /= scalar;
		m33 /= scalar;
		return this;
	}

	@Override
	public Matrix4d divide(Matrix4d mat) {
		return new Matrix4d(this).divideLocal(mat);
	}

	@Override
	public Matrix4d divideLocal(Matrix4d mat) {
		double temp00 = m00 / mat.m00 + m10 / mat.m01 + m20 / mat.m02 + m30 / mat.m03;
		double temp01 = m01 / mat.m00 + m11 / mat.m01 + m21 / mat.m02 + m31 / mat.m03;
		double temp02 = m02 / mat.m00 + m12 / mat.m01 + m22 / mat.m02 + m32 / mat.m03;
		double temp03 = m03 / mat.m00 + m13 / mat.m01 + m23 / mat.m02 + m33 / mat.m03;
		double temp10 = m00 / mat.m10 + m10 / mat.m11 + m20 / mat.m12 + m30 / mat.m13;
		double temp11 = m01 / mat.m10 + m11 / mat.m11 + m21 / mat.m12 + m31 / mat.m13;
		double temp12 = m02 / mat.m10 + m12 / mat.m11 + m22 / mat.m12 + m32 / mat.m13;
		double temp13 = m03 / mat.m10 + m13 / mat.m11 + m23 / mat.m12 + m33 / mat.m13;
		double temp20 = m00 / mat.m20 + m10 / mat.m21 + m20 / mat.m22 + m30 / mat.m23;
		double temp21 = m01 / mat.m20 + m11 / mat.m21 + m21 / mat.m22 + m31 / mat.m23;
		double temp22 = m02 / mat.m20 + m12 / mat.m21 + m22 / mat.m22 + m32 / mat.m23;
		double temp23 = m03 / mat.m20 + m13 / mat.m21 + m23 / mat.m22 + m33 / mat.m23;
		double temp30 = m00 / mat.m30 + m10 / mat.m31 + m20 / mat.m32 + m30 / mat.m33;
		double temp31 = m01 / mat.m30 + m11 / mat.m31 + m21 / mat.m32 + m31 / mat.m33;
		double temp32 = m02 / mat.m30 + m12 / mat.m31 + m22 / mat.m32 + m32 / mat.m33;
		double temp33 = m03 / mat.m30 + m13 / mat.m31 + m23 / mat.m32 + m33 / mat.m33;
		return set(temp00, temp01, temp02, temp03, temp10, temp11, temp12, temp13, temp20, temp21, temp22, temp23, temp30, temp31, temp32, temp33);
	}

	@Override
	public Matrix4d absolute() {
		return new Matrix4d(this).absoluteLocal();
	}

	@Override
	public Matrix4d absoluteLocal() {
		m00 = FastMath.abs(m00);
		m01 = FastMath.abs(m01);
		m02 = FastMath.abs(m02);
		m03 = FastMath.abs(m03);
		m10 = FastMath.abs(m10);
		m11 = FastMath.abs(m11);
		m12 = FastMath.abs(m12);
		m13 = FastMath.abs(m13);
		m20 = FastMath.abs(m20);
		m21 = FastMath.abs(m21);
		m22 = FastMath.abs(m22);
		m23 = FastMath.abs(m23);
		m30 = FastMath.abs(m30);
		m31 = FastMath.abs(m31);
		m32 = FastMath.abs(m32);
		m33 = FastMath.abs(m33);
		return this;
	}

	/**
	 * Creates a new matrix with the same values as this one and scales the
	 * first row of the matrix by <code>x</code>, the second one by
	 * <code>y</code> and the third row by <code>z</code>.
	 *
	 * @param x X scale factor.
	 * @param y Y scale factor.
	 * @param z Z scale factor.
	 * @return New matrix.
	 */
	public Matrix4d scale(double x, double y, double z) {
		return new Matrix4d(this).scaleLocal(x, y, z);
	}

	/**
	 * Scales the first row of this matrix by <code>x</code>, the second one by
	 * <code>y</code> and the third row by <code>z</code>.
	 *
	 * @param x X scale factor.
	 * @param y Y scale factor.
	 * @param z Z scale factor.
	 * @return This.
	 */
	public Matrix4d scaleLocal(double x, double y, double z) {
		m00 *= x;
		m01 *= x;
		m02 *= x;
		m03 *= x;
		m10 *= y;
		m11 *= y;
		m12 *= y;
		m13 *= y;
		m20 *= z;
		m21 *= z;
		m22 *= z;
		m23 *= z;
		return this;
	}

	/**
	 * Creates a new matrix with the same values as this one and translates it
	 * by the given x, y and z coordinates.
	 *
	 * @param x X coordinate.
	 * @param y Y coordinate.
	 * @param z Z coordinate.
	 * @return New matrix.
	 */
	public Matrix4d translate(double x, double y, double z) {
		return new Matrix4d(this).translateLocal(x, y, z);
	}

	/**
	 * Translates this matrix by the given x, y and z coordinates.
	 *
	 * @param x X coordinate.
	 * @param y Y coordinate.
	 * @param z Z coordinate.
	 * @return This.
	 */
	public Matrix4d translateLocal(double x, double y, double z) {
		m30 += m00 * x + m10 * y + m20 * z;
		m31 += m01 * x + m11 * y + m21 * z;
		m32 += m02 * x + m12 * y + m22 * z;
		m33 += m03 * x + m13 * y + m23 * z;
		return this;
	}

	/**
	 * Rotates this matrix for the given angle around the given axis.
	 * <br/>
	 * A new matrix will be created and returned. This one will not get
	 * modified.
	 *
	 * @param angle Angle in degrees.
	 * @param xw X delte (Between -1.0 and 1.0).
	 * @param yw Y delte (Between -1.0 and 1.0).
	 * @param zw Z delte (Between -1.0 and 1.0).
	 * @return New matrix.
	 */
	public Matrix4d rotate(float angle, float xw, float yw, float zw) {
		return new Matrix4d(this).rotateLocal(angle, xw, yw, zw);
	}

	/**
	 * Rotates this matrix for the given angle around the given axis.
	 *
	 * @param angle Angle in degrees.
	 * @param xw X delte (Between -1.0 and 1.0).
	 * @param yw Y delte (Between -1.0 and 1.0).
	 * @param zw Z delte (Between -1.0 and 1.0).
	 * @return This.
	 */
	public Matrix4d rotateLocal(double angle, double xw, double yw, double zw) {
		double a = FastMath.toRadians(angle);
		double c = FastMath.cos(a);
		double s = FastMath.sin(a);

		double length = xw * xw + yw * yw + zw * zw;
		if (length != 1.0 && length != 0.0) {
			length = 1.0 / FastMath.sqrt(length);
			xw *= length;
			yw *= length;
			zw *= length;
		}
		double tx = xw * (1.0 - c);
		double ty = yw * (1.0 - c);
		double tz = zw * (1.0 - c);

		Matrix4d rotate = new Matrix4d();

		rotate.m00 = c + tx * xw;
		rotate.m01 = 0 + tx * yw + s * zw;
		rotate.m02 = 0 + tx * zw - s * yw;

		rotate.m10 = 0 + ty * xw - s * zw;
		rotate.m11 = c + ty * yw;
		rotate.m12 = 0 + ty * zw + s * xw;

		rotate.m20 = 0 + tz * xw + s * yw;
		rotate.m21 = 0 + tz * yw - s * xw;
		rotate.m22 = c + tz * zw;

		return multiplicateLocal(rotate);
	}

	@Override
	public int getWidth() {
		return 4;
	}

	@Override
	public int getHeight() {
		return 4;
	}

	@Override
	public Matrix4d put(int i, Double v) {
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
				m03 = v;
				break;
			case 4:
				m10 = v;
				break;
			case 5:
				m11 = v;
				break;
			case 6:
				m12 = v;
				break;
			case 7:
				m13 = v;
				break;
			case 8:
				m20 = v;
				break;
			case 9:
				m21 = v;
				break;
			case 10:
				m22 = v;
				break;
			case 11:
				m23 = v;
				break;
			case 12:
				m30 = v;
				break;
			case 13:
				m31 = v;
				break;
			case 14:
				m32 = v;
				break;
			case 15:
				m33 = v;
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
				return m03;
			case 4:
				return m10;
			case 5:
				return m11;
			case 6:
				return m12;
			case 7:
				return m13;
			case 8:
				return m20;
			case 9:
				return m21;
			case 10:
				return m22;
			case 11:
				return m23;
			case 12:
				return m30;
			case 13:
				return m31;
			case 14:
				return m32;
			case 15:
				return m33;
			default:
				throw new IllegalArgumentException("Parameter is not in range!");
		}
	}

	@Override
	public Matrix4d put(int i, int j, Double v) {
		if (i == 0 && j == 0) {
			m00 = v;
		}
		if (i == 1 && j == 0) {
			m10 = v;
		}
		if (i == 2 && j == 0) {
			m20 = v;
		}
		if (i == 3 && j == 0) {
			m30 = v;
		}
		if (i == 0 && j == 1) {
			m01 = v;
		}
		if (i == 0 && j == 2) {
			m02 = v;
		}
		if (i == 0 && j == 3) {
			m03 = v;
		}
		if (i == 1 && j == 1) {
			m11 = v;
		}
		if (i == 2 && j == 2) {
			m22 = v;
		}
		if (i == 3 && j == 3) {
			m33 = v;
		}
		if (i == 1 && j == 2) {
			m12 = v;
		}
		if (i == 1 && j == 3) {
			m13 = v;
		}
		if (i == 2 && j == 1) {
			m21 = v;
		}
		if (i == 2 && j == 3) {
			m23 = v;
		}
		if (i == 3 && j == 1) {
			m31 = v;
		}
		if (i == 3 && j == 2) {
			m32 = v;
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
		if (i == 3 && j == 0) {
			return m30;
		}
		if (i == 0 && j == 1) {
			return m01;
		}
		if (i == 0 && j == 2) {
			return m02;
		}
		if (i == 0 && j == 3) {
			return m03;
		}
		if (i == 1 && j == 1) {
			return m11;
		}
		if (i == 2 && j == 2) {
			return m22;
		}
		if (i == 3 && j == 3) {
			return m33;
		}
		if (i == 1 && j == 2) {
			return m12;
		}
		if (i == 1 && j == 3) {
			return m13;
		}
		if (i == 2 && j == 1) {
			return m21;
		}
		if (i == 2 && j == 3) {
			return m23;
		}
		if (i == 3 && j == 1) {
			return m31;
		}
		if (i == 3 && j == 2) {
			return m32;
		}

		throw new IllegalArgumentException("Parameters are not in range!");
	}

	@Override
	public Double[] getRow(int i) {
		if (i == 0) {
			return new Double[]{m00, m01, m02, m03};
		}
		if (i == 1) {
			return new Double[]{m10, m11, m12, m13};
		}
		if (i == 2) {
			return new Double[]{m20, m21, m22, m23};
		}
		if (i == 3) {
			return new Double[]{m30, m31, m32, m33};
		}

		throw new IllegalArgumentException("Index not in range!");
	}

	@Override
	public Double[] getColumn(int i) {
		if (i == 0) {
			return new Double[]{m00, m10, m20, m30};
		}
		if (i == 1) {
			return new Double[]{m01, m11, m21, m31};
		}
		if (i == 2) {
			return new Double[]{m02, m12, m22, m32};
		}
		if (i == 3) {
			return new Double[]{m03, m13, m23, m33};
		}

		throw new IllegalArgumentException("Index not in range!");
	}

	@Override
	public Matrix4d negate() {
		return new Matrix4d(this).negateLocal();
	}

	@Override
	public Matrix4d negateLocal() {
		m00 = -m00;
		m01 = -m01;
		m02 = -m02;
		m03 = -m03;
		m10 = -m10;
		m11 = -m11;
		m12 = -m12;
		m13 = -m13;
		m20 = -m20;
		m21 = -m21;
		m22 = -m22;
		m23 = -m23;
		m30 = -m30;
		m31 = -m31;
		m32 = -m32;
		m33 = -m33;
		return this;
	}

	@Override
	public Double determinant() {
		double fA0 = m00 * m11 - m01 * m10;
		double fA1 = m00 * m12 - m02 * m10;
		double fA2 = m00 * m13 - m03 * m10;
		double fA3 = m01 * m12 - m02 * m11;
		double fA4 = m01 * m13 - m03 * m11;
		double fA5 = m02 * m13 - m03 * m12;
		double fB0 = m20 * m31 - m21 * m30;
		double fB1 = m20 * m32 - m22 * m30;
		double fB2 = m20 * m33 - m23 * m30;
		double fB3 = m21 * m32 - m22 * m31;
		double fB4 = m21 * m33 - m23 * m31;
		double fB5 = m22 * m33 - m23 * m32;
		return fA0 * fB5 - fA1 * fB4 + fA2 * fB3 + fA3 * fB2 - fA4 * fB1 + fA5 * fB0;
	}

	@Override
	public boolean isIdentity() {
		return (m00 == 1 && m01 == 0 && m02 == 0 && m03 == 0)
				&& (m10 == 0 && m11 == 1 && m12 == 0 && m13 == 0)
				&& (m20 == 0 && m21 == 0 && m22 == 1 && m23 == 0)
				&& (m30 == 0 && m31 == 0 && m32 == 0 && m33 == 1);
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
		return (m00 == v && m01 == v && m02 == v && m03 == v)
				&& (m10 == v && m11 == v && m12 == v && m13 == v)
				&& (m20 == v && m21 == v && m22 == v && m23 == v)
				&& (m30 == v && m31 == v && m32 == v && m33 == v);
	}

	@Override
	public void fromArray(Double... array) {
		m00 = array[0];
		m01 = array[1];
		m02 = array[2];
		m03 = array[3];
		m10 = array[4];
		m11 = array[5];
		m12 = array[6];
		m13 = array[7];
		m20 = array[8];
		m21 = array[9];
		m22 = array[10];
		m23 = array[11];
		m30 = array[12];
		m31 = array[13];
		m32 = array[14];
		m33 = array[15];
	}

	@Override
	public Double[] toArray() {
		return new Double[]{
			m00, m01, m02, m03,
			m10, m11, m12, m13,
			m20, m21, m22, m23,
			m30, m31, m32, m33
		};
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m00) ^ (Double.doubleToLongBits(this.m00) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m01) ^ (Double.doubleToLongBits(this.m01) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m02) ^ (Double.doubleToLongBits(this.m02) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m03) ^ (Double.doubleToLongBits(this.m03) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m10) ^ (Double.doubleToLongBits(this.m10) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m11) ^ (Double.doubleToLongBits(this.m11) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m12) ^ (Double.doubleToLongBits(this.m12) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m13) ^ (Double.doubleToLongBits(this.m13) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m20) ^ (Double.doubleToLongBits(this.m20) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m21) ^ (Double.doubleToLongBits(this.m21) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m22) ^ (Double.doubleToLongBits(this.m22) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m23) ^ (Double.doubleToLongBits(this.m23) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m30) ^ (Double.doubleToLongBits(this.m30) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m31) ^ (Double.doubleToLongBits(this.m31) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m32) ^ (Double.doubleToLongBits(this.m32) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.m33) ^ (Double.doubleToLongBits(this.m33) >>> 32));
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
		final Matrix4d other = (Matrix4d) obj;
		if (Double.doubleToLongBits(this.m00) != Double.doubleToLongBits(other.m00)) {
			return false;
		}
		if (Double.doubleToLongBits(this.m01) != Double.doubleToLongBits(other.m01)) {
			return false;
		}
		if (Double.doubleToLongBits(this.m02) != Double.doubleToLongBits(other.m02)) {
			return false;
		}
		if (Double.doubleToLongBits(this.m03) != Double.doubleToLongBits(other.m03)) {
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
		if (Double.doubleToLongBits(this.m13) != Double.doubleToLongBits(other.m13)) {
			return false;
		}
		if (Double.doubleToLongBits(this.m20) != Double.doubleToLongBits(other.m20)) {
			return false;
		}
		if (Double.doubleToLongBits(this.m21) != Double.doubleToLongBits(other.m21)) {
			return false;
		}
		if (Double.doubleToLongBits(this.m22) != Double.doubleToLongBits(other.m22)) {
			return false;
		}
		if (Double.doubleToLongBits(this.m23) != Double.doubleToLongBits(other.m23)) {
			return false;
		}
		if (Double.doubleToLongBits(this.m30) != Double.doubleToLongBits(other.m30)) {
			return false;
		}
		if (Double.doubleToLongBits(this.m31) != Double.doubleToLongBits(other.m31)) {
			return false;
		}
		if (Double.doubleToLongBits(this.m32) != Double.doubleToLongBits(other.m32)) {
			return false;
		}
		return Double.doubleToLongBits(this.m33) == Double.doubleToLongBits(other.m33);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(16);

		result.append(m00);
		result.append(" ");
		result.append(m01);
		result.append(" ");
		result.append(m02);
		result.append(" ");
		result.append(m03);
		result.append("\n");

		result.append(m10);
		result.append(" ");
		result.append(m11);
		result.append(" ");
		result.append(m12);
		result.append(" ");
		result.append(m13);
		result.append("\n");

		result.append(m20);
		result.append(" ");
		result.append(m21);
		result.append(" ");
		result.append(m22);
		result.append(" ");
		result.append(m23);
		result.append("\n");

		result.append(m30);
		result.append(" ");
		result.append(m31);
		result.append(" ");
		result.append(m32);
		result.append(" ");
		result.append(m33);

		return result.toString();
	}

	@Override
	public Matrix4d clone() throws CloneNotSupportedException {
		return (Matrix4d) super.clone();
	}
}
