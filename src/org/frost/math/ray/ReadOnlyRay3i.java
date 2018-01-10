package org.frost.math.ray;

import org.frost.math.vector.Vector3i;

/**
 * Three dimensional ray implementation.
 * <br/>
 * The content of this ray can only be set in the constructor.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyRay3i extends Ray3i {

	/**
	 * Creates a new empty ray with:<br/>
	 * <ul>
	 * <li><code>Origin: Vector3i(0, 0, 0)</code></li>
	 * <li><code>Direction: Vector3i(0, 0, 1)</code></li>
	 * </ul>
	 */
	public ReadOnlyRay3i() {
	}

	/**
	 * Creates a new ray with the given origin and direction.
	 *
	 * @param origin Origin.
	 * @param direction Direction.
	 */
	public ReadOnlyRay3i(Vector3i origin, Vector3i direction) {
		super(origin, direction);
	}

	@Override
	public void setOrigin(Vector3i origin) {
		throw new UnsupportedOperationException("Read only ray does not support this operation");
	}

	@Override
	public void setDirection(Vector3i direction) {
		throw new UnsupportedOperationException("Read only ray does not support this operation");
	}
}
