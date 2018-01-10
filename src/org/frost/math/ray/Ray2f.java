package org.frost.math.ray;

import org.frost.math.vector.Vector2f;

/**
 * Two dimensional ray implementation.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Ray2f extends AbstractRay<Vector2f> {

	/**
	 * Creates a new empty ray with:<br/>
	 * <ul>
	 * <li><code>Origin: Vector2f(0, 0)</code></li>
	 * <li><code>Direction: Vector2f(0, 1)</code></li>
	 * </ul>
	 */
	public Ray2f() {
		this(Vector2f.ZERO, Vector2f.UNIT_Y);
	}

	/**
	 * Creates a new ray with the given origin and direction.
	 *
	 * @param origin Origin.
	 * @param direction Direction.
	 */
	public Ray2f(Vector2f origin, Vector2f direction) {
		super(origin, direction);
	}
}
