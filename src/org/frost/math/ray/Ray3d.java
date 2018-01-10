package org.frost.math.ray;

import org.frost.math.vector.Vector3d;

/**
 * Three dimensional ray implementation.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Ray3d extends AbstractRay<Vector3d> {

	/**
	 * Creates a new empty ray with:<br/>
	 * <ul>
	 * <li><code>Origin: Vector3d(0, 0, 0)</code></li>
	 * <li><code>Direction: Vector3d(0, 0, 1)</code></li>
	 * </ul>
	 */
	public Ray3d() {
		this(Vector3d.ZERO, Vector3d.UNIT_Z);
	}

	/**
	 * Creates a new ray with the given origin and direction.
	 *
	 * @param origin Origin.
	 * @param direction Direction.
	 */
	public Ray3d(Vector3d origin, Vector3d direction) {
		super(origin, direction);
	}
}
