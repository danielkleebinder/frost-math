package org.frost.math.matrix;

/**
 * Holds a 4x4 int matrix. The content of this matrix can only be set in<br/>
 * the constructor.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyMatrix4i extends Matrix4i {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 987715626458715626L;

	/**
	 * Creates a new 4x4 matrix, which is initialized with the default identity
	 * values.
	 */
	public ReadOnlyMatrix4i() {
		super();
	}

	/**
	 * Creates a new 4x4 matrix and sets all values of the matrix to the given
	 * value.
	 *
	 * @param value Value which all matrix values should have.
	 */
	public ReadOnlyMatrix4i(int value) {
		super(value);
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
	public ReadOnlyMatrix4i(int m00, int m01, int m02, int m03, int m10, int m11, int m12, int m13, int m20, int m21, int m22, int m23, int m30, int m31, int m32, int m33) {
		super(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33);
	}

	/**
	 * Creates a new 4x4 matrix from the given matrix. Takes over the matrix
	 * data from the given matrix!
	 *
	 * @param mat Given matrix.
	 */
	public ReadOnlyMatrix4i(ReadOnlyMatrix4i mat) {
		super(mat);
	}

	@Override
	public Matrix4i set(Matrix4i mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix4i set(int m00, int m01, int m02, int m03, int m10, int m11, int m12, int m13, int m20, int m21, int m22, int m23, int m30, int m31, int m32, int m33) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix4i addLocal(Integer v) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix4i addLocal(Matrix4i mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix4i subtractLocal(Integer v) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix4i subtractLocal(Matrix4i mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix4i multiplicateLocal(Integer scalar) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix4i multiplicateLocal(Matrix4i mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix4i divideLocal(Integer scalar) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix4i divideLocal(Matrix4i mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix4i absoluteLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix4i adjointLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public void fromArray(Integer... array) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix4i identity() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix4i invertLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix4i scaleLocal(int x, int y, int z) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix4i translateLocal(int x, int y, int z) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix4i rotateLocal(int angle, int xw, int yw, int zw) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix4i negateLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix4i one() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix4i zero() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix4i fill(Integer v) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix4i put(int i, int j, Integer v) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix4i transposeLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public ReadOnlyMatrix4i clone() throws CloneNotSupportedException {
		return (ReadOnlyMatrix4i) super.clone();
	}
}
