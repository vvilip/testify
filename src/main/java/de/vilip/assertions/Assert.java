package de.vilip.assertions;

import de.vilip.invoker.NotEqualsException;

public class Assert
{
	public static void assertEquals(Object expected, Object actual)
	{
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		System.out.printf("Running test %s%n", methodName);
		if (expected.equals(actual))
		{
			System.out.printf("\u001B[32mTest %s was successful%n\u001B[0m", methodName);
		}
		else
		{
			throw new NotEqualsException("Expected: " + expected + " but was " + actual);
		}
	}
}
