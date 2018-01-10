package org.frost.math.ray;

import org.frost.math.vector.Vector2f;

/**
 * Two dimensional ray implementation.
 * <br/>
 * The content of this ray can only be set in the constructor.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyRay2f extends Ray2f {

	/**
	 * Creates a new empty ray with:<br/>
	 * <ul>
	 * <li><code>Origin: Vector2f(0, 0)</code></li>
	 * <li><code>Direction: Vector2f(0, 1)</code></li>
	 * </ul>
	 */
	public ReadOnlyRay2f() {
	}

	/**
	 * Creates a new ray with the given origin and direction.
	 *
	 * @param origin Origin.
	 * @param direction Direction.
	 */
	public ReadOnlyRay2f(Vector2f origin, Vector2f direction) {
		super(origin, direction);
	}

	@Override
	public void setOrigin(Vector2f origin) {
		throw new UnsupportedOperationException("Read only ray does not support this operation");
	}

	@Override
	public void setDirection(Vector2f direction) {
		throw new UnsupportedOperationException("Read only ray does not support this operation");
	}
}
