package org.frost.math.ray;

import org.frost.math.vector.Vector3f;

/**
 * Three dimensional ray implementation.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Ray3f extends AbstractRay<Vector3f> {

	/**
	 * Creates a new empty ray with:<br/>
	 * <ul>
	 * <li><code>Origin: Vector3f(0, 0, 0)</code></li>
	 * <li><code>Direction: Vector3f(0, 0, 1)</code></li>
	 * </ul>
	 */
	public Ray3f() {
		this(Vector3f.ZERO, Vector3f.UNIT_Z);
	}

	/**
	 * Creates a new ray with the given origin and direction.
	 *
	 * @param origin Origin.
	 * @param direction Direction.
	 */
	public Ray3f(Vector3f origin, Vector3f direction) {
		super(origin, direction);
	}
}
