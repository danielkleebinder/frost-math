package org.frost.math.matrix;

/**
 * Holds a 2x2 int matrix. The content of this matrix can only be set in<br/>
 * the constructor.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyMatrix2i extends Matrix2i {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 768515647851384L;

	/**
	 * Creates a new 2x2 matrix, which is initialized with the default identity
	 * values.
	 */
	public ReadOnlyMatrix2i() {
		super();
	}

	/**
	 * Creates a new 2x2 matrix and sets all values of the matrix to the given
	 * value.
	 *
	 * @param value Value which all matrix values should have.
	 */
	public ReadOnlyMatrix2i(int value) {
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
	public ReadOnlyMatrix2i(int m00, int m01, int m10, int m11) {
		super(m00, m01, m10, m11);
	}

	/**
	 * Creates a new 2x2 matrix from the given matrix. Takes over the matrix
	 * data from the given matrix!
	 *
	 * @param mat Given matrix.
	 */
	public ReadOnlyMatrix2i(Matrix2i mat) {
		super(mat);
	}

	@Override
	public Matrix2i absoluteLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2i addLocal(Matrix2i mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2i addLocal(Integer scalar) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2i adjointLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2i divideLocal(Matrix2i mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2i divideLocal(Integer scalar) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public void fromArray(Integer... array) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2i identity() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2i invertLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2i one() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2i subtractLocal(Matrix2i mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2i subtractLocal(Integer scalar) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2i transposeLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2i zero() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2i fill(Integer v) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2i multiplicateLocal(Integer scalar) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2i multiplicateLocal(Matrix2i mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2i negateLocal() {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2i put(int i, int j, Integer v) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2i set(Matrix2i mat) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public Matrix2i set(int m00, int m01, int m10, int m11) {
		throw new UnsupportedOperationException("Read only matrix does not support this operation");
	}

	@Override
	public ReadOnlyMatrix2i clone() throws CloneNotSupportedException {
		return (ReadOnlyMatrix2i) super.clone();
	}
}
