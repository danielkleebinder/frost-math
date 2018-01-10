package org.frost.math;

import java.math.BigInteger;
import java.util.function.BiConsumer;

/**
 * A fast alternative to the <code>java.lang.Math</code> class.
 * <br/>
 * This class provides additional functionalities too.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 * @see java.lang.Math
 * @see java.lang.StrictMath
 */
public class FastMath {

	/**
	 * The {@code double} value that is pretty close to <i>e</i>, the base of
	 * the natural logarithms.
	 */
	public static final double E = 2.7182818284590452354;
	/**
	 * The {@code float} value that is pretty close to <i>e</i>, the base of the
	 * natural logarithms.
	 */
	public static final float E_HALF_PRECISION = (float) E;
	/**
	 * The {@code double} value that is pretty close to <i>pi</i>, the ratio of
	 * the circumference of a circle to its diameter.
	 */
	public static final double PI = 3.14159265358979323846;
	/**
	 * The {@code float} value that is pretty close to <i>pi</i>, the ratio of
	 * the circumference of a circle to its diameter.
	 */
	public static final float PI_HALF_PRECISION = (float) PI;
	/**
	 * The {@code double} value that is pretty close to <i>pi / 2</i>, the ratio
	 * of the circumference of a circle to its diameter.
	 */
	public static final double HALF_PI = 1.57079632679489661923;
	/**
	 * The {@code float} value that is pretty close to <i>pi / 2</i>, the ratio
	 * of the circumference of a circle to its diameter.
	 */
	public static final float HALF_PI_HALF_PRECISION = (float) HALF_PI;
	/**
	 * The {@code double} value for <code>log(2)</code>.
	 */
	public static final double LOG_2 = log(2.0);
	/**
	 * The {@code float} value for <code>log(2)</code>.
	 */
	public static final float LOG_2_HALF_PRECISION = (float) LOG_2;

	/**
	 * Returns the signum function of the argument; zero if the argument is
	 * zero, 1 if the argument is greater than zero, -1 if the argument is less
	 * than zero.
	 *
	 * @param f The floating-point value whose signum is to be returned.
	 * @return The signum function of the argument.
	 */
	public static int signum(int f) {
		if (f > 0) {
			return 1;
		}
		if (f < 0) {
			return -1;
		}
		return 0;
	}

	/**
	 * Returns the signum function of the argument; zero if the argument is
	 * zero, 1.0f if the argument is greater than zero, -1.0f if the argument is
	 * less than zero.
	 *
	 * @param f The floating-point value whose signum is to be returned.
	 * @return The signum function of the argument.
	 */
	public static float signum(float f) {
		if (f > 0.0f) {
			return 1.0f;
		}
		if (f < 0.0f) {
			return -1.0f;
		}
		return 0.0f;
	}

	/**
	 * Returns the signum function of the argument; zero if the argument is
	 * zero, 1.0 if the argument is greater than zero, -1.0 if the argument is
	 * less than zero.
	 *
	 * @param d The floating-point value whose signum is to be returned.
	 * @return The signum function of the argument.
	 */
	public static double signum(double d) {
		if (d > 0.0f) {
			return 1.0d;
		}
		if (d < 0.0f) {
			return -1.0d;
		}
		return 0.0d;
	}

	/**
	 * This method returns the absolute value of the given number.
	 *
	 * @param i Value.
	 * @return Absolute value (positive value).
	 */
	public static int abs(int i) {
		return (i < 0) ? -i : i;
	}

	/**
	 * This method returns the absolute value of the given number.
	 *
	 * @param f Value.
	 * @return Absolute value (positive value).
	 */
	public static float abs(float f) {
		return (f < 0) ? -f : f;
	}

	/**
	 * This method returns the absolute value of the given number.
	 *
	 * @param d Value.
	 * @return Absolute value (positive value).
	 */
	public static double abs(double d) {
		return (d < 0) ? -d : d;
	}

	/**
	 * Floors the given number. This means for example that 1.785 will become
	 * 1.0.
	 *
	 * @param f Value.
	 * @return Floored value.
	 */
	public static float floor(float f) {
		int i = (int) f;
		return (f < 0 && f != i) ? i - 1 : i;
	}

	/**
	 * Floors the given number. This means for example that 1.785 will become
	 * 1.0.
	 *
	 * @param d Value.
	 * @return Floored value.
	 */
	public static double floor(double d) {
		int i = (int) d;
		return (d < 0 && d != i) ? i - 1 : i;
	}

	/**
	 * Floors the given number to an integer. This means for example that 1.785
	 * will become 1.
	 *
	 * @param f Value.
	 * @return Floored int value.
	 */
	public static int floorToInt(float f) {
		return (int) f;
	}

	/**
	 * Floors the given number to an integer. This means for example that 1.785
	 * will become 1.
	 *
	 * @param d Value.
	 * @return Floored int value.
	 */
	public static int floorToInt(double d) {
		return (int) d;
	}

	/**
	 * Ceils the given number. This means for example that 1.216 will become
	 * 2.0.
	 *
	 * @param f Value.
	 * @return Ceiled value.
	 */
	public static float ceil(float f) {
		int i = ((int) f) + 1;
		return (f < 0 && f != i) ? i + 1 : i;
	}

	/**
	 * Ceils the given number. This means for example that 1.216 will become
	 * 2.0.
	 *
	 * @param d Value.
	 * @return Ceiled value.
	 */
	public static double ceil(double d) {
		int i = ((int) d) + 1;
		return (d < 0 && d != i) ? i + 1 : i;
	}

	/**
	 * Ceils the given number to an integer. This means for example that 1.216
	 * will become 2.
	 *
	 * @param f Value.
	 * @return Ceiled int value.
	 */
	public static int ceilToInt(float f) {
		return (int) ceil(f);
	}

	/**
	 * Ceils the given number to an integer. This means for example that 1.216
	 * will become 2.
	 *
	 * @param d Value.
	 * @return Ceiled int value.
	 */
	public static int ceilToInt(double d) {
		return (int) ceil(d);
	}

	/**
	 * Just rounds the given value. For example 1.253 will become 1.0 and 1.853
	 * will become 2.0.
	 *
	 * @param f Value.
	 * @return Rounded value.
	 */
	public static float round(float f) {
		return (f - floor(f) < 0.5) ? floor(f) : ceil(f);
	}

	/**
	 * Just rounds the given value. For example 1.253 will become 1.0 and 1.853
	 * will become 2.0.
	 *
	 * @param d Value.
	 * @return Rounded value.
	 */
	public static double round(double d) {
		return (d - floor(d) < 0.5) ? floor(d) : ceil(d);
	}

	/**
	 * Just rounds the given value. For example 1.253 will become 1 and 1.853
	 * will become 2. The result will be an integer.
	 *
	 * @param f Value.
	 * @return Rounded value as int.
	 */
	public static int roundToInt(float f) {
		return (int) round(f);
	}

	/**
	 * Just rounds the given value. For example 1.253 will become 1 and 1.853
	 * will become 2. The result will be an integer.
	 *
	 * @param d Value.
	 * @return Rounded value as int.
	 */
	public static int roundToInt(double d) {
		return (int) round(d);
	}

