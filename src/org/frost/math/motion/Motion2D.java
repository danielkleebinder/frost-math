package org.frost.math.motion;

/**
 * All 2D motion based algorithms should implement this interface.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public interface Motion2D {

	/**
	 * Calculates the height value on the given 1D position.
	 *
	 * @param x X coordinate.
	 * @return Value.
	 */
	double motion(double x);

	/**
	 * Calculates the motion value on the given 1D position.
	 *
	 * @param x X coordinate.
	 * @return Value.
	 */
	default float motion(float x) {
		return (float) motion((double) x);
	}
}
