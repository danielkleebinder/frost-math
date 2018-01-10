package org.frost.math.vector;

import java.math.BigDecimal;

/**
 * A vector holding 3 big decimal values.
 * <br/>
 * The content of this vector can only be set in the constructor.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyVector3bd extends Vector3bd {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 1763851L;

	/**
	 * Creates a new <code>ReadOnlyVector3bd</code> instance with the default x,
	 * y and z values. ReadOnlyVector3bd(0.0, 0.0, 0.0).
	 */
	public ReadOnlyVector3bd() {
		super();
	}

	/**
	 * Creates a new <code>ReadOnlyVector3bd</code> instance with the given x, y
	 * and z values.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 * @param z The z value.
	 */
	public ReadOnlyVector3bd(BigDecimal x, BigDecimal y, BigDecimal z) {
		super(x, y, z);
	}

	/**
	 * Creates a new <code>ReadOnlyVector3bd</code> instance with the given
	 * values.
	 *
	 * @param v Values.
	 */
	public ReadOnlyVector3bd(BigDecimal... v) {
		super(v);
	}

	/**
	 * Creates a new <code>ReadOnlyVector3bd</code> instance from the given
	 * <code>Vector3bd</code>.
	 *
	 * @param copy Vector from where the values are copied.
	 */
	public ReadOnlyVector3bd(Vector3bd copy) {
		super(copy);
	}

	@Override
	public Vector3bd set(BigDecimal x, BigDecimal y, BigDecimal z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd set(Vector3bd vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public void setX(BigDecimal x) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public void setY(BigDecimal y) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public void setZ(BigDecimal z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd addLocal(BigDecimal v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd addLocal(Vector3bd vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd addLocal(BigDecimal x, BigDecimal y, BigDecimal z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd subtractLocal(BigDecimal v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd subtractLocal(Vector3bd vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd subtractLocal(BigDecimal x, BigDecimal y, BigDecimal z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd multiplicateLocal(BigDecimal v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd multiplicateLocal(Vector3bd vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd multiplicateLocal(BigDecimal x, BigDecimal y, BigDecimal z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd divideLocal(BigDecimal v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd divideLocal(Vector3bd vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd divideLocal(BigDecimal x, BigDecimal y, BigDecimal z) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd minLocal(Vector3bd vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd maxLocal(Vector3bd vec) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd clampLocal(Vector3bd vec1, Vector3bd vec2) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd clamp(BigDecimal min, BigDecimal max) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd clampMax(BigDecimal max) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd clampMin(BigDecimal min) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd fill(BigDecimal v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd one() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd zero() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public void fromArray(BigDecimal... array) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd negateLocal() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd normalizeLocal() {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public Vector3bd put(int i, BigDecimal v) {
		throw new UnsupportedOperationException("Read only vector does not support this operation");
	}

	@Override
	public ReadOnlyVector3bd clone() throws CloneNotSupportedException {
		return (ReadOnlyVector3bd) super.clone();
	}
}