	/**
	 * Returns the lower value of the given two.
	 *
	 * @param a First value.
	 * @param b Second value.
	 * @return Lower value.
	 */
	public static int min(int a, int b) {
		return (a <= b) ? a : b;
	}

	/**
	 * Returns the lower value of the given two.
	 *
	 * @param a First value.
	 * @param b Second value.
	 * @return Lower value.
	 */
	public static float min(float a, float b) {
		return (a <= b) ? a : b;
	}

	/**
	 * Returns the lower value of the given two.
	 *
	 * @param a First value.
	 * @param b Second value.
	 * @return Lower value.
	 */
	public static double min(double a, double b) {
		return (a <= b) ? a : b;
	}

	/**
	 * Returns the lowest value of the given ones.
	 *
	 * @param values Values.
	 * @return Lowest one.
	 */
	public static int min(int... values) {
		int result = values[0];

		for (Integer i : values) {
			if (i < result) {
				result = i;
			}
		}

		return result;
	}

	/**
	 * Returns the lowest value of the given ones.
	 *
	 * @param values Values.
	 * @return Lowest one.
	 */
	public static float min(float... values) {
		float result = values[0];

		for (Float i : values) {
			if (i < result) {
				result = i;
			}
		}

		return result;
	}

	/**
	 * Returns the lowest value of the given ones.
	 *
	 * @param values Values.
	 * @return Lowest one.
	 */
	public static double min(double... values) {
		double result = values[0];

		for (Double i : values) {
			if (i < result) {
				result = i;
			}
		}

		return result;
	}

	/**
	 * Returns the higher value of the given two.
	 *
	 * @param a First value.
	 * @param b Second value.
	 * @return Higher value.
	 */
	public static int max(int a, int b) {
		return (a >= b) ? a : b;
	}

	/**
	 * Returns the higher value of the given two.
	 *
	 * @param a First value.
	 * @param b Second value.
	 * @return Higher value.
	 */
	public static float max(float a, float b) {
		return (a >= b) ? a : b;
	}

	/**
	 * Returns the higher value of the given two.
	 *
	 * @param a First value.
	 * @param b Second value.
	 * @return Higher value.
	 */
	public static double max(double a, double b) {
		return (a >= b) ? a : b;
	}

	/**
	 * Returns the highest value of the given ones.
	 *
	 * @param values Values.
	 * @return Lowest one.
	 */
	public static int max(int... values) {
		int result = values[0];

		for (Integer i : values) {
			if (i > result) {
				result = i;
			}
		}

		return result;
	}

	/**
	 * Returns the highest value of the given ones.
	 *
	 * @param values Values.
	 * @return Lowest one.
	 */
	public static float max(float... values) {
		float result = values[0];

		for (Float i : values) {
			if (i > result) {
				result = i;
			}
		}

		return result;
	}

	/**
	 * Returns the highest value of the given ones.
	 *
	 * @param values Values.
	 * @return Lowest one.
	 */
	public static double max(double... values) {
		double result = values[0];

		for (Double i : values) {
			if (i > result) {
				result = i;
			}
		}

		return result;
	}

	/**
	 * Clamps the given value within the default values. The default two values
	 * are 1 and 0. The value 100 will become for example 1 and the value -100
	 * will become 0.
	 *
	 * @param i Value.
	 * @return Clamped value.
	 */
	public static int clamp(int i) {
		if (i > 1.0) {
			return 1;
		}
		if (i < 0.0) {
			return 0;
		}
		return i;
	}

	/**
	 * Clamps the given value within the default values. The default two values
	 * are 1.0 and 0.0. The value 1.4 will become for example 1.0 and the value
	 * -1.4 will become 0.0.
	 *
	 * @param f Value.
	 * @return Clamped value.
	 */
	public static float clamp(float f) {
		if (f > 1.0) {
			return 1.0f;
		}
		if (f < 0.0) {
			return 0.0f;
		}
		return f;
	}

	/**
	 * Clamps the given value within the default values. The default two values
	 * are 1.0 and 0.0. The value 1.4 will become for example 1.0 and the value
	 * -1.4 will become 0.0.
	 *
	 * @param d Value.
	 * @return Clamped value.
	 */
	public static double clamp(double d) {
		if (d > 1.0) {
			return 1.0;
		}
		if (d < 0.0) {
			return 0.0;
		}
		return d;
	}

	/**
	 * Clamps the given value <code>int value</code> between the given
	 * <code>int min</code> and the given <code>int max</code> values.
	 *
	 * @param value Value.
	 * @param min Minimum value.
	 * @param max Maximum value.
	 * @return Clamped value.
	 */
	public static int clamp(int value, int min, int max) {
		if (value > max) {
			return max;
		}
		if (value < min) {
			return min;
		}
		return value;
	}

	/**
	 * Clamps the given value <code>float value</code> between the given
	 * <code>float min</code> and the given <code>float max</code> values.
	 *
	 * @param value Value.
	 * @param min Minimum value.
	 * @param max Maximum value.
	 * @return Clamped value.
	 */
	public static float clamp(float value, float min, float max) {
		if (value > max) {
			return max;
		}
		if (value < min) {
			return min;
		}
		return value;
	}

	/**
	 * Clamps the given value <code>double value</code> between the given
	 * <code>double min</code> and the given <code>double max</code> values.
	 *
	 * @param value Value.
	 * @param min Minimum value.
	 * @param max Maximum value.
	 * @return Clamped value.
	 */
	public static double clamp(double value, double min, double max) {
		if (value > max) {
			return max;
		}
		if (value < min) {
			return min;
		}
		return value;
	}

	/**
	 * Rotates the given value between the min and max value. A few simple
	 * examples:<br/> <ul> <li>rotate(1, -1, 1) = 1</li> <li>rotate(-1, -1, 1) =
	 * -1</li> <li>rotate(0, -1, 1) = 0</li> <li>rotate(2, -1, 1) = 0</li>
	 * <li>rotate(-2, -1, 1) = 0</li> <li>rotate(3, -1, 1) = 1</li>
	 * <li>rotate(-3, -1, 1) = -1</li> </ul>
	 *
	 * @param value Current value.
	 * @param min Min value.
	 * @param max Max value.
	 * @return Rotated value.
	 */
	public static int rotate(int value, int min, int max) {
		int remainder = value < min ? (min - value) : (value > max ? (value - max) : value);
		int result = value;

		if (value < min) {
			result = max - (remainder % (max - min));
		}
		if (value > max) {
			result = min + (remainder % (max - min));
		}
		return result;
	}

	/**
	 * Rotates the given value between the min and max value. A few simple
	 * examples:<br/> <ul> <li>rotate(1, -1, 1) = 1</li> <li>rotate(-1, -1, 1) =
	 * -1</li> <li>rotate(0, -1, 1) = 0</li> <li>rotate(2, -1, 1) = 0</li>
	 * <li>rotate(-2, -1, 1) = 0</li> <li>rotate(3, -1, 1) = 1</li>
	 * <li>rotate(-3, -1, 1) = -1</li> </ul>
	 *
	 * @param value Current value.
	 * @param min Min value.
	 * @param max Max value.
	 * @return Rotated value.
	 */
	public static float rotate(float value, float min, float max) {
		float remainder = value < min ? (min - value) : (value > max ? (value - max) : value);
		float result = value;

		if (value < min) {
			result = max - (remainder % (max - min));
		}
		if (value > max) {
			result = min + (remainder % (max - min));
		}
		return result;
	}

