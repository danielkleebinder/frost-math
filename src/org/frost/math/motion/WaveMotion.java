package org.frost.math.motion;

import org.frost.math.FastMath;

/**
 * Generates a gradient using the <code>sin</code> and <code>cos</code>
 * function.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class WaveMotion implements Motion2D, Motion3D {

	@Override
	public double motion(double x) {
		return FastMath.sin(x);
	}

	@Override
	public double motion(double x, double z) {
		return FastMath.sin(x) * FastMath.cos(z);
	}
}
