package de.vilip.options;

import org.apache.commons.cli.*;

public class OptionsParser
{
	private static final Options OPTIONS = new OptionsDefinition().initalizeOptions();
	private static final String OPTIONS_NAME = "t";
	private static final String ERROR_MESSAGE = "An error occurred while parsing the arguments.";

	public String getTestFile(String... args)
	{
		CommandLineParser commandLineParser = new DefaultParser();
		try
		{
			CommandLine commandLine = commandLineParser.parse(OPTIONS, args);
			return (hasOption(commandLine)) ? getOptionValue(commandLine) : "";
		}
		catch (ParseException e)
		{
			throw new RuntimeException(ERROR_MESSAGE, e);
		}
	}

	private boolean hasOption(CommandLine commandLine)
	{
		return commandLine.hasOption(OPTIONS_NAME);
	}

	private String getOptionValue(CommandLine commandLine)
	{
		return commandLine.getOptionValue(OPTIONS_NAME);
	}
}
