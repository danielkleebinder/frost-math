package org.frost.math.vector;

import org.frost.math.FastMath;

/**
 * A vector holding 2 double values.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Vector2d implements Vector<Vector2d, Double> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 87658455L;

	/**
	 * A zero vector, Vector2d(0, 0).
	 */
	public static final Vector2d ZERO = new ReadOnlyVector2d(0, 0);
	/**
	 * A unit x vector, Vector2d(1, 0).
	 */
	public static final Vector2d UNIT_X = new ReadOnlyVector2d(1, 0);
	/**
	 * A unit y vector, Vector2d(0, 1).
	 */
	public static final Vector2d UNIT_Y = new ReadOnlyVector2d(0, 1);
	/**
	 * A zero vector, Vector2d(1, 1).
	 */
	public static final Vector2d UNIT_XY = new ReadOnlyVector2d(1, 1);
	/**
	 * A unit x vector, Vector2d(-1, 0).
	 */
	public static final Vector2d UNIT_NEGATIVE_X = new ReadOnlyVector2d(-1, 0);
	/**
	 * A unit y vector, Vector2d(0, -1).
	 */
	public static final Vector2d UNIT_NEGATIVE_Y = new ReadOnlyVector2d(0, -1);
	/**
	 * A zero vector, Vector2d(-1, -1).
	 */
	public static final Vector2d UNIT_NEGATIVE_XY = new ReadOnlyVector2d(-1, -1);

	/**
	 * The x value of the vector.
	 */
	public double x;
	/**
	 * The y value of the vector.
	 */
	public double y;

	/**
	 * Creates a new <code>Vector2d</code> instance with the default x and y
	 * values. Vector2d(0.0, 0.0).
	 */
	public Vector2d() {
		this(0, 0);
	}

	/**
	 * Creates a new <code>Vector2d</code> instance with the given x and y
	 * values.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 */
	public Vector2d(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Creates a new <code>Vector2d</code> instance with the given values.
	 *
	 * @param v Values.
	 */
	public Vector2d(double... v) {
		switch (v.length) {
			case 2:
				y = v[1];
			case 1:
				x = v[0];
		}
	}

	/**
	 * Creates a new <code>Vector2d</code> instance from the given
	 * <code>Vector2d</code>.
	 *
	 * @param copy Vector from where the values are copied.
	 */
	public Vector2d(Vector2d copy) {
		x = copy.x;
		y = copy.y;
	}

	/**
	 * Sets the vectors x and y values to the given ones.
	 *
	 * @param x The new x value.
	 * @param y The new y value.
	 * @return This vector.
	 */
	public Vector2d set(double x, double y) {
		this.x = x;
		this.y = y;
		return this;
	}

	@Override
	public Vector2d set(Vector2d vec) {
		x = vec.x;
		y = vec.y;
		return this;
	}

	/**
	 * Sets the x value in this vector.
	 *
	 * @param x X value.
	 */
	public void setX(Double x) {
		this.x = x;
	}

	/**
	 * Returns the x value.
	 *
	 * @return X value.
	 */
	public Double getX() {
		return x;
	}

	/**
	 * Sets the y value in this vector.
	 *
	 * @param y Y value.
	 */
	public void setY(Double y) {
		this.y = y;
	}

	/**
	 * Returns the y value.
	 *
	 * @return Y value.
	 */
	public Double getY() {
		return y;
	}

	@Override
	public Vector2d add(Double v) {
		return new Vector2d(this).addLocal(v);
	}

	/**
	 * Adds the given values to this vector and returns a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @return New vector.
	 */
	public Vector2d add(Double x, Double y) {
		return new Vector2d(this).addLocal(x, y);
	}

	@Override
	public Vector2d add(Vector2d vec) {
		return new Vector2d(this).addLocal(vec);
	}

	/**
	 * Adds the given values to this vector.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @return This vector.
	 */
	public Vector2d addLocal(Double x, Double y) {
		this.x += x;
		this.y += y;
		return this;
	}

	@Override
	public Vector2d addLocal(Double v) {
		return addLocal(v, v);
	}

	@Override
	public Vector2d addLocal(Vector2d vec) {
		x += vec.x;
		y += vec.y;
		return this;
	}

	@Override
	public Vector2d subtract(Double v) {
		return new Vector2d(this).subtractLocal(v);
	}

	/**
	 * Subtracts the given values from this vector and writes them to a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @return New vector.
	 */
	public Vector2d subtract(Double x, Double y) {
		return new Vector2d(this).subtractLocal(x, y);
	}

	@Override
	public Vector2d subtract(Vector2d vec) {
		return new Vector2d(this).subtractLocal(vec);
	}

	@Override
	public Vector2d subtractLocal(Double v) {
		x -= v;
		y -= v;
		return this;
	}

	/**
	 * Subtracts the given values from this vector.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @return This vector.
	 */
	public Vector2d subtractLocal(Double x, Double y) {
		this.x -= x;
		this.y -= y;
		return this;
	}

	@Override
	public Vector2d subtractLocal(Vector2d vec) {
		x -= vec.x;
		y -= vec.y;
		return this;
	}

	@Override
	public Vector2d multiplicate(Double v) {
		return new Vector2d(this).multiplicateLocal(v);
	}

	/**
	 * Multiplicates this vector with the given values and writes the to a new
	 * one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @return New vector.
	 */
	public Vector2d multiplicate(Double x, Double y) {
		return new Vector2d(this).multiplicateLocal(x, y);
	}

	@Override
	public Vector2d multiplicate(Vector2d vec) {
		return new Vector2d(this).multiplicateLocal(vec);
	}

	@Override
	public Vector2d multiplicateLocal(Double v) {
		x *= v;
		y *= v;
		return this;
	}

	/**
	 * Multiplicates this vector with the given values.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @return This vector.
	 */
	public Vector2d multiplicateLocal(Double x, Double y) {
		this.x *= x;
		this.y *= y;
		return this;
	}

	@Override
	public Vector2d multiplicateLocal(Vector2d vec) {
		x *= vec.x;
		y *= vec.y;
		return this;
	}

	@Override
	public Vector2d divide(Double v) {
		return new Vector2d(this).divideLocal(v);
	}

	/**
	 * Divides this vector by the given values and writes them to a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @return New vector.
	 */
	public Vector2d divide(Double x, Double y) {
		return new Vector2d(this).divideLocal(x, y);
	}

	@Override
	public Vector2d divide(Vector2d vec) {
		return new Vector2d(this).divideLocal(vec);
	}

	@Override
	public Vector2d divideLocal(Double v) {
		x /= v;
		y /= v;
		return this;
	}

	/**
	 * Divides this vector by the given values.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @return This vector.
	 */
	public Vector2d divideLocal(Double x, Double y) {
		this.x /= x;
		this.y /= y;
		return this;
	}

	@Override
	public Vector2d divideLocal(Vector2d vec) {
		x /= vec.x;
		y /= vec.y;
		return this;
	}

	@Override
	public double dot(Vector2d vec) {
		return x * vec.x + y * vec.y;
	}

	@Override
	public Vector2d cross(Vector2d vec) {
		double det = determinant(vec);
		return new Vector2d(det, det);
	}

	@Override
	public double determinant(Vector2d vec) {
		return (x * vec.x) - (y * vec.y);
	}

	@Override
	public Vector2d abs() {
		x = FastMath.abs(x);
		y = FastMath.abs(y);
		return this;
	}

	@Override
	public Vector2d clampMin(Double min) {
		x = FastMath.max(x, min);
		y = FastMath.max(y, min);
		return this;
	}

	@Override
	public Vector2d clampMax(Double max) {
		x = FastMath.min(x, max);
		y = FastMath.min(y, max);
		return this;
	}

	@Override
	public Double length() {
		return FastMath.sqrt(lengthSquared());
	}

	@Override
	public Double lengthSquared() {
		return x * x + y * y;
	}

	@Override
	public Double distance(Vector2d vec) {
		return FastMath.sqrt(distanceSquared(vec));
	}

	@Override
	public Double distanceSquared(Vector2d vec) {
		double dx = x - vec.x;
		double dy = y - vec.y;
		return dx * dx + dy * dy;
	}

	@Override
	public Vector2d negate() {
		return new Vector2d(this).negateLocal();
	}

	@Override
	public Vector2d negateLocal() {
		x = -x;
		y = -y;
		return this;
	}

	@Override
	public Vector2d normalize() {
		return new Vector2d(this).normalizeLocal();
	}

	@Override
	public Vector2d normalizeLocal() {
		double length = lengthSquared();
		if (length != 1.0f && length != 0.0f) {
			length = 1.0f / FastMath.sqrt(length);
			multiplicateLocal(length);
		}
		return this;
	}

	@Override
	public Vector2d zero() {
		return fill(0.0);
	}

	@Override
	public Vector2d one() {
		return fill(1.0);
	}

	@Override
	public Vector2d fill(Double v) {
		x = y = v;
		return this;
	}

	@Override
	public Vector2d max(Vector2d vec) {
		return new Vector2d(this).maxLocal(vec);
	}

	@Override
	public Vector2d maxLocal(Vector2d vec) {
		x = FastMath.max(x, vec.x);
		y = FastMath.max(y, vec.y);
		return this;
	}

	@Override
	public Vector2d min(Vector2d vec) {
		return new Vector2d(this).minLocal(vec);
	}

	@Override
	public Vector2d minLocal(Vector2d vec) {
		x = FastMath.min(x, vec.x);
		y = FastMath.min(y, vec.y);
		return this;
	}

	@Override
	public Vector2d clamp(Vector2d vec1, Vector2d vec2) {
		return new Vector2d(this).clampLocal(vec1, vec2);
	}

	@Override
	public Vector2d clampLocal(Vector2d vec1, Vector2d vec2) {
		x = FastMath.clamp(x, vec1.x, vec2.x);
		y = FastMath.clamp(y, vec1.y, vec2.y);
		return this;
	}

	@Override
	public Vector2d put(int i, Double v) {
		if (i == 0) {
			x = v;
		}
		if (i == 1) {
			y = v;
		}

		throw new IllegalArgumentException("Index not in range!");
	}

	@Override
	public Double get(int i) {
		if (i == 0) {
			return x;
		}
		if (i == 1) {
			return y;
		}

		throw new IllegalArgumentException("Index not in range!");
	}

	@Override
	public boolean isOne() {
		return isUnified(1.0);
	}

	@Override
	public boolean isZero() {
		return isUnified(0.0);
	}

	@Override
	public boolean isUnified(Double v) {
		return x == v && y == v;
	}

	@Override
	public boolean isNaNVector() {
		return Double.isNaN(x) || Double.isNaN(y);
	}

	@Override
	public boolean isInfiniteVector() {
		return Double.isInfinite(x) || Double.isInfinite(y);
	}

	@Override
	public boolean isUnitVector() {
		double length = length();
		return 0.999999999d < length && length < 1.000000001d;
	}

	@Override
	public void fromArray(Double... array) {
		x = array[0];
		y = array[1];
	}

	@Override
	public Double[] toArray() {
		return new Double[]{x, y};
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 89 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
		hash = 89 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
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
		final Vector2d other = (Vector2d) obj;
		if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
			return false;
		}
		return Double.doubleToLongBits(this.y) == Double.doubleToLongBits(other.y);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Vector2d{");
		result.append(x).append(", ");
		result.append(y);
		result.append("}");
		return result.toString();
	}

	@Override
	public Vector2d clone() throws CloneNotSupportedException {
		return (Vector2d) super.clone();
	}
}
