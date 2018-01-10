package org.frost.math.matrix;

/**
 * Holds a 3x3 double matrix. The content of this matrix can only be set in<br/>
 * the constructor.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyMatrix3d extends Matrix3d {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 786512648586514L;

	/**
	 * Creates a new 3x3 matrix, which is initialized with the default identity
	 * values.
	 */
	public ReadOnlyMatrix3d() {
		super();
	}

	/**
	 * Creates a new 3x3 matrix and sets all values of the matrix to the given
	 * value.
	 *
	 * @param value Value which all matrix values should have.
	 */
	public ReadOnlyMatrix3d(double value) {
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
	public ReadOnlyMatrix3d(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22) {
		super(m00, m01, m02, m10, m11, m12, m20, m21, m22);
	}

	/**
	 * Creates a new 3x3 matrix from the given matrix. Takes over the matrix
	 * data from the given matrix!
	 *
	 * @param mat Given matrix.
	 */
	public ReadOnlyMatrix3d(Matrix3d mat) {
		super(mat);
	}

	@Override
	public Matrix3d absoluteLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3d addLocal(Matrix3d mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3d addLocal(Double v) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3d divideLocal(Matrix3d mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3d divideLocal(Double scalar) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public void fromArray(Double... array) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3d identity() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3d invertLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3d multiplicateLocal(Double scalar) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3d multiplicateLocal(Matrix3d mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3d set(Matrix3d mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3d one() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3d set(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3d subtractLocal(Matrix3d mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3d subtractLocal(Double scalar) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3d transposeLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3d zero() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3d adjointLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3d negateLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix3d put(int i, int j, Double v) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public ReadOnlyMatrix3d clone() throws CloneNotSupportedException {
		return (ReadOnlyMatrix3d) super.clone();
	}
}