	/**
	 * Rotates the given value between the min and max value. A few simple
	 * examples:<br/> <ul> <li>rotate(1, -1, 1) = 1</li> <li>rotate(-1, -1, 1) =
	 * -1</li> <li>rotate(0, -1, 1) = 0</li> <li>rotate(2, -1, 1) = 0</li>
	 * <li>rotate(-2, -1, 1) = 0</li> <li>rotate(3, -1, 1) = 1</li>
	 * <li>rotate(-3, -1, 1) = -1</li> </ul>
	 *
	 * @param value Current value.
	 * @param min Min value.
	 * @param max Max value.
	 * @return Rotated value.
	 */
	public static double rotate(double value, double min, double max) {
		double remainder = value < min ? (min - value) : (value > max ? (value - max) : value);
		double result = value;

		if (value < min) {
			result = max - (remainder % (max - min));
		}
		if (value > max) {
			result = min + (remainder % (max - min));
		}
		return result;
	}

	/**
	 * Rotates the given value between the min and max value. A few simple
	 * examples:<br/> <ul> <li>rotate(1, -1, 1) = 1</li> <li>rotate(-1, -1, 1) =
	 * -1</li> <li>rotate(0, -1, 1) = 0</li> <li>rotate(2, -1, 1) = -1</li>
	 * <li>rotate(-2, -1, 1) = 1</li> <li>rotate(3, -1, 1) = 1</li>
	 * <li>rotate(-3, -1, 1) = -1</li> </ul>
	 *
	 * @param value Current value.
	 * @param min Min value.
	 * @param max Max value.
	 * @return Rotated value.
	 */
	public static int rotateIncludeMinMax(int value, int min, int max) {
		int remainder = value < min ? (min - value) : (value > max ? (value - max) : value);
		int result = value;

		if (value < min) {
			result = max - (remainder % (max - min)) + 1;
		}
		if (value > max) {
			result = min + (remainder % (max - min)) - 1;
		}
		return result;
	}

	/**
	 * Rotates the given value between the min and max value. A few simple
	 * examples:<br/> <ul> <li>rotate(1, -1, 1) = 1</li> <li>rotate(-1, -1, 1) =
	 * -1</li> <li>rotate(0, -1, 1) = 0</li> <li>rotate(2, -1, 1) = -1</li>
	 * <li>rotate(-2, -1, 1) = 1</li> <li>rotate(3, -1, 1) = 1</li>
	 * <li>rotate(-3, -1, 1) = -1</li> </ul>
	 *
	 * @param value Current value.
	 * @param min Min value.
	 * @param max Max value.
	 * @return Rotated value.
	 */
	public static float rotateIncludeMinMax(float value, float min, float max) {
		float remainder = value < min ? (min - value) : (value > max ? (value - max) : value);
		float result = value;

		if (value < min) {
			result = max - (remainder % (max - min)) + 1.0f;
		}
		if (value > max) {
			result = min + (remainder % (max - min)) - 1.0f;
		}
		return result;
	}

	/**
	 * Rotates the given value between the min and max value. A few simple
	 * examples:<br/> <ul> <li>rotate(1, -1, 1) = 1</li> <li>rotate(-1, -1, 1) =
	 * -1</li> <li>rotate(0, -1, 1) = 0</li> <li>rotate(2, -1, 1) = -1</li>
	 * <li>rotate(-2, -1, 1) = 1</li> <li>rotate(3, -1, 1) = 1</li>
	 * <li>rotate(-3, -1, 1) = -1</li> </ul>
	 *
	 * @param value Current value.
	 * @param min Min value.
	 * @param max Max value.
	 * @return Rotated value.
	 */
	public static double rotateIncludeMinMax(double value, double min, double max) {
		double remainder = value < min ? (min - value) : (value > max ? (value - max) : value);
		double result = value;

		if (value < min) {
			result = max - (remainder % (max - min)) + 1.0;
		}
		if (value > max) {
			result = min + (remainder % (max - min)) - 1.0;
		}
		return result;
	}

	/**
	 * Returns the trigonometric sine of an angle. Special cases: <ul><li>If the
	 * argument is NaN or an infinity, then the result is NaN. <li>If the
	 * argument is zero, then the result is a zero with the same sign as the
	 * argument.</ul>
	 *
	 * @param f An angle, in radians.
	 * @return The sine of the argument.
	 */
	public static float sin(float f) {
		return (float) sin((double) f);
	}

	/**
	 * Returns the trigonometric sine of an angle. Special cases: <ul><li>If the
	 * argument is NaN or an infinity, then the result is NaN. <li>If the
	 * argument is zero, then the result is a zero with the same sign as the
	 * argument.</ul>
	 *
	 * @param d An angle, in radians.
	 * @return The sine of the argument.
	 */
	public static double sin(double d) {
		return Math.sin(d);
	}

	/**
	 * Returns the hyperbolic sine of a {@code double} value. The hyperbolic
	 * sine of <i>x</i> is defined to be
	 * (<i>e<sup>x</sup>&nbsp;-&nbsp;e<sup>-x</sup></i>)/2 where <i>e</i> is
	 * {@linkplain Math#E Euler's number}.
	 *
	 * <p>
	 * Special cases: <ul>
	 *
	 * <li>If the argument is NaN, then the result is NaN.
	 *
	 * <li>If the argument is infinite, then the result is an infinity with the
	 * same sign as the argument.
	 *
	 * <li>If the argument is zero, then the result is a zero with the same sign
	 * as the argument.
	 *
	 * </ul>
	 *
	 * @param f The number whose hyperbolic sine is to be returned.
	 * @return The hyperbolic sine of {@code x}.
	 */
	public static float sinh(float f) {
		return (float) sinh((double) f);
	}

	/**
	 * Returns the hyperbolic sine of a {@code double} value. The hyperbolic
	 * sine of <i>x</i> is defined to be
	 * (<i>e<sup>x</sup>&nbsp;-&nbsp;e<sup>-x</sup></i>)/2 where <i>e</i> is
	 * {@linkplain Math#E Euler's number}.
	 *
	 * <p>
	 * Special cases: <ul>
	 *
	 * <li>If the argument is NaN, then the result is NaN.
	 *
	 * <li>If the argument is infinite, then the result is an infinity with the
	 * same sign as the argument.
	 *
	 * <li>If the argument is zero, then the result is a zero with the same sign
	 * as the argument.
	 *
	 * </ul>
	 *
	 * @param d The number whose hyperbolic sine is to be returned.
	 * @return The hyperbolic sine of {@code x}.
	 */
	public static double sinh(double d) {
		return StrictMath.sinh(d);
	}

