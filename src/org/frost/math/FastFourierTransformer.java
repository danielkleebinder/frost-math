package org.frost.math;

/**
 * A utility class for calculating the discrete fourier transformation.
 * <br/>
 * This fourier transformation uses the radix-2 algorithm by cooley and<br/>
 * tukey to compute the discrete fourier transformation. The requirements<br/>
 * are, that all given complex values must have a length equal to a power of 2!
 * <br/><br/>
 * The fourier transformation can convert from frequency domain to time<br/>
 * domain and vice versa.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class FastFourierTransformer {

	/**
	 * Computes the fast fourier transformation.
	 *
	 * @param c Complex values.
	 * @return Transformed values.
	 */
	public static Complex[] fft(Complex... c) {
		int n = c.length;

		if (n == 1) {
			return new Complex[]{c[0]};
		}

		if (!FastMath.isPowerOf2(n)) {
			throw new RuntimeException("Can not compute FFT - Number of complex values is not power of 2!");
		}

		Complex[] even = new Complex[n / 2];
		for (int i = 0; i < n / 2; i++) {
			even[i] = c[2 * i];
		}
		Complex[] q = fft(even);

		Complex[] odd = even;
		for (int i = 0; i < n / 2; i++) {
			odd[i] = c[2 * i + 1];
		}
		Complex[] r = fft(odd);

		Complex[] y = new Complex[n];
		for (int i = 0; i < n / 2; i++) {
			double kth = -2.0 * i * FastMath.PI / n;
			Complex wk = new Complex(FastMath.cos(kth), FastMath.sin(kth));
			y[i] = q[i].add(wk.multiplicate(r[i]));
			y[i + n / 2] = q[i].subtract(wk.multiplicate(r[i]));
		}
		return y;
	}

	/**
	 * Computes the inverse fast fourier transformation.
	 *
	 * @param c Complex values.
	 * @return Transformed values.
	 */
	public static Complex[] ifft(Complex... c) {
		int n = c.length;
		Complex[] y = new Complex[n];

		for (int i = 0; i < n; i++) {
			y[i] = c[i].conjugate();
		}

		y = fft(y);

		for (int i = 0; i < n; i++) {
			y[i] = y[i].conjugate();
		}

		for (int i = 0; i < n; i++) {
			y[i] = y[i].multiplicate(1.0 / n);
		}

		return y;
	}

	/**
	 * Nobody is allowed to create an instance of this class.
	 */
	private FastFourierTransformer() {
	}
}
