package de.vilip.file;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

import de.vilip.Test;

public class FileFinder
{
	private String path;

	private FileFinder()
	{
		// only accessible through builder
	}

	public static FileFinder build()
	{
		return new FileFinder();
	}

	public FileFinder withPath(String... path)
	{
		this.path = path[0];
		return this;
	}

	public List<? extends Class<?>> findFiles()
	{
		return getClasses(path).stream()
			.filter(this::hasTest)
			.toList();
	}

	private List<? extends Class<?>> getClasses(String path)
	{
		File testDir = new File(path);
		String[] files = testDir.list();
		return Arrays.stream(files)
			.map(this::getClass)
			.filter(this::hasTest)
			.toList();
	}

	private Class<?> getClass(String name)
	{
		try
		{
			return Class.forName(name);
		}
		catch (ClassNotFoundException e)
		{
			return null;
		}
	}

	private boolean hasTest(Class<?> clazz)
	{
		Annotation annotation = Annotation.class.getAnnotation(Test.class);
		return annotation != null;
	}
}
