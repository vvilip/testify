package de.vilip.testingwrapper;

import de.vilip.methods.NotEqualsException;

public class Assert
{
	public static void assertEquals(Object expected, Object actual)
	{
		if (expected.equals(actual))
		{
			System.out.println("Test was successful");
		}
		else
		{
			throw new NotEqualsException("Expected: " + expected + " but was " + actual);
		}
	}
}