	/**
	 * Returns the arc sine of a value; the returned angle is in the range
	 * -<i>pi</i>/2 through <i>pi</i>/2. Special cases: <ul><li>If the argument
	 * is NaN or its absolute value is greater than 1, then the result is NaN.
	 * <li>If the argument is zero, then the result is a zero with the same sign
	 * as the argument.</ul>
	 *
	 * @param f The value whose arc sine is to be returned.
	 * @return The arc sine of the argument.
	 */
	public static float asin(float f) {
		return (float) asin((double) f);
	}

	/**
	 * Returns the arc sine of a value; the returned angle is in the range
	 * -<i>pi</i>/2 through <i>pi</i>/2. Special cases: <ul><li>If the argument
	 * is NaN or its absolute value is greater than 1, then the result is NaN.
	 * <li>If the argument is zero, then the result is a zero with the same sign
	 * as the argument.</ul>
	 *
	 * @param d The value whose arc sine is to be returned.
	 * @return The arc sine of the argument.
	 */
	public static double asin(double d) {
		return StrictMath.asin(d);
	}

	/**
	 * Returns the trigonometric cosine of an angle. Special cases: <ul><li>If
	 * the argument is NaN or an infinity, then the result is NaN.</ul>
	 *
	 * @param f An angle, in radians.
	 * @return The cosine of the argument.
	 */
	public static float cos(float f) {
		return (float) cos((double) f);
	}

	/**
	 * Returns the trigonometric cosine of an angle. Special cases: <ul><li>If
	 * the argument is NaN or an infinity, then the result is NaN.</ul>
	 *
	 * @param d An angle, in radians.
	 * @return The cosine of the argument.
	 */
	public static double cos(double d) {
		return Math.cos(d);
	}

	/**
	 * Returns the hyperbolic cosine of a {@code double} value. The hyperbolic
	 * cosine of <i>x</i> is defined to be
	 * (<i>e<sup>x</sup>&nbsp;+&nbsp;e<sup>-x</sup></i>)/2 where <i>e</i> is
	 * {@linkplain Math#E Euler's number}.
	 *
	 * <p>
	 * Special cases: <ul>
	 *
	 * <li>If the argument is NaN, then the result is NaN.
	 *
	 * <li>If the argument is infinite, then the result is positive infinity.
	 *
	 * <li>If the argument is zero, then the result is {@code 1.0}.
	 *
	 * </ul>
	 *
	 * @param f The number whose hyperbolic cosine is to be returned.
	 * @return The hyperbolic cosine of {@code x}.
	 */
	public static float cosh(float f) {
		return (float) cosh((double) f);
	}

	/**
	 * Returns the hyperbolic cosine of a {@code double} value. The hyperbolic
	 * cosine of <i>x</i> is defined to be
	 * (<i>e<sup>x</sup>&nbsp;+&nbsp;e<sup>-x</sup></i>)/2 where <i>e</i> is
	 * {@linkplain Math#E Euler's number}.
	 *
	 * <p>
	 * Special cases: <ul>
	 *
	 * <li>If the argument is NaN, then the result is NaN.
	 *
	 * <li>If the argument is infinite, then the result is positive infinity.
	 *
	 * <li>If the argument is zero, then the result is {@code 1.0}.
	 *
	 * </ul>
	 *
	 * @param d The number whose hyperbolic cosine is to be returned.
	 * @return The hyperbolic cosine of {@code x}.
	 */
	public static double cosh(double d) {
		return StrictMath.cosh(d);
	}

	/**
	 * Returns the arc cosine of a value; the returned angle is in the range 0.0
	 * through <i>pi</i>. Special case: <ul><li>If the argument is NaN or its
	 * absolute value is greater than 1, then the result is NaN.</ul>
	 *
	 * @param f The value whose arc cosine is to be returned.
	 * @return The arc cosine of the argument.
	 */
	public static float acos(float f) {
		return (float) acos((double) f);
	}

	/**
	 * Returns the arc cosine of a value; the returned angle is in the range 0.0
	 * through <i>pi</i>. Special case: <ul><li>If the argument is NaN or its
	 * absolute value is greater than 1, then the result is NaN.</ul>
	 *
	 * @param d The value whose arc cosine is to be returned.
	 * @return The arc cosine of the argument.
	 */
	public static double acos(double d) {
		return StrictMath.acos(d);
	}

	/**
	 * Returns the trigonometric tangent of an angle. Special cases: <ul><li>If
	 * the argument is NaN or an infinity, then the result is NaN. <li>If the
	 * argument is zero, then the result is a zero with the same sign as the
	 * argument.</ul>
	 *
	 * @param f An angle, in radians.
	 * @return The tangent of the argument.
	 */
	public static float tan(float f) {
		return (float) tan((double) f);
	}

	/**
	 * Returns the trigonometric tangent of an angle. Special cases: <ul><li>If
	 * the argument is NaN or an infinity, then the result is NaN. <li>If the
	 * argument is zero, then the result is a zero with the same sign as the
	 * argument.</ul>
	 *
	 * @param d an angle, in radians.
	 * @return the tangent of the argument.
	 */
	public static double tan(double d) {
		return Math.tan(d);
	}

	/**
	 * Returns the hyperbolic tangent of a {@code float} value. The hyperbolic
	 * tangent of <i>x</i> is defined to be
	 * (<i>e<sup>x</sup>&nbsp;-&nbsp;e<sup>-x</sup></i>)/(<i>e<sup>x</sup>&nbsp;+&nbsp;e<sup>-x</sup></i>),
	 * in other words, {@linkplain Math#sinh
	 * sinh(<i>x</i>)}/{@linkplain Math#cosh cosh(<i>x</i>)}. Note that the
	 * absolute value of the exact tanh is always less than 1.
	 *
	 * <p>
	 * Special cases: <ul>
	 *
	 * <li>If the argument is NaN, then the result is NaN.
	 *
	 * <li>If the argument is zero, then the result is a zero with the same sign
	 * as the argument.
	 *
	 * <li>If the argument is positive infinity, then the result is
	 * {@code +1.0}.
	 *
	 * <li>If the argument is negative infinity, then the result is
	 * {@code -1.0}.
	 *
	 * </ul>
	 *
	 * @param f The number whose hyperbolic tangent is to be returned.
	 * @return The hyperbolic tangent of {@code x}.
	 */
	public static float tanh(float f) {
		return (float) tanh((double) f);
	}

	/**
	 * Returns the hyperbolic tangent of a {@code double} value. The hyperbolic
	 * tangent of <i>x</i> is defined to be
	 * (<i>e<sup>x</sup>&nbsp;-&nbsp;e<sup>-x</sup></i>)/(<i>e<sup>x</sup>&nbsp;+&nbsp;e<sup>-x</sup></i>),
	 * in other words, {@linkplain Math#sinh
	 * sinh(<i>x</i>)}/{@linkplain Math#cosh cosh(<i>x</i>)}. Note that the
	 * absolute value of the exact tanh is always less than 1.
	 *
	 * <p>
	 * Special cases: <ul>
	 *
	 * <li>If the argument is NaN, then the result is NaN.
	 *
	 * <li>If the argument is zero, then the result is a zero with the same sign
	 * as the argument.
	 *
	 * <li>If the argument is positive infinity, then the result is
	 * {@code +1.0}.
	 *
	 * <li>If the argument is negative infinity, then the result is
	 * {@code -1.0}.
	 *
	 * </ul>
	 *
	 * @param d The number whose hyperbolic tangent is to be returned.
	 * @return The hyperbolic tangent of {@code x}.
	 */
	public static double tanh(double d) {
		return StrictMath.tanh(d);
	}

