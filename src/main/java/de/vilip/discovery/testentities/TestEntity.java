package de.vilip.discovery.testentities;

import java.net.URLClassLoader;
import java.util.List;

public interface TestEntity
{
	String getPath();

	List<Class<?>> getClasses(URLClassLoader urlClassLoader) throws ClassNotFoundException;
}
