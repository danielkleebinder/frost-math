package org.frost.math.geometry.rectangle;

import org.frost.math.vector.Vector2f;

/**
 * A rectangle holding 4 float values (x, y, width, height).
 * <br/>
 * The content of this rectangle can only be set in the constructor
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyRectangle4f extends Rectangle4f {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 7685216458L;

	/**
	 * Creates a new <code>ReadOnlyRectangle4f</code> instance with the default
	 * x and y values. ReadOnlyRectangle4f(0.0f, 0.0f, 0.0f, 0.0f).
	 */
	public ReadOnlyRectangle4f() {
		super();
	}

	/**
	 * Creates a new <code>ReadOnlyRectangle4f</code> instance with the given
	 * size. ReadOnlyRectangle4f(0.0f, 0.0f, size, size).
	 *
	 * @param size Size (Width and height).
	 */
	public ReadOnlyRectangle4f(float size) {
		super(size);
	}

	/**
	 * Creates a new <code>ReadOnlyRectangle4f</code> instance with the given
	 * coordiantes. ReadOnlyRectangle4f(x, y, 0.0f, 0.0f).
	 *
	 * @param x X position.
	 * @param y Y position.
	 */
	public ReadOnlyRectangle4f(float x, float y) {
		super(x, y);
	}

	/**
	 * Creates a new <code>ReadOnlyRectangle4f</code> instance with the given
	 * coordinates and size.
	 *
	 * @param x X position.
	 * @param y Y position.
	 * @param width Width.
	 * @param height Height.
	 */
	public ReadOnlyRectangle4f(float x, float y, float width, float height) {
		super(x, y, width, height);
	}

	@Override
	public void setWidth(Float width) {
		throw new UnsupportedOperationException("Read only rectangle does not support this operation");
	}

	@Override
	public void setHeight(Float height) {
		throw new UnsupportedOperationException("Read only rectangle does not support this operation");
	}

	@Override
	public void setX(Float x) {
		throw new UnsupportedOperationException("Read only rectangle does not support this operation");
	}

	@Override
	public void setY(Float y) {
		throw new UnsupportedOperationException("Read only rectangle does not support this operation");
	}

	@Override
	public void setPosition(Vector2f position) {
		throw new UnsupportedOperationException("Read only rectangle does not support this operation");
	}

	@Override
	public void setPosition(Float x, Float y) {
		throw new UnsupportedOperationException("Read only rectangle does not support this operation");
	}
}