	/**
	 * Returns the arc tangent of a value; the returned angle is in the range
	 * -<i>pi</i>/2 through <i>pi</i>/2. Special cases: <ul><li>If the argument
	 * is NaN, then the result is NaN. <li>If the argument is zero, then the
	 * result is a zero with the same sign as the argument.</ul>
	 *
	 * @param f The value whose arc tangent is to be returned.
	 * @return The arc tangent of the argument.
	 */
	public static float atan(float f) {
		return (float) atan((double) f);
	}

	/**
	 * Returns the arc tangent of a value; the returned angle is in the range
	 * -<i>pi</i>/2 through <i>pi</i>/2. Special cases: <ul><li>If the argument
	 * is NaN, then the result is NaN. <li>If the argument is zero, then the
	 * result is a zero with the same sign as the argument.</ul>
	 *
	 * @param d The value whose arc tangent is to be returned.
	 * @return The arc tangent of the argument.
	 */
	public static double atan(double d) {
		return StrictMath.atan(d);
	}

	/**
	 * Returns the angle <i>theta</i> from the conversion of rectangular
	 * coordinates ({@code x},&nbsp;{@code y}) to polar coordinates
	 * (r,&nbsp;<i>theta</i>). This method computes the phase <i>theta</i> by
	 * computing an arc tangent of {@code y/x} in the range of -<i>pi</i> to
	 * <i>pi</i>. Special cases: <ul><li>If either argument is NaN, then the
	 * result is NaN. <li>If the first argument is positive zero and the second
	 * argument is positive, or the first argument is positive and finite and
	 * the second argument is positive infinity, then the result is positive
	 * zero. <li>If the first argument is negative zero and the second argument
	 * is positive, or the first argument is negative and finite and the second
	 * argument is positive infinity, then the result is negative zero. <li>If
	 * the first argument is positive zero and the second argument is negative,
	 * or the first argument is positive and finite and the second argument is
	 * negative infinity, then the result is the {@code double} value closest to
	 * <i>pi</i>. <li>If the first argument is negative zero and the second
	 * argument is negative, or the first argument is negative and finite and
	 * the second argument is negative infinity, then the result is the
	 * {@code double} value closest to -<i>pi</i>. <li>If the first argument is
	 * positive and the second argument is positive zero or negative zero, or
	 * the first argument is positive infinity and the second argument is
	 * finite, then the result is the {@code double} value closest to
	 * <i>pi</i>/2. <li>If the first argument is negative and the second
	 * argument is positive zero or negative zero, or the first argument is
	 * negative infinity and the second argument is finite, then the result is
	 * the {@code double} value closest to -<i>pi</i>/2. <li>If both arguments
	 * are positive infinity, then the result is the {@code double} value
	 * closest to <i>pi</i>/4. <li>If the first argument is positive infinity
	 * and the second argument is negative infinity, then the result is the
	 * {@code double} value closest to 3*<i>pi</i>/4. <li>If the first argument
	 * is negative infinity and the second argument is positive infinity, then
	 * the result is the {@code double} value closest to -<i>pi</i>/4. <li>If
	 * both arguments are negative infinity, then the result is the
	 * {@code double} value closest to -3*<i>pi</i>/4.</ul>
	 *
	 * <p>
	 * The computed result must be within 2 ulps of the exact result. Results
	 * must be semi-monotonic.
	 *
	 * @param y The ordinate coordinate.
	 * @param x The abscissa coordinate.
	 * @return The <i>theta</i> component of the point
	 * (<i>r</i>,&nbsp;<i>theta</i>) in polar coordinates that corresponds to
	 * the point (<i>x</i>,&nbsp;<i>y</i>) in Cartesian coordinates.
	 */
	public static float atan2(float x, float y) {
		return (float) atan2((double) x, y);
	}

	/**
	 * Returns the angle <i>theta</i> from the conversion of rectangular
	 * coordinates ({@code x},&nbsp;{@code y}) to polar coordinates
	 * (r,&nbsp;<i>theta</i>). This method computes the phase <i>theta</i> by
	 * computing an arc tangent of {@code y/x} in the range of -<i>pi</i> to
	 * <i>pi</i>. Special cases: <ul><li>If either argument is NaN, then the
	 * result is NaN. <li>If the first argument is positive zero and the second
	 * argument is positive, or the first argument is positive and finite and
	 * the second argument is positive infinity, then the result is positive
	 * zero. <li>If the first argument is negative zero and the second argument
	 * is positive, or the first argument is negative and finite and the second
	 * argument is positive infinity, then the result is negative zero. <li>If
	 * the first argument is positive zero and the second argument is negative,
	 * or the first argument is positive and finite and the second argument is
	 * negative infinity, then the result is the {@code double} value closest to
	 * <i>pi</i>. <li>If the first argument is negative zero and the second
	 * argument is negative, or the first argument is negative and finite and
	 * the second argument is negative infinity, then the result is the
	 * {@code double} value closest to -<i>pi</i>. <li>If the first argument is
	 * positive and the second argument is positive zero or negative zero, or
	 * the first argument is positive infinity and the second argument is
	 * finite, then the result is the {@code double} value closest to
	 * <i>pi</i>/2. <li>If the first argument is negative and the second
	 * argument is positive zero or negative zero, or the first argument is
	 * negative infinity and the second argument is finite, then the result is
	 * the {@code double} value closest to -<i>pi</i>/2. <li>If both arguments
	 * are positive infinity, then the result is the {@code double} value
	 * closest to <i>pi</i>/4. <li>If the first argument is positive infinity
	 * and the second argument is negative infinity, then the result is the
	 * {@code double} value closest to 3*<i>pi</i>/4. <li>If the first argument
	 * is negative infinity and the second argument is positive infinity, then
	 * the result is the {@code double} value closest to -<i>pi</i>/4. <li>If
	 * both arguments are negative infinity, then the result is the
	 * {@code double} value closest to -3*<i>pi</i>/4.</ul>
	 *
	 * <p>
	 * The computed result must be within 2 ulps of the exact result. Results
	 * must be semi-monotonic.
	 *
	 * @param y The ordinate coordinate.
	 * @param x The abscissa coordinate.
	 * @return The <i>theta</i> component of the point
	 * (<i>r</i>,&nbsp;<i>theta</i>) in polar coordinates that corresponds to
	 * the point (<i>x</i>,&nbsp;<i>y</i>) in Cartesian coordinates.
	 */
	public static double atan2(double x, double y) {
		return StrictMath.atan2(x, y);
	}

	/**
	 * Returns the natural logarithm (base <i>e</i>) of a {@code float} value.
	 * Special cases: <ul><li>If the argument is NaN or less than zero, then the
	 * result is NaN. <li>If the argument is positive infinity, then the result
	 * is positive infinity. <li>If the argument is positive zero or negative
	 * zero, then the result is negative infinity.</ul>
	 *
	 * @param f A value.
	 * @return The value ln&nbsp;{@code f}, the natural logarithm of {@code f}.
	 */
	public static float log(float f) {
		return (float) log((double) f);
	}

