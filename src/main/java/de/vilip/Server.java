package de.vilip;

import java.util.List;

import de.vilip.file.FileFinder;

public class Server
{
	public static void main(String... args)
	{
		startServer(args);
	}

	public static void startServer(String... testDirPath)
	{
		List<? extends Class<?>> classes = FileFinder.build()
			.withPath(testDirPath)
			.findFiles();
		System.out.println(classes);
	}
}