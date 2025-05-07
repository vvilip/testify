package de.vilip.annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AnnotationProcessor
{
	public List<Method> getTestMethods(List<Class<?>> classes)
	{
		List<Method> testMethods = new ArrayList<>();
		for (Class<?> clazz : classes)
		{
			testMethods.addAll(getAnnotatedMethods(clazz));
		}
		return testMethods;
	}

	private List<Method> getAnnotatedMethods(Class<?> testClass)
	{
		return Stream.of(testClass.getMethods())
			.filter(this::hasAnnotation)
			.toList();
	}

	private boolean hasAnnotation(Method method)
	{
		return method.isAnnotationPresent(Test.class);
	}
}
