package de.vilip.discovery.testentities;

import java.io.IOException;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.vilip.discovery.FileUtils;

public class TestDirectory implements TestEntity
{
	private String path;

	public TestDirectory(String path)
	{
		this.path = path;
	}

	@Override
	public String getPath()
	{
		return path;
	}

	@Override
	public List<Class<?>> getClasses(URLClassLoader urlClassLoader)
	{
		try (Stream<Path> paths = Files.walk(Paths.get(path)))
		{
			return paths
				.map(p -> {
					try
					{
						return urlClassLoader.loadClass(FileUtils.getFileName(path));
					}
					catch (ClassNotFoundException e)
					{
						throw new RuntimeException(e);
					}
				})
				.collect(Collectors.toList());
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}
