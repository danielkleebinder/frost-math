package org.frost.math.data;

import java.util.List;
import java.util.function.Function;
import org.frost.math.bounding.BoundingVolume;

/**
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class BoundingOctree<T> implements Octree<T, BoundingVolume> {

	private float looseness = 1.0f;

	@Override
	public void add(T obj, BoundingVolume loc) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean remove(T obj) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean remove(T obj, BoundingVolume loc) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean intersects(BoundingVolume loc) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean intersects(float ox, float oy, float oz, float dx, float dy, float dz, float maxDistance) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public List<T> intersectsNodes(BoundingVolume loc) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public List<T> intersectsNodes(float ox, float oy, float oz, float dx, float dy, float dz, float maxDistance) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void shrinkIfPossible(float minLength) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public BoundingVolume bounds() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public List<T> asList() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int size() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void searchBreadthFirst(Function<T, Boolean> foo) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void searchDepthFirst(Function<T, Boolean> foo) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void searchDepthFirstPostOrder(Function<T, Boolean> foo) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
