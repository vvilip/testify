package de.vilip.discovery.testentities;

import java.net.URLClassLoader;
import java.util.List;

import de.vilip.discovery.FileUtils;

public class TestFile implements TestEntity
{
	private String path;

	public TestFile(String path)
	{
		this.path = path;
	}

	@Override
	public String getPath()
	{
		return path;
	}

	@Override
	public List<Class<?>> getClasses(URLClassLoader urlClassLoader) throws ClassNotFoundException
	{
		String name = FileUtils.getFileName(path);
		return List.of(urlClassLoader.loadClass(name));
	}
}
