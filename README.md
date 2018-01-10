# FrostEngine - Math Kernel
The standalone math kernel of the Java &amp; OpenGL "FrostEngine". Contains many useful mathematical functions including full matrix and vector support.


## Installation
The installation is, thanks to GitHub, a quiet simple process. Use the clone command to pull the API.
`git clone https://github.com/danielkleebinder/frost-math/`
Afterwards, add the API to any Java project you like.


## Usage
The frost math API provides all kinds of mathematical functions primarily used for graphics processing using OpenGL and DirectX. The most important functionalities are provided by the packages "org.frost.math.matrix" and "org.frost.math.vector".
```java
package matrix;

import org.frost.math.matrix.Matrix4f;

/**
 * @author Daniel Kleebinder
 */
public class MatrixCalculationTest {

	public static void main(String[] args) {
		Matrix4f a = new Matrix4f(
				-2, 4, 1, 3,
				0, 3, 0, 2,
				1, 0, 5, 1,
				4, 1, 7, 1
		);

		Matrix4f b = new Matrix4f(
				-6, 12, 3, 9,
				0, 3, 0, 2,
				1, 0, 5, 1,
				12, 3, 21, 3
		);

		Matrix4f c = new Matrix4f(
				1, 0, 5, 1,
				-2, 4, 1, 3,
				4, 1, 7, 1,
				0, 3, 0, 2
		);

		Matrix4f d = new Matrix4f(
				1, 0, 5, 1,
				0, 4, 11, 5,
				4, 1, 7, 1,
				0, 3, 0, 2
		);

		System.out.println(a.divide(a.invert()));
		System.out.println();
		System.out.println(Matrix4f.IDENTITY.determinant());
		System.out.println();
		System.out.println(a.determinant() + b.determinant());
		System.out.println(a.add(b).determinant());

		System.out.println("----------------");

		System.out.println(a.transpose().add(b.transpose()).determinant());
		System.out.println(b.transpose().add(c.transpose()).determinant());
		System.out.println(c.transpose().add(d.transpose()).determinant());
		System.out.println(d.transpose().add(a.transpose()).determinant());

		System.out.println("----------------");

		System.out.println(a.transpose().determinant());
		System.out.println(b.transpose().determinant());
		System.out.println(c.transpose().determinant());
		System.out.println(d.transpose().determinant());
	}
}

```
