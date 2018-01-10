package org.frost.math.ray;

import org.frost.math.vector.Vector3d;

/**
 * Three dimensional ray implementation.
 * <br/>
 * The content of this ray can only be set in the constructor.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyRay3d extends Ray3d {

	/**
	 * Creates a new empty ray with:<br/>
	 * <ul>
	 * <li><code>Origin: Vector3d(0, 0, 0)</code></li>
	 * <li><code>Direction: Vector3d(0, 0, 1)</code></li>
	 * </ul>
	 */
	public ReadOnlyRay3d() {
	}

	/**
	 * Creates a new ray with the given origin and direction.
	 *
	 * @param origin Origin.
	 * @param direction Direction.
	 */
	public ReadOnlyRay3d(Vector3d origin, Vector3d direction) {
		super(origin, direction);
	}

	@Override
	public void setOrigin(Vector3d origin) {
		throw new UnsupportedOperationException("Read only ray does not support this operation");
	}

	@Override
	public void setDirection(Vector3d direction) {
		throw new UnsupportedOperationException("Read only ray does not support this operation");
	}
}
