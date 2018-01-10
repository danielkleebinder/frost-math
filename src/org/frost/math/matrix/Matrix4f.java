package org.frost.math.matrix;

import org.frost.math.FastMath;

/**
 * Holds a 4x4 float matrix.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Matrix4f implements SquareMatrix<Matrix4f, Float> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 78951854765134L;

	/**
	 * Identity matrix.
	 */
	public static final Matrix4f IDENTITY = new ReadOnlyMatrix4f();
	/**
	 * Matrix filled with zeros.
	 */
	public static final Matrix4f ZERO = new ReadOnlyMatrix4f(0.0f);
	/**
	 * Matrix filled with ones.
	 */
	public static final Matrix4f ONE = new ReadOnlyMatrix4f(1.0f);
	/**
	 * Matrix filled with negative ones.
	 */
	public static final Matrix4f NEGATIVE_ONE = new ReadOnlyMatrix4f(-1.0f);

	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr>
	 * <td><b>1</b></td> <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td>
	 * <td>1</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td>
	 * <td>1</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td>
	 * <td>1</td> </tr> </table>This value is the index 0!
	 */
	public float m00;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td><b>0</b></td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td>1</td> </tr>
	 * </table>This value is the index 1!
	 */
	public float m01;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td><b>0</b></td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td>1</td> </tr>
	 * </table>This value is the index 2!
	 */
	public float m02;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td><b>0</b></td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td>1</td> </tr>
	 * </table>This value is the index 3!
	 */
	public float m03;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"> <caption>Identity Matrix</caption><tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td><b>0</b></td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td>1</td> </tr>
	 * </table>This value is the index 4!
	 */
	public float m10;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"> <caption>Identity Matrix</caption><tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td><b>1</b></td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td>1</td> </tr>
	 * </table>This value is the index 5!
	 */
	public float m11;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td><b>0</b></td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td>1</td> </tr>
	 * </table>This value is the index 6!
	 */
	public float m12;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td><b>0</b></td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td>1</td> </tr>
	 * </table>This value is the index 7!
	 */
	public float m13;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td><b>0</b></td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td>1</td> </tr>
	 * </table>This value is the index 8!
	 */
	public float m20;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"> <caption>Identity Matrix</caption><tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td><b>0</b></td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td>1</td> </tr>
	 * </table>This value is the index 9!
	 */
	public float m21;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td><b>1</b></td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td>1</td> </tr>
	 * </table>This value is the index 10!
	 */
	public float m22;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td><b>0</b></td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td>1</td>
	 * </tr> </table>This value is the index 11!
	 */
	public float m23;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td><b>0</b></td> <td>0</td> <td>0</td> <td>1</td>
	 * </tr> </table>This value is the index 12!
	 */
	public float m30;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"><caption>Identity Matrix</caption> <tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td><b>0</b></td> <td>0</td> <td>1</td>
	 * </tr> </table>This value is the index 13!
	 */
	public float m31;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"> <caption>Identity Matrix</caption><tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td><b>0</b></td> <td>1</td>
	 * </tr> </table>This value is the index 14!
	 */
	public float m32;
	/**
	 * This matrix value, is the bold value in the matrix below.
	 * <table border="1"> <caption>Identity Matrix</caption><tr> <td>1</td>
	 * <td>0</td> <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>1</td>
	 * <td>0</td> <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>1</td>
	 * <td>0</td> </tr> <tr> <td>0</td> <td>0</td> <td>0</td> <td><b>1</b></td>
	 * </tr> </table>This value is the index 15!
	 */
	public float m33;

	/**
	 * Creates a new 4x4 matrix, which is initialized with the default identity
	 * values.
	 */
	public Matrix4f() {
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
	public Matrix4f(float value) {
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
	public Matrix4f(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33) {
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
	public Matrix4f(Matrix4f mat) {
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
	public Matrix4f set(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33) {
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
	public Matrix4f invert() {
		return new Matrix4f(this).invertLocal();
	}

	@Override
	public Matrix4f invertLocal() {
		float fA0 = m00 * m11 - m01 * m10;
		float fA1 = m00 * m12 - m02 * m10;
		float fA2 = m00 * m13 - m03 * m10;
		float fA3 = m01 * m12 - m02 * m11;
		float fA4 = m01 * m13 - m03 * m11;
		float fA5 = m02 * m13 - m03 * m12;
		float fB0 = m20 * m31 - m21 * m30;
		float fB1 = m20 * m32 - m22 * m30;
		float fB2 = m20 * m33 - m23 * m30;
		float fB3 = m21 * m32 - m22 * m31;
		float fB4 = m21 * m33 - m23 * m31;
		float fB5 = m22 * m33 - m23 * m32;

		float determination = fA0 * fB5 - fA1 * fB4 + fA2 * fB3 + fA3 * fB2 - fA4 * fB1 + fA5 * fB0;

		if (FastMath.abs(determination) <= 0.0f) {
			return zero();
		}

		float f00 = +m11 * fB5 - m12 * fB4 + m13 * fB3;
		float f10 = -m10 * fB5 + m12 * fB2 - m13 * fB1;
		float f20 = +m10 * fB4 - m11 * fB2 + m13 * fB0;
		float f30 = -m10 * fB3 + m11 * fB1 - m12 * fB0;
		float f01 = -m01 * fB5 + m02 * fB4 - m03 * fB3;
		float f11 = +m00 * fB5 - m02 * fB2 + m03 * fB1;
		float f21 = -m00 * fB4 + m01 * fB2 - m03 * fB0;
		float f31 = +m00 * fB3 - m01 * fB1 + m02 * fB0;
		float f02 = +m31 * fA5 - m32 * fA4 + m33 * fA3;
		float f12 = -m30 * fA5 + m32 * fA2 - m33 * fA1;
		float f22 = +m30 * fA4 - m31 * fA2 + m33 * fA0;
		float f32 = -m30 * fA3 + m31 * fA1 - m32 * fA0;
		float f03 = -m21 * fA5 + m22 * fA4 - m23 * fA3;
		float f13 = +m20 * fA5 - m22 * fA2 + m23 * fA1;
		float f23 = -m20 * fA4 + m21 * fA2 - m23 * fA0;
		float f33 = +m20 * fA3 - m21 * fA1 + m22 * fA0;

		set(f00, f01, f02, f03, f10, f11, f12, f13, f20, f21, f22, f23, f30, f31, f32, f33);
		return multiplicateLocal(1.0f / determination);
	}

	@Override
	public Matrix4f adjoint() {
		return new Matrix4f(this).adjointLocal();
	}

	@Override
	public Matrix4f adjointLocal() {
		float fA0 = m00 * m11 - m01 * m10;
		float fA1 = m00 * m12 - m02 * m10;
		float fA2 = m00 * m13 - m03 * m10;
		float fA3 = m01 * m12 - m02 * m11;
		float fA4 = m01 * m13 - m03 * m11;
		float fA5 = m02 * m13 - m03 * m12;
		float fB0 = m20 * m31 - m21 * m30;
		float fB1 = m20 * m32 - m22 * m30;
		float fB2 = m20 * m33 - m23 * m30;
		float fB3 = m21 * m32 - m22 * m31;
		float fB4 = m21 * m33 - m23 * m31;
		float fB5 = m22 * m33 - m23 * m32;

		float f00 = +m11 * fB5 - m12 * fB4 + m13 * fB3;
		float f10 = -m10 * fB5 + m12 * fB2 - m13 * fB1;
		float f20 = +m10 * fB4 - m11 * fB2 + m13 * fB0;
		float f30 = -m10 * fB3 + m11 * fB1 - m12 * fB0;
		float f01 = -m01 * fB5 + m02 * fB4 - m03 * fB3;
		float f11 = +m00 * fB5 - m02 * fB2 + m03 * fB1;
		float f21 = -m00 * fB4 + m01 * fB2 - m03 * fB0;
		float f31 = +m00 * fB3 - m01 * fB1 + m02 * fB0;
		float f02 = +m31 * fA5 - m32 * fA4 + m33 * fA3;
		float f12 = -m30 * fA5 + m32 * fA2 - m33 * fA1;
		float f22 = +m30 * fA4 - m31 * fA2 + m33 * fA0;
		float f32 = -m30 * fA3 + m31 * fA1 - m32 * fA0;
		float f03 = -m21 * fA5 + m22 * fA4 - m23 * fA3;
		float f13 = +m20 * fA5 - m22 * fA2 + m23 * fA1;
		float f23 = -m20 * fA4 + m21 * fA2 - m23 * fA0;
		float f33 = +m20 * fA3 - m21 * fA1 + m22 * fA0;

		return set(f00, f01, f02, f03, f10, f11, f12, f13, f20, f21, f22, f23, f30, f31, f32, f33);
	}

	@Override
	public Matrix4f transpose() {
		return new Matrix4f(this).transposeLocal();
	}

	@Override
	public Matrix4f transposeLocal() {
		return set(
				m00, m10, m20, m30,
				m01, m11, m21, m31,
				m02, m12, m22, m32,
				m03, m13, m23, m33
		);
	}

	@Override
	public Matrix4f set(Matrix4f mat) {
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
	public Matrix4f identity() {
		m01 = m02 = m03 = 0.0f;
		m10 = m12 = m13 = 0.0f;
		m20 = m21 = m23 = 0.0f;
		m30 = m31 = m32 = 0.0f;
		m00 = m11 = m22 = m33 = 1.0f;
		return this;
	}

	@Override
	public Matrix4f zero() {
		return fill(0.0f);
	}

	@Override
	public Matrix4f one() {
		return fill(1.0f);
	}

	@Override
	public Matrix4f fill(Float v) {
		m00 = m01 = m02 = m03 = v;
		m10 = m11 = m12 = m13 = v;
		m20 = m21 = m22 = m23 = v;
		m30 = m31 = m32 = m33 = v;
		return this;
	}

	@Override
	public Matrix4f add(Float v) {
		return new Matrix4f(this).addLocal(v);
	}

	@Override
	public Matrix4f addLocal(Float v) {
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
	public Matrix4f add(Matrix4f mat) {
		return new Matrix4f(this).addLocal(mat);
	}

	@Override
	public Matrix4f addLocal(Matrix4f mat) {
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
	public Matrix4f subtract(Float v) {
		return new Matrix4f(this).subtractLocal(v);
	}

	@Override
	public Matrix4f subtractLocal(Float v) {
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
	public Matrix4f subtract(Matrix4f mat) {
		return new Matrix4f(this).subtractLocal(mat);
	}

	@Override
	public Matrix4f subtractLocal(Matrix4f mat) {
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
	public Matrix4f multiplicate(Float v) {
		return new Matrix4f(this).multiplicateLocal(v);
	}

	@Override
	public Matrix4f multiplicateLocal(Float scalar) {
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
	public Matrix4f multiplicate(Matrix4f mat) {
		return new Matrix4f(this).multiplicateLocal(mat);
	}

	@Override
	public Matrix4f multiplicateLocal(Matrix4f mat) {
		float temp00 = m00 * mat.m00 + m10 * mat.m01 + m20 * mat.m02 + m30 * mat.m03;
		float temp01 = m01 * mat.m00 + m11 * mat.m01 + m21 * mat.m02 + m31 * mat.m03;
		float temp02 = m02 * mat.m00 + m12 * mat.m01 + m22 * mat.m02 + m32 * mat.m03;
		float temp03 = m03 * mat.m00 + m13 * mat.m01 + m23 * mat.m02 + m33 * mat.m03;
		float temp10 = m00 * mat.m10 + m10 * mat.m11 + m20 * mat.m12 + m30 * mat.m13;
		float temp11 = m01 * mat.m10 + m11 * mat.m11 + m21 * mat.m12 + m31 * mat.m13;
		float temp12 = m02 * mat.m10 + m12 * mat.m11 + m22 * mat.m12 + m32 * mat.m13;
		float temp13 = m03 * mat.m10 + m13 * mat.m11 + m23 * mat.m12 + m33 * mat.m13;
		float temp20 = m00 * mat.m20 + m10 * mat.m21 + m20 * mat.m22 + m30 * mat.m23;
		float temp21 = m01 * mat.m20 + m11 * mat.m21 + m21 * mat.m22 + m31 * mat.m23;
		float temp22 = m02 * mat.m20 + m12 * mat.m21 + m22 * mat.m22 + m32 * mat.m23;
		float temp23 = m03 * mat.m20 + m13 * mat.m21 + m23 * mat.m22 + m33 * mat.m23;
		float temp30 = m00 * mat.m30 + m10 * mat.m31 + m20 * mat.m32 + m30 * mat.m33;
		float temp31 = m01 * mat.m30 + m11 * mat.m31 + m21 * mat.m32 + m31 * mat.m33;
		float temp32 = m02 * mat.m30 + m12 * mat.m31 + m22 * mat.m32 + m32 * mat.m33;
		float temp33 = m03 * mat.m30 + m13 * mat.m31 + m23 * mat.m32 + m33 * mat.m33;
		return set(temp00, temp01, temp02, temp03, temp10, temp11, temp12, temp13, temp20, temp21, temp22, temp23, temp30, temp31, temp32, temp33);
	}

	@Override
	public Matrix4f divide(Float scalar) {
		return new Matrix4f(this).divideLocal(scalar);
	}

	@Override
	public Matrix4f divideLocal(Float scalar) {
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
	public Matrix4f divide(Matrix4f mat) {
		return new Matrix4f(this).divideLocal(mat);
	}

	@Override
	public Matrix4f divideLocal(Matrix4f mat) {
		float temp00 = m00 / mat.m00 + m10 / mat.m01 + m20 / mat.m02 + m30 / mat.m03;
		float temp01 = m01 / mat.m00 + m11 / mat.m01 + m21 / mat.m02 + m31 / mat.m03;
		float temp02 = m02 / mat.m00 + m12 / mat.m01 + m22 / mat.m02 + m32 / mat.m03;
		float temp03 = m03 / mat.m00 + m13 / mat.m01 + m23 / mat.m02 + m33 / mat.m03;
		float temp10 = m00 / mat.m10 + m10 / mat.m11 + m20 / mat.m12 + m30 / mat.m13;
		float temp11 = m01 / mat.m10 + m11 / mat.m11 + m21 / mat.m12 + m31 / mat.m13;
		float temp12 = m02 / mat.m10 + m12 / mat.m11 + m22 / mat.m12 + m32 / mat.m13;
		float temp13 = m03 / mat.m10 + m13 / mat.m11 + m23 / mat.m12 + m33 / mat.m13;
		float temp20 = m00 / mat.m20 + m10 / mat.m21 + m20 / mat.m22 + m30 / mat.m23;
		float temp21 = m01 / mat.m20 + m11 / mat.m21 + m21 / mat.m22 + m31 / mat.m23;
		float temp22 = m02 / mat.m20 + m12 / mat.m21 + m22 / mat.m22 + m32 / mat.m23;
		float temp23 = m03 / mat.m20 + m13 / mat.m21 + m23 / mat.m22 + m33 / mat.m23;
		float temp30 = m00 / mat.m30 + m10 / mat.m31 + m20 / mat.m32 + m30 / mat.m33;
		float temp31 = m01 / mat.m30 + m11 / mat.m31 + m21 / mat.m32 + m31 / mat.m33;
		float temp32 = m02 / mat.m30 + m12 / mat.m31 + m22 / mat.m32 + m32 / mat.m33;
		float temp33 = m03 / mat.m30 + m13 / mat.m31 + m23 / mat.m32 + m33 / mat.m33;
		return set(temp00, temp01, temp02, temp03, temp10, temp11, temp12, temp13, temp20, temp21, temp22, temp23, temp30, temp31, temp32, temp33);
	}

	@Override
	public Matrix4f absolute() {
		return new Matrix4f(this).absoluteLocal();
	}

	@Override
	public Matrix4f absoluteLocal() {
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
	public Matrix4f scale(float x, float y, float z) {
		return new Matrix4f(this).scaleLocal(x, y, z);
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
	public Matrix4f scaleLocal(float x, float y, float z) {
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
	public Matrix4f translate(float x, float y, float z) {
		return new Matrix4f(this).translateLocal(x, y, z);
	}

	/**
	 * Translates this matrix by the given x, y and z coordinates.
	 *
	 * @param x X coordinate.
	 * @param y Y coordinate.
	 * @param z Z coordinate.
	 * @return This.
	 */
	public Matrix4f translateLocal(float x, float y, float z) {
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
	 * @param x X delte (Between -1.0f and 1.0f).
	 * @param y Y delte (Between -1.0f and 1.0f).
	 * @param z Z delte (Between -1.0f and 1.0f).
	 * @return New matrix.
	 */
	public Matrix4f rotate(float angle, float x, float y, float z) {
		return new Matrix4f(this).rotateLocal(angle, x, y, z);
	}

	/**
	 * Rotates this matrix for the given angle around the given axis.
	 *
	 * @param angle Angle in degrees.
	 * @param x X delte (Between -1.0f and 1.0f).
	 * @param y Y delte (Between -1.0f and 1.0f).
	 * @param z Z delte (Between -1.0f and 1.0f).
	 * @return This.
	 */
	public Matrix4f rotateLocal(float angle, float x, float y, float z) {
		float a = FastMath.toRadians(angle);
		float c = FastMath.cos(a);
		float s = FastMath.sin(a);

		float length = x * x + y * y + z * z;
		if (length != 1.0f && length != 0.0f) {
			length = 1.0f / FastMath.sqrt(length);
			x *= length;
			y *= length;
			z *= length;
		}
		float tx = x * (1.0f - c);
		float ty = y * (1.0f - c);
		float tz = z * (1.0f - c);

		Matrix4f rotate = new Matrix4f();

		rotate.m00 = c + tx * x;
		rotate.m01 = 0 + tx * y + s * z;
		rotate.m02 = 0 + tx * z - s * y;

		rotate.m10 = 0 + ty * x - s * z;
		rotate.m11 = c + ty * y;
		rotate.m12 = 0 + ty * z + s * x;

		rotate.m20 = 0 + tz * x + s * y;
		rotate.m21 = 0 + tz * y - s * x;
		rotate.m22 = c + tz * z;

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
	public Matrix4f put(int i, Float v) {
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
	public Float get(int i) {
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
	public Matrix4f put(int i, int j, Float v) {
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
	public Float get(int i, int j) {
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
	public Float[] getRow(int i) {
		if (i == 0) {
			return new Float[]{m00, m01, m02, m03};
		}
		if (i == 1) {
			return new Float[]{m10, m11, m12, m13};
		}
		if (i == 2) {
			return new Float[]{m20, m21, m22, m23};
		}
		if (i == 3) {
			return new Float[]{m30, m31, m32, m33};
		}

		throw new IllegalArgumentException("Index not in range!");
	}

	@Override
	public Float[] getColumn(int i) {
		if (i == 0) {
			return new Float[]{m00, m10, m20, m30};
		}
		if (i == 1) {
			return new Float[]{m01, m11, m21, m31};
		}
		if (i == 2) {
			return new Float[]{m02, m12, m22, m32};
		}
		if (i == 3) {
			return new Float[]{m03, m13, m23, m33};
		}

		throw new IllegalArgumentException("Index not in range!");
	}

	@Override
	public Matrix4f negate() {
		return new Matrix4f(this).negateLocal();
	}

	@Override
	public Matrix4f negateLocal() {
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
	public Float determinant() {
		float fA0 = m00 * m11 - m01 * m10;
		float fA1 = m00 * m12 - m02 * m10;
		float fA2 = m00 * m13 - m03 * m10;
		float fA3 = m01 * m12 - m02 * m11;
		float fA4 = m01 * m13 - m03 * m11;
		float fA5 = m02 * m13 - m03 * m12;
		float fB0 = m20 * m31 - m21 * m30;
		float fB1 = m20 * m32 - m22 * m30;
		float fB2 = m20 * m33 - m23 * m30;
		float fB3 = m21 * m32 - m22 * m31;
		float fB4 = m21 * m33 - m23 * m31;
		float fB5 = m22 * m33 - m23 * m32;
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
		return isUnified(0.0f);
	}

	@Override
	public boolean isOne() {
		return isUnified(1.0f);
	}

	@Override
	public boolean isUnified(Float v) {
		return (m00 == v && m01 == v && m02 == v && m03 == v)
				&& (m10 == v && m11 == v && m12 == v && m13 == v)
				&& (m20 == v && m21 == v && m22 == v && m23 == v)
				&& (m30 == v && m31 == v && m32 == v && m33 == v);
	}

	@Override
	public void fromArray(Float... array) {
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
	public Float[] toArray() {
		return new Float[]{
			m00, m01, m02, m03,
			m10, m11, m12, m13,
			m20, m21, m22, m23,
			m30, m31, m32, m33
		};
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 89 * hash + Float.floatToIntBits(this.m00);
		hash = 89 * hash + Float.floatToIntBits(this.m01);
		hash = 89 * hash + Float.floatToIntBits(this.m02);
		hash = 89 * hash + Float.floatToIntBits(this.m03);
		hash = 89 * hash + Float.floatToIntBits(this.m10);
		hash = 89 * hash + Float.floatToIntBits(this.m11);
		hash = 89 * hash + Float.floatToIntBits(this.m12);
		hash = 89 * hash + Float.floatToIntBits(this.m13);
		hash = 89 * hash + Float.floatToIntBits(this.m20);
		hash = 89 * hash + Float.floatToIntBits(this.m21);
		hash = 89 * hash + Float.floatToIntBits(this.m22);
		hash = 89 * hash + Float.floatToIntBits(this.m23);
		hash = 89 * hash + Float.floatToIntBits(this.m30);
		hash = 89 * hash + Float.floatToIntBits(this.m31);
		hash = 89 * hash + Float.floatToIntBits(this.m32);
		hash = 89 * hash + Float.floatToIntBits(this.m33);
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
		final Matrix4f other = (Matrix4f) obj;
		if (Float.floatToIntBits(this.m00) != Float.floatToIntBits(other.m00)) {
			return false;
		}
		if (Float.floatToIntBits(this.m01) != Float.floatToIntBits(other.m01)) {
			return false;
		}
		if (Float.floatToIntBits(this.m02) != Float.floatToIntBits(other.m02)) {
			return false;
		}
		if (Float.floatToIntBits(this.m03) != Float.floatToIntBits(other.m03)) {
			return false;
		}
		if (Float.floatToIntBits(this.m10) != Float.floatToIntBits(other.m10)) {
			return false;
		}
		if (Float.floatToIntBits(this.m11) != Float.floatToIntBits(other.m11)) {
			return false;
		}
		if (Float.floatToIntBits(this.m12) != Float.floatToIntBits(other.m12)) {
			return false;
		}
		if (Float.floatToIntBits(this.m13) != Float.floatToIntBits(other.m13)) {
			return false;
		}
		if (Float.floatToIntBits(this.m20) != Float.floatToIntBits(other.m20)) {
			return false;
		}
		if (Float.floatToIntBits(this.m21) != Float.floatToIntBits(other.m21)) {
			return false;
		}
		if (Float.floatToIntBits(this.m22) != Float.floatToIntBits(other.m22)) {
			return false;
		}
		if (Float.floatToIntBits(this.m23) != Float.floatToIntBits(other.m23)) {
			return false;
		}
		if (Float.floatToIntBits(this.m30) != Float.floatToIntBits(other.m30)) {
			return false;
		}
		if (Float.floatToIntBits(this.m31) != Float.floatToIntBits(other.m31)) {
			return false;
		}
		if (Float.floatToIntBits(this.m32) != Float.floatToIntBits(other.m32)) {
			return false;
		}
		return Float.floatToIntBits(this.m33) == Float.floatToIntBits(other.m33);
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
	public Matrix4f clone() throws CloneNotSupportedException {
		return (Matrix4f) super.clone();
	}
}
