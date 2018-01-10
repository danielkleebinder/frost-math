package org.frost.math.bounding;

import java.util.ArrayList;
import java.util.List;
import org.frost.math.FastMath;
import org.frost.math.ray.Ray3f;
import org.frost.math.vector.Vector3f;

/**
 * A bounding box is used to test intersections, ray casts and to check if one
 * volume contains another one.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class BoundingBox extends BoundingVolume {

	// Buffers for ray casting
	private static final Vector3f vec1 = new Vector3f(),
			vec2 = new Vector3f(),
			vec3 = new Vector3f(),
			vec4 = new Vector3f(),
			vec5 = new Vector3f(),
			vec6 = new Vector3f(),
			vec7 = new Vector3f(),
			vec8 = new Vector3f(),
			norm = new Vector3f();
	private static final Vector3f[] vecArray = new Vector3f[4];

	/**
	 * Box x extent;
	 */
	protected float xExtent;
	/**
	 * Box y extent;
	 */
	protected float yExtent;
	/**
	 * Box z extent;
	 */
	protected float zExtent;

	/**
	 * Creates a new BoundingBox instance with center
	 * <code>Vector3f(0, 0, 0)</code>.
	 */
	public BoundingBox() {
		this(new Vector3f(), 0, 0, 0);
	}

	/**
	 * Creates a new BoundingBox instance with the given center.
	 *
	 * @param center Boundings center.
	 */
	public BoundingBox(Vector3f center) {
		this(center, 0, 0, 0);
	}

	/**
	 * Creates a new bounding box instance with the given extents.
	 *
	 * @param xExtent X extent.
	 * @param yExtent Y extent.
	 * @param zExtent Z extent.
	 */
	public BoundingBox(float xExtent, float yExtent, float zExtent) {
		this(new Vector3f(), xExtent, yExtent, zExtent);
	}

	/**
	 * Creates a new bounding box instance with the given extents and the given
	 * center.
	 *
	 * @param center Boundings center.
	 * @param xExtent X extent.
	 * @param yExtent Y extent.
	 * @param zExtent Z extent.
	 */
	public BoundingBox(Vector3f center, float xExtent, float yExtent, float zExtent) {
		super(center);
		if (xExtent < 0 || yExtent < 0 || zExtent < 0) {
			throw new IllegalArgumentException("The xExtent, yExtent or zExtent is negative!");
		}
		this.xExtent = xExtent;
		this.yExtent = yExtent;
		this.zExtent = zExtent;
	}

	/**
	 * Creates a new bounding box instance around the given bounding sphere.
	 *
	 * @param sphere Inner Sphere.
	 * @return BoundingBox around the given sphere.
	 */
	public static BoundingBox createBoundingBox(BoundingSphere sphere) {
		float radius = sphere.radius * FastMath.sqrt(3);
		return new BoundingBox(sphere.center, radius, radius, radius);
	}

	/**
	 * Sets the x extent of the bounding box.
	 *
	 * @param xExtent Value.
	 */
	public void setXExtent(float xExtent) {
		this.xExtent = xExtent;
	}

	/**
	 * Returns the current x extent of the bounding box.
	 *
	 * @return X extent.
	 */
	public float getXExtent() {
		return xExtent;
	}

	/**
	 * Sets the y extent of the bounding box.
	 *
	 * @param yExtent Value.
	 */
	public void setYExtent(float yExtent) {
		this.yExtent = yExtent;
	}

	/**
	 * Returns the current y extent of the bounding box.
	 *
	 * @return Y extent.
	 */
	public float getYExtent() {
		return yExtent;
	}

	/**
	 * Sets the z extent of the bounding box.
	 *
	 * @param zExtent Value.
	 */
	public void setZExtent(float zExtent) {
		this.zExtent = zExtent;
	}

	/**
	 * Returns the current z extent of the bounding box.
	 *
	 * @return Z extent.
	 */
	public float getZExtent() {
		return zExtent;
	}

	/**
	 * Returns the default position of the bounding box. This position is one of
	 * the corners.
	 *
	 * @return Corner box position.
	 */
	public Vector3f getPosition() {
		return new Vector3f(center.x - xExtent, center.y - yExtent, center.z + zExtent);
	}

	/**
	 * Returns the default x, y and z size.
	 *
	 * @return X, y and z size.
	 */
	public Vector3f getSize() {
		return new Vector3f(xExtent, yExtent, zExtent);
	}

	@Override
	public boolean intersects(Ray3f ray) {
		return rayCast(ray) >= 0;
	}

	/**
	 * Makes a ray cast for the bounding box. This method returns the first
	 * intersection side of the ray. It will return -1 if no intersection
	 * happens with this bounding.<br/>
	 * <ul>
	 * <li>-1... No Side</li>
	 * <li>0 ... Front</li>
	 * <li>1 ... Back</li>
	 * <li>2 ... Left</li>
	 * <li>3 ... Right</li>
	 * <li>4 ... Top</li>
	 * <li>5 ... Bottom</li>
	 * </ul>
	 *
	 * @param ray Ray with which the intersection should be tested.
	 * @return Box side which intersects first.
	 */
	public synchronized int rayCast(Ray3f ray) {
		vec1.set(center.x - xExtent, center.y + yExtent, center.z - zExtent); // Top    Left  Front
		vec2.set(center.x + xExtent, center.y + yExtent, center.z - zExtent); // Top    Right Front
		vec3.set(center.x + xExtent, center.y - yExtent, center.z - zExtent); // Bottom Right Front
		vec4.set(center.x - xExtent, center.y - yExtent, center.z - zExtent); // Bottom Left  Front

		vec5.set(center.x - xExtent, center.y + yExtent, center.z + zExtent); // Top    Left  Back
		vec6.set(center.x + xExtent, center.y + yExtent, center.z + zExtent); // Top    Right Back
		vec7.set(center.x + xExtent, center.y - yExtent, center.z + zExtent); // Bottom Right Back
		vec8.set(center.x - xExtent, center.y - yExtent, center.z + zExtent); // Bottom Left  Back

		float[] results = new float[6];

		results[0] = faceIntersection(ray, setVectorArray(vec5, vec6, vec7, vec8)); // Front  Face
		results[1] = faceIntersection(ray, setVectorArray(vec4, vec3, vec2, vec1)); // Back   Face
		results[2] = faceIntersection(ray, setVectorArray(vec8, vec4, vec1, vec5)); // Left   Face
		results[3] = faceIntersection(ray, setVectorArray(vec3, vec7, vec6, vec2)); // Right  Face
		results[4] = faceIntersection(ray, setVectorArray(vec1, vec2, vec6, vec5)); // Top    Face
		results[5] = faceIntersection(ray, setVectorArray(vec8, vec7, vec3, vec4)); // Bottom Face

		float min = Float.MAX_VALUE;

		for (int i = 0; i < results.length; i++) {
			if (results[i] < 0) {
				continue;
			}
			if (min > results[i]) {
				min = results[i];
			}
		}

		for (int i = 0; i < results.length; i++) {
			if (min == results[i]) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * This method checks, if an intersection with the given face happens.
	 *
	 * @param ray Ray with which the intersection should be tested.
	 * @param edges Edges of the face.
	 * @return Distance to the given face or -1 if no intersection happens.
	 */
	public float faceIntersection(Ray3f ray, Vector3f[] edges) {
		Vector3f normal = computeNormal(edges[0], edges[2], edges[3]);
		float dotNormal = (float) ray.direction.dot(normal);

		if (dotNormal == 0) {
			return -1;
		}

		Vector3f intersect = edges[0].subtract(ray.origin);
		float t = (float) intersect.dot(normal) / dotNormal;

		if (t < 0) {
			return -1.0f;
		}

		boolean positive;
		float firstPtDot = (float) ray.direction
				.dot(ray.origin
						.subtract(edges[0])
						.cross(ray.origin.subtract(edges[1])));

		if (firstPtDot > 0) {
			positive = true;
		} else if (firstPtDot < 0) {
			positive = false;
		} else {
			return -1;
		}

		for (int i = 0; i < 4; i++) {
			int next = (i + 1) % 4;
			float dotPt = (float) ray.direction
					.dot(ray.origin
							.subtract(edges[i])
							.cross(ray.origin.subtract(edges[next])));
			if (positive && dotPt < 0) {
				return -1;
			} else if (!positive && dotPt > 0) {
				return -1;
			}
		}

		return t;
	}

	/**
	 * Calculates the normal of the given face.
	 *
	 * @param v2 First Vector.
	 * @param v3 Second Vector.
	 * @param v4 Third Vector.
	 * @return Normal of the face.
	 */
	private Vector3f computeNormal(Vector3f v2, Vector3f v3, Vector3f v4) {
		float xVector1 = v4.x - v3.x;
		float yVector1 = v4.y - v3.y;
		float zVector1 = v4.z - v3.z;

		float xVector2 = v2.x - v3.x;
		float yVector2 = v2.y - v3.y;
		float zVector2 = v2.z - v3.z;

		float xNormal = yVector1 * zVector2 - yVector2 * zVector1;
		float yNormal = -(xVector1 * zVector2 - xVector2 * zVector1);
		float zNormal = xVector1 * yVector2 - xVector2 * yVector1;

		return norm.set(xNormal, yNormal, zNormal).normalizeLocal();
	}

	/**
	 * Sets the vector array and returns it.
	 *
	 * @param v0 Vector 0.
	 * @param v1 Vector 1.
	 * @param v2 Vector 2.
	 * @param v3 Vector 3.
	 * @return Vector array.
	 */
	private Vector3f[] setVectorArray(Vector3f v0, Vector3f v1, Vector3f v2, Vector3f v3) {
		vecArray[0] = v0;
		vecArray[1] = v1;
		vecArray[2] = v2;
		vecArray[3] = v3;
		return vecArray;
	}

	@Override
	public boolean intersectsBoundingSphere(BoundingSphere sphere) {
		return ((FastMath.abs(center.x - sphere.center.x) <= (sphere.radius + xExtent))
				&& (FastMath.abs(center.y - sphere.center.y) <= (sphere.radius + yExtent))
				&& (FastMath.abs(center.z - sphere.center.z) <= (sphere.radius + zExtent)));
	}

	@Override
	public boolean intersectsBoundingBox(BoundingBox box) {
		if (center.x + xExtent <= box.center.x - box.xExtent || center.x - xExtent >= box.center.x + box.xExtent) {
			return false;
		}
		if (center.y + yExtent <= box.center.y - box.yExtent || center.y - yExtent >= box.center.y + box.yExtent) {
			return false;
		}
		return center.z + zExtent > box.center.z - box.zExtent && center.z - zExtent < box.center.z + box.zExtent;
	}

	/**
	 * This method calculates the intersecting sides in a very performant way.
	 * It returns a List of int values, which gives the sides of the box, on
	 * which the intersection happened. The following values are the possible
	 * results: <ul> <li>1 - The front side intersects.</li> <li>2 - The back
	 * side intersects.</li> <li>3 - The top side intersects.</li> <li>4 - The
	 * bottom side intersects.</li> <li>5 - The left side intersects.</li> <li>6
	 * - The right side intersects.</li> <li>List empty - No side intersects.
	 * (This generally means, that no intersection happens!)</li> </ul> The
	 * given BoundingBox should be checked with the intersectsBoundingBogetX()
	 * method previously, because this one gives much more performance.
	 *
	 * @param box The BoundingBox on which the side intersection should be
	 * checked.
	 * @return Sides which intersects the other box.
	 */
	public List<Integer> getIntersectingSides(BoundingBox box) {
		List<Integer> results = new ArrayList<>(6);
		if (center.x + xExtent >= box.center.x - box.xExtent) {
			results.add(1);
		}
		if (center.x - xExtent <= box.center.x + box.xExtent) {
			results.add(2);
		}
		if (center.z + zExtent >= box.center.z - box.zExtent) {
			results.add(5);
		}
		if (center.z - zExtent <= box.center.z + box.zExtent) {
			results.add(6);
		}
		if (center.y + yExtent >= box.center.y - box.yExtent) {
			results.add(3);
		}
		if (center.y - yExtent <= box.center.y + box.yExtent) {
			results.add(4);
		}
		return results;
	}

	@Override
	public boolean intersects(BoundingVolume volume) {
		return volume.intersectsBoundingBox(this);
	}

	@Override
	public boolean intersects(Vector3f point) {
		if (center.x + xExtent <= point.x || center.x - xExtent >= point.x) {
			return false;
		} else if (center.y + yExtent <= point.y || center.y - yExtent >= point.y) {
			return false;
		}
		return center.z + zExtent > point.z && center.z - zExtent < point.z;
	}

	@Override
	public boolean contains(Vector3f point) {
		if (center.x + xExtent < point.x || center.x - xExtent > point.x) {
			return false;
		} else if (center.y + yExtent < point.y || center.y - yExtent > point.y) {
			return false;
		}
		return center.z + zExtent >= point.z && center.z - zExtent <= point.z;
	}

	@Override
	public float getVolume() {
		return xExtent * 2.0f * yExtent * 2.0f * zExtent * 2.0f;
	}
}
