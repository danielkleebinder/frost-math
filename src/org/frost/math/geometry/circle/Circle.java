package org.frost.math.geometry.circle;

import org.frost.math.geometry.Shape2D;
import org.frost.math.vector.Vector;

/**
 * Interface for all types of circles.
 * <br/>
 * A circle is a shape with a center and a radius discribing a circle.
 *
 * @author Daniel Kleebinder
 * @param <E> Generic number type.
 * @param <F> Generic vector type.
 * @since 1.0.0
 */
public interface Circle<E extends Number, F extends Vector<F, E>> extends Shape2D<E, F> {

	/**
	 * Sets the radius of the circle.
	 *
	 * @param radius Radius.
	 */
	void setRadius(E radius);

	/**
	 * Returns the radius of the circle.
	 *
	 * @return Radius.
	 */
	E getRadius();

	/**
	 * Calculates the diameter of the circle.
	 *
	 * @return Diameter.
	 */
	E diameter();
}
