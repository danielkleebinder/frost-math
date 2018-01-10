package org.frost.math.bounding;

import java.util.Objects;
import org.frost.math.ray.Ray3f;
import org.frost.math.vector.Vector3f;

/**
 * Abstract class for all bounding volumes.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public abstract class BoundingVolume {

	/**
	 * Center point of the bounding.
	 */
	protected Vector3f center;

	/**
	 * Creates a new bounding volume.
	 */
	public BoundingVolume() {
		this(new Vector3f());
	}

	/**
	 * Creates a new bounding volume with the given center.
	 *
	 * @param center The center of the object.
	 */
	public BoundingVolume(Vector3f center) {
		this.center = center;
	}

	/**
	 * Returns the center of the bounding.
	 *
	 * @return Center.
	 */
	public Vector3f getCenter() {
		return center;
	}

	/**
	 * Sets the center of the bounding.
	 *
	 * @param center Center of the bounding.
	 */
	public void setCenter(Vector3f center) {
		this.center = center;
	}

	/**
	 * Test if the given ray intersects with this bounding volume.
	 *
	 * @param ray Ray.
	 * @return True if an intersection happened.
	 */
	public abstract boolean intersects(Ray3f ray);

	/**
	 * Tests if the given <code>BoundingSphere sphere</code> intersects with the
	 * <code>this</code> object.
	 *
	 * @param sphere Other collideable.
	 * @return True if an intersection happened.
	 */
	public abstract boolean intersectsBoundingSphere(BoundingSphere sphere);

	/**
	 * Tests if the given <code>BoundingBox box</code> intersects with the
	 * <code>this</code> object.
	 *
	 * @param box Other collideable
	 * @return True if an intersection happened.
	 */
	public abstract boolean intersectsBoundingBox(BoundingBox box);

	/**
	 * Tests if the given <code>BoundingVolume volume</code> intersects with the
	 * <code>this</code> object.
	 *
	 * @param volume Other collideable.
	 * @return True if an intersection happened.
	 */
	public abstract boolean intersects(BoundingVolume volume);

	/**
	 * Tests if the given <code>Vector3f point</code> <b>intersects</b>
	 * with the <code>this</code> object.
	 *
	 * @param point 3D-Point with which the collision should be tested.
	 * @return True if an intersection happened.
	 */
	public abstract boolean intersects(Vector3f point);

	/**
	 * Tests if the <code>this</code> object <b>contains</b> the given
	 * <code>Vector3f point</code>.
	 *
	 * @param point 3D-Point with which the collision should be tested.
	 * @return True if the this object contains the point.
	 */
	public abstract boolean contains(Vector3f point);

	/**
	 * Calculates the volume of the <code>this</code> object.
	 *
	 * @return The object volume.
	 */
	public abstract float getVolume();

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final BoundingVolume other = (BoundingVolume) obj;
		return Objects.equals(this.center, other.center);
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 67 * hash + Objects.hashCode(this.center);
		return hash;
	}
}
