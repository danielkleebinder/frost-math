package org.frost.math.vector;

import org.frost.math.FastMath;

/**
 * A vector holding 4 int values.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Vector4i implements Vector<Vector4i, Integer> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 78665757234L;

	/**
	 * A zero vector, Vector4i(0, 0, 0, 0).
	 */
	public static final Vector4i ZERO = new ReadOnlyVector4i(0, 0, 0, 0);
	/**
	 * A unit x vector, Vector4i(1, 0, 0, 0).
	 */
	public static final Vector4i UNIT_X = new ReadOnlyVector4i(1, 0, 0, 0);
	/**
	 * A unit y vector, Vector4i(0, 1, 0, 0).
	 */
	public static final Vector4i UNIT_Y = new ReadOnlyVector4i(0, 1, 0, 0);
	/**
	 * A unit z vector, Vector4i(0, 0, 1, 0).
	 */
	public static final Vector4i UNIT_Z = new ReadOnlyVector4i(0, 0, 1, 0);
	/**
	 * A unit w vector, Vector4i(0, 0, 0, 1).
	 */
	public static final Vector4i UNIT_W = new ReadOnlyVector4i(0, 0, 0, 1);
	/**
	 * A unit x, y, z and w vector, Vector4i(1, 1, 1, 1).
	 */
	public static final Vector4i UNIT_XYZW = new ReadOnlyVector4i(1, 1, 1, 1);
	/**
	 * A unit x vector, Vector4i(-1, 0, 0, 0).
	 */
	public static final Vector4i UNIT_NEGATIVE_X = new ReadOnlyVector4i(-1, 0, 0, 0);
	/**
	 * A unit y vector, Vector4i(0, -1, 0, 0).
	 */
	public static final Vector4i UNIT_NEGATIVE_Y = new ReadOnlyVector4i(0, -1, 0, 0);
	/**
	 * A unit z vector, Vector4i(0, 0, -1, 0).
	 */
	public static final Vector4i UNIT_NEGATIVE_Z = new ReadOnlyVector4i(0, 0, -1, 0);
	/**
	 * A unit w vector, Vector4i(0, 0, 0, -1).
	 */
	public static final Vector4i UNIT_NEGATIVE_W = new ReadOnlyVector4i(0, 0, 0, -1);
	/**
	 * A unit x, y, z and w vector, Vector4i(-1, -1, -1, -1).
	 */
	public static final Vector4i UNIT_NEGATIVE_XYZW = new ReadOnlyVector4i(-1, -1, -1, -1);

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
	 * The w value of the vector.
	 */
	public int w;

	/**
	 * Creates a new <code>Vector4i</code> instance with the default x, y, z and
	 * w values. Vector4i(0, 0, 0, 0).
	 */
	public Vector4i() {
		this(0, 0, 0, 0);
	}

	/**
	 * Creates a new <code>Vector4i</code> instance with the given x, y, z and w
	 * values.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 * @param z The z value.
	 * @param w The w value.
	 */
	public Vector4i(int x, int y, int z, int w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	/**
	 * Creates a new <code>Vector4i</code> instance with the given values.
	 *
	 * @param v Values.
	 */
	public Vector4i(int... v) {
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
	 * Creates a new <code>Vector4i</code> instance from the given
	 * <code>Vector4i</code>.
	 *
	 * @param copy Vector from where the values are copied.
	 */
	public Vector4i(Vector4i copy) {
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
	public Vector4i set(int x, int y, int z, int w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		return this;
	}

	@Override
	public Vector4i set(Vector4i vec) {
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

	/**
	 * Sets the w value in this vector.
	 *
	 * @param w W value.
	 */
	public void setW(Integer w) {
		this.w = w;
	}

	/**
	 * Returns the w value.
	 *
	 * @return W value.
	 */
	public Integer getW() {
		return w;
	}

	@Override
	public Vector4i add(Integer v) {
		return new Vector4i(this).addLocal(v);
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
	public Vector4i add(Integer x, Integer y, Integer z, Integer w) {
		return new Vector4i(this).addLocal(x, y, z, w);
	}

	@Override
	public Vector4i add(Vector4i vec) {
		return new Vector4i(this).addLocal(vec);
	}

	@Override
	public Vector4i addLocal(Integer v) {
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
	public Vector4i addLocal(Integer x, Integer y, Integer z, Integer w) {
		this.x += x;
		this.y += y;
		this.z += z;
		this.w += w;
		return this;
	}

	@Override
	public Vector4i addLocal(Vector4i vec) {
		x += vec.x;
		y += vec.y;
		z += vec.z;
		w += vec.w;
		return this;
	}

	@Override
	public Vector4i subtract(Integer v) {
		return new Vector4i(this).subtractLocal(v);
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
	public Vector4i subtract(Integer x, Integer y, Integer z, Integer w) {
		return new Vector4i(this).subtractLocal(x, y, z, w);
	}

	@Override
	public Vector4i subtract(Vector4i vec) {
		return new Vector4i(this).subtractLocal(vec);
	}

	@Override
	public Vector4i subtractLocal(Integer v) {
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
	public Vector4i subtractLocal(Integer x, Integer y, Integer z, Integer w) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
		this.w -= w;
		return this;
	}

	@Override
	public Vector4i subtractLocal(Vector4i vec) {
		x -= vec.x;
		y -= vec.y;
		z -= vec.z;
		w -= vec.w;
		return this;
	}

	@Override
	public Vector4i multiplicate(Integer v) {
		return new Vector4i(this).multiplicateLocal(v);
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
	public Vector4i multiplicate(Integer x, Integer y, Integer z, Integer w) {
		return new Vector4i(this).multiplicateLocal(x, y, z, w);
	}

	@Override
	public Vector4i multiplicate(Vector4i vec) {
		return new Vector4i(this).multiplicateLocal(vec);
	}

	@Override
	public Vector4i multiplicateLocal(Integer v) {
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
	public Vector4i multiplicateLocal(Integer x, Integer y, Integer z, Integer w) {
		this.x *= x;
		this.y *= y;
		this.z *= z;
		this.w *= w;
		return this;
	}

	@Override
	public Vector4i multiplicateLocal(Vector4i vec) {
		x *= vec.x;
		y *= vec.y;
		z *= vec.z;
		w *= vec.w;
		return this;
	}

	@Override
	public Vector4i divide(Integer v) {
		return new Vector4i(this).divideLocal(v);
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
	public Vector4i divide(Integer x, Integer y, Integer z, Integer w) {
		return new Vector4i(this).divideLocal(x, y, z, w);
	}

	@Override
	public Vector4i divide(Vector4i vec) {
		return new Vector4i(this).divideLocal(vec);
	}

	@Override
	public Vector4i divideLocal(Integer v) {
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
	public Vector4i divideLocal(Integer x, Integer y, Integer z, Integer w) {
		this.x /= x;
		this.y /= y;
		this.z /= z;
		this.w /= w;
		return this;
	}

	@Override
	public Vector4i divideLocal(Vector4i vec) {
		x /= vec.x;
		y /= vec.y;
		z /= vec.z;
		w /= vec.w;
		return this;
	}

	@Override
	public double dot(Vector4i vec) {
		return x * vec.x + y * vec.y + z * vec.z + w * vec.w;
	}

	@Override
	public Vector4i cross(Vector4i vec) {
		int tempx = ((y * vec.z) - (z * vec.y));
		int tempy = ((z * vec.x) - (x * vec.z));
		int tempz = ((x * vec.y) - (y * vec.x));
		return new Vector4i(tempx, tempy, tempz, 1);
	}

	@Override
	public double determinant(Vector4i vec) {
		return (x * vec.x) - (y * vec.y) - (z * vec.z) - (w * vec.w);
	}

	@Override
	public Vector4i abs() {
		x = FastMath.abs(x);
		y = FastMath.abs(y);
		z = FastMath.abs(z);
		w = FastMath.abs(w);
		return this;
	}

	@Override
	public Vector4i clampMin(Integer min) {
		x = FastMath.max(x, min);
		y = FastMath.max(y, min);
		z = FastMath.max(z, min);
		w = FastMath.max(w, min);
		return this;
	}

	@Override
	public Vector4i clampMax(Integer max) {
		x = FastMath.min(x, max);
		y = FastMath.min(y, max);
		z = FastMath.min(z, max);
		w = FastMath.min(w, max);
		return this;
	}

	@Override
	public Integer length() {
		return FastMath.roundToInt(FastMath.sqrt(lengthSquared()));
	}

	@Override
	public Integer lengthSquared() {
		return x * x + y * y + z * z + w * w;
	}

	@Override
	public Integer distance(Vector4i vec) {
		return FastMath.roundToInt(FastMath.sqrt(distanceSquared(vec)));
	}

	@Override
	public Integer distanceSquared(Vector4i vec) {
		int dx = x - vec.x;
		int dy = y - vec.y;
		int dz = z - vec.z;
		int dw = w - vec.w;
		return dx * dx + dy * dy + dz * dz + dw * dw;
	}

	@Override
	public Vector4i negate() {
		return new Vector4i(this).negateLocal();
	}

	@Override
	public Vector4i negateLocal() {
		x = -x;
		y = -y;
		z = -z;
		w = -w;
		return this;
	}

	@Override
	public Vector4i normalize() {
		return new Vector4i(this).normalizeLocal();
	}

	@Override
	public Vector4i normalizeLocal() {
		double length = lengthSquared();
		if (length != 1.0f && length != 0f) {
			length = 1.0f / FastMath.sqrt(length);
			multiplicateLocal(FastMath.roundToInt(length));
		}
		return this;
	}

	@Override
	public Vector4i zero() {
		return fill(0);
	}

	@Override
	public Vector4i one() {
		return fill(1);
	}

	@Override
	public Vector4i fill(Integer v) {
		x = y = z = w = v;
		return this;
	}

	@Override
	public Vector4i max(Vector4i vec) {
		return new Vector4i(this).maxLocal(vec);
	}

	@Override
	public Vector4i maxLocal(Vector4i vec) {
		x = FastMath.max(x, vec.x);
		y = FastMath.max(y, vec.y);
		z = FastMath.max(z, vec.z);
		w = FastMath.max(w, vec.w);
		return this;
	}

	@Override
	public Vector4i min(Vector4i vec) {
		return new Vector4i(this).minLocal(vec);
	}

	@Override
	public Vector4i minLocal(Vector4i vec) {
		x = FastMath.min(x, vec.x);
		y = FastMath.min(y, vec.y);
		z = FastMath.min(z, vec.z);
		w = FastMath.min(w, vec.w);
		return this;
	}

	@Override
	public Vector4i clamp(Vector4i vec1, Vector4i vec2) {
		return new Vector4i(this).clampLocal(vec1, vec2);
	}

	@Override
	public Vector4i clampLocal(Vector4i vec1, Vector4i vec2) {
		x = FastMath.clamp(x, vec1.x, vec2.x);
		y = FastMath.clamp(y, vec1.y, vec2.y);
		z = FastMath.clamp(z, vec1.z, vec2.z);
		w = FastMath.clamp(w, vec1.w, vec2.w);
		return this;
	}

	@Override
	public Vector4i put(int i, Integer v) {
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
		if (i == 3) {
			return w;
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
		return x == v && y == v && z == v && w == v;
	}

	@Override
	public boolean isNaNVector() {
		return Double.isNaN(x) || Double.isNaN(y) || Double.isNaN(z) || Double.isNaN(w);
	}

	@Override
	public boolean isInfiniteVector() {
		return Double.isInfinite(x) || Double.isInfinite(y) || Double.isInfinite(z) || Double.isInfinite(w);
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
		w = array[3];
	}

	@Override
	public Integer[] toArray() {
		return new Integer[]{x, y, z, w};
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + this.x;
		hash = 79 * hash + this.y;
		hash = 79 * hash + this.z;
		hash = 79 * hash + this.w;
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
		final Vector4i other = (Vector4i) obj;
		if (this.x != other.x) {
			return false;
		}
		if (this.y != other.y) {
			return false;
		}
		if (this.z != other.z) {
			return false;
		}
		return this.w == other.w;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Vector4i{");
		result.append(x).append(", ");
		result.append(y).append(", ");
		result.append(z).append(", ");
		result.append(w);
		result.append("}");
		return result.toString();
	}

	@Override
	public Vector4i clone() throws CloneNotSupportedException {
		return (Vector4i) super.clone();
	}
}
