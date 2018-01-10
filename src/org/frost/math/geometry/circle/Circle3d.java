package org.frost.math.geometry.circle;

import org.frost.math.FastMath;
import org.frost.math.geometry.rectangle.Rectangle;
import org.frost.math.geometry.rectangle.Rectangle4d;
import org.frost.math.vector.Vector2d;

/**
 * A circle holding 3 double values (x, y, radius).
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Circle3d implements Circle<Double, Vector2d> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 9875238645871243L;

	/**
	 * X position of the circle.
	 */
	public double x;
	/**
	 * Y position of the circle.
	 */
	public double y;
	/**
	 * Radius.
	 */
	public double radius;

	/**
	 * Creates a new <code>Circle3d</code> instance with the default x and y
	 * values. Circle3d(0, 0, 0).
	 */
	public Circle3d() {
		this(0);
	}

	/**
	 * Creates a new <code>Circle3d</code> instance with the given radius.
	 * Circle3d(0, 0, radius).
	 *
	 * @param radius Radius.
	 */
	public Circle3d(double radius) {
		this(0, 0, radius);
	}

	/**
	 * Creates a new <code>Circle3d</code> instance with the given coordinates
	 * and radius.
	 *
	 * @param x X position.
	 * @param y Y position.
	 * @param radius Radius.
	 */
	public Circle3d(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	@Override
	public void setRadius(Double radius) {
		this.radius = radius;
	}

	@Override
	public Double getRadius() {
		return radius;
	}

	@Override
	public Double diameter() {
		return radius * 2;
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
		return new Vector2d(x, y);
	}

	@Override
	public Double perimeter() {
		return 2 * FastMath.PI * radius;
	}

	@Override
	public Rectangle asRectangle() {
		double d = diameter();
		return new Rectangle4d(x - radius, y - radius, d, d);
	}

	@Override
	public Double volume() {
		return FastMath.PI * (radius * radius);
	}

	@Override
	public Double surface() {
		return volume();
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.radius) ^ (Double.doubleToLongBits(this.radius) >>> 32));
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
		final Circle3d other = (Circle3d) obj;
		if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
			return false;
		}
		if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
			return false;
		}
		return Double.doubleToLongBits(this.radius) == Double.doubleToLongBits(other.radius);
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
