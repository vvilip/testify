package de.vilip.discovery;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils
{
	private static final String JAVA_DIR = "/java/";

	public static String getFileName(String path)
	{
		return JAVA_DIR + path;
	}

	public static List<String> getFileNames(List<String> paths)
	{
		return paths.stream()
			.map(FileUtils::getFileName)
			.collect(Collectors.toList());
	}

	public static URL getUrl(String path) throws MalformedURLException
	{
		Path classFilePath = Paths.get(path);
		return classFilePath.getParent().toUri().toURL();
	}
}
