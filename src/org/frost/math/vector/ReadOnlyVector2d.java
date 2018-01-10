package org.frost.math.vector;

/**
 * A vector holding 2 double values.
 * <br/>
 * The content of this vector can only be set in the constructor.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyVector2d extends Vector2d {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 214824L;

	/**
	 * Creates a new <code>ReadOnlyVector2d</code> instance with the default x
	 * and y values. ReadOnlyVector2d(0.0, 0.0).
	 */
	public ReadOnlyVector2d() {
		super();
	}

	/**
	 * Creates a new <code>ReadOnlyVector2d</code> instance with the given x and
	 * y values.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 */
	public ReadOnlyVector2d(double x, double y) {
		super(x, y);
	}

	/**
	 * Creates a new <code>ReadOnlyVector2d</code> instance with the given
	 * values.
	 *
	 * @param v Values.
	 */
	public ReadOnlyVector2d(double... v) {
		super(v);
	}

	/**
	 * Creates a new <code>ReadOnlyVector2d</code> instance from the given
	 * <code>Vector2d</code>.
	 *
	 * @param copy Vector from where the values are copied.
	 */
	public ReadOnlyVector2d(Vector2d copy) {
		super(copy);
	}

	@Override
	public Vector2d addLocal(Vector2d vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d addLocal(Double x, Double y) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d addLocal(Double v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d divideLocal(Vector2d vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d divideLocal(Double scalar) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d divideLocal(Double x, Double y) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d multiplicateLocal(Vector2d vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d multiplicateLocal(Double scalar) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d multiplicateLocal(Double x, Double y) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d one() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d negateLocal() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d normalizeLocal() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d set(Vector2d vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d set(double x, double y) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public void setX(Double x) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public void setY(Double y) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d subtractLocal(Vector2d vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d subtractLocal(Double x, Double y) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d subtractLocal(Double v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d zero() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public void fromArray(Double... array) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d put(int i, Double v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d fill(Double v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d maxLocal(Vector2d vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d minLocal(Vector2d vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d clampLocal(Vector2d vec1, Vector2d vec2) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d clamp(Double min, Double max) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d clampMax(Double max) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector2d clampMin(Double min) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public ReadOnlyVector2d clone() throws CloneNotSupportedException {
		return (ReadOnlyVector2d) super.clone();
	}
}
