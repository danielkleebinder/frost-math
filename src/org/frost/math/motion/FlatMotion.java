package org.frost.math.motion;

/**
 * A flat motion algorithm which will always return 0.0.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class FlatMotion implements Motion2D, Motion3D, Motion4D {

	@Override
	public double motion(double x) {
		return 0.0;
	}

	@Override
	public double motion(double x, double z) {
		return 0.0;
	}

	@Override
	public double motion(double x, double y, double z) {
		return 0.0;
	}
}
