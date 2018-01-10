package org.frost.math.ray;

import org.frost.math.vector.Vector2i;

/**
 * Two dimensional ray implementation.
 * <br/>
 * The content of this ray can only be set in the constructor.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyRay2i extends Ray2i {

	/**
	 * Creates a new empty ray with:<br/>
	 * <ul>
	 * <li><code>Origin: Vector2i(0, 0)</code></li>
	 * <li><code>Direction: Vector2i(0, 1)</code></li>
	 * </ul>
	 */
	public ReadOnlyRay2i() {
	}

	/**
	 * Creates a new ray with the given origin and direction.
	 *
	 * @param origin Origin.
	 * @param direction Direction.
	 */
	public ReadOnlyRay2i(Vector2i origin, Vector2i direction) {
		super(origin, direction);
	}

	@Override
	public void setOrigin(Vector2i origin) {
		throw new UnsupportedOperationException("Read only ray does not support this operation");
	}

	@Override
	public void setDirection(Vector2i direction) {
		throw new UnsupportedOperationException("Read only ray does not support this operation");
	}
}
