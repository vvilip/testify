package de.vilip.discovery.testentities;

import java.lang.reflect.Method;

public class SingleTest implements TestEntity
{
	private Class<?> regardingClass;
	private Method testMethod;
	private String name;

	public SingleTest(String name)
	{
		this.name = name;
	}
}
