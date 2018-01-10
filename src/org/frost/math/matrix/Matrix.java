package org.frost.math.matrix;

import java.io.Serializable;
import org.frost.math.Bufferable;

/**
 * Interface for all types of matrices.
 * <br/>
 * A matrix implementation has to implement this interface.
 *
 * @author Daniel Kleebinder
 * @param <E> Generic matrix type.
 * @param <D> Data type of the matrix.
 * @since 1.0.0
 */
public interface Matrix<E extends Matrix, D extends Number> extends Bufferable<D>, Serializable, Cloneable {

	/**
	 * Takes the data from the given matrix and puts it into this one.
	 *
	 * @param mat Matrix.
	 * @return This matrix.
	 */
	E set(E mat);

	/**
	 * Loads the default identity matrix. Namely all zeros with ones along the
	 * diagonal.
	 *
	 * @return This matrix.
	 */
	E identity();

	/**
	 * Sets all values of the matrix to zeros.
	 *
	 * @return This matrix.
	 */
	E zero();

	/**
	 * Sets all values of the matrix to ones.
	 *
	 * @return This matrix.
	 */
	E one();

	/**
	 * Fills the matrix with the given value.
	 *
	 * @param v Value.
	 * @return This matrix.
	 */
	E fill(D v);

	/**
	 * Adds this matrix by the given value and returns a new matrix.
	 *
	 * @param v Value for the addition.
	 * @return New matrix.
	 */
	E add(D v);

	/**
	 * Adds this matrix by the given value and returns this matrix.
	 *
	 * @param v Value for the addition.
	 * @return This matrix.
	 */
	E addLocal(D v);

	/**
	 * Adds the given matrix to this matrix and returns a new one. This matrix
	 * is unmodified!
	 *
	 * @param mat Matrix for addition.
	 * @return New matrix.
	 */
	E add(E mat);

	/**
	 * Adds the given matrix to this matrix and returns this matrix. This matrix
	 * gets modified!
	 *
	 * @param mat Matrix for addition.
	 * @return This matrix.
	 */
	E addLocal(E mat);

	/**
	 * Subtracts this matrix by the given value and returns a new matrix.
	 *
	 * @param v Value for the subtraction.
	 * @return New matrix.
	 */
	E subtract(D v);

	/**
	 * Subtracts this matrix by the given scalar.
	 *
	 * @param scalar Scalar for the subtraction.
	 * @return This matrix.
	 */
	E subtractLocal(D scalar);

	/**
	 * Subtracts the given matrix from this matrix and returns a new one. This
	 * matrix is unmodified!
	 *
	 * @param mat Matrix for subtraction.
	 * @return New matrix.
	 */
	E subtract(E mat);

	/**
	 * Subtracts the given matrix from this matrix and returns this matrix. This
	 * matrix gets modified!
	 *
	 * @param mat Matrix for subtraction.
	 * @return This matrix.
	 */
	E subtractLocal(E mat);

	/**
	 * Multiplicates this matrix by the given value and returns a new matrix.
	 *
	 * @param v Value for the multiplication.
	 * @return New matrix.
	 */
	E multiplicate(D v);

	/**
	 * Multiplicates this matrix by the given scalar.
	 *
	 * @param scalar Scalar for the multiplication.
	 * @return This matrix.
	 */
	E multiplicateLocal(D scalar);

	/**
	 * Multiplicates the given matrix to this matrix and returns a new one. This
	 * matrix is unmodified!
	 *
	 * @param mat Matrix for multiplication.
	 * @return New matrix.
	 */
	E multiplicate(E mat);

	/**
	 * Multiplicates the given matrix to this matrix and returns this matrix.
	 * This matrix gets modified!
	 *
	 * @param mat Right matrix for multiplication.
	 * @return This matrix.
	 */
	E multiplicateLocal(E mat);

	/**
	 * Divides this matrix by the given scalar and returns a new matrix.
	 *
	 * @param scalar Scalar for the division.
	 * @return New matrix.
	 */
	E divide(D scalar);

	/**
	 * Divides this matrix by the given scalar.
	 *
	 * @param scalar Scalar for the division.
	 * @return This matrix.
	 */
	E divideLocal(D scalar);

	/**
	 * Divides this matrix by the given matrix and returns a new one. This
	 * matrix is unmodified!
	 *
	 * @param mat Matrix for division.
	 * @return New matrix.
	 */
	E divide(E mat);

	/**
	 * Divides this matrix by the given matrix and returns this matrix. This
	 * matrix gets modified!
	 *
	 * @param mat Matrix for division.
	 * @return This matrix.
	 */
	E divideLocal(E mat);

	/**
	 * Calculates the absolute values for the values in this matrix and stores
	 * them into a new matrix. This matrix will stay unmodified!
	 *
	 * @return New matrix with absolute data in it.
	 */
	E absolute();

	/**
	 * Calculates the absolute values for the values in this matrix.
	 *
	 * @return This matrix.
	 */
	E absoluteLocal();

	/**
	 * Returns the width of the matrix.
	 * <br/>
	 * This is the size of the matrix on the horizontal axis.
	 *
	 * @return Width.
	 */
	int getWidth();

	/**
	 * Returns the height of the matrix.
	 * <br/>
	 * This is the size of the matrix on the vertical axis.
	 *
	 * @return Height.
	 */
	int getHeight();

	/**
	 * Puts the given value on the given location.
	 *
	 * @param i Column index.
	 * @param j Row index.
	 * @param v Value.
	 * @return This matrix.
	 */
	E put(int i, int j, D v);

	/**
	 * Puts the given value on the given location.
	 *
	 * @param i Matrix index.
	 * @param v Value.
	 * @return This matrix.
	 */
	E put(int i, D v);

	/**
	 * Returns the value on the given indices.
	 *
	 * @param i Column index.
	 * @param j Row index.
	 * @return Value.
	 */
	D get(int i, int j);

	/**
	 * Returns the value on the given index.
	 *
	 * @param i Matrix index.
	 * @return Value.
	 */
	D get(int i);

	/**
	 * Returns the specified row.
	 *
	 * @param i Row index.
	 * @return Row.
	 */
	D[] getRow(int i);

	/**
	 * Returns the specified column.
	 *
	 * @param i Column index.
	 * @return Column.
	 */
	D[] getColumn(int i);

	/**
	 * Negates the values from this matrix and writes them into a new one.
	 *
	 * @return New matrix.
	 */
	E negate();

	/**
	 * Negates this matrix.
	 *
	 * @return This matrix.
	 */
	E negateLocal();

	/**
	 * Calculates the determinat of this matrix.
	 *
	 * @return The determinat.
	 */
	D determinant();

	/**
	 * Returns true if this matrix is a identity matrix, otherwise false.
	 *
	 * @return True if this matrix is a identity matrix, otherwise false.
	 */
	boolean isIdentity();

	/**
	 * Returns true if this matrix is a zero matrix, otherwise false.
	 *
	 * @return True if this matrix is a zero matrix, otherwise false.
	 */
	boolean isZero();

	/**
	 * Returns true if this matrix is a one matrix, otherwise false.
	 *
	 * @return True if this matrix is a one matrix, otherwise false.
	 */
	boolean isOne();

	/**
	 * Returns if this matrix only consists of the given value.
	 *
	 * @param v Value.
	 * @return True if this matrix only contains the given number, otherwise
	 * false.
	 */
	boolean isUnified(D v);

	/**
	 * Returns this matrix.
	 *
	 * @return This.
	 */
	default E get() {
		return (E) this;
	}
}
