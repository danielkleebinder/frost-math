package org.frost.math.motion;

import java.util.Objects;
import java.util.Random;
import org.frost.math.FastMath;
import org.frost.math.vector.Vector3f;

/**
 * Simplex noise is a method for constructing an n-dimensional noise function
 * <br/>
 * comparable to perlin noise but with a lower computational overhead,
 * especially<br/>
 * in larger dimensions. Whereas classical noise interpolates between the values
 * from<br/>
 * the surrounding hypergrid end points, simplex noise divides the space<br/>
 * into simplices to interpolate between.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class SimplexNoise implements Motion2D, Motion3D, Motion4D {

	/**
	 * Contains all simplex noise octaves.
	 */
	private SimplexNoiseOctave[] octaves;
	/**
	 * Frequencys.
	 */
	private double[] frequencys;
	/**
	 * Amplitudes.
	 */
	private double[] amplitudes;

	/**
	 * Creates a new simplex noise with the seed set to zero.
	 */
	public SimplexNoise() {
		this(0.1, 0);
	}

	/**
	 * Creates a new simplex noise with the given seed.
	 *
	 * @param seed Seed.
	 */
	public SimplexNoise(int seed) {
		this(0.1, seed);
	}

	/**
	 * Creates a new simplex noise with the given persistence and seed.
	 *
	 * @param persistence Persistence.
	 * @param seed Seed.
	 */
	public SimplexNoise(double persistence, int seed) {
		Random random = new Random(seed);

		int numberOfOctaves = 9;

		octaves = new SimplexNoiseOctave[numberOfOctaves];
		frequencys = new double[numberOfOctaves];
		amplitudes = new double[numberOfOctaves];

		for (int i = 0; i < numberOfOctaves; i++) {
			octaves[i] = new SimplexNoiseOctave(random.nextInt());
			frequencys[i] = FastMath.pow(2, i);
			amplitudes[i] = FastMath.pow(persistence, octaves.length - i);
		}
	}

	/**
	 * Calculates the two dimensional simplex noise. The resulting value will be
	 * [-1, 1].
	 *
	 * @param x X position.
	 * @param y Y position.
	 * @return Simplex noise value.
	 */
	public double noise(double x, double y) {
		double result = 0;
		for (int i = 0; i < octaves.length; i++) {
			result += octaves[i].noise(x / frequencys[i], y / frequencys[i]) * amplitudes[i];
		}
		return result;
	}

	/**
	 * Calculates the three dimensional simplex noise. The resulting value will
	 * be [-1, 1].
	 *
	 * @param x X position.
	 * @param y Y position.
	 * @param z Z position.
	 * @return Simplex noise value.
	 */
	public double noise(double x, double y, double z) {
		double result = 0;
		for (int i = 0; i < octaves.length; i++) {
			result += octaves[i].noise(x / frequencys[i], y / frequencys[i], z / frequencys[i]) * amplitudes[i];
		}
		return result;
	}

	@Override
	public double motion(double x) {
		return noise(x, 0.0);
	}

	@Override
	public double motion(double x, double z) {
		return noise(x, z);
	}

	@Override
	public double motion(double x, double y, double z) {
		return noise(x, y, z);
	}

	/**
	 * Calculates one simplex noise octave. This computation is the most
	 * important and slowest part in the calculation.
	 *
	 * @author Daniel Kleebinder
	 * @since 1.0.0
	 */
	private static class SimplexNoiseOctave {

		/**
		 * Skewing for two dimensions.
		 */
		private static final double F2 = 0.5 * (Math.sqrt(3.0) - 1.0);
		/**
		 * Unskewing for two dimensions.
		 */
		private static final double G2 = (3.0 - Math.sqrt(3.0)) / 6.0;
		/**
		 * Skewing for three dimensions.
		 */
		private static final double F3 = 1.0 / 3.0;
		/**
		 * Unskewing for three dimensions.
		 */
		private static final double G3 = 1.0 / 6.0;
		/**
		 * Skewing for four dimensions.
		 */
		private static final double F4 = (Math.sqrt(5.0) - 1.0) / 4.0;
		/**
		 * Unskewing for four dimensions.
		 */
		private static final double G4 = (5.0 - Math.sqrt(5.0)) / 20.0;
		/**
		 * Contains all possible combinations of vectors with three values.
		 */
		private static final Vector3f[] GRAD_3 = {
			new Vector3f(1, 1, 0), new Vector3f(-1, 1, 0), new Vector3f(1, -1, 0), new Vector3f(-1, -1, 0),
			new Vector3f(1, 0, 1), new Vector3f(-1, 0, 1), new Vector3f(1, 0, -1), new Vector3f(-1, 0, -1),
			new Vector3f(0, 1, 1), new Vector3f(0, -1, 1), new Vector3f(0, 1, -1), new Vector3f(0, -1, -1)
		};
		/**
		 * Contains all values between 0 and 255 in random order depending on
		 * the seed.
		 */
		private static final short[] SUPPLY = {
			151, 160, 137, 91, 90, 15, 131, 13, 201, 95, 96, 53, 194, 233, 7, 225, 140,
			36, 103, 30, 69, 142, 8, 99, 37, 240, 21, 10, 23, 190, 6, 148, 247, 120, 234,
			75, 0, 26, 197, 62, 94, 252, 219, 203, 117, 35, 11, 32, 57, 177, 33,
			88, 237, 149, 56, 87, 174, 20, 125, 136, 171, 168, 68, 175, 74, 165, 71, 134, 139, 48, 27, 166,
			77, 146, 158, 231, 83, 111, 229, 122, 60, 211, 133, 230, 220, 105, 92, 41, 55, 46, 245, 40, 244,
			102, 143, 54, 65, 25, 63, 161, 1, 216, 80, 73, 209, 76, 132, 187, 208, 89, 18, 169, 200, 196,
			135, 130, 116, 188, 159, 86, 164, 100, 109, 198, 173, 186, 3, 64, 52, 217, 226, 250, 124, 123,
			5, 202, 38, 147, 118, 126, 255, 82, 85, 212, 207, 206, 59, 227, 47, 16, 58, 17, 182, 189, 28, 42,
			223, 183, 170, 213, 119, 248, 152, 2, 44, 154, 163, 70, 221, 153, 101, 155, 167, 43, 172, 9,
			129, 22, 39, 253, 19, 98, 108, 110, 79, 113, 224, 232, 178, 185, 112, 104, 218, 246, 97, 228,
			251, 34, 242, 193, 238, 210, 144, 12, 191, 179, 162, 241, 81, 51, 145, 235, 249, 14, 239, 107,
			49, 192, 214, 31, 181, 199, 106, 157, 184, 84, 204, 176, 115, 121, 50, 45, 127, 4, 150, 254,
			138, 236, 205, 93, 222, 114, 67, 29, 24, 72, 243, 141, 128, 195, 78, 66, 215, 61, 156, 180
		};
		/**
		 * Permutation.
		 */
		private final short[] permutation = new short[SUPPLY.length * 2];
		/**
		 * Permutation mod 12.
		 */
		private final short[] permutationMod12 = new short[SUPPLY.length * 2];
		/**
		 * Buffer.
		 */
		private short[] buffer = new short[SUPPLY.length];

		/**
		 * Creates a new simplex noise octave with a seed of zero.
		 */
		public SimplexNoiseOctave() {
			this(0);
		}

		/**
		 * Creates a new simplex noise octave with the given object seed.
		 * <br/>
		 * This seed is the <code>hashCode()</code> from the given object.
		 *
		 * @param seed With this seed you have influence on the noise
		 * generation.
		 */
		public SimplexNoiseOctave(Object seed) {
			this(Objects.hashCode(seed));
		}

		/**
		 * Creates a new simplex noise octave with the given seed.
		 *
		 * @param seed Seed.
		 */
		public SimplexNoiseOctave(int seed) {
			Random rnd = new Random(seed);

			buffer = SUPPLY.clone();

			for (int i = 0; i < SUPPLY.length; i++) {
				int swapFrom = FastMath.abs(rnd.nextInt() % SUPPLY.length);
				int swapTo = FastMath.abs(rnd.nextInt() % SUPPLY.length);

				short temp = buffer[swapFrom];
				buffer[swapFrom] = buffer[swapTo];
				buffer[swapTo] = temp;
			}

			for (int i = 0; i < permutation.length; i++) {
				permutation[i] = buffer[i & 255];
				permutationMod12[i] = (short) (permutation[i] % 12);
			}
		}

		/**
		 * Calculates the two dimensional simplex noise. The resulting value
		 * will be [-1, 1].
		 *
		 * @param x X position.
		 * @param y Y position.
		 * @return Simplex noise value.
		 */
		public double noise(double x, double y) {
			double n0, n1, n2;

			double s = (x + y) * F2;
			int i = FastMath.floorToInt(x + s);
			int j = FastMath.floorToInt(y + s);
			double t = (i + j) * G2;

			double x0 = x - (i - t);
			double y0 = y - (j - t);

			int i1, j1;

			if (x0 > y0) {
				i1 = 1;
				j1 = 0;
			} else {
				i1 = 0;
				j1 = 1;
			}

			double x1 = x0 - i1 + G2;
			double y1 = y0 - j1 + G2;
			double x2 = x0 - 1.0 + 2.0 * G2;
			double y2 = y0 - 1.0 + 2.0 * G2;

			int ii = i & 255;
			int jj = j & 255;

			int gi0 = permutationMod12[ii + permutation[jj]];
			int gi1 = permutationMod12[ii + i1 + permutation[jj + j1]];
			int gi2 = permutationMod12[ii + 1 + permutation[jj + 1]];

			double t0 = 0.5 - x0 * x0 - y0 * y0;
			if (t0 < 0) {
				n0 = 0.0;
			} else {
				t0 *= t0;
				n0 = t0 * t0 * dot(GRAD_3[gi0], x0, y0);
			}

			double t1 = 0.5 - x1 * x1 - y1 * y1;
			if (t1 < 0) {
				n1 = 0.0;
			} else {
				t1 *= t1;
				n1 = t1 * t1 * dot(GRAD_3[gi1], x1, y1);
			}

			double t2 = 0.5 - x2 * x2 - y2 * y2;
			if (t2 < 0) {
				n2 = 0.0;
			} else {
				t2 *= t2;
				n2 = t2 * t2 * dot(GRAD_3[gi2], x2, y2);
			}

			return 70.0 * (n0 + n1 + n2);
		}

		/**
		 * Calculates the three dimensional simplex noise. The resulting value
		 * will be [-1, 1].
		 *
		 * @param x X position.
		 * @param y Y position.
		 * @param z Z position.
		 * @return Simplex noise value.
		 */
		public double noise(double x, double y, double z) {
			double n0, n1, n2, n3;

			double s = (x + y + z) * F3;
			int i = FastMath.floorToInt(x + s);
			int j = FastMath.floorToInt(y + s);
			int k = FastMath.floorToInt(z + s);
			double t = (i + j + k) * G3;

			double x0 = x - (i - t);
			double y0 = y - (j - t);
			double z0 = z - (k - t);

			int i1, j1, k1;
			int i2, j2, k2;
			if (x0 >= y0) {
				if (y0 >= z0) {
					i1 = 1;
					j1 = 0;
					k1 = 0;
					i2 = 1;
					j2 = 1;
					k2 = 0;
				} else if (x0 >= z0) {
					i1 = 1;
					j1 = 0;
					k1 = 0;
					i2 = 1;
					j2 = 0;
					k2 = 1;
				} else {
					i1 = 0;
					j1 = 0;
					k1 = 1;
					i2 = 1;
					j2 = 0;
					k2 = 1;
				}
			} else {
				if (y0 < z0) {
					i1 = 0;
					j1 = 0;
					k1 = 1;
					i2 = 0;
					j2 = 1;
					k2 = 1;
				} else if (x0 < z0) {
					i1 = 0;
					j1 = 1;
					k1 = 0;
					i2 = 0;
					j2 = 1;
					k2 = 1;
				} else {
					i1 = 0;
					j1 = 1;
					k1 = 0;
					i2 = 1;
					j2 = 1;
					k2 = 0;
				}
			}

			double x1 = x0 - i1 + G3;
			double y1 = y0 - j1 + G3;
			double z1 = z0 - k1 + G3;

			double x2 = x0 - i2 + 2.0 * G3;
			double y2 = y0 - j2 + 2.0 * G3;
			double z2 = z0 - k2 + 2.0 * G3;

			double x3 = x0 - 1.0 + 3.0 * G3;
			double y3 = y0 - 1.0 + 3.0 * G3;
			double z3 = z0 - 1.0 + 3.0 * G3;

			int ii = i & 255;
			int jj = j & 255;
			int kk = k & 255;

			int gi0 = permutationMod12[ii + permutation[jj + permutation[kk]]];
			int gi1 = permutationMod12[ii + i1 + permutation[jj + j1 + permutation[kk + k1]]];
			int gi2 = permutationMod12[ii + i2 + permutation[jj + j2 + permutation[kk + k2]]];
			int gi3 = permutationMod12[ii + 1 + permutation[jj + 1 + permutation[kk + 1]]];

			double t0 = 0.6 - x0 * x0 - y0 * y0 - z0 * z0;
			if (t0 < 0) {
				n0 = 0.0;
			} else {
				t0 *= t0;
				n0 = t0 * t0 * dot(GRAD_3[gi0], x0, y0, z0);
			}

			double t1 = 0.6 - x1 * x1 - y1 * y1 - z1 * z1;
			if (t1 < 0) {
				n1 = 0.0;
			} else {
				t1 *= t1;
				n1 = t1 * t1 * dot(GRAD_3[gi1], x1, y1, z1);
			}

			double t2 = 0.6 - x2 * x2 - y2 * y2 - z2 * z2;
			if (t2 < 0) {
				n2 = 0.0;
			} else {
				t2 *= t2;
				n2 = t2 * t2 * dot(GRAD_3[gi2], x2, y2, z2);
			}

			double t3 = 0.6 - x3 * x3 - y3 * y3 - z3 * z3;
			if (t3 < 0) {
				n3 = 0.0;
			} else {
				t3 *= t3;
				n3 = t3 * t3 * dot(GRAD_3[gi3], x3, y3, z3);
			}

			return 32.0 * (n0 + n1 + n2 + n3);
		}

		/**
		 * Calculates the dot product.
		 *
		 * @param v Vector.
		 * @param x X location.
		 * @param y Y location.
		 * @return Dot product.
		 */
		private static double dot(Vector3f v, double x, double y) {
			return v.x * x + v.y * y;
		}

		/**
		 * Calculates the dot product.
		 *
		 * @param v Vector.
		 * @param x X location.
		 * @param y Y location.
		 * @param z Z location.
		 * @return Dot product.
		 */
		private static double dot(Vector3f v, double x, double y, double z) {
			return v.x * x + v.y * y + v.z * z;
		}
	}
}
