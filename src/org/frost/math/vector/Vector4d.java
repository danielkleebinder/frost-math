package org.frost.math.vector;

import org.frost.math.FastMath;

/**
 * A vector holding 4 double values.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Vector4d implements Vector<Vector4d, Double> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 78665757234L;

	/**
	 * A zero vector, Vector4d(0, 0, 0, 0).
	 */
	public static final Vector4d ZERO = new ReadOnlyVector4d(0, 0, 0, 0);
	/**
	 * A unit x vector, Vector4d(1, 0, 0, 0).
	 */
	public static final Vector4d UNIT_X = new ReadOnlyVector4d(1, 0, 0, 0);
	/**
	 * A unit y vector, Vector4d(0, 1, 0, 0).
	 */
	public static final Vector4d UNIT_Y = new ReadOnlyVector4d(0, 1, 0, 0);
	/**
	 * A unit z vector, Vector4d(0, 0, 1, 0).
	 */
	public static final Vector4d UNIT_Z = new ReadOnlyVector4d(0, 0, 1, 0);
	/**
	 * A unit w vector, Vector4d(0, 0, 0, 1).
	 */
	public static final Vector4d UNIT_W = new ReadOnlyVector4d(0, 0, 0, 1);
	/**
	 * A unit x, y, z and w vector, Vector4d(1, 1, 1, 1).
	 */
	public static final Vector4d UNIT_XYZW = new ReadOnlyVector4d(1, 1, 1, 1);
	/**
	 * A unit x vector, Vector4d(-1, 0, 0, 0).
	 */
	public static final Vector4d UNIT_NEGATIVE_X = new ReadOnlyVector4d(-1, 0, 0, 0);
	/**
	 * A unit y vector, Vector4d(0, -1, 0, 0).
	 */
	public static final Vector4d UNIT_NEGATIVE_Y = new ReadOnlyVector4d(0, -1, 0, 0);
	/**
	 * A unit z vector, Vector4d(0, 0, -1, 0).
	 */
	public static final Vector4d UNIT_NEGATIVE_Z = new ReadOnlyVector4d(0, 0, -1, 0);
	/**
	 * A unit w vector, Vector4d(0, 0, 0, -1).
	 */
	public static final Vector4d UNIT_NEGATIVE_W = new ReadOnlyVector4d(0, 0, 0, -1);
	/**
	 * A unit x, y, z and w vector, Vector4d(-1, -1, -1, -1).
	 */
	public static final Vector4d UNIT_NEGATIVE_XYZW = new ReadOnlyVector4d(-1, -1, -1, -1);

	/**
	 * The x value of the vector.
	 */
	public double x;
	/**
	 * The y value of the vector.
	 */
	public double y;
	/**
	 * The z value of the vector.
	 */
	public double z;
	/**
	 * The w value of the vector.
	 */
	public double w;

	/**
	 * Creates a new <code>Vector4d</code> instance with the default x, y, z and
	 * w values. Vector4d(0.0, 0.0, 0.0, 0.0).
	 */
	public Vector4d() {
		this(0, 0, 0, 0);
	}

	/**
	 * Creates a new <code>Vector4d</code> instance with the given x, y, z and w
	 * values.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 * @param z The z value.
	 * @param w The w value.
	 */
	public Vector4d(double x, double y, double z, double w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	/**
	 * Creates a new <code>Vector4d</code> instance with the given values.
	 *
	 * @param v Values.
	 */
	public Vector4d(double... v) {
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
	 * Creates a new <code>Vector4d</code> instance from the given
	 * <code>Vector4d</code>.
	 *
	 * @param copy Vector from where the values are copied.
	 */
	public Vector4d(Vector4d copy) {
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
	public Vector4d set(double x, double y, double z, double w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		return this;
	}

	@Override
	public Vector4d set(Vector4d vec) {
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

	/**
	 * Sets the z value in this vector.
	 *
	 * @param z Z value.
	 */
	public void setZ(Double z) {
		this.z = z;
	}

	/**
	 * Returns the z value.
	 *
	 * @return Z value.
	 */
	public Double getZ() {
		return z;
	}

	/**
	 * Sets the w value in this vector.
	 *
	 * @param w W value.
	 */
	public void setW(Double w) {
		this.w = w;
	}

	/**
	 * Returns the w value.
	 *
	 * @return W value.
	 */
	public Double getW() {
		return w;
	}

	@Override
	public Vector4d add(Double v) {
		return new Vector4d(this).addLocal(v);
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
	public Vector4d add(Double x, Double y, Double z, Double w) {
		return new Vector4d(this).addLocal(x, y, z, w);
	}

	@Override
	public Vector4d add(Vector4d vec) {
		return new Vector4d(this).addLocal(vec);
	}

	@Override
	public Vector4d addLocal(Double v) {
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
	public Vector4d addLocal(Double x, Double y, Double z, Double w) {
		this.x += x;
		this.y += y;
		this.z += z;
		this.w += w;
		return this;
	}

	@Override
	public Vector4d addLocal(Vector4d vec) {
		x += vec.x;
		y += vec.y;
		z += vec.z;
		w += vec.w;
		return this;
	}

	@Override
	public Vector4d subtract(Double v) {
		return new Vector4d(this).subtractLocal(v);
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
	public Vector4d subtract(Double x, Double y, Double z, Double w) {
		return new Vector4d(this).subtractLocal(x, y, z, w);
	}

	@Override
	public Vector4d subtract(Vector4d vec) {
		return new Vector4d(this).subtractLocal(vec);
	}

	@Override
	public Vector4d subtractLocal(Double v) {
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
	public Vector4d subtractLocal(Double x, Double y, Double z, Double w) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
		this.w -= w;
		return this;
	}

	@Override
	public Vector4d subtractLocal(Vector4d vec) {
		x -= vec.x;
		y -= vec.y;
		z -= vec.z;
		w -= vec.w;
		return this;
	}

	@Override
	public Vector4d multiplicate(Double v) {
		return new Vector4d(this).multiplicateLocal(v);
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
	public Vector4d multiplicate(Double x, Double y, Double z, Double w) {
		return new Vector4d(this).multiplicateLocal(x, y, z, w);
	}

	@Override
	public Vector4d multiplicate(Vector4d vec) {
		return new Vector4d(this).multiplicateLocal(vec);
	}

	@Override
	public Vector4d multiplicateLocal(Double v) {
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
	public Vector4d multiplicateLocal(Double x, Double y, Double z, Double w) {
		this.x *= x;
		this.y *= y;
		this.z *= z;
		this.w *= w;
		return this;
	}

	@Override
	public Vector4d multiplicateLocal(Vector4d vec) {
		x *= vec.x;
		y *= vec.y;
		z *= vec.z;
		w *= vec.w;
		return this;
	}

	@Override
	public Vector4d divide(Double v) {
		return new Vector4d(this).divideLocal(v);
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
	public Vector4d divide(Double x, Double y, Double z, Double w) {
		return new Vector4d(this).divideLocal(x, y, z, w);
	}

	@Override
	public Vector4d divide(Vector4d vec) {
		return new Vector4d(this).divideLocal(vec);
	}

	@Override
	public Vector4d divideLocal(Double v) {
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
	public Vector4d divideLocal(Double x, Double y, Double z, Double w) {
		this.x /= x;
		this.y /= y;
		this.z /= z;
		this.w /= w;
		return this;
	}

	@Override
	public Vector4d divideLocal(Vector4d vec) {
		x /= vec.x;
		y /= vec.y;
		z /= vec.z;
		w /= vec.w;
		return this;
	}

	@Override
	public double dot(Vector4d vec) {
		return x * vec.x + y * vec.y + z * vec.z + w * vec.w;
	}

	@Override
	public Vector4d cross(Vector4d vec) {
		double tempx = ((y * vec.z) - (z * vec.y));
		double tempy = ((z * vec.x) - (x * vec.z));
		double tempz = ((x * vec.y) - (y * vec.x));
		return new Vector4d(tempx, tempy, tempz, 1.0f);
	}

	@Override
	public double determinant(Vector4d vec) {
		return (x * vec.x) - (y * vec.y) - (z * vec.z) - (w * vec.w);
	}

	@Override
	public Vector4d abs() {
		x = FastMath.abs(x);
		y = FastMath.abs(y);
		z = FastMath.abs(z);
		w = FastMath.abs(w);
		return this;
	}

	@Override
	public Vector4d clampMin(Double min) {
		x = FastMath.max(x, min);
		y = FastMath.max(y, min);
		z = FastMath.max(z, min);
		w = FastMath.max(w, min);
		return this;
	}

	@Override
	public Vector4d clampMax(Double max) {
		x = FastMath.min(x, max);
		y = FastMath.min(y, max);
		z = FastMath.min(z, max);
		w = FastMath.min(w, max);
		return this;
	}

	@Override
	public Double length() {
		return FastMath.sqrt(lengthSquared());
	}

	@Override
	public Double lengthSquared() {
		return x * x + y * y + z * z + w * w;
	}

	@Override
	public Double distance(Vector4d vec) {
		return FastMath.sqrt(distanceSquared(vec));
	}

	@Override
	public Double distanceSquared(Vector4d vec) {
		double dx = x - vec.x;
		double dy = y - vec.y;
		double dz = z - vec.z;
		double dw = w - vec.w;
		return dx * dx + dy * dy + dz * dz + dw * dw;
	}

	@Override
	public Vector4d negate() {
		return new Vector4d(this).negateLocal();
	}

	@Override
	public Vector4d negateLocal() {
		x = -x;
		y = -y;
		z = -z;
		w = -w;
		return this;
	}

	@Override
	public Vector4d normalize() {
		return new Vector4d(this).normalizeLocal();
	}

	@Override
	public Vector4d normalizeLocal() {
		double length = lengthSquared();
		if (length != 1.0f && length != 0.0f) {
			length = 1.0f / FastMath.sqrt(length);
			multiplicateLocal(length);
		}
		return this;
	}

	@Override
	public Vector4d zero() {
		return fill(0.0);
	}

	@Override
	public Vector4d one() {
		return fill(1.0);
	}

	@Override
	public Vector4d fill(Double v) {
		x = y = z = w = v;
		return this;
	}

	@Override
	public Vector4d max(Vector4d vec) {
		return new Vector4d(this).maxLocal(vec);
	}

	@Override
	public Vector4d maxLocal(Vector4d vec) {
		x = FastMath.max(x, vec.x);
		y = FastMath.max(y, vec.y);
		z = FastMath.max(z, vec.z);
		w = FastMath.max(w, vec.w);
		return this;
	}

	@Override
	public Vector4d min(Vector4d vec) {
		return new Vector4d(this).minLocal(vec);
	}

	@Override
	public Vector4d minLocal(Vector4d vec) {
		x = FastMath.min(x, vec.x);
		y = FastMath.min(y, vec.y);
		z = FastMath.min(z, vec.z);
		w = FastMath.min(w, vec.w);
		return this;
	}

	@Override
	public Vector4d clamp(Vector4d vec1, Vector4d vec2) {
		return new Vector4d(this).clampLocal(vec1, vec2);
	}

	@Override
	public Vector4d clampLocal(Vector4d vec1, Vector4d vec2) {
		x = FastMath.clamp(x, vec1.x, vec2.x);
		y = FastMath.clamp(y, vec1.y, vec2.y);
		z = FastMath.clamp(z, vec1.z, vec2.z);
		w = FastMath.clamp(w, vec1.w, vec2.w);
		return this;
	}

	@Override
	public Vector4d put(int i, Double v) {
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
	public Double get(int i) {
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
		return isUnified(1.0);
	}

	@Override
	public boolean isZero() {
		return isUnified(0.0);
	}

	@Override
	public boolean isUnified(Double v) {
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
		double length = length();
		return 0.9999f < length && length < 1.0001f;
	}

	@Override
	public void fromArray(Double... array) {
		x = array[0];
		y = array[1];
		z = array[2];
		w = array[3];
	}

	@Override
	public Double[] toArray() {
		return new Double[]{x, y, z, w};
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 47 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
		hash = 47 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
		hash = 47 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
		hash = 47 * hash + (int) (Double.doubleToLongBits(this.w) ^ (Double.doubleToLongBits(this.w) >>> 32));
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
		final Vector4d other = (Vector4d) obj;
		if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
			return false;
		}
		if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
			return false;
		}
		if (Double.doubleToLongBits(this.z) != Double.doubleToLongBits(other.z)) {
			return false;
		}
		return Double.doubleToLongBits(this.w) == Double.doubleToLongBits(other.w);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Vector4d{");
		result.append(x).append(", ");
		result.append(y).append(", ");
		result.append(z).append(", ");
		result.append(w);
		result.append("}");
		return result.toString();
	}

	@Override
	public Vector4d clone() throws CloneNotSupportedException {
		return (Vector4d) super.clone();
	}
}
