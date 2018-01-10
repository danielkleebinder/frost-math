package org.frost.math.geometry.circle;

import org.frost.math.vector.Vector2f;

/**
 * A circle holding 3 float values (x, y, radius).
 * <br/>
 * The content of this circle can only be set in the constructor
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyCircle3f extends Circle3f {

	/**
	 * Creates a new <code>ReadOnlyReadOnlyCircle3f</code> instance with the
	 * default x and y values. ReadOnlyReadOnlyCircle3f(0.0f, 0.0f, 0.0f).
	 */
	public ReadOnlyCircle3f() {
		super();
	}

	/**
	 * Creates a new <code>ReadOnlyReadOnlyCircle3f</code> instance with the
	 * given radius. ReadOnlyReadOnlyCircle3f(0.0f, 0.0f, radius).
	 *
	 * @param radius Radius.
	 */
	public ReadOnlyCircle3f(float radius) {
		super(radius);
	}

	/**
	 * Creates a new <code>ReadOnlyReadOnlyCircle3f</code> instance with the
	 * given coordinates and radius.
	 *
	 * @param x X position.
	 * @param y Y position.
	 * @param radius Radius.
	 */
	public ReadOnlyCircle3f(float x, float y, float radius) {
		super(x, y, radius);
	}

	@Override
	public void setPosition(Vector2f position) {
		throw new UnsupportedOperationException("Read only circle does not support this operation");
	}

	@Override
	public void setPosition(Float x, Float y) {
		throw new UnsupportedOperationException("Read only circle does not support this operation");
	}

	@Override
	public void setRadius(Float radius) {
		throw new UnsupportedOperationException("Read only circle does not support this operation");
	}

	@Override
	public void setX(Float x) {
		throw new UnsupportedOperationException("Read only circle does not support this operation");
	}

	@Override
	public void setY(Float y) {
		throw new UnsupportedOperationException("Read only circle does not support this operation");
	}
}
