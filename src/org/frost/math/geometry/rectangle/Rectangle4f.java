package org.frost.math.geometry.rectangle;

import org.frost.math.vector.Vector2f;

/**
 * A rectangle holding 4 float values (x, y, width, height).
 *
 * @author Daniel Kleebinder
 * @since 1.0.0f
 */
public class Rectangle4f implements Rectangle<Float, Vector2f> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 7685216458L;

	/**
	 * X position of the rectangle.
	 */
	public float x;
	/**
	 * Y position of the rectangle.
	 */
	public float y;
	/**
	 * Width of the rectangle.
	 */
	public float width;
	/**
	 * Height of the rectangle.
	 */
	public float height;

	/**
	 * Creates a new <code>Rectangle4f</code> instance with the default x and y
	 * values. Rectangle4f(0.0f, 0.0f, 0.0f, 0.0f).
	 */
	public Rectangle4f() {
		this(0, 0);
	}

	/**
	 * Creates a new <code>Rectangle4f</code> instance with the given size.
	 * Rectangle4f(0.0f, 0.0f, size, size).
	 *
	 * @param size Size (Width and height).
	 */
	public Rectangle4f(float size) {
		this(0, 0, size, size);
	}

	/**
	 * Creates a new <code>Rectangle4f</code> instance with the given
	 * coordiantes. Rectangle4f(x, y, 0.0f, 0.0f).
	 *
	 * @param x X position.
	 * @param y Y position.
	 */
	public Rectangle4f(float x, float y) {
		this(x, y, 0, 0);
	}

	/**
	 * Creates a new <code>Rectangle4f</code> instance with the given
	 * coordinates and size.
	 *
	 * @param x X position.
	 * @param y Y position.
	 * @param width Width.
	 * @param height Height.
	 */
	public Rectangle4f(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void setWidth(Float width) {
		this.width = width;
	}

	@Override
	public Float getWidth() {
		return width;
	}

	@Override
	public void setHeight(Float height) {
		this.height = height;
	}

	@Override
	public Float getHeight() {
		return height;
	}

	@Override
	public Vector2f getTopLeft() {
		return new Vector2f(x, y);
	}

	@Override
	public Vector2f getTopRight() {
		return new Vector2f(x + width, y);
	}

	@Override
	public Vector2f getBottomLeft() {
		return new Vector2f(x, y + height);
	}

	@Override
	public Vector2f getBottomRight() {
		return new Vector2f(x + width, y + height);
	}

	@Override
	public void setX(Float x) {
		this.x = x;
	}

	@Override
	public Float getX() {
		return x;
	}

	@Override
	public void setY(Float y) {
		this.y = y;
	}

	@Override
	public Float getY() {
		return y;
	}

	@Override
	public void setPosition(Vector2f position) {
		x = position.x;
		y = position.y;
	}

	@Override
	public Vector2f getPosition() {
		return getTopLeft();
	}

	@Override
	public Vector2f getCenter() {
		return new Vector2f(x + width / 2, y + height / 2);
	}

	@Override
	public Float perimeter() {
		return 2 * width + 2 * height;
	}

	@Override
	public Rectangle asRectangle() {
		return this;
	}

	@Override
	public Float volume() {
		return width * height;
	}

	@Override
	public Float surface() {
		return volume();
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 41 * hash + Float.floatToIntBits(this.x);
		hash = 41 * hash + Float.floatToIntBits(this.y);
		hash = 41 * hash + Float.floatToIntBits(this.width);
		hash = 41 * hash + Float.floatToIntBits(this.height);
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
		final Rectangle4f other = (Rectangle4f) obj;
		if (Float.floatToIntBits(this.x) != Float.floatToIntBits(other.x)) {
			return false;
		}
		if (Float.floatToIntBits(this.y) != Float.floatToIntBits(other.y)) {
			return false;
		}
		if (Float.floatToIntBits(this.width) != Float.floatToIntBits(other.width)) {
			return false;
		}
		return Float.floatToIntBits(this.height) == Float.floatToIntBits(other.height);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Rectangle4f{");
		result.append("x=").append(x).append(", ");
		result.append("y=").append(y).append(", ");
		result.append("width=").append(width).append(", ");
		result.append("height=").append(height);
		result.append("}");
		return result.toString();
	}
}
