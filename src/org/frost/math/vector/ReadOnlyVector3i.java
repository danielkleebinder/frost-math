package org.frost.math.vector;

/**
 * A vector holding 3 int values.
 * <br/>
 * The content of this vector can only be set in the constructor.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyVector3i extends Vector3i {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 1763851L;

	/**
	 * Creates a new <code>ReadOnlyVector3i</code> instance with the default x,
	 * y and z values. ReadOnlyVector3i(0.0, 0.0, 0.0).
	 */
	public ReadOnlyVector3i() {
		super();
	}

	/**
	 * Creates a new <code>ReadOnlyVector3i</code> instance with the given x, y
	 * and z values.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 * @param z The z value.
	 */
	public ReadOnlyVector3i(int x, int y, int z) {
		super(x, y, z);
	}

	/**
	 * Creates a new <code>ReadOnlyVector3i</code> instance with the given
	 * values.
	 *
	 * @param v Values.
	 */
	public ReadOnlyVector3i(int... v) {
		super(v);
	}

	/**
	 * Creates a new <code>ReadOnlyVector3i</code> instance from the given
	 * <code>Vector3i</code>.
	 *
	 * @param copy Vector from where the values are copied.
	 */
	public ReadOnlyVector3i(Vector3i copy) {
		super(copy);
	}

	@Override
	public Vector3i set(int x, int y, int z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i set(Vector3i vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public void setX(Integer x) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public void setY(Integer y) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public void setZ(Integer z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i addLocal(Integer v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i addLocal(Vector3i vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i addLocal(Integer x, Integer y, Integer z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i subtractLocal(Integer v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i subtractLocal(Vector3i vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i subtractLocal(Integer x, Integer y, Integer z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i multiplicateLocal(Integer v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i multiplicateLocal(Vector3i vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i multiplicateLocal(Integer x, Integer y, Integer z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i divideLocal(Integer v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i divideLocal(Vector3i vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i divideLocal(Integer x, Integer y, Integer z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i minLocal(Vector3i vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i maxLocal(Vector3i vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i clampLocal(Vector3i vec1, Vector3i vec2) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i clamp(Integer min, Integer max) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i clampMax(Integer max) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i clampMin(Integer min) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i fill(Integer v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i one() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i zero() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public void fromArray(Integer... array) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i negateLocal() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i normalizeLocal() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3i put(int i, Integer v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public ReadOnlyVector3i clone() throws CloneNotSupportedException {
		return (ReadOnlyVector3i) super.clone();
	}
}
