package de.vilip.clioptions;

import java.util.List;

import org.apache.commons.cli.*;

import de.vilip.discovery.testentities.SingleTest;
import de.vilip.discovery.testentities.TestDirectory;
import de.vilip.discovery.testentities.TestEntity;
import de.vilip.discovery.testentities.TestFile;

public class OptionsParser
{
	private static final List<String> VALID_OPTIONS = List.of(CLIOptions.FILE.getOption().getOpt(), CLIOptions.DIRECTORY.getOption().getOpt(), CLIOptions.TEST.getOption().getOpt());
	private static final Options OPTIONS = OptionsDefinition.initalizeOptions();
	private static final String WRONG_OPTIONS_ERROR = "Wrong options used, please type testify --help for a list of options you have";
	private static final String TOO_MUCH_PARAMETERS_ERROR = "Only one parameter is allowed.";

	public TestEntity parseOptions(String... args)
	{
		try
		{
			return getDedicatedTestEntity(args);
		}
		catch (ParseException e)
		{
			throw new RuntimeException(e);
		}
	}

	private TestEntity getDedicatedTestEntity(String... args) throws ParseException
	{
		CommandLineParser commandLineParser = new DefaultParser();
		CommandLine commandLine = commandLineParser.parse(OPTIONS, args);

		String optionFLag = getPresentOptions(commandLine);
		String optionValue = commandLine.getOptionValue(optionFLag);

		return createTestEntity(optionValue, optionFLag);
	}

	private TestEntity createTestEntity(String optionalValue, String optionalFlag)
	{
		return switch (optionalFlag)
		{
			case "t" -> new SingleTest();
			case "d" -> new TestDirectory();
			case "f" -> new TestFile();
			case null, default -> throw new RuntimeException();
		};
	}

	private String getPresentOptions(CommandLine commandLine)
	{
		List<String> presentOptions = VALID_OPTIONS.stream()
			.filter(commandLine::hasOption)
			.toList();

		checkOptionCorrectness(presentOptions);
		return presentOptions.getFirst();
	}

	private void checkOptionCorrectness(List<String> presentOptions)
	{
		if (presentOptions.isEmpty())
		{
			throw new IllegalArgumentException(WRONG_OPTIONS_ERROR);
		}
		else if (presentOptions.size() > 1)
		{
			throw new IllegalArgumentException(TOO_MUCH_PARAMETERS_ERROR);
		}
	}
}
