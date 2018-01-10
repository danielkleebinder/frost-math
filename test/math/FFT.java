package math;

import java.util.Arrays;
import java.util.Random;
import org.frost.math.Complex;
import org.frost.math.FastFourierTransformer;

/**
 * @author Daniel Kleebinder
 */
public class FFT {

	public static void main(String[] args) {
		Random rnd = new Random();

		Complex[] c = new Complex[8];
		for (int i = 0; i < c.length; i++) {
			c[i] = new Complex(
					rnd.nextDouble(),
					rnd.nextDouble()
			);
		}

		System.out.println("Not Transformed");
		System.out.println(Arrays.toString(c));
		System.out.println("Transformed");
		System.out.println(Arrays.toString(FastFourierTransformer.fft(c)));
		System.out.println("Transformed");
		System.out.println(Arrays.toString(
				FastFourierTransformer.ifft(FastFourierTransformer.fft(c))
		));
	}
}
