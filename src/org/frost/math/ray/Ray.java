package org.frost.math.ray;

import java.io.Serializable;
import org.frost.math.vector.Vector;

/**
 * Interface for all types of rays.
 * <br/>
 * A ray implementation has to implement this interface.
 *
 * @author Daniel Kleebinder
 * @param <E> Generic used vector.
 * @since 1.0.0
 */
public interface Ray<E extends Vector> extends Serializable {

	/**
	 * Sets the origin of the ray.
	 *
	 * @param origin Origin.
	 */
	void setOrigin(E origin);

	/**
	 * Returns the origin of the ray.
	 *
	 * @return Origin.
	 */
	E getOrigin();

	/**
	 * Sets the direction of the ray.
	 *
	 * @param direction Direction.
	 */
	void setDirection(E direction);

	/**
	 * Returns the direction of the ray.
	 *
	 * @return Direction.
	 */
	E getDirection();
}
