package org.frost.math;

import java.io.Serializable;
import java.util.Objects;
import org.frost.math.vector.Vector3f;

/**
 * A tranform object just encapsulates a quaternion for the rotation and two
 * vectors, one for translation and one for scale.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class Transform implements Cloneable, Serializable {

	/**
	 * Default serial UID.
	 */
	private static final long serialVersionUID = 987619645185476L;

	/**
	 * Identity transformation.
	 * <ul>
	 * <li>Translation ... Vector3f(0, 0, 0)</li>
	 * <li>Rotation ... Quaternion(0, 0, 0, 1)</li>
	 * <li>Scale ... Vector3f(1, 1, 1)</li>
	 * </ul>
	 */
	public static final Transform IDENTITY = new Transform(Vector3f.ZERO, Quaternion.IDENTITY, Vector3f.UNIT_XYZ);

	/**
	 * Rotation.
	 */
	private Quaternion rotation = new Quaternion();
	/**
	 * Translation.
	 */
	private Vector3f translation = new Vector3f();
	/**
	 * Scale.
	 */
	private Vector3f scale = new Vector3f();

	/**
	 * Creates a new transform object.
	 * <ul>
	 * <li>Translation ... Vector3f(0, 0, 0)</li>
	 * <li>Rotation ... Quaternion(0, 0, 0, 1)</li>
	 * <li>Scale ... Vector3f(1, 1, 1)</li>
	 * </ul>
	 */
	public Transform() {
		this(Vector3f.ZERO, Quaternion.IDENTITY);
	}

	/**
	 * Creates a new transform object.
	 * <ul>
	 * <li>Translation ... translation</li>
	 * <li>Rotation ... Quaternion(0, 0, 0, 1)</li>
	 * <li>Scale ... Vector3f(1, 1, 1)</li>
	 * </ul>
	 *
	 * @param translation Translation.
	 */
	public Transform(Vector3f translation) {
		this(translation, Quaternion.IDENTITY);
	}

	/**
	 * Creates a new transform object.
	 * <ul>
	 * <li>Translation ... Vector3f(0, 0, 0)</li>
	 * <li>Rotation ... rotation</li>
	 * <li>Scale ... Vector3f(1, 1, 1)</li>
	 * </ul>
	 *
	 * @param rotation Rotation.
	 */
	public Transform(Quaternion rotation) {
		this(Vector3f.ZERO, rotation);
	}

	/**
	 * Creates a new transform object.
	 * <ul>
	 * <li>Translation ... translation</li>
	 * <li>Rotation ... rotation</li>
	 * <li>Scale ... Vector3f(1, 1, 1)</li>
	 * </ul>
	 *
	 * @param translation Translation.
	 * @param rotation Rotation.
	 */
	public Transform(Vector3f translation, Quaternion rotation) {
		this(translation, rotation, Vector3f.UNIT_XYZ);
	}

	/**
	 * Creates a new transform object with the given values.
	 *
	 * @param translation Translation.
	 * @param rotation Rotation.
	 * @param scale Scale.
	 */
	public Transform(Vector3f translation, Quaternion rotation, Vector3f scale) {
		this.translation = translation;
		this.rotation = rotation;
		this.scale = scale;
	}

	/**
	 * Sets the values of this transform to the given once.
	 *
	 * @param transform Transform.
	 */
	public void set(Transform transform) {
		translation.set(transform.translation);
		rotation.set(transform.rotation);
		scale.set(transform.scale);
	}

	/**
	 * Sets the rotation of this transform.
	 *
	 * @param rotation Rotation.
	 */
	public void setRotation(Quaternion rotation) {
		this.rotation = rotation;
	}

	/**
	 * Returns the rotation of this rotation.
	 *
	 * @return Rotation.
	 */
	public Quaternion getRotation() {
		return rotation;
	}

	/**
	 * Sets the translation of this transform.
	 *
	 * @param translation Translation.
	 */
	public void setTranslation(Vector3f translation) {
		this.translation = translation;
	}

	/**
	 * Returns the translation of this transform.
	 *
	 * @return Translation.
	 */
	public Vector3f getTranslation() {
		return translation;
	}

	/**
	 * Sets the scale of this transform.
	 *
	 * @param scale Scale.
	 */
	public void setScale(Vector3f scale) {
		this.scale = scale;
	}

	/**
	 * Returns the scale of this transform.
	 *
	 * @return Scale.
	 */
	public Vector3f getScale() {
		return scale;
	}

	/**
	 * Loads the identity values to this transform.
	 * <ul>
	 * <li>Translation ... Vector3f(0, 0, 0)</li>
	 * <li>Rotation ... Quaternion(0, 0, 0, 1)</li>
	 * <li>Scale ... Vector3f(1, 1, 1)</li>
	 * </ul>
	 */
	public void identity() {
		translation.set(0, 0, 0);
		rotation.set(0, 0, 0, 1);
		scale.set(1, 1, 1);
	}

	/**
	 * Changes the values of this transform acording to it's parent.
	 *
	 * @param parent Parent transform.
	 * @return This.
	 */
	public Transform combine(Transform parent) {
		scale.multiplicateLocal(parent.scale);
		rotation = parent.rotation.multiplicate(rotation);

		translation.multiplicateLocal(parent.scale);
		parent.rotation.multiplicateLocal(translation).addLocal(translation);

		return this;
	}

	/**
	 * Transforms the given vector using this transformation.
	 *
	 * @param vec Vector which should be transformed.
	 * @param store Storage (if null, a new vector will be created!).
	 * @return Storage vector.
	 */
	public Vector3f transform(final Vector3f vec, Vector3f store) {
		if (store == null) {
			store = new Vector3f();
		}

		Quaternion result = rotation.multiplicate(store.set(vec).multiplicateLocal(scale)).addLocal(translation);
		return store.set(result.x, result.y, result.z);
	}

	/**
	 * Transforms the given vector inversed using this transformation.
	 *
	 * @param vec Vector which should be transformed inverse.
	 * @param store Storage (if null, a new vector will be created!).
	 * @return Storage vector.
	 */
	public Vector3f transformInverse(final Vector3f vec, Vector3f store) {
		store = vec.subtract(translation).divideLocal(scale);
		Quaternion result = rotation.inverse().multiplicate(store);
		return store.set(result.x, result.y, result.z);
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 59 * hash + Objects.hashCode(this.rotation);
		hash = 59 * hash + Objects.hashCode(this.translation);
		hash = 59 * hash + Objects.hashCode(this.scale);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Transform other = (Transform) obj;
		if (!Objects.equals(this.rotation, other.rotation)) {
			return false;
		}
		if (!Objects.equals(this.translation, other.translation)) {
			return false;
		}
		return Objects.equals(this.scale, other.scale);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Transform{");

		result.append(translation);
		result.append("\n");
		result.append(rotation);
		result.append("\n");
		result.append(scale);
		result.append("}");

		return result.toString();
	}

	@Override
	public Transform clone() throws CloneNotSupportedException {
		return (Transform) super.clone();
	}
}
