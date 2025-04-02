package de.vilip.engine;

public class Testify
{
	public static void main(String... args)
	{
		startEngine(args);
	}

	public static void startEngine(String... args)
	{
		TestifyEngine testifyEngine = TestifyEngine.getInstance();
		testifyEngine.start(args);
	}
}