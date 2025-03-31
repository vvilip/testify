package de.vilip.discovery;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileFinder
{
	public Class<?> getTestClass(String path)
	{
		return getClazz(path);
	}

	private Class<?> getClazz(String path)
	{
		try (URLClassLoader urlClassLoader = new URLClassLoader(new URL[] { getClassURL(path) }))
		{
			return urlClassLoader.loadClass("de.vilip.testclasses.Hello");
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	private URL getClassURL(String path) throws MalformedURLException
	{
		Path classFilePath = Paths.get(path);
		return classFilePath.getParent().toUri().toURL();
	}
}
