package org.frost.math.vector;

/**
 * A vector holding 4 double values.
 * <br/>
 * The content of this vector can only be set in the constructor.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyVector4d extends Vector4d {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 51637487L;

	/**
	 * Creates a new <code>ReadOnlyVector4d</code> instance with the default x,
	 * y, z and w values. ReadOnlyVector4d(0.0, 0.0, 0.0, 0.0).
	 */
	public ReadOnlyVector4d() {
		super();
	}

	/**
	 * Creates a new <code>ReadOnlyVector4d</code> instance with the given x, y,
	 * z and w values.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 * @param z The z value.
	 * @param w The w value.
	 */
	public ReadOnlyVector4d(double x, double y, double z, double w) {
		super(x, y, z, w);
	}

	/**
	 * Creates a new <code>ReadOnlyVector4d</code> instance with the given
	 * values.
	 *
	 * @param v Values.
	 */
	public ReadOnlyVector4d(double... v) {
		super(v);
	}

	/**
	 * Creates a new <code>ReadOnlyVector4d</code> instance from the given
	 * <code>Vector4d</code>.
	 *
	 * @param copy Vector from where the values are copied.
	 */
	public ReadOnlyVector4d(Vector4d copy) {
		super(copy);
	}

	@Override
	public Vector4d set(double x, double y, double z, double w) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d set(Vector4d vec) {
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
	public void setZ(Double z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public void setW(Double w) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d addLocal(Double v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d addLocal(Vector4d vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d addLocal(Double x, Double y, Double z, Double w) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d subtractLocal(Double v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d subtractLocal(Vector4d vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d subtractLocal(Double x, Double y, Double z, Double w) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d multiplicateLocal(Double v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d multiplicateLocal(Vector4d vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d multiplicateLocal(Double x, Double y, Double z, Double w) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d divideLocal(Double v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d divideLocal(Vector4d vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d divideLocal(Double x, Double y, Double z, Double w) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d maxLocal(Vector4d vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d minLocal(Vector4d vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d clampLocal(Vector4d vec1, Vector4d vec2) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d clamp(Double min, Double max) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d clampMax(Double max) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d clampMin(Double min) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d fill(Double v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d one() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d zero() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d negateLocal() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d normalizeLocal() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public void fromArray(Double... array) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector4d put(int i, Double v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public ReadOnlyVector4d clone() throws CloneNotSupportedException {
		return (ReadOnlyVector4d) super.clone();
	}
}
