package org.frost.math.ray;

import org.frost.math.vector.Vector;

/**
 * All rays should extend this class.
 * <br/>
 * It contains the basic implementation for all rays.
 *
 * @author Daniel Kleebinder
 * @param <E> Generic vector type.
 * @since 1.0.0
 */
public class AbstractRay<E extends Vector> implements Ray<E> {

	/**
	 * Ray origin.
	 */
	public E origin;
	/**
	 * Ray direction.
	 */
	public E direction;

	/**
	 * Creates a new empty ray.
	 */
	public AbstractRay() {
	}

	/**
	 * Creates a ray with the given origin and direction.
	 *
	 * @param origin Origin.
	 * @param direction Direction.
	 */
	public AbstractRay(E origin, E direction) {
		this.origin = origin;
		this.direction = direction;
	}

	@Override
	public void setOrigin(E origin) {
		this.origin = origin;
	}

	@Override
	public E getOrigin() {
		return origin;
	}

	@Override
	public void setDirection(E direction) {
		this.direction = direction;
	}

	@Override
	public E getDirection() {
		return direction;
	}
}
