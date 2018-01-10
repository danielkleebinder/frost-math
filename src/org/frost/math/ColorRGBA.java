package org.frost.math;

import java.io.Serializable;
import java.util.Random;

/**
 * The <code>ColorRGBA</code> class stores color values in floating point<br/>
 * variables.
 *
 * @author Daniel Kleebinder
 * @since 1.0.0
 */
public class ColorRGBA implements Serializable, Bufferable<Float>, Cloneable {

	/**
	 * Default serial uid.
	 */
	private static final long serialVersionUID = 98765186458754L;

	/**
	 * Black color.<br/>ColorRGBA(0, 0, 0).<br/>
	 * <div style="border: 1px #000 solid;background-color:#000;width:50;height:30;"></div>
	 */
	public static final ColorRGBA BLACK = new ColorRGBA(0.0f, 0.0f, 0.0f, 1.0f);
	/**
	 * White color.<br/>ColorRGBA(1, 1, 1).<br/>
	 * <div style="border: 1px #000 solid;background-color:#FFFFFF;width:50;height:30;"></div>
	 */
	public static final ColorRGBA WHITE = new ColorRGBA(1.0f, 1.0f, 1.0f, 1.0f);
	/**
	 * Dark gray color.<br/>ColorRGBA(.2, .2, .2).<br/>
	 * <div style="border: 1px #000 solid;background-color:#343434;width:50;height:30;"></div>
	 */
	public static final ColorRGBA DARK_GRAY = new ColorRGBA(0.2f, 0.2f, 0.2f, 1.0f);
	/**
	 * Gray color.<br/>ColorRGBA(.5, .5, .5).<br/>
	 * <div style="border: 1px #000 solid;background-color:#888888;width:50;height:30;"></div>
	 */
	public static final ColorRGBA GRAY = new ColorRGBA(0.5f, 0.5f, 0.5f, 1.0f);
	/**
	 * Light gray color.<br/>ColorRGBA(.8, .8, .8).<br/>
	 * <div style="border: 1px #000 solid;background-color:#CACACA;width:50;height:30;"></div>
	 */
	public static final ColorRGBA LIGHT_GRAY = new ColorRGBA(0.8f, 0.8f, 0.8f, 1.0f);
	/**
	 * Red color.<br/>ColorRGBA(1, 0, 0).<br/>
	 * <div style="border: 1px #000 solid;background-color:#FF0000;width:50;height:30;"></div>
	 */
	public static final ColorRGBA RED = new ColorRGBA(1.0f, 0.0f, 0.0f, 1.0f);
	/**
	 * Green color.<br/>ColorRGBA(0, 1, 0).<br/>
	 * <div style="border: 1px #000 solid;background-color:#00FF00;width:50;height:30;"></div>
	 */
	public static final ColorRGBA GREEN = new ColorRGBA(0.0f, 1.0f, 0.0f, 1.0f);
	/**
	 * Blue color.<br/>ColorRGBA(0, 0, 1).<br/>
	 * <div style="border: 1px #000 solid;background-color:#0000FF;width:50;height:30;"></div>
	 */
	public static final ColorRGBA BLUE = new ColorRGBA(0.0f, 0.0f, 1.0f, 1.0f);
	/**
	 * Yellow color.<br/>ColorRGBA(1, 1, 0).<br/>
	 * <div style="border: 1px #000 solid;background-color:#FFFF00;width:50;height:30;"></div>
	 */
	public static final ColorRGBA YELLOW = new ColorRGBA(1.0f, 1.0f, 0.0f, 1.0f);
	/**
	 * Magenta color.<br/>ColorRGBA(1, 0, 1).<br/>
	 * <div style="border: 1px #000 solid;background-color:#FF00FF;width:50;height:30;"></div>
	 */
	public static final ColorRGBA MAGENTA = new ColorRGBA(1.0f, 0.0f, 1.0f, 1.0f);
	/**
	 * Cyan color.<br/>ColorRGBA(0, 1, 1).<br/>
	 * <div style="border: 1px #000 solid;background-color:#00FFFF;width:50;height:30;"></div>
	 */
	public static final ColorRGBA AQUA = new ColorRGBA(0.0f, 1.0f, 1.0f, 1.0f);
	/**
	 * Orange color.<br/>ColorRGBA(.98431, .50980, 0).<br/>
	 * <div style="border: 1px #000 solid;background-color:#FD8A00;width:50;height:30;"></div>
	 */
	public static final ColorRGBA ORANGE = new ColorRGBA(0.98431f, 0.50980f, 0.0f, 1.0f);
	/**
	 * Brown color.<br/>ColorRGBA(.25490, .15686, .1).<br/>
	 * <div style="border: 1px #000 solid;background-color:#412619;width:50;height:30;"></div>
	 */
	public static final ColorRGBA BROWN = new ColorRGBA(0.25490f, 0.15686f, 0.1f, 1.0f);
	/**
	 * Pink color.<br/>ColorRGBA(1, .68, .68).<br/>
	 * <div style="border: 1px #000 solid;background-color:#FFADAD;width:50;height:30;"></div>
	 */
	public static final ColorRGBA PINK = new ColorRGBA(1.0f, 0.68f, 0.68f, 1.0f);
	/**
	 * Gold color.<br/>ColorRGBA(1, .84313, 0).<br/>
	 * <div style="border: 1px #000 solid;background-color:#FFDA00;width:50;height:30;"></div>
	 */
	public static final ColorRGBA GOLD = new ColorRGBA(1.0f, 0.84313f, 0.0f, 1.0f);
	/**
	 * Silver color.<br/>ColorRGBA(.753, .753, .753).<br/>
	 * <div style="border: 1px #000 solid;background-color:#B1B1B1;width:50;height:30;"></div>
	 */
	public static final ColorRGBA SILVER = new ColorRGBA(0.753f, 0.753f, 0.753f, 1.0f);
	/**
	 * Bronze color.<br/>ColorRGBA(.80392, .5, .19607).<br/>
	 * <div style="border: 1px #000 solid;background-color:#BD8834;width:50;height:30;"></div>
	 */
	public static final ColorRGBA BRONZE = new ColorRGBA(0.80392f, 0.5f, 0.19607f, 1.0f);
	/**
	 * Coral color. Coral is a reddish or pinkish shade of
	 * orange.<br/>ColorRGBA(1, .251, .251).<br/>
	 * <div style="border: 1px #000 solid;background-color:#FF4141;width:50;height:30;"></div>
	 */
	public static final ColorRGBA CORAL = new ColorRGBA(1.0f, 0.251f, 0.251f, 1.0f);
	/**
	 * Olive color.<br/>ColorRGBA(.5, .5, 0).<br/>
	 * <div style="border: 1px #000 solid;background-color:#888800;width:50;height:30;"></div>
	 */
	public static final ColorRGBA OLIVE = new ColorRGBA(0.5f, 0.5f, 0.0f, 1.0f);
	/**
	 * A mix out of yellow and green color.<br/>ColorRGBA(.60392, .80392,
	 * .19607).<br/>
	 * <div style="border: 1px #000 solid;background-color:#9ABD34;width:50;height:30;"></div>
	 */
	public static final ColorRGBA YELLOW_GREEN = new ColorRGBA(0.60392f, 0.80392f, 0.19607f, 1.0f);
	/**
	 * An orange color which is pretty much the same color as the sunset
	 * has.<br/>ColorRGBA(.98039, .83921, .64705).<br/>
	 * <div style="border: 1px #000 solid;background-color:#FED9A6;width:50;height:30;"></div>
	 */
	public static final ColorRGBA SUNSET = new ColorRGBA(0.98039f, 0.83921f, 0.64705f, 1.0f);
	/**
	 * A cold light bluish color.
	 * <br/>ColorRGBA(.71764, .87058, .92941).<br/>
	 * <div style="border: 1px #000 solid;background-color:#B7DEED;width:50;height:30;"></div>
	 */
	public static final ColorRGBA FROST = new ColorRGBA(0.71764f, 0.87058f, 0.92941f, 1.0f);
	/**
	 * A greenish jade color.
	 * <br/>ColorRGBA(.135, .2225, .1575).<br/>
	 * <div style="border: 1px #000 solid;background-color:#233828;width:50;height:30;"></div>
	 */
	public static final ColorRGBA JADE = new ColorRGBA(0.135f, 0.2225f, 0.1575f);
	/**
	 * Black with no alpha color.<br/>ColorRGBA(0, 0, 0, 0).<br/>
	 * <div style="border: 1px #000 solid;background-color:rgba(0,0,0,0);width:50;height:30;"></div>
	 */
	public static final ColorRGBA TRANSPARENT = new ColorRGBA(0.0f, 0.0f, 0.0f, 0.0f);

