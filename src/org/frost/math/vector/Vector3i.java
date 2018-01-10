package org.frost.math.vector;

import org.frost.math.FastMath;

/**
 * A vector holding 3 int values.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Vector3i implements Vector<Vector3i, Integer> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 143124786576L;

	/**
	 * A zero vector, Vector3i(0, 0, 0).
	 */
	public static final Vector3i ZERO = new ReadOnlyVector3i(0, 0, 0);
	/**
	 * A unit x vector, Vector3i(1, 0, 0).
	 */
	public static final Vector3i UNIT_X = new ReadOnlyVector3i(1, 0, 0);
	/**
	 * A unit y vector, Vector3i(0, 1, 0).
	 */
	public static final Vector3i UNIT_Y = new ReadOnlyVector3i(0, 1, 0);
	/**
	 * A unit z vector, Vector3i(0, 0, 1).
	 */
	public static final Vector3i UNIT_Z = new ReadOnlyVector3i(0, 0, 1);
	/**
	 * A unit x, y and z vector, Vector3i(1, 1, 1).
	 */
	public static final Vector3i UNIT_XYZ = new ReadOnlyVector3i(1, 1, 1);
	/**
	 * A unit x vector, Vector3i(-1, 0, 0).
	 */
	public static final Vector3i UNIT_NEGATIVE_X = new ReadOnlyVector3i(-1, 0, 0);
	/**
	 * A unit y vector, Vector3i(0, -1, 0).
	 */
	public static final Vector3i UNIT_NEGATIVE_Y = new ReadOnlyVector3i(0, -1, 0);
	/**
	 * A unit z vector, Vector3i(0, 0, -1).
	 */
	public static final Vector3i UNIT_NEGATIVE_Z = new ReadOnlyVector3i(0, 0, -1);
	/**
	 * A unit x, y and z vector, Vector3i(-1, -1, -1).
	 */
	public static final Vector3i UNIT_NEGATIVE_XYZ = new ReadOnlyVector3i(-1, -1, -1);

	/**
	 * The x value of the vector.
	 */
	public int x;
	/**
	 * The y value of the vector.
	 */
	public int y;
	/**
	 * The z value of the vector.
	 */
	public int z;

	/**
	 * Creates a new <code>Vector3i</code> instance with the default x, y and z
	 * values. Vector3i(0, 0, 0).
	 */
	public Vector3i() {
		this(0, 0, 0);
	}

	/**
	 * Creates a new <code>Vector3i</code> instance with the given x, y and z
	 * values.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 * @param z The z value.
	 */
	public Vector3i(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Creates a new <code>Vector3i</code> instance with the given values.
	 *
	 * @param v Values.
	 */
	public Vector3i(int... v) {
		switch (v.length) {
			case 3:
				z = v[2];
			case 2:
				y = v[1];
			case 1:
				x = v[0];
		}
	}

	/**
	 * Creates a new <code>Vector3i</code> instance from the given
	 * <code>Vector3i</code>.
	 *
	 * @param copy Vector from where the values are copied.
	 */
	public Vector3i(Vector3i copy) {
		x = copy.x;
		y = copy.y;
		z = copy.z;
	}

	/**
	 * Sets the vectors x, y and z values to the given ones.
	 *
	 * @param x The new x value.
	 * @param y The new y value.
	 * @param z The new z value.
	 * @return This vector.
	 */
	public Vector3i set(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}

	@Override
	public Vector3i set(Vector3i vec) {
		x = vec.x;
		y = vec.y;
		z = vec.z;
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

	/**
	 * Sets the z value in this vector.
	 *
	 * @param z Z value.
	 */
	public void setZ(Integer z) {
		this.z = z;
	}

	/**
	 * Returns the z value.
	 *
	 * @return Z value.
	 */
	public Integer getZ() {
		return z;
	}

	@Override
	public Vector3i add(Integer v) {
		return new Vector3i(this).addLocal(v);
	}

	/**
	 * Adds the given values to this vector and returns a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @return New vector.
	 */
	public Vector3i add(Integer x, Integer y, Integer z) {
		return new Vector3i(this).addLocal(x, y, z);
	}

	@Override
	public Vector3i add(Vector3i vec) {
		return new Vector3i(this).addLocal(vec);
	}

	@Override
	public Vector3i addLocal(Integer v) {
		x += v;
		y += v;
		z += v;
		return this;
	}

	/**
	 * Adds the given values to this vector.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @return This vector.
	 */
	public Vector3i addLocal(Integer x, Integer y, Integer z) {
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	@Override
	public Vector3i addLocal(Vector3i vec) {
		x += vec.x;
		y += vec.y;
		z += vec.z;
		return this;
	}

	@Override
	public Vector3i subtract(Integer v) {
		return new Vector3i(this).subtractLocal(v);
	}

	/**
	 * Subtracts the given values from this vector and writes them to a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @return New vector.
	 */
	public Vector3i subtract(Integer x, Integer y, Integer z) {
		return new Vector3i(this).subtractLocal(x, y, z);
	}

	@Override
	public Vector3i subtract(Vector3i vec) {
		return new Vector3i(this).subtractLocal(vec);
	}

	@Override
	public Vector3i subtractLocal(Integer v) {
		x -= v;
		y -= v;
		z -= v;
		return this;
	}

	/**
	 * Subtracts the given values from this vector.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @return This vector.
	 */
	public Vector3i subtractLocal(Integer x, Integer y, Integer z) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}

	@Override
	public Vector3i subtractLocal(Vector3i vec) {
		x -= vec.x;
		y -= vec.y;
		z -= vec.z;
		return this;
	}

	@Override
	public Vector3i multiplicate(Integer v) {
		return new Vector3i(this).multiplicateLocal(v);
	}

	/**
	 * Multiplicates this vector with the given values and writes the to a new
	 * one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @return New vector.
	 */
	public Vector3i multiplicate(Integer x, Integer y, Integer z) {
		return new Vector3i(this).multiplicateLocal(x, y, z);
	}

	@Override
	public Vector3i multiplicate(Vector3i vec) {
		return new Vector3i(this).multiplicateLocal(vec);
	}

	@Override
	public Vector3i multiplicateLocal(Integer v) {
		x *= v;
		y *= v;
		z *= v;
		return this;
	}

	/**
	 * Multiplicates this vector with the given values.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @return This vector.
	 */
	public Vector3i multiplicateLocal(Integer x, Integer y, Integer z) {
		this.x *= x;
		this.y *= y;
		this.z *= z;
		return this;
	}

	@Override
	public Vector3i multiplicateLocal(Vector3i vec) {
		x *= vec.x;
		y *= vec.y;
		z *= vec.z;
		return this;
	}

	@Override
	public Vector3i divide(Integer v) {
		return new Vector3i(this).divideLocal(v);
	}

	/**
	 * Divides this vector by the given values and writes them to a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @return New vector.
	 */
	public Vector3i divide(Integer x, Integer y, Integer z) {
		return new Vector3i(this).divideLocal(x, y, z);
	}

	@Override
	public Vector3i divide(Vector3i vec) {
		return new Vector3i(this).divideLocal(vec);
	}

	@Override
	public Vector3i divideLocal(Integer v) {
		x /= v;
		y /= v;
		z /= v;
		return this;
	}

	/**
	 * Divides this vector by the given values.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @return This vector.
	 */
	public Vector3i divideLocal(Integer x, Integer y, Integer z) {
		this.x /= x;
		this.y /= y;
		this.z /= z;
		return this;
	}

	@Override
	public Vector3i divideLocal(Vector3i vec) {
		x /= vec.x;
		y /= vec.y;
		z /= vec.z;
		return this;
	}

	@Override
	public double dot(Vector3i vec) {
		return x * vec.x + y * vec.y + z * vec.z;
	}

	@Override
	public Vector3i cross(Vector3i vec) {
		int tempx = (y * vec.z) - (z * vec.y);
		int tempy = (z * vec.x) - (x * vec.z);
		int tempz = (x * vec.y) - (y * vec.x);
		return new Vector3i(tempx, tempy, tempz);
	}

	@Override
	public double determinant(Vector3i vec) {
		return (x * vec.x) - (y * vec.y) - (z * vec.z);
	}

	@Override
	public Vector3i abs() {
		x = FastMath.abs(x);
		y = FastMath.abs(y);
		z = FastMath.abs(z);
		return this;
	}

	@Override
	public Vector3i clampMin(Integer min) {
		x = FastMath.max(x, min);
		y = FastMath.max(y, min);
		z = FastMath.max(z, min);
		return this;
	}

	@Override
	public Vector3i clampMax(Integer max) {
		x = FastMath.min(x, max);
		y = FastMath.min(y, max);
		z = FastMath.min(z, max);
		return this;
	}

	@Override
	public Integer length() {
		return FastMath.roundToInt(FastMath.sqrt(lengthSquared()));
	}

	@Override
	public Integer lengthSquared() {
		return x * x + y * y + z * z;
	}

	@Override
	public Integer distance(Vector3i vec) {
		return FastMath.roundToInt(FastMath.sqrt(distanceSquared(vec)));
	}

	@Override
	public Integer distanceSquared(Vector3i vec) {
		int dx = x - vec.x;
		int dy = y - vec.y;
		int dz = z - vec.z;
		return dx * dx + dy * dy + dz * dz;
	}

	@Override
	public Vector3i negate() {
		return new Vector3i(this).negateLocal();
	}

	@Override
	public Vector3i negateLocal() {
		x = -x;
		y = -y;
		z = -z;
		return this;
	}

	@Override
	public Vector3i normalize() {
		return new Vector3i(this).normalizeLocal();
	}

	@Override
	public Vector3i normalizeLocal() {
		double length = lengthSquared();
		if (length != 1.0f && length != 0f) {
			length = 1.0f / FastMath.sqrt(length);
			multiplicateLocal(FastMath.roundToInt(length));
		}
		return this;
	}

	@Override
	public Vector3i zero() {
		return fill(0);
	}

	@Override
	public Vector3i one() {
		return fill(1);
	}

	@Override
	public Vector3i fill(Integer v) {
		x = y = z = v;
		return this;
	}

	@Override
	public Vector3i max(Vector3i vec) {
		return new Vector3i(this).maxLocal(vec);
	}

	@Override
	public Vector3i maxLocal(Vector3i vec) {
		x = FastMath.max(x, vec.x);
		y = FastMath.max(y, vec.y);
		z = FastMath.max(z, vec.z);
		return this;
	}

	@Override
	public Vector3i min(Vector3i vec) {
		return new Vector3i(this).minLocal(vec);
	}

	@Override
	public Vector3i minLocal(Vector3i vec) {
		x = FastMath.min(x, vec.x);
		y = FastMath.min(y, vec.y);
		z = FastMath.min(z, vec.z);
		return this;
	}

	@Override
	public Vector3i clamp(Vector3i vec1, Vector3i vec2) {
		return new Vector3i(this).clampLocal(vec1, vec2);
	}

	@Override
	public Vector3i clampLocal(Vector3i vec1, Vector3i vec2) {
		x = FastMath.clamp(x, vec1.x, vec2.x);
		y = FastMath.clamp(y, vec1.y, vec2.y);
		z = FastMath.clamp(z, vec1.z, vec2.z);
		return this;
	}

	@Override
	public Vector3i put(int i, Integer v) {
		if (i == 0) {
			x = v;
		}
		if (i == 1) {
			y = v;
		}
		if (i == 2) {
			z = v;
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
		if (i == 2) {
			return z;
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
		return x == v && y == v && z == v;
	}

	@Override
	public boolean isNaNVector() {
		return Double.isNaN(x) || Double.isNaN(y) || Double.isNaN(z);
	}

	@Override
	public boolean isInfiniteVector() {
		return Double.isInfinite(x) || Double.isInfinite(y) || Double.isInfinite(z);
	}

	@Override
	public boolean isUnitVector() {
		int length = length();
		return 0.9999f < length && length < 1.0001f;
	}

	@Override
	public void fromArray(Integer... array) {
		x = array[0];
		y = array[1];
		z = array[2];
	}

	@Override
	public Integer[] toArray() {
		return new Integer[]{x, y, z};
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 79 * hash + this.x;
		hash = 79 * hash + this.y;
		hash = 79 * hash + this.z;
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
		final Vector3i other = (Vector3i) obj;
		if (this.x != other.x) {
			return false;
		}
		if (this.y != other.y) {
			return false;
		}
		return this.z == other.z;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Vector3i{");
		result.append(x).append(", ");
		result.append(y).append(", ");
		result.append(z);
		result.append("}");
		return result.toString();
	}

	@Override
	public Vector3i clone() throws CloneNotSupportedException {
		return (Vector3i) super.clone();
	}
}
