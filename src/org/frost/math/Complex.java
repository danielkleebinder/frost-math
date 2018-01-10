package org.frost.math;

import java.io.Serializable;

/**
 * A complex number is a number which is built out of an imaginary and a real
 * part.
 * <br/>
 * Complex number are often used for mathematical operations and computations
 * like the<br/>
 * fourier transformation. This implementation contains arithmetic and
 * mathematical<br/>
 * functions. A complex number has the following form:<br/>
 * <code>z = u + i * v</code><br/>
 * Where <code>z</code> is the complex number, <code>u</code> the real part and
 * <code>v</code> the imaginary part.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Complex implements Bufferable<Double>, Serializable, Cloneable {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Complex number only containing zeros.
	 */
	public static final Complex ZERO = new Complex(0.0, 0.0);
	/**
	 * Complex number with only the real part.
	 */
	public static final Complex REAL = new Complex(1.0, 0.0);
	/**
	 * Complex number with only the imaginary part.
	 */
	public static final Complex IMAGINARY = new Complex(0.0, 1.0);
	/**
	 * Complex number only containing ones.
	 */
	public static final Complex ONE = new Complex(1.0, 1.0);
	/**
	 * Complex number only containing negative ones.
	 */
	public static final Complex NEGATIVE_ONE = new Complex(-1.0, -1.0);

	/**
	 * Real part.
	 */
	public double u;
	/**
	 * Imaginary part.
	 */
	public double v;

	/**
	 * Creates a new complex number built out of a real and an imaginary part.
	 */
	public Complex() {
	}

	/**
	 * Creates a new complex number built out of a real and an imaginary part.
	 * <br/>
	 * The given parameters will built the complex number in the following
	 * way:<br/>
	 * <code>z = u + i * v</code><br/>
	 *
	 * @param u Real part.
	 */
	public Complex(double u) {
		this(u, 0.0);
	}

	/**
	 * Creates a new complex number built out of a real and an imaginary part.
	 * <br/>
	 * The given parameters will built the complex number in the following
	 * way:<br/>
	 * <code>z = u + i * v</code><br/>
	 *
	 * @param u Real part.
	 * @param v Imaginary part.
	 */
	public Complex(double u, double v) {
		this.u = u;
		this.v = v;
	}

	/**
	 * Creates a new complex number built out of a real and an imaginary part.
	 * <br/>
	 * The given parameters will built the complex number in the following
	 * way:<br/>
	 * <code>z = u + i * v</code><br/>
	 *
	 * @param copy From where the real and imaginary part should be copied.
	 */
	public Complex(Complex copy) {
		u = copy.u;
		v = copy.v;
	}

	/**
	 * Sets the real and imaginary part.
	 *
	 * @param u Real part.
	 * @param v Imaginary part.
	 */
	public void set(double u, double v) {
		this.u = u;
		this.v = v;
	}

	/**
	 * Sets the real and imaginary part from the given complex number.
	 *
	 * @param copy From where the real and imaginary part should be copied.
	 */
	public void set(Complex copy) {
		u = copy.u;
		v = copy.v;
	}

	/**
	 * Sets the real part of the complex number.
	 *
	 * @param u Real part.
	 */
	public void setRealPart(double u) {
		this.u = u;
	}

	/**
	 * Returns the real part of the complex number.
	 *
	 * @return Real part.
	 */
	public double getRealPart() {
		return u;
	}

	/**
	 * Sets the imaginary part of the complex number.
	 *
	 * @param v Imaginary part.
	 */
	public void setImaginaryPart(double v) {
		this.v = v;
	}

	/**
	 * Returns the imaginary part of the complex number.
	 *
	 * @return Imaginary part.
	 */
	public double getImaginaryPart() {
		return v;
	}

	/**
	 * Calculates the argument of this complex number.
	 * <br/>
	 * This will be the angle in radians with the x axis in polar coordinates.
	 *
	 * @return Argument.
	 */
	public double argument() {
		return FastMath.atan2(v, u);
	}

	/**
	 * Calculates the modulo value of this complex number.
	 * <br/>
	 * This will be the distance from the origin in polar coordinates.
	 *
	 * @return Modulo.
	 */
	public double modulo() {
		if (u != 0 || v != 0) {
			return FastMath.sqrt(u * u + v * v);
		}
		return 0;
	}

	/**
	 * Conjugates the values of this complex number and returns the result in a
	 * new instance.
	 * <br/>
	 * The conjugate of <code>u + i * v</code> will be <code>u - i * v</code>
	 *
	 * @return Conjugate.
	 */
	public Complex conjugate() {
		return new Complex(u, -v);
	}

	/**
	 * Conjugates the values of this complex number and returns the this object.
	 * <br/>
	 * The conjugate of <code>u + i * v</code> will be <code>u - i * v</code>
	 *
	 * @return This.
	 */
	public Complex conjugateLocal() {
		v = -v;
		return this;
	}

	/**
	 * Adds the given complex number to this one.
	 * <br/>
	 * The computation will look like the following:<br/>
	 * <code>(u1 + i * v1) + (u2 + i * v2) = (u1 + u2) + i * (v1 + v2)</code>
	 *
	 * @param complex Complex number to be added.
	 * @return New complex number with the result stored in it.
	 */
	public Complex add(Complex complex) {
		return new Complex(u, v).addLocal(complex);
	}

	/**
	 * Adds the given complex number to this one.
	 * <br/>
	 * The computation will look like the following:<br/>
	 * <code>(u1 + i * v1) + (u2 + i * v2) = (u1 + u2) + i * (v1 + v2)</code>
	 *
	 * @param complex Complex number to be added.
	 * @return This.
	 */
	public Complex addLocal(Complex complex) {
		u += complex.u;
		v += complex.v;
		return this;
	}

	/**
	 * Subtracts the given complex number to this one.
	 * <br/>
	 * The computation will look like the following:<br/>
	 * <code>(u1 + i * v1) - (u2 + i * v2) = (u1 - u2) + i * (v1 - v2)</code>
	 *
	 * @param complex Complex number to be subtracted.
	 * @return New complex number with the result stored in it.
	 */
	public Complex subtract(Complex complex) {
		return new Complex(u, v).subtractLocal(complex);
	}

	/**
	 * Subtracts the given complex number to this one.
	 * <br/>
	 * The computation will look like the following:<br/>
	 * <code>(u1 + i * v1) - (u2 + i * v2) = (u1 - u2) + i * (v1 - v2)</code>
	 *
	 * @param complex Complex number to be subtracted.
	 * @return This.
	 */
	public Complex subtractLocal(Complex complex) {
		u -= complex.u;
		v -= complex.v;
		return this;
	}

	/**
	 * Multiplicates the given complex number to this one.
	 *
	 * @param complex Complex number to be multiplicated.
	 * @return New complex number with the result stored in it.
	 */
	public Complex multiplicate(Complex complex) {
		return new Complex(u, v).multiplicateLocal(complex);
	}

	/**
	 * Multiplicates the given complex number to this one.
	 *
	 * @param complex Complex number to be multiplicated.
	 * @return This.
	 */
	public Complex multiplicateLocal(Complex complex) {
		u = u * complex.u - v * complex.v;
		v = u * complex.v + v * complex.u;
		return this;
	}

	/**
	 * Multiplicates the complex number by the given value.
	 *
	 * @param value Value.
	 * @return New complex number with the result stored in it.
	 */
	public Complex multiplicate(double value) {
		return new Complex(u, v).multiplicateLocal(value);
	}

	/**
	 * Multiplicates the complex number by the given value.
	 *
	 * @param value Value.
	 * @return This.
	 */
	public Complex multiplicateLocal(double value) {
		u *= value;
		v *= value;
		return this;
	}

	/**
	 * Divides the given complex number to this one.
	 * <br/>
	 * The computation will look like the following:<br/>
	 * <code>(u1 + i * v1) / (u2 + i * v2) = ((u1 * u2 + v1 * v2) + i * (v1 * u2 - v1 * v2)) / (u2 ^ 2 + v2 ^ 2)</code>
	 *
	 * @param complex Complex number to be divided.
	 * @return New complex number with the result stored in it.
	 */
	public Complex divide(Complex complex) {
		return new Complex(u, v).divideLocal(complex);
	}

	/**
	 * Divides the given complex number to this one.
	 * <br/>
	 * The computation will look like the following:<br/>
	 * <code>(u1 + i * v1) / (u2 + i * v2) = ((u1 * u2 + v1 * v2) + i * (v1 * u2 - v1 * v2)) / (u2 ^ 2 + v2 ^ 2)</code>
	 *
	 * @param complex Complex number to be divided.
	 * @return This.
	 */
	public Complex divideLocal(Complex complex) {
		double d = FastMath.pow(complex.modulo(), 2.0);
		u = (u * complex.u + v * complex.v) / d;
		v = (v * complex.u - u * complex.v) / d;
		return this;
	}

	/**
	 * Calculates the exponential complex number.
	 *
	 * @return New complex number with the result stored in it.
	 */
	public Complex exp() {
		return new Complex(u, v).expLocal();
	}

	/**
	 * Calculates the exponential complex number.
	 *
	 * @return This.
	 */
	public Complex expLocal() {
		u = FastMath.exp(u) * FastMath.cos(v);
		v = FastMath.exp(u) * FastMath.sin(v);
		return this;
	}

	/**
	 * Calculates the square root of the complex number.
	 *
	 * @return New complex number with the result stored in it.
	 */
	public Complex sqrt() {
		return new Complex(u, v).sqrtLocal();
	}

	/**
	 * Calculates the square root of the complex number.
	 *
	 * @return This.
	 */
	public Complex sqrtLocal() {
		double r = FastMath.sqrt(modulo());
		double t = argument() / 2.0;

		u = r * FastMath.cos(t);
		v = r * FastMath.sin(t);

		return this;
	}

	/**
	 * Calculates the logarithm of the complex number.
	 *
	 * @return New complex number with the result stored in it.
	 */
	public Complex log() {
		return new Complex(u, v).logLocal();
	}

	/**
	 * Calculates the logarithm of the complex number.
	 *
	 * @return This.
	 */
	public Complex logLocal() {
		u = FastMath.log(modulo());
		v = argument();
		return this;
	}

	/**
	 * Calculates the sine of the complex number.
	 *
	 * @return New complex number with the result stored in it.
	 */
	public Complex sin() {
		return new Complex(u, v).sinLocal();
	}

	/**
	 * Calculates the sine of the complex number.
	 *
	 * @return This.
	 */
	public Complex sinLocal() {
		u = FastMath.cosh(v) * FastMath.sin(u);
		v = FastMath.sinh(v) * FastMath.cos(u);
		return this;
	}

	/**
	 * Calculates the cosine of the complex number.
	 *
	 * @return New complex number with the result stored in it.
	 */
	public Complex cos() {
		return new Complex(u, v).cosLocal();
	}

	/**
	 * Calculates the cosine of the complex number.
	 *
	 * @return This.
	 */
	public Complex cosLocal() {
		u = FastMath.cosh(v) * FastMath.cos(u);
		v = -FastMath.sinh(v) * FastMath.sin(u);
		return this;
	}

	/**
	 * Calculates the tangent value of the complex number.
	 *
	 * @return New complex number with the result stored in it.
	 */
	public Complex tan() {
		return new Complex(u, v).tanLocal();
	}

	/**
	 * Calculates the tangent value of the complex number.
	 *
	 * @return This.
	 */
	public Complex tanLocal() {
		return sinLocal().divideLocal(cosLocal());
	}

	/**
	 * Negates the complex number.
	 *
	 * @return New complex number with the result stored in it.
	 */
	public Complex negate() {
		return new Complex(-u, -v);
	}

	/**
	 * Negates the complex number.
	 *
	 * @return This.
	 */
	public Complex negateLocal() {
		u = -u;
		v = -v;
		return this;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 23 * hash + (int) (Double.doubleToLongBits(this.u) ^ (Double.doubleToLongBits(this.u) >>> 32));
		hash = 23 * hash + (int) (Double.doubleToLongBits(this.v) ^ (Double.doubleToLongBits(this.v) >>> 32));
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
		final Complex other = (Complex) obj;
		if (Double.doubleToLongBits(this.u) != Double.doubleToLongBits(other.u)) {
			return false;
		}
		return Double.doubleToLongBits(this.v) == Double.doubleToLongBits(other.v);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(16);
		if (u != 0) {
			result.append(u);
		}
		if (v < 0) {
			if (u != 0) {
				result.append(" - ");
			} else {
				result.append("-");
			}
			result.append(-v);
		} else {
			if (u != 0 && v != 0) {
				result.append(" + ");
			}
			if (v != 0) {
				result.append(v);
			}
		}
		if (v != 0) {
			result.append("i");
		}
		return result.toString();
	}

	@Override
	public void fromArray(Double... array) {
		u = array[0];
		v = array[1];
	}

	@Override
	public Double[] toArray() {
		return new Double[]{u, v};
	}

	@Override
	public Complex clone() throws CloneNotSupportedException {
		return (Complex) super.clone();
	}
}
