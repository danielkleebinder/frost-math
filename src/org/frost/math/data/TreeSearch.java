package org.frost.math.data;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Function;

/**
 * An interface which contains typical tree search algorithms.
 *
 * @author Daniel Kleebinder
 * @param <T> Generic data type.
 * @since 1.0.0
 */
public interface TreeSearch<T> {

	/**
	 * Searches the tree breadth first.
	 *
	 * @param foo Function.
	 */
	void searchBreadthFirst(Function<T, Boolean> foo);

	/**
	 * Searches the tree breadth first in post order.
	 *
	 * @param foo Function.
	 */
	default void searchBreadthFirstPostOrder(Function<T, Boolean> foo) {
		Deque<T> stack = new ArrayDeque<>();
		searchBreadthFirst(t -> {
			stack.push(t);
			return false;
		});

		while (!stack.isEmpty()) {
			if (foo.apply(stack.pop())) {
				return;
			}
		}
	}

	/**
	 * Searches the tree depth first.
	 *
	 * @param foo Function.
	 */
	void searchDepthFirst(Function<T, Boolean> foo);

	/**
	 * Searches the tree depth first in post order.
	 *
	 * @param foo Function.
	 */
	void searchDepthFirstPostOrder(Function<T, Boolean> foo);
}
