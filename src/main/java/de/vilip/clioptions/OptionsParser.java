package de.vilip.clioptions;

import java.util.Optional;

import org.apache.commons.cli.*;

public class OptionsParser
{
	private static final Options OPTIONS = OptionsDefinition.initalizeOptions();
	private static final String ERROR_MESSAGE = "An error occurred while parsing the arguments.";

	// ToDO: Distinguish between different inputs
	public Optional<String> getOptionsValue(String... args)
	{
		CommandLineParser commandLineParser = new DefaultParser();
		try
		{
			CommandLine commandLine = commandLineParser.parse(OPTIONS, args);
			if (hasOption(commandLine))
			{
				return Optional.of(getOptionValue(commandLine));
			}
			return Optional.empty();
		}
		catch (ParseException e)
		{
			throw new RuntimeException(ERROR_MESSAGE, e);
		}
	}

	private boolean hasOption(CommandLine commandLine)
	{
		return commandLine.hasOption("");
	}

	private String getOptionValue(CommandLine commandLine)
	{
		return commandLine.getOptionValue("");
	}
}
