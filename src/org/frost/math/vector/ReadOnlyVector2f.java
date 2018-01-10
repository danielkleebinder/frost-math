package org.frost.math.vector;

/**
 * A vector holding 2 float values.
 * <br/>
 * The content of this vector can only be set in the constructor.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyVector2f extends Vector2f {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 98761497868134L;

	/**
	 * Creates a new <code>ReadOnlyVector2f</code> instance with the default x
	 * and y values. ReadOnlyVector2f(0.0f, 0.0f).
	 */
	public ReadOnlyVector2f() {
		super();
	}

	/**
	 * Creates a new <code>ReadOnlyVector2f</code> instance with the given x and
	 * y values.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 */
	public ReadOnlyVector2f(float x, float y) {
		super(x, y);
	}

	/**
	 * Creates a new <code>ReadOnlyVector2f</code> instance with the given
	 * values.
	 *
	 * @param v Values.
	 */
	public ReadOnlyVector2f(float... v) {
		super(v);
	}

	/**
	 * Creates a new <code>ReadOnlyVector2f</code> instance from the given
	 * <code>Vector2f</code>.
	 *
	 * @param copy Vector from where the values are copied.
	 */
	public ReadOnlyVector2f(Vector2f copy) {
		super(copy);
	}

	@Override
	public Vector2f addLocal(Vector2f vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f addLocal(Float x, Float y) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f addLocal(Float v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f divideLocal(Vector2f vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f divideLocal(Float scalar) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f divideLocal(Float x, Float y) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f multiplicateLocal(Vector2f vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f multiplicateLocal(Float scalar) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f multiplicateLocal(Float x, Float y) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f one() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f negateLocal() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f normalizeLocal() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f set(Vector2f vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f set(float x, float y) {
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
	public Vector2f subtractLocal(Vector2f vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f subtractLocal(Float x, Float y) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f subtractLocal(Float v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f zero() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public void fromArray(Float... array) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f put(int i, Float v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f fill(Float v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f maxLocal(Vector2f vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f minLocal(Vector2f vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f clampLocal(Vector2f vec1, Vector2f vec2) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f clamp(Float min, Float max) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f clampMax(Float max) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2f clampMin(Float min) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public ReadOnlyVector2f clone() throws CloneNotSupportedException {
		return (ReadOnlyVector2f) super.clone();
	}
}
