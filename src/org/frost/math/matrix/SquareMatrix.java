package org.frost.math.matrix;

/**
 * Interface for all square matrices.
 * <br/>
 * Square matrices do have a few more functionalities than default ones.<br/>
 * They can for example inverse the matrix!
 *
 * @author Daniel Kleebinder
 * @param <E> Generic matrix type.
 * @param <D> Data type of the matrix.
 * @since 1.0.0
 */
public interface SquareMatrix<E extends SquareMatrix, D extends Number> extends Matrix<E, D> {

	/**
	 * Returns a new inverse matrix of this one.
	 *
	 * @return New matrix.
	 */
	E invert();

	/**
	 * Inverts this matrix and returns it.
	 *
	 * @return This matrix.
	 */
	E invertLocal();

	/**
	 * Creates a new matrix with the adjoint values of this matrix.
	 *
	 * @return New matrix with the adjoint values.
	 */
	E adjoint();

	/**
	 * Calculates the adjoint of this matrix.
	 *
	 * @return This matrix.
	 */
	E adjointLocal();

	/**
	 * Transposes this matrix and returns the transposed values in a new matrix.
	 * <br/>
	 * Swaps the rows with the columns.
	 *
	 * @return New matrix.
	 */
	E transpose();

	/**
	 * Transposes this matrix.
	 * <br/>
	 * Swaps the rows with the columns.
	 *
	 * @return This matrix.
	 */
	E transposeLocal();
}
