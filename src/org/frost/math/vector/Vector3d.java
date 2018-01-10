package org.frost.math.vector;

import org.frost.math.FastMath;

/**
 * A vector holding 3 double values.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Vector3d implements Vector<Vector3d, Double> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 143124786576L;

	/**
	 * A zero vector, Vector3d(0, 0, 0).
	 */
	public static final Vector3d ZERO = new ReadOnlyVector3d(0, 0, 0);
	/**
	 * A unit x vector, Vector3d(1, 0, 0).
	 */
	public static final Vector3d UNIT_X = new ReadOnlyVector3d(1, 0, 0);
	/**
	 * A unit y vector, Vector3d(0, 1, 0).
	 */
	public static final Vector3d UNIT_Y = new ReadOnlyVector3d(0, 1, 0);
	/**
	 * A unit z vector, Vector3d(0, 0, 1).
	 */
	public static final Vector3d UNIT_Z = new ReadOnlyVector3d(0, 0, 1);
	/**
	 * A unit x, y and z vector, Vector3d(1, 1, 1).
	 */
	public static final Vector3d UNIT_XYZ = new ReadOnlyVector3d(1, 1, 1);
	/**
	 * A unit x vector, Vector3d(-1, 0, 0).
	 */
	public static final Vector3d UNIT_NEGATIVE_X = new ReadOnlyVector3d(-1, 0, 0);
	/**
	 * A unit y vector, Vector3d(0, -1, 0).
	 */
	public static final Vector3d UNIT_NEGATIVE_Y = new ReadOnlyVector3d(0, -1, 0);
	/**
	 * A unit z vector, Vector3d(0, 0, -1).
	 */
	public static final Vector3d UNIT_NEGATIVE_Z = new ReadOnlyVector3d(0, 0, -1);
	/**
	 * A unit x, y and z vector, Vector3d(-1, -1, -1).
	 */
	public static final Vector3d UNIT_NEGATIVE_XYZ = new ReadOnlyVector3d(-1, -1, -1);

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
	 * Creates a new <code>Vector3d</code> instance with the default x, y and z
	 * values. Vector3d(0.0, 0.0, 0.0).
	 */
	public Vector3d() {
		this(0, 0, 0);
	}

	/**
	 * Creates a new <code>Vector3d</code> instance with the given x, y and z
	 * values.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 * @param z The z value.
	 */
	public Vector3d(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Creates a new <code>Vector3d</code> instance with the given values.
	 *
	 * @param v Values.
	 */
	public Vector3d(double... v) {
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
	 * Creates a new <code>Vector3d</code> instance from the given
	 * <code>Vector3d</code>.
	 *
	 * @param copy Vector from where the values are copied.
	 */
	public Vector3d(Vector3d copy) {
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
	public Vector3d set(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}

	@Override
	public Vector3d set(Vector3d vec) {
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

	@Override
	public Vector3d add(Double v) {
		return new Vector3d(this).addLocal(v);
	}

	/**
	 * Adds the given values to this vector and returns a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @return New vector.
	 */
	public Vector3d add(Double x, Double y, Double z) {
		return new Vector3d(this).addLocal(x, y, z);
	}

	@Override
	public Vector3d add(Vector3d vec) {
		return new Vector3d(this).addLocal(vec);
	}

	@Override
	public Vector3d addLocal(Double v) {
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
	public Vector3d addLocal(Double x, Double y, Double z) {
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	@Override
	public Vector3d addLocal(Vector3d vec) {
		x += vec.x;
		y += vec.y;
		z += vec.z;
		return this;
	}

	@Override
	public Vector3d subtract(Double v) {
		return new Vector3d(this).subtractLocal(v);
	}

	/**
	 * Subtracts the given values from this vector and writes them to a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @return New vector.
	 */
	public Vector3d subtract(Double x, Double y, Double z) {
		return new Vector3d(this).subtractLocal(x, y, z);
	}

	@Override
	public Vector3d subtract(Vector3d vec) {
		return new Vector3d(this).subtractLocal(vec);
	}

	@Override
	public Vector3d subtractLocal(Double v) {
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
	public Vector3d subtractLocal(Double x, Double y, Double z) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}

	@Override
	public Vector3d subtractLocal(Vector3d vec) {
		x -= vec.x;
		y -= vec.y;
		z -= vec.z;
		return this;
	}

	@Override
	public Vector3d multiplicate(Double v) {
		return new Vector3d(this).multiplicateLocal(v);
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
	public Vector3d multiplicate(Double x, Double y, Double z) {
		return new Vector3d(this).multiplicateLocal(x, y, z);
	}

	@Override
	public Vector3d multiplicate(Vector3d vec) {
		return new Vector3d(this).multiplicateLocal(vec);
	}

	@Override
	public Vector3d multiplicateLocal(Double v) {
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
	public Vector3d multiplicateLocal(Double x, Double y, Double z) {
		this.x *= x;
		this.y *= y;
		this.z *= z;
		return this;
	}

	@Override
	public Vector3d multiplicateLocal(Vector3d vec) {
		x *= vec.x;
		y *= vec.y;
		z *= vec.z;
		return this;
	}

	@Override
	public Vector3d divide(Double v) {
		return new Vector3d(this).divideLocal(v);
	}

	/**
	 * Divides this vector by the given values and writes them to a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @return New vector.
	 */
	public Vector3d divide(Double x, Double y, Double z) {
		return new Vector3d(this).divideLocal(x, y, z);
	}

	@Override
	public Vector3d divide(Vector3d vec) {
		return new Vector3d(this).divideLocal(vec);
	}

	@Override
	public Vector3d divideLocal(Double v) {
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
	public Vector3d divideLocal(Double x, Double y, Double z) {
		this.x /= x;
		this.y /= y;
		this.z /= z;
		return this;
	}

	@Override
	public Vector3d divideLocal(Vector3d vec) {
		x /= vec.x;
		y /= vec.y;
		z /= vec.z;
		return this;
	}

	@Override
	public double dot(Vector3d vec) {
		return x * vec.x + y * vec.y + z * vec.z;
	}

	@Override
	public Vector3d cross(Vector3d vec) {
		double tempx = (y * vec.z) - (z * vec.y);
		double tempy = (z * vec.x) - (x * vec.z);
		double tempz = (x * vec.y) - (y * vec.x);
		return new Vector3d(tempx, tempy, tempz);
	}

	@Override
	public double determinant(Vector3d vec) {
		return (x * vec.x) - (y * vec.y) - (z * vec.z);
	}

	@Override
	public Vector3d abs() {
		x = FastMath.abs(x);
		y = FastMath.abs(y);
		z = FastMath.abs(z);
		return this;
	}

	@Override
	public Vector3d clampMin(Double min) {
		x = FastMath.max(x, min);
		y = FastMath.max(y, min);
		z = FastMath.max(z, min);
		return this;
	}

	@Override
	public Vector3d clampMax(Double max) {
		x = FastMath.min(x, max);
		y = FastMath.min(y, max);
		z = FastMath.min(z, max);
		return this;
	}

	@Override
	public Double length() {
		return FastMath.sqrt(lengthSquared());
	}

	@Override
	public Double lengthSquared() {
		return x * x + y * y + z * z;
	}

	@Override
	public Double distance(Vector3d vec) {
		return FastMath.sqrt(distanceSquared(vec));
	}

	@Override
	public Double distanceSquared(Vector3d vec) {
		double dx = x - vec.x;
		double dy = y - vec.y;
		double dz = z - vec.z;
		return dx * dx + dy * dy + dz * dz;
	}

	@Override
	public Vector3d negate() {
		return new Vector3d(this).negateLocal();
	}

	@Override
	public Vector3d negateLocal() {
		x = -x;
		y = -y;
		z = -z;
		return this;
	}

	@Override
	public Vector3d normalize() {
		return new Vector3d(this).normalizeLocal();
	}

	@Override
	public Vector3d normalizeLocal() {
		double length = lengthSquared();
		if (length != 1.0f && length != 0.0f) {
			length = 1.0f / FastMath.sqrt(length);
			multiplicateLocal(length);
		}
		return this;
	}

	@Override
	public Vector3d zero() {
		return fill(0.0);
	}

	@Override
	public Vector3d one() {
		return fill(1.0);
	}

	@Override
	public Vector3d fill(Double v) {
		x = y = z = v;
		return this;
	}

	@Override
	public Vector3d max(Vector3d vec) {
		return new Vector3d(this).maxLocal(vec);
	}

	@Override
	public Vector3d maxLocal(Vector3d vec) {
		x = FastMath.max(x, vec.x);
		y = FastMath.max(y, vec.y);
		z = FastMath.max(z, vec.z);
		return this;
	}

	@Override
	public Vector3d min(Vector3d vec) {
		return new Vector3d(this).minLocal(vec);
	}

	@Override
	public Vector3d minLocal(Vector3d vec) {
		x = FastMath.min(x, vec.x);
		y = FastMath.min(y, vec.y);
		z = FastMath.min(z, vec.z);
		return this;
	}

	@Override
	public Vector3d clamp(Vector3d vec1, Vector3d vec2) {
		return new Vector3d(this).clampLocal(vec1, vec2);
	}

	@Override
	public Vector3d clampLocal(Vector3d vec1, Vector3d vec2) {
		x = FastMath.clamp(x, vec1.x, vec2.x);
		y = FastMath.clamp(y, vec1.y, vec2.y);
		z = FastMath.clamp(z, vec1.z, vec2.z);
		return this;
	}

	@Override
	public Vector3d put(int i, Double v) {
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
		double length = length();
		return 0.9999f < length && length < 1.0001f;
	}

	@Override
	public void fromArray(Double... array) {
		x = array[0];
		y = array[1];
		z = array[2];
	}

	@Override
	public Double[] toArray() {
		return new Double[]{x, y, z};
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 23 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
		hash = 23 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
		hash = 23 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
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
		final Vector3d other = (Vector3d) obj;
		if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
			return false;
		}
		if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
			return false;
		}
		return Double.doubleToLongBits(this.z) == Double.doubleToLongBits(other.z);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Vector3d{");
		result.append(x).append(", ");
		result.append(y).append(", ");
		result.append(z);
		result.append("}");
		return result.toString();
	}

	@Override
	public Vector3d clone() throws CloneNotSupportedException {
		return (Vector3d) super.clone();
	}
}
