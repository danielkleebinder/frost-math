package org.frost.math.vector;

import org.frost.math.FastMath;

/**
 * A vector holding 2 float values.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Vector2f implements Vector<Vector2f, Float> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 11111117865124688L;

	/**
	 * A zero vector, Vector2f(0, 0).
	 */
	public static final Vector2f ZERO = new ReadOnlyVector2f(0, 0);
	/**
	 * A unit x vector, Vector2f(1, 0).
	 */
	public static final Vector2f UNIT_X = new ReadOnlyVector2f(1, 0);
	/**
	 * A unit y vector, Vector2f(0, 1).
	 */
	public static final Vector2f UNIT_Y = new ReadOnlyVector2f(0, 1);
	/**
	 * A zero vector, Vector2f(1, 1).
	 */
	public static final Vector2f UNIT_XY = new ReadOnlyVector2f(1, 1);
	/**
	 * A unit x vector, Vector2f(-1, 0).
	 */
	public static final Vector2f UNIT_NEGATIVE_X = new ReadOnlyVector2f(-1, 0);
	/**
	 * A unit y vector, Vector2f(0, -1).
	 */
	public static final Vector2f UNIT_NEGATIVE_Y = new ReadOnlyVector2f(0, -1);
	/**
	 * A zero vector, Vector2f(-1, -1).
	 */
	public static final Vector2f UNIT_NEGATIVE_XY = new ReadOnlyVector2f(-1, -1);

	/**
	 * The x value of the vector.
	 */
	public float x;
	/**
	 * The y value of the vector.
	 */
	public float y;

	/**
	 * Creates a new <code>Vector2f</code> instance with the default x and y
	 * values. Vector2f(0.0f, 0.0f).
	 */
	public Vector2f() {
		this(0, 0);
	}

	/**
	 * Creates a new <code>Vector2f</code> instance with the given x and y
	 * values.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 */
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Creates a new <code>Vector2f</code> instance with the given values.
	 *
	 * @param v Values.
	 */
	public Vector2f(float... v) {
		switch (v.length) {
			case 2:
				y = v[1];
			case 1:
				x = v[0];
		}
	}

	/**
	 * Creates a new <code>Vector2f</code> instance from the given
	 * <code>Vector2f</code>.
	 *
	 * @param copy Vector from where the values are copied.
	 */
	public Vector2f(Vector2f copy) {
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
	public Vector2f set(float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}

	@Override
	public Vector2f set(Vector2f vec) {
		x = vec.x;
		y = vec.y;
		return this;
	}

	/**
	 * Sets the x value in this vector.
	 *
	 * @param x X value.
	 */
	public void setX(Float x) {
		this.x = x;
	}

	/**
	 * Returns the x value.
	 *
	 * @return X value.
	 */
	public Float getX() {
		return x;
	}

	/**
	 * Sets the y value in this vector.
	 *
	 * @param y Y value.
	 */
	public void setY(Float y) {
		this.y = y;
	}

	/**
	 * Returns the y value.
	 *
	 * @return Y value.
	 */
	public Float getY() {
		return y;
	}

	@Override
	public Vector2f add(Float v) {
		return new Vector2f(this).addLocal(v);
	}

	/**
	 * Adds the given values to this vector and returns a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @return New vector.
	 */
	public Vector2f add(Float x, Float y) {
		return new Vector2f(this).addLocal(x, y);
	}

	@Override
	public Vector2f add(Vector2f vec) {
		return new Vector2f(this).addLocal(vec);
	}

	/**
	 * Adds the given values to this vector.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @return This vector.
	 */
	public Vector2f addLocal(Float x, Float y) {
		this.x += x;
		this.y += y;
		return this;
	}

	@Override
	public Vector2f addLocal(Float v) {
		return addLocal(v, v);
	}

	@Override
	public Vector2f addLocal(Vector2f vec) {
		x += vec.x;
		y += vec.y;
		return this;
	}

	@Override
	public Vector2f subtract(Float v) {
		return new Vector2f(this).subtractLocal(v);
	}

	/**
	 * Subtracts the given values from this vector and writes them to a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @return New vector.
	 */
	public Vector2f subtract(Float x, Float y) {
		return new Vector2f(this).subtractLocal(x, y);
	}

	@Override
	public Vector2f subtract(Vector2f vec) {
		return new Vector2f(this).subtractLocal(vec);
	}

	@Override
	public Vector2f subtractLocal(Float v) {
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
	public Vector2f subtractLocal(Float x, Float y) {
		this.x -= x;
		this.y -= y;
		return this;
	}

	@Override
	public Vector2f subtractLocal(Vector2f vec) {
		x -= vec.x;
		y -= vec.y;
		return this;
	}

	@Override
	public Vector2f multiplicate(Float v) {
		return new Vector2f(this).multiplicateLocal(v);
	}

	/**
	 * Multiplicates this vector with the given values and writes the to a new
	 * one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @return New vector.
	 */
	public Vector2f multiplicate(Float x, Float y) {
		return new Vector2f(this).multiplicateLocal(x, y);
	}

	@Override
	public Vector2f multiplicate(Vector2f vec) {
		return new Vector2f(this).multiplicateLocal(vec);
	}

	@Override
	public Vector2f multiplicateLocal(Float v) {
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
	public Vector2f multiplicateLocal(Float x, Float y) {
		this.x *= x;
		this.y *= y;
		return this;
	}

	@Override
	public Vector2f multiplicateLocal(Vector2f vec) {
		x *= vec.x;
		y *= vec.y;
		return this;
	}

	@Override
	public Vector2f divide(Float v) {
		return new Vector2f(this).divideLocal(v);
	}

	/**
	 * Divides this vector by the given values and writes them to a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @return New vector.
	 */
	public Vector2f divide(Float x, Float y) {
		return new Vector2f(this).divideLocal(x, y);
	}

	@Override
	public Vector2f divide(Vector2f vec) {
		return new Vector2f(this).divideLocal(vec);
	}

	@Override
	public Vector2f divideLocal(Float v) {
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
	public Vector2f divideLocal(Float x, Float y) {
		this.x /= x;
		this.y /= y;
		return this;
	}

	@Override
	public Vector2f divideLocal(Vector2f vec) {
		x /= vec.x;
		y /= vec.y;
		return this;
	}

	@Override
	public double dot(Vector2f vec) {
		return x * vec.x + y * vec.y;
	}

	@Override
	public Vector2f cross(Vector2f vec) {
		float det = (float) determinant(vec);
		return new Vector2f(det, det);
	}

	@Override
	public double determinant(Vector2f vec) {
		return (x * vec.x) - (y * vec.y);
	}

	@Override
	public Vector2f abs() {
		x = FastMath.abs(x);
		y = FastMath.abs(y);
		return this;
	}

	@Override
	public Vector2f clampMin(Float min) {
		x = FastMath.max(x, min);
		y = FastMath.max(y, min);
		return this;
	}

	@Override
	public Vector2f clampMax(Float max) {
		x = FastMath.min(x, max);
		y = FastMath.min(y, max);
		return this;
	}

	@Override
	public Float length() {
		return FastMath.sqrt(lengthSquared());
	}

	@Override
	public Float lengthSquared() {
		return x * x + y * y;
	}

	@Override
	public Float distance(Vector2f vec) {
		return FastMath.sqrt(distanceSquared(vec));
	}

	@Override
	public Float distanceSquared(Vector2f vec) {
		float dx = x - vec.x;
		float dy = y - vec.y;
		return dx * dx + dy * dy;
	}

	@Override
	public Vector2f negate() {
		return new Vector2f(this).negateLocal();
	}

	@Override
	public Vector2f negateLocal() {
		x = -x;
		y = -y;
		return this;
	}

	@Override
	public Vector2f normalize() {
		return new Vector2f(this).normalizeLocal();
	}

	@Override
	public Vector2f normalizeLocal() {
		float length = lengthSquared();
		if (length != 1.0f && length != 0.0f) {
			length = 1.0f / FastMath.sqrt(length);
			multiplicateLocal(length);
		}
		return this;
	}

	@Override
	public Vector2f zero() {
		return fill(0.0f);
	}

	@Override
	public Vector2f one() {
		return fill(1.0f);
	}

	@Override
	public Vector2f fill(Float v) {
		x = y = v;
		return this;
	}

	@Override
	public Vector2f max(Vector2f vec) {
		return new Vector2f(this).maxLocal(vec);
	}

	@Override
	public Vector2f maxLocal(Vector2f vec) {
		x = FastMath.max(x, vec.x);
		y = FastMath.max(y, vec.y);
		return this;
	}

	@Override
	public Vector2f min(Vector2f vec) {
		return new Vector2f(this).minLocal(vec);
	}

	@Override
	public Vector2f minLocal(Vector2f vec) {
		x = FastMath.min(x, vec.x);
		y = FastMath.min(y, vec.y);
		return this;
	}

	@Override
	public Vector2f clamp(Vector2f vec1, Vector2f vec2) {
		return new Vector2f(this).clampLocal(vec1, vec2);
	}

	@Override
	public Vector2f clampLocal(Vector2f vec1, Vector2f vec2) {
		x = FastMath.clamp(x, vec1.x, vec2.x);
		y = FastMath.clamp(y, vec1.y, vec2.y);
		return this;
	}

	@Override
	public Vector2f put(int i, Float v) {
		if (i == 0) {
			x = v;
		}
		if (i == 1) {
			y = v;
		}

		throw new IllegalArgumentException("Index not in range!");
	}

	@Override
	public Float get(int i) {
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
		return isUnified(1.0f);
	}

	@Override
	public boolean isZero() {
		return isUnified(0.0f);
	}

	@Override
	public boolean isUnified(Float v) {
		return x == v && y == v;
	}

	@Override
	public boolean isNaNVector() {
		return Float.isNaN(x) || Float.isNaN(y);
	}

	@Override
	public boolean isInfiniteVector() {
		return Float.isInfinite(x) || Float.isInfinite(y);
	}

	@Override
	public boolean isUnitVector() {
		float length = length();
		return 0.9999f < length && length < 1.0001f;
	}

	@Override
	public void fromArray(Float... array) {
		x = array[0];
		y = array[1];
	}

	@Override
	public Float[] toArray() {
		return new Float[]{x, y};
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 89 * hash + Float.floatToIntBits(this.x);
		hash = 89 * hash + Float.floatToIntBits(this.y);
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
		final Vector2f other = (Vector2f) obj;
		if (Float.floatToIntBits(this.x) != Float.floatToIntBits(other.x)) {
			return false;
		}
		return Float.floatToIntBits(this.y) == Float.floatToIntBits(other.y);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Vector2f{");
		result.append(x).append(", ");
		result.append(y);
		result.append("}");
		return result.toString();
	}

	@Override
	public Vector2f clone() throws CloneNotSupportedException {
		return (Vector2f) super.clone();
	}
}
