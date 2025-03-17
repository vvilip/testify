package de.vilip;

import java.lang.reflect.Method;
import java.util.List;

import de.vilip.annotations.AnnotationProcessor;
import de.vilip.files.FileFinder;
import de.vilip.methods.MethodInvocator;
import de.vilip.options.OptionsParser;

public class Engine
{
	public static void main(String... args)
	{
		startEngine(args);
	}

	public static void startEngine(String... testDirPath)
	{
		OptionsParser optionsParser = new OptionsParser();
		String file = optionsParser.getTestFile(testDirPath);

		FileFinder fileFinder = new FileFinder();
		Class<?> clazz = fileFinder.getTestClass(file);

		AnnotationProcessor annotationProcessor = new AnnotationProcessor();
		List<Method> methods = annotationProcessor.getTestMethods(clazz);

		MethodInvocator methodInvocator = new MethodInvocator();
		methodInvocator.runTestMethods(methods);
	}
}