package org.frost.math.vector;

import java.math.BigDecimal;
import java.util.Objects;
import org.frost.math.FastMath;

/**
 * A vector holding 3 big decimal values.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Vector3bd implements Vector<Vector3bd, BigDecimal> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 143124786576L;

	/**
	 * A zero vector, Vector3bd(0, 0, 0).
	 */
	public static final Vector3bd ZERO = new ReadOnlyVector3bd(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
	/**
	 * A unit x vector, Vector3bd(1, 0, 0).
	 */
	public static final Vector3bd UNIT_X = new ReadOnlyVector3bd(BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ZERO);
	/**
	 * A unit y vector, Vector3bd(0, 1, 0).
	 */
	public static final Vector3bd UNIT_Y = new ReadOnlyVector3bd(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.ZERO);
	/**
	 * A unit z vector, Vector3bd(0, 0, 1).
	 */
	public static final Vector3bd UNIT_Z = new ReadOnlyVector3bd(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ONE);
	/**
	 * A unit x, y and z vector, Vector3bd(1, 1, 1).
	 */
	public static final Vector3bd UNIT_XYZ = new ReadOnlyVector3bd(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE);
	/**
	 * A unit x vector, Vector3bd(-1, 0, 0).
	 */
	public static final Vector3bd UNIT_NEGATIVE_X = new ReadOnlyVector3bd(BigDecimal.ONE.negate(), BigDecimal.ZERO, BigDecimal.ZERO);
	/**
	 * A unit y vector, Vector3bd(0, -1, 0).
	 */
	public static final Vector3bd UNIT_NEGATIVE_Y = new ReadOnlyVector3bd(BigDecimal.ZERO, BigDecimal.ONE.negate(), BigDecimal.ZERO);
	/**
	 * A unit z vector, Vector3bd(0, 0, -1).
	 */
	public static final Vector3bd UNIT_NEGATIVE_Z = new ReadOnlyVector3bd(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ONE.negate());
	/**
	 * A unit x, y and z vector, Vector3bd(-1, -1, -1).
	 */
	public static final Vector3bd UNIT_NEGATIVE_XYZ = new ReadOnlyVector3bd(BigDecimal.ONE.negate(), BigDecimal.ONE.negate(), BigDecimal.ONE.negate());

	/**
	 * The x value of the vector.
	 */
	public BigDecimal x;
	/**
	 * The y value of the vector.
	 */
	public BigDecimal y;
	/**
	 * The z value of the vector.
	 */
	public BigDecimal z;

	/**
	 * Creates a new <code>Vector3bd</code> instance with the default x, y and z
	 * values. Vector3bd(0.0, 0.0, 0.0).
	 */
	public Vector3bd() {
		this(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
	}

	/**
	 * Creates a new <code>Vector3bd</code> instance with the given x, y and z
	 * values.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 * @param z The z value.
	 */
	public Vector3bd(BigDecimal x, BigDecimal y, BigDecimal z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Creates a new <code>Vector3bd</code> instance with the given values.
	 *
	 * @param v Values.
	 */
	public Vector3bd(BigDecimal... v) {
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
	 * Creates a new <code>Vector3bd</code> instance from the given
	 * <code>Vector3bd</code>.
	 *
	 * @param copy Vector from where the values are copied.
	 */
	public Vector3bd(Vector3bd copy) {
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
	public Vector3bd set(BigDecimal x, BigDecimal y, BigDecimal z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}

	@Override
	public Vector3bd set(Vector3bd vec) {
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
	public void setX(BigDecimal x) {
		this.x = x;
	}

	/**
	 * Returns the x value.
	 *
	 * @return X value.
	 */
	public BigDecimal getX() {
		return x;
	}

	/**
	 * Sets the y value in this vector.
	 *
	 * @param y Y value.
	 */
	public void setY(BigDecimal y) {
		this.y = y;
	}

	/**
	 * Returns the y value.
	 *
	 * @return Y value.
	 */
	public BigDecimal getY() {
		return y;
	}

	/**
	 * Sets the z value in this vector.
	 *
	 * @param z Z value.
	 */
	public void setZ(BigDecimal z) {
		this.z = z;
	}

	/**
	 * Returns the z value.
	 *
	 * @return Z value.
	 */
	public BigDecimal getZ() {
		return z;
	}

	@Override
	public Vector3bd add(BigDecimal v) {
		return new Vector3bd(this).addLocal(v);
	}

	/**
	 * Adds the given values to this vector and returns a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @return New vector.
	 */
	public Vector3bd add(BigDecimal x, BigDecimal y, BigDecimal z) {
		return new Vector3bd(this).addLocal(x, y, z);
	}

	@Override
	public Vector3bd add(Vector3bd vec) {
		return new Vector3bd(this).addLocal(vec);
	}

	@Override
	public Vector3bd addLocal(BigDecimal v) {
		x = x.add(v);
		y = y.add(v);
		z = z.add(v);
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
	public Vector3bd addLocal(BigDecimal x, BigDecimal y, BigDecimal z) {
		this.x = this.x.add(x);
		this.y = this.y.add(y);
		this.z = this.z.add(z);
		return this;
	}

	@Override
	public Vector3bd addLocal(Vector3bd vec) {
		x = x.add(vec.x);
		y = y.add(vec.y);
		z = z.add(vec.z);
		return this;
	}

	@Override
	public Vector3bd subtract(BigDecimal v) {
		return new Vector3bd(this).subtractLocal(v);
	}

	/**
	 * Subtracts the given values from this vector and writes them to a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @return New vector.
	 */
	public Vector3bd subtract(BigDecimal x, BigDecimal y, BigDecimal z) {
		return new Vector3bd(this).subtractLocal(x, y, z);
	}

	@Override
	public Vector3bd subtract(Vector3bd vec) {
		return new Vector3bd(this).subtractLocal(vec);
	}

	@Override
	public Vector3bd subtractLocal(BigDecimal v) {
		x = x.subtract(v);
		y = y.subtract(v);
		z = z.subtract(v);
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
	public Vector3bd subtractLocal(BigDecimal x, BigDecimal y, BigDecimal z) {
		this.x = this.x.subtract(x);
		this.y = this.y.subtract(y);
		this.z = this.z.subtract(z);
		return this;
	}

	@Override
	public Vector3bd subtractLocal(Vector3bd vec) {
		x = x.subtract(vec.x);
		y = y.subtract(vec.y);
		z = z.subtract(vec.z);
		return this;
	}

	@Override
	public Vector3bd multiplicate(BigDecimal v) {
		return new Vector3bd(this).multiplicateLocal(v);
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
	public Vector3bd multiplicate(BigDecimal x, BigDecimal y, BigDecimal z) {
		return new Vector3bd(this).multiplicateLocal(x, y, z);
	}

	@Override
	public Vector3bd multiplicate(Vector3bd vec) {
		return new Vector3bd(this).multiplicateLocal(vec);
	}

	@Override
	public Vector3bd multiplicateLocal(BigDecimal v) {
		x = x.multiply(v);
		y = y.multiply(v);
		z = z.multiply(v);
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
	public Vector3bd multiplicateLocal(BigDecimal x, BigDecimal y, BigDecimal z) {
		this.x = this.x.multiply(x);
		this.y = this.y.multiply(y);
		this.z = this.z.multiply(z);
		return this;
	}

	@Override
	public Vector3bd multiplicateLocal(Vector3bd vec) {
		x = x.multiply(vec.x);
		y = y.multiply(vec.y);
		z = z.multiply(vec.z);
		return this;
	}

	@Override
	public Vector3bd divide(BigDecimal v) {
		return new Vector3bd(this).divideLocal(v);
	}

	/**
	 * Divides this vector by the given values and writes them to a new one.
	 *
	 * @param x X value.
	 * @param y Y value.
	 * @param z Z value.
	 * @return New vector.
	 */
	public Vector3bd divide(BigDecimal x, BigDecimal y, BigDecimal z) {
		return new Vector3bd(this).divideLocal(x, y, z);
	}

	@Override
	public Vector3bd divide(Vector3bd vec) {
		return new Vector3bd(this).divideLocal(vec);
	}

	@Override
	public Vector3bd divideLocal(BigDecimal v) {
		x = x.divide(v);
		y = y.divide(v);
		z = z.divide(v);
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
	public Vector3bd divideLocal(BigDecimal x, BigDecimal y, BigDecimal z) {
		this.x = this.x.divide(x);
		this.y = this.y.divide(y);
		this.z = this.z.divide(z);
		return this;
	}

	@Override
	public Vector3bd divideLocal(Vector3bd vec) {
		x = x.divide(vec.x);
		y = y.divide(vec.y);
		z = z.divide(vec.z);
		return this;
	}

	@Override
	public double dot(Vector3bd vec) {
		return x.multiply(vec.x).add(y.multiply(vec.y).add(z.multiply(vec.z))).doubleValue();
	}

	@Override
	public Vector3bd cross(Vector3bd vec) {
		BigDecimal tempx = (y.multiply(vec.z)).subtract(z.multiply(vec.y));
		BigDecimal tempy = (z.multiply(vec.x)).subtract(x.multiply(vec.z));
		BigDecimal tempz = (x.multiply(vec.y)).subtract(y.multiply(vec.x));
		return new Vector3bd(tempx, tempy, tempz);
	}

	@Override
	public double determinant(Vector3bd vec) {
		return (x.multiply(vec.x)).subtract(y.multiply(vec.y).subtract(z.multiply(vec.z))).doubleValue();
	}

	@Override
	public Vector3bd abs() {
		x = x.abs();
		y = y.abs();
		z = z.abs();
		return this;
	}

	@Override
	public Vector3bd clampMin(BigDecimal min) {
		x = x.max(min);
		y = y.max(min);
		z = z.max(min);
		return this;
	}

	@Override
	public Vector3bd clampMax(BigDecimal max) {
		x = x.min(max);
		y = y.min(max);
		z = z.min(max);
		return this;
	}

	@Override
	public BigDecimal length() {
		return new BigDecimal(FastMath.sqrt(lengthSquared().doubleValue()));		// Use simple double precision
	}

	@Override
	public BigDecimal lengthSquared() {
		return x.multiply(x).add(y.multiply(y).add(z.multiply(z)));
	}

	@Override
	public BigDecimal distance(Vector3bd vec) {
		return new BigDecimal(FastMath.sqrt(distanceSquared(vec).doubleValue()));	// Use simple double precision
	}

	@Override
	public BigDecimal distanceSquared(Vector3bd vec) {
		BigDecimal dx = x.subtract(vec.x);
		BigDecimal dy = y.subtract(vec.y);
		BigDecimal dz = z.subtract(vec.z);
		return dx.multiply(dx).add(dy.multiply(dy).add(dz.multiply(dz)));
	}

	@Override
	public Vector3bd negate() {
		return new Vector3bd(this).negateLocal();
	}

	@Override
	public Vector3bd negateLocal() {
		x = x.negate();
		y = y.negate();
		z = z.negate();
		return this;
	}

	@Override
	public Vector3bd normalize() {
		return new Vector3bd(this).normalizeLocal();
	}

	@Override
	public Vector3bd normalizeLocal() {
		BigDecimal length = lengthSquared();
		if (length.equals(BigDecimal.ONE) && length.equals(BigDecimal.ZERO)) {
			length = BigDecimal.ONE.divide(new BigDecimal(FastMath.sqrt(length.doubleValue())));		// Use simple double precision
			multiplicateLocal(length);
		}
		return this;
	}

	@Override
	public Vector3bd zero() {
		return fill(BigDecimal.ZERO);
	}

	@Override
	public Vector3bd one() {
		return fill(BigDecimal.ONE);
	}

	@Override
	public Vector3bd fill(BigDecimal v) {
		x = y = z = v;
		return this;
	}

	@Override
	public Vector3bd max(Vector3bd vec) {
		return new Vector3bd(this).maxLocal(vec);
	}

	@Override
	public Vector3bd maxLocal(Vector3bd vec) {
		x = x.max(vec.x);
		y = y.max(vec.y);
		z = z.max(vec.z);
		return this;
	}

	@Override
	public Vector3bd min(Vector3bd vec) {
		return new Vector3bd(this).minLocal(vec);
	}

	@Override
	public Vector3bd minLocal(Vector3bd vec) {
		x = x.min(vec.x);
		y = y.min(vec.y);
		z = z.min(vec.z);
		return this;
	}

	@Override
	public Vector3bd clamp(Vector3bd vec1, Vector3bd vec2) {
		return new Vector3bd(this).clampLocal(vec1, vec2);
	}

	@Override
	public Vector3bd clampLocal(Vector3bd vec1, Vector3bd vec2) {
		x = x.max(vec1.x).min(vec2.x);
		y = y.max(vec1.y).min(vec2.y);
		z = z.max(vec1.z).min(vec2.z);
		return this;
	}

	@Override
	public Vector3bd put(int i, BigDecimal v) {
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
	public BigDecimal get(int i) {
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
		return isUnified(BigDecimal.ONE);
	}

	@Override
	public boolean isZero() {
		return isUnified(BigDecimal.ZERO);
	}

	@Override
	public boolean isUnified(BigDecimal v) {
		return x.equals(v) && y.equals(v) && z.equals(v);
	}

	@Override
	public boolean isNaNVector() {
		throw new UnsupportedOperationException("Big decimal numbers have no representation for NaN!");
	}

	@Override
	public boolean isInfiniteVector() {
		throw new UnsupportedOperationException("Big decimal numbers have no representation for infinite!");
	}

	@Override
	public boolean isUnitVector() {
		double length = length().doubleValue();
		return 0.9999f < length && length < 1.0001f;
	}

	@Override
	public void fromArray(BigDecimal... array) {
		x = array[0];
		y = array[1];
		z = array[2];
	}

	@Override
	public BigDecimal[] toArray() {
		return new BigDecimal[]{x, y, z};
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.x);
		hash = 79 * hash + Objects.hashCode(this.y);
		hash = 79 * hash + Objects.hashCode(this.z);
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
		final Vector3bd other = (Vector3bd) obj;
		if (!Objects.equals(this.x, other.x)) {
			return false;
		}
		if (!Objects.equals(this.y, other.y)) {
			return false;
		}
		return Objects.equals(this.z, other.z);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Vector3bd{");
		result.append(x).append(", ");
		result.append(y).append(", ");
		result.append(z);
		result.append("}");
		return result.toString();
	}

	@Override
	public Vector3bd clone() throws CloneNotSupportedException {
		return (Vector3bd) super.clone();
	}
}
