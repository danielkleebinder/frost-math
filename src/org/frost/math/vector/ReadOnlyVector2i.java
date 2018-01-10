package org.frost.math.vector;

/**
 * A vector holding 2 int values.
 * <br/>
 * The content of this vector can only be set in the constructor.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyVector2i extends Vector2i {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 214824L;

	/**
	 * Creates a new <code>ReadOnlyVector2i</code> instance with the default x
	 * and y values. ReadOnlyVector2i(0.0, 0.0).
	 */
	public ReadOnlyVector2i() {
		super();
	}

	/**
	 * Creates a new <code>ReadOnlyVector2i</code> instance with the given x and
	 * y values.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 */
	public ReadOnlyVector2i(int x, int y) {
		super(x, y);
	}

	/**
	 * Creates a new <code>ReadOnlyVector2i</code> instance with the given
	 * values.
	 *
	 * @param v Values.
	 */
	public ReadOnlyVector2i(int... v) {
		super(v);
	}

	/**
	 * Creates a new <code>ReadOnlyVector2i</code> instance from the given
	 * <code>Vector2i</code>.
	 *
	 * @param copy Vector from where the values are copied.
	 */
	public ReadOnlyVector2i(Vector2i copy) {
		super(copy);
	}

	@Override
	public Vector2i addLocal(Vector2i vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i addLocal(Integer x, Integer y) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i addLocal(Integer v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i divideLocal(Vector2i vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i divideLocal(Integer scalar) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i divideLocal(Integer x, Integer y) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i multiplicateLocal(Vector2i vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i multiplicateLocal(Integer scalar) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i multiplicateLocal(Integer x, Integer y) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i one() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i negateLocal() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i normalizeLocal() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i set(Vector2i vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i set(int x, int y) {
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
	public Vector2i subtractLocal(Vector2i vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i subtractLocal(Integer x, Integer y) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i subtractLocal(Integer v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i zero() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public void fromArray(Integer... array) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i put(int i, Integer v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i fill(Integer v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i maxLocal(Vector2i vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i minLocal(Vector2i vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i clampLocal(Vector2i vec1, Vector2i vec2) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i clamp(Integer min, Integer max) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i clampMax(Integer max) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2i clampMin(Integer min) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public ReadOnlyVector2i clone() throws CloneNotSupportedException {
		return (ReadOnlyVector2i) super.clone();
	}
}
