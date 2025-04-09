package de.vilip.clioptions;

import org.apache.commons.cli.Options;

public class OptionsDefinition
{
	public static Options initalizeOptions()
	{
		return new Options().addOption(CLIOptions.DIRECTORY.getOption())
			.addOption(CLIOptions.FILE.getOption())
			.addOption(CLIOptions.TEST.getOption());
	}
}