	/**
	 * Returns the natural logarithm (base <i>e</i>) of a {@code double} value.
	 * Special cases: <ul><li>If the argument is NaN or less than zero, then the
	 * result is NaN. <li>If the argument is positive infinity, then the result
	 * is positive infinity. <li>If the argument is positive zero or negative
	 * zero, then the result is negative infinity.</ul>
	 *
	 * @param d a value
	 * @return the value ln&nbsp;{@code a}, the natural logarithm of {@code a}.
	 */
	public static double log(double d) {
		return Math.log(d);
	}

	/**
	 * Returns the logarithm (base <i>2</i>) of a {@code float} value. Special
	 * cases: <ul><li>If the argument is NaN or less than zero, then the result
	 * is NaN. <li>If the argument is positive infinity, then the result is
	 * positive infinity. <li>If the argument is positive zero or negative zero,
	 * then the result is negative infinity.</ul>
	 *
	 * @param f A value.
	 * @return The value ln&nbsp;{@code f}, the logarithm of {@code a}.
	 */
	public static float log2(float f) {
		return log(f) / LOG_2_HALF_PRECISION;
	}

	/**
	 * Returns the logarithm (base <i>2</i>) of a {@code double} value. Special
	 * cases: <ul><li>If the argument is NaN or less than zero, then the result
	 * is NaN. <li>If the argument is positive infinity, then the result is
	 * positive infinity. <li>If the argument is positive zero or negative zero,
	 * then the result is negative infinity.</ul>
	 *
	 * @param d A value.
	 * @return The value ln&nbsp;{@code d}, the logarithm of {@code d}.
	 */
	public static double log2(double d) {
		return log(d) / LOG_2;
	}

	/**
	 * Returns the base 10 logarithm of a {@code float} value. Special cases:
	 *
	 * <ul><li>If the argument is NaN or less than zero, then the result is NaN.
	 * <li>If the argument is positive infinity, then the result is positive
	 * infinity.
	 * <li>If the argument is positive zero or negative zero, then the result is
	 * negative infinity.
	 * <li> If the argument is equal to 10<sup><i>n</i></sup> for integer
	 * <i>n</i>, then the result is <i>n</i>.
	 * </ul>
	 *
	 * <p>
	 * The computed result must be within 1 ulp of the exact result. Results
	 * must be semi-monotonic.
	 *
	 * @param f A value.
	 * @return The base 10 logarithm of {@code f}.
	 */
	public static float log10(float f) {
		return (float) log10((double) f);
	}

	/**
	 * Returns the base 10 logarithm of a {@code double} value. Special cases:
	 *
	 * <ul><li>If the argument is NaN or less than zero, then the result is NaN.
	 * <li>If the argument is positive infinity, then the result is positive
	 * infinity.
	 * <li>If the argument is positive zero or negative zero, then the result is
	 * negative infinity.
	 * <li> If the argument is equal to 10<sup><i>n</i></sup> for integer
	 * <i>n</i>, then the result is <i>n</i>.
	 * </ul>
	 *
	 * <p>
	 * The computed result must be within 1 ulp of the exact result. Results
	 * must be semi-monotonic.
	 *
	 * @param d A value.
	 * @return The base 10 logarithm of {@code d}.
	 */
	public static double log10(double d) {
		return StrictMath.log10(d);
	}

	/**
	 * Converts an angle measured in radians to an approximately equivalent
	 * angle measured in degrees. The conversion from radians to degrees is
	 * generally inexact; users should <i>not</i> expect
	 * {@code cos(toRadians(90.0))} to exactly equal {@code 0.0}.
	 *
	 * @param d An angle, in radians.
	 * @return The measurement of the angle {@code angrad} in degrees.
	 */
	public static strictfp double toDegrees(double d) {
		return d * 180.0 / PI;
	}

	/**
	 * Converts an angle measured in radians to an approximately equivalent
	 * angle measured in degrees. The conversion from radians to degrees is
	 * generally inexact; users should <i>not</i> expect
	 * {@code cos(toRadians(90.0))} to exactly equal {@code 0.0}.
	 *
	 * @param f An angle, in radians.
	 * @return The measurement of the angle {@code angrad} in degrees.
	 */
	public static strictfp float toDegrees(float f) {
		return f * 180.0f / PI_HALF_PRECISION;
	}

	/**
	 * Converts an angle measured in degrees to an approximately equivalent
	 * angle measured in radians. The conversion from degrees to radians is
	 * generally inexact.
	 *
	 * @param d An angle, in degrees.
	 * @return The measurement of the angle {@code angdeg} in radians.
	 */
	public static strictfp double toRadians(double d) {
		return d / 180.0 * PI;
	}

	/**
	 * Converts an angle measured in degrees to an approximately equivalent
	 * angle measured in radians. The conversion from degrees to radians is
	 * generally inexact.
	 *
	 * @param f An angle, in degrees.
	 * @return The measurement of the angle {@code angdeg} in radians.
	 */
	public static strictfp float toRadians(float f) {
		return f / 180.0f * PI_HALF_PRECISION;
	}

	/**
	 * Returns Euler's number <i>e</i> raised to the power of a {@code double}
	 * value. Special cases:
	 * <ul><li>If the argument is NaN, the result is NaN.
	 * <li>If the argument is positive infinity, then the result is positive
	 * infinity.
	 * <li>If the argument is negative infinity, then the result is positive
	 * zero.</ul>
	 *
	 * @param d The exponent to raise <i>e</i> to.
	 * @return The value <i>e</i><sup>{@code d}</sup>, where <i>e</i> is the
	 * base of the natural logarithms.
	 */
	public static double exp(double d) {
		return StrictMath.exp(d);
	}

	/**
	 * Returns Euler's number <i>e</i> raised to the power of a {@code float}
	 * value. Special cases:
	 * <ul><li>If the argument is NaN, the result is NaN.
	 * <li>If the argument is positive infinity, then the result is positive
	 * infinity.
	 * <li>If the argument is negative infinity, then the result is positive
	 * zero.</ul>
	 *
	 * @param f the exponent to raise <i>e</i> to.
	 * @return the value <i>e</i><sup>{@code f}</sup>, where <i>e</i> is the
	 * base of the natural logarithms.
	 */
	public static float exp(float f) {
		return (float) exp((double) f);
	}

	/**
	 * Returns the correctly rounded positive square root of a {@code double}
	 * value. Special cases: <ul><li>If the argument is NaN or less than zero,
	 * then the result is NaN. <li>If the argument is positive infinity, then
	 * the result is positive infinity. <li>If the argument is positive zero or
	 * negative zero, then the result is the same as the argument.</ul>
	 * Otherwise, the result is the {@code double} value closest to the true
	 * mathematical square root of the argument value.
	 *
	 * @param d a value.
	 * @return the positive square root of {@code a}.
	 */
	public static double sqrt(double d) {
		return StrictMath.sqrt(d);
	}

