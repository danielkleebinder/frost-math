package org.frost.math.geometry.circle;

import org.frost.math.FastMath;
import org.frost.math.geometry.rectangle.Rectangle;
import org.frost.math.geometry.rectangle.Rectangle4i;
import org.frost.math.vector.Vector2i;

/**
 * A circle holding 3 integer values (x, y, radius).
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Circle3i implements Circle<Integer, Vector2i> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 9875238645871243L;

	/**
	 * X position of the circle.
	 */
	public int x;
	/**
	 * Y position of the circle.
	 */
	public int y;
	/**
	 * Radius.
	 */
	public int radius;

	/**
	 * Creates a new <code>Circle3i</code> instance with the default x and y
	 * values. Circle3i(0, 0, 0).
	 */
	public Circle3i() {
		this(0);
	}

	/**
	 * Creates a new <code>Circle3i</code> instance with the given radius.
	 * Circle3i(0, 0, radius).
	 *
	 * @param radius Radius.
	 */
	public Circle3i(int radius) {
		this(0, 0, radius);
	}

	/**
	 * Creates a new <code>Circle3i</code> instance with the given coordinates
	 * and radius.
	 *
	 * @param x X position.
	 * @param y Y position.
	 * @param radius Radius.
	 */
	public Circle3i(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	@Override
	public void setRadius(Integer radius) {
		this.radius = radius;
	}

	@Override
	public Integer getRadius() {
		return radius;
	}

	@Override
	public Integer diameter() {
		return radius * 2;
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
		return new Vector2i(x, y);
	}

	@Override
	public Integer perimeter() {
		return FastMath.roundToInt(2 * FastMath.PI * radius);
	}

	@Override
	public Rectangle asRectangle() {
		int d = diameter();
		return new Rectangle4i(x - radius, y - radius, d, d);
	}

	@Override
	public Integer volume() {
		return FastMath.roundToInt(FastMath.PI * (radius * radius));
	}

	@Override
	public Integer surface() {
		return volume();
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 89 * hash + this.x;
		hash = 89 * hash + this.y;
		hash = 89 * hash + this.radius;
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
		final Circle3i other = (Circle3i) obj;
		if (this.x != other.x) {
			return false;
		}
		if (this.y != other.y) {
			return false;
		}
		return this.radius == other.radius;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Circle3i{");
		result.append("x=").append(x).append(", ");
		result.append("y=").append(y).append(", ");
		result.append("radius=").append(radius);
		result.append("}");
		return result.toString();
	}
}
