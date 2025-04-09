package de.vilip.clioptions;

import java.util.Optional;

import org.apache.commons.cli.*;

import de.vilip.discovery.testentities.SingleTest;
import de.vilip.discovery.testentities.TestDirectory;
import de.vilip.discovery.testentities.TestEntity;
import de.vilip.discovery.testentities.TestFile;

public class OptionsParser
{
	private static final Options OPTIONS = OptionsDefinition.initalizeOptions();
	private static final String ERROR_MESSAGE = "An error occurred while parsing the arguments.";

	// ToDO: Distinguish between different inputs
	public Optional<String> getOptionsValue(String... args)
	{
		try
		{
			CommandLineParser commandLineParser = new DefaultParser();
			CommandLine commandLine = commandLineParser.parse(OPTIONS, args);
			if (hasOption(commandLine))
			{

			}
			else
			{
				throw new RuntimeException(ERROR_MESSAGE);
			}
		}
		catch (ParseException e)
		{
			throw new RuntimeException(e);
		}
	}

	private TestEntity createTestEntity(String optionalValue)
	{
		return switch (optionalValue)
		{
			case "t" -> new SingleTest();
			case "d" -> new TestDirectory();
			case "f" -> new TestFile();
			case null, default -> throw new RuntimeException();
		};
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
