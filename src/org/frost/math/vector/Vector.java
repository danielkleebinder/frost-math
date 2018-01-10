package org.frost.math.vector;

import java.io.Serializable;
import org.frost.math.Bufferable;
import org.frost.math.FastMath;

/**
 * Interface for all types of vectors.
 * <br/>
 * A vector implementation has to implement this interface.
 *
 * @author Daniel Kleebinder
 * @param <E> Generic vector type.
 * @param <D> Data type of the vector.
 * @since 1.0.0
 */
public interface Vector<E extends Vector, D extends Number> extends Bufferable<D>, Serializable, Cloneable {

	/**
	 * Takes the data from the given vector and puts it into this one.
	 *
	 * @param vec Vector.
	 * @return This vector.
	 */
	E set(E vec);

	/**
	 * Adds the given value to the vector.
	 *
	 * @param v Value.
	 * @return New vector.
	 */
	E add(D v);

	/**
	 * Adds the given vector to this vector and returns a new vector which
	 * contains the result values!
	 *
	 * @param vec Vector which should be added.
	 * @return New vector with the added values.
	 */
	E add(E vec);

	/**
	 * Adds the given value to this vector.
	 *
	 * @param v Value.
	 * @return This vector.
	 */
	E addLocal(D v);

	/**
	 * Adds the given vector to this one.
	 *
	 * @param vec Vector.
	 * @return This vector.
	 */
	E addLocal(E vec);

	/**
	 * Subtracts the given value from the vector.
	 *
	 * @param v Value.
	 * @return New vector.
	 */
	E subtract(D v);

	/**
	 * Subtracts the given vector from this one.
	 *
	 * @param vec Vector.
	 * @return New vector.
	 */
	E subtract(E vec);

	/**
	 * Subtracts the given value from this vector.
	 *
	 * @param v Value.
	 * @return This vector.
	 */
	E subtractLocal(D v);

	/**
	 * Subtracts the given vector from this one.
	 *
	 * @param vec Vector.
	 * @return This vector.
	 */
	E subtractLocal(E vec);

	/**
	 * Multiplicates the given value with the vector.
	 *
	 * @param v Value.
	 * @return New vector.
	 */
	E multiplicate(D v);

	/**
	 * Multiplicates this vector by the given one.
	 *
	 * @param vec Vector.
	 * @return New vector.
	 */
	E multiplicate(E vec);

	/**
	 * Multiplicates the given value with this vector.
	 *
	 * @param v Value.
	 * @return This vector.
	 */
	E multiplicateLocal(D v);

	/**
	 * Multiplicates this vector by the given one.
	 *
	 * @param vec Vector.
	 * @return This vector.
	 */
	E multiplicateLocal(E vec);

	/**
	 * Divides this vector by the given value.
	 *
	 * @param v Value.
	 * @return New vector.
	 */
	E divide(D v);

	/**
	 * Divides this vector by the given one.
	 *
	 * @param vec Vector.
	 * @return New vector.
	 */
	E divide(E vec);

	/**
	 * Divides this vector by the given value.
	 *
	 * @param v Value.
	 * @return This vector.
	 */
	E divideLocal(D v);

	/**
	 * Divides this vector by the given one.
	 *
	 * @param vec Vector.
	 * @return This vector.
	 */
	E divideLocal(E vec);

	/**
	 * Calculates the dot product of this vector and the given one.
	 *
	 * @param vec Vector.
	 * @return Dot product.
	 */
	double dot(E vec);

	/**
	 * Calculates the cross product of this vector and the given one.
	 *
	 * @param vec Vector.
	 * @return Cross product.
	 */
	E cross(E vec);

	/**
	 * Calculates the determinant value of this vector and the given one.
	 *
	 * @param vec Vector.
	 * @return The determinant.
	 */
	double determinant(E vec);

	/**
	 * Calculates the absolute value of all components in the vector.
	 *
	 * @return This vector.
	 */
	E abs();

	/**
	 * Clamps the vector (all components) by the given min and max value.
	 *
	 * @param min Min value.
	 * @param max Max value.
	 * @return This vector.
	 */
	default E clamp(D min, D max) {
		clampMin(min);
		clampMax(max);
		return (E) this;
	}

	/**
	 * Clamps all components of the vector which are below the given min value
	 * to the given min value.
	 *
	 * @param min Min value.
	 * @return This vector.
	 */
	E clampMin(D min);

	/**
	 * Clamps all components of the vector which are higher the given max value
	 * to the given max value.
	 *
	 * @param max Max value.
	 * @return This vector.
	 */
	E clampMax(D max);

	/**
	 * Calculates the length of the vector.
	 *
	 * @return Length.
	 */
	D length();

