package de.vilip.discovery;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

import de.vilip.discovery.testentities.TestEntity;

public class FileFinder
{
	public List<Class<?>> getTestClass(TestEntity testEntity, String testDirectory)
	{
		return getClazz(testEntity, testDirectory);
	}

	private List<Class<?>> getClazz(TestEntity testEntity, String testDirectory)
	{
		try (URLClassLoader urlClassLoader = new URLClassLoader(new URL[] { FileUtils.getUrl(testDirectory) }))
		{
			return testEntity.getClasses(urlClassLoader);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}
