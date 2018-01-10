package org.frost.math.ray;

import org.frost.math.vector.Vector2i;

/**
 * Two dimensional ray implementation.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Ray2i extends AbstractRay<Vector2i> {

	/**
	 * Creates a new empty ray with:<br/>
	 * <ul>
	 * <li><code>Origin: Vector2i(0, 0)</code></li>
	 * <li><code>Direction: Vector2i(0, 1)</code></li>
	 * </ul>
	 */
	public Ray2i() {
		this(Vector2i.ZERO, Vector2i.UNIT_Y);
	}

	/**
	 * Creates a new ray with the given origin and direction.
	 *
	 * @param origin Origin.
	 * @param direction Direction.
	 */
	public Ray2i(Vector2i origin, Vector2i direction) {
		super(origin, direction);
	}
}
