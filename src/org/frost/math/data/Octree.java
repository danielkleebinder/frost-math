package org.frost.math.data;

import java.util.List;
import org.frost.math.ray.Ray3d;
import org.frost.math.ray.Ray3f;
import org.frost.math.ray.Ray3i;

/**
 * An octree is a tree data structure in which each internal node has exactly
 * eight children. Octrees are most often used to partition a three-dimensional
 * space by recursively subdividing it into eight octants. Octrees are the
 * three-dimensional analog of quadtrees. The name is formed from oct + tree,
 * but note that it is normally written "octree" with only one "t". Octrees are
 * often used in 3D graphics and 3D game engines.
 *
 * @see
 * https://github.com/Nition/UnityOctree/blob/master/Scripts/BoundsOctree.cs
 * @author Daniel Kleebinder
 * @param <T> Stored object type.
 * @param <D> Data structure type.
 * @since 1.0.0
 */
public interface Octree<T, D> extends TreeSearch<T> {

	/**
	 * Adds the given object at the given location.
	 *
	 * @param obj Object.
	 * @param loc Location.
	 */
	void add(T obj, D loc);

	/**
	 * Removes the given object from the octree.
	 *
	 * @param obj Object.
	 * @return True if the object was successfully removed, otherwise false.
	 */
	boolean remove(T obj);

	/**
	 * Removes the given object from the octree using the given location.
	 *
	 * @param obj Object.
	 * @param loc Location.
	 * @return True if the object was successfully removed, otherwise false.
	 */
	boolean remove(T obj, D loc);

	/**
	 * Checks if the given data structure intersects with any node in the
	 * octree.
	 *
	 * @param loc Data structure.
	 * @return True if an intersection happened, otherwise false.
	 */
	boolean intersects(D loc);

	/**
	 * Checks if the given ray intersects with any node in the octree.
	 *
	 * @param ox Origin X.
	 * @param oy Origin Y.
	 * @param oz Origin Z.
	 * @param dx Direction X.
	 * @param dy Direction Y.
	 * @param dz Direction Z.
	 * @param maxDistance Max ray distance.
	 * @return True if an intersection happened, otherwise false.
	 */
	boolean intersects(float ox, float oy, float oz, float dx, float dy, float dz, float maxDistance);

	/**
	 * Checks if the given ray intersects with any node in the octree.
	 *
	 * @param ox Origin X.
	 * @param oy Origin Y.
	 * @param oz Origin Z.
	 * @param dx Direction X.
	 * @param dy Direction Y.
	 * @param dz Direction Z.
	 * @return True if an intersection happened, otherwise false.
	 */
	default boolean intersects(float ox, float oy, float oz, float dx, float dy, float dz) {
		return intersects(ox, oy, oz, dx, dy, dz, Float.POSITIVE_INFINITY);
	}

	/**
	 * Checks if the given ray intersects with any node in the octree.
	 *
	 * @param ray Ray.
	 * @param maxDistance Max ray distance.
	 * @return True if an intersection happened, otherwise false.
	 */
	default boolean intersects(Ray3f ray, float maxDistance) {
		return intersects(
				ray.origin.x, ray.origin.y, ray.origin.z,
				ray.direction.x, ray.direction.y, ray.direction.z,
				maxDistance
		);
	}

	/**
	 * Checks if the given ray intersects with any node in the octree.
	 *
	 * @param ray Ray.
	 * @return True if an intersection happened, otherwise false.
	 */
	default boolean intersects(Ray3f ray) {
		return intersects(ray, Float.POSITIVE_INFINITY);
	}

	/**
	 * Checks if the given ray intersects with any node in the octree.
	 *
	 * @param ray Ray.
	 * @param maxDistance Max ray distance.
	 * @return True if an intersection happened, otherwise false.
	 */
	default boolean intersects(Ray3d ray, float maxDistance) {
		return intersects(
				(float) ray.origin.x, (float) ray.origin.y, (float) ray.origin.z,
				(float) ray.direction.x, (float) ray.direction.y, (float) ray.direction.z,
				maxDistance
		);
	}

	/**
	 * Checks if the given ray intersects with any node in the octree.
	 *
	 * @param ray Ray.
	 * @return True if an intersection happened, otherwise false.
	 */
	default boolean intersects(Ray3d ray) {
		return intersects(ray, Float.POSITIVE_INFINITY);
	}

	/**
	 * Checks if the given ray intersects with any node in the octree.
	 *
	 * @param ray Ray.
	 * @param maxDistance Max ray distance.
	 * @return True if an intersection happened, otherwise false.
	 */
	default boolean intersects(Ray3i ray, float maxDistance) {
		return intersects(
				ray.origin.x, ray.origin.y, ray.origin.z,
				ray.direction.x, ray.direction.y, ray.direction.z,
				maxDistance
		);
	}

