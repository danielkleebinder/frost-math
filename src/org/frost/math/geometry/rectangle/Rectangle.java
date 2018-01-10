package org.frost.math.geometry.rectangle;

import org.frost.math.geometry.Shape2D;
import org.frost.math.vector.Vector;

/**
 * Interface for all types of rectangles.
 * <br/>
 * A rectangle is a shape with 4 edges and 4 sides.
 *
 * @author Daniel Kleebinder
 * @param <E> Generic number type.
 * @param <F> Generic vector type.
 * @since 1.0.0
 */
public interface Rectangle<E extends Number, F extends Vector<F, E>> extends Shape2D<E, F> {

	/**
	 * Sets the width of the rectangle.
	 *
	 * @param width Width.
	 */
	void setWidth(E width);

	/**
	 * Returns the width of the rectangle.
	 *
	 * @return Width.
	 */
	E getWidth();

	/**
	 * Sets the height of the rectangle.
	 *
	 * @param height Height.
	 */
	void setHeight(E height);

	/**
	 * Returns the height of the rectangle.
	 *
	 * @return Height.
	 */
	E getHeight();

	/**
	 * Returns the top left coordinate of the rectangle.
	 *
	 * @return Top left coordinate.
	 */
	F getTopLeft();

	/**
	 * Returns the top right coordinate of the rectangle.
	 *
	 * @return Top right coordinate.
	 */
	F getTopRight();

	/**
	 * Returns the bottom left coordinate of the rectangle.
	 *
	 * @return Bottom left coordinate.
	 */
	F getBottomLeft();

	/**
	 * Returns the bottom right coordinate of the rectangle.
	 *
	 * @return Bottom right coordinate.
	 */
	F getBottomRight();

	/**
	 * Returns the center position of the rectangle.
	 *
	 * @return Center position.
	 */
	F getCenter();
}
