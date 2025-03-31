package de.vilip.invoker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MethodInvocator
{
	public void runTestMethods(List<Method> methods)
	{
		for (Method m : methods)
		{
			runMethod(m);
		}
	}

	private void runMethod(Method method)
	{
		Class<?> clazz = method.getDeclaringClass();
		try
		{
			method.invoke(clazz.getDeclaredConstructor().newInstance());
		}
		catch (NoSuchMethodException | InstantiationException | IllegalAccessException e)
		{
			throw new RuntimeException(e);
		}
		catch (InvocationTargetException e)
		{
			throw new NotEqualsException(e.getTargetException().getMessage());
		}
	}
}
