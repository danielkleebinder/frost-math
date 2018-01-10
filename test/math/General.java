package math;

/**
 * Math.pow(x, y): Time (ms): 7148
 *
 * @author Daniel Kleebinder
 */
public class General {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long res = 0;
		for (int i = 0; i < 100_000_000; i++) {
			res += Math.pow(i, Math.PI);
		}
		System.out.println(res);
		System.out.println("Time (ms): " + (System.currentTimeMillis() - start));
	}
}
