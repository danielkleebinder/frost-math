package org.frost.math.geometry.rectangle;

import org.frost.math.vector.Vector2d;

/**
 * A rectangle holding 4 double values (x, y, width, height).
 * <br/>
 * The content of this rectangle can only be set in the constructor
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyRectangle4d extends Rectangle4d {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 7685216458L;

	/**
	 * Creates a new <code>ReadOnlyRectangle4d</code> instance with the default
	 * x and y values. ReadOnlyRectangle4d(0.0, 0.0, 0.0, 0.0).
	 */
	public ReadOnlyRectangle4d() {
		super();
	}

	/**
	 * Creates a new <code>ReadOnlyRectangle4d</code> instance with the given
	 * size. ReadOnlyRectangle4d(0.0, 0.0, size, size).
	 *
	 * @param size Size (Width and height).
	 */
	public ReadOnlyRectangle4d(double size) {
		super(size);
	}

	/**
	 * Creates a new <code>ReadOnlyRectangle4d</code> instance with the given
	 * coordiantes. ReadOnlyRectangle4d(x, y, 0.0, 0.0).
	 *
	 * @param x X position.
	 * @param y Y position.
	 */
	public ReadOnlyRectangle4d(double x, double y) {
		super(x, y);
	}

	/**
	 * Creates a new <code>ReadOnlyRectangle4d</code> instance with the given
	 * coordinates and size.
	 *
	 * @param x X position.
	 * @param y Y position.
	 * @param width Width.
	 * @param height Height.
	 */
	public ReadOnlyRectangle4d(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

	@Override
	public void setWidth(Double width) {
		throw new UnsupportedOperationException("Read only rectangle does not support this operation");
	}

	@Override
	public void setHeight(Double height) {
		throw new UnsupportedOperationException("Read only rectangle does not support this operation");
	}

	@Override
	public void setX(Double x) {
		throw new UnsupportedOperationException("Read only rectangle does not support this operation");
	}

	@Override
	public void setY(Double y) {
		throw new UnsupportedOperationException("Read only rectangle does not support this operation");
	}

	@Override
	public void setPosition(Vector2d position) {
		throw new UnsupportedOperationException("Read only rectangle does not support this operation");
	}

	@Override
	public void setPosition(Double x, Double y) {
		throw new UnsupportedOperationException("Read only rectangle does not support this operation");
	}
}
