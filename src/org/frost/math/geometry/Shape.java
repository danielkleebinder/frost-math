package org.frost.math.geometry;

import java.io.Serializable;

/**
 * The shape interface is a basic interface for all kind of shapes.
 *
 * @author Daniel Kleebinder
 * @param <E> Generic number type.
 * @since 1.0.0
 */
public interface Shape<E extends Number> extends Serializable {

	/**
	 * Calculates the volume of the shape.
	 *
	 * @return Volume.
	 */
	E volume();

	/**
	 * Calculates the surface of the shape.
	 *
	 * @return Surface size.
	 */
	E surface();
}
