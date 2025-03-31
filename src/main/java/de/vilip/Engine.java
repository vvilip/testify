package de.vilip;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import de.vilip.annotations.AnnotationProcessor;
import de.vilip.clioptions.OptionsParser;
import de.vilip.discovery.FileFinder;
import de.vilip.invoker.MethodInvocator;

public class Engine
{
	private static final String BANNER_PATH = "src/main/java/de/vilip/banner.txt";

	public static void main(String... args)
	{
		startEngine(args);
	}

	public static void startEngine(String... testDirPath)
	{
		printBanner();

		OptionsParser optionsParser = new OptionsParser();
		String file = optionsParser.getTestFile(testDirPath);

		FileFinder fileFinder = new FileFinder();
		Class<?> clazz = fileFinder.getTestClass(file);

		AnnotationProcessor annotationProcessor = new AnnotationProcessor();
		List<Method> methods = annotationProcessor.getTestMethods(clazz);

		MethodInvocator methodInvocator = new MethodInvocator();
		methodInvocator.runTestMethods(methods);
	}

	private static void printBanner()
	{
		try
		{
			List<String> lines = Files.readAllLines(Paths.get(BANNER_PATH));
			for (String l : lines)
			{
				System.out.println(l);
			}
		}
		catch (IOException e)
		{
			System.out.println("Testify");
		}
		System.out.println("---------------------------------------------------");
		System.out.println("                Start running tests                ");
		System.out.println("---------------------------------------------------");
	}
}