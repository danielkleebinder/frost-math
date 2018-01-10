package org.frost.math.ray;

import org.frost.math.vector.Vector3f;

/**
 * Three dimensional ray implementation.
 * <br/>
 * The content of this ray can only be set in the constructor.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyRay3f extends Ray3f {

	/**
	 * Creates a new empty ray with:<br/>
	 * <ul>
	 * <li><code>Origin: Vector3f(0, 0, 0)</code></li>
	 * <li><code>Direction: Vector3f(0, 0, 1)</code></li>
	 * </ul>
	 */
	public ReadOnlyRay3f() {
	}

	/**
	 * Creates a new ray with the given origin and direction.
	 *
	 * @param origin Origin.
	 * @param direction Direction.
	 */
	public ReadOnlyRay3f(Vector3f origin, Vector3f direction) {
		super(origin, direction);
	}

	@Override
	public void setOrigin(Vector3f origin) {
		throw new UnsupportedOperationException("Read only ray does not support this operation");
	}

	@Override
	public void setDirection(Vector3f direction) {
		throw new UnsupportedOperationException("Read only ray does not support this operation");
	}
}
