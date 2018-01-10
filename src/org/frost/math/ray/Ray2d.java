package org.frost.math.ray;

import org.frost.math.vector.Vector2d;

/**
 * Two dimensional ray implementation.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Ray2d extends AbstractRay<Vector2d> {

	/**
	 * Creates a new empty ray with:<br/>
	 * <ul>
	 * <li><code>Origin: Vector2d(0, 0)</code></li>
	 * <li><code>Direction: Vector2d(0, 1)</code></li>
	 * </ul>
	 */
	public Ray2d() {
		this(Vector2d.ZERO, Vector2d.UNIT_Y);
	}

	/**
	 * Creates a new ray with the given origin and direction.
	 *
	 * @param origin Origin.
	 * @param direction Direction.
	 */
	public Ray2d(Vector2d origin, Vector2d direction) {
		super(origin, direction);
	}
}
