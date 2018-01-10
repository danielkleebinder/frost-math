package org.frost.math.vector;

import org.frost.math.FastMath;

/**
 * A vector holding 4 float values.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Vector4f implements Vector<Vector4f, Float> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 987512534815234576L;

	/**
	 * A zero vector, Vector4f(0, 0, 0, 0).
	 */
	public static final Vector4f ZERO = new ReadOnlyVector4f(0, 0, 0, 0);
	/**
	 * A unit x vector, Vector4f(1, 0, 0, 0).
	 */
	public static final Vector4f UNIT_X = new ReadOnlyVector4f(1, 0, 0, 0);
	/**
	 * A unit y vector, Vector4f(0, 1, 0, 0).
	 */
	public static final Vector4f UNIT_Y = new ReadOnlyVector4f(0, 1, 0, 0);
	/**
	 * A unit z vector, Vector4f(0, 0, 1, 0).
	 */
	public static final Vector4f UNIT_Z = new ReadOnlyVector4f(0, 0, 1, 0);
	/**
	 * A unit w vector, Vector4f(0, 0, 0, 1).
	 */
	public static final Vector4f UNIT_W = new ReadOnlyVector4f(0, 0, 0, 1);
	/**
	 * A unit x, y, z and w vector, Vector4f(1, 1, 1, 1).
	 */
	public static final Vector4f UNIT_XYZW = new ReadOnlyVector4f(1, 1, 1, 1);
	/**
	 * A unit x vector, Vector4f(-1, 0, 0, 0).
	 */
	public static final Vector4f UNIT_NEGATIVE_X = new ReadOnlyVector4f(-1, 0, 0, 0);
	/**
	 * A unit y vector, Vector4f(0, -1, 0, 0).
	 */
	public static final Vector4f UNIT_NEGATIVE_Y = new ReadOnlyVector4f(0, -1, 0, 0);
	/**
	 * A unit z vector, Vector4f(0, 0, -1, 0).
	 */
	public static final Vector4f UNIT_NEGATIVE_Z = new ReadOnlyVector4f(0, 0, -1, 0);
	/**
	 * A unit w vector, Vector4f(0, 0, 0, -1).
	 */
	public static final Vector4f UNIT_NEGATIVE_W = new ReadOnlyVector4f(0, 0, 0, -1);
	/**
	 * A unit x, y, z and w vector, Vector4f(-1, -1, -1, -1).
	 */
	public static final Vector4f UNIT_NEGATIVE_XYZW = new ReadOnlyVector4f(-1, -1, -1, -1);

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
	 * The w value of the vector.
	 */
	public float w;

	/**
	 * Creates a new <code>Vector4f</code> instance with the default x, y, z and
	 * w values. Vector4f(0.0f, 0.0f, 0.0f, 0.0f).
	 */
	public Vector4f() {
		this(0, 0, 0, 0);
	}

	/**
	 * Creates a new <code>Vector4f</code> instance with the given x, y, z and w
	 * values.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 * @param z The z value.
	 * @param w The w value.
	 */
	public Vector4f(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	/**
	 * Creates a new <code>Vector4f</code> instance with the given values.
	 *
	 * @param v Values.
	 */
	public Vector4f(float... v) {
		switch (v.length) {
			case 4:
				w = v[3];
			case 3:
				z = v[2];
			case 2:
				y = v[1];
			case 1:
				x = v[0];
		}
	}

	/**
	 * Creates a new <code>Vector4f</code> instance from the given
	 * <code>Vector4f</code>.
	 *
	 * @param copy Vector from where the values are copied.
	 */
	public Vector4f(Vector4f copy) {
		x = copy.x;
		y = copy.y;
		z = copy.z;
		w = copy.w;
	}

	/**
	 * Sets the vectors x, y, z and w values to the given ones.
	 *
	 * @param x The new x value.
	 * @param y The new y value.
	 * @param z The new z value.
	 * @param w The new w value.
	 * @return This vector.
	 */
	public Vector4f set(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		return this;
	}

	@Override
	public Vector4f set(Vector4f vec) {
		x = vec.x;
		y = vec.y;
		z = vec.z;
		w = vec.w;
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

	/**
	 * Sets the w value in this vector.
	 *
	 * @param w W value.
	 */
	public void setW(Float w) {
		this.w = w;
	}

	/**
	 * Returns the w value.
	 *
	 * @return W value.
	 */
	public Float getW() {
		return w;
	}

	@Override
	public Vector4f add(Float v) {
		return new Vector4f(this).addLocal(v);
	}

	/**
	 * Adds the given values to this vector and returns a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @param w W value.
	 * @return New vector.
	 */
	public Vector4f add(Float x, Float y, Float z, Float w) {
		return new Vector4f(this).addLocal(x, y, z, w);
	}

	@Override
	public Vector4f add(Vector4f vec) {
		return new Vector4f(this).addLocal(vec);
	}

	@Override
	public Vector4f addLocal(Float v) {
		x += v;
		y += v;
		z += v;
		w += v;
		return this;
	}

	/**
	 * Adds the given values to this vector.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @param w W value.
	 * @return This vector.
	 */
	public Vector4f addLocal(Float x, Float y, Float z, Float w) {
		this.x += x;
		this.y += y;
		this.z += z;
		this.w += w;
		return this;
	}

	@Override
	public Vector4f addLocal(Vector4f vec) {
		x += vec.x;
		y += vec.y;
		z += vec.z;
		w += vec.w;
		return this;
	}

	@Override
	public Vector4f subtract(Float v) {
		return new Vector4f(this).subtractLocal(v);
	}

	/**
	 * Subtracts the given values from this vector and writes them to a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @param w W value.
	 * @return New vector.
	 */
	public Vector4f subtract(Float x, Float y, Float z, Float w) {
		return new Vector4f(this).subtractLocal(x, y, z, w);
	}

	@Override
	public Vector4f subtract(Vector4f vec) {
		return new Vector4f(this).subtractLocal(vec);
	}

	@Override
	public Vector4f subtractLocal(Float v) {
		x -= v;
		y -= v;
		z -= v;
		w -= v;
		return this;
	}

	/**
	 * Subtracts the given values from this vector.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @param w W value.
	 * @return This vector.
	 */
	public Vector4f subtractLocal(Float x, Float y, Float z, Float w) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
		this.w -= w;
		return this;
	}

	@Override
	public Vector4f subtractLocal(Vector4f vec) {
		x -= vec.x;
		y -= vec.y;
		z -= vec.z;
		w -= vec.w;
		return this;
	}

	@Override
	public Vector4f multiplicate(Float v) {
		return new Vector4f(this).multiplicateLocal(v);
	}

	/**
	 * Multiplicates this vector with the given values and writes the to a new
	 * one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @param w W value.
	 * @return New vector.
	 */
	public Vector4f multiplicate(Float x, Float y, Float z, Float w) {
		return new Vector4f(this).multiplicateLocal(x, y, z, w);
	}

	@Override
	public Vector4f multiplicate(Vector4f vec) {
		return new Vector4f(this).multiplicateLocal(vec);
	}

	@Override
	public Vector4f multiplicateLocal(Float v) {
		x *= v;
		y *= v;
		z *= v;
		w *= v;
		return this;
	}

	/**
	 * Multiplicates this vector with the given values.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @param w W value.
	 * @return This vector.
	 */
	public Vector4f multiplicateLocal(Float x, Float y, Float z, Float w) {
		this.x *= x;
		this.y *= y;
		this.z *= z;
		this.w *= w;
		return this;
	}

	@Override
	public Vector4f multiplicateLocal(Vector4f vec) {
		x *= vec.x;
		y *= vec.y;
		z *= vec.z;
		w *= vec.w;
		return this;
	}

	@Override
	public Vector4f divide(Float v) {
		return new Vector4f(this).divideLocal(v);
	}

	/**
	 * Divides this vector by the given values and writes them to a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @param w W value.
	 * @return New vector.
	 */
	public Vector4f divide(Float x, Float y, Float z, Float w) {
		return new Vector4f(this).divideLocal(x, y, z, w);
	}

	@Override
	public Vector4f divide(Vector4f vec) {
		return new Vector4f(this).divideLocal(vec);
	}

	@Override
	public Vector4f divideLocal(Float v) {
		x /= v;
		y /= v;
		z /= v;
		w /= v;
		return this;
	}

	/**
	 * Divides this vector by the given values.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @param w W value.
	 * @return This vector.
	 */
	public Vector4f divideLocal(Float x, Float y, Float z, Float w) {
		this.x /= x;
		this.y /= y;
		this.z /= z;
		this.w /= w;
		return this;
	}

	@Override
	public Vector4f divideLocal(Vector4f vec) {
		x /= vec.x;
		y /= vec.y;
		z /= vec.z;
		w /= vec.w;
		return this;
	}

	@Override
	public double dot(Vector4f vec) {
		return x * vec.x + y * vec.y + z * vec.z + w * vec.w;
	}

	@Override
	public Vector4f cross(Vector4f vec) {
		float tempx = ((y * vec.z) - (z * vec.y));
		float tempy = ((z * vec.x) - (x * vec.z));
		float tempz = ((x * vec.y) - (y * vec.x));
		return new Vector4f(tempx, tempy, tempz, 1.0f);
	}

	@Override
	public double determinant(Vector4f vec) {
		return (x * vec.x) - (y * vec.y) - (z * vec.z) - (w * vec.w);
	}

	@Override
	public Vector4f abs() {
		x = FastMath.abs(x);
		y = FastMath.abs(y);
		z = FastMath.abs(z);
		w = FastMath.abs(w);
		return this;
	}

	@Override
	public Vector4f clampMin(Float min) {
		x = FastMath.max(x, min);
		y = FastMath.max(y, min);
		z = FastMath.max(z, min);
		w = FastMath.max(w, min);
		return this;
	}

	@Override
	public Vector4f clampMax(Float max) {
		x = FastMath.min(x, max);
		y = FastMath.min(y, max);
		z = FastMath.min(z, max);
		w = FastMath.min(w, max);
		return this;
	}

	@Override
	public Float length() {
		return FastMath.sqrt(lengthSquared());
	}

	@Override
	public Float lengthSquared() {
		return x * x + y * y + z * z + w * w;
	}

	@Override
	public Float distance(Vector4f vec) {
		return FastMath.sqrt(distanceSquared(vec));
	}

	@Override
	public Float distanceSquared(Vector4f vec) {
		float dx = x - vec.x;
		float dy = y - vec.y;
		float dz = z - vec.z;
		float dw = w - vec.w;
		return dx * dx + dy * dy + dz * dz + dw * dw;
	}

	@Override
	public Vector4f negate() {
		return new Vector4f(this).negateLocal();
	}

	@Override
	public Vector4f negateLocal() {
		x = -x;
		y = -y;
		z = -z;
		w = -w;
		return this;
	}

	@Override
	public Vector4f normalize() {
		return new Vector4f(this).normalizeLocal();
	}

	@Override
	public Vector4f normalizeLocal() {
		float length = lengthSquared();
		if (length != 1.0f && length != 0.0f) {
			length = 1.0f / FastMath.sqrt(length);
			multiplicateLocal(length);
		}
		return this;
	}

	@Override
	public Vector4f zero() {
		return fill(0.0f);
	}

	@Override
	public Vector4f one() {
		return fill(1.0f);
	}

	@Override
	public Vector4f fill(Float v) {
		x = y = z = w = v;
		return this;
	}

	@Override
	public Vector4f max(Vector4f vec) {
		return new Vector4f(this).maxLocal(vec);
	}

	@Override
	public Vector4f maxLocal(Vector4f vec) {
		x = FastMath.max(x, vec.x);
		y = FastMath.max(y, vec.y);
		z = FastMath.max(z, vec.z);
		w = FastMath.max(w, vec.w);
		return this;
	}

	@Override
	public Vector4f min(Vector4f vec) {
		return new Vector4f(this).minLocal(vec);
	}

	@Override
	public Vector4f minLocal(Vector4f vec) {
		x = FastMath.min(x, vec.x);
		y = FastMath.min(y, vec.y);
		z = FastMath.min(z, vec.z);
		w = FastMath.min(w, vec.w);
		return this;
	}

	@Override
	public Vector4f clamp(Vector4f vec1, Vector4f vec2) {
		return new Vector4f(this).clampLocal(vec1, vec2);
	}

	@Override
	public Vector4f clampLocal(Vector4f vec1, Vector4f vec2) {
		x = FastMath.clamp(x, vec1.x, vec2.x);
		y = FastMath.clamp(y, vec1.y, vec2.y);
		z = FastMath.clamp(z, vec1.z, vec2.z);
		w = FastMath.clamp(w, vec1.w, vec2.w);
		return this;
	}

	@Override
	public Vector4f put(int i, Float v) {
		if (i == 0) {
			x = v;
		}
		if (i == 1) {
			y = v;
		}
		if (i == 2) {
			z = v;
		}
		if (i == 3) {
			w = v;
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
		if (i == 3) {
			return w;
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
		return x == v && y == v && z == v && w == v;
	}

	@Override
	public boolean isNaNVector() {
		return Float.isNaN(x) || Float.isNaN(y) || Float.isNaN(z) || Float.isNaN(w);
	}

	@Override
	public boolean isInfiniteVector() {
		return Float.isInfinite(x) || Float.isInfinite(y) || Float.isInfinite(z) || Float.isInfinite(w);
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
		w = array[3];
	}

	@Override
	public Float[] toArray() {
		return new Float[]{x, y, z, w};
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 41 * hash + Float.floatToIntBits(this.x);
		hash = 41 * hash + Float.floatToIntBits(this.y);
		hash = 41 * hash + Float.floatToIntBits(this.z);
		hash = 41 * hash + Float.floatToIntBits(this.w);
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
		final Vector4f other = (Vector4f) obj;
		if (Float.floatToIntBits(this.x) != Float.floatToIntBits(other.x)) {
			return false;
		}
		if (Float.floatToIntBits(this.y) != Float.floatToIntBits(other.y)) {
			return false;
		}
		if (Float.floatToIntBits(this.z) != Float.floatToIntBits(other.z)) {
			return false;
		}
		return Float.floatToIntBits(this.w) == Float.floatToIntBits(other.w);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Vector4f{");
		result.append(x).append(", ");
		result.append(y).append(", ");
		result.append(z).append(", ");
		result.append(w);
		result.append("}");
		return result.toString();
	}

	@Override
	public Vector4f clone() throws CloneNotSupportedException {
		return (Vector4f) super.clone();
	}
}