	/**
	 * Calculates the squared length of the vector.
	 *
	 * @return Squared length.
	 */
	D lengthSquared();

	/**
	 * Calculates the distance from this vector to the given one.
	 *
	 * @param vec Vector.
	 * @return Distance.
	 */
	D distance(E vec);

	/**
	 * Calculates the squared distance from this vector to the given one.
	 *
	 * @param vec Vector.
	 * @return Squared distance.
	 */
	D distanceSquared(E vec);

	/**
	 * Negates the values of this vector and writes them into a new one.
	 *
	 * @return New vector.
	 */
	E negate();

	/**
	 * Negates the values of this vector.
	 *
	 * @return This vector.
	 */
	E negateLocal();

	/**
	 * Normalizes the values of this vector and writes them into a new one.
	 *
	 * @return New vector.
	 */
	E normalize();

	/**
	 * Normalizes the values of this vector.
	 *
	 * @return This vector.
	 */
	E normalizeLocal();

	/**
	 * Returns the smallest angle between this vector and the given one.
	 *
	 * @param vec Vector.
	 * @return Smallest angle.
	 */
	default double angleBetween(E vec) {
		return FastMath.acos(dot(vec));
	}

	/**
	 * Sets all values of this vector to zero.
	 *
	 * @return This vector.
	 */
	E zero();

	/**
	 * Sets all values of this vector to one.
	 *
	 * @return This vector.
	 */
	E one();

	/**
	 * Sets all values of this vector to the given value.
	 *
	 * @param v Value.
	 * @return This vector.
	 */
	E fill(D v);

	/**
	 * Calculates the direction from this vector to the given one.
	 *
	 * @param vec Vector.
	 * @return Direction.
	 */
	default E direction(E vec) {
		return (E) subtract(vec).normalizeLocal();
	}

	/**
	 * Sets the max values from this and the given vector and returns a new one.
	 *
	 * @param vec Vector.
	 * @return New vector.
	 */
	E max(E vec);

	/**
	 * Sets the max values from this and the given vector.
	 *
	 * @param vec Vector.
	 * @return This vector.
	 */
	E maxLocal(E vec);

	/**
	 * Sets the min values from this and the given vector and returns a new one.
	 *
	 * @param vec Vector.
	 * @return New vector.
	 */
	E min(E vec);

	/**
	 * Sets the min values from this and the given vector.
	 *
	 * @param vec Vector.
	 * @return This vector.
	 */
	E minLocal(E vec);

	/**
	 * Clamps this vector between the given vector values and returns a new one.
	 *
	 * @param vec1 Vector 1.
	 * @param vec2 Vector 2.
	 * @return New vector.
	 */
	E clamp(E vec1, E vec2);

	/**
	 * Clamps this vector between the given vector values.
	 *
	 * @param vec1 Vector 1.
	 * @param vec2 Vector 2.
	 * @return This vector.
	 */
	E clampLocal(E vec1, E vec2);

	/**
	 * Sets the given value to the given index.
	 *
	 * @param i Index.
	 * @param v Value.
	 * @return This vector.
	 */
	E put(int i, D v);

	/**
	 * Returns the value on the given index position.
	 *
	 * @param i Index.
	 * @return Value.
	 */
	D get(int i);

	/**
	 * Returns if this vector only contains ones.
	 *
	 * @return True if this vector only contains ones, otherwise false.
	 */
	boolean isOne();

	/**
	 * Returns if this vector only contains zeros.
	 *
	 * @return True if this vector only contains zeros, otherwise false.
	 */
	boolean isZero();

	/**
	 * Returns if this vector only consists of the given value.
	 *
	 * @param v Value.
	 * @return True if this vector only contains the given number, otherwise
	 * false.
	 */
	boolean isUnified(D v);

	/**
	 * Returns if this vector only contains NaN (not a number) values.
	 *
	 * @return True if this vector only contains NaN values, otherwise false.
	 */
	boolean isNaNVector();

	/**
	 * Returns if this vector only contains infinity values.
	 *
	 * @return True if this vector only contains infinity values, otherwise
	 * false.
	 */
	boolean isInfiniteVector();

	/**
	 * Checks if this vector is valid.
	 *
	 * @return True if this vector is valid, otherwise false.
	 */
	default boolean isValidVector() {
		return !(isNaNVector() || isInfiniteVector());
	}

	/**
	 * Returns if this vector is a unit vector.
	 *
	 * @return True if this vector is a unit vector, otherwise false.
	 */
	boolean isUnitVector();

	/**
	 * Returns this vector.
	 *
	 * @return This.
	 */
	default E get() {
		return (E) this;
	}
}