	/**
	 * Returns the correctly rounded positive square root of a {@code float}
	 * value. Special cases: <ul><li>If the argument is NaN or less than zero,
	 * then the result is NaN. <li>If the argument is positive infinity, then
	 * the result is positive infinity. <li>If the argument is positive zero or
	 * negative zero, then the result is the same as the argument.</ul>
	 * Otherwise, the result is the {@code float} value closest to the true
	 * mathematical square root of the argument value.
	 *
	 * @param f a value.
	 * @return the positive square root of {@code a}.
	 */
	public static float sqrt(float f) {
		return (float) sqrt((double) f);
	}

	/**
	 * Default squareroot function, but this sqrt function takes additional the
	 * sqrt exponential.
	 *
	 * @see org.ice.math.FastMath#sqrt(double)
	 * @param d Value.
	 * @param h Exponential.
	 * @return Result.
	 */
	public static double sqrt(double d, double h) {
		return pow(d, 1.0 / h);
	}

	/**
	 * Default squareroot function, but this sqrt function takes additional the
	 * sqrt exponential.
	 *
	 * @see org.ice.math.FastMath#sqrt(double)
	 * @param d Value.
	 * @param h Exponential.
	 * @return Result.
	 */
	public static float sqrt(float d, float h) {
		return (float) sqrt((double) d, h);
	}

	/**
	 * Returns the value of the first argument raised to the power of the second
	 * argument. Special cases:
	 *
	 * <ul><li>If the second argument is positive or negative zero, then the
	 * result is 1.0. <li>If the second argument is 1.0, then the result is the
	 * same as the first argument. <li>If the second argument is NaN, then the
	 * result is NaN. <li>If the first argument is NaN and the second argument
	 * is nonzero, then the result is NaN.
	 *
	 * <li>If <ul> <li>the absolute value of the first argument is greater than
	 * 1 and the second argument is positive infinity, or <li>the absolute value
	 * of the first argument is less than 1 and the second argument is negative
	 * infinity, </ul> then the result is positive infinity.
	 *
	 * <li>If <ul> <li>the absolute value of the first argument is greater than
	 * 1 and the second argument is negative infinity, or <li>the absolute value
	 * of the first argument is less than 1 and the second argument is positive
	 * infinity, </ul> then the result is positive zero.
	 *
	 * <li>If the absolute value of the first argument equals 1 and the second
	 * argument is infinite, then the result is NaN.
	 *
	 * <li>If <ul> <li>the first argument is positive zero and the second
	 * argument is greater than zero, or <li>the first argument is positive
	 * infinity and the second argument is less than zero, </ul> then the result
	 * is positive zero.
	 *
	 * <li>If <ul> <li>the first argument is positive zero and the second
	 * argument is less than zero, or <li>the first argument is positive
	 * infinity and the second argument is greater than zero, </ul> then the
	 * result is positive infinity.
	 *
	 * <li>If <ul> <li>the first argument is negative zero and the second
	 * argument is greater than zero but not a finite odd integer, or <li>the
	 * first argument is negative infinity and the second argument is less than
	 * zero but not a finite odd integer, </ul> then the result is positive
	 * zero.
	 *
	 * <li>If <ul> <li>the first argument is negative zero and the second
	 * argument is a positive finite odd integer, or <li>the first argument is
	 * negative infinity and the second argument is a negative finite odd
	 * integer, </ul> then the result is negative zero.
	 *
	 * <li>If <ul> <li>the first argument is negative zero and the second
	 * argument is less than zero but not a finite odd integer, or <li>the first
	 * argument is negative infinity and the second argument is greater than
	 * zero but not a finite odd integer, </ul> then the result is positive
	 * infinity.
	 *
	 * <li>If <ul> <li>the first argument is negative zero and the second
	 * argument is a negative finite odd integer, or <li>the first argument is
	 * negative infinity and the second argument is a positive finite odd
	 * integer, </ul> then the result is negative infinity.
	 *
	 * <li>If the first argument is finite and less than zero <ul> <li> if the
	 * second argument is a finite even integer, the result is equal to the
	 * result of raising the absolute value of the first argument to the power
	 * of the second argument
	 *
	 * <li>if the second argument is a finite odd integer, the result is equal
	 * to the negative of the result of raising the absolute value of the first
	 * argument to the power of the second argument
	 *
	 * <li>if the second argument is finite and not an integer, then the result
	 * is NaN. </ul>
	 *
	 * <li>If both arguments are integers, then the result is exactly equal to
	 * the mathematical result of raising the first argument to the power of the
	 * second argument if that result can in fact be represented exactly as a
	 * {@code double} value.</ul>
	 *
	 * <p>
	 * (In the foregoing descriptions, a floating-point value is considered to
	 * be an integer if and only if it is finite and a fixed point of the method
	 * {@link #ceil ceil} or, equivalently, a fixed point of the method {@link #floor
	 * floor}. A value is a fixed point of a one-argument method if and only if
	 * the result of applying the method to the value is equal to the value.)
	 *
	 * @param b base.
	 * @param e the exponent.
	 * @return the value {@code a}<sup>{@code b}</sup>.
	 */
	public static double pow(double b, double e) {
		return StrictMath.pow(b, e);
	}

	/**
	 * Returns the value of the first argument raised to the power of the second
	 * argument. Special cases:
	 *
	 * <ul><li>If the second argument is positive or negative zero, then the
	 * result is 1.0. <li>If the second argument is 1.0, then the result is the
	 * same as the first argument. <li>If the second argument is NaN, then the
	 * result is NaN. <li>If the first argument is NaN and the second argument
	 * is nonzero, then the result is NaN.
	 *
	 * <li>If <ul> <li>the absolute value of the first argument is greater than
	 * 1 and the second argument is positive infinity, or <li>the absolute value
	 * of the first argument is less than 1 and the second argument is negative
	 * infinity, </ul> then the result is positive infinity.
	 *
	 * <li>If <ul> <li>the absolute value of the first argument is greater than
	 * 1 and the second argument is negative infinity, or <li>the absolute value
	 * of the first argument is less than 1 and the second argument is positive
	 * infinity, </ul> then the result is positive zero.
	 *
	 * <li>If the absolute value of the first argument equals 1 and the second
	 * argument is infinite, then the result is NaN.
	 *
	 * <li>If <ul> <li>the first argument is positive zero and the second
	 * argument is greater than zero, or <li>the first argument is positive
	 * infinity and the second argument is less than zero, </ul> then the result
	 * is positive zero.
	 *
	 * <li>If <ul> <li>the first argument is positive zero and the second
	 * argument is less than zero, or <li>the first argument is positive
	 * infinity and the second argument is greater than zero, </ul> then the
	 * result is positive infinity.
	 *
	 * <li>If <ul> <li>the first argument is negative zero and the second
	 * argument is greater than zero but not a finite odd integer, or <li>the
	 * first argument is negative infinity and the second argument is less than
	 * zero but not a finite odd integer, </ul> then the result is positive
	 * zero.
	 *
	 * <li>If <ul> <li>the first argument is negative zero and the second
	 * argument is a positive finite odd integer, or <li>the first argument is
	 * negative infinity and the second argument is a negative finite odd
	 * integer, </ul> then the result is negative zero.
	 *
	 * <li>If <ul> <li>the first argument is negative zero and the second
	 * argument is less than zero but not a finite odd integer, or <li>the first
	 * argument is negative infinity and the second argument is greater than
	 * zero but not a finite odd integer, </ul> then the result is positive
	 * infinity.
	 *
	 * <li>If <ul> <li>the first argument is negative zero and the second
	 * argument is a negative finite odd integer, or <li>the first argument is
	 * negative infinity and the second argument is a positive finite odd
	 * integer, </ul> then the result is negative infinity.
	 *
	 * <li>If the first argument is finite and less than zero <ul> <li> if the
	 * second argument is a finite even integer, the result is equal to the
	 * result of raising the absolute value of the first argument to the power
	 * of the second argument
	 *
	 * <li>if the second argument is a finite odd integer, the result is equal
	 * to the negative of the result of raising the absolute value of the first
	 * argument to the power of the second argument
	 *
	 * <li>if the second argument is finite and not an integer, then the result
	 * is NaN. </ul>
	 *
	 * <li>If both arguments are integers, then the result is exactly equal to
	 * the mathematical result of raising the first argument to the power of the
	 * second argument if that result can in fact be represented exactly as a
	 * {@code float} value.</ul>
	 *
	 * <p>
	 * (In the foregoing descriptions, a floating-point value is considered to
	 * be an integer if and only if it is finite and a fixed point of the method
	 * {@link #ceil ceil} or, equivalently, a fixed point of the method {@link #floor
	 * floor}. A value is a fixed point of a one-argument method if and only if
	 * the result of applying the method to the value is equal to the value.)
	 *
	 * @param b base.
	 * @param e the exponent.
	 * @return the value {@code a}<sup>{@code b}</sup>.
	 */
	public static float pow(float b, float e) {
		return (float) pow((double) b, e);
	}

