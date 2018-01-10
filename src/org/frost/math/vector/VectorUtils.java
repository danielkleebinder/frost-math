package org.frost.math.vector;

import org.frost.math.FastMath;

/**
 * Contains many utility methods for vector operations.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class VectorUtils {

	/**
	 * Adds the right vector to the left vector.
	 *
	 * @param <E> Generic vector type.
	 * @param <D> Generic vector data type.
	 * @param left Left vector.
	 * @param right Right vector.
	 * @return New vector containing the result.
	 */
	public static <E extends Vector, D extends Number> E add(E left, E right) {
		if (left == null) {
			throw new IllegalArgumentException("Left vector can not be null!");
		}
		if (right == null) {
			throw new IllegalArgumentException("Right vector can not be null!");
		}
		return (E) left.add(right);
	}

	/**
	 * Subtracts the right vector from the left vector.
	 *
	 * @param <E> Generic vector type.
	 * @param <D> Generic vector data type.
	 * @param left Left vector.
	 * @param right Right vector.
	 * @return New vector containing the result.
	 */
	public static <E extends Vector, D extends Number> E subtract(E left, E right) {
		if (left == null) {
			throw new IllegalArgumentException("Left vector can not be null!");
		}
		if (right == null) {
			throw new IllegalArgumentException("Right vector can not be null!");
		}
		return (E) left.subtract(right);
	}

	/**
	 * Multiplicates the right vector with the left vector.
	 *
	 * @param <E> Generic vector type.
	 * @param <D> Generic vector data type.
	 * @param left Left vector.
	 * @param right Right vector.
	 * @return New vector containing the result.
	 */
	public static <E extends Vector, D extends Number> E multiplicate(E left, E right) {
		if (left == null) {
			throw new IllegalArgumentException("Left vector can not be null!");
		}
		if (right == null) {
			throw new IllegalArgumentException("Right vector can not be null!");
		}
		return (E) left.multiplicate(right);
	}

	/**
	 * Divides the left vector by the right vector.
	 *
	 * @param <E> Generic vector type.
	 * @param <D> Generic vector data type.
	 * @param left Left vector.
	 * @param right Right vector.
	 * @return New vector containing the result.
	 */
	public static <E extends Vector, D extends Number> E divide(E left, E right) {
		if (left == null) {
			throw new IllegalArgumentException("Left vector can not be null!");
		}
		if (right == null) {
			throw new IllegalArgumentException("Right vector can not be null!");
		}
		return (E) left.divide(right);
	}

	/**
	 * Interpolates the two given vectors by using the given float value.
	 * <br/>
	 * The change amount must be between 0.0f and 1.0f.
	 *
	 * @param <E> Generic vector type.
	 * @param <D> Generic vector data type.
	 * @param first First vector.
	 * @param last Last vector.
	 * @param v Change amount.
	 * @return Interpolated vector.
	 */
	public static <E extends Vector, D extends Number> E interpolate(E first, E last, float v) {
		if (first == null) {
			throw new IllegalArgumentException("First vector can not be null!");
		}
		if (last == null) {
			throw new IllegalArgumentException("Last vector can not be null!");
		}
		if (v < 0 || v > 1) {
			throw new IllegalArgumentException("Change amount out of range [0,1]!");
		}
		return (E) first.multiplicate(1.0f - v).addLocal(last.multiplicate(v));
	}

	/**
	 * Calculates the distance between the two given vectors.
	 *
	 * @param <E> Generic vector type.
	 * @param <D> Generic vector data type.
	 * @param vec1 Vector 1.
	 * @param vec2 Vector 2.
	 * @return Distance.
	 */
	public static <E extends Vector, D extends Number> D distance(E vec1, E vec2) {
		if (vec1 == null) {
			throw new IllegalArgumentException("First vector can not be null!");
		}
		if (vec2 == null) {
			throw new IllegalArgumentException("Second vector can not be null!");
		}
		return (D) vec1.distance(vec2);
	}

	/**
	 * Calculates the squared distance between the two given vectors.
	 * <br/>
	 * Use the <code>sqrt</code> function to get the right distance.
	 *
	 * @param <E> Generic vector type.
	 * @param <D> Generic vector data type.
	 * @param vec1 Vector 1.
	 * @param vec2 Vector 2.
	 * @return Squared distance.
	 */
	public static <E extends Vector, D extends Number> D distanceSquared(E vec1, E vec2) {
		if (vec1 == null) {
			throw new IllegalArgumentException("First vector can not be null!");
		}
		if (vec2 == null) {
			throw new IllegalArgumentException("Second vector can not be null!");
		}
		return (D) vec1.distanceSquared(vec2);
	}

	/**
	 * Calculates the cross product of the two given vectors.
	 *
	 * @param <E> Generic vector type.
	 * @param <D> Generic vector data type.
	 * @param vec1 Vector 1.
	 * @param vec2 Vector 2.
	 * @return Cross product.
	 */
	public static <E extends Vector, D extends Number> E crossProduct(E vec1, E vec2) {
		if (vec1 == null) {
			throw new IllegalArgumentException("First vector can not be null!");
		}
		if (vec2 == null) {
			throw new IllegalArgumentException("Second vector can not be null!");
		}
		return (E) vec1.cross(vec2);
	}

	/**
	 * Calculates the output reflection direction vector for the given incident
	 * and normal vector.
	 *
	 * @param <E> Generic vector type.
	 * @param <D> Generic vector data type.
	 * @param i Incident vector.
	 * @param n Normal vector.
	 * @return Reflection direction vector.
	 */
	public static <E extends Vector, D extends Number> E reflect(E i, E n) {
		return (E) i.subtract(n.multiplicate((float) n.dot(i) * 2.0f));
	}

	/**
	 * Calculates the refraction direction vector for the given incident and
	 * normal vector. The two input parameters <code>i</code> and <code>n</code>
	 * should be normalized to get the expected correct results.<br/>
	 * The given ratio of indices of refraction is a specific parameter which
	 * influences the refraction direction vector. The ratio of indices of
	 * refraction is also known as "refraction index" which is used for
	 * different refraction materials.<br/>
	 * Some common used refraction indices are in the table below.
	 * <center>
	 * <table border="1">
	 * <tr><td><b>Material</b></td><td><b>n</b></td></tr>
	 * <tr><td>Vacuum</td><td>1</td></tr>
	 * <tr><td>Air</td><td>1.000 293</td></tr>
	 * <tr><td>Helium</td><td>1.000 036</td></tr>
	 * <tr><td>Hydrogen</td><td>1.000 132</td></tr>
	 * <tr><td>Carbon dioxide</td><td>1.000 45</td></tr>
	 * <tr><td>Water</td><td>1.333</td></tr>
	 * <tr><td>Ethanol</td><td>1.36</td></tr>
	 * <tr><td>Ice</td><td>1.309</td></tr>
	 * <tr><td>Diamond</td><td>2.42</td></tr>
	 * </table>
	 * </center>
	 * The refraction indices are normally never below <code>1.0</code>, but
	 * there are some exceptions.
	 * <center>
	 * <table border="1">
	 * <tr><td><b>Material</b></td><td><b>n</b></td></tr>
	 * <tr><td>Metamaterials</td><td>&lt 0.0</td></tr>
	 * <tr><td>Plasma</td><td>&lt 1.0</td></tr>
	 * </table>
	 * </center>
	 *
	 * @param <E> Generic vector type.
	 * @param <D> Generic vector data type.
	 * @param i Incident vector.
	 * @param n Normal vector.
	 * @param eta Ratio of indices of refraction.
	 * @return Refraction direction vector.
	 */
	public static <E extends Vector, D extends Number> E refract(E i, E n, double eta) {
		double ndi = n.dot(i);
		double k = 1.0 - eta * eta * (1.0 - ndi * ndi);
		if (k < 0.0) {
			return (E) n.multiplicate(0.0f);
		}
		return (E) i.multiplicate((float) eta)
				.subtractLocal(
						n.multiplicate((float) (eta * ndi + FastMath.sqrt(k)))
				);
	}

	/**
	 * Calculates the normal of the three given input vectors.
	 *
	 * @param <E> Generic vector type.
	 * @param <D> Generic vector data type.
	 * @param vec1 Vector 1.
	 * @param vec2 Vector 2.
	 * @param vec3 Vector 3.
	 * @return Normal vector.
	 */
	public static <E extends Vector, D extends Number> E normal(E vec1, E vec2, E vec3) {
		return (E) crossProduct(vec2.subtract(vec1), vec3.subtract(vec1)).normalizeLocal();
	}

	/**
	 * Nobody is allowed to create an instance of this class.
	 */
	private VectorUtils() {
	}
}
