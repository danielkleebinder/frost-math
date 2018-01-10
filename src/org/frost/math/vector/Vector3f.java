package org.frost.math.vector;

import org.frost.math.FastMath;

/**
 * A vector holding 3 float values.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Vector3f implements Vector<Vector3f, Float> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 98761256384134L;

	/**
	 * A zero vector, Vector3f(0, 0, 0).
	 */
	public static final Vector3f ZERO = new ReadOnlyVector3f(0, 0, 0);
	/**
	 * A unit x vector, Vector3f(1, 0, 0).
	 */
	public static final Vector3f UNIT_X = new ReadOnlyVector3f(1, 0, 0);
	/**
	 * A unit y vector, Vector3f(0, 1, 0).
	 */
	public static final Vector3f UNIT_Y = new ReadOnlyVector3f(0, 1, 0);
	/**
	 * A unit z vector, Vector3f(0, 0, 1).
	 */
	public static final Vector3f UNIT_Z = new ReadOnlyVector3f(0, 0, 1);
	/**
	 * A unit x, y and z vector, Vector3f(1, 1, 1).
	 */
	public static final Vector3f UNIT_XYZ = new ReadOnlyVector3f(1, 1, 1);
	/**
	 * A unit x vector, Vector3f(-1, 0, 0).
	 */
	public static final Vector3f UNIT_NEGATIVE_X = new ReadOnlyVector3f(-1, 0, 0);
	/**
	 * A unit y vector, Vector3f(0, -1, 0).
	 */
	public static final Vector3f UNIT_NEGATIVE_Y = new ReadOnlyVector3f(0, -1, 0);
	/**
	 * A unit z vector, Vector3f(0, 0, -1).
	 */
	public static final Vector3f UNIT_NEGATIVE_Z = new ReadOnlyVector3f(0, 0, -1);
	/**
	 * A unit x, y and z vector, Vector3f(-1, -1, -1).
	 */
	public static final Vector3f UNIT_NEGATIVE_XYZ = new ReadOnlyVector3f(-1, -1, -1);

	/**
	 * The x value of the vector.
	 */
	public float x;
	/**
	 * The y value of the vector.
	 */
	public float y;
	/**
	 * The z value of the vector.
	 */
	public float z;

	/**
	 * Creates a new <code>Vector3f</code> instance with the default x, y and z
	 * values. Vector3f(0.0f, 0.0f, 0.0f).
	 */
	public Vector3f() {
		this(0, 0, 0);
	}

	/**
	 * Creates a new <code>Vector3f</code> instance with the given x, y and z
	 * values.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 * @param z The z value.
	 */
	public Vector3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Creates a new <code>Vector3f</code> instance with the given values.
	 *
	 * @param v Values.
	 */
	public Vector3f(float... v) {
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
	 * Creates a new <code>Vector3f</code> instance from the given
	 * <code>Vector3f</code>.
	 *
	 * @param copy Vector from where the values are copied.
	 */
	public Vector3f(Vector3f copy) {
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
	public Vector3f set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}

	@Override
	public Vector3f set(Vector3f vec) {
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

	/**
	 * Sets the z value in this vector.
	 *
	 * @param z Z value.
	 */
	public void setZ(Float z) {
		this.z = z;
	}

	/**
	 * Returns the z value.
	 *
	 * @return Z value.
	 */
	public Float getZ() {
		return z;
	}

	@Override
	public Vector3f add(Float v) {
		return new Vector3f(this).addLocal(v);
	}

	/**
	 * Adds the given values to this vector and returns a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @return New vector.
	 */
	public Vector3f add(Float x, Float y, Float z) {
		return new Vector3f(this).addLocal(x, y, z);
	}

	@Override
	public Vector3f add(Vector3f vec) {
		return new Vector3f(this).addLocal(vec);
	}

	@Override
	public Vector3f addLocal(Float v) {
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
	public Vector3f addLocal(Float x, Float y, Float z) {
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	@Override
	public Vector3f addLocal(Vector3f vec) {
		x += vec.x;
		y += vec.y;
		z += vec.z;
		return this;
	}

	@Override
	public Vector3f subtract(Float v) {
		return new Vector3f(this).subtractLocal(v);
	}

	/**
	 * Subtracts the given values from this vector and writes them to a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @return New vector.
	 */
	public Vector3f subtract(Float x, Float y, Float z) {
		return new Vector3f(this).subtractLocal(x, y, z);
	}

	@Override
	public Vector3f subtract(Vector3f vec) {
		return new Vector3f(this).subtractLocal(vec);
	}

	@Override
	public Vector3f subtractLocal(Float v) {
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
	public Vector3f subtractLocal(Float x, Float y, Float z) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}

	@Override
	public Vector3f subtractLocal(Vector3f vec) {
		x -= vec.x;
		y -= vec.y;
		z -= vec.z;
		return this;
	}

	@Override
	public Vector3f multiplicate(Float v) {
		return new Vector3f(this).multiplicateLocal(v);
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
	public Vector3f multiplicate(Float x, Float y, Float z) {
		return new Vector3f(this).multiplicateLocal(x, y, z);
	}

	@Override
	public Vector3f multiplicate(Vector3f vec) {
		return new Vector3f(this).multiplicateLocal(vec);
	}

	@Override
	public Vector3f multiplicateLocal(Float v) {
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
	public Vector3f multiplicateLocal(Float x, Float y, Float z) {
		this.x *= x;
		this.y *= y;
		this.z *= z;
		return this;
	}

	@Override
	public Vector3f multiplicateLocal(Vector3f vec) {
		x *= vec.x;
		y *= vec.y;
		z *= vec.z;
		return this;
	}

	@Override
	public Vector3f divide(Float v) {
		return new Vector3f(this).divideLocal(v);
	}

	/**
	 * Divides this vector by the given values and writes them to a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @return New vector.
	 */
	public Vector3f divide(Float x, Float y, Float z) {
		return new Vector3f(this).divideLocal(x, y, z);
	}

	@Override
	public Vector3f divide(Vector3f vec) {
		return new Vector3f(this).divideLocal(vec);
	}

	@Override
	public Vector3f divideLocal(Float v) {
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
	public Vector3f divideLocal(Float x, Float y, Float z) {
		this.x /= x;
		this.y /= y;
		this.z /= z;
		return this;
	}

	@Override
	public Vector3f divideLocal(Vector3f vec) {
		x /= vec.x;
		y /= vec.y;
		z /= vec.z;
		return this;
	}

	@Override
	public double dot(Vector3f vec) {
		return x * vec.x + y * vec.y + z * vec.z;
	}

	@Override
	public Vector3f cross(Vector3f vec) {
		float tempx = (y * vec.z) - (z * vec.y);
		float tempy = (z * vec.x) - (x * vec.z);
		float tempz = (x * vec.y) - (y * vec.x);
		return new Vector3f(tempx, tempy, tempz);
	}

	@Override
	public double determinant(Vector3f vec) {
		return (x * vec.x) - (y * vec.y) - (z * vec.z);
	}

	@Override
	public Vector3f abs() {
		x = FastMath.abs(x);
		y = FastMath.abs(y);
		z = FastMath.abs(z);
		return this;
	}

	@Override
	public Vector3f clampMin(Float min) {
		x = FastMath.max(x, min);
		y = FastMath.max(y, min);
		z = FastMath.max(z, min);
		return this;
	}

	@Override
	public Vector3f clampMax(Float max) {
		x = FastMath.min(x, max);
		y = FastMath.min(y, max);
		z = FastMath.min(z, max);
		return this;
	}

	@Override
	public Float length() {
		return FastMath.sqrt(lengthSquared());
	}

	@Override
	public Float lengthSquared() {
		return x * x + y * y + z * z;
	}

	@Override
	public Float distance(Vector3f vec) {
		return FastMath.sqrt(distanceSquared(vec));
	}

	@Override
	public Float distanceSquared(Vector3f vec) {
		float dx = x - vec.x;
		float dy = y - vec.y;
		float dz = z - vec.z;
		return dx * dx + dy * dy + dz * dz;
	}

	@Override
	public Vector3f negate() {
		return new Vector3f(this).negateLocal();
	}

	@Override
	public Vector3f negateLocal() {
		x = -x;
		y = -y;
		z = -z;
		return this;
	}

	@Override
	public Vector3f normalize() {
		return new Vector3f(this).normalizeLocal();
	}

	@Override
	public Vector3f normalizeLocal() {
		float length = lengthSquared();
		if (length != 1.0f && length != 0.0f) {
			length = 1.0f / FastMath.sqrt(length);
			multiplicateLocal(length);
		}
		return this;
	}

	@Override
	public Vector3f zero() {
		return fill(0.0f);
	}

	@Override
	public Vector3f one() {
		return fill(1.0f);
	}

	@Override
	public Vector3f fill(Float v) {
		x = y = z = v;
		return this;
	}

	@Override
	public Vector3f max(Vector3f vec) {
		return new Vector3f(this).maxLocal(vec);
	}

	@Override
	public Vector3f maxLocal(Vector3f vec) {
		x = FastMath.max(x, vec.x);
		y = FastMath.max(y, vec.y);
		z = FastMath.max(z, vec.z);
		return this;
	}

	@Override
	public Vector3f min(Vector3f vec) {
		return new Vector3f(this).minLocal(vec);
	}

	@Override
	public Vector3f minLocal(Vector3f vec) {
		x = FastMath.min(x, vec.x);
		y = FastMath.min(y, vec.y);
		z = FastMath.min(z, vec.z);
		return this;
	}

	@Override
	public Vector3f clamp(Vector3f vec1, Vector3f vec2) {
		return new Vector3f(this).clampLocal(vec1, vec2);
	}

	@Override
	public Vector3f clampLocal(Vector3f vec1, Vector3f vec2) {
		x = FastMath.clamp(x, vec1.x, vec2.x);
		y = FastMath.clamp(y, vec1.y, vec2.y);
		z = FastMath.clamp(z, vec1.z, vec2.z);
		return this;
	}

	@Override
	public Vector3f put(int i, Float v) {
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
	public Float get(int i) {
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
		return isUnified(1.0f);
	}

	@Override
	public boolean isZero() {
		return isUnified(0.0f);
	}

	@Override
	public boolean isUnified(Float v) {
		return x == v && y == v && z == v;
	}

	@Override
	public boolean isNaNVector() {
		return Float.isNaN(x) || Float.isNaN(y) || Float.isNaN(z);
	}

	@Override
	public boolean isInfiniteVector() {
		return Float.isInfinite(x) || Float.isInfinite(y) || Float.isInfinite(z);
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
		z = array[2];
	}

	@Override
	public Float[] toArray() {
		return new Float[]{x, y, z};
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 29 * hash + Float.floatToIntBits(this.x);
		hash = 29 * hash + Float.floatToIntBits(this.y);
		hash = 29 * hash + Float.floatToIntBits(this.z);
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
		final Vector3f other = (Vector3f) obj;
		if (Float.floatToIntBits(this.x) != Float.floatToIntBits(other.x)) {
			return false;
		}
		if (Float.floatToIntBits(this.y) != Float.floatToIntBits(other.y)) {
			return false;
		}
		return Float.floatToIntBits(this.z) == Float.floatToIntBits(other.z);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Vector3f{");
		result.append(x).append(", ");
		result.append(y).append(", ");
		result.append(z);
		result.append("}");
		return result.toString();
	}

	@Override
	public Vector3f clone() throws CloneNotSupportedException {
		return (Vector3f) super.clone();
	}
}
