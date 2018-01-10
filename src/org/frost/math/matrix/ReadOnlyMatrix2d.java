package org.frost.math.matrix;

/**
 * Holds a 2x2 double matrix. The content of this matrix can only be set in<br/>
 * the constructor.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyMatrix2d extends Matrix2d {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 768515647851384L;

	/**
	 * Creates a new 2x2 matrix, which is initialized with the default identity
	 * values.
	 */
	public ReadOnlyMatrix2d() {
		super();
	}

	/**
	 * Creates a new 2x2 matrix and sets all values of the matrix to the given
	 * value.
	 *
	 * @param value Value which all matrix values should have.
	 */
	public ReadOnlyMatrix2d(double value) {
		super(value);
	}

	/**
	 * Creates a new 2x2 matrix with the given values.
	 *
	 * @param m00 Value 1.
	 * @param m01 Value 2.
	 * @param m10 Value 3.
	 * @param m11 Value 4.
	 */
	public ReadOnlyMatrix2d(double m00, double m01, double m10, double m11) {
		super(m00, m01, m10, m11);
	}

	/**
	 * Creates a new 2x2 matrix from the given matrix. Takes over the matrix
	 * data from the given matrix!
	 *
	 * @param mat Given matrix.
	 */
	public ReadOnlyMatrix2d(Matrix2d mat) {
		super(mat);
	}

	@Override
	public Matrix2d absoluteLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2d addLocal(Matrix2d mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2d addLocal(Double scalar) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2d adjointLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2d divideLocal(Matrix2d mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2d divideLocal(Double scalar) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public void fromArray(Double... array) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2d identity() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2d invertLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2d one() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2d subtractLocal(Matrix2d mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2d subtractLocal(Double scalar) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2d transposeLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2d zero() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2d fill(Double v) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2d multiplicateLocal(Double scalar) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2d multiplicateLocal(Matrix2d mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2d negateLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2d put(int i, int j, Double v) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2d set(Matrix2d mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2d set(double m00, double m01, double m10, double m11) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public ReadOnlyMatrix2d clone() throws CloneNotSupportedException {
		return (ReadOnlyMatrix2d) super.clone();
	}
}
