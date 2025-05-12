package de.vilip.engine;

public class Testify
{
	public static void main(String... args)
	{
		startEngine(System.getProperty("user.dir"), args);
	}

	public static void startEngine(String testDirectory, String... args)
	{
		TestifyEngine testifyEngine = TestifyEngine.getInstance();
		testifyEngine.start(testDirectory, args);
	}
}