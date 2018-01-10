package org.frost.math.ray;

import org.frost.math.vector.Vector3i;

/**
 * Three dimensional ray implementation.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Ray3i extends AbstractRay<Vector3i> {

	/**
	 * Creates a new empty ray with:<br/>
	 * <ul>
	 * <li><code>Origin: Vector3i(0, 0, 0)</code></li>
	 * <li><code>Direction: Vector3i(0, 0, 1)</code></li>
	 * </ul>
	 */
	public Ray3i() {
		this(Vector3i.ZERO, Vector3i.UNIT_Z);
	}

	/**
	 * Creates a new ray with the given origin and direction.
	 *
	 * @param origin Origin.
	 * @param direction Direction.
	 */
	public Ray3i(Vector3i origin, Vector3i direction) {
		super(origin, direction);
	}
}
