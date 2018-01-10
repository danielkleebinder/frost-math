package vector;

import org.frost.math.vector.Vector2f;
import org.frost.math.vector.VectorUtils;

/**
 * @author Daniel Kleebinder
 */
public class VectorUtilsTest {

	public static void main(String[] args) {
		System.out.println(VectorUtils.reflect(new Vector2f(1.0f, -1.0f), new Vector2f(0.0f, 1.0f)));
		System.out.println(VectorUtils.refract(new Vector2f(1.0f, -1.0f), new Vector2f(0.0f, 1.0f), 1.8));
	}
}
