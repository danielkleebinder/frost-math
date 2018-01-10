package org.frost.math.ray;

import org.frost.math.vector.Vector2d;

/**
 * Two dimensional ray implementation.
 * <br/>
 * The content of this ray can only be set in the constructor.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyRay2d extends Ray2d {

	/**
	 * Creates a new empty ray with:<br/>
	 * <ul>
	 * <li><code>Origin: Vector2d(0, 0)</code></li>
	 * <li><code>Direction: Vector2d(0, 1)</code></li>
	 * </ul>
	 */
	public ReadOnlyRay2d() {
	}

	/**
	 * Creates a new ray with the given origin and direction.
	 *
	 * @param origin Origin.
	 * @param direction Direction.
	 */
	public ReadOnlyRay2d(Vector2d origin, Vector2d direction) {
		super(origin, direction);
	}

	@Override
	public void setOrigin(Vector2d origin) {
		throw new UnsupportedOperationException("Read only ray does not support this operation");
	}

	@Override
	public void setDirection(Vector2d direction) {
		throw new UnsupportedOperationException("Read only ray does not support this operation");
	}
}
