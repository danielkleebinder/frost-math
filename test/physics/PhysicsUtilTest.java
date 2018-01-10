package physics;

import org.frost.physics.PhysicsUtil;
import static org.frost.physics.PhysicsUtil.GRAVITY_EARTH;

/**
 * @author Daniel Kleebinder
 */
public class PhysicsUtilTest {

	public static void main(String[] args) {
		System.out.println(PhysicsUtil.dropHeight(GRAVITY_EARTH, PhysicsUtil.dropTime(GRAVITY_EARTH, 100)));
		System.out.println(PhysicsUtil.escapeVelocity(5.972E24, 6471000));
		System.out.println(PhysicsUtil.toMetersPerSecond(36));
		System.out.println(PhysicsUtil.toKilometersPerHour(10));
		System.out.println(PhysicsUtil.toKilometersPerSecond(36));
	}
}