	/**
	 * Checks if the given integer value is a power of 2 value (2 ^ n). If the
	 * given value is less than 0, false will be returned.
	 *
	 * @param i Integer value.
	 * @return If given value is power of 2.
	 */
	public static boolean isPowerOf2(int i) {
		if (i < 0) {
			return false;
		}
		return (i & (i - 1)) == 0;
	}

	/**
	 * Rounds the given integer value to the nearest power of 2 value (2 ^ n).
	 * If the given number is already power of 2, the value itself will be
	 * returned.
	 *
	 * @param i Integer value.
	 * @return Nearest power of 2.
	 */
	public static int roundToPowerOf2(int i) {
		if (isPowerOf2(i)) {
			return i;
		}

		return (int) round(pow(2, round(log2(i))));
	}

	/**
	 * Ceils the given integer value to the next power of 2 value (2 ^ n). If
	 * the given number is already power of 2, the value itself will be
	 * returned.
	 *
	 * @param i Integer value.
	 * @return Next power of 2.
	 */
	public static int ceilToPowerOf2(int i) {
		if (isPowerOf2(i)) {
			return i;
		}

		while (!isPowerOf2(i)) {
			i &= i - 1;
		}

		return i << 1;
	}

	/**
	 * Calculates the factorial value of the given one.
	 * <br/>
	 * The factorial is for example:<br/>
	 * <code>
	 * n = 5<br/>
	 * r = 5 * 4 * 3 * 2 = 120
	 * </code>
	 *
	 * @param n Value.
	 * @return Factorial.
	 */
	public static long factorial(int n) {
		long result = n;
		while (n > 2) {
			result *= (--n);
		}
		return result;
	}

	/**
	 * Calculates the factorial value of the given one.
	 * <br/>
	 * The factorial is for example:<br/>
	 * <code>
	 * n = 5<br/>
	 * r = 5 * 4 * 3 * 2 = 120
	 * </code>
	 *
	 * @param n Value.
	 * @return Factorial.
	 */
	public static BigInteger factorial(long n) {
		BigInteger result = new BigInteger("" + n);
		while (n > 2) {
			result = result.multiply(new BigInteger("" + (--n)));
		}
		return result;
	}

	/**
	 * Interpolates the given values using the given factor.
	 *
	 * @param first First value.
	 * @param last Last value.
	 * @param v Change amount
	 * @return Interpolated value.
	 */
	public static float interpolateLinear(float first, float last, float v) {
		return first + v * (last - first);
	}

	/**
	 * Interpolates the given values using the given factor.
	 *
	 * @param first First value.
	 * @param last Last value.
	 * @param v Change amount
	 * @return Interpolated value.
	 */
	public static double interpolateLinear(double first, double last, double v) {
		return first + v * (last - first);
	}

	/**
	 * Interpolates the given values using the cosine interpolation method.
	 *
	 * @param first First value.
	 * @param last Last value.
	 * @param v Change amount
	 * @return Interpolated value.
	 */
	public static float interpolateCosine(float first, float last, float v) {
		float mu = (1.0f - cos(v * PI_HALF_PRECISION)) / 2.0f;
		return (first * (1.0f - mu) + last * mu);
	}

	/**
	 * Interpolates the given values using the cosine interpolation method.
	 *
	 * @param first First value.
	 * @param last Last value.
	 * @param v Change amount
	 * @return Interpolated value.
	 */
	public static double interpolateCosine(double first, double last, double v) {
		double mu = (1.0f - cos(v * PI_HALF_PRECISION)) / 2.0f;
		return (first * (1.0f - mu) + last * mu);
	}

	/**
	 * Interpolates the given values using the smooth hermit interpolation. The
	 * results are undefined if <code>first >= last</code>.
	 *
	 * @param first Specifies the value of the lower edge of the Hermite
	 * function.
	 * @param last Specifies the value of the upper edge of the Hermite
	 * function.
	 * @param v Specifies the source value for interpolation.
	 * @return Smooth hermit interpolated value.
	 */
	public static float interpolateSmoothHermit(float first, float last, float v) {
		float t = clamp((v - first) / (last - first), 0.0f, 1.0f);
		return t * t * (3.0f - 2.0f * t);
	}

	/**
	 * Interpolates the given values using the smooth hermit interpolation. The
	 * results are undefined if <code>first >= last</code>.
	 *
	 * @param first Specifies the value of the lower edge of the Hermite
	 * function.
	 * @param last Specifies the value of the upper edge of the Hermite
	 * function.
	 * @param v Specifies the source value for interpolation.
	 * @return Smooth hermit interpolated value.
	 */
	public static double interpolateSmoothHermit(double first, double last, double v) {
		double t = clamp((v - first) / (last - first), 0.0, 1.0);
		return t * t * (3.0 - 2.0 * t);
	}

	/**
	 * Creates circular coordinates and supplies it to the given biconsumer.
	 *
	 * @param c Consumer of the coordinates.
	 * @param radius Radius of the circle.
	 */
	public static void circle(BiConsumer<Float, Float> c, float radius) {
		for (int i = 0; i < 360; i++) {
			float angle = toRadians(i);
			c.accept(cos(angle) * radius, sin(angle) * radius);
		}
	}

	/**
	 * Nobody is allowed to create an instance of this class.
	 */
	private FastMath() {
	}
}
