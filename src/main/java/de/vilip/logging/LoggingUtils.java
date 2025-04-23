package de.vilip.logging;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.jboss.logging.Logger;

public class LoggingUtils
{
	private static final String BANNER_PATH = "banner.txt";
	private static final Logger LOG = Logger.getLogger(LoggingUtils.class);

	public static void printBanner()
	{
		try
		{
			List<String> lines = Files.readAllLines(Paths.get(BANNER_PATH));
			for (String l : lines)
			{
				LOG.info(l);
			}
		}
		catch (IOException e)
		{
			LOG.info("Testify");
		}
		LOG.info("---------------------------------------------------");
		LOG.info("                Start running tests                ");
		LOG.info("---------------------------------------------------");
	}
}
