package org.frost.math.bounding;

import org.frost.math.FastMath;
import org.frost.math.ray.Ray3f;
import org.frost.math.vector.Vector3f;

/**
 * A bounding sphere is a sphere containing a 3D object.
 * <br/>
 * A bounding sphere is used to test if one object intersects with another one.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class BoundingSphere extends BoundingVolume {

	/**
	 * Sphere radius.
	 */
	protected float radius;

	/**
	 * Creates a new bounding sphere instance with center value Vector3f(0, 0,
	 * 0) and radius 0.
	 */
	public BoundingSphere() {
		this(new Vector3f(), 0);
	}

	/**
	 * Creates a new bounding sphere instance with the given center and the
	 * radius 0.
	 *
	 * @param center Boundings center.
	 */
	public BoundingSphere(Vector3f center) {
		this(center, 0);
	}

	/**
	 * Creates a new bounding sphere instance with the given radius and the
	 * center of Vector3f(0, 0, 0).
	 *
	 * @param radius Boundings radius.
	 */
	public BoundingSphere(float radius) {
		this(new Vector3f(), radius);
	}

	/**
	 * Creates a new bounding sphere instance with the given values.
	 *
	 * @param center Boundings center.
	 * @param radius Boundings radius.
	 */
	public BoundingSphere(Vector3f center, float radius) {
		super(center);
		if (radius < 0) {
			throw new IllegalArgumentException("The radius of the bounding sphere is negative!");
		}
		this.radius = radius;
	}

	/**
	 * Creates a new bounding sphere instance with the default values (All 0).
	 *
	 * @return New bounding sphere instance.
	 */
	public static BoundingSphere createBoundingSphere() {
		return new BoundingSphere();
	}

	/**
	 * Creates a new bounding sphere instance with the given center and a radius
	 * of 0.
	 *
	 * @param center Boundings center.
	 * @return New bounding sphere instance.
	 */
	public static BoundingSphere createBoundingSphere(Vector3f center) {
		return new BoundingSphere(center);
	}

	/**
	 * Creates a new bounding sphere instance with the given radius and a center
	 * of Vector3f(0, 0, 0).
	 *
	 * @param radius Boundings radius.
	 * @return New bounding sphere instance.
	 */
	public static BoundingSphere createBoundingSphere(float radius) {
		return new BoundingSphere(radius);
	}

	/**
	 * Creates a new bounding sphere instance with the given values.
	 *
	 * @param center Boundings center.
	 * @param radius Boundings radius.
	 * @return New bounding sphere instance.
	 */
	public static BoundingSphere createBoundingSphere(Vector3f center, float radius) {
		return new BoundingSphere(center, radius);
	}

	/**
	 * Creates a new bounding sphere instance around the given bounding box.
	 *
	 * @param box Box around which a bounding sphere should be created.
	 * @return New bounding sphere instance.
	 */
	public static BoundingSphere createBoundingSphere(BoundingBox box) {
		return new BoundingSphere(box.center, FastMath.max(FastMath.max(box.xExtent, box.zExtent), box.yExtent));
	}

	@Override
	public boolean intersectsBoundingSphere(BoundingSphere sphere) {
		float r = radius + sphere.radius;
		return center.distanceSquared(sphere.center) <= (r * r);
	}

	@Override
	public boolean intersectsBoundingBox(BoundingBox box) {
		return ((FastMath.abs(box.center.x - center.x) <= (radius + box.xExtent))
				&& (FastMath.abs(box.center.y - center.y) <= (radius + box.yExtent))
				&& (FastMath.abs(box.center.z - center.z) <= (radius + box.zExtent)));
	}

	@Override
	public boolean intersects(BoundingVolume volume) {
		return volume.intersectsBoundingSphere(this);
	}

	@Override
	public boolean intersects(Vector3f point) {
		return center.distanceSquared(point) <= (radius * radius);
	}

	@Override
	public boolean contains(Vector3f point) {
		return center.distanceSquared(point) < (radius * radius);
	}

	@Override
	public float getVolume() {
		return (float) ((4.0f * FastMath.pow(radius, 3.0f) * FastMath.PI) / 3.0f);
	}

	@Override
	public boolean intersects(Ray3f ray) {
		return rayCast(ray);
	}

	/**
	 * Makes a ray cast for the bounding sphere.
	 *
	 * @param ray Ray with which the intersection should be tested.
	 * @return True if an intersection happens, otherwise false.
	 */
	public boolean rayCast(Ray3f ray) {
		float a = (float) ray.direction.dot(ray.direction);
		float b = (float) ray.direction.dot(ray.origin) * 2.0f;
		float c = (float) ray.origin.dot(ray.origin) - (radius * radius);
		float d = b * b - 4 * a * c;

		if (d < 0) {
			return false;
		}

		float dist = FastMath.sqrt(d);
		float q;

		if (b < 0) {
			q = (-b - dist) / 2.0f;
		} else {
			q = (-b + dist) / 2.0f;
		}

		float t0 = q / a;
		float t1 = c / q;

		if (t0 > t1) {
			t1 = t0;
		}

		return t1 >= 0;
	}

	/**
	 * Sets the radius of the bounding sphere.
	 *
	 * @param radius New radius.
	 */
	public void setRadius(float radius) {
		this.radius = radius;
	}

	/**
	 * Returns the radius of the bounding sphere.
	 *
	 * @return Radius.
	 */
	public float getRadius() {
		return radius;
	}
}
