package org.frost.math.geometry.circle;

import org.frost.math.vector.Vector2i;

/**
 * A circle holding 3 integer values (x, y, radius).
 * <br/>
 * The content of this circle can only be set in the constructor
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyCircle3i extends Circle3i {

	/**
	 * Creates a new <code>ReadOnlyCircle3i</code> instance with the default x
	 * and y values. ReadOnlyCircle3i(0, 0, 0).
	 */
	public ReadOnlyCircle3i() {
		super();
	}

	/**
	 * Creates a new <code>ReadOnlyCircle3i</code> instance with the given
	 * radius. ReadOnlyCircle3i(0, 0, radius).
	 *
	 * @param radius Radius.
	 */
	public ReadOnlyCircle3i(int radius) {
		super(radius);
	}

	/**
	 * Creates a new <code>ReadOnlyCircle3i</code> instance with the given
	 * coordinates and radius.
	 *
	 * @param x X position.
	 * @param y Y position.
	 * @param radius Radius.
	 */
	public ReadOnlyCircle3i(int x, int y, int radius) {
		super(x, y, radius);
	}

	@Override
	public void setPosition(Vector2i position) {
		throw new UnsupportedOperationException("Read only circle does not support this operation");
	}

	@Override
	public void setPosition(Integer x, Integer y) {
		throw new UnsupportedOperationException("Read only circle does not support this operation");
	}

	@Override
	public void setRadius(Integer radius) {
		throw new UnsupportedOperationException("Read only circle does not support this operation");
	}

	@Override
	public void setX(Integer x) {
		throw new UnsupportedOperationException("Read only circle does not support this operation");
	}

	@Override
	public void setY(Integer y) {
		throw new UnsupportedOperationException("Read only circle does not support this operation");
	}
}
