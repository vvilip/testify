package de.vilip.annotations;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Stream;

public class AnnotationProcessor
{
	public List<Method> getTestMethods(Class<?> clazz)
	{
		return Stream.of(clazz.getMethods())
			.filter(this::hasAnnotation)
			.toList();
	}

	private boolean hasAnnotation(Method method)
	{
		return method.isAnnotationPresent(Test.class);
	}
}
