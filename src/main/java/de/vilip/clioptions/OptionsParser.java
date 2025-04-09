package de.vilip.clioptions;

import java.util.List;
import java.util.Optional;

import org.apache.commons.cli.*;

import de.vilip.discovery.testentities.SingleTest;
import de.vilip.discovery.testentities.TestDirectory;
import de.vilip.discovery.testentities.TestEntity;
import de.vilip.discovery.testentities.TestFile;

public class OptionsParser
{
	private static final List<String> VALID_OPTIONS = List.of(CLIOptions.FILE.getShortOption(), CLIOptions.DIRECTORY.getShortOption(), CLIOptions.TEST.getShortOption());
	private static final Options OPTIONS = OptionsDefinition.initalizeOptions();
	private static final String WRONG_OPTIONS_ERROR = "Wrong options used, please type testify --help for a list of options you have";

	public TestEntity getOptionsValue(String... args)
	{
		try
		{
			Optional<String> optionValue = getOptionValue(args);
			if (optionValue.isPresent())
			{
				return createTestEntity(optionValue.get());
			}
			else
			{
				throw new RuntimeException(WRONG_OPTIONS_ERROR);
			}
		}
		catch (ParseException e)
		{
			throw new RuntimeException(e);
		}
	}

	private Optional<String> getOptionValue(String... args) throws ParseException
	{
		CommandLineParser commandLineParser = new DefaultParser();
		CommandLine commandLine = commandLineParser.parse(OPTIONS, args);
		return getOption(commandLine);
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

	private Optional<String> getOption(CommandLine commandLine)
	{
		return VALID_OPTIONS.stream()
			.filter(commandLine::hasOption)
			.map(commandLine::getOptionValue)
			.findFirst();
	}
}
