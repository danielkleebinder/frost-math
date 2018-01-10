package org.frost.math.geometry.rectangle;

import org.frost.math.vector.Vector2i;

/**
 * A rectangle holding 4 integer values (x, y, width, height).
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Rectangle4i implements Rectangle<Integer, Vector2i> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 7685216458L;

	/**
	 * X position of the rectangle.
	 */
	public int x;
	/**
	 * Y position of the rectangle.
	 */
	public int y;
	/**
	 * Width of the rectangle.
	 */
	public int width;
	/**
	 * Height of the rectangle.
	 */
	public int height;

	/**
	 * Creates a new <code>Rectangle4i</code> instance with the default x and y
	 * values. Rectangle4i(0, 0, 0, 0).
	 */
	public Rectangle4i() {
		this(0, 0);
	}

	/**
	 * Creates a new <code>Rectangle4i</code> instance with the given size.
	 * Rectangle4i(0, 0, size, size).
	 *
	 * @param size Size (Width and height).
	 */
	public Rectangle4i(int size) {
		this(0, 0, size, size);
	}

	/**
	 * Creates a new <code>Rectangle4i</code> instance with the given
	 * coordiantes. Rectangle4i(x, y, 0, 0).
	 *
	 * @param x X position.
	 * @param y Y position.
	 */
	public Rectangle4i(int x, int y) {
		this(x, y, 0, 0);
	}

	/**
	 * Creates a new <code>Rectangle4i</code> instance with the given
	 * coordinates and size.
	 *
	 * @param x X position.
	 * @param y Y position.
	 * @param width Width.
	 * @param height Height.
	 */
	public Rectangle4i(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void setWidth(Integer width) {
		this.width = width;
	}

	@Override
	public Integer getWidth() {
		return width;
	}

	@Override
	public void setHeight(Integer height) {
		this.height = height;
	}

	@Override
	public Integer getHeight() {
		return height;
	}

	@Override
	public Vector2i getTopLeft() {
		return new Vector2i(x, y);
	}

	@Override
	public Vector2i getTopRight() {
		return new Vector2i(x + width, y);
	}

	@Override
	public Vector2i getBottomLeft() {
		return new Vector2i(x, y + height);
	}

	@Override
	public Vector2i getBottomRight() {
		return new Vector2i(x + width, y + height);
	}

	@Override
	public void setX(Integer x) {
		this.x = x;
	}

	@Override
	public Integer getX() {
		return x;
	}

	@Override
	public void setY(Integer y) {
		this.y = y;
	}

	@Override
	public Integer getY() {
		return y;
	}

	@Override
	public void setPosition(Vector2i position) {
		x = position.x;
		y = position.y;
	}

	@Override
	public Vector2i getPosition() {
		return getTopLeft();
	}

	@Override
	public Vector2i getCenter() {
		return new Vector2i(x + width / 2, y + height / 2);
	}

	@Override
	public Integer perimeter() {
		return 2 * width + 2 * height;
	}

	@Override
	public Rectangle asRectangle() {
		return this;
	}

	@Override
	public Integer volume() {
		return width * height;
	}

	@Override
	public Integer surface() {
		return volume();
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 37 * hash + this.x;
		hash = 37 * hash + this.y;
		hash = 37 * hash + this.width;
		hash = 37 * hash + this.height;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Rectangle4i other = (Rectangle4i) obj;
		if (this.x != other.x) {
			return false;
		}
		if (this.y != other.y) {
			return false;
		}
		if (this.width != other.width) {
			return false;
		}
		return this.height == other.height;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Rectangle4i{");
		result.append("x=").append(x).append(", ");
		result.append("y=").append(y).append(", ");
		result.append("width=").append(width).append(", ");
		result.append("height=").append(height);
		result.append("}");
		return result.toString();
	}
}
