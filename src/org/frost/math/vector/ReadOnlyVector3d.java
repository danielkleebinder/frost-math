package org.frost.math.vector;

/**
 * A vector holding 3 double values.
 * <br/>
 * The content of this vector can only be set in the constructor.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyVector3d extends Vector3d {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 1763851L;

	/**
	 * Creates a new <code>ReadOnlyVector3d</code> instance with the default x,
	 * y and z values. ReadOnlyVector3d(0.0, 0.0, 0.0).
	 */
	public ReadOnlyVector3d() {
		super();
	}

	/**
	 * Creates a new <code>ReadOnlyVector3d</code> instance with the given x, y
	 * and z values.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 * @param z The z value.
	 */
	public ReadOnlyVector3d(double x, double y, double z) {
		super(x, y, z);
	}

	/**
	 * Creates a new <code>ReadOnlyVector3d</code> instance with the given
	 * values.
	 *
	 * @param v Values.
	 */
	public ReadOnlyVector3d(double... v) {
		super(v);
	}

	/**
	 * Creates a new <code>ReadOnlyVector3d</code> instance from the given
	 * <code>Vector3d</code>.
	 *
	 * @param copy Vector from where the values are copied.
	 */
	public ReadOnlyVector3d(Vector3d copy) {
		super(copy);
	}

	@Override
	public Vector3d set(double x, double y, double z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d set(Vector3d vec) {
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
	public Vector3d addLocal(Double v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d addLocal(Vector3d vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d addLocal(Double x, Double y, Double z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d subtractLocal(Double v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d subtractLocal(Vector3d vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d subtractLocal(Double x, Double y, Double z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d multiplicateLocal(Double v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d multiplicateLocal(Vector3d vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d multiplicateLocal(Double x, Double y, Double z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d divideLocal(Double v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d divideLocal(Vector3d vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d divideLocal(Double x, Double y, Double z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d minLocal(Vector3d vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d maxLocal(Vector3d vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d clampLocal(Vector3d vec1, Vector3d vec2) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d clamp(Double min, Double max) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d clampMax(Double max) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d clampMin(Double min) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d fill(Double v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d one() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d zero() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public void fromArray(Double... array) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d negateLocal() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d normalizeLocal() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3d put(int i, Double v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public ReadOnlyVector3d clone() throws CloneNotSupportedException {
		return (ReadOnlyVector3d) super.clone();
	}
}
