package org.frost.math;

import org.frost.math.matrix.Matrix3f;
import org.frost.math.vector.Vector3f;

/**
 * <code>Quaternion</code> defines a single example of a more general class of
 * hypercomplex numbers. Quaternions extends a rotation in three dimensions to a
 * rotation in four dimensions.
 * <br/>
 * The content of this matrix can only be set in the<br/>
 * constructor.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ReadOnlyQuaternion extends Quaternion {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 987999679891968964L;

	/**
	 * Creates a new quaternion with the default identity values. Quaternion(0,
	 * 0, 0, 1).
	 */
	public ReadOnlyQuaternion() {
		super();
	}

	/**
	 * Creates a new quaternion with the given values.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 * @param z The z value.
	 * @param w The w value.
	 */
	public ReadOnlyQuaternion(float x, float y, float z, float w) {
		super(x, y, z, w);
	}

	/**
	 * Creates a new <code>Quaternion</code> instance from the given
	 * <code>Quaternion</code>.
	 *
	 * @param copy Quaternion from where the values are copied.
	 */
	public ReadOnlyQuaternion(Quaternion copy) {
		super(copy);
	}

	@Override
	public Quaternion addLocal(Quaternion quat) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion addLocal(Vector3f vec) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion apply(Matrix3f mat) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion fromAngleAxis(float angle, Vector3f axis) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion fromAngleNormalAxis(float angle, Vector3f axis) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion fromAngles(Vector3f angles) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion fromAngles(float... angles) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion fromAngles(float xAngle, float yAngle, float zAngle) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion fromAxes(Vector3f xAxis, Vector3f yAxis, Vector3f zAxis) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public void fromArray(Float... array) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion fromRotationMatrix(Matrix3f mat) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion fromRotationMatrix(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion identity() {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion inverseLocal() {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public void lookAt(Vector3f direction, Vector3f up) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion multiplicateLocal(Quaternion quat) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion multiplicateLocal(Vector3f vec) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion multiplicateLocal(float scalar) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion negateLocal() {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion nlerp(Quaternion q2, float t) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion normalizeLocal() {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion oppositeLocal() {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion set(Quaternion quat) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion set(float x, float y, float z, float w) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public void setW(float w) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public void setX(float x) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public void setY(float y) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public void setZ(float z) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion slerp(Quaternion q2, float t) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion slerp(Quaternion q1, Quaternion q2, float t) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion subtractLocal(Quaternion quat) {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public Quaternion zero() {
		throw new UnsupportedOperationException("Read only quaternion does not support this operation");
	}

	@Override
	public ReadOnlyQuaternion clone() throws CloneNotSupportedException {
		return (ReadOnlyQuaternion) super.clone();
	}
}
