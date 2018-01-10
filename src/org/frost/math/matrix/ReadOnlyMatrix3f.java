package org.frost.math.matrix;

/**
 * Holds a 3x3 float matrix. The content of this matrix can only be set in<br/>
 * the constructor.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyMatrix3f extends Matrix3f {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 87651625387443L;

	/**
	 * Creates a new 3x3 matrix, which is initialized with the default identity
	 * values.
	 */
	public ReadOnlyMatrix3f() {
		super();
	}

	/**
	 * Creates a new 3x3 matrix and sets all values of the matrix to the given
	 * value.
	 *
	 * @param value Value which all matrix values should have.
	 */
	public ReadOnlyMatrix3f(float value) {
		super(value);
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
	public ReadOnlyMatrix3f(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
		super(m00, m01, m02, m10, m11, m12, m20, m21, m22);
	}

	/**
	 * Creates a new 3x3 matrix from the given matrix. Takes over the matrix
	 * data from the given matrix!
	 *
	 * @param mat Given matrix.
	 */
	public ReadOnlyMatrix3f(Matrix3f mat) {
		super(mat);
	}

	@Override
	public Matrix3f absoluteLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3f addLocal(Matrix3f mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3f addLocal(Float v) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3f divideLocal(Matrix3f mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3f divideLocal(Float scalar) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public void fromArray(Float... array) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3f identity() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3f invertLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3f multiplicateLocal(Float scalar) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3f multiplicateLocal(Matrix3f mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3f set(Matrix3f mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3f one() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3f set(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3f subtractLocal(Matrix3f mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3f subtractLocal(Float scalar) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3f transposeLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3f zero() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3f adjointLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3f negateLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3f put(int i, int j, Float v) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public ReadOnlyMatrix3f clone() throws CloneNotSupportedException {
		return (ReadOnlyMatrix3f) super.clone();
	}
}
