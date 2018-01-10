package org.frost.math.geometry.rectangle;

import org.frost.math.vector.Vector2d;

/**
 * A rectangle holding 4 double values (x, y, width, height).
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Rectangle4d implements Rectangle<Double, Vector2d> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 7685216458L;

	/**
	 * X position of the rectangle.
	 */
	public double x;
	/**
	 * Y position of the rectangle.
	 */
	public double y;
	/**
	 * Width of the rectangle.
	 */
	public double width;
	/**
	 * Height of the rectangle.
	 */
	public double height;

	/**
	 * Creates a new <code>Rectangle4d</code> instance with the default x and y
	 * values. Rectangle4d(0.0, 0.0, 0.0, 0.0).
	 */
	public Rectangle4d() {
		this(0, 0);
	}

	/**
	 * Creates a new <code>Rectangle4d</code> instance with the given size.
	 * Rectangle4d(0.0, 0.0, size, size).
	 *
	 * @param size Size (Width and height).
	 */
	public Rectangle4d(double size) {
		this(0, 0, size, size);
	}

	/**
	 * Creates a new <code>Rectangle4d</code> instance with the given
	 * coordiantes. Rectangle4d(x, y, 0.0, 0.0).
	 *
	 * @param x X position.
	 * @param y Y position.
	 */
	public Rectangle4d(double x, double y) {
		this(x, y, 0, 0);
	}

	/**
	 * Creates a new <code>Rectangle4d</code> instance with the given
	 * coordinates and size.
	 *
	 * @param x X position.
	 * @param y Y position.
	 * @param width Width.
	 * @param height Height.
	 */
	public Rectangle4d(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void setWidth(Double width) {
		this.width = width;
	}

	@Override
	public Double getWidth() {
		return width;
	}

	@Override
	public void setHeight(Double height) {
		this.height = height;
	}

	@Override
	public Double getHeight() {
		return height;
	}

	@Override
	public Vector2d getTopLeft() {
		return new Vector2d(x, y);
	}

	@Override
	public Vector2d getTopRight() {
		return new Vector2d(x + width, y);
	}

	@Override
	public Vector2d getBottomLeft() {
		return new Vector2d(x, y + height);
	}

	@Override
	public Vector2d getBottomRight() {
		return new Vector2d(x + width, y + height);
	}

	@Override
	public void setX(Double x) {
		this.x = x;
	}

	@Override
	public Double getX() {
		return x;
	}

	@Override
	public void setY(Double y) {
		this.y = y;
	}

	@Override
	public Double getY() {
		return y;
	}

	@Override
	public void setPosition(Vector2d position) {
		x = position.x;
		y = position.y;
	}

	@Override
	public Vector2d getPosition() {
		return getTopLeft();
	}

	@Override
	public Vector2d getCenter() {
		return new Vector2d(x + width / 2, y + height / 2);
	}

	@Override
	public Double perimeter() {
		return 2 * width + 2 * height;
	}

	@Override
	public Rectangle asRectangle() {
		return this;
	}

	@Override
	public Double volume() {
		return width * height;
	}

	@Override
	public Double surface() {
		return volume();
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 23 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
		hash = 23 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
		hash = 23 * hash + (int) (Double.doubleToLongBits(this.width) ^ (Double.doubleToLongBits(this.width) >>> 32));
		hash = 23 * hash + (int) (Double.doubleToLongBits(this.height) ^ (Double.doubleToLongBits(this.height) >>> 32));
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
		final Rectangle4d other = (Rectangle4d) obj;
		if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
			return false;
		}
		if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
			return false;
		}
		if (Double.doubleToLongBits(this.width) != Double.doubleToLongBits(other.width)) {
			return false;
		}
		return Double.doubleToLongBits(this.height) == Double.doubleToLongBits(other.height);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Rectangle4d{");
		result.append("x=").append(x).append(", ");
		result.append("y=").append(y).append(", ");
		result.append("width=").append(width).append(", ");
		result.append("height=").append(height);
		result.append("}");
		return result.toString();
	}
}
