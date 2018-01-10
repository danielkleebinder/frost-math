package org.frost.math.vector;

import org.frost.math.FastMath;

/**
 * A vector holding 2 integer values.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Vector2i implements Vector<Vector2i, Integer> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 87658455L;

	/**
	 * A zero vector, Vector2i(0, 0).
	 */
	public static final Vector2i ZERO = new ReadOnlyVector2i(0, 0);
	/**
	 * A unit x vector, Vector2i(1, 0).
	 */
	public static final Vector2i UNIT_X = new ReadOnlyVector2i(1, 0);
	/**
	 * A unit y vector, Vector2i(0, 1).
	 */
	public static final Vector2i UNIT_Y = new ReadOnlyVector2i(0, 1);
	/**
	 * A zero vector, Vector2i(1, 1).
	 */
	public static final Vector2i UNIT_XY = new ReadOnlyVector2i(1, 1);
	/**
	 * A unit x vector, Vector2i(-1, 0).
	 */
	public static final Vector2i UNIT_NEGATIVE_X = new ReadOnlyVector2i(-1, 0);
	/**
	 * A unit y vector, Vector2i(0, -1).
	 */
	public static final Vector2i UNIT_NEGATIVE_Y = new ReadOnlyVector2i(0, -1);
	/**
	 * A zero vector, Vector2i(-1, -1).
	 */
	public static final Vector2i UNIT_NEGATIVE_XY = new ReadOnlyVector2i(-1, -1);

	/**
	 * The x value of the vector.
	 */
	public int x;
	/**
	 * The y value of the vector.
	 */
	public int y;

	/**
	 * Creates a new <code>Vector2i</code> instance with the default x and y
	 * values. Vector2i(0, 0).
	 */
	public Vector2i() {
		this(0, 0);
	}

	/**
	 * Creates a new <code>Vector2i</code> instance with the given x and y
	 * values.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 */
	public Vector2i(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Creates a new <code>Vector2i</code> instance with the given values.
	 *
	 * @param v Values.
	 */
	public Vector2i(int... v) {
		switch (v.length) {
			case 2:
				y = v[1];
			case 1:
				x = v[0];
		}
	}

	/**
	 * Creates a new <code>Vector2i</code> instance from the given
	 * <code>Vector2i</code>.
	 *
	 * @param copy Vector from where the values are copied.
	 */
	public Vector2i(Vector2i copy) {
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
	public Vector2i set(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}

	@Override
	public Vector2i set(Vector2i vec) {
		x = vec.x;
		y = vec.y;
		return this;
	}

	/**
	 * Sets the x value in this vector.
	 *
	 * @param x X value.
	 */
	public void setX(Integer x) {
		this.x = x;
	}

	/**
	 * Returns the x value.
	 *
	 * @return X value.
	 */
	public Integer getX() {
		return x;
	}

	/**
	 * Sets the y value in this vector.
	 *
	 * @param y Y value.
	 */
	public void setY(Integer y) {
		this.y = y;
	}

	/**
	 * Returns the y value.
	 *
	 * @return Y value.
	 */
	public Integer getY() {
		return y;
	}

	@Override
	public Vector2i add(Integer v) {
		return new Vector2i(this).addLocal(v);
	}

	/**
	 * Adds the given values to this vector and returns a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @return New vector.
	 */
	public Vector2i add(Integer x, Integer y) {
		return new Vector2i(this).addLocal(x, y);
	}

	@Override
	public Vector2i add(Vector2i vec) {
		return new Vector2i(this).addLocal(vec);
	}

	/**
	 * Adds the given values to this vector.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @return This vector.
	 */
	public Vector2i addLocal(Integer x, Integer y) {
		this.x += x;
		this.y += y;
		return this;
	}

	@Override
	public Vector2i addLocal(Integer v) {
		return addLocal(v, v);
	}

	@Override
	public Vector2i addLocal(Vector2i vec) {
		x += vec.x;
		y += vec.y;
		return this;
	}

	@Override
	public Vector2i subtract(Integer v) {
		return new Vector2i(this).subtractLocal(v);
	}

	/**
	 * Subtracts the given values from this vector and writes them to a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @return New vector.
	 */
	public Vector2i subtract(Integer x, Integer y) {
		return new Vector2i(this).subtractLocal(x, y);
	}

	@Override
	public Vector2i subtract(Vector2i vec) {
		return new Vector2i(this).subtractLocal(vec);
	}

	@Override
	public Vector2i subtractLocal(Integer v) {
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
	public Vector2i subtractLocal(Integer x, Integer y) {
		this.x -= x;
		this.y -= y;
		return this;
	}

	@Override
	public Vector2i subtractLocal(Vector2i vec) {
		x -= vec.x;
		y -= vec.y;
		return this;
	}

	@Override
	public Vector2i multiplicate(Integer v) {
		return new Vector2i(this).multiplicateLocal(v);
	}

	/**
	 * Multiplicates this vector with the given values and writes the to a new
	 * one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @return New vector.
	 */
	public Vector2i multiplicate(Integer x, Integer y) {
		return new Vector2i(this).multiplicateLocal(x, y);
	}

	@Override
	public Vector2i multiplicate(Vector2i vec) {
		return new Vector2i(this).multiplicateLocal(vec);
	}

	@Override
	public Vector2i multiplicateLocal(Integer v) {
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
	public Vector2i multiplicateLocal(Integer x, Integer y) {
		this.x *= x;
		this.y *= y;
		return this;
	}

	@Override
	public Vector2i multiplicateLocal(Vector2i vec) {
		x *= vec.x;
		y *= vec.y;
		return this;
	}

	@Override
	public Vector2i divide(Integer v) {
		return new Vector2i(this).divideLocal(v);
	}

	/**
	 * Divides this vector by the given values and writes them to a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @return New vector.
	 */
	public Vector2i divide(Integer x, Integer y) {
		return new Vector2i(this).divideLocal(x, y);
	}

	@Override
	public Vector2i divide(Vector2i vec) {
		return new Vector2i(this).divideLocal(vec);
	}

	@Override
	public Vector2i divideLocal(Integer v) {
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
	public Vector2i divideLocal(Integer x, Integer y) {
		this.x /= x;
		this.y /= y;
		return this;
	}

	@Override
	public Vector2i divideLocal(Vector2i vec) {
		x /= vec.x;
		y /= vec.y;
		return this;
	}

	@Override
	public double dot(Vector2i vec) {
		return x * vec.x + y * vec.y;
	}

	@Override
	public Vector2i cross(Vector2i vec) {
		int det = FastMath.roundToInt(determinant(vec));
		return new Vector2i(det, det);
	}

	@Override
	public double determinant(Vector2i vec) {
		return (x * vec.x) - (y * vec.y);
	}

	@Override
	public Vector2i abs() {
		x = FastMath.abs(x);
		y = FastMath.abs(y);
		return this;
	}

	@Override
	public Vector2i clampMin(Integer min) {
		x = FastMath.max(x, min);
		y = FastMath.max(y, min);
		return this;
	}

	@Override
	public Vector2i clampMax(Integer max) {
		x = FastMath.min(x, max);
		y = FastMath.min(y, max);
		return this;
	}

	@Override
	public Integer length() {
		return (int) FastMath.sqrt(lengthSquared());
	}

	@Override
	public Integer lengthSquared() {
		return x * x + y * y;
	}

	@Override
	public Integer distance(Vector2i vec) {
		return FastMath.roundToInt(FastMath.sqrt(distanceSquared(vec)));
	}

	@Override
	public Integer distanceSquared(Vector2i vec) {
		int dx = x - vec.x;
		int dy = y - vec.y;
		return dx * dx + dy * dy;
	}

	@Override
	public Vector2i negate() {
		return new Vector2i(this).negateLocal();
	}

	@Override
	public Vector2i negateLocal() {
		x = -x;
		y = -y;
		return this;
	}

	@Override
	public Vector2i normalize() {
		return new Vector2i(this).normalizeLocal();
	}

	@Override
	public Vector2i normalizeLocal() {
		double length = lengthSquared();
		if (length != 1.0f && length != 0f) {
			length = 1.0f / FastMath.sqrt(length);
			multiplicateLocal(FastMath.roundToInt(length));
		}
		return this;
	}

	@Override
	public Vector2i zero() {
		return fill(0);
	}

	@Override
	public Vector2i one() {
		return fill(1);
	}

	@Override
	public Vector2i fill(Integer v) {
		x = y = v;
		return this;
	}

	@Override
	public Vector2i max(Vector2i vec) {
		return new Vector2i(this).maxLocal(vec);
	}

	@Override
	public Vector2i maxLocal(Vector2i vec) {
		x = FastMath.max(x, vec.x);
		y = FastMath.max(y, vec.y);
		return this;
	}

	@Override
	public Vector2i min(Vector2i vec) {
		return new Vector2i(this).minLocal(vec);
	}

	@Override
	public Vector2i minLocal(Vector2i vec) {
		x = FastMath.min(x, vec.x);
		y = FastMath.min(y, vec.y);
		return this;
	}

	@Override
	public Vector2i clamp(Vector2i vec1, Vector2i vec2) {
		return new Vector2i(this).clampLocal(vec1, vec2);
	}

	@Override
	public Vector2i clampLocal(Vector2i vec1, Vector2i vec2) {
		x = FastMath.clamp(x, vec1.x, vec2.x);
		y = FastMath.clamp(y, vec1.y, vec2.y);
		return this;
	}

	@Override
	public Vector2i put(int i, Integer v) {
		if (i == 0) {
			x = v;
		}
		if (i == 1) {
			y = v;
		}

		throw new IllegalArgumentException("Index not in range!");
	}

	@Override
	public Integer get(int i) {
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
		return isUnified(1);
	}

	@Override
	public boolean isZero() {
		return isUnified(0);
	}

	@Override
	public boolean isUnified(Integer v) {
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
	public void fromArray(Integer... array) {
		x = array[0];
		y = array[1];
	}

	@Override
	public Integer[] toArray() {
		return new Integer[]{x, y};
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 59 * hash + this.x;
		hash = 59 * hash + this.y;
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
		final Vector2i other = (Vector2i) obj;
		if (this.x != other.x) {
			return false;
		}
		return this.y == other.y;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Vector2i{");
		result.append(x).append(", ");
		result.append(y);
		result.append("}");
		return result.toString();
	}

	@Override
	public Vector2i clone() throws CloneNotSupportedException {
		return (Vector2i) super.clone();
	}
}
