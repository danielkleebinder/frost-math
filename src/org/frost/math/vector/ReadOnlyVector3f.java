package org.frost.math.vector;

/**
 * A vector holding 3 float values.
 * <br/>
 * The content of this vector can only be set in the constructor.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyVector3f extends Vector3f {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 1264875876541234L;

	/**
	 * Creates a new <code>ReadOnlyVector3f</code> instance with the default x,
	 * y and z values. ReadOnlyVector3f(0.0f, 0.0f, 0.0f).
	 */
	public ReadOnlyVector3f() {
		super();
	}

	/**
	 * Creates a new <code>ReadOnlyVector3f</code> instance with the given x, y
	 * and z values.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 * @param z The z value.
	 */
	public ReadOnlyVector3f(float x, float y, float z) {
		super(x, y, z);
	}

	/**
	 * Creates a new <code>ReadOnlyVector3f</code> instance with the given
	 * values.
	 *
	 * @param v Values.
	 */
	public ReadOnlyVector3f(float... v) {
		super(v);
	}

	/**
	 * Creates a new <code>ReadOnlyVector3f</code> instance from the given
	 * <code>Vector3f</code>.
	 *
	 * @param copy Vector from where the values are copied.
	 */
	public ReadOnlyVector3f(Vector3f copy) {
		super(copy);
	}

	@Override
	public Vector3f set(float x, float y, float z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f set(Vector3f vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public void setX(Float x) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public void setY(Float y) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public void setZ(Float z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f addLocal(Float v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f addLocal(Vector3f vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f addLocal(Float x, Float y, Float z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f subtractLocal(Float v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f subtractLocal(Vector3f vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f subtractLocal(Float x, Float y, Float z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f multiplicateLocal(Float v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f multiplicateLocal(Vector3f vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f multiplicateLocal(Float x, Float y, Float z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f divideLocal(Float v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f divideLocal(Vector3f vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f divideLocal(Float x, Float y, Float z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f minLocal(Vector3f vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f maxLocal(Vector3f vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f clampLocal(Vector3f vec1, Vector3f vec2) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f clamp(Float min, Float max) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f clampMax(Float max) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f clampMin(Float min) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f fill(Float v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f one() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f zero() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public void fromArray(Float... array) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f negateLocal() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f normalizeLocal() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3f put(int i, Float v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public ReadOnlyVector3f clone() throws CloneNotSupportedException {
		return (ReadOnlyVector3f) super.clone();
	}
}
