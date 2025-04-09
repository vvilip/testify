package de.vilip.engine;

import java.lang.reflect.Method;
import java.util.List;

import de.vilip.annotations.AnnotationProcessor;
import de.vilip.clioptions.OptionsParser;
import de.vilip.discovery.FileFinder;
import de.vilip.discovery.testentities.TestEntity;
import de.vilip.invoker.MethodInvocator;
import de.vilip.logging.LoggingUtils;

public class TestifyEngine
{
	private TestifyEngine()
	{
		// Private constructor for singleton pattern
	}

	private static class Holder
	{
		private static final TestifyEngine INSTANCE = new TestifyEngine();
	}

	public static TestifyEngine getInstance()
	{
		return Holder.INSTANCE;
	}

	public void start(String... args)
	{
		LoggingUtils.printBanner();

		OptionsParser optionsParser = new OptionsParser();
		TestEntity testEntity = optionsParser.parseOptions(args);

		FileFinder fileFinder = new FileFinder();
		Class<?> clazz = fileFinder.getTestClass("");

		AnnotationProcessor annotationProcessor = new AnnotationProcessor();
		List<Method> methods = annotationProcessor.getTestMethods(clazz);

		MethodInvocator methodInvocator = new MethodInvocator();
		methodInvocator.runTestMethods(methods);
	}
}
