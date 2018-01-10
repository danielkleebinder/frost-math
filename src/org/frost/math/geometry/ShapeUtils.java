package org.frost.math.geometry;

import org.frost.math.FastMath;
import org.frost.math.geometry.circle.Circle;
import org.frost.math.geometry.rectangle.Rectangle;
import org.frost.math.vector.Vector2d;
import org.frost.math.vector.Vector2f;
import org.frost.math.vector.Vector2i;

/**
 * A utility class for two dimensional shapes.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ShapeUtils {

	/**
	 * Checks if the two given shapes intersect.
	 *
	 * @param s1 First shape.
	 * @param s2 Second shape.
	 * @return True if intersection, otherwise false.
	 */
	public static boolean intersects(Shape s1, Shape s2) {
		if (s1 instanceof Rectangle && s2 instanceof Rectangle) {
			return intersects((Rectangle) s1, (Rectangle) s2);
		}
		if (s1 instanceof Rectangle && s2 instanceof Circle) {
			return intersects((Rectangle) s1, (Circle) s2);
		}
		if (s1 instanceof Circle && s2 instanceof Rectangle) {
			return intersects((Rectangle) s2, (Circle) s1);
		}
		if (s1 instanceof Circle && s2 instanceof Circle) {
			return intersects((Circle) s1, (Circle) s2);
		}
		return false;
	}

	/**
	 * Checks if the given rectangles intersect each other.
	 *
	 * @param r1 First rectangle.
	 * @param r2 Second rectangle.
	 * @return True if intersection, otherwise false.
	 */
	public static boolean intersects(Rectangle r1, Rectangle r2) {
		double ax = ((Rectangle) r1).getX().doubleValue();
		double ay = ((Rectangle) r1).getY().doubleValue();
		double aw = ((Rectangle) r1).getWidth().doubleValue();
		double ah = ((Rectangle) r1).getHeight().doubleValue();

		double bx = ((Rectangle) r2).getX().doubleValue();
		double by = ((Rectangle) r2).getY().doubleValue();
		double bw = ((Rectangle) r2).getWidth().doubleValue();
		double bh = ((Rectangle) r2).getHeight().doubleValue();

		return ax < (bx + bw) && (ax + aw) > bx && ay < (by + bh) && (ay + ah) > by;
	}

	/**
	 * Checks if the given circles intersect each other.
	 *
	 * @param c1 First circle.
	 * @param c2 Second circle.
	 * @return True if intersection, otherwise false.
	 */
	public static boolean intersects(Circle c1, Circle c2) {
		double ax = ((Circle) c1).getX().doubleValue();
		double ay = ((Circle) c1).getY().doubleValue();
		double ar = ((Circle) c1).getRadius().doubleValue();

		double bx = ((Circle) c2).getX().doubleValue();
		double by = ((Circle) c2).getY().doubleValue();
		double br = ((Circle) c2).getRadius().doubleValue();

		double dx = ax - bx;
		double dy = ay - by;
		double rr = ar + br;

		return (dx * dx + dy * dy) <= (rr * rr);
	}

	/**
	 * Checks if the given two shapes intersect each other.
	 *
	 * @param r Rectangle.
	 * @param c Circle.
	 * @return True if an intersection happened, otherwise false.
	 */
	public static boolean intersects(Rectangle r, Circle c) {
		double rx = r.getX().doubleValue();
		double ry = r.getY().doubleValue();
		double rw = r.getWidth().doubleValue();
		double rh = r.getHeight().doubleValue();

		rx += rw / 2.0;
		ry += rh / 2.0;

		double cx = c.getX().doubleValue();
		double cy = c.getY().doubleValue();
		double cr = c.getRadius().doubleValue();

		double cdx = FastMath.abs(cx - rx);
		double cdy = FastMath.abs(cy - ry);

		if (cdx > (rw / 2.0 + cr) || cdy > (rh / 2.0 + cr)) {
			return false;
		}

		if (cdx <= (rw / 2.0) || cdy <= (rh / 2.0)) {
			return true;
		}

		double bx = (cdx - rw / 2.0);
		double by = (cdy - rh / 2.0);
		double cdsq = bx * bx + by * by;

		return cdsq <= (cr * cr);
	}

	/**
	 * Checks if the given two shapes contain each other.
	 *
	 * @param s1 First shape.
	 * @param s2 Second shape.
	 * @return True if the first one contains the second one, otherwise false.
	 */
	public static boolean contains(Shape s1, Shape s2) {
		if (s1 instanceof Rectangle && s2 instanceof Rectangle) {
			return contains((Rectangle) s1, (Rectangle) s2);
		}
		if (s1 instanceof Rectangle && s2 instanceof Circle) {
			return contains((Rectangle) s1, (Circle) s2);
		}
		if (s1 instanceof Circle && s2 instanceof Rectangle) {
			return contains((Rectangle) s2, (Circle) s1);
		}
		if (s1 instanceof Circle && s2 instanceof Circle) {
			return contains((Circle) s1, (Circle) s2);
		}
		return false;
	}

	/**
	 * Checks if the first rectangle contains the second one.
	 *
	 * @param r1 First rectangle.
	 * @param r2 Second rectangle.
	 * @return True if the first one contains the second one, otherwise false.
	 */
	public static boolean contains(Rectangle r1, Rectangle r2) {
		double ax = ((Rectangle) r1).getX().doubleValue();
		double ay = ((Rectangle) r1).getY().doubleValue();
		double aw = ((Rectangle) r1).getWidth().doubleValue();
		double ah = ((Rectangle) r1).getHeight().doubleValue();

		double bx = ((Rectangle) r2).getX().doubleValue();
		double by = ((Rectangle) r2).getY().doubleValue();
		double bw = ((Rectangle) r2).getWidth().doubleValue();
		double bh = ((Rectangle) r2).getHeight().doubleValue();

		return ax > bx && ay > by && (ax + aw) < (bx + bw) && (ay + ah) < (by + bh);
	}

	/**
	 * Checks if the first circle contains the second one.
	 *
	 * @param c1 First circle.
	 * @param c2 Second circle.
	 * @return True if the first one contains the second one, otherwise false.
	 */
	public static boolean contains(Circle c1, Circle c2) {
		double ax = ((Circle) c1).getX().doubleValue();
		double ay = ((Circle) c1).getY().doubleValue();
		double ar = ((Circle) c1).getRadius().doubleValue();

		double bx = ((Circle) c2).getX().doubleValue();
		double by = ((Circle) c2).getY().doubleValue();
		double br = ((Circle) c2).getRadius().doubleValue();

		if (br > ar) {
			return false;
		}

		double dx = ax - bx;
		double dy = ay - by;
		double rr = ar - br;

		return (dx * dx + dy * dy) <= (rr * rr);
	}

	/**
	 * Checks if the rectangle contains the given circle.
	 *
	 * @param r Rectangle.
	 * @param c Circle.
	 * @return True if the rectangle contains the circle.
	 */
	public static boolean contains(Rectangle r, Circle c) {
		double ax = ((Rectangle) r).getX().doubleValue();
		double ay = ((Rectangle) r).getY().doubleValue();
		double aw = ((Rectangle) r).getWidth().doubleValue();
		double ah = ((Rectangle) r).getHeight().doubleValue();

		double bx = ((Circle) c).getX().doubleValue();
		double by = ((Circle) c).getY().doubleValue();
		double br = ((Circle) c).getRadius().doubleValue();

		return ax < bx + br && (ax + aw) > bx && ay < (by + br) && (ay + ah) > by;
	}

	/**
	 * Checks if the given shape contains the given point.
	 *
	 * @param s Shape.
	 * @param p Point.
	 * @return True if contained, otherwise false.
	 */
	public static boolean contains(Shape s, Vector2i p) {
		return contains(s, p.x, p.y);
	}

	/**
	 * Checks if the given shape contains the given point.
	 *
	 * @param s Shape.
	 * @param p Point.
	 * @return True if contained, otherwise false.
	 */
	public static boolean contains(Shape s, Vector2f p) {
		return contains(s, p.x, p.y);
	}

	/**
	 * Checks if the given shape contains the given point.
	 *
	 * @param s Shape.
	 * @param p Point.
	 * @return True if contained, otherwise false.
	 */
	public static boolean contains(Shape s, Vector2d p) {
		return contains(s, p.x, p.y);
	}

	/**
	 * Checks if the given shape contains the given point.
	 *
	 * @param s Shape.
	 * @param x X position of the point.
	 * @param y Y position of the point.
	 * @return True if contained, otherwise false.
	 */
	public static boolean contains(Shape s, double x, double y) {
		if (s instanceof Circle) {
			return contains((Circle) s, x, y);
		}
		if (s instanceof Circle) {
			return contains((Rectangle) s, x, y);
		}
		return false;
	}

	/**
	 * Checks if the given rectangle contains the given point.
	 *
	 * @param r Rectangle.
	 * @param x X position of the point.
	 * @param y Y position of the point.
	 * @return True if contained, otherwise false.
	 */
	public static boolean contains(Rectangle r, double x, double y) {
		double ax = ((Rectangle) r).getX().doubleValue();
		double ay = ((Rectangle) r).getY().doubleValue();
		double aw = ((Rectangle) r).getWidth().doubleValue();
		double ah = ((Rectangle) r).getHeight().doubleValue();

		return ax < x && ay < y && (ax + aw) > x && (ay + ah) > y;
	}

	/**
	 * Checks if the given circle contains the given point.
	 *
	 * @param c Circle.
	 * @param x X position of the point.
	 * @param y Y position of the point.
	 * @return True if contained, otherwise false.
	 */
	public static boolean contains(Circle c, double x, double y) {
		double ax = ((Circle) c).getX().doubleValue();
		double ay = ((Circle) c).getY().doubleValue();
		double ar = ((Circle) c).getRadius().doubleValue();

		double dx = ax - x;
		double dy = ay - y;
		double rr = ar * ar;

		return (dx * dx + dy * dy) <= rr;
	}
}
