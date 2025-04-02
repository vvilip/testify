package de.vilip.clioptions;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class OptionsDefinition
{
	public static Options initalizeOptions()
	{
		Option directory = new Option(CLIOptions.DIRECTORY.getShortOption(), true, "A whole test directory");
		Option file = new Option(CLIOptions.FILE.getShortOption(), true, "A single test file");
		Option test = new Option(CLIOptions.TEST.getShortOption(), true, "A single test in a file");
		Options options = new Options();

		return options.addOption(directory)
			.addOption(file)
			.addOption(test);
	}
}
