package org.frost.math.motion;

import org.frost.math.vector.Vector3d;
import org.frost.math.vector.Vector3f;

/**
 * All 4D motion based algorithms should implement this interface.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public interface Motion4D {

	/**
	 * Calculates the motion value on the given 3D position.
	 *
	 * @param x X coordinate.
	 * @param y Y coordinate.
	 * @param z Z coordinate.
	 * @return Value.
	 */
	double motion(double x, double y, double z);

	/**
	 * Calculates the motion value on the given 3D position.
	 *
	 * @param vec Coordinate.
	 * @return Value.
	 */
	default double motion(Vector3d vec) {
		return motion(vec.x, vec.y, vec.z);
	}

	/**
	 * Calculates the motion value on the given 3D position.
	 *
	 * @param x X coordinate.
	 * @param y Y coordinate.
	 * @param z Z coordinate.
	 * @return Value.
	 */
	default float motion(float x, float y, float z) {
		return (float) motion((double) x, y, z);
	}

	/**
	 * Calculates the motion value on the given 3D position.
	 *
	 * @param vec Coordinate.
	 * @return Value.
	 */
	default float motion(Vector3f vec) {
		return motion(vec.x, vec.y, vec.z);
	}
}
