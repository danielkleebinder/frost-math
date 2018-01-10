package org.frost.math.geometry.circle;

import org.frost.math.FastMath;
import org.frost.math.geometry.rectangle.Rectangle;
import org.frost.math.geometry.rectangle.Rectangle4d;
import org.frost.math.vector.Vector2f;

/**
 * A circle holding 3 float values (x, y, radius).
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Circle3f implements Circle<Float, Vector2f> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 9875238645871243L;

	/**
	 * X position of the circle.
	 */
	public float x;
	/**
	 * Y position of the circle.
	 */
	public float y;
	/**
	 * Radius.
	 */
	public float radius;

	/**
	 * Creates a new <code>Circle3f</code> instance with the default x and y
	 * values. Circle3f(0, 0, 0).
	 */
	public Circle3f() {
		this(0);
	}

	/**
	 * Creates a new <code>Circle3f</code> instance with the given radius.
	 * Circle3f(0, 0, radius).
	 *
	 * @param radius Radius.
	 */
	public Circle3f(float radius) {
		this(0, 0, radius);
	}

	/**
	 * Creates a new <code>Circle3f</code> instance with the given coordinates
	 * and radius.
	 *
	 * @param x X position.
	 * @param y Y position.
	 * @param radius Radius.
	 */
	public Circle3f(float x, float y, float radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	@Override
	public void setRadius(Float radius) {
		this.radius = radius;
	}

	@Override
	public Float getRadius() {
		return radius;
	}

	@Override
	public Float diameter() {
		return radius * 2;
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
		return new Vector2f(x, y);
	}

	@Override
	public Float perimeter() {
		return (float) (2 * FastMath.PI * radius);
	}

	@Override
	public Rectangle asRectangle() {
		float d = diameter();
		return new Rectangle4d(x - radius, y - radius, d, d);
	}

	@Override
	public Float volume() {
		return (float) (FastMath.PI * (radius * radius));
	}

	@Override
	public Float surface() {
		return volume();
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 31 * hash + Float.floatToIntBits(this.x);
		hash = 31 * hash + Float.floatToIntBits(this.y);
		hash = 31 * hash + Float.floatToIntBits(this.radius);
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
		final Circle3f other = (Circle3f) obj;
		if (Float.floatToIntBits(this.x) != Float.floatToIntBits(other.x)) {
			return false;
		}
		if (Float.floatToIntBits(this.y) != Float.floatToIntBits(other.y)) {
			return false;
		}
		return Float.floatToIntBits(this.radius) == Float.floatToIntBits(other.radius);
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