	/**
	 * Checks if the given ray intersects with any node in the octree.
	 *
	 * @param ray Ray.
	 * @return True if an intersection happened, otherwise false.
	 */
	default boolean intersects(Ray3i ray) {
		return intersects(ray, Float.POSITIVE_INFINITY);
	}

	/**
	 * Checks if the given data structure intersects with any node in the octree
	 * and returns the intersections as list.
	 *
	 * @param loc Data structure.
	 * @return Intersecting nodes.
	 */
	List<T> intersectsNodes(D loc);

	/**
	 * Checks if the given ray intersects with any node in the octree and
	 * returns the intersections as list.
	 *
	 * @param ox Origin X.
	 * @param oy Origin Y.
	 * @param oz Origin Z.
	 * @param dx Direction X.
	 * @param dy Direction Y.
	 * @param dz Direction Z.
	 * @param maxDistance Max ray distance.
	 * @return Intersecting nodes.
	 */
	List<T> intersectsNodes(float ox, float oy, float oz, float dx, float dy, float dz, float maxDistance);

	/**
	 * Checks if the given ray intersects with any node in the octree and
	 * returns the intersections as list.
	 *
	 * @param ox Origin X.
	 * @param oy Origin Y.
	 * @param oz Origin Z.
	 * @param dx Direction X.
	 * @param dy Direction Y.
	 * @param dz Direction Z.
	 * @return Intersecting nodes.
	 */
	default List<T> intersectsNodes(float ox, float oy, float oz, float dx, float dy, float dz) {
		return intersectsNodes(ox, oy, oz, dx, dy, dz, Float.POSITIVE_INFINITY);
	}

	/**
	 * Checks if the given ray intersects with any node in the octree and
	 * returns the intersections as list.
	 *
	 * @param ray Ray.
	 * @param maxDistance Max ray distance.
	 * @return Intersecting nodes.
	 */
	default List<T> intersectsNodes(Ray3f ray, float maxDistance) {
		return intersectsNodes(
				ray.origin.x, ray.origin.y, ray.origin.z,
				ray.direction.x, ray.direction.y, ray.direction.z,
				maxDistance
		);
	}

	/**
	 * Checks if the given ray intersects with any node in the octree and
	 * returns the intersections as list.
	 *
	 * @param ray Ray.
	 * @return Intersecting nodes.
	 */
	default List<T> intersectsNodes(Ray3f ray) {
		return intersectsNodes(ray, Float.POSITIVE_INFINITY);
	}

	/**
	 * Checks if the given ray intersects with any node in the octree and
	 * returns the intersections as list.
	 *
	 * @param ray Ray.
	 * @param maxDistance Max ray distance.
	 * @return Intersecting nodes.
	 */
	default List<T> intersectsNodes(Ray3d ray, float maxDistance) {
		return intersectsNodes(
				(float) ray.origin.x, (float) ray.origin.y, (float) ray.origin.z,
				(float) ray.direction.x, (float) ray.direction.y, (float) ray.direction.z,
				maxDistance
		);
	}

	/**
	 * Checks if the given ray intersects with any node in the octree and
	 * returns the intersections as list.
	 *
	 * @param ray Ray.
	 * @return Intersecting nodes.
	 */
	default List<T> intersectsNodes(Ray3d ray) {
		return intersectsNodes(ray, Float.POSITIVE_INFINITY);
	}

	/**
	 * Checks if the given ray intersects with any node in the octree and
	 * returns the intersections as list.
	 *
	 * @param ray Ray.
	 * @param maxDistance Max ray distance.
	 * @return Intersecting nodes.
	 */
	default List<T> intersectsNodes(Ray3i ray, float maxDistance) {
		return intersectsNodes(
				ray.origin.x, ray.origin.y, ray.origin.z,
				ray.direction.x, ray.direction.y, ray.direction.z,
				maxDistance
		);
	}

	/**
	 * Checks if the given ray intersects with any node in the octree and
	 * returns the intersections as list.
	 *
	 * @param ray Ray.
	 * @return Intersecting nodes.
	 */
	default List<T> intersectsNodes(Ray3i ray) {
		return intersectsNodes(ray, Float.POSITIVE_INFINITY);
	}

	/**
	 * Shrinks the octree if this is possible.
	 *
	 * @param minLength Minimum dimensions of a node in the octree.
	 */
	void shrinkIfPossible(float minLength);

	/**
	 * Returns the bounds of the whole octree.
	 *
	 * @return Bounds of the whole octree.
	 */
	D bounds();

	/**
	 * Returns all objects in the octree as list.
	 *
	 * @return List.
	 */
	List<T> asList();

	/**
	 * Returns the current number of objects in the octree.
	 *
	 * @return Number of objects in the octree.
	 */
	int size();
}
