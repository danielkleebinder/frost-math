package org.frost.math.vector;

/**
 * A vector holding 4 int values.
 * <br/>
 * The content of this vector can only be set in the constructor.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyVector4i extends Vector4i {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 51637487L;

	/**
	 * Creates a new <code>ReadOnlyVector4i</code> instance with the default x,
	 * y, z and w values. ReadOnlyVector4i(0, 0, 0, 0).
	 */
	public ReadOnlyVector4i() {
		super();
	}

	/**
	 * Creates a new <code>ReadOnlyVector4i</code> instance with the given x, y,
	 * z and w values.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 * @param z The z value.
	 * @param w The w value.
	 */
	public ReadOnlyVector4i(int x, int y, int z, int w) {
		super(x, y, z, w);
	}

	/**
	 * Creates a new <code>ReadOnlyVector4i</code> instance with the given
	 * values.
	 *
	 * @param v Values.
	 */
	public ReadOnlyVector4i(int... v) {
		super(v);
	}

	/**
	 * Creates a new <code>ReadOnlyVector4i</code> instance from the given
	 * <code>Vector4i</code>.
	 *
	 * @param copy Vector from where the values are copied.
	 */
	public ReadOnlyVector4i(Vector4i copy) {
		super(copy);
	}

	@Override
	public Vector4i set(int x, int y, int z, int w) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i set(Vector4i vec) {
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
	public void setW(Integer w) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i addLocal(Integer v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i addLocal(Vector4i vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i addLocal(Integer x, Integer y, Integer z, Integer w) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i subtractLocal(Integer v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i subtractLocal(Vector4i vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i subtractLocal(Integer x, Integer y, Integer z, Integer w) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i multiplicateLocal(Integer v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i multiplicateLocal(Vector4i vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i multiplicateLocal(Integer x, Integer y, Integer z, Integer w) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i divideLocal(Integer v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i divideLocal(Vector4i vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i divideLocal(Integer x, Integer y, Integer z, Integer w) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i maxLocal(Vector4i vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i minLocal(Vector4i vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i clampLocal(Vector4i vec1, Vector4i vec2) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i clamp(Integer min, Integer max) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i clampMax(Integer max) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i clampMin(Integer min) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i fill(Integer v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i one() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i zero() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i negateLocal() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i normalizeLocal() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public void fromArray(Integer... array) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4i put(int i, Integer v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public ReadOnlyVector4i clone() throws CloneNotSupportedException {
		return (ReadOnlyVector4i) super.clone();
	}
}
