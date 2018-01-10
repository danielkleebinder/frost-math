package vector;

import org.frost.math.vector.ReadOnlyVector2f;
import org.frost.math.vector.Vector2f;
import org.frost.math.vector.Vector3f;
import org.frost.math.vector.Vector4f;
import org.frost.math.vector.VectorUtils;

/**
 * @author Daniel Kleebinder
 */
public class Vector2fTest {

	public static void main(String[] args) {
		Vector2f vec1 = new ReadOnlyVector2f(0.0f, 0.0f);
		Vector2f vec2 = new ReadOnlyVector2f(2.0f, 1.0f);

		System.out.println(VectorUtils.interpolate(vec1, vec2, 0.1253f));
		System.out.println(VectorUtils.normal(
				new Vector3f(1.0f, 0.0f, 0.0f),
				new Vector3f(0.0f, 0.0f, 0.0f),
				new Vector3f(0.0f, 0.0f, 1.0f)
		));

		System.out.println(new Vector4f(1.0f).direction(new Vector4f(1.0f, 1.0f, 1.0f, 1.0f)));
		
		System.out.println(new Vector3f(1, 0, 1).cross(new Vector3f(2, 1, 0)));
	}
}
