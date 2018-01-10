package org.frost.math;

import java.io.Serializable;
import org.frost.math.matrix.Matrix3f;
import org.frost.math.matrix.Matrix4f;
import org.frost.math.vector.Vector3f;

/**
 * <code>Quaternion</code> defines a single example of a more general class of
 * hypercomplex numbers. Quaternions extends a rotation in three dimensions to a
 * rotation in four dimensions.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Quaternion implements Cloneable, Serializable, Bufferable<Float> {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 98888798628346928L;

	/**
	 * The identity quaternion. Quaternion(0, 0, 0, 1).
	 */
	public static final Quaternion IDENTITY = new ReadOnlyQuaternion(0.0f, 0.0f, 0.0f, 1.0f);
	/**
	 * The zero quaternion. Quaternion(0, 0, 0, 0).
	 */
	public static final Quaternion ZERO = new ReadOnlyQuaternion(0.0f, 0.0f, 0.0f, 0.0f);

	/**
	 * The x value of the quaternion.
	 */
	public float x;
	/**
	 * The y value of the quaternion.
	 */
	public float y;
	/**
	 * The z value of the quaternion.
	 */
	public float z;
	/**
	 * The w value of the quaternion.
	 */
	public float w;

	/**
	 * Creates a new quaternion with the default identity values. Quaternion(0,
	 * 0, 0, 1).
	 */
	public Quaternion() {
		this(0.0f, 0.0f, 0.0f, 1.0f);
	}

	/**
	 * Creates a new quaternion with the given values.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 * @param z The z value.
	 * @param w The w value.
	 */
	public Quaternion(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	/**
	 * Creates a new <code>Quaternion</code> instance from the given
	 * <code>Quaternion</code>.
	 *
	 * @param copy Quaternion from where the values are copied.
	 */
	public Quaternion(Quaternion copy) {
		x = copy.x;
		y = copy.y;
		z = copy.z;
		w = copy.w;
	}

	/**
	 * Sets the quaternions x, y and z values to the given ones.
	 *
	 * @param x The new x value.
	 * @param y The new y value.
	 * @param z The new z value.
	 * @param w The new w value.
	 * @return This quaternion.
	 */
	public Quaternion set(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		return this;
	}

	/**
	 * Sets the quaternions x, y and z values to them from the given quaternion.
	 *
	 * @param quat Copy quaternion.
	 * @return This quaternion.
	 */
	public Quaternion set(Quaternion quat) {
		x = quat.x;
		y = quat.y;
		z = quat.z;
		w = quat.w;
		return this;
	}

	/**
	 * Sets all quaternion values to zero.
	 *
	 * @return This quaternion.
	 */
	public Quaternion zero() {
		x = y = z = w = 0;
		return this;
	}

	/**
	 * Sets the quaternion to the identity.
	 *
	 * @return This quaternion.
	 */
	public Quaternion identity() {
		x = y = z = 0;
		w = 1;
		return this;
	}

	/**
	 * If this quaternion is a zero quaternion, true will be returned, otherwise
	 * false.
	 *
	 * @return If zero quaternion or not.
	 */
	public boolean isZero() {
		return (x == 0 && y == 0 && z == 0 && w == 0);
	}

	/**
	 * If this quaternion is a identity quaternion, true will be returned,
	 * otherwise false.
	 *
	 * @return If identity quaternion or not.
	 */
	public boolean isIdentity() {
		return (x == 0 && y == 0 && z == 0 && w == 1);
	}

	/**
	 * Builds a quaternion from the Euler rotation angles (y, r, p).
	 *
	 * @param angles Euler angles (in radians).
	 * @return This quaternion.
	 */
	public Quaternion fromAngles(Vector3f angles) {
		return fromAngles(angles.x, angles.y, angles.z);
	}

	/**
	 * Builds a quaternion from the Euler rotation angles (y, r, p).
	 *
	 * @param angles Euler angles (in radians).
	 * @return This quaternion.
	 */
	public Quaternion fromAngles(float... angles) {
		if (angles.length != 3) {
			throw new IllegalArgumentException("Angles array must have three elements");
		}

		return fromAngles(angles[0], angles[1], angles[2]);
	}

	/**
	 * Builds a quaternion from the Euler rotation angles (y, r, p).
	 *
	 * @param xAngle Euler angle x (in radians).
	 * @param yAngle Euler angle y (in radians).
	 * @param zAngle Euler angle z (in radians).
	 * @return This quaternion.
	 */
	public Quaternion fromAngles(float xAngle, float yAngle, float zAngle) {
		float angle;
		float sinX, sinY, sinZ;
		float cosX, cosY, cosZ;

		angle = xAngle * 0.5f;
		sinX = (float) FastMath.sin(angle);
		cosX = (float) FastMath.cos(angle);

		angle = yAngle * 0.5f;
		sinY = (float) FastMath.sin(angle);
		cosY = (float) FastMath.cos(angle);

		angle = zAngle * 0.5f;
		sinZ = (float) FastMath.sin(angle);
		cosZ = (float) FastMath.cos(angle);

		float cosYXcosZ = cosY * cosZ;
		float sinYXsinZ = sinY * sinZ;
		float cosYXsinZ = cosY * sinZ;
		float sinYXcosZ = sinY * cosZ;

		w = cosYXcosZ * cosX - sinYXsinZ * sinX;
		x = cosYXcosZ * sinX + sinYXsinZ * cosX;
		y = sinYXcosZ * cosX + cosYXsinZ * sinX;
		z = cosYXsinZ * cosX - sinYXcosZ * sinX;

		normalizeLocal();
		return this;
	}

	/**
	 * Calculates the Euler rotation angles (y, r, p) from this quaternion.
	 *
	 * @return Angles.
	 */
	public Vector3f toAngles() {
		Vector3f dest = new Vector3f();

		float sqw = w * w;
		float sqx = x * x;
		float sqy = y * y;
		float sqz = z * z;
		float unit = sqx + sqy + sqz + sqw;

		float test = x * y + z * w;
		if (test > 0.499 * unit) {
			dest.y = 2.0f * (float) FastMath.atan2(x, w);
			dest.z = (float) FastMath.HALF_PI;
			dest.x = 0.0f;
		} else if (test < -0.499 * unit) {
			dest.y = -2.0f * (float) FastMath.atan2(x, w);
			dest.z = (float) -FastMath.HALF_PI;
			dest.x = 0.0f;
		} else {
			dest.y = (float) FastMath.atan2(2.0f * y * w - 2.0f * x * z, sqx - sqy - sqz + sqw);
			dest.z = (float) FastMath.asin(2.0f * test / unit);
			dest.x = (float) FastMath.atan2(2.0f * x * w - 2.0f * y * z, -sqx + sqy - sqz + sqw);
		}

		return dest;
	}

	/**
	 * Takes the rotation from the given matrix.
	 *
	 * @param mat Rotation matrix.
	 * @return This quaternion.
	 */
	public Quaternion fromRotationMatrix(Matrix3f mat) {
		return fromRotationMatrix(mat.m00, mat.m01, mat.m02, mat.m10, mat.m11, mat.m12, mat.m20, mat.m21, mat.m22);
	}

	/**
	 * Takes the rotation from the given matrix.
	 *
	 * @param m00 M00.
	 * @param m01 M01.
	 * @param m02 M02.
	 * @param m10 M10.
	 * @param m11 M11.
	 * @param m12 M12.
	 * @param m20 M20.
	 * @param m21 M21.
	 * @param m22 M22.
	 * @return This quaternion.
	 */
	public Quaternion fromRotationMatrix(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
		float t = m00 + m11 + m22;

		if (t >= 0.0f) {
			float s = FastMath.sqrt(t + 1.0f);
			w = 0.5f * s;
			s = 0.5f / s;
			x = (m21 - m12) * s;
			y = (m02 - m20) * s;
			z = (m10 - m01) * s;
		} else if ((m00 > m11) && (m00 > m22)) {
			float s = FastMath.sqrt(1.0f + m00 - m11 - m22);
			x = s * 0.5f;
			s = 0.5f / s;
			y = (m10 + m01) * s;
			z = (m02 + m20) * s;
			w = (m21 - m12) * s;
		} else if (m11 > m22) {
			float s = FastMath.sqrt(1.0f + m11 - m00 - m22);
			y = s * 0.5f;
			s = 0.5f / s;
			x = (m10 + m01) * s;
			z = (m21 + m12) * s;
			w = (m02 + m20) * s;
		} else {
			float s = FastMath.sqrt(1.0f + m22 - m00 - m11);
			z = s * 0.5f;
			s = 0.5f / s;
			x = (m02 + m20) * s;
			y = (m21 + m12) * s;
			w = (m10 + m01) * s;
		}

		return this;
	}

	/**
	 * Applies this quaternion to a rotation matrix.
	 *
	 * @return Result matrix.
	 */
	public Matrix3f toRotationMatrix() {
		return toRotationMatrix(new Matrix3f());
	}

	/**
	 * Applies this quaternion to a rotation matrix. <br/>If the
	 * <code>dest</code> matrix is null, a new one will be generated.
	 *
	 * @param dest Destination matrix.
	 * @return Destination matrix.
	 */
	public Matrix3f toRotationMatrix(Matrix3f dest) {
		if (dest == null) {
			dest = new Matrix3f();
		}

		float length = lengthSquared();

		float s = (length == 1.0f) ? 2.0f : (length > 0.0f) ? 2.0f / length : 0.0f;

		float xs = x * s;
		float ys = y * s;
		float zs = z * s;

		float xx = x * xs;
		float xy = x * ys;
		float xz = x * zs;

		float xw = w * xs;
		float yy = y * ys;
		float yz = y * zs;
		float yw = w * ys;
		float zz = z * zs;
		float zw = w * zs;

		dest.m00 = 1.0f - (yy + zz);
		dest.m01 = xy - zw;
		dest.m02 = xz + yw;

		dest.m10 = xy + zw;
		dest.m11 = 1.0f - (xx + zz);
		dest.m12 = yz - xw;

		dest.m20 = xz - yw;
		dest.m21 = yz + xw;
		dest.m22 = 1.0f - (xx + yy);

		return dest;
	}

	/**
	 * Applies this quaternion to a rotation matrix. <br/>If the
	 * <code>dest</code> matrix is null, a new one will be generated.
	 *
	 * @param dest Destination matrix.
	 * @return Destination matrix.
	 */
	public Matrix4f toRotationMatrix(Matrix4f dest) {
		if (dest == null) {
			dest = new Matrix4f();
		}

		float length = lengthSquared();

		float s = (length == 1.0f) ? 2.0f : (length > 0.0f) ? 2.0f / length : 0.0f;

		float xs = x * s;
		float ys = y * s;
		float zs = z * s;

		float xx = x * xs;
		float xy = x * ys;
		float xz = x * zs;

		float xw = w * xs;
		float yy = y * ys;
		float yz = y * zs;
		float yw = w * ys;
		float zz = z * zs;
		float zw = w * zs;

		dest.m00 = 1.0f - (yy + zz);
		dest.m01 = xy - zw;
		dest.m02 = xz + yw;

		dest.m10 = xy + zw;
		dest.m11 = 1.0f - (xx + zz);
		dest.m12 = yz - xw;

		dest.m20 = xz - yw;
		dest.m21 = yz + xw;
		dest.m22 = 1.0f - (xx + yy);

		return dest;
	}

	/**
	 * Returns one of three columns specified by the index parameter.
	 *
	 * @param i The column to retrieve. Must be betweem 0 and 2.
	 * @return The column.
	 */
	public Vector3f getRotationColumn(int i) {
		return getRotationColumn(i, null);
	}

	/**
	 * Returns one of three columns specified by the index parameter.
	 *
	 * @param i The column to retrieve. Must be betweem 0 and 2.
	 * @param dest The destination.
	 * @return The column.
	 */
	public Vector3f getRotationColumn(int i, Vector3f dest) {
		if (dest == null) {
			dest = new Vector3f();
		}

		float length = lengthSquared();
		if (length != 1.0f) {
			length = 1.0f / FastMath.sqrt(length);
		}

		float xx = x * x * length;
		float xy = x * y * length;
		float xz = x * z * length;
		float xw = x * w * length;
		float yy = y * y * length;
		float yz = y * z * length;
		float yw = y * w * length;
		float zz = z * z * length;
		float zw = z * w * length;

		switch (i) {
			case 0:
				dest.x = 1.0f - 2.0f * (yy + zz);
				dest.y = 2.0f * (xy + zw);
				dest.z = 2.0f * (xz - yw);
				break;
			case 1:
				dest.x = 2.0f * (xy - zw);
				dest.y = 1.0f - 2.0f * (xx + zz);
				dest.z = 2.0f * (yz + xw);
				break;
			case 2:
				dest.x = 2.0f * (xz + yw);
				dest.y = 2.0f * (yz - xw);
				dest.z = 1.0f - 2.0f * (xx + yy);
				break;
			default:
				throw new IllegalArgumentException("Invalid column index: " + i);
		}

		return dest;
	}

	/**
	 * Sets the quaternion to the values specified by an angle and an axis of
	 * rotation.
	 *
	 * @param angle Rotation angle (in radians).
	 * @param axis Axis of rotation.
	 * @return This quaternion.
	 */
	public Quaternion fromAngleAxis(float angle, Vector3f axis) {
		return fromAngleNormalAxis(angle, axis.normalize());
	}

	/**
	 * Sets the quaternion to the values specified by an angle and an axis of
	 * rotation.
	 *
	 * @param angle Rotation angle (in radians).
	 * @param axis Axis of rotation (already normalized).
	 * @return This quaternion.
	 */
	public Quaternion fromAngleNormalAxis(float angle, Vector3f axis) {
		if (axis.x == 0.0f && axis.y == 0.0f && axis.z == 0.0f) {
			identity();
		} else {
			float halfAngle = 0.5f * angle;
			float sin = (float) FastMath.sin(halfAngle);

			w = (float) FastMath.cos(halfAngle);
			x = sin * axis.x;
			y = sin * axis.y;
			z = sin * axis.z;
		}
		return this;
	}

	/**
	 * Sets the given angle and axis to that represented by the current
	 * quaternion.
	 *
	 * @param axisStore Computed axis store.
	 * @return The angle of rotation in radians.
	 */
	public float toAngleAxis(Vector3f axisStore) {
		float sqrLength = x * x + y * y + z * z;
		float angle;

		if (sqrLength == 0.0f) {
			angle = 0.0f;
			if (axisStore != null) {
				axisStore.x = 1.0f;
				axisStore.y = 0.0f;
				axisStore.z = 0.0f;
			}
		} else {
			angle = 2.0f * (float) FastMath.acos(w);
			if (axisStore != null) {
				float invLength = 1.0f / FastMath.sqrt(sqrLength);
				axisStore.x = x * invLength;
				axisStore.y = y * invLength;
				axisStore.z = z * invLength;
			}
		}

		return angle;
	}

	/**
	 * Sets this quaternion to the given axes.
	 *
	 * @param xAxis X axis.
	 * @param yAxis Y axis.
	 * @param zAxis Z axis.
	 * @return This quaternion.
	 */
	public Quaternion fromAxes(Vector3f xAxis, Vector3f yAxis, Vector3f zAxis) {
		return fromRotationMatrix(xAxis.x, yAxis.x, zAxis.x, xAxis.y, yAxis.y, zAxis.y, xAxis.z, yAxis.z, zAxis.z);
	}

	/**
	 * Stores the rotation axes to the given axes.
	 *
	 * @param axes Destination.
	 */
	public void toAxes(Vector3f[] axes) {
		Matrix3f tempMat = toRotationMatrix();
		axes[0] = new Vector3f(tempMat.getColumn(0)[0], tempMat.getColumn(0)[1], tempMat.getColumn(0)[2]);
		axes[1] = new Vector3f(tempMat.getColumn(1)[0], tempMat.getColumn(1)[1], tempMat.getColumn(1)[2]);
		axes[2] = new Vector3f(tempMat.getColumn(2)[0], tempMat.getColumn(2)[1], tempMat.getColumn(2)[2]);
	}

	/**
	 * Interpolates the given quaternion with this quaternion and stores the
	 * result in this quaternion.
	 *
	 * @param q2 Other quaternion.
	 * @param t Amount to interpolate between the two quaternions.
	 * @return This quaternion.
	 */
	public Quaternion slerp(Quaternion q2, float t) {
		return slerp(this, q2, t);
	}

	/**
	 * Interpolates the two given quaternions and stores the result in this
	 * quaternion.
	 *
	 * @param q1 First quaternion.
	 * @param q2 Second quaternion.
	 * @param t Amount to interpolate between the two quaternions.
	 * @return This quaternion.
	 */
	public Quaternion slerp(Quaternion q1, Quaternion q2, float t) {
		if (q1.x == q2.x && q1.y == q2.y && q1.z == q2.z && q1.w == q2.w) {
			return set(q1);
		}

		float result = (q1.x * q2.x) + (q1.y * q2.y) + (q1.z * q2.z) + (q1.w * q2.w);
		if (result < 0.0f) {
			q2.negateLocal();
			result = -result;
		}

		float scale0 = 1.0f - t;
		float scale1 = t;

		if ((1.0f - result) > 0.1f) {
			float theta = (float) FastMath.acos(result);
			float invSinTheta = 1.0f / (float) FastMath.sin(theta);

			scale0 = (float) FastMath.sin((1.0f - t) * theta) * invSinTheta;
			scale1 = (float) FastMath.sin(t * theta) * invSinTheta;
		}

		x = (scale0 * q1.x) + (scale1 * q2.x);
		y = (scale0 * q1.y) + (scale1 * q2.y);
		z = (scale0 * q1.z) + (scale1 * q2.z);
		w = (scale0 * q1.w) + (scale1 * q2.w);

		return this;
	}

	/**
	 * Interpolates the given quaternion with this quaternion and stores the
	 * result in this quaternion and normalizes it.
	 *
	 * @param q2 Other quaternion.
	 * @param t Blend value.
	 * @return This quaternion.
	 */
	public Quaternion nlerp(Quaternion q2, float t) {
		float dot = dot(q2);
		float blend = 1.0f - t;

		if (dot < 0.0f) {
			x = blend * x - t * q2.x;
			y = blend * y - t * q2.y;
			z = blend * z - t * q2.z;
			w = blend * w - t * q2.w;
		} else {
			x = blend * x - t * q2.x;
			y = blend * y - t * q2.y;
			z = blend * z - t * q2.z;
			w = blend * w - t * q2.w;
		}

		return normalizeLocal();
	}

	/**
	 * Adds the given quaternion to this and returns a new one with the result
	 * in it.
	 *
	 * @param quat Other quaternion.
	 * @return New quaternion with the result stored in it.
	 */
	public Quaternion add(Quaternion quat) {
		return new Quaternion(x + quat.x, y + quat.y, z + quat.z, w + quat.w);
	}

	/**
	 * Adds the given vector to this and returns a new one with the result in
	 * it.
	 *
	 * @param vec Vector.
	 * @return New quaternion with the result stored in it.
	 */
	public Quaternion add(Vector3f vec) {
		return new Quaternion(x + vec.x, y + vec.y, z + vec.z, w);
	}

	/**
	 * Adds the given quaternion to this quaternion and returns this.
	 *
	 * @param quat Other quaternion.
	 * @return This quaternion.
	 */
	public Quaternion addLocal(Quaternion quat) {
		x += quat.x;
		y += quat.y;
		z += quat.z;
		w += quat.w;
		return this;
	}

	/**
	 * Adds the given vector to this quaternion and returns this.
	 *
	 * @param vec Vector.
	 * @return This quaternion.
	 */
	public Quaternion addLocal(Vector3f vec) {
		x += vec.x;
		y += vec.y;
		z += vec.z;
		return this;
	}

	/**
	 * Subs the given quaternion to this and returns a new one with the result
	 * in it.
	 *
	 * @param quat Other quaternion.
	 * @return New quaternion with the result stored in it.
	 */
	public Quaternion subtract(Quaternion quat) {
		return new Quaternion(x - quat.x, y - quat.y, z - quat.z, w - quat.w);
	}

	/**
	 * Subs the given quaternion to this quaternion and returns this.
	 *
	 * @param quat Other quaternion.
	 * @return This quaternion.
	 */
	public Quaternion subtractLocal(Quaternion quat) {
		x -= quat.x;
		y -= quat.y;
		z -= quat.z;
		w -= quat.w;
		return this;
	}

	/**
	 * Multiplies the given quaternion by this quaternion.
	 *
	 * @param quat Right quaternion.
	 * @return New destination quaternion.
	 */
	public Quaternion multiplicate(Quaternion quat) {
		Quaternion dest = new Quaternion();
		dest.x = x * quat.w + y * quat.z - z * quat.y + w * quat.x;
		dest.y = -x * quat.z + y * quat.w + z * quat.x + w * quat.y;
		dest.z = x * quat.y - y * quat.x + z * quat.w + w * quat.z;
		dest.w = -x * quat.x - y * quat.y - z * quat.z + w * quat.w;
		return dest;
	}

	/**
	 * Multiplies this quaternion by the given scalar.
	 *
	 * @param scalar Scalar.
	 * @return New quaternion with the result in it.
	 */
	public Quaternion multiplicate(float scalar) {
		return new Quaternion(this).multiplicateLocal(scalar);
	}

	/**
	 * Multiplies the given vector with this quaternion.
	 *
	 * @param vec Right vector.
	 * @return New quaternion with the result stored in it.
	 */
	public Quaternion multiplicate(Vector3f vec) {
		float rx = w * vec.x + y * vec.z - z * vec.y;
		float ry = w * vec.y + z * vec.x - x * vec.z;
		float rz = w * vec.z + x * vec.y - y * vec.x;
		float rw = -x * vec.x - y * vec.y - z * vec.z;
		return new Quaternion(rx, ry, rz, rw);
	}

	/**
	 * Multiplies the given quaternion by this quaternion.
	 *
	 * @param quat Right quaternion.
	 * @return This quaternion.
	 */
	public Quaternion multiplicateLocal(Quaternion quat) {
		return set(Quaternion.this.multiplicate(quat));
	}

	/**
	 * Multiplies this quaternion by the given scalar.
	 *
	 * @param scalar Scalar.
	 * @return This quaternion.
	 */
	public Quaternion multiplicateLocal(float scalar) {
		x *= scalar;
		y *= scalar;
		z *= scalar;
		w *= scalar;
		return this;
	}

	/**
	 * Multiplies the given vector with this quaternion.
	 *
	 * @param vec Right vector.
	 * @return This quaternion with the result stored in it.
	 */
	public Quaternion multiplicateLocal(Vector3f vec) {
		float rx = w * vec.x + y * vec.z - z * vec.y;
		float ry = w * vec.y + z * vec.x - x * vec.z;
		float rz = w * vec.z + x * vec.y - y * vec.x;
		float rw = -x * vec.x - y * vec.y - z * vec.z;
		return set(rx, ry, rz, rw);
	}

	/**
	 * Applies the given rotation matrix to this quaternion and returns the
	 * result, which is stored in this quaternion.
	 *
	 * @param mat Rotation matrix.
	 * @return This quaternion.
	 */
	public Quaternion apply(Matrix3f mat) {
		float oldX = x, oldY = y, oldZ = z, oldW = w;
		fromRotationMatrix(mat);
		float temX = x, temY = y, temZ = z, temW = w;

		x = oldX * temW + oldY * temZ - oldZ * temY + oldW * temX;
		y = -oldX * temZ + oldY * temW + oldZ * temX + oldW * temY;
		z = oldX * temY - oldY * temX + oldZ * temW + oldW * temZ;
		w = -oldX * temX - oldY * temY - oldZ * temZ + oldW * temW;

		return this;
	}

	/**
	 * Calculates the dot product for this and the given quaternion.
	 *
	 * @param quat Other quaternion.
	 * @return Dot product.
	 */
	public float dot(Quaternion quat) {
		return w * quat.w + x * quat.x + y * quat.y + z * quat.z;
	}

	/**
	 * Length of the quaternion.
	 *
	 * @return Length.
	 */
	public float length() {
		return FastMath.sqrt(lengthSquared());
	}

	/**
	 * Squared length of the quaternion.
	 *
	 * @return Squared length.
	 */
	public float lengthSquared() {
		return w * w + x * x + y * y + z * z;
	}

	/**
	 * Normalizes the values of this quaternion and stores the values into a new
	 * one.
	 *
	 * @return New quaternion with normalized values.
	 */
	public Quaternion normalize() {
		float n = 1.0f / FastMath.sqrt(lengthSquared());
		return new Quaternion(x * n, y * n, z * n, w * n);
	}

	/**
	 * Normalizes the quaternion.
	 *
	 * @return This quaternion.
	 */
	public Quaternion normalizeLocal() {
		float n = 1.0f / FastMath.sqrt(lengthSquared());
		w *= n;
		x *= n;
		y *= n;
		z *= n;
		return this;
	}

	/**
	 * Inverses this quaternion and stores the data into a new one.
	 *
	 * @return New quaternion with inversed data.
	 */
	public Quaternion inverse() {
		float length = lengthSquared();
		if (length > 0.0f) {
			float invLength = 1.0f / length;
			return new Quaternion(-x * invLength, -y * invLength, -z * invLength, w * invLength);
		}
		return null;
	}

	/**
	 * Calculates the inverse value for this quaternion.
	 *
	 * @return This quaternion.
	 */
	public Quaternion inverseLocal() {
		float length = lengthSquared();
		if (length > 0.0f) {
			float invLength = 1.0f / length;
			x *= -invLength;
			y *= -invLength;
			z *= -invLength;
			w *= invLength;
		}
		return this;
	}

	/**
	 * Stores the negated values into a new quaternion.
	 *
	 * @return New quaternion with negated values in it.
	 */
	public Quaternion negate() {
		return new Quaternion(-x, -y, -z, -w);
	}

	/**
	 * Negates this quaternion.
	 *
	 * @return This quaternion.
	 */
	public Quaternion negateLocal() {
		return set(-x, -y, -z, -w);
	}

	/**
	 * Rotates the given vector by this quaternion.
	 *
	 * @param vec Vector.
	 * @return This quaternion.
	 */
	public Vector3f rotate(Vector3f vec) {
		Quaternion quat = new Quaternion(this);
		quat.multiplicateLocal(vec);

		Quaternion invRot = inverse();
		quat.multiplicateLocal(invRot);

		return new Vector3f(quat.x, quat.y, quat.z);
	}

	/**
	 * Lets the quaternion look at the given direction.
	 *
	 * @param direction Direction.
	 * @param up Vector which is the up value.
	 */
	public void lookAt(Vector3f direction, Vector3f up) {
		Vector3f vec1 = new Vector3f(direction).normalizeLocal();
		Vector3f vec2 = up.cross(direction).normalizeLocal();
		Vector3f vec3 = direction.cross(vec2).normalizeLocal();

		fromAxes(vec2, vec3, vec1);
	}

	/**
	 * Calculates a quaternion which points in exactly the opposite direction of
	 * this quaternion.
	 *
	 * @return New quaternion.
	 */
	public Quaternion opposite() {
		return opposite(null);
	}

	/**
	 * Calculates a quaternion which points in exactly the opposite direction of
	 * this quaternion.
	 *
	 * @param dest Destination quaternion.
	 * @return New quaternion.
	 */
	public Quaternion opposite(Quaternion dest) {
		if (dest == null) {
			dest = new Quaternion();
		}

		Vector3f axis = new Vector3f();
		float angle = toAngleAxis(axis);
		dest.fromAngleAxis((float) FastMath.PI + angle, axis);
		return dest;
	}

	/**
	 * Calculates a quaternion which points in exactly the opposite direction of
	 * this quaternion.
	 *
	 * @return This quaternion.
	 */
	public Quaternion oppositeLocal() {
		return opposite(this);
	}

	/**
	 * Sets the x value of the quaternion.
	 *
	 * @param x New x value.
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Returns the x value of the quaternion.
	 *
	 * @return X value.
	 */
	public float getX() {
		return x;
	}

	/**
	 * Sets the y value of the quaternion.
	 *
	 * @param y New y value.
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * Returns the y value of the quaternion.
	 *
	 * @return Y value.
	 */
	public float getY() {
		return y;
	}

	/**
	 * Sets the z value of the quaternion.
	 *
	 * @param z New z value.
	 */
	public void setZ(float z) {
		this.z = z;
	}

	/**
	 * Returns the z value of the quaternion.
	 *
	 * @return Z value.
	 */
	public float getZ() {
		return z;
	}

	/**
	 * Sets the w value of the quaternion.
	 *
	 * @param w New w value.
	 */
	public void setW(float w) {
		this.w = w;
	}

	/**
	 * Returns the w value of the quaternion.
	 *
	 * @return W value.
	 */
	public float getW() {
		return w;
	}

	@Override
	public void fromArray(Float... array) {
		x = array[0];
		y = array[1];
		z = array[2];
		w = array[3];
	}

	@Override
	public Float[] toArray() {
		return new Float[]{x, y, z, w};
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Quaternion other = (Quaternion) obj;
		if (Float.floatToIntBits(this.x) != Float.floatToIntBits(other.x)) {
			return false;
		}
		if (Float.floatToIntBits(this.y) != Float.floatToIntBits(other.y)) {
			return false;
		}
		if (Float.floatToIntBits(this.z) != Float.floatToIntBits(other.z)) {
			return false;
		}
		return Float.floatToIntBits(this.w) == Float.floatToIntBits(other.w);
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 89 * hash + Float.floatToIntBits(this.x);
		hash = 89 * hash + Float.floatToIntBits(this.y);
		hash = 89 * hash + Float.floatToIntBits(this.z);
		hash = 89 * hash + Float.floatToIntBits(this.w);
		return hash;
	}

	@Override
	public Quaternion clone() throws CloneNotSupportedException {
		return (Quaternion) super.clone();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Quaternion{");

		result.append(x);
		result.append(", ");
		result.append(y);
		result.append(", ");
		result.append(z);
		result.append(", ");
		result.append(w);
		result.append("}");

		return result.toString();
	}
}
