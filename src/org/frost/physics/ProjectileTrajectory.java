package org.frost.physics;

import static org.frost.math.FastMath.sin;
import static org.frost.math.FastMath.tan;
import static org.frost.math.FastMath.cos;
import static org.frost.math.FastMath.tanh;
import static org.frost.math.FastMath.sqrt;

/**
 * A utility class for calculating the trajectory of projectiles.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ProjectileTrajectory {

	/**
	 * Calculates the distance which the projectile will cover.
	 *
	 * @param theta Launch angle in radiants.
	 * @param g Gravity.
	 * @param v0 Start velocity.
	 * @return Distance.
	 */
	public static double distance(double theta, double g, double v0) {
		return distance(theta, g, v0, 0.0);
	}

	/**
	 * Calculates the distance which the projectile will cover.
	 *
	 * @param theta Launch angle in radiants.
	 * @param g Gravity.
	 * @param v0 Start velocity.
	 * @param y0 Start height.
	 * @return Distance.
	 */
	public static double distance(double theta, double g, double v0, double y0) {
		double d = v0 * sin(theta);
		return ((v0 * cos(theta)) / g) * (v0 * sin(theta) + sqrt((d * d) + 2 * g * y0));
	}

	/**
	 * Calculates the max distance the projectile can cover.
	 *
	 * @param g Gravity.
	 * @param v0 Start velocity.
	 * @return Distance.
	 */
	public static double maxDistance(double g, double v0) {
		return (v0 * v0) / g;
	}

	/**
	 * Calculates the flight time of the projectile.
	 *
	 * @param d Distance.
	 * @param theta Launch angle in radiants.
	 * @param g Gravity.
	 * @param v0 Start velocity.
	 * @return Flight time.
	 */
	public static double flightTime(double d, double theta, double g, double v0) {
		return flightTime(d, theta, g, v0, 0.0);
	}

	/**
	 * Calculates the flight time of the projectile.
	 *
	 * @param d Distance.
	 * @param theta Launch angle in radiants.
	 * @param g Gravity.
	 * @param v0 Start velocity.
	 * @param y0 Start height.
	 * @return Flight time.
	 */
	public static double flightTime(double d, double theta, double g, double v0, double y0) {
		double x = v0 * sin(theta);
		return (v0 * sin(theta) + sqrt((x * x) + 2 * g * y0)) / g;
	}

	/**
	 * Calculates the projectile height at the given x position.
	 *
	 * @param x X position.
	 * @param theta Launch angle in radiants.
	 * @param g Gravity.
	 * @param v0 Start velocity.
	 * @return Height.
	 */
	public static double heightAt(double x, double theta, double g, double v0) {
		return heightAt(x, theta, g, v0, 0.0);
	}

	/**
	 * Calculates the projectile height at the given x position.
	 *
	 * @param x X position.
	 * @param theta Launch angle in radiants.
	 * @param g Gravity.
	 * @param v0 Start velocity.
	 * @param y0 Start height.
	 * @return Height.
	 */
	public static double heightAt(double x, double theta, double g, double v0, double y0) {
		double d = v0 * cos(theta);
		return y0 + x * tan(theta) - ((g * (x * x)) / (2 * (d * d)));
	}

	/**
	 * Calculates the velocity at the given x position.
	 *
	 * @param x X position.
	 * @param theta Launch angle in radiants.
	 * @param g Gravity.
	 * @param v0 Start velocity.
	 * @return Velocity.
	 */
	public static double velocityAt(double x, double theta, double g, double v0) {
		double d = (g * x) / (v0 * cos(theta));
		return sqrt((v0 * v0) - (2 * g * x * tan(theta)) + (d * d));
	}

	/**
	 * Calculates the angle which must be used to hit the given vector
	 * <code>V=(x, y)</code>.
	 *
	 * @param x X position.
	 * @param y Y position.
	 * @param g Gravity.
	 * @param v0 Start velocity.
	 * @return Angle to hit in radiants.
	 */
	public static double angleToHit(double x, double y, double g, double v0) {
		double vs = v0 * v0;
		return tanh((vs + sqrt((vs * vs) - g * (g * (x * x) + 2 * y * vs))) / (g * x));
	}
}