	/**
	 * Red value.
	 */
	public float r;
	/**
	 * Green value.
	 */
	public float g;
	/**
	 * Blue value.
	 */
	public float b;
	/**
	 * Alpha value.
	 */
	public float a;
	/**
	 * If the color is a high dynamic range color or not.
	 */
	private boolean hdr;

	/**
	 * Creates a new <code>ColorRGBA</code> object. This will instantiate the
	 * color as a default color "white", all values set to 1.0f.
	 */
	public ColorRGBA() {
		r = g = b = a = 1.0f;
	}

	/**
	 * Creates a new <code>ColorRGBA</code> object. This will instantiate the
	 * color as a default color "white", all values set to 1.0f.
	 *
	 * @param hdr HDR color or not.
	 */
	public ColorRGBA(boolean hdr) {
		this.hdr = hdr;
		r = g = b = a = 1.0f;
	}

	/**
	 * Creates a new <code>ColorRGBA</code> object with the given parameters.
	 *
	 * @param r The red color component.
	 * @param g The green color component.
	 * @param b The blue color component.
	 */
	public ColorRGBA(float r, float g, float b) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = 1.0f;

		checkColorRange();
	}

	/**
	 * Creates a new <code>ColorRGBA</code> object with the given parameters.
	 *
	 * @param r The red color component.
	 * @param g The green color component.
	 * @param b The blue color component.
	 * @param hdr HDR color or not.
	 */
	public ColorRGBA(float r, float g, float b, boolean hdr) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = 1.0f;
		this.hdr = hdr;

		checkColorRange();
	}

	/**
	 * Creates a new <code>ColorRGBA</code> object with the given parameters.
	 *
	 * @param r The red color component.
	 * @param g The green color component.
	 * @param b The blue color component.
	 * @param a The alpha color component.
	 */
	public ColorRGBA(float r, float g, float b, float a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;

		checkColorRange();
	}

	/**
	 * Creates a new <code>ColorRGBA</code> object with the given parameters.
	 *
	 * @param r The red color component.
	 * @param g The green color component.
	 * @param b The blue color component.
	 * @param a The alpha color component.
	 * @param hdr HDR color or not.
	 */
	public ColorRGBA(float r, float g, float b, float a, boolean hdr) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
		this.hdr = hdr;

		checkColorRange();
	}

	/**
	 * Creates a new <code>ColorRGBA</code> object with the given parameters.
	 *
	 * @param r The red color component.
	 * @param g The green color component.
	 * @param b The blue color component.
	 */
	public ColorRGBA(int r, int g, int b) {
		this.r = r / 255.0f;
		this.g = g / 255.0f;
		this.b = b / 255.0f;
		this.a = 1.0f;

		checkColorRange();
	}

	/**
	 * Creates a new <code>ColorRGBA</code> object with the given parameters.
	 *
	 * @param r The red color component.
	 * @param g The green color component.
	 * @param b The blue color component.
	 * @param hdr HDR color or not.
	 */
	public ColorRGBA(int r, int g, int b, boolean hdr) {
		this.r = r / 255.0f;
		this.g = g / 255.0f;
		this.b = b / 255.0f;
		this.a = 1.0f;
		this.hdr = hdr;

		checkColorRange();
	}

	/**
	 * Creates a new <code>ColorRGBA</code> object with the given parameters.
	 *
	 * @param r The red color component.
	 * @param g The green color component.
	 * @param b The blue color component.
	 * @param a The alpha color component.
	 */
	public ColorRGBA(int r, int g, int b, int a) {
		this.r = r / 255.0f;
		this.g = g / 255.0f;
		this.b = b / 255.0f;
		this.a = a / 255.0f;

		checkColorRange();
	}

	/**
	 * Creates a new <code>ColorRGBA</code> object with the given parameters.
	 *
	 * @param r The red color component.
	 * @param g The green color component.
	 * @param b The blue color component.
	 * @param a The alpha color component.
	 * @param hdr HDR color or not.
	 */
	public ColorRGBA(int r, int g, int b, int a, boolean hdr) {
		this.r = r / 255.0f;
		this.g = g / 255.0f;
		this.b = b / 255.0f;
		this.a = a / 255.0f;
		this.hdr = hdr;

		checkColorRange();
	}

	/**
	 * Creates a new <code>ColorRGBA</code> object with the given color.
	 *
	 * @param color Int ARGB color.
	 */
	public ColorRGBA(int color) {
		a = ((color >> 24) & 0xFF) / 255.0f;
		r = ((color >> 16) & 0xFF) / 255.0f;
		g = ((color >> 8) & 0xFF) / 255.0f;
		b = (color & 0xFF) / 255.0f;

		checkColorRange();
	}

	/**
	 * Creates a new <code>ColorRGBA</code> object with the given color.
	 *
	 * @param color Int ARGB color.
	 * @param hdr HDR color or not.
	 */
	public ColorRGBA(int color, boolean hdr) {
		a = ((color >> 24) & 0xFF) / 255.0f;
		r = ((color >> 16) & 0xFF) / 255.0f;
		g = ((color >> 8) & 0xFF) / 255.0f;
		b = (color & 0xFF) / 255.0f;
		this.hdr = hdr;

		checkColorRange();
	}

	/**
	 * Copy constructor which creates a new <code>ColorRGBA</code> object with
	 * the RGBA value from the given <code>ColorRGBA</code> object.
	 *
	 * @param rgba The <code>ColorRGBA</code> object to copy.
	 */
	public ColorRGBA(ColorRGBA rgba) {
		this.hdr = rgba.hdr;
		this.r = rgba.r;
		this.g = rgba.g;
		this.b = rgba.b;
		this.a = rgba.a;
	}

	/**
	 * Sets the RGBA values to the given ones and returns this object.
	 *
	 * @param r The red color component.
	 * @param g The green color component.
	 * @param b The blue color component.
	 * @param a The alpha color component.
	 * @return This.
	 */
	public ColorRGBA set(float r, float g, float b, float a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;

		checkColorRange();

		return this;
	}

	/**
	 * Sets the RGBA values to the given ones and returns this object.
	 *
	 * @param r The red color component.
	 * @param g The green color component.
	 * @param b The blue color component.
	 * @param a The alpha color component.
	 * @return This.
	 */
	public ColorRGBA set(int r, int g, int b, int a) {
		this.r = r / 255.0f;
		this.g = g / 255.0f;
		this.b = b / 255.0f;
		this.a = a / 255.0f;

		checkColorRange();

		return this;
	}

	/**
	 * Copies the RGBA data from the given object to this one.
	 *
	 * @param rgba The <code>ColorRGBA</code> object to copy.
	 * @return This.
	 */
	public ColorRGBA set(ColorRGBA rgba) {
		if (rgba == null) {
			throw new NullPointerException("ColorRGBA rgba is null!");
		}

		this.r = rgba.r;
		this.g = rgba.g;
		this.b = rgba.b;
		this.a = rgba.a;

		return this;
	}

	/**
	 * Clamps all values between 0.0f and 1.0f.
	 */
	public void clamp() {
		r = FastMath.clamp(r, 0.0f, 1.0f);
		g = FastMath.clamp(g, 0.0f, 1.0f);
		b = FastMath.clamp(b, 0.0f, 1.0f);
		a = FastMath.clamp(a, 0.0f, 1.0f);
	}

	/**
	 * Sets the RGBA values to 1.0f.
	 */
	public void one() {
		r = g = b = a = 1.0f;
	}

	/**
	 * Sets the RGBA values to 0.0f.
	 */
	public void zero() {
		r = g = b = a = 0.0f;
	}

	/**
	 * Sets the RGB values to random values and the alpha value stays the same.
	 */
	public void random() {
		Random rnd = new Random();

		r = rnd.nextFloat();
		g = rnd.nextFloat();
		b = rnd.nextFloat();
	}

	/**
	 * Sets the alpha value to the given one. The value should be between 0.0f
	 * and 1.0f!
	 *
	 * @param a New alpha value.
	 */
	public void setAlpha(float a) {
		this.a = a;
		checkColorRange();
	}

	/**
	 * Sets the alpha value to the given one. The value should be between 0 and
	 * 255!
	 *
	 * @param a New alpha value.
	 */
	public void setAlpha(int a) {
		this.a = a;
		checkColorRange();
	}

	/**
	 * Returns the alpha value. The returned value will be a float between 0.0f
	 * and 1.0f.
	 *
	 * @return Alpha.
	 */
	public float getAlpha() {
		return a;
	}

	/**
	 * Returns the alpha value. The returned value will be a int between 0 and
	 * 255.
	 *
	 * @return Alpha.
	 */
	public int getAlpha255() {
		return (int) FastMath.round(a * 255.0f);
	}

	/**
	 * Sets the red value to the given one. The value should be between 0.0f and
	 * 1.0f!
	 *
	 * @param r New red value.
	 */
	public void setRed(float r) {
		this.r = r;
		checkColorRange();
	}

	/**
	 * Sets the red value to the given one. The value should be between 0 and
	 * 255!
	 *
	 * @param r New red value.
	 */
	public void setRed(int r) {
		this.r = r;
		checkColorRange();
	}

	/**
	 * Returns the red value. The returned value will be a float between 0.0f
	 * and 1.0f.
	 *
	 * @return Red.
	 */
	public float getRed() {
		return r;
	}

	/**
	 * Returns the red value. The returned value will be a int between 0 and
	 * 255.
	 *
	 * @return Red.
	 */
	public int getRed255() {
		return (int) FastMath.round(r * 255.0f);
	}

	/**
	 * Sets the green value to the given one. The value should be between 0.0f
	 * and 1.0f!
	 *
	 * @param g New green value.
	 */
	public void setGreen(float g) {
		this.g = g;
		checkColorRange();
	}

	/**
	 * Sets the green value to the given one. The value should be between 0 and
	 * 255!
	 *
	 * @param g New green value.
	 */
	public void setGreen(int g) {
		this.g = g;
		checkColorRange();
	}

	/**
	 * Returns the green value. The returned value will be a float between 0.0f
	 * and 1.0f.
	 *
	 * @return Green.
	 */
	public float getGreen() {
		return g;
	}

	/**
	 * Returns the green value. The returned value will be a int between 0 and
	 * 255.
	 *
	 * @return Green.
	 */
	public int getGreen255() {
		return (int) FastMath.round(g * 255.0f);
	}

	/**
	 * Sets the blue value to the given one. The value should be between 0.0f
	 * and 1.0f!
	 *
	 * @param b New blue value.
	 */
	public void setBlue(float b) {
		this.b = b;
		checkColorRange();
	}

	/**
	 * Sets the blue value to the given one. The value should be between 0 and
	 * 255!
	 *
	 * @param b New blue value.
	 */
	public void setBlue(int b) {
		this.b = b;
		checkColorRange();
	}

	/**
	 * Returns the blue value. The returned value will be a float between 0.0f
	 * and 1.0f.
	 *
	 * @return Blue.
	 */
	public float getBlue() {
		return b;
	}

	/**
	 * Returns the blue value. The returned value will be a int between 0 and
	 * 255.
	 *
	 * @return Blue.
	 */
	public int getBlue255() {
		return (int) FastMath.round(b * 255.0f);
	}

	/**
	 * Returns if this color uses HDR.
	 *
	 * @return Is HDR or not.
	 */
	public boolean isHDR() {
		return hdr;
	}

	/**
	 * Sets if this color should use HDR color or not.
	 * <br/>
	 * This will cause that the colors can range not only from 0 to 1. With this
	 * modification they will have infinite range!
	 *
	 * @param hdr HDR.
	 */
	public void setHDR(boolean hdr) {
		this.hdr = hdr;
	}

	/**
	 * Multiplies each RGBA of this color by the given RGBA values and returns a
	 * new color object with the result.
	 *
	 * @param rgba The color for the multiplication.
	 * @return The new <code>ColorRGBA</code> object. This * rgba.
	 */
	public ColorRGBA multiplicate(ColorRGBA rgba) {
		return new ColorRGBA(r * rgba.r, g * rgba.g, b * rgba.b, a * rgba.a);
	}

	/**
	 * Multiplies each RGBA of this color by the given RGBA values and returns a
	 * new color object with the result.
	 *
	 * @param r The red value between 0.0f and 1.0f for multiplication of the
	 * color.
	 * @param g The green value between 0.0f and 1.0f for multiplication of the
	 * color.
	 * @param b The blue value between 0.0f and 1.0f for multiplication of the
	 * color.
	 * @param a The alpha value between 0.0f and 1.0f for multiplication of the
	 * color.
	 * @return The new <code>ColorRGBA</code> object. This * rgba.
	 */
	public ColorRGBA multiplicate(float r, float g, float b, float a) {
		return new ColorRGBA(r * this.r, g * this.g, b * this.b, a * this.a);
	}

	/**
	 * Multiplies each RGBA of this color by the given RGBA values and returns
	 * this.
	 *
	 * @param rgba The color for the multiplication.
	 * @return This.
	 */
	public ColorRGBA multiplicateLocal(ColorRGBA rgba) {
		r *= rgba.r;
		g *= rgba.g;
		b *= rgba.b;
		a *= rgba.a;
		return this;
	}

	/**
	 * Multiplies each RGBA of this color by the given RGBA values and returns
	 * this.
	 *
	 * @param r The red value between 0.0f and 1.0f for multiplication of the
	 * color.
	 * @param g The green value between 0.0f and 1.0f for multiplication of the
	 * color.
	 * @param b The blue value between 0.0f and 1.0f for multiplication of the
	 * color.
	 * @param a The alpha value between 0.0f and 1.0f for multiplication of the
	 * color.
	 * @return This.
	 */
	public ColorRGBA multiplicateLocal(float r, float g, float b, float a) {
		this.r *= r;
		this.g *= g;
		this.b *= b;
		this.a *= a;

		checkColorRange();

		return this;
	}

	/**
	 * Divides each RGBA of this color by the given RGBA values and returns a
	 * new color object with the result.
	 *
	 * @param rgba The color for the division.
	 * @return The new <code>ColorRGBA</code> object. This / rgba.
	 */
	public ColorRGBA divide(ColorRGBA rgba) {
		return new ColorRGBA(r / rgba.r, g / rgba.g, b / rgba.b, a / rgba.a);
	}

	/**
	 * Divides each RGBA of this color by the given RGBA values and returns a
	 * new color object with the result.
	 *
	 * @param r The red value between 0.0f and 1.0f for division of the color.
	 * @param g The green value between 0.0f and 1.0f for division of the color.
	 * @param b The blue value between 0.0f and 1.0f for division of the color.
	 * @param a The alpha value between 0.0f and 1.0f for division of the color.
	 * @return The new <code>ColorRGBA</code> object. This / rgba.
	 */
	public ColorRGBA divide(float r, float g, float b, float a) {
		return new ColorRGBA(this.r / r, this.g / g, this.b / b, this.a / a);
	}

	/**
	 * Divides each RGBA of this color by the given RGBA values and returns
	 * this. This / rgba.
	 *
	 * @param rgba The color for the division.
	 * @return This.
	 */
	public ColorRGBA divideLocal(ColorRGBA rgba) {
		r /= rgba.r;
		g /= rgba.g;
		b /= rgba.b;
		a /= rgba.a;

		return this;
	}

	/**
	 * Divides each RGBA of this color by the given RGBA values and returns
	 * this. This / rgba.
	 *
	 * @param r The red value between 0.0f and 1.0f for division of the color.
	 * @param g The green value between 0.0f and 1.0f for division of the color.
	 * @param b The blue value between 0.0f and 1.0f for division of the color.
	 * @param a The alpha value between 0.0f and 1.0f for division of the color.
	 * @return This.
	 */
	public ColorRGBA divideLocal(float r, float g, float b, float a) {
		this.r /= r;
		this.g /= g;
		this.b /= b;
		this.a /= a;

		checkColorRange();

		return this;
	}

	/**
	 * Adds each RGBA of this color with the given RGBA values and returns a new
	 * color object with the result.
	 *
	 * @param rgba The color for the addition.
	 * @return The new <code>ColorRGBA</code> object. This + rgba.
	 */
	public ColorRGBA add(ColorRGBA rgba) {
		return new ColorRGBA(r + rgba.r, g + rgba.g, b + rgba.b, a + rgba.a);
	}

	/**
	 * Adds each RGBA of this color with the given RGBA values and returns a new
	 * color object with the result.
	 *
	 * @param r The red value between 0.0f and 1.0f for addition of the color.
	 * @param g The green value between 0.0f and 1.0f for addition of the color.
	 * @param b The blue value between 0.0f and 1.0f for addition of the color.
	 * @param a The alpha value between 0.0f and 1.0f for addition of the color.
	 * @return The new <code>ColorRGBA</code> object. This + rgba.
	 */
	public ColorRGBA add(float r, float g, float b, float a) {
		return new ColorRGBA(r + this.r, g + this.g, b + this.b, a + this.a);
	}

	/**
	 * Adds each RGBA of this color with the given RGBA values and returns this.
	 *
	 * @param rgba The color for the addition.
	 * @return This.
	 */
	public ColorRGBA addLocal(ColorRGBA rgba) {
		r += rgba.r;
		g += rgba.g;
		b += rgba.b;
		a += rgba.a;

		checkColorRange();

		return this;
	}

	/**
	 * Adds each RGBA of this color with the given RGBA values and returns this.
	 *
	 * @param r The red value between 0.0f and 1.0f for addition of the color.
	 * @param g The green value between 0.0f and 1.0f for addition of the color.
	 * @param b The blue value between 0.0f and 1.0f for addition of the color.
	 * @param a The alpha value between 0.0f and 1.0f for addition of the color.
	 * @return This.
	 */
	public ColorRGBA addLocal(float r, float g, float b, float a) {
		this.r += r;
		this.g += g;
		this.b += b;
		this.a += a;

		checkColorRange();

		return this;
	}

	/**
	 * Subtracts each RGBA of this color with the given RGBA values and returns
	 * a new color object with the result.
	 *
	 * @param rgba The color for the subtraction.
	 * @return The new <code>ColorRGBA</code> object. This - rgba.
	 */
	public ColorRGBA subtract(ColorRGBA rgba) {
		return new ColorRGBA(r - rgba.r, g - rgba.g, b - rgba.b, a - rgba.a);
	}

	/**
	 * Subtracts each RGBA of this color with the given RGBA values and returns
	 * a new color object with the result.
	 *
	 * @param r The red value between 0.0f and 1.0f for subtraction of the
	 * color.
	 * @param g The green value between 0.0f and 1.0f for subtraction of the
	 * color.
	 * @param b The blue value between 0.0f and 1.0f for subtraction of the
	 * color.
	 * @param a The alpha value between 0.0f and 1.0f for subtraction of the
	 * color.
	 * @return The new <code>ColorRGBA</code> object. This - rgba.
	 */
	public ColorRGBA subtract(float r, float g, float b, float a) {
		return new ColorRGBA(this.r - r, this.g - g, this.b - b, this.a - a);
	}

	/**
	 * Subtracts each RGBA of this color with the given RGBA values and returns
	 * this. This - rgba.
	 *
	 * @param rgba The color for the subtraction.
	 * @return This.
	 */
	public ColorRGBA subtractLocal(ColorRGBA rgba) {
		r -= rgba.r;
		g -= rgba.g;
		b -= rgba.b;
		a -= rgba.a;

		checkColorRange();

		return this;
	}

	/**
	 * Subtracts each RGBA of this color with the given RGBA values and returns
	 * this. This - rgba.
	 *
	 * @param r The red value between 0.0f and 1.0f for subtraction of the
	 * color.
	 * @param g The green value between 0.0f and 1.0f for subtraction of the
	 * color.
	 * @param b The blue value between 0.0f and 1.0f for subtraction of the
	 * color.
	 * @param a The alpha value between 0.0f and 1.0f for subtraction of the
	 * color.
	 * @return This.
	 */
	public ColorRGBA subtractLocal(float r, float g, float b, float a) {
		this.r -= r;
		this.g -= g;
		this.b -= b;
		this.a -= a;

		checkColorRange();

		return this;
	}

	/**
	 * Darkens this color and returns a new color object.
	 * <br/>
	 * The color brightness will be minimized by 10 percent.
	 *
	 * @return Darker color.
	 */
	public ColorRGBA darker() {
		return new ColorRGBA(this).darkerLocal();
	}

	/**
	 * Darkens this color.
	 * <br/>
	 * The color brightness will be minimized by 10 percent.
	 *
	 * @return This.
	 */
	public ColorRGBA darkerLocal() {
		r = FastMath.max(r - 0.1f, 0.0f);
		g = FastMath.max(g - 0.1f, 0.0f);
		b = FastMath.max(b - 0.1f, 0.0f);
		return this;
	}

	/**
	 * Brightens this color and returns a new color object.
	 * <br/>
	 * The color brightness will be maximized by 10 percent.
	 *
	 * @return Brighter color.
	 */
	public ColorRGBA brighter() {
		return new ColorRGBA(this).brighterLocal();
	}

	/**
	 * Brightens this color.
	 * <br/>
	 * The color brightness will be maximized by 10 percent.
	 *
	 * @return This.
	 */
	public ColorRGBA brighterLocal() {
		r = FastMath.min(r + 0.1f, 1.0f);
		g = FastMath.min(g + 0.1f, 1.0f);
		b = FastMath.min(b + 0.1f, 1.0f);
		return this;
	}

	/**
	 * Returns this color as converted <code>int</code> value.
	 *
	 * @return ARGB int color.
	 */
	public int asIntARGB() {
		return (((int) (a * 255) & 0xFF) << 24)
				| (((int) (r * 255) & 0xFF) << 16)
				| (((int) (g * 255) & 0xFF) << 8)
				| ((int) (b * 255) & 0xFF);
	}

	/**
	 * Returns this color as converted <code>int</code> value.
	 *
	 * @return RGBA int color.
	 */
	public int asIntRGBA() {
		return (((int) (r * 255) & 0xFF) << 24)
				| (((int) (g * 255) & 0xFF) << 16)
				| (((int) (b * 255) & 0xFF) << 8)
				| ((int) (a * 255) & 0xFF);
	}

	/**
	 * Returns this color as converted <code>int</code> value.
	 *
	 * @return ABGR int color.
	 */
	public int asIntABGR() {
		return (((int) (a * 255) & 0xFF) << 24)
				| (((int) (b * 255) & 0xFF) << 16)
				| (((int) (g * 255) & 0xFF) << 8)
				| ((int) (r * 255) & 0xFF);
	}

	/**
	 * Sets the color to the given one from an int value.
	 *
	 * @param color Int ARGB color.
	 */
	public void fromIntARGB(int color) {
		a = ((color >> 24) & 0xFF) / 255.0f;
		r = ((color >> 16) & 0xFF) / 255.0f;
		g = ((color >> 8) & 0xFF) / 255.0f;
		b = (color & 0xFF) / 255.0f;
	}

	/**
	 * Sets the color to the given one from an int value.
	 *
	 * @param color Int RGBA color.
	 */
	public void fromIntRGBA(int color) {
		r = ((color >> 24) & 0xFF) / 255.0f;
		g = ((color >> 16) & 0xFF) / 255.0f;
		b = ((color >> 8) & 0xFF) / 255.0f;
		a = (color & 0xFF) / 255.0f;
	}

	/**
	 * Sets the color to the given one from an int value.
	 *
	 * @param color Int ABGR color.
	 */
	public void fromIntABGR(int color) {
		a = ((color >> 24) & 0xFF) / 255.0f;
		b = ((color >> 16) & 0xFF) / 255.0f;
		g = ((color >> 8) & 0xFF) / 255.0f;
		r = (color & 0xFF) / 255.0f;
	}

	/**
	 * Interpolates this and a given target color by the given value and returns
	 * a new instance of <code>ColorRGBA</code>. This instance will not be
	 * manipulated.
	 *
	 * @param target Target color.
	 * @param v Interpolation factor.
	 * @return Interpolated color.
	 */
	public ColorRGBA interpolateLinear(ColorRGBA target, float v) {
		return interpolateLinear(this, target, v);
	}

	/**
	 * Interpolates this and a given target color by the given value
	 *
	 * @param target Target color.
	 * @param v Interpolation factor.
	 * @return Interpolated color.
	 */
	public ColorRGBA interpolateLinearLocal(ColorRGBA target, float v) {
		r = FastMath.interpolateLinear(r, target.r, v);
		g = FastMath.interpolateLinear(g, target.g, v);
		b = FastMath.interpolateLinear(b, target.b, v);
		a = FastMath.interpolateLinear(a, target.a, v);
		return this;
	}

	/**
	 * Creates a single int value from the given rgba values.
	 *
	 * @param r Red value.
	 * @param g Green value.
	 * @param b Blue value.
	 * @param a Alpha value.
	 * @return ARGB color value.
	 */
	public static int toIntARGB(int r, int g, int b, int a) {
		return (a << 24) | (r << 16) | (g << 8) | b;
	}

	/**
	 * Creates a single int value from the given rgba values.
	 *
	 * @param r Red value.
	 * @param g Green value.
	 * @param b Blue value.
	 * @param a Alpha value.
	 * @return RGBA color value.
	 */
	public static int toIntRGBA(int r, int g, int b, int a) {
		return (r << 24) | (g << 16) | (b << 8) | a;
	}

	/**
	 * Returns the alpha component of the given ARGB value.
	 *
	 * @param argb ARGB color value.
	 * @return Alpha component.
	 */
	public static int getAlphaARGB(int argb) {
		return (argb >> 24) & 0xFF;
	}

	/**
	 * Returns the red component of the given ARGB value.
	 *
	 * @param argb ARGB color value.
	 * @return Red component.
	 */
	public static int getRedARGB(int argb) {
		return (argb >> 16) & 0xFF;
	}

	/**
	 * Returns the green component of the given ARGB value.
	 *
	 * @param argb ARGB color value.
	 * @return Green component.
	 */
	public static int getGreenARGB(int argb) {
		return (argb >> 8) & 0xFF;
	}

	/**
	 * Returns the blue component of the given ARGB value.
	 *
	 * @param argb ARGB color value.
	 * @return Blue component.
	 */
	public static int getBlueARGB(int argb) {
		return argb & 0xFF;
	}

	/**
	 * Converts the given hex color to a rgba color. The given hex value can
	 * look for example <code>#00FF00</code><br/>
	 * <code>#00FF00FF</code>
	 *
	 * @param hex Hex color.
	 * @return ColorRGBA.
	 */
	public static ColorRGBA toColorRGBA(String hex) {
		int r = Integer.parseInt(hex.substring(0, 2).trim(), 16);
		int g = Integer.parseInt(hex.substring(2, 4).trim(), 16);
		int b = Integer.parseInt(hex.substring(4, 6).trim(), 16);
		int a = 255;
		if (hex.length() > 6) {
			a = Integer.parseInt(hex.substring(6, 8).trim(), 16);
		}
		return new ColorRGBA(r, g, b, a);
	}

	/**
	 * Interpolates between the given colors.
	 *
	 * @param first First.
	 * @param last Last.
	 * @param v Interpolation value.
	 * @return Interpolated color.
	 */
	public static ColorRGBA interpolateLinear(ColorRGBA first, ColorRGBA last, float v) {
		ColorRGBA result = new ColorRGBA(last.isHDR());
		result.r = FastMath.interpolateLinear(first.r, last.r, v);
		result.g = FastMath.interpolateLinear(first.g, last.g, v);
		result.b = FastMath.interpolateLinear(first.b, last.b, v);
		result.a = FastMath.interpolateLinear(first.a, last.a, v);
		return result;
	}

	/**
	 * Checks for the right color ranges and throws an illegal argument<br/>
	 * exception if the color range is wrong!
	 */
	protected final void checkColorRange() {
		if (r < 0.0f) {
			throw new IllegalArgumentException("The red value is lower than 0.0!");
		}
		if (g < 0.0f) {
			throw new IllegalArgumentException("The green value is lower than 0.0!");
		}
		if (b < 0.0f) {
			throw new IllegalArgumentException("The blue value is lower than 0.0!");
		}
		if (a < 0.0f) {
			throw new IllegalArgumentException("The alpha value is lower than 0.0!");
		}

		if (hdr) {
			return;
		}

		if (r > 1.0f) {
			throw new IllegalArgumentException("The red value is greater than 1.0!");
		}
		if (g > 1.0f) {
			throw new IllegalArgumentException("The green value is greater than 1.0!");
		}
		if (b > 1.0f) {
			throw new IllegalArgumentException("The blue value is greater than 1.0!");
		}
		if (a > 1.0f) {
			throw new IllegalArgumentException("The alpha value is greater than 1.0!");
		}
	}

	@Override
	public void fromArray(Float... array) {
		r = array[0];
		g = array[1];
		b = array[2];
		a = array[3];
	}

	@Override
	public Float[] toArray() {
		return new Float[]{r, g, b, a};
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash += asIntARGB();
		hash += (this.hdr ? 1 : 0);
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
		final ColorRGBA other = (ColorRGBA) obj;
		if (asIntARGB() != other.asIntARGB()) {
			return false;
		}
		return this.hdr == other.hdr;
	}

	@Override
	protected ColorRGBA clone() throws CloneNotSupportedException {
		return (ColorRGBA) super.clone();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("ColorRGBA{");
		result.append("R = ").append(r).append(", ");
		result.append("G = ").append(g).append(", ");
		result.append("B = ").append(b).append(", ");
		result.append("A = ").append(a).append(", ");
		result.append("HDR = ").append(hdr);
		result.append("}");
		return result.toString();
	}
}
