package org.frost.math.geometry.circle;

import org.frost.math.vector.Vector2d;

/**
 * A circle holding 3 double values (x, y, radius).
 * <br/>
 * The content of this circle can only be set in the constructor
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyCircle3d extends Circle3d {

	/**
	 * Creates a new <code>ReadOnlyReadOnlyCircle3d</code> instance with the
	 * default x and y values. ReadOnlyReadOnlyCircle3d(0.0, 0.0, 0.0).
	 */
	public ReadOnlyCircle3d() {
		super();
	}

	/**
	 * Creates a new <code>ReadOnlyReadOnlyCircle3d</code> instance with the
	 * given radius. ReadOnlyReadOnlyCircle3d(0.0, 0.0, radius).
	 *
	 * @param radius Radius.
	 */
	public ReadOnlyCircle3d(double radius) {
		super(radius);
	}

	/**
	 * Creates a new <code>ReadOnlyReadOnlyCircle3d</code> instance with the
	 * given coordinates and radius.
	 *
	 * @param x X position.
	 * @param y Y position.
	 * @param radius Radius.
	 */
	public ReadOnlyCircle3d(double x, double y, double radius) {
		super(x, y, radius);
	}

	@Override
	public void setPosition(Vector2d position) {
		throw new UnsupportedOperationException("Read only circle does not support this operation");
	}

	@Override
	public void setPosition(Double x, Double y) {
		throw new UnsupportedOperationException("Read only circle does not support this operation");
	}

	@Override
	public void setRadius(Double radius) {
		throw new UnsupportedOperationException("Read only circle does not support this operation");
	}

	@Override
	public void setX(Double x) {
		throw new UnsupportedOperationException("Read only circle does not support this operation");
	}

	@Override
	public void setY(Double y) {
		throw new UnsupportedOperationException("Read only circle does not support this operation");
	}
}
