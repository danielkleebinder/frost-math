package org.frost.math.motion;

import org.frost.math.vector.Vector2d;
import org.frost.math.vector.Vector2f;

/**
 * All 3D motion based algorithms should implement this interface.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public interface Motion3D {

	/**
	 * Calculates the height value on the given 2D position.
	 *
	 * @param x X coordinate.
	 * @param z Z coordinate.
	 * @return Value.
	 */
	double motion(double x, double z);

	/**
	 * Calculates the height value on the given 2D position.
	 *
	 * @param vec Coordinate.
	 * @return Value.
	 */
	default double motion(Vector2d vec) {
		return motion(vec.x, vec.y);
	}

	/**
	 * Calculates the motion value on the given 2D position.
	 *
	 * @param x X coordinate.
	 * @param z Z coordinate.
	 * @return Value.
	 */
	default float motion(float x, float z) {
		return (float) motion((double) x, z);
	}

	/**
	 * Calculates the height value on the given 2D position.
	 *
	 * @param vec Coordinate.
	 * @return Value.
	 */
	default float motion(Vector2f vec) {
		return motion(vec.x, vec.y);
	}
}
