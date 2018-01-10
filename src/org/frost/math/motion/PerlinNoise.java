package org.frost.math.motion;

import java.util.Objects;
import java.util.Random;
import org.frost.math.FastMath;

/**
 * Improved Perlin-Noise algorithm, based on the reference implementation by Ken
 * Perlin.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class PerlinNoise implements Motion2D, Motion3D, Motion4D {

	/**
	 * Lacunarity value.
	 */
	private static final float LACUNARITY = 2.1379201F;
	/**
	 * H value.
	 */
	private static final float H = 0.836281F;
	/**
	 * Spectral weights.
	 */
	private double[] spectralWeights;
	/**
	 * Noise permutations.
	 */
	private int[] noisePermutations;
	/**
	 * If the spectral weights should be recomputed.
	 */
	private boolean recomputeSpectralWeights = true;
	/**
	 * Number of octaves.
	 */
	private int octaves = 9;

	/**
	 * Generates an new object from the class <code>PerlinNoise</code> with the
	 * seed 0.
	 */
	public PerlinNoise() {
		this(System.currentTimeMillis());
	}

	/**
	 * Generates an new object from the class <code>PerlinNoise</code> with a
	 * seed. This seed is the <code>hashCode()</code> from the given object.
	 *
	 * @param seed With this seed you have influence on the noise generation.
	 */
	public PerlinNoise(Object seed) {
		this(Objects.hashCode(seed));
	}

	/**
	 * Generates an new object from the class <code>PerlinNoise</code> with a
	 * seed. This seed is the given parameter <code>int seed</code>.
	 *
	 * @param seed With this seed you have influence on the noise generation.
	 */
	public PerlinNoise(int seed) {
		Random random = new Random(seed);

		noisePermutations = new int[512];
		int[] noiseTable = new int[256];

		//init table
		for (int i = 0; i < noiseTable.length; i++) {
			noiseTable[i] = i;
		}

		//shuffle table
		for (int i = 0; i < noiseTable.length; i++) {
			int j = FastMath.abs(random.nextInt() % noiseTable.length);

			int swap = noiseTable[i];
			noiseTable[i] = noiseTable[j];
			noiseTable[j] = swap;
		}

		//Copy the array
		for (int i = 0; i < noiseTable.length; i++) {
			noisePermutations[i] = noisePermutations[i + 256] = noiseTable[i];
		}
	}

	/**
	 * Calculates the 4D-noise value.
	 *
	 * @param x X position.
	 * @param y Y position.
	 * @param z Z position.
	 * @return Noise value.
	 */
	public double noise(double x, double y, double z) {
		double nx = x, ny = y, nz = z;
		int _x = FastMath.floorToInt(x) & 255;
		int _y = FastMath.floorToInt(y) & 255;
		int _z = FastMath.floorToInt(z) & 255;

		nx -= FastMath.floor(x);
		ny -= FastMath.floor(y);
		nz -= FastMath.floor(z);

		double u = fade(nx);
		double v = fade(ny);
		double w = fade(nz);

		int a = noisePermutations[_x] + _y;
		int aa = noisePermutations[a] + _z;
		int ab = noisePermutations[a + 1] + _z;
		int b = noisePermutations[_x + 1] + _y;
		int ba = noisePermutations[b] + _z;
		int bb = noisePermutations[b + 1] + _z;

		double lerp01 = FastMath.interpolateLinear(grad(noisePermutations[ab], nx, ny - 1, nz), grad(noisePermutations[bb], nx - 1, ny - 1, nz), u);
		double lerp02 = FastMath.interpolateLinear(grad(noisePermutations[ab + 1], nx, ny - 1, nz - 1), grad(noisePermutations[bb + 1], nx - 1, ny - 1, nz - 1), u);

		double lerp1 = FastMath.interpolateLinear(FastMath.interpolateLinear(grad(noisePermutations[aa], nx, ny, nz), grad(noisePermutations[ba], nx - 1, ny, nz), u), lerp01, v);
		double lerp2 = FastMath.interpolateLinear(FastMath.interpolateLinear(grad(noisePermutations[aa + 1], nx, ny, nz - 1), grad(noisePermutations[ba + 1], nx - 1, ny, nz - 1), u), lerp02, v);

		return FastMath.interpolateLinear(lerp1, lerp2, w);
	}

	/**
	 * Sets the amount of used octaves for the calculation.
	 *
	 * @param octaves Octaves.
	 */
	public void setOctaves(int octaves) {
		this.octaves = octaves;
	}

	/**
	 * Returns the amount of used octaves for the calculation.
	 *
	 * @return Octaves.
	 */
	public int getOctaves() {
		return octaves;
	}

	@Override
	public double motion(double x) {
		return motion(x, 0.0);
	}

	@Override
	public double motion(double x, double z) {
		return motion(x, 0.0, z);
	}

	@Override
	public double motion(double x, double y, double z) {
		double result = 0.0;
		double nx = x, ny = y, nz = z;

		if (recomputeSpectralWeights) {
			spectralWeights = new double[octaves];

			for (int i = 0; i < octaves; i++) {
				spectralWeights[i] = FastMath.pow(LACUNARITY, -H * i);
			}
			recomputeSpectralWeights = false;
		}

		for (int i = 0; i < octaves; i++) {
			result += noise(nx, ny, nz) * spectralWeights[i];

			nx *= LACUNARITY;
			ny *= LACUNARITY;
			nz *= LACUNARITY;
		}

		return result;
	}

	/**
	 * Fades the values with an algorithm.
	 *
	 * @param t Value.
	 * @return Result.
	 */
	private static double fade(double t) {
		return t * t * t * (t * (t * 6 - 15) + 10);
	}

	/**
	 * Grad hashing algorithm.
	 *
	 * @param hash Hash.
	 * @param x X position.
	 * @param y Y position.
	 * @param z Z position.
	 * @return Result.
	 */
	private static double grad(int hash, double x, double y, double z) {
		int nHash = hash & 15;
		double u = nHash < 8 ? x : y;
		double v = nHash < 4 ? y : nHash == 12 || nHash == 14 ? x : z;
		return ((nHash & 1) == 0 ? u : -u) + ((nHash & 2) == 0 ? v : -v);
	}
}
