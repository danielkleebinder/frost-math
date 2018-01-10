package org.frost.math.geometry;

import org.frost.math.geometry.rectangle.Rectangle;
import org.frost.math.vector.Vector;

/**
 * A basic two dimensional shape.
 *
 * @author Daniel Kleebinder
 * @param <E> Generic number type.
 * @param <F> Generic vector type.
 * @since 1.0.0
 */
public interface Shape2D<E extends Number, F extends Vector<F, E>> extends Shape<E> {

	/**
	 * Sets the x position of the shape.
	 *
	 * @param x X position.
	 */
	void setX(E x);

	/**
	 * Returns the x position of the shape.
	 *
	 * @return X position.
	 */
	E getX();

	/**
	 * Sets the y position of the shape.
	 *
	 * @param y Y position.
	 */
	void setY(E y);

	/**
	 * Returns the y position of the shape.
	 *
	 * @return Y position.
	 */
	E getY();

	/**
	 * Sets the position of the shape.
	 *
	 * @param x X position.
	 * @param y Y position.
	 */
	default void setPosition(E x, E y) {
		setX(x);
		setY(y);
	}

	/**
	 * Sets the position of the shape.
	 *
	 * @param position Position.
	 */
	void setPosition(F position);

	/**
	 * Returns the position of the shape.
	 *
	 * @return Position.
	 */
	F getPosition();

	/**
	 * Calculates the perimeter of the shape.
	 *
	 * @return Perimeter.
	 */
	E perimeter();

	/**
	 * Returns this shape as rectangle.
	 *
	 * @return Rectangular shape of this one.
	 */
	Rectangle asRectangle();
}
