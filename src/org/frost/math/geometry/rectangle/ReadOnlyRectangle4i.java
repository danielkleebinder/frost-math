package org.frost.math.geometry.rectangle;

import org.frost.math.vector.Vector2i;

/**
 * A rectangle holding 4 integer values (x, y, width, height).
 * <br/>
 * The content of this rectangle can only be set in the constructor
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyRectangle4i extends Rectangle4i {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 7685216458L;

	/**
	 * Creates a new <code>ReadOnlyRectangle4i</code> instance with the default
	 * x and y values. ReadOnlyRectangle4i(0.0, 0.0, 0.0, 0.0).
	 */
	public ReadOnlyRectangle4i() {
		super();
	}

	/**
	 * Creates a new <code>ReadOnlyRectangle4i</code> instance with the given
	 * size. ReadOnlyRectangle4i(0.0, 0.0, size, size).
	 *
	 * @param size Size (Width and height).
	 */
	public ReadOnlyRectangle4i(int size) {
		super(size);
	}

	/**
	 * Creates a new <code>ReadOnlyRectangle4i</code> instance with the given
	 * coordiantes. ReadOnlyRectangle4i(x, y, 0.0, 0.0).
	 *
	 * @param x X position.
	 * @param y Y position.
	 */
	public ReadOnlyRectangle4i(int x, int y) {
		super(x, y);
	}

	/**
	 * Creates a new <code>ReadOnlyRectangle4i</code> instance with the given
	 * coordinates and size.
	 *
	 * @param x X position.
	 * @param y Y position.
	 * @param width Width.
	 * @param height Height.
	 */
	public ReadOnlyRectangle4i(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void setWidth(Integer width) {
		throw new UnsupportedOperationException("Read only rectangle does not support this operation");
	}

	@Override
	public void setHeight(Integer height) {
		throw new UnsupportedOperationException("Read only rectangle does not support this operation");
	}

	@Override
	public void setX(Integer x) {
		throw new UnsupportedOperationException("Read only rectangle does not support this operation");
	}

	@Override
	public void setY(Integer y) {
		throw new UnsupportedOperationException("Read only rectangle does not support this operation");
	}

	@Override
	public void setPosition(Vector2i position) {
		throw new UnsupportedOperationException("Read only rectangle does not support this operation");
	}

	@Override
	public void setPosition(Integer x, Integer y) {
		throw new UnsupportedOperationException("Read only rectangle does not support this operation");
	}
}
