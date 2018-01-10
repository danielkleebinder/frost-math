package org.frost.math.vector;

/**
 * A vector holding 4 float values.
 * <br/>
 * The content of this vector can only be set in the constructor.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyVector4f extends Vector4f {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 116712566666125376L;

	/**
	 * Creates a new <code>ReadOnlyVector4f</code> instance with the default x,
	 * y, z and w values. ReadOnlyVector4f(0.0f, 0.0f, 0.0f, 0.0f).
	 */
	public ReadOnlyVector4f() {
		super();
	}

	/**
	 * Creates a new <code>ReadOnlyVector4f</code> instance with the given x, y,
	 * z and w values.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 * @param z The z value.
	 * @param w The w value.
	 */
	public ReadOnlyVector4f(float x, float y, float z, float w) {
		super(x, y, z, w);
	}

	/**
	 * Creates a new <code>ReadOnlyVector4f</code> instance with the given
	 * values.
	 *
	 * @param v Values.
	 */
	public ReadOnlyVector4f(float... v) {
		super(v);
	}

	/**
	 * Creates a new <code>ReadOnlyVector4f</code> instance from the given
	 * <code>Vector4f</code>.
	 *
	 * @param copy Vector from where the values are copied.
	 */
	public ReadOnlyVector4f(Vector4f copy) {
		super(copy);
	}

	@Override
	public Vector4f set(float x, float y, float z, float w) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f set(Vector4f vec) {
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
	public void setW(Float w) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f addLocal(Float v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f addLocal(Vector4f vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f addLocal(Float x, Float y, Float z, Float w) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f subtractLocal(Float v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f subtractLocal(Vector4f vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f subtractLocal(Float x, Float y, Float z, Float w) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f multiplicateLocal(Float v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f multiplicateLocal(Vector4f vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f multiplicateLocal(Float x, Float y, Float z, Float w) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f divideLocal(Float v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f divideLocal(Vector4f vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f divideLocal(Float x, Float y, Float z, Float w) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f maxLocal(Vector4f vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f minLocal(Vector4f vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f clampLocal(Vector4f vec1, Vector4f vec2) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f clamp(Float min, Float max) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f clampMax(Float max) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f clampMin(Float min) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f fill(Float v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f one() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f zero() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f negateLocal() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f normalizeLocal() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public void fromArray(Float... array) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4f put(int i, Float v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public ReadOnlyVector4f clone() throws CloneNotSupportedException {
		return (ReadOnlyVector4f) super.clone();
	}
}
