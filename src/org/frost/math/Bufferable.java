package org.frost.math;

/**
 * All classes which implement this interface will have the ability to get and
 * set data from raw float values.
 * <br/>
 * <b>The following constraint must be given for all bufferable classes</b><br/>
 * <ul>
 * <li>If the result array from the method <code>Bufferable#toArray</code><br/>
 * is passed to the <code>Bufferable#fromArray</code> method, the object<br/>
 * values are not allowed to change!
 * </li>
 * <li>
 * If an array is passed to the <code>Bufferable#fromArray</code> method,<br/>
 * the exact same array must be returned by the
 * <code>Bufferable#toArray</code><br/> method (Not memory wise, but content
 * wise)!
 * </li>
 * </ul>
 *
 * @author Daniel Kleebinder
 * @param <E> Generic number data type.
 * @since 1.0.0
 */
public interface Bufferable<E extends Number> {

	/**
	 * Sets the data from the given array.
	 *
	 * @param array Array.
	 */
	void fromArray(E... array);

	/**
	 * Returns the data in form of an array.
	 *
	 * @return Array.
	 */
	E[] toArray();
}
