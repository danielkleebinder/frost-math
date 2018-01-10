package org.frost.physics;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.frost.math.FastMath;

/**
 * A math utility class for physics dependent calculations.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class PhysicsUtil {

	/**
	 * Gravity in meters per second squared for earth.
	 */
	public static final double GRAVITY_EARTH = 9.80665;
	/**
	 * Gravitational constant for combining mass with gravity.
	 */
	public static final double GRAVITATIONAL_CONSTANT = 6.6725985E-11;
	/**
	 * Speed of light in meters per second in a vacuum.
	 */
	public static final double SPEED_OF_LIGHT_VAKUUM = 299_792_458.0f;
	/**
	 * Speed of light squared in meters per second in a vacuum. This value is
	 * very important for many calculations.
	 */
	public static final double SPEED_OF_LIGHT_VAKUUM_SQUARED = SPEED_OF_LIGHT_VAKUUM * SPEED_OF_LIGHT_VAKUUM;
	/**
	 * Precise gravitational constant for combining mass with gravity.
	 */
	public static final BigDecimal PRECISE_GRAVITATIONAL_CONSTANT = new BigDecimal("6.671281903963040991511534289E-11");

	/**
	 * Calculates the falling height of an object not respecting air conditions.
	 *
	 * @param g Gravity.
	 * @param s Time in seconds.
	 * @return Drop height.
	 */
	public static double dropHeight(double g, double s) {
		return g * (s * s);
	}

	/**
	 * Calculates the time the object is falling from the given height not
	 * respecting air conditions.
	 *
	 * @param g Gravity.
	 * @param h Height.
	 * @return Drop time.
	 */
	public static double dropTime(double g, double h) {
		return FastMath.pow(h / g, 0.5);
	}

	/**
	 * Calculates the gravity from the given mass and the radius (or the
	 * distance) from the center of the object.
	 *
	 * @param m Mass in kg.
	 * @param r Radius in meters.
	 * @return Surface gravity in meters per second.
	 */
	public static double gravityFromMass(double m, double r) {
		return (GRAVITATIONAL_CONSTANT * m) / (r * r);
	}

	/**
	 * Calculates the gravity from the given mass and the radius (or the
	 * distance) from the center of the object.
	 *
	 * @param m Mass in kg.
	 * @param r Radius in meters.
	 * @return Surface gravity in meters per second.
	 */
	public static BigDecimal gravityFromMass(BigDecimal m, BigDecimal r) {
		return (PRECISE_GRAVITATIONAL_CONSTANT.multiply(m)).divide((r.pow(2)), 1000, RoundingMode.HALF_UP);
	}

	/**
	 * Calculates the gravity from the given mass and the radius (or the
	 * distance) from the center of the object.
	 *
	 * @param m Mass in kg.
	 * @param radiusSquared Radius squared in meters.
	 * @return Surface gravity in meters per second.
	 */
	public static BigDecimal gravityFromMassSquared(BigDecimal m, BigDecimal radiusSquared) {
		return (PRECISE_GRAVITATIONAL_CONSTANT.multiply(m)).divide(radiusSquared, 1000, RoundingMode.HALF_UP);
	}

	/**
	 * Calculates the orbital velocity for a given mass and distance.
	 *
	 * @param m Mass in kg.
	 * @param r Radius in meters.
	 * @return Orbital velocity in meters per second.
	 */
	public static double orbitalVelocity(double m, double r) {
		return FastMath.sqrt((GRAVITATIONAL_CONSTANT * m) / r);
	}

	/**
	 * Calculates the gravitational parameter.
	 *
	 * @param m1 Mass 1.
	 * @param m2 Mass 2.
	 * @return Gravitational parameter.
	 */
	public static double gravitationalParameter(double m1, double m2) {
		return GRAVITATIONAL_CONSTANT * (m1 + m2);
	}

	/**
	 * Calculates the standard gravitational parameter.
	 *
	 * @param m1 Mass 1.
	 * @return Standard gravitational parameter.
	 */
	public static double standardGravitationalParameter(double m1) {
		return GRAVITATIONAL_CONSTANT * m1;
	}

	/**
	 * Calculates the specific angular momentum.
	 *
	 * @param angularMomentum Angular momentum.
	 * @param mass Mass.
	 * @return Specific angular momentum.
	 */
	public static double specificAngularMomentum(double angularMomentum, double mass) {
		return angularMomentum / mass;
	}

	/**
	 * Calculates the semi latus rectum. The semi-latus rectum (ℓ) is half of
	 * the length of the latus rectum.
	 *
	 * @param specificAngularMomentum Specific angular momentum.
	 * @param gravitationalParameter Gravitational parameter.
	 * @return Semi latus rectum.
	 */
	public static double semiLatusRectum(double specificAngularMomentum, double gravitationalParameter) {
		return (specificAngularMomentum * specificAngularMomentum) / gravitationalParameter;
	}

	/**
	 * Returns the length of the semi major axis.
	 *
	 * @param semiLatusRectum Semi latus rectum.
	 * @param orbitalEccentricity Orbital eccentricity.
	 * @return Length of the semi major axis.
	 */
	public static double semiMajorAxis(double semiLatusRectum, double orbitalEccentricity) {
		return semiLatusRectum / (1 - (orbitalEccentricity * orbitalEccentricity));
	}

	/**
	 * Calculates the velocity in meters per second which an object needs to
	 * escape the gravitational force of an object.
	 *
	 * @param m Mass in kg.
	 * @param r Radius in meters.
	 * @return Velocity in meters per second.
	 */
	public static double escapeVelocity(double m, double r) {
		return FastMath.sqrt((2.0 * GRAVITATIONAL_CONSTANT * m) / r);
	}

	/**
	 * Calculates the schwarzschild radius of an object with the given mass.
	 *
	 * @param m Mass in kg.
	 * @return Schwarzschildradius in meters.
	 */
	public static double schwarzschildRadius(double m) {
		return (2.0f * GRAVITATIONAL_CONSTANT * m) / SPEED_OF_LIGHT_VAKUUM_SQUARED;
	}

	/**
	 * Converts the given km/h to meters per second.
	 *
	 * @param kmh Kilometers per hour.
	 * @return Meters per second.
	 */
	public static double toMetersPerSecond(double kmh) {
		return kmh / 3.6;
	}

	/**
	 * Converts the given meters per second to km/h.
	 *
	 * @param mps Meters per second.
	 * @return Kilometers per hour.
	 */
	public static double toKilometersPerHour(double mps) {
		return mps * 3.6;
	}

	/**
	 * Converts the given meters per second to km/s.
	 *
	 * @param mps Meters per second.
	 * @return Kilometers per second.
	 */
	public static double toKilometersPerSecond(double mps) {
		return mps / 1000.0;
	}
}
