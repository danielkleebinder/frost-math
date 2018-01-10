package org.frost.math.matrix;

import org.frost.math.FastMath;
import org.frost.math.geometry.rectangle.Rectangle4i;
import org.frost.math.vector.Vector3d;
import org.frost.math.vector.Vector3f;
import org.frost.math.vector.Vector3i;
import org.frost.math.vector.Vector4d;
import org.frost.math.vector.Vector4f;
import org.frost.math.vector.Vector4i;

/**
 * Contains many utility methods for matrix operations.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class MatrixUtils {

	/**
	 * Adds the right matrix to the left one.
	 *
	 * @param <E> Generic matrix type.
	 * @param <D> Generic matrix data type.
	 * @param left Left matrix.
	 * @param right Right matrix.
	 * @return New matrix containing the result.
	 */
	public static <E extends Matrix, D extends Number> E add(E left, E right) {
		if (left == null) {
			throw new IllegalArgumentException("Left matrix can not be null!");
		}
		if (right == null) {
			throw new IllegalArgumentException("Right matrix can not be null!");
		}
		return (E) left.add(right);
	}

	/**
	 * Subtracts the right matrix from the left matrix.
	 *
	 * @param <E> Generic matrix type.
	 * @param <D> Generic matrix data type.
	 * @param left Left matrix.
	 * @param right Right matrix.
	 * @return New matrix containing the result.
	 */
	public static <E extends Matrix, D extends Number> E subtract(E left, E right) {
		if (left == null) {
			throw new IllegalArgumentException("Left matrix can not be null!");
		}
		if (right == null) {
			throw new IllegalArgumentException("Right matrix can not be null!");
		}
		return (E) left.subtract(right);
	}

	/**
	 * Multiplicates the left matrix with the right matrix.
	 *
	 * @param <E> Generic matrix type.
	 * @param <D> Generic matrix data type.
	 * @param left Left matrix.
	 * @param right Right matrix.
	 * @return New matrix containing the result.
	 */
	public static <E extends Matrix, D extends Number> E multiplicate(E left, E right) {
		if (left == null) {
			throw new IllegalArgumentException("Left matrix can not be null!");
		}
		if (right == null) {
			throw new IllegalArgumentException("Right matrix can not be null!");
		}
		return (E) left.multiplicate(right);
	}

	/**
	 * Divides the left matrix by the right matrix.
	 *
	 * @param <E> Generic matrix type.
	 * @param <D> Generic matrix data type.
	 * @param left Left matrix.
	 * @param right Right matrix.
	 * @return New matrix containing the result.
	 */
	public static <E extends Matrix, D extends Number> E divide(E left, E right) {
		if (left == null) {
			throw new IllegalArgumentException("Left matrix can not be null!");
		}
		if (right == null) {
			throw new IllegalArgumentException("Right matrix can not be null!");
		}
		return (E) left.divide(right);
	}

	/**
	 * Calculates the perspective projection for the given matrix and stores it
	 * local into the given one.
	 *
	 * @param mat Matrix.
	 * @param fov Field of view.
	 * @param aspect Aspect (Calculation: width / height).
	 * @param near Near clipping plane (Should be lower than 1.0).
	 * @param far Far clipping plane (Should be more than 1 000.0).
	 * @return Given matrix transformed.
	 */
	public static Matrix4d perspectiveProjection(Matrix4d mat, double fov, double aspect, double near, double far) {
		double delta = far - near;
		double radians = (fov / 2.0) * (FastMath.PI / 180.0);
		double sine = FastMath.sin(radians);

		if ((delta == 0) || (sine == 0) || (aspect == 0)) {
			return new Matrix4d();
		}

		double contangent = FastMath.cos(radians) / sine;

		mat.identity();

		mat.m00 = contangent / aspect;
		mat.m11 = contangent;
		mat.m22 = -(far + near) / delta;
		mat.m23 = -1.0;
		mat.m32 = -2.0 * near * far / delta;
		mat.m33 = 0.0;

		return mat;
	}

	/**
	 * Calculates the perspective projection for the given matrix and stores it
	 * local into the given one.
	 *
	 * @param mat Matrix.
	 * @param fov Field of view.
	 * @param aspect Aspect (Calculation: width / height).
	 * @param near Near clipping plane (Should be lower than 1.0f).
	 * @param far Far clipping plane (Should be more than 1 000.0f).
	 * @return Given matrix transformed.
	 */
	public static Matrix4f perspectiveProjection(Matrix4f mat, float fov, float aspect, float near, float far) {
		float delta = far - near;
		float radians = (float) ((fov / 2.0f) * (FastMath.PI / 180.0f));
		float sine = FastMath.sin(radians);

		if ((delta == 0) || (sine == 0) || (aspect == 0)) {
			return new Matrix4f();
		}

		float contangent = FastMath.cos(radians) / sine;

		mat.identity();

		mat.m00 = contangent / aspect;
		mat.m11 = contangent;
		mat.m22 = -(far + near) / delta;
		mat.m23 = -1.0f;
		mat.m32 = -2.0f * near * far / delta;
		mat.m33 = 0.0f;

		return mat;
	}

	/**
	 * Calculates the perspective projection for the given matrix and stores it
	 * local into the given one.
	 *
	 * @param mat Matrix.
	 * @param fov Field of view.
	 * @param aspect Aspect (Calculation: width / height).
	 * @param near Near clipping plane (Should be lower than 1).
	 * @param far Far clipping plane (Should be more than 1 000).
	 * @return Given matrix transformed.
	 */
	public static Matrix4i perspectiveProjection(Matrix4i mat, int fov, int aspect, int near, int far) {
		int delta = far - near;
		int radians = (int) ((fov / 2) * (FastMath.PI / 180.0f));
		int sine = (int) FastMath.sin(radians);

		if ((delta == 0) || (sine == 0) || (aspect == 0)) {
			return new Matrix4i();
		}

		int contangent = (int) FastMath.cos(radians) / sine;

		mat.identity();

		mat.m00 = contangent / aspect;
		mat.m11 = contangent;
		mat.m22 = -(far + near) / delta;
		mat.m23 = -1;
		mat.m32 = (int) -2.0f * near * far / delta;
		mat.m33 = 0;

		return mat;
	}

	/**
	 * Calculates the orthogonal projection for the given matrix and stores it
	 * local into the given one.
	 *
	 * @param mat Matrix.
	 * @param left Left.
	 * @param right Right.
	 * @param top Top.
	 * @param bottom Bottom.
	 * @param near Near.
	 * @param far Far.
	 * @return Given matrix transformed.
	 */
	public static Matrix4d orthogonalProjection(Matrix4d mat, double left, double right, double top, double bottom, double near, double far) {
		mat.identity();

		mat.m00 = 2.0 / (right - left);
		mat.m30 = -(right + left) / (right - left);
		mat.m11 = 2.0 / (top - bottom);
		mat.m31 = -(top + bottom) / (top - bottom);
		mat.m22 = -2.0 / (far - near);
		mat.m32 = -(far + near) / (far - near);

		return mat;
	}

	/**
	 * Calculates the orthogonal projection for the given matrix and stores it
	 * local into the given one.
	 *
	 * @param mat Matrix.
	 * @param left Left.
	 * @param right Right.
	 * @param top Top.
	 * @param bottom Bottom.
	 * @param near Near.
	 * @param far Far.
	 * @return Given matrix transformed.
	 */
	public static Matrix4f orthogonalProjection(Matrix4f mat, float left, float right, float top, float bottom, float near, float far) {
		mat.identity();

		mat.m00 = 2.0f / (right - left);
		mat.m30 = -(right + left) / (right - left);
		mat.m11 = 2.0f / (top - bottom);
		mat.m31 = -(top + bottom) / (top - bottom);
		mat.m22 = -2.0f / (far - near);
		mat.m32 = -(far + near) / (far - near);

		return mat;
	}

	/**
	 * Calculates the orthogonal projection for the given matrix and stores it
	 * local into the given one.
	 *
	 * @param mat Matrix.
	 * @param left Left.
	 * @param right Right.
	 * @param top Top.
	 * @param bottom Bottom.
	 * @param near Near.
	 * @param far Far.
	 * @return Given matrix transformed.
	 */
	public static Matrix4i orthogonalProjection(Matrix4i mat, int left, int right, int top, int bottom, int near, int far) {
		mat.identity();

		mat.m00 = 2 / (right - left);
		mat.m30 = -(right + left) / (right - left);
		mat.m11 = 2 / (top - bottom);
		mat.m31 = -(top + bottom) / (top - bottom);
		mat.m22 = -2 / (far - near);
		mat.m32 = -(far + near) / (far - near);

		return mat;
	}

	/**
	 * Calculates a matrix which can be used as transformation matrix to look at
	 * a specific point.
	 *
	 * @param mat Matrix.
	 * @param eye The position of the viewer.
	 * @param center The position of the reference point, to which the viewer
	 * looks.
	 * @param up The direction of the vector, which points to the top (Default:
	 * Vector3f(0, 1, 0)).
	 * @return Given matrix transformed.
	 */
	public static Matrix4d lookAt(Matrix4d mat, Vector3d eye, Vector3d center, Vector3d up) {
		Vector3d f = center.subtract(eye).normalizeLocal();
		Vector3d u = up;
		Vector3d s = f.cross(u).normalizeLocal();

		u = f.cross(s);

		mat.identity();

		mat.m00 = s.x;
		mat.m10 = s.y;
		mat.m20 = s.z;

		mat.m01 = u.x;
		mat.m11 = u.y;
		mat.m21 = u.z;

		mat.m02 = -f.x;
		mat.m12 = -f.y;
		mat.m22 = -f.z;

		mat.m30 = -s.dot(eye);
		mat.m31 = -u.dot(eye);
		mat.m32 = f.dot(eye);

		return mat;
	}

	/**
	 * Calculates a matrix which can be used as transformation matrix to look at
	 * a specific point.
	 *
	 * @param mat Matrix.
	 * @param eye The position of the viewer.
	 * @param center The position of the reference point, to which the viewer
	 * looks.
	 * @param up The direction of the vector, which points to the top (Default:
	 * Vector3f(0, 1, 0)).
	 * @return Given matrix transformed.
	 */
	public static Matrix4f lookAt(Matrix4f mat, Vector3f eye, Vector3f center, Vector3f up) {
		Vector3f f = center.subtract(eye).normalizeLocal();
		Vector3f u = up;
		Vector3f s = f.cross(u).normalizeLocal();

		u = s.cross(f);

		mat.identity();

		mat.m00 = s.x;
		mat.m10 = s.y;
		mat.m20 = s.z;

		mat.m01 = u.x;
		mat.m11 = u.y;
		mat.m21 = u.z;

		mat.m02 = -f.x;
		mat.m12 = -f.y;
		mat.m22 = -f.z;

		mat.m30 = (float) -s.dot(eye);
		mat.m31 = (float) -u.dot(eye);
		mat.m32 = (float) f.dot(eye);

		return mat;
	}

	/**
	 * Calculates a matrix which can be used as transformation matrix to look at
	 * a specific point.
	 *
	 * @param mat Matrix.
	 * @param eye The position of the viewer.
	 * @param center The position of the reference point, to which the viewer
	 * looks.
	 * @param up The direction of the vector, which points to the top (Default:
	 * Vector3f(0, 1, 0)).
	 * @return Given matrix transformed.
	 */
	public static Matrix4i lookAt(Matrix4i mat, Vector3i eye, Vector3i center, Vector3i up) {
		Vector3i f = center.subtract(eye).normalizeLocal();
		Vector3i u = up;
		Vector3i s = f.cross(u).normalizeLocal();

		u = f.cross(s);

		mat.identity();

		mat.m00 = s.x;
		mat.m10 = s.y;
		mat.m20 = s.z;

		mat.m01 = u.x;
		mat.m11 = u.y;
		mat.m21 = u.z;

		mat.m02 = -f.x;
		mat.m12 = -f.y;
		mat.m22 = -f.z;

		mat.m30 = (int) -s.dot(eye);
		mat.m31 = (int) -u.dot(eye);
		mat.m32 = (int) f.dot(eye);

		return mat;
	}

	/**
	 * Projects the given three dimensional coordinates to the two dimensional
	 * viewport.
	 *
	 * @param view View matrix.
	 * @param projection Projection matrix.
	 * @param viewport Viewport dimensions.
	 * @param pos Position.
	 * @return Projected viewport positions.
	 */
	public static Vector3f project(Matrix4f view, Matrix4f projection, Rectangle4i viewport, Vector3f pos) {
		Vector4f in = new Vector4f(pos.x, pos.y, pos.z, 1.0f);
		Vector4f out = new Vector4f();
		Vector3f result = new Vector3f();

		out.x = in.x * view.m00 + in.y * view.m10 + in.z * view.m20 + in.w * view.m30;
		out.y = in.x * view.m01 + in.y * view.m11 + in.z * view.m21 + in.w * view.m31;
		out.z = in.x * view.m02 + in.y * view.m12 + in.z * view.m22 + in.w * view.m32;
		out.w = in.x * view.m03 + in.y * view.m13 + in.z * view.m23 + in.w * view.m33;

		in.x = out.x * projection.m00 + out.y * projection.m10 + out.z * projection.m20 + out.w * projection.m30;
		in.y = out.x * projection.m01 + out.y * projection.m11 + out.z * projection.m21 + out.w * projection.m31;
		in.z = out.x * projection.m02 + out.y * projection.m12 + out.z * projection.m22 + out.w * projection.m32;
		in.w = out.x * projection.m03 + out.y * projection.m13 + out.z * projection.m23 + out.w * projection.m33;

		if (in.w == 0.0f) {
			return new Vector3f(0.0f, 0.0f, 0.0f);
		}

		in.w = (1.0f / in.w) * 0.5f;

		in.x = in.x * in.w + 0.5f;
		in.y = in.y * in.w + 0.5f;
		in.z = in.z * in.w + 0.5f;

		result.x = in.x * (float) viewport.width + viewport.x;
		result.y = in.y * (float) viewport.height + viewport.y;
		result.z = in.z;

		return result;
	}

	/**
	 * Unprojects the given two dimensional coordinates to the three dimensional
	 * scene.
	 *
	 * @param view View matrix.
	 * @param projection Projection matrix.
	 * @param viewport Viewport dimensions.
	 * @param pos Position.
	 * @return Unprojected scene positions.
	 */
	public static Vector3f unproject(Matrix4f view, Matrix4f projection, Rectangle4i viewport, Vector3f pos) {
		Vector4f in = new Vector4f(pos.x, pos.y, pos.z, 1.0f);
		Vector4f out = new Vector4f();

		Matrix4f vp = multiplicate(projection, view).invertLocal();
		if (vp.isZero()) {
			return new Vector3f(0.0f, 0.0f, 0.0f);
		}

		in.x = (in.x - viewport.x) / viewport.width;
		in.y = (in.y - viewport.y) / viewport.height;

		in.x = in.x * 2.0f - 1.0f;
		in.y = in.y * 2.0f - 1.0f;
		in.z = in.z * 2.0f - 1.0f;

		out.x = in.x * vp.m00 + in.y * vp.m10 + in.z * vp.m20 + in.w * vp.m30;
		out.y = in.x * vp.m01 + in.y * vp.m11 + in.z * vp.m21 + in.w * vp.m31;
		out.z = in.x * vp.m02 + in.y * vp.m12 + in.z * vp.m22 + in.w * vp.m32;
		out.w = in.x * vp.m03 + in.y * vp.m13 + in.z * vp.m23 + in.w * vp.m33;

		if (out.w == 0.0f) {
			return new Vector3f(0.0f, 0.0f, 0.0f);
		}

		out.w = 1.0f / out.w;

		return new Vector3f(out.x * out.w, out.y * out.w, out.z * out.w);
	}

	/**
	 * Multiplicates the given vector by the given matrix.
	 *
	 * @param mat Matrix.
	 * @param vec Vector.
	 * @return Result.
	 */
	public static Vector3d multiplicate(Matrix4d mat, Vector3d vec) {
		Vector3d result = new Vector3d();
		result.x = mat.m00 * vec.x + mat.m01 * vec.y + mat.m02 * vec.z + mat.m03;
		result.y = mat.m10 * vec.x + mat.m11 * vec.y + mat.m12 * vec.z + mat.m13;
		result.z = mat.m20 * vec.x + mat.m21 * vec.y + mat.m22 * vec.z + mat.m23;
		return result;
	}

	/**
	 * Multiplicates the given vector by the given matrix.
	 *
	 * @param mat Matrix.
	 * @param vec Vector.
	 * @return Result.
	 */
	public static Vector3f multiplicate(Matrix4f mat, Vector3f vec) {
		Vector3f result = new Vector3f();
		result.x = mat.m00 * vec.x + mat.m01 * vec.y + mat.m02 * vec.z + mat.m03;
		result.y = mat.m10 * vec.x + mat.m11 * vec.y + mat.m12 * vec.z + mat.m13;
		result.z = mat.m20 * vec.x + mat.m21 * vec.y + mat.m22 * vec.z + mat.m23;
		return result;
	}

	/**
	 * Multiplicates the given vector by the given matrix.
	 *
	 * @param mat Matrix.
	 * @param vec Vector.
	 * @return Result.
	 */
	public static Vector3i multiplicate(Matrix4i mat, Vector3i vec) {
		Vector3i result = new Vector3i();
		result.x = mat.m00 * vec.x + mat.m01 * vec.y + mat.m02 * vec.z + mat.m03;
		result.y = mat.m10 * vec.x + mat.m11 * vec.y + mat.m12 * vec.z + mat.m13;
		result.z = mat.m20 * vec.x + mat.m21 * vec.y + mat.m22 * vec.z + mat.m23;
		return result;
	}

	/**
	 * Multiplicates the given vector by the given matrix.
	 *
	 * @param mat Matrix.
	 * @param vec Vector.
	 * @return Result.
	 */
	public static Vector4d multiplicate(Matrix4d mat, Vector4d vec) {
		Vector4d result = new Vector4d();
		result.x = mat.m00 * vec.x + mat.m01 * vec.y + mat.m02 * vec.z + mat.m03 * vec.w;
		result.y = mat.m10 * vec.x + mat.m11 * vec.y + mat.m12 * vec.z + mat.m13 * vec.w;
		result.z = mat.m20 * vec.x + mat.m21 * vec.y + mat.m22 * vec.z + mat.m23 * vec.w;
		result.w = mat.m30 * vec.x + mat.m31 * vec.y + mat.m32 * vec.z + mat.m33 * vec.w;
		return result;
	}

	/**
	 * Multiplicates the given vector by the given matrix.
	 *
	 * @param mat Matrix.
	 * @param vec Vector.
	 * @return Result.
	 */
	public static Vector4f multiplicate(Matrix4f mat, Vector4f vec) {
		Vector4f result = new Vector4f();
		result.x = mat.m00 * vec.x + mat.m01 * vec.y + mat.m02 * vec.z + mat.m03 * vec.w;
		result.y = mat.m10 * vec.x + mat.m11 * vec.y + mat.m12 * vec.z + mat.m13 * vec.w;
		result.z = mat.m20 * vec.x + mat.m21 * vec.y + mat.m22 * vec.z + mat.m23 * vec.w;
		result.w = mat.m30 * vec.x + mat.m31 * vec.y + mat.m32 * vec.z + mat.m33 * vec.w;
		return result;
	}

	/**
	 * Multiplicates the given vector by the given matrix.
	 *
	 * @param mat Matrix.
	 * @param vec Vector.
	 * @return Result.
	 */
	public static Vector4i multiplicate(Matrix4i mat, Vector4i vec) {
		Vector4i result = new Vector4i();
		result.x = mat.m00 * vec.x + mat.m01 * vec.y + mat.m02 * vec.z + mat.m03 * vec.w;
		result.y = mat.m10 * vec.x + mat.m11 * vec.y + mat.m12 * vec.z + mat.m13 * vec.w;
		result.z = mat.m20 * vec.x + mat.m21 * vec.y + mat.m22 * vec.z + mat.m23 * vec.w;
		result.w = mat.m30 * vec.x + mat.m31 * vec.y + mat.m32 * vec.z + mat.m33 * vec.w;
		return result;
	}

	/**
	 * Nobody is allowed to create an instance of this class.
	 */
	private MatrixUtils() {
	}
}
