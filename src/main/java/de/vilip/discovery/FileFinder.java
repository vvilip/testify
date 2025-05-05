package de.vilip.discovery;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

import de.vilip.discovery.testentities.TestEntity;

public class FileFinder
{
	public List<Class<?>> getTestClass(TestEntity testEntity)
	{
		return getClazz(testEntity);
	}

	private List<Class<?>> getClazz(TestEntity testEntity)
	{
		try (URLClassLoader urlClassLoader = new URLClassLoader(new URL[] { FileUtils.getUrl(testEntity.getPath()) }))
		{
			return testEntity.getClasses(urlClassLoader);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}
